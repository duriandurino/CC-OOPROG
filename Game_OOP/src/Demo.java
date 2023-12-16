import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Demo extends GameStates{
    Demo(GSM gsm){
        super(gsm);
    }

    ImageIcon bg = new ImageIcon("src\\assets\\bgg.png");
    ImageIcon pus = new ImageIcon("src\\assets\\panel.png");
    Image pusI = pus.getImage();
    Image bgImg = bg.getImage();

    String[] pauseOpt = {"RESUME", "RESET","MAIN MENU"};

    int sel=0;

    int lvl;

    Audio batol, batol2;
    Audio selc, seld;


    Random level = new Random();

    Players p1,p2;
    private Arena map;
    private Lava lava;

    public static boolean paused = false;
    static boolean resumed=false;
    boolean harder = false;
    boolean stop=false;

    static int tap = 0;

    @Override
    void init() {
        p1 = new Players(Color.YELLOW,0);
        p2=new Players(Color.CYAN,1);
        map = new Arena(36,21);
        lava = new Lava(0,650);
        batol = new Audio("src\\assets\\battle1.wav");
        batol2 = new Audio("src\\assets\\battle2.wav");
        selc = new Audio("src\\assets\\sel.wav");
        seld = new Audio("src\\assets\\seld.wav");
        batol2.setVol(0.5f);
        batol.setVol(0.5f);
    }

    @Override
    void tick() {
        if(!batol.clip.isRunning()&&!paused&&!stop&&lvl!=2){//for pause porpossies
            batol.playSfx();
        }
        if(!batol2.clip.isRunning()&&!paused&&!stop&&lvl>1){
            batol.stopSfx();
            batol2.playSfx();
        }

        p1.tick(map.getPlats(), lava, p2);
        p2.tick(map.getPlats(), lava, p1);//ticks obj ticks
        lava.tick();

        payting(p1,p2);
                    //the fuckin game mechanic
        payting(p2,p1);

        if(!paused){
            //ooo lava scary
            if(p1.layp<=3&&p2.layp<=3&&lava.y>(level.nextInt(10)+490)){
                lvl=2;
                upOneLvl();//1
            }else if(p1.layp==1&&p2.layp==1&&lava.y>(level.nextInt(20)+300)){
                upOneLvl();//3
            }else if((p1.layp<=2||p2.layp<=2)&&lava.y>(level.nextInt(50)+450)){
                lvl=2;
                upOneLvl();//2
            }else{
                lava.arise=false;
                harder = false;
            }
        }

        //kung naay di na marebayb
        if(p1.layp<=0||p2.layp<=0){
            endGame();
            gsm.states.push(new GameOver(gsm, playerWin(p1,p2)));
        }

    }

    @Override
    void draw(Graphics g) {
        g.drawImage(bgImg, 0,0, MainPanel.sw, MainPanel.sh, null);
        map.draw(g);
        p1.draw(g);
        p2.draw(g);
        lava.draw(g);
        if(paused){
            pauseMenu(g);
        }
    }

    @Override
    void keyPressed(int k) {
        p1.keyPressed(k);
        p2.keyPressed(k);
        if(k== KeyEvent.VK_P){
            //System.out.println("PAUSED");
            tap+=1;
            resumed=false;
            paused=true;
            batol.stopSfx();
            batol2.stopSfx();
            lava.arise=false;
        }
        if(k== KeyEvent.VK_P&&tap==2){
            resumed();
        }
        if(paused){
            if(k==KeyEvent.VK_UP||k==KeyEvent.VK_W){
                selc.playSfx();
                sel--;
                if(sel<0){
                    sel=pauseOpt.length-1;
                }
            }
            if(k==KeyEvent.VK_DOWN||k==KeyEvent.VK_S){
                selc.playSfx();
                sel++;
                if(sel>=pauseOpt.length){
                    sel=0;
                }
            }

            if(k==KeyEvent.VK_ENTER){
                seld.playSfx();
                switch(sel){
                    case 0:
                        resumed();
                        break;
                    case 1:
                        endGame();
                        gsm.states.push(new Demo(gsm));
                        break;
                    case 2:
                        endGame();
                        gsm.states.push(new Menu(gsm));
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @Override
    void keyReleased(int k) {
        p1.keyReleased(k);
        p2.keyReleased(k);
    }

    @Override
    void keyTyped(char k) {
        p1.keyTyped(k);
        p2.keyTyped(k);
    }

    @Override
    void mouseClicked(int x, int y) {
        if(paused){
            if(x>=490&&x<=650&&y>=250&&y<=290){
                selc.playSfx();
                if(sel==0){
                    seld.playSfx();
                    resumed();
                }
                sel=0;
            }
            if(x>=490&&x<=650&&y>=330&&y<=370){
                selc.playSfx();
                if(sel==1){
                    seld.playSfx();
                    endGame();
                    gsm.states.push(new Demo(gsm));
                }
                sel=1;
            }
            if(x>=490&&x<=690&&y>=410&&y<=450) {
                selc.playSfx();
                if(sel==2){
                    seld.playSfx();
                    endGame();
                    gsm.states.push(new Menu(gsm));
                }
                sel=2;
            }
            if(x>=795&&x<=840&&y>=110&&y<=140){
                seld.playSfx();
                resumed();
            }
        }
    }

    //BUKOT2 STARTS HERE
    int playerWin(Players p1, Players p2){//get p win
        int p=0;

        if(p1.layp==0){
            p=2;
        }
        if(p2.layp==0){
            p=1;
        }
        return p;
    }

    void payting(Players a, Players b){
        if((a.dash)&&dashColl(a,b)){//for p2 hit p1
            b.kb=true;
            b.naigo.playSfx();
        }
        if(a.pR==1&&b.kb){
            b.hit(true);
        }
        if(a.pL==1&&b.kb){
            b.hit(false);
        }
    }

    boolean dashColl(Players a, Players b){//p coll when dash proud kaayo ko ani dapat ma 1.0 ako grado
        if(((a.x+a.width>=b.x)&&!(a.x+a.width>=b.x+b.width)
                ||(a.x<=b.x+b.width)&&!(a.x<=b.x))
                &&((a.y>=b.y)&&!(a.y>=b.y+b.height)
                ||(a.y+a.height>=b.y)&&!(a.y+a.height>=b.y+b.height))){
            return true;
        }
        return false;
    }

    void upOneLvl(){//lava skeri
        lava.arise=true;
        harder = true;
    }

    void endGame(){
        harder=false;
        lava.arise=false;
        lava.laba.stopSfx();
        lava.cracks.stopSfx();
        paused=false;
        batol.stopSfx();
        batol2.stopSfx();
        batol.closeSfx();
        batol2.closeSfx();
        lava.laba.closeSfx();
        lava.cracks.closeSfx();
        selc.closeSfx();
        seld.closeSfx();
        killPSfx(p1);
        killPSfx(p2);
    }

    void killPSfx(Players a){
        a.jomp.closeSfx();
        a.matay.closeSfx();
        a.dasher.closeSfx();
        a.naigo.closeSfx();
    }

    void resumed(){
        //System.out.println("Resumed");
        resumed=true;
        paused=false;
        if(lvl==2){
            batol2.clip.start();
        }
        if(lvl!=2){
            batol.clip.start();
        }
        if(harder){
            lava.arise=true;
        }
        tap=0;
    }

    void pauseMenu(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.setComposite(AlphaComposite.SrcOver.derive(0.7f));
        g2.fillRect(0,0,MainPanel.sw,MainPanel.sh);
        g2.setComposite(AlphaComposite.SrcOver.derive(1f));
        g.drawImage(pusI, 400,100, 450,500, null);
        for(int i=0; i<pauseOpt.length;i++){
            if(sel==i){
                g2.setStroke(new BasicStroke(4));
                g2.setColor(Color.DARK_GRAY);
                if(sel==0){
                    seldH(g,g2,i,140);
                    g.setColor(Color.GREEN);
                }else if(sel==1){
                    seldH(g,g2,i,110);
                    g.setColor(Color.RED);
                }else if(sel==2){
                    seldH(g,g2,i,200);
                    g.setColor(Color.ORANGE);
                }
            }else{
                g.setColor(Color.WHITE);
            }
            g.setFont(new Font("Palatino Linotype", Font.BOLD, 30));
            g.drawString(pauseOpt[i], 500, 280+i*80);
        }
    }

    void seldH(Graphics g, Graphics2D g2, int i, int w){
        g2.setComposite(AlphaComposite.SrcOver.derive(0.6f));
        g2.fillRect(495,250+i*80,w,40);
        g2.setComposite(AlphaComposite.SrcOver.derive(1f));
        g.setColor(Color.BLACK);
        g2.drawRect(495,250+i*80,w,40);
    }
}
