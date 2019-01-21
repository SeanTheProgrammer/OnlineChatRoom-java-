import javax.swing.*;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//This Class can now run the Server and client

public class ChatRoom extends JFrame
{


    JPanel chat = new JPanel();
    JTextArea TA = new JTextArea(15,25);
    JScrollPane SP= new JScrollPane(TA);
    JTextField TF = new JTextField(25);
    JButton JB = new JButton("Send Message");

    //Server Related Components
    JPanel Menu = new JPanel();
    JTextField ServerIpTF = new JTextField(25);
    JButton JoinServer = new JButton("Join Server");
    JButton HostServer = new JButton("Host Server");

    //Server Sockets
    ServerSocket SSocket;
    Socket MainServerSocket;

    //Client Socket
    Socket Client;


    public ChatRoom()
    {
        setTitle("ChatRoom");
        setSize(500,500);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Could put function inside to turn off after doing some other stuff
        SetUpPanel();
    }

    public void SetUpPanel()
    {
        // TA.setEditable(false); <--- Used to disable typing onto the text area (used for recent chat messages)

        //Chat Panel Start
        JB.addActionListener(this::actionPerformed);//this:: references the method inside this
        chat.add(SP); //Adds scrollpane that has text area in it onto the pane
        chat.add(TF);
        chat.add(JB);
        chat.setVisible(false);
        //Chat Panel End

        //Adding Server Components
        HostServer.addActionListener(this::HostServerL);
        JoinServer.addActionListener(this::JoinServerL);

        Menu.add(ServerIpTF);
        Menu.add(JoinServer);
        Menu.add(HostServer);
        this.add(Menu);
        //End Server Components


        //this.add(chat);
    }

    public void JoinServerL(ActionEvent e)
    {
        //TODO: Setup Socket to join the server
        //TODO: Error check if the socket doesn't connect

        try
        {
            ConnectToServer(ServerIpTF.getText());
        }
        catch (IOException error)
        {
            System.out.println("Failed to join the selected Server");
            System.exit(-1);
        }

        System.out.println("You've selected to join the server" + ServerIpTF.getText());
        Menu.setVisible(false);
        chat.setVisible(true);
        this.add(chat);

    }

    public void HostServerL(ActionEvent e) //ActionEvent e allows to be used as action listener
    {


        try
        {
            SSocket = new ServerSocket(25565);

            MainServerSocket = SSocket.accept();
        }
        catch (Exception exc)
        {
            System.out.println("Main Server Could Not Accpet");
            System.exit(-1);
        }

        System.out.println("You've selected to host the server on this machine");
        Menu.setVisible(false);
        chat.setVisible(true);
        this.add(chat);

    }

    public void actionPerformed(ActionEvent e)
    {
        TA.append("You: "+TF.getText() + "\n");//Change this to get the sockets name and then change the "you part"
        TF.setText("");
    }

    Socket ClientSocket;

    public void ConnectToServer(String ip) throws IOException
    {
        ClientSocket = new Socket(ip,25565);//change the port depending on the desired connection
    }

    public static void main(String args[])
    {
        ChatRoom temp = new ChatRoom();
    }
}

