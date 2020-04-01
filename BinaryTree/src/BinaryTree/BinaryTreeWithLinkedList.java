package BinaryTree;
//Java program to create complete Binary Tree from its Linked List
//representation

//importing necessary classes
import java.util.*;

//A linked list node
class ListNode 
{
 int data;
 ListNode next;
 ListNode(int d)
 {
     data = d;
     next = null;
 }
}

//A binary tree node
class BinaryTreeNode 
{
 int data;
 BinaryTreeNode left, right = null;
 BinaryTreeNode(int data)
 {
     this.data = data;
     left = right = null;
 }
}

class BinaryTree 
{
 ListNode head;
 BinaryTreeNode root;

 // Function to insert a node at the beginning of
 // the Linked List
 void push(int new_data) 
 {
     // allocate node and assign data
     ListNode new_node = new ListNode(new_data);

     // link the old list off the new node
     new_node.next = head;

     // move the head to point to the new node
     head = new_node;
 }

 // converts a given linked list representing a 
 // complete binary tree into the linked 
 // representation of binary tree.
 BinaryTreeNode convertList2Binary(BinaryTreeNode node) 
 {
     // queue to store the parent nodes
     Queue<BinaryTreeNode> q = 
                    new LinkedList<BinaryTreeNode>();

     // Base Case
     if (head == null) 
     {
         node = null; 
         return null;
     }

     // 1.) The first node is always the root node, and
     //     add it to the queue
     node = new BinaryTreeNode(head.data);
     q.add(node);

     // advance the pointer to the next node
     head = head.next;

     // until the end of linked list is reached, do the
     // following steps
     while (head != null) 
     {
         // 2.a) take the parent node from the q and 
         //      remove it from q
         BinaryTreeNode parent = q.poll();//q.peek();
         //BinaryTreeNode pp = q.poll();
           
         // 2.c) take next two nodes from the linked list.
         // We will add them as children of the current 
         // parent node in step 2.b. Push them into the
         // queue so that they will be parents to the 
         // future nodes
         BinaryTreeNode leftChild = null, rightChild = null;
         leftChild = new BinaryTreeNode(head.data);
         q.add(leftChild);
         head = head.next;
         if (head != null) 
         {
             rightChild = new BinaryTreeNode(head.data);
             q.add(rightChild);
             head = head.next;
         }

         // 2.b) assign the left and right children of
         //      parent
         parent.left = leftChild;
         parent.right = rightChild;
     }
       
     return node;
 }

 // Utility function to traverse the binary tree 
 // after conversion
 void inorderTraversal(BinaryTreeNode node) 
 {
     if (node != null) 
     {
         inorderTraversal(node.left);
         System.out.print(node.data + " ");
         inorderTraversal(node.right);
     }
 }

 // Driver program to test above functions
 public static void main(String[] args) 
 {
     BinaryTree tree = new BinaryTree();
     tree.push(36); /* Last node of Linked List */
     tree.push(30);
     tree.push(25);
     tree.push(15);
     tree.push(12);
     tree.push(10); /* First node of Linked List */
     BinaryTreeNode node = tree.convertList2Binary(tree.root);

     System.out.println("Inorder Traversal of the"+
                     " constructed Binary Tree is:");
     tree.inorderTraversal(node);
 }
}
//This code has been contributed by Mayank Jaiswal


public class BinaryTreeWithLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
 * public interface Queue<E>
extends Collection<E>
A collection designed for holding elements prior to processing. Besides basic Collection operations, queues provide additional insertion, extraction, and inspection operations. Each of these methods exists in two forms: one throws an exception if the operation fails, the other returns a special value (either null or false, depending on the operation). The latter form of the insert operation is designed specifically for use with capacity-restricted Queue implementations; in most implementations, insert operations cannot fail.
Throws exception	Returns special value
Insert	add(e)	offer(e)
Remove	remove()	poll()
Examine	element()	peek()
Queues typically, but do not necessarily, order elements in a FIFO (first-in-first-out) manner. Among the exceptions are priority queues, which order elements according to a supplied comparator, or the elements' natural ordering, and LIFO queues (or stacks) which order the elements LIFO (last-in-first-out). Whatever the ordering used, the head of the queue is that element which would be removed by a call to remove() or poll(). In a FIFO queue, all new elements are inserted at the tail of the queue. Other kinds of queues may use different placement rules. Every Queue implementation must specify its ordering properties.
 */
