
package lab6a;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Lab6a extends JApplet implements ActionListener
{
    CardLayout queue = new CardLayout();
    
    private JPanel cardPanel = new JPanel();
    private JComboBox jcboIntRational = new JComboBox(); // pg 1105
    
    public Lab6a()
    {
        JPanel intPanel = new IntPanel();
        JPanel rationalPanel = new RationalPanel();
        LayoutManager layout = queue;
        
        cardPanel.add(intPanel, "Integer");
        cardPanel.add(rationalPanel, "Rational");
        
        getContentPane().setLayout(new BorderLayout());
        add(jcboIntRational, BorderLayout.NORTH);
        add(cardPanel, BorderLayout.CENTER);
        
        jcboIntRational.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (jcboIntRantional.getSelectedItem().equals("Integer Operation"))
        {
            //p1074
        }
        else if (jcboIntRational.getSelectedItem().equals("Rational Operation"))
        {
            //p 1074 flip to last
        }
    }
    
    public static void main(String[] args) 
    {
        Lab6a applet = new Lab6a();
        JFrame frame = new JFrame();
        frame.setTitle(("Lab6a"));
        frame.getContentPane().add(applet, BorderLayout.CENTER);
        applet.init();
        applet.start();
        
        frame.setSize(400, 320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
