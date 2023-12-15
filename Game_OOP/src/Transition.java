import javax.swing.*;
import java.awt.*;

public class Transition extends Rectangle{

    final static int size = 1200;

    double maxTspeed=0.001;
    double currTspeed=0.0001;

    Transition(int x, int y){
        setBounds(x,y, size,size/2-400);
    }

    void tick(){

    }

    void draw(Graphics g){
        g.drawRect( x,y, size,size);
    }

}
