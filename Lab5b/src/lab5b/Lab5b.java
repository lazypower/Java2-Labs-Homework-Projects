package lab5b;

import java.awt.*;
import javax.swing.*;
import java.util.*;
        

public class Lab5b extends JApplet implements MemoryListener
{

    boolean isStandalone = false;
    private MemoryWatch memoryWatch1 = new MemoryWatch();
    private JScrollPane jscrollPane1 = new JScrollPane();
    private JTextArea jTextArea1 = new JTextArea();
    
    
    public void init() 
    {
        this.setSize(new Dimension(400,300));
        jTextArea1.setText("jTextArea1");
        
        memoryWatch1.addMemoryListener(new MemoryListener()
        {
            public void sufficientMemory(MemoryEvent e) 
            { }

            public void insufficientMemory(MemoryEvent e) 
            {
                memoryWatch1_insufficientMemory(e);
            }
        });
        
        memoryWatch1.addMemoryListener(new MemoryListener()
        {
            public void sufficientMemory(MemoryEvent e)
            {
                memoryWatch1_sufficientMemory(e);
            }
            
            public void insufficientMemory(MemoryEvent e)
            { }
        });
        
        // add jscrollpane to center of applet
        jscrollPane1.getViewport().add(jTextArea1, null);
    }
    
    public static void main(String[] args) 
    {
        Lab5b applet = new Lab5b();
        applet.isStandalone = true;
        JFrame frame = new JFrame();
        frame.setTitle("Lab5b");
        frame.getContentPane().add(applet, BorderLayout.CENTER);
        
        applet.init();
        applet.start();
        frame.setSize(400, 320);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public void sufficientMemory(MemoryEvent e)
    {
        jTextArea1.setText("Sufficient Memory");
        jTextArea1.append("highLimit " + memoryWatch1.getHighLimit()+"\n");
        jTextArea1.append("free memory " + e.getFreeMemory() + "\n");
        jTextArea1.append("total memory " + e.getTotalMemory() + "\n");
        
    }
    
    public void insufficientMemory(MemoryEvent e) 
    {
        jTextArea1.setText("Insufficient Memory");
        jTextArea1.append("highLimit " + memoryWatch1.getHighLimit()+"\n");
        jTextArea1.append("free memory " + e.getFreeMemory() + "\n");
        jTextArea1.append("total memory " + e.getTotalMemory() + "\n");
    }
    
    void memoryWatch1_insufficientMemory(MemoryEvent e) 
    {
        insufficientMemory(e);
    }
    
    void memoryWatch1_sufficientMemory(MemoryEvent e) 
    {
        sufficientMemory(e);
    }
    
    
    public interface MemoryListener extends EventListener
    {
        public void sufficientMemory(MemoryEvent e);
        public void InsufficientMemory(MemoryEvent e);
        
    }

    class MemoryEvent extends EventObject
    {
        // page 1065 
        //Runtime runtime = 
        
        public MemoryEvent(Object o)
        {
            //iniitalize the parent of this class with the argumen to
        }
        
        public long freeMemory() 
        {
            //return free memory - page 1065
        }
        
        public long totalMemory() 
        {
            //return total memory page 1065
        }
        
    }
    
    class MemroyWatch implements Runnable 
    {
        private int highLimit = 700000;
        private int lowLimit = 200000;
        
        //Runtime runtime 
        //page 1065
        
        private Thread thread;
        private transiet Vector memoryListeners;
        
        public MemoryWatch() 
        {
            thread = new Thread(this);
            thread.start();
        }
        
        public void run()
        {
            while (true) 
            {
                try 
                {
                    Thread.sleep(1000);
                }
                catch(Exception e)
                { }
                
                System.out.println("Total Memory " + runtime.totalMemory());
                System.out.println("Free Memory " + runtime.freeMemory());
                
                if ( runtime.freeMemory > highLimit)
                {
                    MemoryEvent e = new MemoryEvent(this);
                    
                    fireSufficientMemory(e);
                }
                
                if ( runtime.freeMemory < lowLimit)
                {
                    MemoryEvent e = new MemoryEvent(this);
                    
                    fireInsufficientMemory(e);
                }
            }
        }
        
        public static void main(String[] args) 
        {
            MemoryWatch memoryWatch1 = new MemoryWatch();
        }
        
        public void setHighLimit(int newHighLimit)
        {
            highLimit = newHighLimit;
        }
        
        public void setLowLimit(int newLowLimit)
        {
            lowLimit = newLowLimit;
        }
        
        public int getHighLimit()
        {
            return highLimit;
        }
        
        public int getLowLimit()
        {
            return lowLimit;
        }
    }
    
}
