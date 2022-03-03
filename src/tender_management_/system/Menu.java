
package tender_management_.system;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Menu extends JFrame {
    


    JFrame f2 ;
     Menu(){
  JLabel v1,v2,v3,v4;
  v3=new JLabel("....  Menu ....");
  JButton vb1,vb2,vb3,vb4;
  v1=new JLabel("If you are Admin  , click ");
  v2=new JLabel("If you are User , click");
  v4=new JLabel("If you are Supplier, click");
  vb1=new JButton("Admin");
  vb2=new JButton("User");
  vb3=new JButton("Go Back");
  vb4=new JButton("Supplier");
  v3.setBounds(150,15,100,25);
  v1.setBounds(50, 70, 500, 30);
  vb1.setBounds(220, 75, 90, 25);
  v2.setBounds(50,130,500,30);
  vb2.setBounds(220,135,90,25);
  v4.setBounds(50,190,500,30);
  vb4.setBounds(220,195,90,25);
  vb3.setBounds(280,260,90,25);
  add(v1);add(vb1);add(v2);add(vb2);add(v3);add(vb3);add(v4);add(vb4);
  setBounds(530,150,400,350);  
  setLayout(null);  
  setVisible(true);
  setTitle(" MENU ");
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  vb3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                
                new Home();
                dispose();
            }
        
        });
  
  
  vb1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                
                new Admin_login();
                dispose();
            }
        
        });
  
  vb2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new Userlogin();
                dispose();
            }
        
        });
  
  vb4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new Supplierlogin();
                dispose();
            }
        
        });
  
}
public static void main(String args[]){  
   new  Menu();  
}

        }