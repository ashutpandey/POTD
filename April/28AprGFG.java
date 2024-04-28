// Delete Middle of Linked List
// https://www.geeksforgeeks.org/problems/delete-middle-of-linked-list/1


class Node {
    int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}


class Solution {
    Node deleteMid(Node head) {
        // This is method only submission.
        // You only need to complete the method
        if(head.next==null)return null;
        Node fast=head;
        Node slow=head;
        Node temp=null;
        while(fast!=null && fast.next!=null){
            temp=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if(temp!=null){
            temp.next=slow.next;
        }
        return head;
    }
}