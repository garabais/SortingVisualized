import java.lang.reflect.Array;
import java.util.Random;

public class MergeSort {

	public static <E extends Comparable<E>> void sort(E[] arr, DrawPanel dp) {
		MergeSort.sort(arr, 0, arr.length - 1, dp);
	}

	private static <E extends Comparable<E>> void sort(E[] arr, int start, int end, DrawPanel dp) {

		if (start < end) {
			MergeSort.sort(arr, start, (start + end) / 2, dp);
			MergeSort.sort(arr,(start + end) / 2 + 1, end, dp);

			MergeSort.merge(arr,start, (start + end) / 2, end, dp);
		}
	}

	@SuppressWarnings("unchecked")
	private static <E extends Comparable<E>> void merge(E[] arr, int start, int middle ,int end, DrawPanel dp) {

		int l1 = middle - start + 1,
				l2 = end - middle;


		E[] arr1 = (E[]) Array.newInstance(arr.getClass().getComponentType(), l1);
		E[] arr2 = (E[]) Array.newInstance(arr.getClass().getComponentType(), l2);

//		System.arraycopy(arr, start, arr1, 0, l1);
//		System.arraycopy(arr, middle + 1, arr2, 0, l2);

		for (int i = 0, j = 0; i < l1 || j < l2; ) {
			if (i < l1) {
				arr1[i] = arr[start + i];
				((Value) arr[start + i]).setComparable();
				i++;
			}

			if (j < l2) {
				arr2[j] = arr[middle + 1 + j];
				((Value) arr[middle + 1 + j]).setComparable();
				j++;
			}

			dp.repaint();
			dp.sleep();
		}

		int i = start, j = 0, k = 0;

		while (j < l1 && k < l2) {
			if (arr1[j].compareTo(arr2[k]) < 0) {
				((Value) arr1[j]).setComparable();
				arr[i++] = arr1[j++];
			} else {
				((Value) arr2[k]).setComparable();
				arr[i++] = arr2[k++];
			}

			dp.repaint();
			dp.sleep();
		}

		while (j < l1) {
			((Value) arr1[j]).setComparable();
			arr[i++] = arr1[j++];
			dp.repaint();
			dp.sleep();
		}
		while (k < l2) {
			((Value) arr2[k]).setComparable();
			arr[i++] = arr2[k++];
			dp.repaint();
			dp.sleep();
		}
	}
}