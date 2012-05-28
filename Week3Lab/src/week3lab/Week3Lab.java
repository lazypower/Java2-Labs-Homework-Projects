package week3lab;

import java.awt.*;
import javax.swing.*;
import java.util.*;


/**
 *
 * @author charles
 */
public class Week3Lab extends JApplet{
    private DisplayArrayPanel displayArrayPanel1 = new DisplayArrayPanel();
    private int[] numbers1 = initializeNumbers();

    private DisplayArrayPanel displayArrayPanel2 = new DisplayArrayPanel();
    private int[] numbers2 = numbers1.clone();
    
    private DisplayArrayPanel displayArrayPanel3 = new DisplayArrayPanel();
    private int[] numbers3 = numbers1.clone(); 
            
    static int PAUSE_TIME = 250;
    
    public Week3Lab() {
        setLayout(new GridLayout(1, 4));
        
        displayArrayPanel1.setNumbers(numbers1);
        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.add(new JLabel("Selection Sort", JLabel.CENTER), BorderLayout.NORTH);
        panel1.add(displayArrayPanel1, BorderLayout.CENTER);
        add(panel1);
    
    
    displayArrayPanel2.setNumbers(numbers2);
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(new JLabel("Insertion Sort", JLabel.CENTER), BorderLayout.NORTH);
        panel2.add(displayArrayPanel1, BorderLayout.CENTER);
        add(panel2);
    

    displayArrayPanel3.setNumbers(numbers3);
        JPanel panel3 = new JPanel(new BorderLayout());
        panel3.add(new JLabel("Bubble Sort", JLabel.CENTER), BorderLayout.NORTH);
        panel3.add(displayArrayPanel1, BorderLayout.CENTER);
        add(panel3);
    
    
    new Thread (new Runnable() 
    {
        public void run() 
        {
            selectionSort(numbers1);
        }
    }).start();
    
    new Thread (new Runnable() 
    {
        public void run() 
        {
            selectionSort(numbers2);
        }
    }).start();    

    new Thread (new Runnable() 
    {
        public void run() 
        {
            selectionSort(numbers3);
        }
    }).start();

    }
    
    
    public void selectionSort(int[] list) 
    {
        // page 200 lines 3-20
        
        try 
        {
            Thread.sleep(PAUSE_TIME);
        }
        
        catch (InterruptedException e) {}
        displayArrayPanel1.repaint();
    }
    
    public void insertionSort(int[] list) 
    {
        for (int i = 1; i < list.length; i++) 
        {
            //insert listi into a sorted sublist list[0 i-1] so list [0..i] is sorted 
            int currentElement = list[i];
            int k;
            for (k = i - 1; k >= 0 && list[k] > currentElement; k--) 
            {
                list[k+1] = list[k];
                try 
                {
                 Thread.sleep(PAUSE_TIME);    
                }
                catch (InterruptedException e) {}
                
                list[k+1] = currentElement;
                try
                {
                    Thread.sleep(PAUSE_TIME);
                }
                catch (InterruptedException e) {}
                displayArrayPanel2.repaint();
                }
          }
      }
    
    public void bubbleSort(int[] list)
    {   
        // page 837
        
    }

    public int[] initializeNumbers()
    {
        int[] numbers = new int[50];
        
        //for( int i = 0; i < list.length; i++)
        //{
        //    numbers[i] = i + 1;
        //}
        
        java.util.List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) 
        {
            list.add(numbers[i]);
        }
        
        Collections.shuffle(list);
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
        
        Object[] objects = list.toArray();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(objects[i].toString());
        }
        return numbers;
    }
    
    
    
    public static void main(String[] args) {
        Week3Lab applet = new Week3Lab();
        JFrame frame = new JFrame();
        frame.getContentPane().add(applet, BorderLayout.CENTER);
        applet.init();
        applet.start();
        frame.setSize(600, 160);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }
}

class DisplayArrayPanel extends JPanel {
    int[] numbers;
    
    public void setNumbers(int[] numbers) 
    {
        this.numbers = numbers;
        repaint();
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) 
        {
            if (max < numbers[i]) 
            {
                max = numbers[i];
            }
        }
       int height = (int)(getSize().height * 0.98);
       int width = getSize().width;
       int unitWidth = (int)(width * 1.0 / numbers.length);
       for (int i = 0; i < numbers.length; i++) 
       {
           g.drawRect(
                   (int)(i * unitWidth),
                   getSize().height - (int)((numbers[i] * 1.0 / max) * height),
                   (int)(unitWidth), getSize().height);
       }
    }
}
