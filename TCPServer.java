/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerInfo;

/**
 *
 * @author joshu
 */
import java.net.*;


public class TCPServer {
  public static void main(String[] args) throws Exception {
	  
	    try
	    {
		      ServerSocket server=new ServerSocket(2210);
		      int counter = 0;
		      System.out.println("Server Started");
		      
		      while(true)
		      {
		    	  counter++;
		          Socket serverClient=server.accept();
	              System.out.println(" >> " + "Client No: " + counter + " started");
	              ServerClientThread sct = new ServerClientThread(serverClient,counter);
	              sct.start();
		      }
	 
	      }
	      catch(Exception e)
	      {
	        System.out.println(e);
	      }
	  
  }
}

