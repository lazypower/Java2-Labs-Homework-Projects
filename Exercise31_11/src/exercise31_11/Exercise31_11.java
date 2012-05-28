
package exercise31_11;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

import java.net.URL;
import javax.swing.event.*;
import java.io.*;
import javax.xml.ws.http.HTTPBinding;

public class Exercise31_11 extends JApplet implements ActionListener , HyperlinkListener 
{

    //page 998 - jeditor pane jep
    private JEditorPane jep = new JEditorPane();
    
    JLabel jlblURL = new JLabel("URL");
    JTextField jtfURL = new JTextField();
    
    public void init()
    {
        JPanel jpURL = new JPanel();
        LayoutManager layout = new BorderLayout();
        jpURL.add(jlblURL, BorderLayout.WEST);
        jpURL.add(jtfURL, null);
        
        JScrollPane jspViewer = new JScrollPane();
        jspViewer.getViewport().add(jep, null);
        
        this.getContentPane().add(jspViewer, BorderLayout.CENTER);
        this.getContentPane().add(jpURL, BorderLayout.NORTH);
        
        jep.setEditable(false);
        
        jep.addHyperlinkListener(this);
        jtfURL.addActionListener(this);
    }
public void actionPerformed(ActionEvent e)
{
    String urlString = jtfURL.getText().trim();
    if (isSubstring("www", urlString))
    {
        urlString.concat("http://");
    }
    
    URL url;
    
    try 
    {
        if (isSubstring("http", urlString))
        {
            url = new URL(urlString);
        }
        else
        {
            url = this.getClass().getResource(urlString);
        }
        System.out.println("urlString " + urlString);
        
        // p 998 display html file
        jep.setPage(url);
    }
    catch (IOException ex) {
        System.out.println(ex);
    }
}

public void hyperlinkUpdate(HyperlinkEvent e)
{
    try
    {
        jep.setPage(e.getURL());
    }
    catch (IOException ex) { System.out.println(ex); }
}

    
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("some title");
        Exercise31_11 applet = new Exercise31_11();
        
        frame.getContentPane().add(applet, BorderLayout.CENTER);
        applet.init();
        applet.start();
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public static boolean isSubstring(String first, String second) {
        int remainingLength = second.length();
        int startingIndex = 0;
        
        while(first.length() <= remainingLength )
        {
            for (int i = 0; i <= first.length(); i++)
            {
                if (first.charAt(i) != second.charAt(startingIndex+i))
                {
                    startingIndex++;
                    remainingLength--;
                }
            }
            return true;
        }
        return false;
    }
}
