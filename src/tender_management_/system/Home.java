
package tender_management_.system;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import static java.lang.System.in;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.Action;
import java.sql.*;

public class Home extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5;
    JButton menu,aboutus,feedback;
    
    Home(){
        
        l1=new JLabel("SKI TENDER MANAGEMENT ");  
        l1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        l1.setForeground(Color.blue);
        l1.setBounds(350,90,500,50);
        l2=new JLabel("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");  
        l2.setBounds(70,150,1050,55);
        add(l1);add(l2);
         l3=new JLabel();
        l3.setText("<html>===>The Tender Management System is a project which is developed to enable the suppliers to get all\n "
                + "the tender details online and provide facility to submit the tender.By using this application we can save a lot of time by making the documents\n "
                + "online instead of sending and receiving documents using the postal system.<html>");
                
        l3.setBounds(100,200,950,200);
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        add(l3);
        
        add(l1);add(l2);
         l4=new JLabel();
         l4.setText("<html>===>Traditionally Tender Management System work needs to be completed manually.In Our Tender Management "
                 + "System many tenders will be released by the User everyday and the new tenders are published by the Admin so that"
                 + " Suppliers can view them and if they are interested they can apply for the tender.");
        l4.setFont(new Font("Arial", Font.BOLD, 20));
         l4.setBounds(100,370,950,200);
         add(l4);
        l5=new JLabel("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");  
        l5.setBounds(70,550,1050,55);
        add(l5);
        aboutus=new JButton("About Us");
        aboutus.setBounds(250,650,120, 50);
        add(aboutus);
        menu=new JButton("Menu");
        menu.setBounds(1000,20,120, 50);
        add(menu);
        feedback=new JButton("Feedback");
        feedback.setBounds(800,650, 120, 50);
        add(feedback);
        setTitle(" HOME PAGE ");
        setSize(1200,800);  
        setLayout(null);  
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    
    menu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                
                new Menu();
                dispose();
            }
        
        });
    aboutus.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                
                new AboutUs();
                dispose();
            }
        
        });
    feedback.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                
                new Feedback();
                dispose();
            }
        
        });
}
    public static void main(String[] args) {
		new Home();
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    
    
}