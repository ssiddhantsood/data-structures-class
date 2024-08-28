//Updated on 12.14.2020 v2

//Name:   Date:
import java.util.*;
import java.io.*;
public class McRonald
{
   public static final int TIME = 1080;     //18 hrs * 60 min
   public static double CHANCE_OF_CUSTOMER = .2;
   public static int customers = 0;
   public static int totalMinutes = 0;
   public static int longestWaitTime = 0;
   public static int longestQueue = 0;
   public static int serviceWindow = 0;      // to serve the front of the queue
   //public static final int numberOfServiceWindows = 3;  //for McRonald 3
   public static int thisCustomersTime;
   public static PrintWriter outfile = null; // file to display the queue information
      
   public static int timeToOrderAndBeServed()
   {
      return (int)(Math.random() * 6 + 2);
   }
  
   public static void displayTimeAndQueue(Queue<Customer> q, int min)
   { 
      //Billington's
      outfile.println(min + ": " + q);	
      //Jurj's
      //outfile.println("Customer#" + intServiceAreas[i] + 
      //                            " leaves and his total wait time is " + (intMinute - intServiceAreas[i]));                     	
      
   }
   
   public static int getCustomers()
   {
      return customers;
   }
   public static double calculateAverage()
   {
      return (int)(1.0 * totalMinutes/customers * 10)/10.0;
   }
   public static int getLongestWaitTime()
   {
      return longestWaitTime;
   }
   public static int getLongestQueue()
   {
      return longestQueue;
   }
            
   public static void main(String[] args)
   {     
    //set up file      
      try
      {
         outfile = new PrintWriter(new FileWriter("McRonald 1 Queue 1 ServiceArea.txt"));
      }
      catch(IOException e)
      {
         System.out.println("File not created");
         System.exit(0);
      }
      
      mcRonald(TIME, outfile);   //run the simulation
      
      outfile.close();	
   }
   
   public static void mcRonald(int TIME, PrintWriter of)
   {
   
      Queue<Customer> customersq = new LinkedList<>();
      double ran;
      Random rand = new Random();
      
      Customer v = null;
      Customer w = null;
      int lwait = 0;
      
      
      for (int i= 0; i<TIME; i++){
      
         ran = rand.nextDouble();
            if (ran <= CHANCE_OF_CUSTOMER)
            {
               int r =2+rand.nextInt(6);
               //System.out.println(r);
               
               customersq.add(new Customer(i,r));
               customers = customers + 1; 
            }
            
            
            
            
            
            v = customersq.peek();
            
            
                  if (w == null && v != null)
                  {
                     w = new Customer (v);
                  }
                  
                  if ((v != null) && (v.getTime() != w.getTime()))
                  {
                     w = new Customer(v);
                  }
               
               
               
            
            if (v != null){
            
            displayTimeAndQueue(customersq, v.getOrder());
            }
            else{
            displayTimeAndQueue(customersq, 0);

            
            }
            if (v == null){
             
            }
            else if (v.getOrder() > 0)
            {
            v.update();
            
            }
            if (v != null)
            {

               if (v.getOrder() == 0)
               {
                 customersq.remove();
                 
                 totalMinutes = totalMinutes + i - w.getTime();
                 
                 if (customersq.size() > longestQueue)
                     longestQueue = customersq.size();   
                 
                 lwait = i - w.getTime();
                 if (lwait > longestWaitTime)
                 {
                 longestWaitTime = lwait;
                 }               
                 
                 }
               
            }
            
        
            
       }   
            
         
         
         
            
      
      
      
      
      
     
        
        
              
      /*   report the data to the screen    */  
      System.out.println("1 queue, 1 service window, probability of arrival = "+ CHANCE_OF_CUSTOMER);
      System.out.println("Total customers served = " + getCustomers());
      System.out.println("Average wait time = " + calculateAverage());
      System.out.println("Longest wait time = " + longestWaitTime);
      System.out.println("Longest queue = " + longestQueue);
   }
   
   public static class Customer      
   {
   
      private int arrivedAt;
      private int orderAndBeServed;
     
      
    /**********************************
       Complete the Customer class with  
       constructor, accessor methods, toStrin
    ***********************************/
    
    public Customer(int x, int y)
    {
       this.arrivedAt = x;
       this.orderAndBeServed = y;
    } 
    
    public Customer(Customer another)
    {
      this.arrivedAt = another.arrivedAt;
      this.orderAndBeServed = another.orderAndBeServed;
      
      
   
    }
    public int getTime()
    {
      return arrivedAt;
    }
    
    public void update()
    {
    orderAndBeServed = orderAndBeServed -1;
    }
    
    public int getOrder()
    {
      return orderAndBeServed;
    }
    
    public String arrstr()
    {
      return Integer.toString(arrivedAt);
    }
    
    public String ordstr()
    {
      return Integer.toString(orderAndBeServed);
    }
      
    
    
   }
}
