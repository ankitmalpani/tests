package linkedlist;

import java.util.Stack;

public class Reverse {
	
	public static void main(String [] args){
		int [] input = new int []{-1,-2,1,2,3,4,5,6,7};
		reverseArrayStack(input);
		for(int n : input){
			System.out.println(n);
		}
	}
	
	//1 2 3 4 5 time: O(n), constant extra space with temp variable
	private static void reverseArray(int [] input){
		int forwardIter = 0;
		for(int i = input.length -1 ; i >= input.length/2; i--){
			if(input[forwardIter] != input[i]){
				int temp = input[forwardIter];
				input[forwardIter] = input[i];
				input[i] = temp;
				forwardIter++;
			}
		}
	}
	
	//O(n) (2 passses - so 2n), space: O(n) for stack
	private static Stack<Integer> rStack = new Stack<Integer>();
	private static void reverseArrayStack(int [] input){
		for(int n : input){
			rStack.push(n);
		}
		int forwardIter = 0;
		while(!rStack.isEmpty()){
			input[forwardIter++] = rStack.pop();
		}
	}
	
	//1-2-3-4
	private static void reverseRecursiveSinglyLinkedList(Node start, Node prev){
		if(start == null || start.next == null) return;
		else{
			Node next = start.next;
			start.next = prev;
			reverseRecursiveSinglyLinkedList(next,start);
			
		}
	}
	
	private static void reverseList(Node head){
		if(head == null || head.next == null) return;
		else{
			Node prev = null;
			Node curr = head;
			while(curr != null){
				Node next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
			}
			
		}
	}
	
	public class Node{
		int data;
		Node next;
	}

}
