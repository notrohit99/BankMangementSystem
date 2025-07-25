
package bankmangementsystem;
import javax.swing.*;
import java.sql.*;  

public class MiniStatement extends JFrame {
    String pinnumber;
    MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        setTitle("Mini Statement");
        
        JLabel mini  = new JLabel();
        add(mini);
        
        JLabel bank = new JLabel("Bharat Bank");
        bank.setBounds(150,20 , 100, 30);
        add(bank);
        
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        
        
        try{
            Conn conn = new Conn();
           ResultSet rs =  conn.s.executeQuery("select * from login where pinnumber + '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Cardnumber:"+ rs.getString("cardnumber").substring(0,4) + "XXXXXXXX"+ rs.getString("cardnumber".substring(12)));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            Conn conn  = new Conn();
            int bal = 0 ;
           ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText()+"<html>" + rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
            
            if(rs.getString("type").equals("deposit")){
                bal +=  Integer.parseInt(rs.getString("amount"));
                        }else{
                bal -= Integer.parseInt(rs.getString("amount"));
                        }
            }
            balance.setText("Your Current Balance is " + bal);
        }catch(Exception e){
            System.out.println(e);
        }
        mini.setBounds(20, 140, 400, 200);
        
        setSize(400,600);
        setLocation(20,20);
        setVisible(true);
        
    }
   
    public static void main(String[] args){
        new MiniStatement("");
    }
}
