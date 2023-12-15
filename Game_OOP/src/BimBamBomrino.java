import javax.swing.JFrame;
import java.awt.BorderLayout;

public class BimBamBomrino{
    public static void main(String[] args){
        JFrame gf = new JFrame();

        gf.setDefaultCloseOperation(gf.EXIT_ON_CLOSE);
        gf.setResizable(false);
        gf.setLayout(new BorderLayout());
        gf.setTitle("Inferno Lancers v0.0.1a");

        gf.add(new MainPanel(), BorderLayout.CENTER);

        gf.pack();
        gf.setLocationRelativeTo(null);
        gf.setVisible(true);
    }
}
