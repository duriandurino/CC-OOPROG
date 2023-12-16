import java.awt.*;

abstract class GameStates {

    public GSM gsm;

    public GameStates(GSM gsm){
        this.gsm = gsm;
        init();
    }

    abstract void init();
    abstract void tick();
    abstract void draw(Graphics g);
    abstract void keyPressed(int k);
    abstract void keyReleased(int k);
    abstract void keyTyped(char k);
    abstract void mouseClicked(int x, int y);
}
