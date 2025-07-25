
package bankmangementsystem;

import javax.swing.*;
import java .util.*;
import java.awt.*;
import java.awt.event.*;

public class Deposit extends JFrame implements ActionListener{
    JTextField amount;
      JButton deposit ,back;
    String pinnumber;
    Deposit(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Enter amount to deposit");
        text.setFont(new Font("Raleway", Font.BOLD , 16));
        text.setForeground(Color.WHITE);
        text.setBounds(250, 300, 400, 20);
          image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("System" , Font.BOLD,22));
        amount .setBounds(170,350,320,25);
        image.add(amount);
        
         deposit = new JButton("Deposit");
        deposit.setBounds(355,485,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
           back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit){
            String number  = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "please enter the amount");
            }else{
                try{
                Conn conn = new Conn();
                String query = "insert into bank values('"+pinnumber+"','deposit','"+date+"','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "rs"+number+"deposit succesfull");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                }catch (Exception e){
                    System.out.println(e);
                }
            }
            
        }else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
 public static void main(String[] agrs){
     new Deposit("");
 }   
}
