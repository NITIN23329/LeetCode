class Solution {
	public ListNode sortList(ListNode head) {
	if(head==null || head.next==null)return head;
		ListNode slow=head,fast=head;
		while(fast.next!=null && fast.next.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		ListNode right=slow.next;
		slow.next=null;
		head = sortList(head);
		right = sortList(right);
		return merge(head,right);
	}
	private ListNode merge(ListNode left , ListNode right){
		if(left.val>right.val){
			ListNode temp = left;
			left=right;
			right=temp;
		}
		ListNode head=left;
		ListNode prev=left;
		ListNode curr = left.next;
		 while(right!=null && curr!=null){
			 if(curr.val<=right.val){
				 prev=curr;
				 curr=curr.next;
			 }else{
				 prev.next = right;
				 ListNode temp=right.next;
				 right.next = curr;
				 right=temp;
				 prev=prev.next;
			 }
		 }
		if(right!=null)prev.next=right;
		return head;
	}
}
