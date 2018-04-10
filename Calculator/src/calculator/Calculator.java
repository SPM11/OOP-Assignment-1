package Calculator;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener
{
    
    JPanel[] row = new JPanel[5];
    JButton[] button = new JButton[19];
    String[] buttonString = {"Reset", "On/Off","7", "8", "9", "+", "-","4", "5", "6", "x", "/","1", "2", "3","0", ".", "Del", "="};
    int[] dimW = {300,45,100};
    int[] dimH = {35, 40};
    Dimension displayDimension = new Dimension(dimW[0], dimH[0]);
    Dimension regularDimension = new Dimension(dimW[1], dimH[1]);
    Dimension otherButtDimension = new Dimension(dimW[2], dimH[1]);
    boolean[] function = new boolean[4];
    double[] temporary = {0, 0};
    JTextArea display = new JTextArea(1,20);
    Font font = new Font("Tahoma", Font.PLAIN, 12);
    JLabel label = new JLabel("Made by Sanzu Padula");
    Font fontl = new Font("Lucida Handwriting", Font.PLAIN, 12);

    public static void main(String[] args)
    {
        JPanel[] row = new JPanel[5];
    JButton[] button = new JButton[19];
    String[] buttonString = {"Reset", "On/Off","7", "8", "9", "+", "-","4", "5", "6", "x", "/","1", "2", "3","0", ".", "Del", "="};
    int[] dimW = {300,45,100};
    int[] dimH = {35, 40};
    Dimension displayDimension = new Dimension(dimW[0], dimH[0]);
    Dimension regularDimension = new Dimension(dimW[1], dimH[1]);
    Dimension otherButtDimension = new Dimension(dimW[2], dimH[1]);
    boolean[] function = new boolean[4];
    double[] temporary = {0, 0};
    JTextArea display = new JTextArea(1,20);
    Font font = new Font("Tahoma", Font.PLAIN, 12);
    JLabel label = new JLabel("Made by Sanzu Padula");
    Font fontl = new Font("Lucida Handwriting", Font.PLAIN, 12);
        Calculator c = new Calculator();
    }
    Calculator()
    {
        super("MyCalculator");
        setSize(400, 320);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(5,5);
        setLayout(grid);
        
        for(int i = 0; i < 4; i++)
            function[i] = false;
        
        FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
        FlowLayout f2 = new FlowLayout(FlowLayout.CENTER,1,1);
        for(int i = 0; i < 5; i++)
            row[i] = new JPanel();
        row[0].setLayout(f1);
        for(int i = 1; i < 5; i++)
            row[i].setLayout(f2);
        
        for(int i = 0; i < 19; i++)
        {
            button[i] = new JButton();
            button[i].setText(buttonString[i]);
            button[i].setFont(font);
            button[i].addActionListener(this);
        }
        
        display.setFont(font);
        display.setEditable(false);
        display.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        display.setPreferredSize(displayDimension);
        for(int i = 0; i < 2; i++)
            button[i].setPreferredSize(otherButtDimension);
        for(int i = 2; i < 18; i++)
            button[i].setPreferredSize(regularDimension);
        
        row[0].add(display);
        add(row[0]);
        
        row[1].add(label);
        for(int i = 0; i < 2; i++)
            row[1].add(button[i]);
        add(row[1]);
        
        for(int i = 2; i < 7; i++)
            row[2].add(button[i]);
        add(row[2]);
        
        for(int i = 7; i < 12; i++)
            row[3].add(button[i]);
        add(row[3]);
        
        for(int i = 12; i < 15; i++)
            row[4].add(button[i]);
        add(row[4]);
        
        for(int i = 15; i < 19; i++)
            row[5].add(button[i]);
        add(row[5]);
        
        setVisible(true);
    }
    
    public void reset()
    {
        try
        {
            display.setText("");
            for(int i = 0; i < 4; i++)
                function[i] = false;
            for(int i = 0; i < 2; i++)
                temporary[i] = 0;
        } catch(NullPointerException e)
        {  
        }
    }
    
    public void powerOp()
    {
    }
    
    public void result()
    {
        double result = 0;
        temporary[1] = Double.parseDouble(display.getText());
        String temp0 = Double.toString(temporary[0]);
        String temp1 = Double.toString(temporary[1]);
        try
        {
            if(temp0.contains("-"))
            {
                String[] temp00 = temp0.split("-", 2);
                temporary[0] = (Double.parseDouble(temp00[1]) * -1);
            }
            if(temp1.contains("-"))
            {
                String[] temp11 = temp1.split("-", 2);
                temporary[1] = (Double.parseDouble(temp11[1]) * -1);
            }
        } catch(ArrayIndexOutOfBoundsException e)
        {
        }
        try
        {
            if(function[2] == true)
                result = temporary[0] * temporary[1];
            else if(function[3] == true)
                result = temporary[0] / temporary[1];
            else if(function[0] == true)
                result = temporary[0] + temporary[1];
            else if(function[1] == true)
                result = temporary[0] - temporary[1];
            display.setText(Double.toString(result));
            for(int i = 0; i < 4; i++)
                function[i] = false;
        } catch(NumberFormatException e)
        {
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource() == button[2])
            display.append("7");
        if(a.getSource() == button[3])
            display.append("8");
        if(a.getSource() == button[4])
            display.append("9");
        if(a.getSource() == button[5])
        {
            //add
            temporary[0] = Double.parseDouble(display.getText());
            function[0] = true;
            display.setText("");
        }
        if(a.getSource() == button[7])
            display.append("4");
        if(a.getSource() == button[8])
            display.append("5");
        if(a.getSource() == button[9])
            display.append("6");
        if(a.getSource() == button[6])
        {
            //subtract
            temporary[0] = Double.parseDouble(display.getText());
            function[1] = true;
            display.setText("");
        }
        if(a.getSource() == button[12])
            display.append("1");
        if(a.getSource() == button[13])
            display.append("2");
        if(a.getSource() == button[14])
            display.append("3");
        if(a.getSource() == button[10])
        {
            //multiply
            temporary[0] = Double.parseDouble(display.getText());
            function[2] = true;
            display.setText("");
        }
        if(a.getSource() == button[16])
            display.append(".");
        if(a.getSource() == button[11])
        {
            //divide
            temporary[0] = Double.parseDouble(display.getText());
            function[3] = true;
            display.setText("");
        }
        if(a.getSource() == button[0])
            reset();
        if(a.getSource() == button[1])
            powerOp();
        if(a.getSource() == button[18])
            result();
        if(a.getSource() == button[15])
            display.append("0");
    }

}
