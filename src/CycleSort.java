public class CycleSort {

    public static void sort(Value[] arr, DrawPanel dp) {
        for (int i = 0; i <= arr.length - 2; i++) {
            int pos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[i]) < 0){
                    pos++;
                }
            }
            if(pos == i){
                continue;
            }
            while (arr[i].equals(arr[pos])){
                pos++;
            }
            if (pos != i){
                if (dp.isStoped()) {
                    dp.repaint();
                    return;
                }
                arr[pos].setComparable();
                arr[i].setComparable();
                dp.repaint();
                dp.sleep();
                swap(arr, pos, i);
            }
            while (pos != i){
                pos = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j].compareTo(arr[i]) < 0){
                        pos++;
                    }
                }
                if(pos == i){
                    continue;
                }
                while (arr[i].equals(arr[pos])){
                    pos++;
                }
                if (!arr[i].equals(arr[pos])){
                    if (dp.isStoped()) {
                        dp.repaint();
                        return;
                    }
                    arr[pos].setComparable();
                    arr[i].setComparable();
                    dp.repaint();
                    dp.sleep();
                    swap(arr, pos, i);
                }
            }
        }
    }

    private static void swap(Value[] datos, int i, int j) {
        Value aux = datos[j];
        datos[j] = datos[i];
        datos[i] = aux;
    }

}
