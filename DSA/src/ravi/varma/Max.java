package ravi.varma;

public class Max {

	public static void main(String[] args) {
		System.out.println(findMax(new int[] {1, 2,100, 3, 4, 5}));
		System.out.println(findSecondLargest(new int[] {5,4,5}));
		
	}
	public static int findMax(int[] arr) {
		int max=arr[0];
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		return max;
	}
	public static int findSecondLargest(int[] a) {
		if(a==null||a.length<2 ) {
			return -1;
		}
		int first=Integer.MIN_VALUE;
		int second=Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++) {
			if(a[i]>first) {
second=first;
first=a[i];
				
			}
			else if(a[i]>second &&a[i]!=first) {
				second=a[i];
			}
		}
		return second;
		
	}

}
