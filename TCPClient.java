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
import java.io.*;
import java.net.Socket;

public class TCPClient {
  public static void main(String[] args) throws Exception {
	  try
	  {
	    Socket socket=new Socket("127.0.0.1",2210);
	    
	    DataInputStream inStream=new DataInputStream(socket.getInputStream());
	    DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
	    
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    String clientMessage = "";
	    String serverMessage = "";
	    
	    while(!clientMessage.equals("bye"))
	    {
	      System.out.println("Enter two numbers for height(m) and weight(kg):  Example: 1.75 70");
	      clientMessage=br.readLine();
	      outStream.writeUTF(clientMessage);
	      outStream.flush();
	      serverMessage=inStream.readUTF();
          System.out.println(serverMessage);
	    }
	    
	      outStream.close();
	      outStream.close();
	      socket.close();
	  }
	  catch(Exception e)
	  {
	    System.out.println(e);
	  }
  }
}

