import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class SettingsPanel extends JPanel implements ActionListener, ChangeListener {

    private JButton start, randomize, stop, step;
    private DrawPanel dp;
    private JComboBox<? extends Sorts> sorts;
    private JComboBox<Integer> sizes;
    private JComboBox<String> delayOption;
    private JSpinner delay;
    private JPanel options;

    SettingsPanel(DrawPanel p) {
        this.setPreferredSize(new Dimension(200, 600));
        this.setBackground(new Color(64,64,64));
        GroupLayout layout = new GroupLayout(this);

        this.dp = p;

        JLabel lSorts = new JLabel("Sorts");
        lSorts.setBackground(Color.gray);
        lSorts.setForeground(Color.WHITE);
//        this.add(l);

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
//        this.sorts.setSelectedItem(this.dp.getSort());

        lSorts.setLabelFor(this.sorts);
//        this.add(this.sorts);

        JLabel lItems = new JLabel("Items");
        lItems.setBackground(Color.gray);
        lItems.setForeground(Color.WHITE);
//        this.add(l);

        Integer[] sizes = {4,8,25,50,100,200,400,800};

        this.sizes = new JComboBox<>(sizes);
//        this.sizes.setSelectedIndex(5);
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

        lItems.setLabelFor(this.sizes);
//        this.add(this.sizes);

//        this.add(j);

        SpinnerNumberModel model = new SpinnerNumberModel(this.dp.getDelay(), 1, 250, 1);
        this.delay = new JSpinner(model);
        int n = this.delay.getComponentCount();
        this.delay.getEditor().getComponent(0).setBackground(Color.GRAY);
        this.delay.getEditor().getComponent(0).setForeground(Color.WHITE);

        JLabel lDelay = new JLabel("Delay");
        lDelay.setBackground(Color.gray);
        lDelay.setForeground(Color.WHITE);
//        this.add(l);

        this.delay.getComponent(0).setBackground(Color.LIGHT_GRAY);
        this.delay.getComponent(1).setBackground(Color.LIGHT_GRAY);

        this.delay.addChangeListener(this);

        lDelay.setLabelFor(this.delay);
//        this.add(this.delay);

        this.randomize = new JButton("Randomize");
        this.randomize.setForeground(Color.WHITE);
        this.randomize.setBackground(Color.GRAY);
        this.randomize.addActionListener(this);

        this.start = new JButton("Start");
        this.start.setForeground(Color.WHITE);
        this.start.setBackground(Color.GRAY);
        this.start.addActionListener(this);

        this.stop = new JButton("Stop");
        this.stop.setForeground(Color.WHITE);
        this.stop.setBackground(Color.GRAY);
        this.stop.addActionListener(this);

        this.step = new JButton("Next");
        this.step.setForeground(Color.WHITE);
        this.step.setBackground(Color.GRAY);
        this.step.addActionListener(this);

        JPanel sortsp = new JPanel();
        sortsp.setBackground(this.getBackground());
        sortsp.add(lSorts);
        sortsp.add(this.sorts);

        JPanel itemsp = new JPanel();
        itemsp.setBackground(this.getBackground());
        itemsp.add(lItems);
        itemsp.add(this.sizes);

        JPanel buttons = new JPanel();
        buttons.setBackground(this.getBackground());
        buttons.add(this.start);
        buttons.add(this.stop);

        JPanel buttonR = new JPanel();
        buttonR.setBackground(this.getBackground());
        buttonR.add(this.randomize);


        JPanel selector = new JPanel();
        selector.setBackground(this.getBackground());

        String[] delayOptions = { "Delay", "Steps" };
        this.delayOption = new JComboBox<>(delayOptions);
        this.delayOption.setForeground(Color.WHITE);
        this.delayOption.setBackground(Color.GRAY);
        this.delayOption.setRenderer(new DefaultListCellRenderer() {
            @Override
            public void paint(Graphics g) {
                setBackground(Color.gray);
                super.paint(g);
            }
        });

        this.delayOption.setEditable(false);
//        this.delayOption.addItemListener(this);
        this.delayOption.addActionListener(this);
        selector.add(this.delayOption);

        JPanel d = new JPanel();
        d.setBackground(this.getBackground());
        d.add(lDelay);
        d.add(this.delay);

        JPanel s = new JPanel();
        s.setBackground(this.getBackground());
        s.add(this.step);

        options = new JPanel(new CardLayout());
        options.setBackground(this.getBackground());
        options.add(d, "Delay");
        options.add(s, "Steps");

        JPanel delays = new JPanel();
        delays.setBackground(this.getBackground());
        delays.add(selector);
        delays.add(options);


//        this.add(this.randomize);
//        this.add(this.start);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(sortsp)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(itemsp)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(buttons)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonR)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(delays)

                        )
        );

        this.dp.setSort((Sorts) this.sorts.getSelectedItem());
        this.dp.reSize((Integer) this.sizes.getSelectedItem());
        this.dp.setDelay((Integer)this.delay.getValue());
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

        } else if (e.getSource() == this.step) {
            this.dp.next();
        } else if (e.getSource() == this.delayOption) {
            CardLayout cl = (CardLayout)(options.getLayout());
            cl.show(options, (String) this.delayOption.getSelectedItem());
//            cl.show(options, (String)e.getItem());
            if (!((String) this.delayOption.getSelectedItem()).equals(this.dp.getMode())) {
                this.dp.changeMode();
            }
//            this.dp.changeMode();
            this.dp.next();
//            System.out.println("change");
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.dp.setDelay((Integer)this.delay.getValue());

    }
}