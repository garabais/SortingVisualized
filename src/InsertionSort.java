public class InsertionSort {

	public static <E extends Comparable<E>> void sort(E[] arr, DrawPanel dp) {
		for (int i = 1; i < arr.length; i++) {
			E key = arr[i];
			int j = i - 1;
			while (j >= 0 && key.compareTo(arr[j]) < 0) {
				((Value) arr[j]).setComparable();
				dp.repaint();
				dp.sleep();
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}
}
