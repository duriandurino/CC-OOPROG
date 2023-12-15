import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Menu extends GameStates {

    private String[] opt = {"P L A Y", "H E L P","LEADERBOARD", "Q U I T"};

    private int sel = 0;

    double rspeed=15;
    double currRspeed=3;
    double rxPos= -100;

    Audio menu,selc,seld;
    ImageIcon mbg = new ImageIcon("src\\assets\\mbg.gif");
    Image mbgi = mbg.getImage();
    ImageIcon md = new ImageIcon("src\\assets\\p1.gif");
    Image mdi = md.getImage();

    boolean stop=false;
    boolean chose=false;

    Menu(GSM gsm){
        super(gsm);
    }

    @Override
    void init() {
        menu = new Audio("src\\assets\\menu.wav");
        selc = new Audio("src\\assets\\sel.wav");
        seld = new Audio("src\\assets\\seld.wav");
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

            //g.drawLine(MainPanel.sw/2,0,MainPanel.sw/2,MainPanel.sh);
            //g.drawLine(0,MainPanel.sh/2,MainPanel.sw,MainPanel.sh/2);
            g.setFont(new Font("Palatino Linotype", Font.BOLD, 60));
            g.drawString(opt[i], dx, 400+i*80);
        }
    }

    @Override
    void keyPressed(int k) {
        //System.out.println(k+"menu");
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
            stop=stopMenuSfx();
            switch(sel){
                case 0:
                    //play
                    gsm.states.push(new Demo(gsm));
                    break;
                case 1:
                    //help
                    break;
                case 2:
                    //leaderboard
                    break;
                case 3:
                    //quit
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    void keyReleased(int k) {

    }

    @Override
    void keyTyped(int k) {

    }

    @Override
    void mouseClicked(int x, int y) {

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
                stop=stopMenuSfx();
                //help
            }
            sel=1;
        }
        if(x>=2&&x<=400&&y>=510&&y<=570){
            rxPos=-100;
            selc.playSfx();
            if(sel==2){
                stop=stopMenuSfx();
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

    boolean stopMenuSfx(){
        boolean stop = true;
        menu.stopSfx();
        selc.stopSfx();
        seld.playSfx();
        return stop;
    }
}
