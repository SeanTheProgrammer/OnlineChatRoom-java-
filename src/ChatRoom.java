import javax.swing.*;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;

//This Class is the client part of the program

public class ChatRoom extends JFrame
{
    //TODO: Connect to server

    JPanel chat = new JPanel();
    JTextArea TA = new JTextArea(15,25);
    JScrollPane SP= new JScrollPane(TA);
    JTextField TF = new JTextField(25);
    JButton JB = new JButton("Send Message");
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

        JB.addActionListener(this::actionPerformed);//this:: references the method inside this

        chat.add(SP); //Adds scrollpane that has text area in it onto the pane
        chat.add(TF);
        chat.add(JB);
        chat.setVisible(true);
        this.add(chat);
    }

    public void actionPerformed(ActionEvent e)
    {
        TA.append("You: "+TF.getText() + "\n");//Change this to get the sockets name and then change the "you part"
        TF.setText("");
    }

    public static void main(String args[])
    {
        ChatRoom temp = new ChatRoom();
    }
}

