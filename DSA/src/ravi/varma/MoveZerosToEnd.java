package ravi.varma;

public class MoveZerosToEnd {

	public static void main(String[] args) {
		int[] arr = {0, 1, 0, 3, 12};
		moveZerosToEnd(arr);
		for(int num : arr) {
			System.out.print(num + " ");
		}

	}
	private static void moveZerosToEnd(int[] arr) {
		int n=arr.length;
		int nonZeroIndex=0;
		for(int i=0;i<n;i++) {
			if(arr[i]!=0) {
				arr[nonZeroIndex++]=arr[i];
			}
		}
		while(nonZeroIndex<n) {
			arr[nonZeroIndex++]=0;
		}
	}

}
