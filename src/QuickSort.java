public class QuickSort {

	public static <E extends Comparable<E>> void sort(E[] arr, DrawPanel dp){
		sort(arr, 0, arr.length -1, dp);
	}

	private static <E extends Comparable<E>> void sort(E[] arr, int min, int max, DrawPanel dp) {

		if(min < max) {
			int p = partition(arr, min, max, dp);

			sort(arr, min, p -1, dp);
			sort(arr, p + 1, max, dp);
		}
	}

	private static <E extends Comparable<E>> int partition(E[] arr, int min, int max, DrawPanel dp) {

		E pivot = arr[min];
		int i = min + 1;

		for (int j = min + 1; j <= max; j++) {
			((Value) arr[j]).setComparable();
			dp.repaint();
			dp.sleep();
			if (arr[j].compareTo(pivot) <= 0) {

				swap(arr, i++, j);

			}
		}

		swap(arr, min, i - 1);

		return i -1;

	}

	private static <E> void swap(E[] arr, int i, int j) {
		E temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
