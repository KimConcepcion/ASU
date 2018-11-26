
public class TestBinaryTree {

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();

		Node n = bt.add("Kim");
		bt.add("Ciri");
		bt.add("Lambert");
		bt.add("Eskel");
		bt.add("Geralt");

		//	Print tree in pre order:
		bt.traversePreOrder(n);
		System.out.print("\n");

		// Test find method:
		bt.containsNode("Emhyr");

		// Delete a node:
		bt.containsNode("Kim");
		bt.delete("Kim");
		bt.containsNode("Kim");
	}
}