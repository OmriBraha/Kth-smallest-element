package Tirgul1;


public class KthSmallest {

	public static void swap(int[] a, int i, int j)
	{
	 int temp = a[i];
	 a[i] = a[j];
	 a[j] = temp;
	}
	
	public static int partition(int[] A, int left, int right)
	{
		int pivot = A[right];
		int i = left-1;
		for (int j=left; j<right-1; j++) {
			if (A[j]<=pivot)
			{
				i=i+1;
				swap(A,i,j);
			}
		}
		swap(A,i+1,right);
		return i+1;
	}
	
	public static int kthSmallest(int[]A, int left, int right, int k)
	{
		
		int current = partition(A,left,right);
		if (current==k-1) {
			return A[current];
		}
		if(current>k-1)
		{
			return kthSmallest(A,left,current-1,k);
		}
		else {
			return kthSmallest(A,current+1,right,k);
		}
	}
	
	public static void printArray(int[]A)
	{
		for (int i=0; i<A.length; i++)
		{
			System.out.print(A[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		int array[] = {7,3,18,14,5,19,10,2,11,6}; // sorted: 2,3,5,6,7,10,11,14,18,19
		int n = (array.length - 1);
		System.out.println("The array is: ");
		printArray(array);
		System.out.println("");


		System.out.println("-------------------");
		int k = 5;
		System.out.println("The "+k+"th smallest element is");
		int result = kthSmallest(array,0,n,k);
		System.out.println(result);
		printArray(array);
		
		
	}

}
