import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Menu extends GameStates {

    private final String[] opt = {"P L A Y", "H E L P","LEADERBOARD", "Q U I T"};

    private int sel = 0;

    double rspeed=15;
    double currRspeed=3;
    double rxPos= -100;

    DataManager dm;

    Audio menu,selc,seld;

    ImageIcon mbg = new ImageIcon("assets/mbg.gif");
    Image mbgi = mbg.getImage();
    ImageIcon md = new ImageIcon("assets/p1.gif");
    Image mdi = md.getImage();
    ImageIcon pnl = new ImageIcon("assets/panel.png");
    Image pnli = pnl.getImage();
    ImageIcon hii = new ImageIcon("assets/help.png");
    Image hi = hii.getImage();

    ImageIcon ttl = new ImageIcon("assets/title.png");
    Image ttli = ttl.getImage();
    ImageIcon tbg = new ImageIcon("assets/titlebg.png");
    Image tbgi = tbg.getImage();
    ImageIcon ttlt = new ImageIcon("assets/tail.gif");
    Image ttlti = ttlt.getImage();

    boolean stop=false;
    boolean chose=false;

    boolean lb=false;
    boolean herp=false;

    Menu(GSM gsm){
        super(gsm);
    }

    @Override
    void init() {
        //Leaderboard lb = new Leaderboard();
        //lb.checkData();
        menu = new Audio("assets/menu.wav");
        selc = new Audio("assets/sel.wav");
        seld = new Audio("assets/seld.wav");
    }

    @Override
    void tick() {
        if(!menu.clip.isRunning()&&!stop){
            menu.playSfx();
        }
        if(chose){
            rxPos+=currRspeed;
            currRspeed-=1;
            if(currRspeed<=0){
                currRspeed=rspeed;
                chose=false;
            }
        }
    }

    @Override
    void draw(Graphics g) {
        int dx = 90;
        g.drawImage(mbgi, 0,0,MainPanel.sw, MainPanel.sh, null);
        g.drawImage(mdi, MainPanel.sw/2-200,MainPanel.sh/2-150,MainPanel.sw/2+200, MainPanel.sh/2+200, null);
        g.drawImage(tbgi, -20,40,900, 210, null);
        g.drawImage(ttlti, 275,70,100, 60, null);
        g.drawImage(ttli, 100,75,650, 170, null);
        for(int i=0;i<opt.length;i++){
            if(rxPos<0){
                chose=true;
            }
            if(rxPos>=0){
                //System.out.println("ni draw sa menu");
                chose=false;
            }
            if(sel==i){
                dx = 120;
                g.setColor(new Color(10, 2, 20));
                g.fillRect((int)rxPos-10, 340+i*80, 400,70);
                if(sel==2){
                    g.fillRect((int)rxPos-10, 340+i*80, 611,70);
                    g.setColor(Color.YELLOW);
                }
                else if(sel==3){
                    g.setColor(Color.RED);
                }else{
                    g.setColor(Color.GREEN);
                }
            }else{
                dx=90;
                g.setColor(Color.WHITE);
            }

//            g.drawLine(MainPanel.sw/2,0,MainPanel.sw/2,MainPanel.sh);
//            g.drawLine(0,MainPanel.sh/2,MainPanel.sw,MainPanel.sh/2);
            g.setFont(new Font("Palatino Linotype", Font.BOLD, 60));
            g.drawString(opt[i], dx, 400+i*80);

            if(lb||herp){
                hnlPanel(g);
            }

        }
    }

    void hnlPanel(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.setComposite(AlphaComposite.SrcOver.derive(0.5f));
        g2.fillRect(0,0,MainPanel.sw,MainPanel.sh);
        g2.setComposite(AlphaComposite.SrcOver.derive(1f));
        g.drawImage(pnli, 300,30, 600,650, null);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Palatino Linotype", Font.BOLD, 40));
        String header=" ";
        int hx=0, hy=0;
        if(lb){
            header="TOP INFERNO LANCERS";
            lPanel(g);
            hx=360;
            hy=120;
        }if(herp){
            header="GAME INFO";
            hPanel(g);
            hx=480;
            hy=120;
        }
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Palatino Linotype", Font.BOLD, 40));
        g.drawString(header, hx, hy);
    }

    void hPanel(Graphics g){
        g.drawImage(hi, 400,145, 400,530, null);
    }

    void lPanel(Graphics g){
        dm = new DataManager();
        g.setFont(new Font("Palatino Linotype", Font.BOLD, 25));
        g.drawString("NAME                      WINS", 400, 215);
        if(dm.getDatas()!=null||dm.getDatas().length!=0){
            String[] records = dm.getDatas();
            for(int i=0;i< records.length;i++){
                if(records[i]==null){
                    break;
                }
                if(i==0){
                    g.setColor(new Color(255,215,0));
                    g.drawRect(400,240, 350,30);
                    g.setFont(new Font("Times New Roman", Font.BOLD, 25));
                }
                else if(i==1){
                    g.setColor(new Color(192,192,192));
                    g.drawRect(400,280, 340,38);
                    g.setFont(new Font("Times New Roman", Font.BOLD, 23));
                }else if(i==2){
                    g.setColor(new Color(205,127,50));
                    g.drawRect(400,325, 330,35);
                    g.setFont(new Font("Times New Roman", Font.BOLD, 20));
                }else{
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                }
                String[] rSplit = records[i].split(":");
                String spc = " - - - - - - - - - - ";
                for(int j=records[i].length(); j<8;j++){
                    spc+="- ";
                }
                String pr = (i+1)+". "+rSplit[0]+" "+spc+" "+rSplit[1];
                g.drawString(pr, 400, 265+i*40);
            }
        }
    }

    @Override
    void keyPressed(int k) {
        //System.out.println(k+"menu");
        if(!lb){
            if(k==KeyEvent.VK_UP||k==KeyEvent.VK_DOWN){
                rxPos=-100;
                selc.playSfx();
            }
            if(k==KeyEvent.VK_UP){
                sel--;
                if(sel<0){
                    sel=opt.length-1;
                }
            }
            if(k==KeyEvent.VK_DOWN){
                sel++;
                if(sel>=opt.length){
                    sel=0;
                }
            }
            if(k==KeyEvent.VK_ENTER){
                switch(sel){
                    case 0:
                        //play
                        stop=stopMenuSfx();
                        gsm.states.push(new Demo(gsm));
                        break;
                    case 1:
                        //help
                        seld.playSfx();
                        herp=true;
                        break;
                    case 2:
                        //leaderboard
                        seld.playSfx();
                        lb=true;
                        break;
                    case 3:
                        //quit
                        stop=stopMenuSfx();
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @Override
    void keyReleased(int k) {

    }

    @Override
    void keyTyped(char k) {

    }

    @Override
    void mouseClicked(int x, int y) {
        if(!lb){
            if(x>=2&&x<=400&&y>=340&&y<=410){
                rxPos=-100;
                selc.playSfx();
                if(sel==0){
                    stop=stopMenuSfx();
                    gsm.states.push(new Demo(gsm));
                }
                sel=0;
            }
            if(x>=2&&x<=400&&y>=420&&y<=490){
                rxPos=-100;
                selc.playSfx();
                if(sel==1){
                    seld.playSfx();
                    herp=true;
                    //help
                }
                sel=1;
            }
            if(x>=2&&x<=600&&y>=510&&y<=570){
                rxPos=-100;
                selc.playSfx();
                if(sel==2){
                    seld.playSfx();
                    lb=true;
                    //leaderboard
                }
                sel=2;
            }
            if(x>=2&&x<=400&&y>=580&&y<=650){
                rxPos=-100;
                selc.playSfx();
                if(sel==3){
                    stop=stopMenuSfx();
                    //quit
                    System.exit(0);
                }
                sel=3;
            }
        }
        if(lb||herp){
            if(x>=820&&x<=890&&y>=40&&y<=80){
                herp=false;
                lb=false;
            }
        }
    }

    boolean stopMenuSfx(){
        boolean stop = true;
        menu.stopSfx();
        selc.stopSfx();
        seld.playSfx();
        seld.closeSfx();
        selc.closeSfx();
        menu.closeSfx();
        return stop;
    }
}
