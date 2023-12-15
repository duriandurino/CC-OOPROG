import java.awt.*;
import java.util.Random;

public class GameOver extends GameStates{

    Audio pwvc;
    int playerId;
    int pvc;
    String fp;
    int delay=0;

    GameOver(GSM gsm, int wp){
        super(gsm);
        this.playerId=wp;
    }

    @Override
    void init() {
        Random randomm = new Random();
        pvc = randomm.nextInt(4)+1;
        fp = "src\\assets\\pw"+pvc+".wav";
        pwvc = new Audio(fp);
        pwvc.setVol(1.9f);
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
        if(delay<480){
            delay+=1;
        }
        if(delay==480){

            delay+=1;
        }
        //System.out.println("way delay bleh");
    }

    @Override
    void draw(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(0,0,MainPanel.sw, MainPanel.sh);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Palatino Linotype", Font.BOLD, 70));
        g.drawString("Winner: Player "+playerId, MainPanel.sw/2-170,100);
        g.drawLine(0,MainPanel.sh/2,MainPanel.sw,MainPanel.sh/2);
        g.drawLine(MainPanel.sw/2, 0,MainPanel.sw/2,MainPanel.sh);
    }

    @Override
    void keyPressed(int k) {

    }

    @Override
    void keyReleased(int k) {

    }

    @Override
    void keyTyped(int k) {

    }

    @Override
    void mouseClicked(int x, int y) {

    }
}
