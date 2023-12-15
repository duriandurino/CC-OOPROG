import java.awt.*;
import java.util.Stack;

class GSM {

    public Stack<GameStates> states;

    GSM(){
        states = new Stack<GameStates>();
        states.push(new Menu(this));
    }

    void tick(){
        states.peek().tick();
    }

    void draw(Graphics g){
        states.peek().draw(g);
    }

    void keyPressed(int k){
        states.peek().keyPressed(k);
    }

    void keyTyped(int k){
        states.peek().keyTyped(k);
    }

    void keyReleased(int k){
        states.peek().keyReleased(k);
    }

    void mouseClicked(int x, int y){
        states.peek().mouseClicked(x,y);
    }
}
