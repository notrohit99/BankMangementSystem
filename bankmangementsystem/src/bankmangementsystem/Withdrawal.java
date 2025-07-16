
package bankmangementsystem;
import java.awt.Image;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class Withdrawal extends JFrame implements ActionListener{
    String pinnumber;
    JButton withdrawal  , back;
    JTextField amount;
    Withdrawal(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3   = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Enter Amount To Withdrawal:");
        text.setFont(new Font("System", Font.BOLD ,16));
        text.setForeground(Color.WHITE);
        text.setBounds(250, 300, 400, 20);
        image.add(text);
        
         amount = new JTextField();
        amount.setFont(new Font("System" , Font.BOLD, 22));
        amount.setBounds(170,350,320,20);
        image.add(amount);
        
         withdrawal = new JButton("Withdrawal");
        withdrawal.setBounds(355,485,150,30 );
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        
         back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setVisible(true);
        setLocation(300,0);
    }
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource() == withdrawal){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount");
            }else{
                try{
                Conn conn = new Conn();
                String query = "insert into bank values('"+pinnumber+"','withdraw','"+date+"','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs: "+number+" withdraw succesfully");
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
     new Withdrawal("");
 }   
}