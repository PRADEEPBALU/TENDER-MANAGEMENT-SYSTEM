
package tender_management_.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.regex.*;

public class User_registration extends JFrame implements ActionListener{
        JLabel userid_lb=new JLabel("USER ID");
        JLabel userfname_lb=new JLabel("FIRST NAME");
        JLabel userlname_lb=new JLabel("LAST NAME");
        JLabel gender_lb=new JLabel("GENDER");
        JLabel email_lb=new JLabel("EMAIL ID");
        JLabel password=new JLabel("PASSWORD");
        JLabel confirmPassword=new JLabel("CONFIRM PASSWORD");
        JLabel mobNo=new JLabel("MOBILE NO");
        JLabel address_lb=new JLabel("ADDRESSS");
        JLabel city=new JLabel("CITY");
        JLabel state=new JLabel("STATE");
        
        
        JTextField userid_tf=new JTextField();
        JTextField userfname_tf=new JTextField();
        JTextField userlname_tf=new JTextField();
        JTextArea address_tf=new JTextArea();
        JTextField email_tf=new JTextField();
        JTextField mob_tf=new JTextField();
        JPasswordField password_pf=new JPasswordField();
        JPasswordField conPassword_pf=new JPasswordField();
        
        ButtonGroup btngroup;
        JRadioButton male_rb,female_rb;
        JComboBox city_cb,state_cb;
        
        String gender="";
        JButton register,reset,back;
        int count=0;
    
    User_registration()
    {
        
        setContentPane(new JLabel(new ImageIcon("E:\\BOOTCAMP\\PROJECT\\Tender management System")));
        
        btngroup=new ButtonGroup();
        male_rb=new JRadioButton("Male");
        female_rb=new JRadioButton("Female"); 
        btngroup.add(male_rb);
        btngroup.add(female_rb);
        
        city_cb=new JComboBox();
        state_cb=new JComboBox();
        
        city_cb.addItem("Coimbatore");
        city_cb.addItem("Chennai");
        city_cb.addItem("Erode");
        city_cb.addItem("Karur");
        city_cb.addItem("Madurai");
        city_cb.addItem("Namakkal");
        city_cb.addItem("Trichy");
        city_cb.addItem("Salem");
        city_cb.addItem("Kochi");
        city_cb.addItem("Thiruvananthapuram");
        city_cb.addItem("Bangalore");
        city_cb.addItem("Mysore");

        state_cb.addItem("TAMIL NADU");
        state_cb.addItem("KARNATAKA");
        state_cb.addItem("KERALA");
        
        register=new JButton("REGISTER");
        reset=new JButton("RESET");
        back=new JButton("GO BACK");
        
        userid_lb.setBounds(20,50,120,25);
        userfname_lb.setBounds(20,150,120,25);
        userlname_lb.setBounds(20,250,120,25);
        gender_lb.setBounds(20,350,60,25);
        address_lb.setBounds(20,450,120,25);
        email_lb.setBounds(600,50,120,25);
        password.setBounds(600,150,120,25);
        confirmPassword.setBounds(600,250,150,25);
        mobNo.setBounds(600,350,120,25);
        city.setBounds(600,450,120,25);
        state.setBounds(600,550,120,25);

        userid_tf.setBounds(230, 50, 200, 25);
        userfname_tf.setBounds(230, 150, 200, 25);
        userlname_tf.setBounds(230, 250, 200, 25);
        male_rb.setBounds(230, 350, 100, 25);
        female_rb.setBounds(330, 350, 100, 25);
        address_tf.setBounds(230, 450, 200, 120);
        email_tf.setBounds(750, 50, 200, 25);
        password_pf.setBounds(750, 150, 200, 25);
        conPassword_pf.setBounds(750,250,200,25);
        mob_tf.setBounds(750, 350, 200, 25);
        city_cb.setBounds(750, 450, 200, 25);
        state_cb.setBounds(750, 550, 200, 25);
        register.setBounds(350, 620, 120, 25);
        reset.setBounds(550, 620, 120, 25);
        
        back.setBounds(750, 700, 120, 25);
        
        add(userid_lb);
        add(userfname_lb);
        add(userlname_lb);
        add(gender_lb);
        add(address_lb);
        add(email_lb);
        add(password);
        add(confirmPassword);
        add(mobNo);
        add(city);
        add(state);
        
        add(userid_tf);
        add(userfname_tf);
        add(userlname_tf);
        add(male_rb);
        add(female_rb);
        add(address_tf);
        add(email_tf);
        add(password_pf);
        add(conPassword_pf);
        add(mob_tf);
        add(city_cb);
        add(state_cb);
        
        add(register);
        add(reset);
        add(back);
        
        setTitle("USER REGISTRATION FORM");
        setSize(1200,800);
        //getContentPane().setBackground(Color.CYAN);
        /*Image img=Toolkit.getDefaultToolkit().getImage("E:\BOOTCAMP\PROJECT\Tender management System");
        this.setContentPane(new JPanel(){
                public void paintComponent(Graphics g)
                {
                    super.paintComponents(g);
                    g.drawImage(img, 0, 0, null);
                }
        });*/
        getContentPane().setLayout(null);
        
        //add(bg);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        register.addActionListener(this);
        reset.addActionListener(this);
        back.addActionListener(this);
    }
    /*public void itemStateChanged(ItemEvent ie){

        ItemSelectable itemselected=ie.getItemSelectable();

        if(itemselected==male_rb){
                gender="male";
        }
        else if(itemselected==female_rb){
                gender="female";
        }
    }*/
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==register)
        {
            try
            {
                
                if(male_rb.isSelected())
                {
                    gender="male";
                }
                else if(female_rb.isSelected())
                {
                    gender="female";
                }
                
                
                
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","tms","tender");
                PreparedStatement ps=conn.prepareStatement("insert into User_Register values(?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, userid_tf.getText().toString());
                ps.setString(2, userfname_tf.getText().toString());
                ps.setString(3, userlname_tf.getText().toString());
                ps.setString(4, email_tf.getText().toString());
                ps.setString(5, password_pf.getText().toString());
                ps.setString(6, gender);
                ps.setString(7, mob_tf.getText().toString());
                ps.setString(8, address_tf.getText().toString());
                ps.setString(9, city_cb.getSelectedItem().toString());
                ps.setString(10, state_cb.getSelectedItem().toString());
                
                conn.setAutoCommit(true);
                if(password_pf.getText().equalsIgnoreCase(conPassword_pf.getText()))
                {
                    //ps.executeUpdate();
                    count++;
               }
               else
               {
                    JOptionPane.showMessageDialog(null, "Password did not match");
                    
                }
                
                String email="^[A-Za-z0-9+_.]+@(.+)$";
                Pattern epat=Pattern.compile(email);
                Matcher ematch=epat.matcher(email_tf.getText());
                if(ematch.matches())
                {
                 //   ps.executeUpdate();
                                        count++;

                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid email id");
                }
                
                Pattern pt=Pattern.compile("[6-9][0-9]{9}");
                Matcher pmatch=pt.matcher(mob_tf.getText());
                if(pmatch.find()&&pmatch.group().equals(mob_tf.getText()))
                {
                 //   ps.executeUpdate();
                 //   JOptionPane.showMessageDialog(this,"Registred successfully!");
                    count++;
                }
                else
               {
                    JOptionPane.showMessageDialog(null,"Invalid mobile number");
                    
                }
               if(count==3) 
               {
                   ps.executeUpdate();
                   JOptionPane.showMessageDialog(this,"Registered successfully!!!");
               }
               count=0;
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
            
        }
        
        if(ae.getSource()==reset)
        {
            userid_tf.setText("");
            userfname_tf.setText("");
            userlname_tf.setText("");
            address_tf.setText("");
            email_tf.setText("");
            password_pf.setText("");
            conPassword_pf.setText("");
            mob_tf.setText("");
            city_cb.setSelectedItem("Coimbatore");
            state_cb.setSelectedItem("TAMIL NADU");
            //gender.split("");
        }
        
        
        if(ae.getSource()==back)
        {
            
            new Userlogin();
            dispose();
    }
        }
    

    public static void main(String args[])
    {
        new User_registration();
    }
    
    
}