import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class Value implements Comparable<Value> {
    private Integer value;
    private Color color;

     Value(int value) {
        this.value = value;
        this.color = Color.WHITE;
    }

    void setComparable(){
         this.setColor(Color.RED);
    }

    void setColor(Color c) {
         this.color = c;
    }
    void draw(Graphics g, int x, int w, int h, int max) {
        g.setColor(this.color);

        int p = this.value * h / max;

       g.fillRect(x,h -p, w, p);

       if (this.color == Color.RED) {
           this.color = Color.WHITE;
       }

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Value) {
            return ((Value) obj).value.equals(this.value);
        }
        return false;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public int compareTo(Value o) {
        return this.value.compareTo(o.value);
    }
}
