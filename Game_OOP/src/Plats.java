import javax.swing.*;
import java.awt.*;

public class Plats extends Rectangle {
    public static final int size = 24;
    int x;
    int y;

    String fp;

    ImageIcon plimg;
    Image plimgg;

    Plats(int x, int y, String fp){
        this.x=x;
        this.y=y;
        this.fp=fp;
        plimg = new ImageIcon(fp);
        plimgg = plimg.getImage();
        setBounds(x, y, size, size);
    }

    void draw(Graphics g) {
        g.drawImage(plimgg, x, y, size, size, null);
    }
}
