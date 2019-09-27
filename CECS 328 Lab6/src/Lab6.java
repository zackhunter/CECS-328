import java.util.Scanner;
import java.util.Random;


public class Lab6
{
	static int[] build_MaxHeap(int a[])
	{
		for (int i= a.length/2-1; i >= 0;i--)
		{
			a=max_heapify(a,i);
		}
		return a;
	}
	
	static int [] max_heapify(int a[],int index)
	{
		int right = 2*index + 2;//2
		int left = 2 * index + 1;//1
		int maxVal = index;
		int len = a.length;
		if (left < len && a[maxVal] < a[left])
		{
			maxVal = left;
		}
		if (right < len && a[maxVal] < a[right] )
		{
			maxVal = right; 
		}
		if (maxVal != index)
		{
			int tempVal = a[index];
			a[index] = a[maxVal];
			a[maxVal] = tempVal;
			return max_heapify(a,maxVal);
		}
		return a;
	}
	
	static int[] heap_sort(int a[])
	{
		build_MaxHeap(a);
		for (int i = a.length-1; i >= 0;i--)
		{
			int temp=a[i];
			a[i]=a[0];
			a[0]=temp;
			a=heap(a,i,0);
		}
		return a;
	}
	
	static int [] heap(int a[],int n,int index)
	{
		int right = 2* index + 2;
		int left = 2* index + 1;
		int maxVal=index;
		if (left < n && a[left] > a[maxVal])
		{
			maxVal = left;
		}
		if (right < n && a[right] > a[left])
		{
			maxVal = right;  
		}
		if (maxVal != index)
		{
			int temp = a[index];
			a[index] = a[maxVal];
			a[maxVal] = temp;
			return heap(a,n,maxVal);
		}
		return a;
	}
	
	public static void main( String args[]) throws Exception
	{
		int n;
		int [] a;
		Scanner reader = new Scanner(System.in);
		Random rand = new Random();
		System.out.print("Enter a number : ");
		n = reader.nextInt();
		a = new int[n];
		for(int i = 0; i < n;i++)
		{
			a[i] = rand.nextInt(20001) - 10000;  
		}
		a = heap_sort(a);
		n = 1000;
		int [] b = new int[n];
		long totalTimeH = 0;
		long timeStartedH = 0;
		long timeEndedH = 0;
		for (int i = 0; i < 100; i++)
		{
			for(int j = 0; j < n;j++)
			{
				b[j] = rand.nextInt(20001) - 10000;  
			}
			timeStartedH = System.nanoTime();
			a = heap_sort(b);
			timeEndedH = System.nanoTime();
			totalTimeH += timeEndedH - timeStartedH;
		}
		long averageTimeH = totalTimeH/100;
		System.out.println("The average running time of heap sort is: " + averageTimeH + " nanosecs");
		
		n = 10;
		int [] c = new int[n];
		for(int i = 0; i < n;i++)
		{
			c[i] = rand.nextInt(20001) - 10000;  
		}
		System.out.println("random array : ");
		for(int i = 0; i < n;i++)
		{
			System.out.print(c[i] + " ");
		}
		a = heap_sort(c);
		System.out.println("\nsorted array : ");
		for(int i = 0; i < n;i++)
		{
			System.out.print(c[i] + " ");
		}
		reader.close();
	}
}