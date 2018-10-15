import java.util.*;

public class TreeTraversal {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode temp = new TreeNode(3);
		root.left = temp;
		temp = new TreeNode(9);
		root.right = temp;
		temp = new TreeNode(1);
		root.right.left = temp;
		temp = new TreeNode(4);
		root.right.right = temp;

		List<Integer> recursiveInorder = new ArrayList<Integer>();
		List<Integer> iterativeInorder = new ArrayList<Integer>();
		List<Integer> recursivePreorder = new ArrayList<Integer>();
		List<Integer> iterativePreorder = new ArrayList<Integer>();
		List<Integer> recursivePostorder = new ArrayList<Integer>();
		List<Integer> iterativePostorder = new ArrayList<Integer>();

		recursiveInorder(root, recursiveInorder);
		iterativeInorder(root, iterativeInorder);
		recursivePreorder(root, recursivePreorder);
		iterativePreorder(root, iterativePreorder);
		recursivePostorder(root, recursivePostorder);
		iterativePostorder(root, iterativePostorder);

		System.out.println("recursiveInorder");
		for (int num : recursiveInorder) {
			System.out.print(num + " ");
		}
		System.out.println();

		System.out.println("iterativeInorder");
		for (int num : iterativeInorder) {
			System.out.print(num + " ");
		}
		System.out.println();

		System.out.println("recursivePreorder");
		for (int num : recursivePreorder) {
			System.out.print(num + " ");
		}
		System.out.println();

		System.out.println("iterativePreorder");
		for (int num : iterativePreorder) {
			System.out.print(num + " ");
		}
		System.out.println();

		System.out.println("recursivePostorder");
		for (int num : recursivePostorder) {
			System.out.print(num + " ");
		}
		System.out.println();

		System.out.println("iterativePostorder");
		for (int num : iterativePostorder) {
			System.out.print(num + " ");
		}
		System.out.println();

	}

	public static void recursiveInorder(TreeNode root, List<Integer> traversal) {

		if (root == null) return;

		//left
		recursiveInorder(root.left, traversal);

		//root
		traversal.add(root.val);

		//right
		recursiveInorder(root.right, traversal);
	}

	public static void iterativeInorder(TreeNode root, List<Integer> traversal) {

		if (root == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack();
		TreeNode curr = root;

		while (!stack.isEmpty() || curr != null) {

			while (curr != null) {

				stack.push(curr);
				curr = curr.left;
			}

			curr = stack.pop();

			traversal.add(curr.val);

			curr = curr.right;
		}
	}

	public static void recursivePreorder(TreeNode root, List<Integer> traversal) {

		if (root == null) return;

		//root
		traversal.add(root.val);

		//left
		recursivePreorder(root.left, traversal);

		//right
		recursivePreorder(root.right, traversal);
	}

	public static void iterativePreorder(TreeNode root, List<Integer> traversal) {

		if (root == null) return;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while (!stack.isEmpty()) {
			root = stack.pop();

			//root
			if (root == null) continue;
			traversal.add(root.val);

			//right underneath the left on the stack
			stack.push(root.right);

			//left above the right on the stack
			stack.push(root.left);
		}
	}

	public static void recursivePostorder(TreeNode root, List<Integer> traversal) {

		if (root == null) return;

		//left
		recursivePostorder(root.left, traversal);

		//right
		recursivePostorder(root.right, traversal);

		//root
		traversal.add(root.val);
	}

	public static void iterativePostorder(TreeNode root, List<Integer> traversal) {

		if (root == null) return;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		TreeNode next;

		while(!stack.isEmpty()) {

			next = stack.peek();

			boolean finishedSubtrees = (next.right == root || next.left == root);
			boolean isLeaf = (next.left == null && next.right == null);

			if (finishedSubtrees || isLeaf) {

			  stack.pop();
			  traversal.add(next.val);
			  root = next;
			}
			else {

			  if (next.right != null) {
			    stack.push(next.right);
			  }
			  
			  if (next.left != null) {
			    stack.push(next.left);
			  }
			}
		}
	}
}