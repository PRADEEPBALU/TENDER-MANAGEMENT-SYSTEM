
package tender_management_.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.regex.*;

public class Feedback extends JFrame implements ActionListener{

    JLabel lbl_Role = new JLabel("ROLE");
    JLabel lbl_ID = new JLabel("ID");
    JLabel lbl_Tender_ID = new JLabel("TENDER ID");
    JLabel lbl_Feedback = new JLabel("FEEDBACK");


    JTextField txt_ID = new JTextField();
    JTextField txt_Feedback = new JTextField();


    ButtonGroup buttongroup;
    // JRadioButton male_rb,female_rb;
    JComboBox jcb_Role,jcb_Tender_ID;

    //String gender="";
    JButton register;

    Feedback()
    {
        buttongroup = new ButtonGroup();


        jcb_Role = new JComboBox();
        jcb_Tender_ID = new JComboBox();

        jcb_Tender_ID.addItem("COIMBATORE");
        jcb_Tender_ID.addItem("ERODE");
        jcb_Tender_ID.addItem("CHENNAI");
        jcb_Tender_ID.addItem("SALEM");


        jcb_Role.addItem("User Feedback");
        jcb_Role.addItem("Supplier Feedback");

        register=new JButton("REGISTER");

        lbl_Role.setBounds(20,100,120,25);
        lbl_ID.setBounds(20,200,120,25);
        lbl_Tender_ID.setBounds(20,300,120,25);
        lbl_Feedback.setBounds(20,400,60,25);



        txt_ID.setBounds(230,200,120,25);
        txt_Feedback.setBounds(230, 400,120,25);
        jcb_Role.setBounds(230, 100, 120, 25);
        jcb_Tender_ID.setBounds(230, 300, 120, 25);
        register.setBounds(230, 500, 120, 25);


        add(lbl_Role);
        add(lbl_ID);
        add(lbl_Tender_ID);
        add(lbl_Feedback);


        add(txt_ID);
        add(txt_Feedback);
        add(jcb_Role);
        add(jcb_Tender_ID);

        add(register);

        setTitle("FEEDBACK FORM");
        setSize(1200,800);

        getContentPane().setLayout(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        register.addActionListener(this);
    }
    /* public void itemStateChanged(ItemEvent ie){

        ItemSelectable itemselected=ie.getItemSelectable();

        if(itemselected==male_rb){
                gender="MALE";
        }
        else if(itemselected==female_rb){
                gender="FEMALE";
        }
    } */
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==register)
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/sample?characterEncoding=latin1";
                Connection conn=DriverManager.getConnection(url,"root","pradeep4521");
                PreparedStatement ps=conn.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, jcb_Role.getSelectedItem().toString());
                ps.setString(2, txt_ID.getText().toString());
                ps.setString(3, jcb_Tender_ID.getSelectedItem().toString());
                ps.setString(4, txt_Feedback.getText().toString());




                //String email="^[A-Za-z0-9+_.]+@(.+)$";
                // Pattern epat=Pattern.compile(email);
                // Matcher ematch=epat.matcher(text_email.getText());
                // if(ematch.matches())
                // {
                //   ps.executeUpdate();
                // }
                // else
                // {
                //     JOptionPane.showMessageDialog(null,"Invalid email id");
                // }
                // Pattern pt=Pattern.compile("[6-9][0-9]{9}");
                //  Matcher pmatch=pt.matcher(text_mobile.getText());
                //  if(pmatch.find()&&pmatch.group().equals(text_mobile.getText()))
                //   {
                //   	   ps.executeUpdate();
                //  	   JOptionPane.showMessageDialog(this,"Registred successfully!");
                //   }
                //   else
                //  {
                //       JOptionPane.showMessageDialog(null,"Invalid mobile number");
                //  }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }


    public static void main(String args[])
    {
        new Feedback();
    }
}
