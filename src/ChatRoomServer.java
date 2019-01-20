import java.net.ServerSocket;
import java.net.Socket;

//This class is used to be the server Part of the chatroom

public class ChatRoomServer
{
    public ChatRoomServer()
    {
        ServerSocket MainServer;
        Socket ClientSocket;
        System.out.println("Starting Server...");
        try
        {
            MainServer = new ServerSocket(25565);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String args[])
    {
        ChatRoomServer Server = new ChatRoomServer();
    }
}
