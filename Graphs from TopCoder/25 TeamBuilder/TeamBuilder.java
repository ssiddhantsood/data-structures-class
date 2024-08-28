// Name: Siddhant Sood
// Date:6/2/2022
 
import java.util.*;
import java.io.*;

public class TeamBuilder
{
   public static void main(String[] args) 
   {
      String[] path = {"010", "000", "110"};	   
      //String[] path = {"0010", "1000", "1100", "1000"};
      //String[] path = {"01000", "00100", "00010", "00001", "10000"};
      //String[] path = {"0110000", "1000100", "0000001", "0010000", "0110000", "1000010", "0001000"};
      
      int[] ret = specialLocations(path);
      System.out.println("{" + ret[0] + ", " + ret[1] + "}");
   }

   public static int[] specialLocations(String[] paths)
   {
   
      grid = new int[paths.length][paths[0].length()];
      for(int i = 0; i<paths.size ; i++)
      {
        for(int j = 1; j<= paths[0].length; j++)
        {
           grid[i][j] = paths[i].substring(j-1,j);
     	  }
        
        
      }
      int firstCounter = 0;
      
      for(int i=0; i< w ; i++)
      {
      if(grid[vertices.get(x)][i] == 1) 
            reach.add(nameList.get(i));      
      }
      
   }
   
   public boolean isReachable(String sauce, String others)
   {
      List<Vertex> reach = breadthFirstSearch(source);
      for (Vertex x : reach)
      {
         if(x.getName().equals(target))
            return true;
         
      }
      return false;
   }

}