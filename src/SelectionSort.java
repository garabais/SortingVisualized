import java.awt.*;

public class SelectionSort {

	public static <E extends Comparable<E>> void sort(E[] arr, DrawPanel dp) {
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i+1; j < arr.length; j++) {
				((Value) arr[j]).setComparable();
				((Value) arr[min]).setComparable();
				dp.repaint();
				dp.sleep();
				if(arr[min].compareTo(arr[j]) > 0 ){
					((Value) arr[min]).setColor(Color.WHITE);
					min = j;
				}
				//min = arr[min].compareTo(arr[j]) < 0 ? min : j;
			}
			((Value) arr[min]).setColor(Color.WHITE);
			swap(arr, i, min);
		}
	}
	
	private static <E> void swap(E[] datos, int first, int last) {
		E aux = datos[last];
		datos[last] = datos[first];
		datos[first] = aux;
	}
	
}
