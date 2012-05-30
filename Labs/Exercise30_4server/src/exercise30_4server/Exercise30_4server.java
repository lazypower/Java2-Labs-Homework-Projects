
package exercise30_4server;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercise30_4server extends JFrame 
{
    protected JTextArea jta = new JTextArea();
    protected JButton jbtStop = new JButton("Stop");
    protected RandomAccessFile raf;
    protected String countFile = "webcount.dat";
    protected static int count;
    
    public Exercise30_4server ()
    {
        JScrollPane jsp = new JScrollPane(jta);
        
        Container container = getContentPane();
        container.add(jsp, BorderLayout.CENTER);
        container.add(jbtStop, BorderLayout.SOUTH);
        
        //jbtStop.addActionListener();
        
        
        setTitle("Exercise30_4Server: Web Visit Count Server");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        container.setVisible(true);
        
        startup();
    }
    
    private void startup() 
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(8000);
            jta.append("Server started " + "\n\n");
            
            if (new File(countFile).exists()) 
            {
                raf = new RandomAccessFile(countFile, "rw");
                count = raf.readInt();
            }
            else 
            {
                raf = new RandomAccessFile(countFile, "rw");
                count = 0;
            }
            
            int i = 0;
            while (true) {
                Socket connectToClient = serverSocket.accept();
                jta.append("Starting thread " + i + "\n");
                jta.append("Client IP " + 
                        connectToClient.getInetAddress() + "\n");
                
                webVisitHandler thread = new webVisitHandler(connectToClient);
                thread.run();
                i++;
            }
        }
        catch(IOException ex) 
        {
            jta.append(ex + "\n");
        }
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == jbtStop) 
        {
            try
            {
                if (raf != null) 
                {
                    raf.setLength(0);
                    raf.writeInt(count);
                    raf.close();
                }
            }
            catch (IOException ex)
            {
                jta.append(ex + "\n");
            }
        }
        System.exit(0);
    }
    
public static void main(String args[]) 
{
    Exercise30_4server frame = new Exercise30_4server();
    frame.setVisible(true);
}

public static int increaseCount()
{
    return ++count;
}

 class webVisitHandler extends Thread {
    private Socket connectToClient;
    public webVisitHandler(java.net.Socket c) 
    {
        connectToClient = c;
    }


public void run() 
{
  try 
  {
      PrintWriter osToClient = 
           new PrintWriter(connectToClient.getOutputStream(), true);
      int newCount = increaseCount();
      osToClient.println(newCount);
    }
    catch (IOException ex) 
    {
        jta.append(ex + "\n");
    }
}

}

}



    
