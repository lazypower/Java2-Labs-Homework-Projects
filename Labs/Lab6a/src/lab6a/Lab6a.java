
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
        if (jcboIntRational.getSelectedItem().equals("Integer Operation"))
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

// skip down to "abstract class calcuation -- then come back
class IntPanel extends CalculationPanel
{
    IntPanel()
    {
        //- init super class with integer calcuation
    }

    void add() 
    {
        int result = getNum1() + getNum2();
        
        tfResult.setText(String.valueOf(result));
    }
    
    // write code for three other operations
    
    private int getNum1()
    {
        int num1 = Integer.parseInt(tfNum1.getText().trim());
        return num1;
    }
    
    private int getNum2()
    {
        int num2 = Integer.parseInt(tfNum2.getText().trim());
    }
}

class RationalPanel extends CalculationPanel
{
    RationalPanel()
    {
        // init super with "Rational Calcuation"
    }
    
    void add()
    {
        Rational num1 = getNum1();
        Rational num2 = getNum2();
        Rational result = num1.add(num2);
        
        tfResult.setText(result.toString());
    }
    
    // write code for 3 other operations
    
    Rational getNum1()
    {
        StringTokenizer st1 = new StringTokenizer(tfNum1.getText().trim(), "/");
        int numer1 = Integer.parseInt(st1.nextToken());
        int denom1 = Integer.parseInt(st1.nextToken());
        return new Rational(numer1, denom1);
    }
    
    Rational getNum2()
    {
       StringTokenizer st2 = new StringTokenizer(tfNum2.getText().trim(), "/");
        int numer2 = Integer.parseInt(st2.nextToken());
        int denom2 = Integer.parseInt(st2.nextToken());
        return new Rational(numer2, denom2);
    }
    
}

abstract class CalculationPanel extends JPanel implements ActionListener
{
    private JPanel p0 = new JPanel();
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    
    JTextField tfnum1, tfNum2, tfResult;
    JButton jbtAdd, jbtSub, jbtMul, jbtDiv;
    
    public CalculationPanel(String title) {
        p0.add(new JLabel(title));
        LayoutManager flow = new FlowLayout();
        p1.setLayout(flow);
        p1.add(new JLabel("Number 1"));
        p1.add(tfnum1 = new JTextField(" ", 3));
        p1.add(new JLabel("Number 2"));
        p1.add(tfNum2 = new JTextField(" ", 3));
        p1.add(new JLabel("Result"));
        p1.add(tfResult = new JTextField(" ", 3));
        
        tfResult.setEditable(false);
        JPanel p2 = new JPanel();
        p2.setLayout(flow);
        p2.add(jbtAdd = new JButton("Add"));
        p2.add(jbtSub = new JButton("Sub"));
        p2.add(jbtMul = new JButton("Mul"));
        p2.add(jbtDiv = new JButton("Div"));
        
        setLayout(new BorderLayout());
        add("North", p0);
        add("Center", p1);
        add("South", p2);
        
        jbtAdd.addActionListener(this);
        jbtSub.addActionListener(this);
        jbtMul.addActionListener(this);
        jbtDiv.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        String actionCommand = e.getActionCommand();
        if (e.getSource() instanceof JButton)
        {
            if ("Add".equals(actionCommand))
            {
                add();
            }
            if ("Sub".equals(actionCommand))
            {
                sub();
            }
            if ("Mul".equals(actionCommand))
            {
                mul();
            }
            if ("Div".equals(actionCommand))
            {
                div();
            }
        }
    }
    
    abstract void add();
    abstract void sub();
    abstract void mul();
    abstract void div();
}

