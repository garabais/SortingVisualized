import javax.swing.*;
import java.awt.*;
import java.util.Random;

class DrawPanel extends JPanel implements Runnable{

     private Value[] values;
     private Sorts sort;
     private boolean start, mode, next;
     private int delay;


     DrawPanel(){
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(Color.BLACK);

        this.reSize(800);
        this.randomize();
        this.sort = Sorts.MERGESORT;

        this.delay = 1;

        Thread th = new Thread(this);

        th.start();
    }

     void randomize(){

         for (int i = 0; i < this.values.length; i++){
             int j = (int)(Math.random()*this.values.length);

             Value aux = this.values[j];
             this.values[j] = this.values[i];
             this.values[i] = aux;
         }
//        Random rd = new Random();
//         for (int i = 0; i < values.length; i++) {
//             this.values[i] = new Value(rd.nextInt(1000));
//         }
         this.repaint();
    }

    void sleep() {

        if (!mode) {
            try {
                Thread.sleep(this.delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            while (!next) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.next = false;
        }

    }

    String getMode() {
         return this.mode ? "Steps": "Delay";
    }
    void changeMode(){
         this.mode = !this.mode;
        System.out.println(this.mode);

    }

    public void next() {
         if (start) {
             this.next = true;
         }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        this.paintValues(g);
    }

    void start(){
         this.start = true;
    }

    void reSize(int n) {
         this.values = new Value[n];
        for (int i = 0; i < this.values.length; i++) {
            this.values[i] = new Value(i + 1);
        }

        this.randomize();
         this.repaint();
    }

    private void paintValues(Graphics g) {

         int w = this.getWidth() / this.values.length;

        for (int i = 0; i < values.length; i++) {
            this.values[i].draw(g,w*i,w,this.getHeight(), values.length);
        }
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public Sorts getSort() {
        return sort;
    }

    public void setSort(Sorts sort) {
        this.sort = sort;
    }

    public boolean isRunning(){
         return this.start;
    }

    public Integer getSizes(){
         return this.values.length;
    }

    void checkSort(){
         this.values[0].setComparable();
         this.repaint();
         this.sleep();
        for(int i = 1; i < this.values.length; i++) {
            this.values[i].setComparable();
            this.values[i - 1].setColor(Color.GREEN);
            this.repaint();
            this.sleep();
        }
        this.values[this.values.length -1].setColor(Color.GREEN);
        this.repaint();
        this.sleep();

        for (Value v : this.values) {
            v.setColor(Color.WHITE);
        }
        this.repaint();
    }

    void stop() {
         this.start = false;
         this.next();
         this.repaint();
    }

    boolean isStoped() {
         return !this.start;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);

                if (this.start ) {
                    switch (this.sort) {
                        case HEAPSORT:
                            HeapSort.sort(this.values, this);
                            break;
                        case MERGESORT:
                            MergeSort.sort(this.values, this);
                            break;
                        case QUICKSORT:
                            QuickSort.sort(this.values, this);
                            break;
                        case RADIXSORT:
                            RadixSort.sort(this.values, this);
                            break;
                        case COUNTINGSORT:
                            CountingSort.sort(this.values, this);
                            break;
                        case BUBBLESORT:
                            BubbleSort.sort(this.values, this);
                            break;
                        case INSERTIONSORT:
                            InsertionSort.sort(this.values, this);
                            break;
                        case SELECTIONSORT:
                            SelectionSort.sort(this.values, this);
                            break;
                        case BOGOSORT:
                            BogoSort.sort(this.values, this);
                            break;
                        case BOZOSORT:
                            BozoSort.sort(this.values, this);
                            break;
                        case BUCKETSORT:
                            BucketSort.sort(this.values, this);
                            break;
                        case COMBSORT:
                            CombSort.sort(this.values, this);
                            break;
                        case SHELLSORT:
                            ShellSort.sort(this.values, this);
                            break;
                        case COCKTAILSORT:
                            CocktailSort.sort(this.values, this);
                            break;
                        case PANCAKESORT:
                            PancakeSort.sort(this.values, this);
                            break;
                        case INTROSORT:
                            IntroSort.sort(this.values, this);
                            break;
                    }
                    if (this.start) {
                        this.checkSort();
                    }
                    this.start = false;
                }

//                System.out.println("hello");


            }catch (InterruptedException e) {

                System.out.println("Cant recover from sleep");
            }
        }
    }
}
