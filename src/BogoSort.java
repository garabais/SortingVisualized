public class BogoSort {

    public static void sort(Value[] arr, DrawPanel dp){
        while (!isSorted(arr)){
            shuffle(arr, dp);
        }
    }

    public static boolean isSorted(Value[] arr){
        for(int i = 1; i < arr.length; i++){
            if(arr[i].compareTo(arr[i-1]) < 0){
                return  false;
            }
        }
        return true;
    }

    public static void shuffle(Value[] arr, DrawPanel dp){
        for (int i = 0; i < arr.length; i++){
            if (dp.isStoped()) {
                dp.repaint();
                return;
            }
            int j = (int)(Math.random()*i);
            arr[i].setComparable();
            arr[j].setComparable();
            dp.repaint();
            dp.sleep();
            swap(arr, i, j);
        }
    }

    private static void swap(Value[] arr, int first, int last) {
        Value aux = arr[last];
        arr[last] = arr[first];
        arr[first] = aux;
    }

}
