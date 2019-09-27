
import java.util.Scanner;
import java.util.Random;
public class Lab3
{
	public static void quick_sort(int[] a, int lower, int higher)
	{
		if (lower < higher)
		{
			int pivot = a[higher];
			int x = (lower - 1);
			for (int i=lower; i<higher; i++)
			{
				if (a[i] <= pivot)
				{
					x++;
					int temp = a[x];
					a[x] = a[i];
					a[i] = temp;
				}
			}
			int temp = a[x + 1];
			a[x + 1] = a[higher];
			a[higher] = temp;
			int pivotIndex= x + 1;
			quick_sort(a, lower, pivotIndex - 1);
			quick_sort(a, pivotIndex + 1, higher);
		}
	}
	public static void insertion_sort(int[] a)
	{
		int n = a.length;
		for (int i=1; i<n; ++i)
		{
			int key = a[i];
			int j = i - 1;
			while (j>=0 && a[j] > key)
			{
				a[j + 1] = a[j];
				j = j - 1;
			}
			a[j + 1] = key;
		}
	}
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter n : ");
		int n = scanner.nextInt();
		int insertArray[] = new int[n];
		Random rand = new Random();
		for (int i=0; i<n; i++)
		{
			insertArray[i] = rand.nextInt(10000) + 1-5000;
		}
		int quickArray[] = new int[n];
		for (int i=0; i<n; i++)
		{
			quickArray[i] = insertArray[i];
		}
		long timeStartedI = System.nanoTime();
		for (int i=0;i<100;i++)
		{
			insertion_sort(insertArray);
		}
		long timeEndedI = System.nanoTime();
		long averageTimeI = (timeEndedI - timeStartedI)/100;
		System.out.println("Average time for intersertion sort: " + averageTimeI + " nanosecs");
		long timeStartedQ = System.nanoTime();
		for (int i=0;i<100;i++)
		{
			quick_sort(quickArray,0,n-1);
		}
		long timeEndedQ = System.nanoTime();
		long averageTimeQ = (timeEndedQ - timeStartedQ)/100;
		System.out.println("Average time for quick sort: " + averageTimeQ + " nanosecs");
		long instructionsPerSec = averageTimeI*n*n/1000000000;
		System.out.println("Using insertion sort, the amount of instructions per second would be: " + instructionsPerSec);
		scanner.close();
	}
}