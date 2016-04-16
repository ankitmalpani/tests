package linkedlist;

public class Reversal {
	
	public static void main(String [] args){
		Reversal rev = new Reversal();
		Node first = rev.new Node(1);
		Node second = rev.new Node(2);
		Node third = rev.new Node(3);
		Node fourth = rev.new Node(4);
		third.setNext(fourth);
		second.setNext(third);
		first.setNext(second);
		printList(first);
		printList(fourth);
		reverseNoStack(first);
		printList(fourth);
		printList(first);
	}
	
	public static void printList(Node head){
		StringBuilder b = new StringBuilder();
		while(head != null){
			b.append(head.getData()+"-");
			head = head.next;
		}
		System.out.println(b);
	}
	
	// 1-2-3-4 should return //4-3-2-1
	public static void reverseNoStack(Node head){
		if(head == null ) return;
		if(head.next == null) return;
		Node curr = head;
		Node next = head.next;
		curr.next = null;
		reverse(curr,next);
	}
	
	public static void reverse(Node curr, Node next){
		if(next == null) return;
		Node nextNext = next.next;
		next.next = curr;
		reverse(next,nextNext);
	}
	
	public class Node{
		int data;
		Node next;
		
		public Node(int data){
			this.data = data;
		}
		
		public Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
		
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}		
	}

}
