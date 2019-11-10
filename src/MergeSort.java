import java.lang.reflect.Array;
import java.util.Random;

public class MergeSort {

	public static void sort(Value[] arr, DrawPanel dp) {
		MergeSort.sort(arr, 0, arr.length - 1, dp);
	}

	private static void sort(Value[] arr, int start, int end, DrawPanel dp) {

		if (start < end) {
			MergeSort.sort(arr, start, (start + end) / 2, dp);
			if (dp.isStoped()) {
				dp.repaint();
				return;
			}
			MergeSort.sort(arr,(start + end) / 2 + 1, end, dp);
			if (dp.isStoped()) {
				dp.repaint();
				return;
			}
			MergeSort.merge(arr,start, (start + end) / 2, end, dp);
		}
	}

	@SuppressWarnings("unchecked")
	private static void merge(Value[] arr, int start, int middle ,int end, DrawPanel dp) {

		int l1 = middle - start + 1,
				l2 = end - middle;


		Value[] arr1 = (Value[]) Array.newInstance(arr.getClass().getComponentType(), l1);
		Value[] arr2 = (Value[]) Array.newInstance(arr.getClass().getComponentType(), l2);

//		System.arraycopy(arr, start, arr1, 0, l1);
//		System.arraycopy(arr, middle + 1, arr2, 0, l2);

		for (int i = 0, j = 0; i < l1 || j < l2; ) {
			if (dp.isStoped()) {
				dp.repaint();
				return;
			}
			if (i < l1) {
				arr1[i] = arr[start + i];
				arr[start + i].setComparable();
				i++;
			}

			if (j < l2) {
				arr2[j] = arr[middle + 1 + j];
				arr[middle + 1 + j].setComparable();
				j++;
			}

			dp.repaint();
			dp.sleep();
		}

		int i = start, j = 0, k = 0;

		while (j < l1 && k < l2) {
			if (dp.isStoped()) {
				dp.repaint();
				return;
			}
			if (arr1[j].compareTo(arr2[k]) < 0) {
				arr1[j].setComparable();
				arr[i++] = arr1[j++];
			} else {
				arr2[k].setComparable();
				arr[i++] = arr2[k++];
			}

			dp.repaint();
			dp.sleep();
		}

		while (j < l1) {
			if (dp.isStoped()) {
				dp.repaint();
				return;
			}
			arr1[j].setComparable();
			arr[i++] = arr1[j++];
			dp.repaint();
			dp.sleep();
		}
		while (k < l2) {
			if (dp.isStoped()) {
				dp.repaint();
				return;
			}
			arr2[k].setComparable();
			arr[i++] = arr2[k++];
			dp.repaint();
			dp.sleep();
		}
	}
}