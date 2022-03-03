
package tender_management_.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.regex.*;

public class Admin_login extends JFrame implements ActionListener{
    
    JLabel email_lb;
    JLabel password_lb;
    JLabel l1;
    
    JTextField email_tf;
    JPasswordField password_tf;
    
    JButton login;
    JButton back;
    
    Admin_login()
    {
        email_lb=new JLabel("EMAIL ID");
        password_lb=new JLabel("PASSWORD");
        l1=new JLabel("Don't have an account? click");
        
        email_tf=new JTextField();
        password_tf=new JPasswordField();
        
        login=new JButton("LOG IN");
        back=new JButton("GO BACK");
        
        email_lb.setBounds(50,50,120,40);
        password_lb.setBounds(50,150,120,40);
        email_tf.setBounds(230,50,200,40);
        password_tf.setBounds(230,150,200,40);
        login.setBounds(120,300,120,40);
        back.setBounds(300,300,120,40);
        
        add(email_lb);
        add(password_lb);
        add(email_tf);
        add(password_tf);
        add(login);
        add(back);
        
        setTitle("ADMIN LOGIN");
        setSize(600, 600);
        getContentPane().setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                
                new Menu();
                dispose();
            }
        
        });
        
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        
    }
    
    public static void main(String args[])
    {
        new Admin_login();
    }
}