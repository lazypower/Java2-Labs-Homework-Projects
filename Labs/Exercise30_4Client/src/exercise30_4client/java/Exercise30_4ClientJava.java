
package exercise30_4client.java;

import java.net.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Exercise30_4ClientJava extends JApplet {

    private JLabel lb1 = new JLabel("You are visitor number");
    private JLabel lb2 = new JLabel("0");
    
    public void init() {
        LayoutManager  layoutmanager = new FlowLayout();
        add(lb1);
        lb1.setBackground(Color.YELLOW);
        add(lb2);
        lb2.setBackground(Color.CYAN);
        // these are some fug interface colors Mr T.
        
        try 
        {
            Socket connectToServer = new Socket("localhost", 8000);
            BufferedReader isFromServer =
                    new BufferedReader(
                            new InputStreamReader(connectToServer.getInputStream()));
        }
        catch (IOException ioe) { System.err.println(ioe);}
    }
}
