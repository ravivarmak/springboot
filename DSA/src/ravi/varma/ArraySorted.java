package ravi.varma;

public class ArraySorted {

	public static void main(String[] args) {
		int[] a= {1,2,3,4,5,7,6};
		System.out.println(isSorted(a));
	}
	private static boolean isSorted(int[] a) {
		for(int i=0;i<a.length-1;i++) {
			if(a[i]>a[i+1]) {
				return false;
			}
		}
		return true;
	}

	private static void reverse(int[] a) {
		int start=0;
		int end=a.length-1;
		while(start<end) {
			int temp=a[start];
			a[start]=a[end];
			a[end]=temp;
			start++;
			end--;
		}
		
	}
}
