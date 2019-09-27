import java.util.Scanner;
import java.util.Random;

public class lab4
{
	public static int quick_select_max(int[] a,int key, int right, int left)
	{
		if (key > 0)// && key <= right-left+1)
		{
			int x = a[right]; 
			int pivot = left;
			for (int i = left; i <= right- 1; i++) 
			{
				if (a[i] >= x) 
				{
					int temp = a[pivot];
					a[pivot] = a[i];
					a[i] = temp;
					pivot++;
				}
				System.out.println(pivot);
			}
			int temp = a[pivot];
			a[pivot] = a[right];
			a[right] = temp;
			int z = pivot-left;
			int y = key-1;
			//if (z == y)
			if(key==pivot)
			{
				return a[pivot];
			}
			//if (z > y)
			else if(key>pivot)
			{
				return quick_select(a, key, pivot-1, left);
			}
			else
			{
				key = key - pivot + left - 1;
				return quick_select(a,key, right, pivot + 1);
			}	
		}
		else
		{
			return 0;
		}	
	}
	public static int quick_select(int[] a,int key, int right, int left)
	{
		if (key > 0 && key <= right-left+1)
		{
			int x = a[right]; 
			int pivot = left;
			for (int i = left; i <= right- 1; i++) 
			{
				if (a[i] <= x) 
				{
					int temp = a[pivot];
					a[pivot] = a[i];
					a[i] = temp; 
					pivot++;
				}
			}
			int temp = a[pivot];
			a[pivot] = a[right];
			a[right] = temp;
			int z = pivot-left;
			int y = key-1;
			if (z == y)
			{
				return a[pivot];
			}
			if (z > y)
			{
				return quick_select(a, key, pivot-1, left);
			}
			key = key - pivot + left - 1;
			return quick_select(a,key, right, pivot + 1);
		}
		return 0;
	}
	public static void main(String[] args)
	{	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter n: ");
		int n = scanner.nextInt();
		int a[] = new int[n];
		Random rand = new Random();
		for (int i=0; i<n; i++)
		{
			a[i] = rand.nextInt(200) - 99;
		}
		for (int i=0; i<n; i++)
		{
			System.out.println(a[i]);
		}
		System.out.println("Enter a number between 1 and n: ");
		int k = scanner.nextInt();
		System.out.println(quick_select(a,k,n-1,0));
		scanner.close();
	}
}
