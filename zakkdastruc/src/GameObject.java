import java.awt.*;

public class GameObject {
    int x, y, width, height;
    Rectangle hitBox;
    GameObject(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        hitBox = new Rectangle(x,y,width,height);
    }
    void setHitBox(){
        hitBox.x = x;
        hitBox.y = y;
    }
}
