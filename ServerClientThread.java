/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * PROBLEM 02: This class incorporates multithreading to the BMI calculator to allow for multiple users.
 */
package ServerInfo;

/**
 *
 * @author joshu
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

class ServerClientThread extends Thread {
	
  Socket serverClient;
  int clientNo;
  double height, weight;
  String delims = " ";
  String[] bodyStats;

  
  ServerClientThread(Socket inSocket,int counter){
    serverClient = inSocket;
    clientNo=counter;
  }
  
  public void run(){
    try
    {
      DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
      DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
      String clientMessage = "";
      String serverMessage = "";
      
      while(!clientMessage.equals("bye"))
      {
        clientMessage=inStream.readUTF();
        System.out.println("From Client-" + clientNo + ": Input is :" + clientMessage);
        
        if (!clientMessage.contentEquals("bye")) {
	        bodyStats = clientMessage.split(delims);
	        
	        height = Double.parseDouble(bodyStats[0]);
	        weight = Double.parseDouble(bodyStats[1]);
	        
	        serverMessage = "From Server to Client-" + clientNo + "  BMI = " + weight/(height*height);
        }
        else
        	serverMessage = "bye";
        
        outStream.writeUTF(serverMessage);
        outStream.flush();
      }
      
      inStream.close();
      outStream.close();
      serverClient.close();
    }
    catch(Exception ex)
    {
      System.out.println(ex);
    }finally
    {
      System.out.println("Client -" + clientNo + " exit!! ");
    }
  }
}

