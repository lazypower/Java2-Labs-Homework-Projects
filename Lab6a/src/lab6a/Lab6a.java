
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
        cardPanel.setLayout(layout);
        
        )
        
    }
    
    

    public static void main(String[] args) {
        // TODO code application logic here
    }
}
