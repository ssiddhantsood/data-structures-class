 //Name: Siddhant Sood  
 //Date: 10/21/2021

import java.util.*;
import java.io.*;

public class InsertionSort_Driver
{
   public static void main(String[] args) throws Exception
   {
      //Part 1, for doubles
      int n = (int)(Math.random()*100)+20;
      double[] array = new double[n];
      for(int k = 0; k < array.length; k++)
         array[k] = Math.random()*100;	
      
      Insertion.sort(array);  //students write
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
   
      Insertion.sort(arrayStr);   //students write
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
      for(Object temp : papaya)    
         System.out.print(temp+" ");
   }
   
   public static boolean isAscending(double[] a)
   {
   
      for (int i =1; i<a.length; i++)
      {
         if (!(a[i] >= a[i-1]))
         {
             return false;
         }
      }
         
    return true;

   }
   
   @SuppressWarnings("unchecked")//this removes the warning for Comparable
   public static boolean isAscending(Comparable[] a)
   {
   
      for (int i =1; i<a.length-1; i++)
      {
         int x  = a[i].compareTo(a[i-1]);
         if (x<0)
         {
             return false;
         }
      }
      
      return true;
   }
}

//**********************************************************

class Insertion
{
   public static void sort(double[] array)
   { 
   
      
      for (int i = 1; i<array.length;i++)
      {
         double r = array[i];
         int y = shift(array, i-1,r);
         
         for(int j= i-1; j>=y;j--)
         {
            array[j+1] = array[j];
         }
         
         array[y] = r;
        
         
      }   
   

   }
 
   private static int shift(double[] array, int index, double value)
   {
      for(int i = index; i>= 0; i--)
      {
         if (value>=array[i])
         {
            return i+1;
            }
       }
       return 0;
    }
 
   @SuppressWarnings("unchecked")
   public static void sort(Comparable[] array)
   { 
    for (int i = 1; i<array.length;i++)
      {
         Comparable r = array[i];
         int y = shift(array, i-1,r);
         
         for(int j= i-1; j>=y;j--)
         {
            array[j+1] = array[j];
         }
         
         array[y] = r;
        
         
      }   
   


   }
   
   @SuppressWarnings("unchecked")
   private static int shift(Comparable[] array, int index, Comparable value)
   {
   for(int i = index; i>= 0; i--)
      {
         int x = array[i].compareTo(value);
         if (x<0)
         {
            return i+1;
         }
       }
       return 0;

   }
}
