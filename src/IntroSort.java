public class IntroSort {

    public static void sort(Value[] arr, DrawPanel dp) {
        // limit of processes in the Stack
        int limit = (int) ( Math.floor(Math.log(arr.length)/Math.log(2)));
        sort(arr, 0, arr.length-1, limit, dp);
    }

    public static void sort(Value[] arr, int first, int last, int limit, DrawPanel dp){
        if(last - first > 16){
            if(limit == 0){
                heap(arr, first, last, dp);
                return;
            }
            limit--;
            int piv = pivot(arr, first, first + ((last - first)/2) + 1, last);
            swap(arr, piv, last);
            int partition = partition(arr, first, last, dp);
            // sorts both parts of the partition
            sort(arr, first, partition - 1, limit, dp);
            sort(arr, partition + 1, last, limit, dp);
        }else{
            // if data set is small, does InsertionSort
            insertion(arr, first, last, dp);
        }
    }

    public static void heap(Value[] arr, int first, int last, DrawPanel dp){
        int length = last - first;
        for (int i = length / 2; i >= 1; i--) {
            heapify(arr, i, length, first, dp);
        }
        for (int i = length; i >= 1; i--) {
            arr[first].setComparable();
            arr[first + 1].setComparable();
            dp.repaint();
            dp.sleep();
            swap(arr, first, first+i);
            heapify(arr, 1, i, first, dp);
        }
    }

    public static void heapify(Value[] arr, int i, int length, int first, DrawPanel dp){
        Value temp = arr[first + i - 1];
        int min;
        while (i <= length / 2) {
            min = 2 * i;
            if (min < length && arr[first + min - 1].compareTo(arr[first + min]) < 0)
                min++;
            if (temp.compareTo(arr[first + min - 1]) >= 0)
                break;
            arr[first + i - 1] = arr[first + min - 1];
            i = min;
        }
        arr[first + i - 1] = temp;
    }

    public static int pivot(Value[] arr, int first, int mid, int last){
        int max = Math.max(Math.max(arr[first].getValue(), arr[mid].getValue()), arr[last].getValue());
        int min = Math.min(Math.min(arr[first].getValue(), arr[mid].getValue()), arr[last].getValue());
        int median = max ^ min ^ arr[first].getValue() ^ arr[mid].getValue() ^ arr[last].getValue();
        if (median == arr[first].getValue())
            return first;
        if (median == arr[mid].getValue())
            return mid;
        return last;
    }

    public static int partition(Value[] arr, int first, int last, DrawPanel dp){
        Value piv = arr[last];
        int small = first-1;
        for (int i = first; i < last; i++) {
            if(arr[i].compareTo(piv) <= 0){
                small++;
                arr[i].setComparable();
                arr[small].setComparable();
                dp.repaint();
                dp.sleep();
                swap(arr, small, i);
            }
        }
        arr[small + 1].setComparable();
        arr[last].setComparable();
        dp.repaint();
        dp.sleep();
        swap(arr,small + 1, last);
        return small + 1;
    }

    public static void insertion(Value[] arr, int first, int last, DrawPanel dp){
        for (int i = first + 1; i <= last; i++) {
            Value key = arr[i];
            int j = i - 1;
            while (j >= first && key.compareTo(arr[j]) < 0) {
                arr[j].setComparable();
                dp.repaint();
                dp.sleep();
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static <E> void swap(E[] datos, int i, int j) {
        E aux = datos[j];
        datos[j] = datos[i];
        datos[i] = aux;
    }

}
