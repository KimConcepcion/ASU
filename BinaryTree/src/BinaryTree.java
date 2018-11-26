
public class BinaryTree {
	
	//	Starting node:
	Node root;
	
	//	Recursive inserting method:
	private Node addRecursive(Node current, String name) {
		
		if(current == null) {
			return new Node(name);
		}
		
		if(name.length() < current.name.length()) {
			current.left = addRecursive(current.left, name);
		}
		
		else if(name.length() > current.name.length()) {
			current.right = addRecursive(current.right, name);
		}
		
		else {
			System.out.println("The name already exists!");
			return current;
		}
		
		return current;
	}
	
	//	Start recursion from root (The way we sort)
	public Node add(String name) {
		return root = addRecursive(root, name);
	}
	
	//	Find method:
	private boolean containsNodeRecursive(Node current, String name) {
		
		//	Does not exist in tree:
		if(current == null) {
			System.out.println(name + " not found!");
			return false;
		}
		
		
		if(name.equals(current.name) == true) {
			System.out.println(name + " found!");
			return true;
		}
		
		return name.length() < current.name.length()
				? containsNodeRecursive(current.left, name)
				: containsNodeRecursive(current.right, name);
	}
	
	public boolean containsNode(String name) {
		return containsNodeRecursive(root, name);
	}
	
	//	Recursive deletion method:
	private Node deleteRecursive(Node current, String name) {
		
		if(current == null) {
			return null;
		}
		
		//	Delete if the node was found:
		if(name.equals(current.name) == true) {
			
			//	If node has no children:
			if(current.left == null && current.right == null) {
				return null;
			}
			
			//	The node has one child:
			if(current.left == null) {
				return current.left;
			}
			
			if(current.right == null) {
				return current.right;
			}
			
			//	The node has two children:
			String smallestValue = findSmallestValue(current.right);
			current.name = smallestValue;
			current.right = deleteRecursive(current.right, smallestValue);
			return current;
		}
		
		if(name.length() < current.name.length()) {
			current.left = deleteRecursive(current.left, name);
			return current;
		}
		
		current.right = deleteRecursive(current.right, name);
		return current;
	}
	
	//	Method for finding smallest value:
	private String findSmallestValue(Node root) {
		
		if(root.left == null) {
			return root.name;
		}
		
		else {
			return findSmallestValue(root.left);
		}
	}
	
	//	Delete method:
	public void delete(String name) {
		System.out.println("Deleting: " + name);
		root = deleteRecursive(root, name);
	}
	
	//	traverse tree in pre order method:
	public void traversePreOrder(Node node) {
		if(node != null) {
			System.out.print(node.name + " ");
			traversePreOrder(node.left);
			traversePreOrder(node.right);
		}
	}
}
