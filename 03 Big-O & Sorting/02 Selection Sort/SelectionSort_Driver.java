// Name: Siddhant Sood
// Date: 10/21/2021

import java.util.*;
import java.io.*;

public class SelectionSort_Driver
{
   public static void main(String[] args) throws Exception
   {
     //Part 1, for doubles
      int n = (int)(Math.random()*100)+20;
      double[] array = new double[n];
      for(int k = 0; k < array.length; k++)
         array[k] = Math.random()*100;	
      
      Selection.sort(array);   //students must write
      print(array);
      if( isAscending(array) )
         System.out.println("In order!");
      else
         System.out.println("Out of order  :-( ");
      System.out.println();
      
      //Part 2, for Strings
      int size = 100;
      Scanner sc = new Scanner(new File("declaration.txt"));
      Comparable[] arrayStr = new String[size];
      for(int k = 0; k < arrayStr.length; k++)
         arrayStr[k] = sc.next();	
   
      Selection.sort(arrayStr);  //students must write
      print(arrayStr);
      System.out.println();
      
      if( isAscending(arrayStr) )
         System.out.println("In order!");
      else
         System.out.println("Out of order  :-( ");
   }
  
   public static void print(double[] a)
   {
      // for(int k = 0; k < a.length; k++)
         // System.out.println(a[k]);
      for(double temp: a)         //for-each
         System.out.print(temp+" ");
      System.out.println();
   }
  
   public static void print(Object[] papaya)
   {
      for(Object temp : papaya)     //for-each
         System.out.print(temp+" ");
         
   }
  
   public static boolean isAscending(double[] a)
   {
      for (int i =1; i<a.length; i++)
      {
           if (!(a[i] >= a[i-1])){
               return false;
           }
      }
      
      
    return true;
   }
   
   @SuppressWarnings("unchecked")
   public static boolean isAscending(Comparable[] a)
   {
       for (int i =1; i<a.length-1; i++)
       {
         int x  = a[i].compareTo(a[i-1]);
           if (x<0){
               return false;
           }
      }
      
    return true;
 
   }
}
/////////////////////////////////////////////////////

class Selection
{
   public static void sort(double[] array)
   {
      int x = 0;
      double  tempVal = 0;
      for (int i = array.length -1; i>0; i--)
      {
         x = findMax(array, i);
         
         tempVal = array[i];
         array[i] = array[x];
         array[x] = tempVal;
         
      }   
   }
   
   // upper controls where the inner loop of the Selection Sort ends
   private static int findMax(double[] array, int upper)
   {
     int x = 0;
     for (int i = 1; i<= upper; i ++)
     {
       if (array[i] > array[x])
       {
         x = i;
       }
       
     }
     return x;
   
   }
   private static void swap(double[] array, int a, int b)
   {
      //not needed
   }   	
   
	/*******  for Comparables ********************/
   @SuppressWarnings("unchecked")
   public static void sort(Comparable[] array)
   {
      int x = 0;
      Comparable tempVal = "";
      for (int i = array.length -1; i>0; i--)
      {
         x = findMax(array, i);
         
         tempVal = array[i];
         array[i] = array[x];
         array[x] = tempVal;
         
      }
   }
   
   @SuppressWarnings("unchecked")
   public static int findMax(Comparable[] array, int upper)
   {
      Comparable z = array[upper];
      int y = 0;
     for (int i = upper; i>=0; i --)
     {
       y = array[i].compareTo(z);
       if (y>0)
       {
         z = array[i];
         upper = i;
       }
       
     }
     return upper;
   

   
   }
   public static void swap(Object[] array, int a, int b)
   {
   //not needed
   }
}

