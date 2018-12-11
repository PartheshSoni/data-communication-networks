import java.net.*;
import java.io.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        
        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }
        
        int portNumber = Integer.parseInt(args[0]);
        
        try {
            ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));
            System.out.println("Server Started...");
	    Socket clientSocket = serverSocket.accept();    
	      BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);                   

	    	  BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		           
	    	  String inputLine, userInput;	

          
             while(true){
             	System.out.print("Enter message: ");
             		userInput = stdIn.readLine();
		          	out.println(userInput);
		          	out.flush();

		          	if((inputLine = in.readLine()) != null)
		          		System.out.println("Client: "+inputLine);

		          }


            }
        
         catch (UnknownHostException e) {
            //System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } 
        catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}