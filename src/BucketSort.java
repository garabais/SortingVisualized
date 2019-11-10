import java.util.ArrayList;

public class BucketSort {

    public static void sort(Value[] arr, DrawPanel dp) {
        int[] bucket = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            if (dp.isStoped()) {
                dp.repaint();
                return;
            }
            arr[i].setComparable();
            dp.repaint();
            dp.sleep();
            bucket[arr[i].getValue()]++;
        }
        int count = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                if (dp.isStoped()) {
                    dp.repaint();
                    return;
                }
                arr[count].setComparable();
                dp.repaint();
                dp.sleep();
                arr[count++] = new Value(i);

            }
        }
    }

}
