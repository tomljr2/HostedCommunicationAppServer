import java.net.*;
import java.io.*;

public class Server extends Thread
{
   int PORT = 8005;

   private ServerSocket serverSocket;
   private InputStream is;

   public Server() throws IOException
   {
      serverSocket = new ServerSocket(PORT);
   }

   public void run(){
      while(true)
      {
         try
         {
//            System.out.println("Waiting for client on port " +
//                               serverSocket.getLocalPort() + "...");
            Socket server = serverSocket.accept();
            is = server.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            System.out.println(br.readLine());

            server.close();
         }
         catch(IOException e)
         {
            e.printStackTrace();
            break;
         }
      }
   }

   public static void main(String [] args)
   {
      try
      {
         Thread t = new Server();
         t.start();
      }
      catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}
