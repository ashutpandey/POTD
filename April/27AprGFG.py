#Merge Sort on Doubly Linked List
# https://www.geeksforgeeks.org/problems/merge-sort-on-doubly-linked-list/1
class Node:
	def __init__(self, data):
		self.data = data
		self.next = None
		self.prev = None


class Solution():
#Function to sort the given doubly linked list using Merge Sort.
        def merge(self, first, second):
            if not first :
                return second
            if not second :
                return first
    
            if first.data < second.data:
                first.next = self.merge(first.next, second)
                if first.next is not None:
                    first.next.prev = first
                first.prev = None
                return first
            else:
                second.next = self.merge(first, second.next)
                if second.next is not None:
                    second.next.prev = second
                second.prev = None
                return second

        def mergeSort(self, tempHead):
            if not tempHead  or not tempHead.next:
                return tempHead
    
            second = self.split(tempHead)
    
            tempHead = self.mergeSort(tempHead)
            second = self.mergeSort(second)
    
            return self.merge(tempHead, second)
    
        def split(self, tempHead):
            fast = slow = tempHead
            while fast.next  and fast.next.next:
                fast = fast.next.next
                slow = slow.next
            temp = slow.next
            slow.next = None
            return temp
    
        def sortDoubly(self, head):
            if head is None or head.next is None:
                return head
            second = self.split(head)
            head = self.mergeSort(head)
            second = self.mergeSort(second)
            return self.merge(head, second)