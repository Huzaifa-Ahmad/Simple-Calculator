    
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.JFrame;
 
 

public class Calculator extends Frame implements KeyListener {
    int x,y;
    
        //Color costants
    Color border = new Color(225,225,225);
    Color background = new Color(235,235,235);
    Color white = new Color(252,252,252);
        
    JLabel input, blank, blank2, blank0;
    private int constant = 12;
    
        //Icon Image
    ImageIcon img = new ImageIcon("Capture.PNG");
   
    //String bar = Character.toString('\u2261');
    //JLabel txtf2 = new JLabel("  " + bar + "   STANDARD",2); 

    public static void main () {
        new Calculator();
    }
    
    public Calculator() {
        super("Calculator");
        setVisible(true);
        setResizable(false);
        setSize(320,550);
        // Calculator Icon
        setIconImage(img.getImage());

        // Triple Bar Image Top Left Corner
        ImageIcon image = new ImageIcon("Capture.jpg");
        JLabel label2 = new JLabel(" STANDARD", image, SwingConstants.LEFT);
        label2.setOpaque(true);
        label2.setBackground(border);
        label2.setFont(new Font("Gadugi", Font.BOLD, 15));
        
        //Panel#1
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));
        
        //Empty JLabel                          
            blank2 = new JLabel();
            blank2.setOpaque(true);
            blank2.setBackground(border);
            blank2.setFont(new Font("", Font.PLAIN, 15));
            blank2.setHorizontalAlignment(JTextField.RIGHT);
            blank2.setForeground(new Color(85,85,85));
             
        //Input JLabel    
            input = new JLabel();
            input.setHorizontalAlignment(JTextField.RIGHT);
            input.setOpaque(true);
            input.setBackground(border);
            input.setBorder(BorderFactory.createLineBorder(border, 2 ));
            input.setFont(new Font("", Font.PLAIN, 42));
            input.setText("0");
  
        //Panels
            JPanel panel2 = new JPanel();
            JPanel panel3 = new JPanel();
            JPanel panel4 = new JPanel();
        
            panel2.setLayout(new GridLayout(2,4));
            panel3.setLayout(new GridLayout(1,4));
            panel4.setLayout(new GridLayout(1,4));
        
            JPanel p0 = new JPanel();
            JPanel p2 = new JPanel();
            JPanel p3 = new JPanel();
            JPanel p4 = new JPanel();
            JPanel c2 = new JPanel();
            
            p0.setLayout(new GridLayout(2,1));
            p2.setLayout(new GridLayout(2,1));
            p3.setLayout(new GridLayout(2,1));
            p4.setLayout(new GridLayout(1,1));
            
            JPanel b1 = new JPanel();
            JPanel b2 = new JPanel();
            JPanel b3 = new JPanel();
            JPanel b4 = new JPanel();
            
            b1.setLayout(new GridLayout(2,1));
            b2.setLayout(new GridLayout(2,1));
            b3.setLayout(new GridLayout(2,1));
            b4.setLayout(new GridLayout(1,1));
            c2.setLayout(new GridLayout(1,2));
            
        //Buttons
                
                    //"C" button - Red Mouse Action Background Upon Hovering Over the Button
                JButton clear = new JButton("C");
                clear.setActionCommand("C");
                clear.setFont(new Font("Gadugi", Font.PLAIN, 18));
                clear.setBackground(background);
                clear.setBorder(BorderFactory.createLineBorder(border, 2));
                clear.setPreferredSize(new Dimension(65,65));
                clear.addActionListener(new ClearActionListener());
                

                    //"÷" button - Blue Mouse Action Background 
                JButton divide = new JButton("÷");
                divide.setActionCommand("÷");
                divide.setFont(new Font("Calibri", Font.PLAIN, 32));
                divide.setBackground(background);
                divide.setBorder(BorderFactory.createLineBorder(border, 2));
                divide.addActionListener(new calc(4));
                
                
                    //"×" button - Blue Mouse Action Background 
                JButton times = new JButton("×");
                times.setActionCommand("×");
                times.setFont(new Font("Calibri", Font.PLAIN, 32));
                times.setBackground(background);
                times.setBorder(BorderFactory.createLineBorder(border, 2));
                times.addActionListener(new calc(3));
                
                
                    //"-" button - Blue Mouse Action Background 
                JButton minus = new JButton("−");
                minus.setActionCommand("−");
                minus.setFont(new Font("Calibri", Font.PLAIN, 32));
                minus.setBackground(background);
                minus.setBorder(BorderFactory.createLineBorder(border, 2));
                minus.addActionListener(new calc(2));
                
                
                    //"+" button - Blue Mouse Action Background 
                JButton plus = new JButton("+");
                plus.setActionCommand("+");
                plus.setFont(new Font("Calibri", Font.PLAIN, 32));
                plus.setBackground(background);
                plus.setBorder(BorderFactory.createLineBorder(border, 2));
                plus.addActionListener(new calc(1));
                
                
                    //"=" button - Blue Mouse Action Background 
                JButton equals = new JButton("=");
                equals.setActionCommand("=");
                equals.setFont(new Font("Calibri", Font.PLAIN, 32));
                equals.setBackground(background);
                equals.setBorder(BorderFactory.createLineBorder(border, 2));
                equals.addActionListener(new equals());
                
                    //"." button - Empty JButton. Could not figure out a way to successfuly implement double values into the program,
                    // without getting any errors. 
                JButton dot = new JButton("");
                dot.setBackground(background);
                dot.setFont(new Font("Calibri", Font.PLAIN, 32));
                dot.setBorder(BorderFactory.createLineBorder(border, 2));
                
                    //"negate" button
                JButton pm= new JButton("±");
                pm.setActionCommand("±");
                pm.setFont(new Font("Calibri", Font.PLAIN, 25));
                pm.setBackground(background);
                pm.setBorder(BorderFactory.createLineBorder(border, 2));
                pm.addActionListener(new sign());
                
                        
                
        //Numbers
        Numbers action = new Numbers();
        
        for (int i=10;i>=0;i--)
        {
            
                JButton button = new JButton((String.valueOf(i)));
                button.setBackground(white);
                button.setFont(new Font("", Font.PLAIN, 25));
                button.setForeground(Color.BLACK);
                button.setBorder(BorderFactory.createLineBorder(border, 2));
                button.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent event) {
                        button.setBackground(new java.awt.Color(220,220,220));
                    }

                    public void mouseExited(java.awt.event.MouseEvent event) {
                        button.setBackground(white);
                    }
                });
                
                if (i == 1 ) {
                    b1.add(button);
                }
                
                if (i == 2 || i == 0 ) {
                    b2.add(button);
                }
                
                if (i == 3 ) {
                    b3.add(button);
                }
                
                if (i == 7 || i == 4) {
                    p0.add(button);
                }
                
                if (i == 8 || i == 5) {
                    p2.add(button);
                }
                
                if (i == 9 || i == 6) {
                    p3.add(button);
                }

                button.addActionListener(action);
        }
        
            //Adding buttons, JLabels to Panels, Creating a Custom Layout using Panels
        b1.add(pm);
        b3.add(dot);      
        b4.add(equals);
        p4.add(plus);
        c2.add(clear);
        c2.add(divide);
        c2.add(times);
        c2.add(minus);
        
        panel.add(label2);
        panel.add(input);
        panel2.add(blank2);
        panel2.add(c2);
        panel3.add(p0);
        panel3.add(p2);
        panel3.add(p3);
        panel3.add(p4);
        panel4.add(b1);
        panel4.add(b2);
        panel4.add(b3);
        panel4.add(b4);
        
        add(panel);
        add(panel2);
        add(panel3);
        add(panel4);
                
            //Background Color Mouse Actions
        MouseListener color = new MouseAdapter(){
                public void mouseEntered(java.awt.event.MouseEvent event)
                {            
                    Component button = event.getComponent();                   
                    button.setBackground(new Color(220,220,220));
                }                                      
                
                public void mouseExited(java.awt.event.MouseEvent event)
                {                                      
                    Component button = event.getComponent();
                    button.setBackground(background);
                }  
            };
        
        MouseListener blue = new MouseAdapter(){
                public void mouseEntered(java.awt.event.MouseEvent event)
                {            
                    Component button = event.getComponent();                   
                    button.setBackground(new Color(107, 179, 242));
                }                                      
                
                public void mouseExited(java.awt.event.MouseEvent event)
                {                                      
                    Component button = event.getComponent();
                    button.setBackground(background);
                }  
            };
        
       MouseListener red = new MouseAdapter(){
                public void mouseEntered(java.awt.event.MouseEvent event)
                {            
                    Component button = event.getComponent();                   
                    button.setBackground(new Color(219, 55, 55));
                }                                      
                
                public void mouseExited(java.awt.event.MouseEvent event)
                {                                      
                    Component button = event.getComponent();
                    button.setBackground(background);
                }  
            };
             
            plus.addMouseListener(blue);
            equals.addMouseListener(blue);
            minus.addMouseListener(blue);
            divide.addMouseListener(blue);
            times.addMouseListener(blue);
            pm.addMouseListener(blue);
            clear.addMouseListener(red);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        addKeyListener(this);
        setLayout(new GridLayout(4,1));
    }

    private int function = 0;
    
    private class Numbers implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {
            if (!input.getText().equals("0") && function == 0) {
                String action = event.getActionCommand();
                input.setText(input.getText() + action);
            } else
                {
                    input.setText("");
                    String action = event.getActionCommand();
                    input.setText(action);
                    function = 0;
                }
        
            }
    }
    
    private class ClearActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            input.setText("0");
            blank2.setText("");
        } 
    }
    
    private class sign implements ActionListener {
        private int number;
        public void actionPerformed(ActionEvent event){
            number = Integer.parseInt(input.getText());
            input.setText(String.valueOf(number * -1));
            blank2.setText("negate(" + number + ") ");
        }
    }
    
    private class calc implements ActionListener {
        private int value;
        
        public calc(int z)
        {
            value = z;
        }
        
        public void actionPerformed(ActionEvent event)
        {
            x = Integer.parseInt(input.getText()); 
            y = value;
            blank2.setForeground(new Color(85,85,85));
            
                function = function + 1;
                if (y==1) {
                    blank2.setText(x + " +  ");
                } 
                else if (y==2) {
                    blank2.setText(x + " -  ");
                } 
                else if (y==3) {
                    blank2.setText(x + " x  ");
                             } 
                else if (y==4) {
                    blank2.setText(x + " /  ");
                } 
        }
        
    }
    
    private class equals implements ActionListener
    {
        public void actionPerformed(ActionEvent event) {
            if(!input.getText().isEmpty())
            {
                int number = Integer.parseInt(input.getText());
                
                
                    if (y == 1)
                    {
                        int total = x + number;
                        blank2.setText(x + " + " + number + " ");
                        input.setText(Integer.toString(total));
                    }
                    else if (y == 2)
                    {
                        int total = x - number;
                        blank2.setText(x + " - " + number + " ");
                        input.setText(Integer.toString(total));
                    }
                    else if (y == 3)
                    {
                        int total = x * number;
                        blank2.setText(x + " x " + number + " ");
                        input.setText(Integer.toString(total));
                    }
                    else if (y == 4)
                    {
                        if (number == 0) {
                            input.setText("0");
                            blank2.setForeground(Color.RED);
                            blank2.setText("Error   ");
                        }
                        else {
                            int total = x / number;
                            blank2.setText(x + " / " + number + " ");
                            input.setText(Integer.toString(total));
                        }
                    }
                
                
                
                }
            }
            
        }
    
    public void keyTyped (KeyEvent event) {} 
               
    public void keyReleased(KeyEvent event){}
                
    public void keyPressed(KeyEvent event) {
        String text = input.getText();
        char key = event.getKeyChar();
        
        if (key == KeyEvent.VK_1 || key == KeyEvent.VK_2 || key == KeyEvent.VK_3 || key == KeyEvent.VK_4 || key == KeyEvent.VK_5 || key == KeyEvent.VK_6 || key == KeyEvent.VK_7 || key == KeyEvent.VK_8 || key == KeyEvent.VK_9 || key == KeyEvent.VK_0) {
            
            if (input.getText() == "0") {
                input.setText(String.valueOf(key));
            }
            else input.setText(text + key);
        }
        
        if (key == KeyEvent.VK_PLUS) {
            y = 1;
            x = Integer.parseInt(input.getText()); 
            input.setText("");
        }
        else if (key == KeyEvent.VK_MINUS) {
            y = 2;
            x = Integer.parseInt(input.getText()); 
            input.setText("");
        }
        else if (key == event.VK_MULTIPLY) {
            y = 3;
            x = Integer.parseInt(input.getText()); 
            input.setText("");
        }
        else if (key == KeyEvent.VK_SLASH) {
            y = 4;
            x = Integer.parseInt(input.getText()); 
            input.setText("");
        } 
                
        if (key == KeyEvent.VK_ENTER) {
           
            if(!input.getText().isEmpty())
            {
                int number = Integer.parseInt(input.getText());
                
                
                    if (y == 1)
                    {
                        int total = x + number;
                        blank2.setText(x + " + " + number + " ");
                        input.setText(Integer.toString(total));
                    }
                    else if (y == 2)
                    {
                        int total = x - number;
                        blank2.setText(x + " - " + number + " ");
                        input.setText(Integer.toString(total));
                    }
                    else if (y == 3)
                    {
                        int total = x * number;
                        blank2.setText(x + " x " + number + " ");
                        input.setText(Integer.toString(total));
                    }
                    else if (y == 4)
                    {
                        if (number == 0) {
                            input.setText("0");
                            blank2.setForeground(Color.RED);
                            blank2.setText("Error   ");
                        }
                        else {
                            int total = x / number;
                            blank2.setText(x + " / " + number + " ");
                            input.setText(Integer.toString(total));
                        }
                    }
                
                
                
                }
        }
        
    
    }    
        
}        
