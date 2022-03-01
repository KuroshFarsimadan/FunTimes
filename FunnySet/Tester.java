package FunnySet;

public class Tester {

	public static void main(String[] args) {
		findMissingNumber();
		twoIntegerEquals(7);
		binaryTraversal();
	}

	boolean isBinaryTree(Node node) {
		if (node == null)
			return true;

		if (node.left != null && node.left.data > node.data)
			return false;

		if (node.right != null && node.right.data < node.data)
			return false;

		if (!isBinaryTree(node.left) || !isBinaryTree(node.right))
			return false;

		return true;
	}

	public static void binaryTraversal() {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Level order traversal of binary tree is ");
		tree.printLevelOrder();
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(-1);
		ListNode p = result;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				p.next = l1;
				l1 = l1.next;
			}

			else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		if (l1 == null) {
			p.next = l2;
		}

		else if (l2 == null) {
			p.next = l1;
		}

		return result.next;
	}

	static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	static void mergeTwoLinkedLists() {
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(3);
		head1.next.next = new ListNode(5);
		ListNode head2 = new ListNode(0);
		head2.next = new ListNode(2);
		head2.next.next = new ListNode(4);
		ListNode mergedhead = mergeTwoLists(head1, head2);

		printList(mergedhead);
	}

	static void twoIntegerEquals(int val) {
		int intArray[] = { 5, 7, 1, 2, 8, 4, 3 };
		for (int i = 0; i < intArray.length; i++) {
			for (int b = 0; b < intArray.length; b++) {
				if ((intArray[i] + intArray[b]) == val) {
					System.out.println(intArray[i] + "+" + intArray[b] + "=" + val);
				}
			}
		}

	}

	static void findMissingNumber() {
		int intArray[] = { 3, 7, 1, 2, 8, 4, 5 };

		intArray = sorting(intArray);
		int missingNum = search(intArray, intArray.length);
		System.out.println(missingNum);
	}

	static int search(int ar[], int size) {
		int a = 0, b = size - 1;
		int mid = 0;
		while ((b - a) > 1) {
			mid = (a + b) / 2;
			if ((ar[a] - a) != (ar[mid] - mid))
				b = mid;
			else if ((ar[b] - b) != (ar[mid] - mid))
				a = mid;
		}
		return (ar[a] + 1);
	}

	static int[] sorting(int[] array) {
		int n = array.length;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (array[j - 1] > array[j]) {
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}

			}
		}
		return array;
	}

}
