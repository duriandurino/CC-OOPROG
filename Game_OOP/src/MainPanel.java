import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainPanel extends JPanel implements Runnable, KeyListener{

    public static int sw = 1200;
    public static int sh = 700;

    private Thread thread;
    private boolean isRunning = false;

    private final int fps = 60;
    private final long tt = 1000/fps;

    private GSM gsm;
    MouseAdapter ma = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            System.out.println(e.getButton()+" "+e.getX() + " : " + e.getY());
            gsm.mouseClicked(e.getX(), e.getY());
        }
    };

    public MainPanel(){
        setPreferredSize(new Dimension(sw,sh));
        System.out.println("start");
        this.addKeyListener(this);
        this.setFocusable(true);
        this.addMouseListener(ma);
        Start();
    }

    private void Start(){
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    //EVENT LISTENERS==============================================
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println(e.getKeyCode());
        gsm.keyPressed(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //System.out.println(e.getKeyCode());
        gsm.keyTyped(e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println(e.getKeyCode());
        gsm.keyReleased(e.getKeyCode());
    }
    //E... L...=======================================================

    @Override
    public void run() {
        long start;
        long elapsed;
        long wait;

        gsm = new GSM();

        while(isRunning){
            start = System.nanoTime();

            tick();
            repaint();

            elapsed = System.nanoTime() - start;
            wait = tt - elapsed / 1000000;

            if(wait < 0){
                wait = 5;
            }

            try{
                Thread.sleep(wait);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void tick(){
        gsm.tick();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.clearRect(0,0,sw,sh);
        gsm.draw(g);
    }

}
