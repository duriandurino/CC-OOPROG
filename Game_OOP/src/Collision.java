import java.awt.Point;

public class Collision {
    //platform coll
    static boolean coll(Point p, Plats b){
        if(b!=null){
            return b.contains(p);
        }
        return false;
    }

    //lava coll
    static boolean coll(Point p, Lava b){
        if(b!=null){
            return b.contains(p);
        }
        return false;
    }
}
