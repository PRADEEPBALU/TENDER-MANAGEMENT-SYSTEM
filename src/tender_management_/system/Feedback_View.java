package tender_management_.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Feedback_View extends JFrame{
    JFrame f;
    static JTable table;

    public Feedback_View() {

        JTextField Tender_ID = new JTextField();
        JLabel Tender_ID1=new JLabel("Re-Enter Tender_ID");
        Tender_ID1.setBounds(85,70,120,20);add( Tender_ID1);Tender_ID.setBounds(210,70,130,20);add(Tender_ID);
        JButton but,go;
        but=new JButton("view");
        go=new JButton("Go Back");
        but.setBounds(370, 70, 70, 20);add(but);
        go.setBounds(500, 300, 100, 20);add(go);
        String column[]={"Tender_ID","Tender_Name","Tender_type","Requirement","Quantity","Starting_price","Time_Period","Open_Date","Closing_date"};
        setBounds(100, 100, 690, 400);
        setLayout(null);
        setVisible(true);
        setTitle("TENDER VIEW FORM ");
        but.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                display(Tender_ID.getText(),column);
            }

        });
        go.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                new Feedback_View();
                dispose();
            }

        });
    }

    public void display(String s,String[] column){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","java","lakshmi");
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(column);
            table = new JTable();
            table.setModel(model);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            table.setFillsViewportHeight(true);
            JScrollPane scroll = new JScrollPane(table);
            scroll.setHorizontalScrollBarPolicy(
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scroll.setVerticalScrollBarPolicy(
                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            String Tender_ID = "";
            String Tender_Name = "";
            String Tender_type = "";
            String Requirement = "";
            String Quantity ="";
            String Starting_price ="";
            String Time_Period ="";
            String Open_Date = "";
            String Closing_Date = "";
            PreparedStatement pst = con.prepareStatement("select * from details where Tender_ID='" +s+ "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Tender_ID  = rs.getString("Tender_ID");
                Tender_Name = rs.getString("Tender_Name");
                Tender_type = rs.getString("Tender_type");
                Requirement = rs.getString("Requirement");
                Quantity = rs.getString("Quantity");
                Starting_price = rs.getString("Starting_price");
                Time_Period  = rs.getString("Time_Period");
                Open_Date  = rs.getString("Open_Date");
                Closing_Date = rs.getString("Closing_Date");
                model.addRow(new Object[]{Tender_ID,Tender_Name,Tender_type,Requirement,Quantity,Starting_price,Time_Period,Open_Date,Closing_Date});
            }
            add(scroll);
            table.setBounds(50, 140, 600, 70);
            add(table);
        }catch(Exception e) {
            System.out.print(e);
        }
    }
    public static void main(String[] args) {
        new Feedback_View();
    }


}