import java.util.Scanner;

// Java program for implementation of Selection Sort
class Selection
{
	void sort(int arr[])
	{
		int n = arr.length;

		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n-1; i++)
		{
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i+1; j < n; j++)
				if (arr[j] < arr[min_idx])
					min_idx = j;

			// Swap the found minimum element with the first
			// element
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}

	// Prints the array
	void printArray(int arr[])
	{
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(arr[i]+" ");
		System.out.println();
	}

	// Driver code to test above
	public static void main(String args[])
	{
		Selection ob = new Selection();
		Scanner sc = new Scanner(System.in);
		System.out.println("Emter total eles");
		int g= sc.nextInt();
		System.out.println("Emter eles");
		int arr[] = new int[g];
		for(int i = 0; i<g;i++){
			arr[i] = sc.nextInt();
		}
		ob.sort(arr);
		System.out.println("Sorted array");
		ob.printArray(arr);
	}
}
/* This code is contributed by Rajat Mishra*/
