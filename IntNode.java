package lab4;

public class IntNode {
	public int data; // The integer element stored in this node
	public IntNode link; //Refers the next node in the list
	
	
	/*No-argument constructor which sets the node value to be 0 and the link to be null*/
	public IntNode() {
		data = 0;
		link = null;
	}
	
	/*A constructor with the given node value and the link*/
    public IntNode(int initialData, IntNode initialLink) {
    	data = initialData;
    	link = initialLink;
    }
	    
    /*Get and set methods for node value and node link*/
    public int getData() {
    	return data;
    }
    
    public IntNode getLink() {
    	return link;
    }
    
    public void setData(int newData) {
    	data = newData;
    }
    
    public void setLink(IntNode newLink) {
    	link = newLink;
    }
    
    /*Get length method starting from a given node head*/
    public static int listLength(IntNode head) {
    	IntNode cursor;
    	int answer;
    	answer = 0;
    	for(cursor = head; cursor != null; cursor = cursor.link)
    		answer++;
    	
    	return answer;	
    }
    
    public void addNodeAfter(int element)
    {
    	link = new IntNode(element, link);
    }
    
    /*toString method with two arguments, the first one is a linked list, the second one is*/
    /*the position where a user wants to activate this method*/
    /*the value of activation should be positive and not bigger than the list length*/
    public static String toString(IntNode head, int activation) {
    	String datalist = new String("");
    	IntNode cursor;
    	int i;
    	int len = listLength(head);
    	if (activation <=0)
    		throw new IllegalArgumentException("Activation is not positive.");
    	cursor = head;
    	if(activation <= len) {
    		for(i = 1;i <=len ; i++) 
    		{
    			if((i >= activation) &&(i < len))
    			{
    				datalist = datalist + Integer.toString(cursor.getData())+"->";
    			}
    			if(i==len)
    			{
    				datalist = datalist + Integer.toString(cursor.getData());
    			}
    			cursor = cursor.link;
    		}
    	}   	   	
    	return datalist;
    }
    
    /*A method to add a node after the current node*/
    public void addNodeAfterThis(int newdata) {
    	link = new IntNode(newdata, link);
    }
    
    /*A method to remove a node after the current node*/ 
    public void removeNodeAfter() {
    	link=link.link;
    }
    
    /*A method to search whether a linked list starting with head contains a given value data*/
    public static boolean search(IntNode head, int data) {
    	IntNode cursor;
    	boolean exist = false;
    	if(head!=null) {//precondition
    		for(cursor = head; cursor != null; cursor = cursor.link)
        		if(cursor.getData()==data) {
        			exist = true;
        		}
    	}
    	
    	return exist;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
