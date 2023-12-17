import javax.swing.*;
import java.awt.BorderLayout;

public class InfernoLancers{
    public static void main(String[] args){
        JFrame gf = new JFrame();
        ImageIcon logo = new ImageIcon("src\\assets\\logo.png");

        gf.setDefaultCloseOperation(gf.EXIT_ON_CLOSE);
        gf.setResizable(false);
        gf.setLayout(new BorderLayout());
        gf.setTitle("Inferno Lancers: The Duel v0.0.1a");
        gf.setIconImage(logo.getImage());

        gf.add(new MainPanel(), BorderLayout.CENTER);

        gf.pack();
        gf.setLocationRelativeTo(null);
        gf.setVisible(true);
    }
}
