package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class HotelManagementSystem extends JFrame implements ActionListener{

   HotelManagementSystem(){
   
    setSize(1366,565);
    setLocation(100,100);
    setLayout(null);
    

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/First.jpg"));
    JLabel image = new JLabel(i1);
    image.setBounds(0,0,1366,565);
    add(image);
    
    JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
    text.setBounds(20,430,1000,90);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("serif",Font.BOLD,50));
    image.add(text);
    
    JButton next = new JButton("Next");
    next.setBounds(1150,450,150,50);
    next.setBackground(Color.WHITE);
    next.setForeground(Color.RED);
    next.addActionListener(this);
    next.setFont(new Font("serif",Font.BOLD,24));
    image.add(next);
    
    setVisible(true);
    while(true){
        text.setVisible(false);
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        text.setVisible(true);
         try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   }
       @Override
    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new Login();
    }
    public static void main(String[] args){
       HotelManagementSystem obj = new HotelManagementSystem();
    }    
}
