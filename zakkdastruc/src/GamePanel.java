import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    final int SCREEN_HEIGHT = 600, SCREEN_WIDTH = 1000;
    long currentTime, lastTime, fps = 1000000000/60;
    boolean gameRunning;

    ImageIcon enemyIcon = new ImageIcon(".\\res\\enemy.jpg");
    Image enemy = enemyIcon.getImage();

    ArrayList<GameObject> objects = new ArrayList<>();

    MouseListener ma = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            System.out.println(e.getX());
            System.out.println(e.getY());
        }
    };

    Thread gameThread = new Thread(()->{
        lastTime = System.nanoTime();
        while (gameRunning){
            currentTime = System.nanoTime();
            if (currentTime-lastTime > fps){
                lastTime = System.nanoTime();
                gameTick();
                repaint();
            }
        }
    });
    void gameTick(){
        objects.get(0).x++;
    }
    GamePanel(){
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setBackground(Color.LIGHT_GRAY);
        gameThread.start();
        gameRunning = true;
        objects.add(new GameObject(0,0,50,50));
        addMouseListener(ma);

    }
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        for (GameObject object : objects){
            g2d.drawImage(enemy,object.x,object.y,enemy.getWidth(null)/2,enemy.getHeight(null)/2, null);
        }
    }
}
