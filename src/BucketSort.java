import java.util.ArrayList;

public class BucketSort {

    public static void sort(Value[] arr, DrawPanel dp) {
        int[] bucket = new int[1010];
        for (int i = 0; i < arr.length; i++) {
            arr[i].setComparable();
            dp.repaint();
            dp.sleep();
            bucket[arr[i].getValue()]++;
        }
        int count = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                arr[count].setComparable();
                dp.repaint();
                dp.sleep();
                arr[count++] = new Value(i);

            }
        }
    }

}
