public class CocktailSort {

    public static void sort(Value[] arr, DrawPanel dp) {
        boolean change = true;
        int first = 0,
            last = arr.length;
        while (change){
            change = false;
            for(int i = first; i < last - 1; i++) {
                if (dp.isStoped()) {
                    dp.repaint();
                    return;
                }
                arr[i].setComparable();
                dp.repaint();
                dp.sleep();
                if(arr[i].compareTo(arr[i+1]) > 0) {
                    change = true;
                    swap(arr, i, i+1);
                }
            }
            if(change = false){
                break;
            }
            change = false;
            last--;
            for (int i = last - 1; i >= first; i--) {
                if (dp.isStoped()) {
                    dp.repaint();
                    return;
                }
                arr[i].setComparable();
                dp.repaint();
                dp.sleep();
                if(arr[i].compareTo(arr[i+1]) > 0) {
                    change = true;
                    swap(arr, i, i+1);
                }
            }
            first++;
        }
    }

    private static <E> void swap(E[] datos, int i, int j) {
        E aux = datos[j];
        datos[j] = datos[i];
        datos[i] = aux;
    }

}
