import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(){
        super("Sorting Algorithms");

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        DrawPanel dp = new DrawPanel();
        this.add(dp);
        this.add(new SettingsPanel(dp), BorderLayout.WEST);

        this.pack();
    }

    public static void main(String[] args) {
        Window w = new Window();
    }
}
