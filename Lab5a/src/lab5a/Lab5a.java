package lab5a;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import javax.swing.*;

import java.util.*;
//import formatting package

public class Lab5a extends JApplet implements ActionListener
{
    private Locale[] availableLocales = getAvailableLocales();
    private String[] availableTimeZones = getAvailableIDs();
    private DateFormat dateFormat = DateFormat.getDateInstance();
    private DateFormat timeFormat = DateFormat.getTimeInstance();
    
    private Date date = new Date();
    private JTextField jtfDate = new JTextField(dateFormat.format(date));
    private JTextField jtfTime = new JTextField(timeFormat.format(date));
    
    private JComboBox jcboLocale = new JComboBox(availableLocales);
    private JComboBox jcboTimeZones = new JComboBox(availableTimeZones);
    
    private JComboBox jcboDateStyle = new JComboBox(
            new String[] { "Full", "LONG", "MEDIUM", "SHORT"});
    private JComboBox jcboTimeStyle = new JComboBox(
            new String[] { "Full", "LONG", "MEDIUM", "SHORT"});
    
    private Locale lcale = Locale.US;
    private String timeZone = TimeZone.getDefault().getID();
    
    private int dateStyle = DateFormat.FULL;
    private int timeStyle = DateFormat.FULL;
    
    public Lab5a()
    {
        JPanel p1 = new JPanel(new GridLayout(1, 2));
        JPanel p1_1 = new JPanel(new BorderLayout());
        JPanel p1_2 = new JPanel(new BorderLayout());
        p1_1.add(new JLabel("timeZone: "), BorderLayout.WEST);
        p1_1.add(jtfDate, BorderLayout.CENTER);
        p1_2.add(new JLabel("Time: "), BorderLayout.WEST);
        p1_2.add(jtfTime, BorderLayout.CENTER);
        p1.add(p1_1);
        p1.add(p1_2);
        
        JPanel p2 = new JPanel();
        p2.add(new JLabel("Locale:"));
        p2.add(jcboLocale);
        p2.add(new JLabel("Time Zone:"));
        p2.add(jcboTimeZones);
        
        JPanel p3 = new JPanel();
        p3.add(new JLabel("Date Style: "));
        p3.add(jcboDateStyle);
        p3.add(new JLabel("Time Style:"));
        p3.add(jcboTimeStyle);
        
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new GridLayout(1, 3));
        
        this.add(p1);
        this.add(p2);
        this.add(p3);
        
        jcboDateStyle.addActionListener(this);
        jcboLocale.addActionListener(this);
        jcboTimeStyle.addActionListener(this);
        jcboTimeZones.addActionListener(this);
        
    }
    
    
    public static void main(String[] args) 
    {
       JFrame frame = new JFrame("Show Date and TIme");
       Lab5a applet = new Lab5a();
       
       frame.add(applet, BorderLayout.CENTER);
       frame.setSize(450, 150);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);
       
    }

}
