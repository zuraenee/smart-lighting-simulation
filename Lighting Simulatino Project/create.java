import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
import java.util.*;
import java.awt.Color;
public class create implements ActionListener
{
    JFrame frame = new JFrame();

    JButton createnew = new JButton("Create New Project");
    JButton openold = new JButton("Open Old Project");
    JTextField nameofnew = new JTextField();
    String projectname = "";
    public create(){
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        
        createnew.addActionListener(this);
        openold.addActionListener(this);
        
        frame.add(createnew, BorderLayout.NORTH);
        frame.add(openold, BorderLayout.SOUTH);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource().equals(createnew)){
            frame.add(nameofnew, BorderLayout.CENTER);
            projectname = nameofnew.getText();
        }
    }
}
