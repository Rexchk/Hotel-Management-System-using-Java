package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddRooms extends JFrame implements ActionListener{
    JButton add,cancel;
    JTextField tfroomno,tfprice;
    JComboBox availableCombo,cleanCombo,typeCombo;
     AddRooms() {
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
         JLabel heading = new JLabel("Add Rooms");
         heading.setFont(new Font("Tahoma",Font.BOLD,18));
         heading.setBounds(150,20,200,20);
         add(heading);
         
         JLabel lblroomno = new JLabel("Room Number");
         lblroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
         lblroomno.setBounds(60,80,120,30);
         add(lblroomno);
         
         tfroomno = new JTextField();
         tfroomno.setBounds(200,80,150,30);
         add(tfroomno);
         
         JLabel lblavailable = new JLabel("Available");
         lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
         lblavailable.setBounds(60,130,120,30);
         add(lblavailable);
         
         String availableOptions[] = {"Available","Occupied"};
         availableCombo = new JComboBox(availableOptions);
         availableCombo.setBounds(200,130,150,30);
         availableCombo.setBackground(Color.WHITE);
         add(availableCombo);
         
         JLabel lblclean = new JLabel("Cleaning Status");
         lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
         lblclean.setBounds(60,180,120,30);
         add(lblclean);
         
         String cleanOptions[] = {"Clean","Dirty"};
         cleanCombo = new JComboBox(cleanOptions);
         cleanCombo.setBounds(200,180,150,30);
         cleanCombo.setBackground(Color.WHITE);
         add(cleanCombo);
             
         JLabel lblprice = new JLabel("Price");
         lblprice.setBounds(60,230,120,30);
         lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
         add(lblprice);
         
         tfprice = new JTextField();
         tfprice.setBounds(200,230,150,30);
         add(tfprice);
         
         JLabel lblbedtype = new JLabel("Bed Type");
         lblbedtype.setFont(new Font("Tahoma",Font.PLAIN,16));
         lblbedtype.setBounds(60,280,120,30);
         add(lblbedtype);
         
         String typeOptions[] = {"Single Bed","Double Bed"};
         typeCombo = new JComboBox(typeOptions);
         typeCombo.setBounds(200,280,150,30);
         typeCombo.setBackground(Color.WHITE);
         add(typeCombo);
         
         add = new JButton("Add Rooms");
         add.setForeground(Color.WHITE);
         add.setBackground(Color.BLACK);
         add.setBounds(60,350,130,30);
         add.addActionListener(this);
         add(add);
     
         cancel = new JButton("Cancel");
         cancel.setForeground(Color.WHITE);
         cancel.setBackground(Color.BLACK);
         cancel.setBounds(220,350,130,
                 30);
         cancel.addActionListener(this);
         add(cancel);
         
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
         JLabel image = new JLabel(i1);
         image.setBounds(400,30,500,300);
         add(image);
         
         
         setBounds(330,200,940,470);
         setVisible(true);
    }
     
     @Override
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()== add){
             String roomnumber = tfroomno.getText();
             String availability = (String)availableCombo.getSelectedItem();
             String status = (String)cleanCombo.getSelectedItem();
             String price = tfprice.getText();
             String type = (String)typeCombo.getSelectedItem();
             
             try{
                 Conn c = new Conn();
                 String str = "insert into room values('"+roomnumber+"', '"+availability+"', '"+status+"', '"+price+"', '"+type+"')";
                 c.s.executeUpdate(str);
                 
                 JOptionPane.showMessageDialog(null, "New Room Added Successfully");
                 setVisible(false);
             }
             catch(Exception e){
                 e.printStackTrace();
             }
         }
         else{
             setVisible(false);
         }
     }
    
    
    public static void main(String[] args){
        new AddRooms();
    }
}
