public class RadixSort {

	public static Value getMax(Value[] arr) {
		Value max = arr[0];
		for(Value data : arr) {
			max = data.compareTo(max) > 0 ? data : max;
		}
		return max;
	}

	public static void count(Value[] arr, int exp, DrawPanel dp) {
		Value[] aux =  new Value[arr.length];
		int[] count = new int[10];
		// Store the amount of occurrences in count[]
		for (int i = 0; i < arr.length; i++) {
			if (dp.isStoped()) {
				dp.repaint();
				return;
			}
			arr[i].setComparable();
			dp.repaint();
			dp.sleep();
			count[(arr[i].getValue() / exp) % 10]++;
		}
		//Changes count[i] to its correspondent position of digits in output[]
		for (int i = 1; i < 10; i++) {
			count[i] += count[i-1];
		}
		//Create aux array
		for (int i = arr.length-1; i >= 0; i--) {
			aux[count[(arr[i].getValue() / exp)%10]-1] = arr[i];
			count[(arr[i].getValue() / exp)%10]--;
		}
		//Copying aux[] in arr[]
		for (int i = 0; i < arr.length; i++){
			if (dp.isStoped()) {
				dp.repaint();
				return;
			}
			aux[i].setComparable();
			dp.repaint();
			dp.sleep();
			arr[i] = aux[i];
		}
	}

	public static void sort(Value[] arr, DrawPanel dp){
		//Get maximun value to know nimber of digits
		int max = getMax(arr).getValue();
		//Sorting for every digit
		for(int exp = 1; max /exp > 0; exp *= 10){
			count(arr,exp,dp);
		}
	}

}
