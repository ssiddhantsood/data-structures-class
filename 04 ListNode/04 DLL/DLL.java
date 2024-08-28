// Name: Siddhant Sood
// Date: 

//  implements some of the List and LinkedList interfacesw: 
//	 	  size(), add(i, o), remove(i);  addFirst(o), addLast(o); 
//  This class also overrides toString().
//  the list is zero-indexed.
//  Uses DLNode.

public class DLL        //DoubleLinkedList
{
   private int size = 0;
   private DLNode head = new DLNode(); //dummy node--very useful--simplifies the code
   
   //no constructor needed
   
   /* two accessor methods  */
   public int size()
   {
      return size;
   }
   public DLNode getHead()
   {
      return head;
   }
   
   /* appends obj to end of list; increases size;
   	  @return true  */
   public boolean add(Object obj)
   {
      addLast(obj);
      return true;   
   }
   
   /* inserts obj at position index (the list is zero-indexed).  
      increments size. 
      no need for a special case when size == 0.
	   */
   public void add(int index, Object obj) throws IndexOutOfBoundsException  //this the way the real LinkedList is coded
   {
      if( index > size || index < 0 )
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      /* enter your code below  */
      DLNode point=head;
      while (index != 0) {
    	  point=point.getNext();
        index--;
      }
      DLNode temp = new DLNode(obj, point, point.getNext());
      point.getNext().setPrev(temp);
      point.setNext(temp);  
      size++;
                    
                    
   }
   
    /* return obj at position index (zero-indexed). 
    */
   public Object get(int index) throws IndexOutOfBoundsException
   { 
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      /* enter your code below  */
     
      DLNode point= head;
      index++;
      while (index!= 0)
      {
    	  point=point.getNext();
        index--;
      }
      return point.getValue(); 
   }
   
   /* replaces obj at position index (zero-indexed). 
        returns the obj that was replaced.
        */
   public Object set(int index, Object obj) throws IndexOutOfBoundsException
   {
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      /* enter your code below  */
      DLNode point=head;
      index++;
      while (index !=0) {
    	  point=point.getNext();
        index--;
      }
      
      DLNode temp = new DLNode(obj, point, point.getNext());
      
      point.getPrev().setNext(temp);
      point.getNext().setPrev(temp);
      Object val = point.getValue();
      return val;

      
   }
   
   /*  removes the node from position index (zero-indexed).  decrements size.
       @return the object in the node that was removed. 
        */
   public Object remove(int index) throws IndexOutOfBoundsException
   {
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      /* enter your code below  */
      DLNode point=head.getNext();
      while (index != 0)
      {
    	  point=point.getNext();
        index--;
      }
      point.getPrev().setNext(point.getNext());
      point.getNext().setPrev(point.getPrev());
      size--;
      return point.getValue();

      
   }
   
  	/* inserts obj to front of list, increases size.
	    */ 
   public void addFirst(Object obj)
   {
      head.getNext().setPrev(new DLNode(obj,head,head.getNext()));
	   head.setNext(head.getNext().getPrev());
	   size = size + 1;
   }
   
   /* appends obj to end of list, increases size.
       */
   public void addLast(Object obj)
   {
   
	   DLNode point = head;
      point = point.getPrev();
      point.setNext(new DLNode(obj, point, head));
      head.setPrev(point.getNext());
      size++;
   }
   
   /* returns the first element in this list  
      */
   public Object getFirst()
   {
      if (head.getNext().getValue() == null)
      {
         return null;
      }
      
      return head.getNext().getValue();
      
   }
   
   /* returns the last element in this list  
     */
   public Object getLast()
   {
      DLNode point = head.getNext();
	   
      if(point.getValue()==null) {
		    return null;
	   }
      
		while(point.getNext().getValue()!=null) 
      {
		    point=point.getNext();
		}
		
      return point.getValue();
 
         }
         
         
 
   
   /* returns and removes the first element in this list, or
      returns null if the list is empty  
      */
   public Object removeFirst()
   {
      if(head.getNext().getValue()==null)
      {
		   return null;
	   } 
      
		Object v = head.getNext().getValue();
      head.setNext(head.getNext().getNext());
		head.getNext().setPrev(head);
      
	   size--;
	   return v;		   
	  

   
   }
  
   /* returns and removes the last element in this list, or
      returns null if the list is empty  
      */
   public Object removeLast()
   {
	   if(head.getNext().getValue()==null) 
      {
		   return null;
	   } 
      
      DLNode point = head.getNext();
		while(point.getNext().getValue()!=null)
      {
			point=point.getNext();
		}
      
		   point.getPrev().setNext(null);		   
		   size--;
		   return point.getValue();
	   

   }
   
   /*  returns a String with the values in the list in a 
       friendly format, for example   [Apple, Banana, Cucumber]
       The values are enclosed in [], separated by one comma and one space.
    */
   public String toString()
   {
    String values = "[";
      DLNode a = head;
      a = a.getNext();
      values = values + a.getValue();
      int b=size;
      while (size != 1){
      
         a = a.getNext();
         values = values + ", " + a.getValue();
         size--;
      }
      size = b;
      values = values +  "]";
      return values;
   }
}