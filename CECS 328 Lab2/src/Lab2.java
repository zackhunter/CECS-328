import java.util.Scanner;


public class Lab2
{
	public static void main(String[] args)
	{
		//Question 1
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter an int: ");
		int n = reader.nextInt();
		/*
		int check = n;
		while (check*check!=n)
		{
			check--;
			if(check*check < n)
			{
				check++;
				break;
			}
		}
		*/
		int mid = n/2;
		while (mid*mid !=n)
		{
			if (mid*mid > n)
			{
				if (mid*mid > n && (mid-1)*(mid-1) < n)
				{
					break;
				}
				mid = mid-1;
			}
			else
			{
				mid = mid+1;
			}
		}
		
		System.out.println("The square root of " + n + " is " + mid); 
		
		//Question 2
		System.out.println("Enter a random binary number: ");
		String binary = reader.next();
		int bArray[] = new int[binary.length()];
		for(int i = 0; i  < binary.length();i++)
		{
			char c = binary.charAt(i);
			bArray[i] = Character.getNumericValue(c);
		}
		/*
		int k=0;
		for (int i = 1;i < bArray.length; i++)
		{
			if (bArray[i-1]!=bArray[i])
			{
				k = i;
				break;
			}
		}*/
		int k = bArray.length/2;
		System.out.println("The position of K is " + bBinary(k,bArray));
		
		reader.close();
	}
	public static int bBinary(int k, int a[])
	{
		boolean looping = true;
		while(looping)
		{
			if (k+1 != k)
			{
				return k;
			}
			if(k-1 != k)
			{
				return k-1;
			}
		}
		if (k != 0)
		{
			return bBinary(k-1,a);
		}
		else
		{
			return bBinary(k+1,a);
		}
	}
}
