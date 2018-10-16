public class ReverseLinkedList {
	
	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ListNode curr = reverseList(head);

		while (curr != null) {
			System.out.print( curr.val + " -> ");
			curr = curr.next;
		}

		System.out.println(curr);
	}

	public static ListNode reverseList(ListNode head) {

		if (head == null) return null;

		ListNode prev = head;
		ListNode curr = head.next;
		ListNode next;

		prev.next = null;

		while (curr != null) {
			next = curr.next;

			curr.next = prev;

			prev = curr;
			curr = next;
		}

		return prev;
	}
}