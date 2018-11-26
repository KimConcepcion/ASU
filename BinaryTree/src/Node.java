
public class Node {
	
	//	Each node contains a name, left and right links:
	String name;
	Node left;
	Node right;
	
	//	Constructor:
	Node(String name){
		this.name = name;
		//	Positions is initialized as null:
		left = null;
		right = null;
	}
}