public class CountingSort {

    public static void sort(Value[] arr, DrawPanel dp) {
        Value[] aux =  new Value[arr.length+1];
        //Array of every possible Value
        int[] count = new int[arr.length+1];
        // Store the amount of occurrences in count[]
        for (int i = 0; i < arr.length; ++i) {
            if (dp.isStoped()) {
                dp.repaint();
                return;
            }
            arr[i].setComparable();
            dp.repaint();
            dp.sleep();
            ++count[arr[i].getValue()];
        }
        //Changes count[i] to its correspondent position of value in output[]
        for (int i = 1; i < aux.length; ++i) {
            count[i] += count[i-1];
        }
        //Create aux array
        for (int i = arr.length-1; i >= 0; i--) {
            aux[count[arr[i].getValue()]-1] = arr[i];
            --count[arr[i].getValue()];
        }
        //Copying aux[] in arr[]
        for (int i = 0; i < arr.length; i++){
            if (!dp.isStoped()) {
                aux[i].setComparable();
                dp.sleep();
            }
            dp.repaint();
            arr[i] = aux[i];
        }
    }

}
