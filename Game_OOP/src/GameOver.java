import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameOver extends GameStates{

    Audio pwvc, vsong;

    ImageIcon rbg = new ImageIcon("src/assets/record.png");
    Image rbgi = rbg.getImage();
    ImageIcon md;

    DataManager dm;

    int playerId;
    int pvc;
    int delay=0;

    String fp;
    StringBuilder userIn;
    String disUin;
    char userInChar;

    boolean empty=false;

    GameOver(GSM gsm, int wp){
        super(gsm);
        this.playerId=wp;
    }

    @Override
    void init() {
        Random randomm = new Random();
        pvc = randomm.nextInt(4)+1;
        fp = "src/assets/pw"+pvc+".wav";
        pwvc = new Audio(fp);
        pwvc.setVol(1.9f);
        vsong=new Audio("src/assets/victory.wav");
        userIn = new StringBuilder();
    }

    @Override
    void tick() {
        if(delay<180){
            delay+=1;
        }
        if(delay==180){//delay 2 secs (60 frames /1 sec)
            pwvc.playSfx();
            delay+=1;
        }
        if(delay<400){
            delay+=1;
        }
        if(delay==400){
            vsong.playSfx();
            delay+=1;
        }
        //System.out.println("way delay bleh");
    }

    @Override
    void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,MainPanel.sw, MainPanel.sh);
        g.drawImage(rbgi, 0,0,MainPanel.sw, MainPanel.sh,null);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Palatino Linotype", Font.BOLD, 50));
        g.drawString("Winner: Player "+playerId, 415,150);
        g.setColor(Color.BLACK);
        //g.drawLine(0,MainPanel.sh/2,MainPanel.sw,MainPanel.sh/2);
        //g.drawLine(MainPanel.sw/2, 0,MainPanel.sw/2,MainPanel.sh);
        g.setFont(new Font("Segoe Script", Font.BOLD, 50));
        disUin = userIn.toString();
        g.drawString(disUin, 500,480);
        if(empty){
            g.setColor(Color.RED);
            g.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
            g.drawString("Should not be empty!", 485,520);
        }
        md = new ImageIcon("src/assets/p"+playerId+".gif");
        Image mdi = md.getImage();
        g.drawImage(mdi, 690,300,700, 550, null);
    }

    @Override
    void keyPressed(int k) {
        if(k== KeyEvent.VK_BACK_SPACE){
            if(!userIn.isEmpty()){
                userIn.deleteCharAt(userIn.length()-1);
            }
        }
        if(k==KeyEvent.VK_ENTER){
            if(!userIn.isEmpty()){
                exit();
                dm = new DataManager();
                dm.writeData(disUin);
            }
            else{
                userInChar='_';
                empty=true;
            }
        }
    }

    @Override
    void keyReleased(int k) {

    }

    @Override
    void keyTyped(char k) {
        if(userIn.length()<8&&k!='\b'){
            if(k == ' ' || k == ':'||k=='\n'||k=='\t'){
                userInChar='_';
            }
            else{
                userInChar=k;
            }
            userIn.append(userInChar);
        }
    }

    @Override
    void mouseClicked(int x, int y) {

    }

    void exit(){
        pwvc.closeSfx();
        vsong.closeSfx();
        gsm.states.push(new Menu(gsm));
    }
}
