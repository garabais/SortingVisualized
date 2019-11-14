public class BozoSort {

    public static void sort(Value[] arr, DrawPanel dp){
        while (!isSorted(arr)){
            if (dp.isStoped()) {
                dp.repaint();
                return;
            }
            int i = (int)(Math.random()*arr.length);
            int j = (int)(Math.random()*arr.length);
            arr[i].setComparable();
            arr[j].setComparable();
            dp.repaint();
            dp.sleep();
            swap(arr, i, j);
        }
    }

    private static boolean isSorted(Value[] arr){
        for(int i = 1; i < arr.length; i++){
            if(arr[i].compareTo(arr[i-1]) < 0){
                return  false;
            }
        }
        return true;
    }

    private static void swap(Value[] arr, int first, int last) {
        Value aux = arr[last];
        arr[last] = arr[first];
        arr[first] = aux;
    }

}
