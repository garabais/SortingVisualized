import java.awt.*;

public class SelectionSort {

	public static void sort(Value[] arr, DrawPanel dp) {
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i+1; j < arr.length; j++) {
				if (dp.isStoped()) {
					dp.repaint();
					return;
				}
				arr[j].setComparable();
				arr[min].setComparable();
				dp.repaint();
				dp.sleep();
				if(arr[min].compareTo(arr[j]) > 0 ){
					arr[min].setColor(Color.WHITE);
					min = j;
				}
				//min = arr[min].compareTo(arr[j]) < 0 ? min : j;
			}
			arr[min].setColor(Color.WHITE);
			swap(arr, i, min);
		}
	}
	
	private static <E> void swap(E[] datos, int first, int last) {
		E aux = datos[last];
		datos[last] = datos[first];
		datos[first] = aux;
	}
	
}
