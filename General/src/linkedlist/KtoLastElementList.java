package linkedlist;

public class KtoLastElementList {
	
	private static Node kthToLast(Node head, int k){
		if(head == null) return null;
		Node first = head;
		Node second = head;
		int counter = k;
		while(counter > 0 ){
			if(!(second.next == null))
				second = second.next;
			else
				return second; //k is greater than length of list
			counter--;
		}
		
		while(second.next != null){
			second = second.next;
			first = first.next;
		}
		return first;
		
	}
	
	
	public class Node{
		int data;
		Node next;
	}

}
