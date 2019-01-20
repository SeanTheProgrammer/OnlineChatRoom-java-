import javax.swing.*;
import javax.swing.JPanel;

public class ChatRoom extends JFrame
{
    JPanel chat = new JPanel();
    JTextArea TA = new JTextArea(15,25);
    JScrollPane SP= new JScrollPane(TA);
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
        chat.add(SP);
        chat.setVisible(true);
        this.add(chat);
    }

    public static void main(String args[])
    {
        ChatRoom temp = new ChatRoom();
    }
}

