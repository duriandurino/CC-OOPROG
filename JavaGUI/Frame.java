import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Frame extends JFrame implements KeyListener{

    ImageIcon keyNA = new ImageIcon("mania-key1.png");
    ImageIcon keyA = new ImageIcon("mania-key1D.png");
    ImageIcon leftWall = new ImageIcon("mania-stage-left.png");
    ImageIcon rightWall = new ImageIcon("mania-stage-right.png");
    
    Font letter = new Font("Times New Roman", Font.BOLD, 20);
    
    JPanel Menu;
    
    
    JPanel GamePanels;
    JPanel wall;
    JLabel lWall;
    JLabel rWall;
    JPanel tile;
    JPanel cheer;
    JPanel la;
    JPanel mla;
    JPanel mra;
    JPanel ra;
    JLabel left;
    JLabel mLeft;
    JLabel mRight;
    JLabel right;
    
    Frame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1024,700);
        this.setLayout(null);
        this.setResizable(false);
        this.addKeyListener(this);
        this.setTitle("Drino Tiles");
        
        GamePanel();       
        
        this.getContentPane().setBackground(Color.black);
        this.setVisible(true);
    }
    
    public void GamePanel(){
        GamePanels = new JPanel();
        
        tile = new JPanel();
        cheer = new JPanel();
        
        la = new JPanel();
        mla = new JPanel();
        mra = new JPanel();
        ra = new JPanel();
        
        wall = new JPanel();
        
        GamePanels.setBounds(0,0, 1024,700);
        GamePanels.setBackground(null);
        GamePanels.setLayout(null);
        
        wall.setBounds(0,0, 1024,700);
        wall.setBackground(null);
        wall.setLayout(null);
        
        lWall = new JLabel();
        lWall.setIcon(leftWall);
        lWall.setBounds(-489,0, 713,700);
        lWall.setBackground(null);
        lWall.setOpaque(true);
        rWall = new JLabel();
        rWall.setIcon(rightWall);
        rWall.setBounds(764,0, 300,700);
        rWall.setBackground(null);
        rWall.setOpaque(true);             
        
        tile.setBackground(null);
        tile.setBounds(224,0, 540, 700);
        tile.setLayout(null);
        
        la.setBounds(50,0, 100, 600);
        la.setBackground(null);
        la.setLayout(null);
        mla.setBounds(160,0, 100, 600);
        mla.setBackground(null);
        mla.setLayout(null);
        mra.setBounds(270,0, 100, 600);
        mra.setBackground(null);
        mra.setLayout(null);
        ra.setBounds(380,0, 100, 600);
        ra.setBackground(null);
        ra.setLayout(null);
        
        left = new JLabel();
        left.setBackground(null);
        left.setIcon(keyNA);
        left.setText("D");
        left.setFont(letter);
        left.setForeground(Color.gray);
        left.setHorizontalTextPosition(JLabel.CENTER);
        left.setVerticalTextPosition(JLabel.CENTER);
        left.setBounds(0,500, 100,125);
        left.setOpaque(true);
        
        mLeft = new JLabel();
        mLeft.setBackground(null);
        mLeft.setIcon(keyNA);
        mLeft.setText("F");
        mLeft.setFont(letter);
        mLeft.setForeground(Color.gray);
        mLeft.setHorizontalTextPosition(JLabel.CENTER);
        mLeft.setVerticalTextPosition(JLabel.CENTER);
        mLeft.setBounds(0,500, 100,125);
        mLeft.setOpaque(true);
        
        mRight = new JLabel();
        mRight.setBackground(null);
        mRight.setIcon(keyNA);
        mRight.setText("J");
        mRight.setFont(letter);
        mRight.setForeground(Color.gray);
        mRight.setHorizontalTextPosition(JLabel.CENTER);
        mRight.setVerticalTextPosition(JLabel.CENTER);
        mRight.setBounds(0,500, 100,125);
        mRight.setOpaque(true);
        
        right = new JLabel();
        right.setBackground(null);
        right.setIcon(keyNA);
        right.setText("K");
        right.setFont(letter);
        right.setForeground(Color.gray);
        right.setHorizontalTextPosition(JLabel.CENTER);
        right.setVerticalTextPosition(JLabel.CENTER);
        right.setBounds(0,500, 100,125);
        right.setOpaque(true);
        
        wall.add(lWall);
        wall.add(rWall);
        
        la.add(left);
        mla.add(mLeft);
        mra.add(mRight);
        ra.add(right);
        
        tile.add(cheer);
        tile.add(la);
        tile.add(mla);
        tile.add(mra);
        tile.add(ra);
        
        GamePanels.add(tile);
        GamePanels.add(wall);
        
        this.add(GamePanels);
    }
    
    public void tap(KeyEvent e){
        switch(e.getKeyChar()){
            case 'd': left.setIcon(keyA); 
                    left.setForeground(new Color(0, 255, 255));
                break;
            case 'f': mLeft.setIcon(keyA); 
                    mLeft.setForeground(new Color(0, 255, 255));
                break;
            case 'j': mRight.setIcon(keyA); 
                    mRight.setForeground(new Color(0, 255, 255));
                break;
            case 'k': right.setIcon(keyA); 
                    right.setForeground(new Color(0, 255, 255));
                break;
        }
    }
    
    public void tapRelease(KeyEvent e){
        switch(e.getKeyChar()){
            case 'd': left.setIcon(keyNA); 
                    left.setForeground(Color.gray);
                break;
            case 'f': mLeft.setIcon(keyNA); 
                    mLeft.setForeground(Color.gray);
                break;
            case 'j': mRight.setIcon(keyNA); 
                    mRight.setForeground(Color.gray);
                break;
            case 'k': right.setIcon(keyNA); 
                    right.setForeground(Color.gray);
                break;
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e){
        tap(e);
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        tap(e);
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        tapRelease(e);
    }
}
