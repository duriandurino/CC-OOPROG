import javax.swing.*;
import java.awt.*;

public class Lava extends Rectangle{
    public static final int size = 1200;

    ImageIcon plimg = new ImageIcon("assets/lava.gif");
    Image plimgg = plimg.getImage();

    Audio laba,cracks;

    double maxLspeed=0.001;
    double currLspeed=0.0001;

    boolean arise = false;

    Lava(int x, int y){
        setBounds(x, y, size, size/2-200);
        laba=new Audio("assets/lava.wav");
        cracks=new Audio("assets/cracks.wav");
    }

    void tick(){
        if(arise){
            if(!laba.clip.isRunning()||!cracks.clip.isRunning()){
                cracks.playSfx();
                laba.playSfx();
            }
            y-=currLspeed;
            //same logic with fall but upwards
            if(currLspeed<maxLspeed){
                currLspeed+=0.0001;
            }
        }
        if(!arise){
            currLspeed=0.0001;
        }
    }

    void draw(Graphics g){
        g.drawImage(plimgg, x,y, size,size, null);
    }
}
