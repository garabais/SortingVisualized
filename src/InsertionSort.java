public class InsertionSort {

	public static void sort(Value[] arr, DrawPanel dp) {
		for (int i = 1; i < arr.length; i++) {
			Value key = arr[i];
			int j = i - 1;
			while (j >= 0 && key.compareTo(arr[j]) < 0) {
				if (dp.isStoped()) {
					dp.repaint();
					return;
				}
				arr[j].setComparable();
				dp.repaint();
				dp.sleep();
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}
}
