import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class Lab5
{
	public static void swap(int[] a, int x, int y)
	{
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	public static int quickSelect(int[] a, int p, int l, int r)
	{
		if (l == p && l == r)
		{
			return a[l];
		}
		int pivot = a[l];
		int pos = l;
		for (int i=1+l; i < r+1; i++)
		{
			if (a[i] <= pivot)
			{
				pos++;
				swap(a, i, pos);
			}
		}
		swap(a, l, pos);
		if (pos==p)
		{
			return a[pos];
		}
		else if (pos>p)
		{
			return quickSelect(a, p, l,pos-1);
		}
		else
		{
			return quickSelect(a, p,pos+1, r);
		}
		
	}
	public static void main(String[] s)
	{
		Random rand = new Random();
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter a positive int: ");
		int n = reader.nextInt();
		int array[] = new int[n];
		for (int i = 0; i < n; i++)
		{
			array[i] = rand.nextInt(200)-100+1; 
		}
		for (int i = 0; i<n;i++)
		{
			System.out.println(array[i]);
		}
		System.out.println("enter a number from 1 to " + n + ": ");
		int k = reader.nextInt();
		int position = array.length/2;
		int med = quickSelect(array, position, 0, array.length - 1);														
		int diff[] = new int[n];
		for (int i = 0; i<n; i++)
		{
			diff[i] = Math.abs(array[i]-med);
		}
		int kClosestNumbers[] = new int[k];
		for (int i = 0; i < k; i++)
		{
			kClosestNumbers[i] = quickSelect(diff, i, 0, diff.length - 1);
		} 
		
		System.out.println("test");
		for (int i = 0; i < k; i++)
		{
			System.out.println(diff[i]);
		}
		boolean x = true;
		for (int i = 0; i < k; i++)
		{
			System.out.println("s");
			for (int j = 0; j < n; j++)
			{
				if (med - kClosestNumbers[i] == array[j])
				{
					System.out.println(kClosestNumbers[i] + "-");
					kClosestNumbers[i] = med - kClosestNumbers[i];
					x = false;
				}
				if (j == n-1 && x)
				{
					kClosestNumbers[i] = kClosestNumbers[i]+med;
				}
			}
			x = true;
		}
		System.out.println("Answer: ");
		for (int i = 0; i < k; i++)
		{
			System.out.println(kClosestNumbers[i]);
		}
		reader.close();
	}

}