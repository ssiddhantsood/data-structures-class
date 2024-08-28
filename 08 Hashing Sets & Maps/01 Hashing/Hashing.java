 // Name: Siddhant Sood
 // Date: 3/3/2022

/* 
   Assignment:  This hashing program results in collisions.
   You are to implement three different collision schemes: linear 
   probing, rehashing, and chaining.  Then implement a search 
   algorithm that is appropriate for each collision scheme.
 */
import java.util.*;
import javax.swing.*;
public class Hashing
{
   public static void main(String[] args)
   {
      int arrayLength = Integer.parseInt(JOptionPane.showInputDialog(
                         "Hashing!\n"+
                         "Enter the size of the array:  "));//20
       
      int numItems = Integer.parseInt(JOptionPane.showInputDialog(
                         "Add n items:  "));               //15
     
      int scheme = Integer.parseInt(JOptionPane.showInputDialog(
           "The Load Factor is " + (double)numItems/arrayLength +
           "\nWhich collision scheme?\n"+
           "1. Linear Probing\n" +
           "2. Rehashing\n"+
           "3. Chaining"));
      Hashtable table = null;
      switch( scheme )
      {
         case 1:   
            table = new HashtableLinearProbe(arrayLength);
            break;
         case 2: 
            table = new HashtableRehash(arrayLength);
            break;
         case 3:  
            table = new HashtableChaining(arrayLength);
            break;
         default:  System.exit(0);    
      }
      for(int i = 0; i < numItems; i++)
         table.add("Item" + i);
      int itemNumber = Integer.parseInt(JOptionPane.showInputDialog(
                       "Search for:  Item0" + " to "+ "Item"+(numItems-1)));
      while(true)
      {
         itemNumber = Integer.parseInt(JOptionPane.showInputDialog(
                       "Search for:  Item0" + " to "+ "Item"+(numItems-1)));
         if(itemNumber == -1)
            System.exit(0);
         String key = "Item" + itemNumber; 
      System.out.println("Searching for " + key);
      boolean found = table.contains(key); 
      } 
   }
}

/*********************************************/
interface Hashtable
{
   void add(Object obj);
   boolean contains(Object obj);
   Object[] getArray();   //for Codepost
}
/***************************************************/ 

class HashtableLinearProbe implements Hashtable
{
   private Object[] array;
  
   public HashtableLinearProbe(int size)//constructor
   {
      array = new Object[size];                    
   }   
   
   public Object[] getArray()   //for Codepost
   {
      return array;
   }
   
   public void add(Object obj)
   {
      int code = obj.hashCode();
      int index = Math.abs(code % array.length);
      if(array[index] == null) 
      {
         array[index] = obj;
           
      }
      else //collision
       {
         System.out.println(obj + "\t" + code + "\tCollision at index "+ index);
         index = linearProbe(index);
         array[index] = obj;
         System.out.println(obj + "\t" + code + "\tindex" + index);
     }
   }  
   
   public int linearProbe(int index)
   {      
      if(index >= array.length) 
			return linearProbe(0);
		else if(array[index]!=null) 
			return linearProbe(index+1);
		else 
			return index;
      
  
   }
   
   public boolean contains(Object obj)     
   {
      int index = Math.abs(obj.hashCode() % array.length);
      while(array[index] != null)
      {
         if(array[index] == obj)  //found it
         {
            return true;   
         }
         else //search for it in a linear probe manner
         {
         if (index >= array.length-1)
            index = 0;
         else 
            index = index + 1;
            
         }
      }
      System.out.println("\t\t\tNot found!");
      return false;  //not found
   }
}

/*****************************************************/
class HashtableRehash implements Hashtable
{
   private Object[] array;
   private int constant;  
   
   public HashtableRehash(int size) //constructor
   {
      array=new Object[size];
		
		if(size%2 == 1) 
			constant = 2;
		else 
      {
         int n =3; 
         
         boolean r = true;
         for(int i=3; i<=n/2; i=i+2) {
			if(n%i==0) {
				r = false;
			}
         
         }
		
         
         while((size % n != 0)&& r) 
			{
	         n = n + 2;
            
            r = true;
            for(int i=3; i<=n/2; i=i+2) 
            {
			      if(n%i==0) 
				      r = false;
			   }
            
         }
         
         constant = n;
		}

			
		
                     
   }
   
   public Object[] getArray()   //for Codepost
   {
      return array;
   }
   
   public void add(Object obj)
   {
      int code = obj.hashCode();
      int index = Math.abs(code % array.length);
      if(array[index] == null)  //if empty, insert
      {
      array[index] = obj;
         
      }
      else //collision
   {
         System.out.println(obj + "\t" + code +"\tCollision at index "+ index);
         index = rehash(index);
         array[index] = obj;
         System.out.println(obj + "\t" + code + "\tindex " + index);
    }
   }  
   
   public int rehash(int index)
   {
   if(array[index] == null) 
	  return index;
   else
	  return rehash((index+constant) % (array.length));

       
   }
   
   public boolean contains(Object obj)
   {
      int index = Math.abs(obj.hashCode() % array.length);
      while(array[index] != null)
      {
         if(array[index] == obj)  //found it
         {
            return true;
         }
         else //search for it in a rehashing manner
         {
            index = (index+constant) % array.length;
         }
      }
       System.out.println("\t\t\tNot found!");
      return false;  //not found
   }
}

/********************************************************/
class HashtableChaining implements Hashtable
{
   private LinkedList[] array;
   
   public HashtableChaining(int size)
   {
      array = new LinkedList[size];
      
      for(int i=0; i<size; i++) 
      {
		  array[i] = new LinkedList<Object>();
		}
                            
   }
   
   public Object[] getArray()   //for Codepost
   {
      return array;
   }
   
   public void add(Object obj)
   {
      int code = obj.hashCode();
      int index = Math.abs(code % array.length);
      array[index].addFirst(obj);
      System.out.println(obj + "\t" + code + " " + " at index " +index + ": "+ array[index]);
   }  
   
   public boolean contains(Object obj)
   {
      int index = Math.abs(obj.hashCode() % array.length);
      if( !array[index].isEmpty() )
      {
         if(array[index].getFirst() == obj)  //found it
         {
            return true;
         }
         else //search for it in a chaining manner
         { 
            for(Object i:array[index])
            {
        		  if(i==obj) 
        			  return true; 		  
        	   } 	   
            return false;   
         }
      }
      System.out.println("\t\t\tNot found!");
      return false;  //not found
   }
}

/************* Sample run for Linear Probe ****************
Linear Probe 
Size: 20
Items: 15
Search for 14
                              
     ----jGRASP exec: java Hashing_teacher
 Item0	70973277	index 17
 Item1	70973278	index 18
 Item2	70973279	index 19
 Item3	70973280	index 0
 Item4	70973281	index 1
 Item5	70973282	index 2
 Item6	70973283	index 3
 Item7	70973284	index 4
 Item8	70973285	index 5
 Item9	70973286	index 6
 Item10	-2094795630	index 10
 Item11	-2094795629	index 9
 Item12	-2094795628	index 8
 Item13	-2094795627	index 7
 Item14	-2094795626	Collision at index 6
 			Collision at index 6
 			Collision at index 7
 			Collision at index 8
 			Collision at index 9
 			Collision at index 10
 Item14	-2094795626	index11
 Searching for Item14
 			Looking at index 6
 			Looking at index 7
 			Looking at index 8
 			Looking at index 9
 			Looking at index 10
 			Found at index 11
 
  ----jGRASP: operation complete.
  
********************************************************/
/************* Sample run for Rehashing ****************
Rehashing 
Size: 20
Items: 15
Search for 14 
    
  ----jGRASP exec: java Hashing_teacher
 Item0	70973277	index 17
 Item1	70973278	index 18
 Item2	70973279	index 19
 Item3	70973280	index 0
 Item4	70973281	index 1
 Item5	70973282	index 2
 Item6	70973283	index 3
 Item7	70973284	index 4
 Item8	70973285	index 5
 Item9	70973286	index 6
 Item10	-2094795630	index 10
 Item11	-2094795629	index 9
 Item12	-2094795628	index 8
 Item13	-2094795627	index 7
 Item14	-2094795626	Collision at index 6
 			Collision at index 6
 			Collision at index 9
 Item14	-2094795626	index 12
 Searching for Item14
 			Looking at index 6
 			Looking at index 9
 			Found at index 12
 
  ----jGRASP: operation complete.
  
  ***********************************************/
  
/************* Sample run for Chaining ****************
Chaining
Size: 20
Items: 15
Search for 14
  
       ----jGRASP exec: java Hashing_teacher
 Item0	70973277  at index 17: [Item0]
 Item1	70973278  at index 18: [Item1]
 Item2	70973279  at index 19: [Item2]
 Item3	70973280  at index 0: [Item3]
 Item4	70973281  at index 1: [Item4]
 Item5	70973282  at index 2: [Item5]
 Item6	70973283  at index 3: [Item6]
 Item7	70973284  at index 4: [Item7]
 Item8	70973285  at index 5: [Item8]
 Item9	70973286  at index 6: [Item9]
 Item10	-2094795630  at index 10: [Item10]
 Item11	-2094795629  at index 9: [Item11]
 Item12	-2094795628  at index 8: [Item12]
 Item13	-2094795627  at index 7: [Item13]
 Item14	-2094795626  at index 6: [Item14, Item9]
 Searching for Item14
 			Found at index 6
 
  ----jGRASP: operation complete.
  ************************************************************/