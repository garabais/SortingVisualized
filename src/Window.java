import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Window extends JFrame implements ComponentListener {

    private DrawPanel dp;
    private SettingsPanel sp;

    public Window(){
        super("Sorting Algorithms");

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.dp = new DrawPanel();
        this.add(dp);

        this.sp = new SettingsPanel(dp);
        this.add(this.sp, BorderLayout.WEST);

        this.pack();
//        this.resize();
        this.addComponentListener(this);
    }

    public void resize() {
        this.dp.stop();
        this.sp.clearSizes();
        for (int i=3;i<=this.dp.getWidth();i++){
            if (this.dp.getWidth()%i==0){
                this.sp.addSize(i);
            }

        }
    }
    public static void main(String[] args) {
        Window w = new Window();
    }

    @Override
    public void componentResized(ComponentEvent e) {
        this.resize();
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
