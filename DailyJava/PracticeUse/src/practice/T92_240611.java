package practice;

public class T92_240611 {

	public class ListNode {
		int	 value;
		ListNode	 next;

		public ListNode(){};
		public ListNode(int value){
			this.value = value;
		}
		public ListNode(int value, ListNode next){
			this.value = value;
			this.next = next;
		}
	}

	public class Solution {
		
		public ListNode reverseBetween1(ListNode head, int left, int right){
			ListNode dummy = new ListNode(0, head);
			ListNode prev = dummy;
			for(int i = 0; i < left - 1; i ++){
				prev = prev.next;
			}
			ListNode cur = prev.next;
			ListNode reverseHead = prev, reverseTail = cur;
			for(int i = 0; i < right - left; i ++){
				ListNode next = cur.next;
				cur.next = prev;
				prev = cur;
				cur = next;
			}
			// 这里cur到了反转边界之外；prev到了反转的最后一个节点，也就是头
			reverseHead.next = prev;
			reverseTail.next = cur;
			return dummy.next;
		}

		public ListNode reverseBetween(ListNode head, int left, int right){
			ListNode dummy = new ListNode(0, head);
			ListNode revePrev = dummy;
			for(int i = 0; i < left - 1; i ++){
				revePrev = revePrev.next;
			}
			ListNode cur = revePrev.next;
			for(int i = 0; i < right - left; i ++){
				ListNode next = cur.next;
				cur.next = next.next;
				next.next = revePrev.next;
				revePrev.next = next;
			}
			return dummy.next;
		}
	}

}
