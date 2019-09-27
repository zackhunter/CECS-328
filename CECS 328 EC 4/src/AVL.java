import java.lang.Math;
public class AVL
{
	Node root;	
	int getHeight(Node N) 
	{	
		if (N == null)	
		{
			return 0;	
		}
		else
		{
			return N.height;	
		}
	}	
	Node rotateRight(Node a) 
	{	
		Node b = a.left;	
		Node temp = b.right;	
		b.right = a;	
		a.left = temp;		
		a.height = Math.max(getHeight(a.left), getHeight(a.right)) + 1;	
		b.height = Math.max(getHeight(b.left), getHeight(b.right)) + 1;		
		return b;	
	}
	Node rotateLeft(Node b) 
	{	
		Node a = b.right;	
		Node temp = a.left;
		a.left = b;
		b.right = temp;	
		b.height = Math.max(getHeight(b.left), getHeight(b.right)) + 1;	
		a.height = Math.max(getHeight(a.left), getHeight(a.right)) + 1;		
		return a;	
	}
	int getTheBalance(Node N)
	{	
		if (N == null)	
		{
			return 0;
		}
		else
		{
			return getHeight(N.left) - getHeight(N.right);
		}	
	}
	Node insert(Node node, int key) 
	{
		if (node == null)
		{
			return (new Node(key));
		}
		if (key < node.key)
		{
			node.left = insert(node.left, key);
		}
		else if (key > node.key)
		{
			node.right = insert(node.right, key);
		}
		else
		{
			return node;
		}
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));	
		int balanced = getTheBalance(node);	
		if (balanced > 1 && key < node.left.key)
		{
			return rotateRight(node);
		}
		if (balanced < -1 && key > node.right.key)
		{
			return rotateLeft(node);
		}
		if (balanced > 1 && key > node.left.key) 
		{
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}
		if (balanced < -1 && key < node.right.key) 
		{
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}
		return node;
	}
		
	void print(Node node) 
	{
		if (node != null) 
		{
			System.out.print(node.key + " ");
			print(node.left);
			print(node.right);	
		}	
	}
}