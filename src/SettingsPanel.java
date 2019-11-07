import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SettingsPanel extends JPanel implements ActionListener, ChangeListener {

    private JButton start, randomize;
    private DrawPanel dp;
    private JComboBox<? extends Sorts> sorts;
    private JComboBox<Integer> sizes;
    private JSpinner delay;

    SettingsPanel(DrawPanel p) {
        this.setPreferredSize(new Dimension(200, 600));
        this.setBackground(new Color(64,64,64));

        this.dp = p;

        JLabel l = new JLabel("Sorts");
        l.setBackground(Color.gray);
        l.setForeground(Color.WHITE);
        this.add(l);

        this.sorts = new JComboBox<>(Sorts.values());
        this.sorts.setForeground(Color.WHITE);
        this.sorts.setBackground(Color.GRAY);
        this.sorts.setRenderer(new DefaultListCellRenderer() {
            @Override
            public void paint(Graphics g) {
                setBackground(Color.gray);
                super.paint(g);
            }
        });
        this.sorts.addActionListener(this);
        this.sorts.setSelectedItem(this.dp.getSort());

        l.setLabelFor(this.sorts);
        this.add(this.sorts);

        l = new JLabel("Items");
        l.setBackground(Color.gray);
        l.setForeground(Color.WHITE);
        this.add(l);

        Integer[] sizes = {4,8,10,25,50,100,200,400,800};

        this.sizes = new JComboBox<>(sizes);
        this.sizes.setSelectedIndex(sizes.length-1);
        this.sizes.setForeground(Color.WHITE);
        this.sizes.setBackground(Color.GRAY);
        this.sizes.setRenderer(new DefaultListCellRenderer() {
            @Override
            public void paint(Graphics g) {
                setBackground(Color.gray);
                super.paint(g);
            }
        });
        this.sizes.addActionListener(this);

        l.setLabelFor(this.sizes);
        this.add(this.sizes);
        JSeparator j = new JSeparator(SwingConstants.VERTICAL);
        j.setBackground(this.getBackground());
        this.add(j);

        SpinnerNumberModel model = new SpinnerNumberModel(this.dp.getDelay(), 0, 250, 1);
        this.delay = new JSpinner(model);
        int n = this.delay.getComponentCount();
        this.delay.getEditor().getComponent(0).setBackground(Color.GRAY);
        this.delay.getEditor().getComponent(0).setForeground(Color.WHITE);

        l = new JLabel("Delay");
        l.setBackground(Color.gray);
        l.setForeground(Color.WHITE);
        this.add(l);

        this.delay.getComponent(0).setBackground(Color.LIGHT_GRAY);
        this.delay.getComponent(1).setBackground(Color.LIGHT_GRAY);

        this.delay.addChangeListener(this);

        l.setLabelFor(this.delay);
        this.add(this.delay);

        this.randomize = new JButton("Randomize");
        this.randomize.setForeground(Color.WHITE);
        this.randomize.setBackground(Color.GRAY);
        this.randomize.addActionListener(this);

        this.start = new JButton("Sort");
        this.start.setForeground(Color.WHITE);
        this.start.setBackground(Color.GRAY);
        this.start.addActionListener(this);

        this.add(this.randomize);
        this.add(this.start);

    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.sorts) {
            if (!this.dp.isRunning()){
                this.dp.setSort((Sorts) this.sorts.getSelectedItem());
            } else {
                this.sorts.setSelectedItem(this.dp.getSort());
            }

        }  else if (e.getSource() == this.sizes) {
            if (!this.dp.isRunning()){
                this.dp.reSize((Integer) this.sizes.getSelectedItem());
            } else {
                this.sizes.setSelectedItem(this.dp.getSizes());
            }

        }else if (e.getSource() == this.randomize) {
            if (!this.dp.isRunning()){
                this.dp.randomize();
                this.dp.repaint();
            }

        } else if (e.getSource() == this.start) {
            if (!this.dp.isRunning()){
                this.dp.start();
            }

        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.dp.setDelay((Integer)this.delay.getValue());
    }
}