import java.util.Scanner;
public class test
{
	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		AVL tree = new AVL();	
		for (int i =0; i < 6; i++)
		{
			int n;
			System.out.println("Please enter a random number: ");
			n = reader.nextInt();
			tree.root = tree.insert(tree.root, n);
		}
		tree.print(tree.root);	
		reader.close();
	}
}