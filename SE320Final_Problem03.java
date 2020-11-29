/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se320final_problem03;


/**
 *
 * @author joshu
 */
public class SE320Final_Problem03
{
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Integer[] list = {3, 4, 5, 1, -3, -5, -1};
        
        for (int i = 0; i < list.length; i++)
        {
            list[i] = i;
        }
        
         
         System.out.println(linearSearch(list, 2));
         System.out.println(linearSearch(list, 5));
        
    }   
           
        
        
        
    
    
    
    public static <E extends Comparable<E>> int linearSearch(E[] list, E key)
    {
        for (int i = 0; i < list.length; i++)
        {
            if (list[i].compareTo(key) == 0)
            {
                return i;
            }
        }
        return -1;
    }
}
