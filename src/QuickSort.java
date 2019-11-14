public class QuickSort {

	public static void sort(Value[] arr, DrawPanel dp){
		sort(arr, 0, arr.length -1, dp);
	}

	private static void sort(Value[] arr, int min, int max, DrawPanel dp) {

		if(min < max) {
			int p = partition(arr, min, max, dp);
			sort(arr, min, p -1, dp);
			if (dp.isStoped()) {
				dp.repaint();
				return;
			}
			sort(arr, p + 1, max, dp);
			if (dp.isStoped()) {
				dp.repaint();
				return;
			}
		}
	}

	private static int partition(Value[] arr, int min, int max, DrawPanel dp) {

		Value pivot = arr[min];
		int i = min + 1;

		for (int j = min + 1; j <= max; j++) {
			if (dp.isStoped()) {
				dp.repaint();
				return i - 1;
			}
			arr[j].setComparable();
			dp.repaint();
			dp.sleep();
			if (arr[j].compareTo(pivot) <= 0) {
				swap(arr, i++, j);
			}
		}
		swap(arr, min, i - 1);
		return i -1;
	}

	private static void swap(Value[] arr, int i, int j) {
		Value temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
