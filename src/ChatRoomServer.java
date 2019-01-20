import javax.swing.*;
import java.net.ServerSocket;
import java.net.Socket;

//This class is used to be the server Part of the chatroom

public class ChatRoomServer extends JFrame
{

    ServerSocket MainServer;
    Socket ClientSocket;

    public ChatRoomServer()
    {


        System.out.println("Starting Server...");
        try
        {
            MainServer = new ServerSocket(25565);
            ClientSocket = MainServer.accept();
            if(ClientSocket.isBound())
            {
                ListUsers();
                System.out.println("SOCKET IS BOUND");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        setSize(500,400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    //This functions lists current users on the Server
    public void ListUsers()
    {
        System.out.println(ClientSocket.getLocalAddress());
    }

    public static void main(String args[])
    {
        ChatRoomServer Server = new ChatRoomServer();
    }
}
