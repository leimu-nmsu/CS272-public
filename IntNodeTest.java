package lab4;
import lab4.IntNode;

public class IntNodeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        /*Build a linked list: 12 28 0 34*/
				IntNode head1;
				head1 = new IntNode(34,null);
				head1 = new IntNode(0,head1);
				head1 = new IntNode(28,head1);
				head1 = new IntNode(12,head1);
				System.out.println("The original linked list is:");
				System.out.println(lab4.IntNode.toString(head1, 1));
				
				/*Add 17 after the head of the linked list*/
				head1.addNodeAfter(17);
				System.out.println();
				System.out.println("After adding 17 after the head, the linked list becomes:");
				System.out.println(lab4.IntNode.toString(head1, 1));
				
				/*Add 22 after the position 2*/
				IntNode cursor;
				int i = 1;
				for(cursor = head1; cursor !=null; cursor = cursor.link) {
					if(i==2) { //add a data after position i = 2
						cursor.addNodeAfter(22);
					}
					i++;
				}
				System.out.println();
				System.out.println("After adding 22 after the position 2, the linked list becomes:");
				System.out.println(lab4.IntNode.toString(head1, 1));
				
				
				head1.removeNodeAfter();
				System.out.println();
				System.out.println("After removing the element after the head, the linked list becomes:");
				System.out.println(lab4.IntNode.toString(head1, 1));
				
				/*Remove an element after the position 2*/
				int j = 1;
				for(cursor = head1; cursor !=null; cursor = cursor.link) {
					if(j==2) { //add a data after position j = 2
						cursor.removeNodeAfter();
					}
					j++;
				}
				System.out.println();
				System.out.println("After removing the element after position 2, the linked list becomes:");
				System.out.println(lab4.IntNode.toString(head1, 1));
				
				System.out.println();
				System.out.println("Does the linked list constain 13:");
				System.out.println(lab4.IntNode.search(head1,13));
				
				System.out.println();
				System.out.println("Does the linked list constain 22:");
				System.out.println(lab4.IntNode.search(head1,22));
			}
}
