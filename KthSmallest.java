package Tirgul1;


public class KthSmallest {
	// swap method
	public static void swap(int[] a, int i, int j)
	{
	 int temp = a[i];
	 a[i] = a[j];
	 a[j] = temp;
	}
	
	// Partition 
	public static int partition(int[] A, int left, int right)
	{
		int pivot = A[right]; // Pivot is now the last element in the array
		int i = left-1; // intialize i to be 1 element before the first element of the array
		for (int j=left; j<right-1; j++) { // go over the array and compare pivot with every element 
			if (A[j]<=pivot) // once the pivot is bigger
			{
				i=i+1; 
				swap(A,i,j); // swap the element in index j with the element with index i to orginize the smaller elements ( from the pivot ) at the left side of the array
			}
		}
		swap(A,i+1,right); // relocating the pivot in its right position in the array
		return i+1; // returning the pivot
	}
	
	// Find the kth Smallest element using recursion
	public static int kthSmallest(int[]A, int left, int right, int k)
	{
		
		int current = partition(A,left,right); // use partition to find the pivot
		if (current==k-1) { // trivical case
			return A[current];
		}
		if(current>k-1) // the program will search at the left side of the array
		{
			return kthSmallest(A,left,current-1,k);
		}
		else { // the program will search at the right side of the array
			return kthSmallest(A,current+1,right,k);
		}
	}
	
	// Print Array 
	public static void printArray(int[]A)
	{
		for (int i=0; i<A.length; i++)
		{
			System.out.print(A[i]+" ");
		}
	}
	// main
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
