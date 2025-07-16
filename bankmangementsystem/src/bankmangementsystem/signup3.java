
package bankmangementsystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class signup3 extends JFrame implements ActionListener{
      JRadioButton saving ,  fixed , current , recurring;
       JButton submit , cencel;
      JCheckBox  email$sms , mobile , internetbank, atmcard ,cheque, estatement,declare;
        String formno;
     
      
      signup3(String formno){
          this.formno  = formno;
        setTitle("Acount detail");
        setLayout(null);
         JLabel Accdet = new JLabel("Page 3: Additional Details");
        Accdet.setFont(new Font("Raleway" , Font.BOLD,22));
        Accdet.setBounds(290, 80, 400, 30);
        add(Accdet);
        
        JLabel acctype =new JLabel("Account Type");
        acctype.setFont(new Font("Raleway",Font.BOLD,18));
        acctype.setBounds(100,140, 200, 40);
        add(acctype);
        
         saving = new JRadioButton("Saving Account");
        saving.setFont(new Font("Raleway", Font.BOLD,14));
        saving.setBounds(100, 180,200, 30);
        saving.setBackground(Color.WHITE);
        add(saving);
        
       
         fixed = new JRadioButton("Fixed Deosit Account");
        fixed.setFont(new Font("Raleway", Font.BOLD,14));
        fixed.setBounds(400, 180,200, 30);
        fixed.setBackground(Color.WHITE);
        add(fixed);
        
          current = new JRadioButton("Current Account");
        current.setFont(new Font("Raleway", Font.BOLD,14));
        current.setBounds(100, 230,200, 30);
        current.setBackground(Color.WHITE);
        add(current);
        
         recurring = new JRadioButton("Recurring Deposit Account");
        recurring.setFont(new Font("Raleway", Font.BOLD,14));
        recurring.setBounds(400, 230,400, 30);
        recurring.setBackground(Color.WHITE);
        add(recurring);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(saving);
         groupaccount.add(fixed);
          groupaccount.add(current);
           groupaccount.add(recurring);
        
         JLabel cnumber = new JLabel("Card Number");
        cnumber.setFont(new Font("Raleway" , Font.BOLD,22));
        cnumber.setBounds(100, 280, 400, 40);
        add(cnumber);
         JLabel yourcardno = new JLabel("Your 16 Digit Card Number");
        yourcardno.setFont(new Font("Raleway" , Font.BOLD,12));
        yourcardno.setBounds(100, 310, 400, 20);
        add(yourcardno);
         JLabel cardnumber = new JLabel("XXXX-XXXX-XXXX-4148");
        cardnumber.setFont(new Font("Raleway" , Font.BOLD,22));
        cardnumber.setBounds(350, 280, 600, 30);
        add(cardnumber);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway" , Font.BOLD,22));
        pin.setBounds(100, 340, 200, 30);
        add(pin);
        
        JLabel pindetail = new JLabel("Your 4 digit Password");
        pindetail.setFont(new Font("Raleway" , Font.BOLD,12));
        pindetail.setBounds(100, 360, 500, 20);
        add(pindetail);
        
        JLabel pinnumber = new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway" , Font.BOLD,22));
        pinnumber.setBounds(350, 340, 200, 30);
        add(pinnumber);
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setVisible(true);
        setLocation(350,10);
         JLabel servicereq = new JLabel("Service Required:");
        servicereq.setFont(new Font("Raleway" , Font.BOLD,22));
        servicereq.setBounds(100, 410, 400, 30);
        add(servicereq);
        atmcard = new JCheckBox("ATM Card");
        atmcard.setFont(new Font("Raleway",Font.BOLD,18));
        atmcard.setBounds(100, 480,200, 30);
        atmcard.setBackground(Color.WHITE);
        add(atmcard);
        
          internetbank = new JCheckBox("Internet Banking");
        internetbank.setFont(new Font("Raleway",Font.BOLD,18));
        internetbank.setBounds(380, 480,200, 30);
        internetbank.setBackground(Color.WHITE);
        add(internetbank);
        
          mobile = new JCheckBox("Mobile Banking");
        mobile.setFont(new Font("Raleway",Font.BOLD,18));
        mobile.setBounds(100, 510,200, 30);
        mobile.setBackground(Color.WHITE);
        add(mobile);
        
        email$sms = new JCheckBox("Email & SMS Alerts");
        email$sms.setFont(new Font("Raleway",Font.BOLD,18));
        email$sms.setBounds(380, 510,200, 30);
        email$sms.setBackground(Color.WHITE);
        add(email$sms);
        
        
          cheque = new JCheckBox("Cheque Banking");
        cheque.setFont(new Font("Raleway",Font.BOLD,18));
        cheque.setBounds(100, 540,200, 30);
        cheque.setBackground(Color.WHITE);
        add(cheque);
        
          estatement = new JCheckBox("E-Statement");
        estatement.setFont(new Font("Raleway",Font.BOLD,18));
        estatement.setBounds(380, 540,200, 30);
        estatement.setBackground(Color.WHITE);
        add(estatement);
        
        declare = new JCheckBox("I hereby declear that the above information is entered are correct.");
        declare.setBackground(Color.WHITE);
        declare.setBounds(100,620,600,30);
        declare.setFont(new Font("Raleway" , Font.BOLD, 14));
        add(declare);
        
        
         submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD,12));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(300, 660, 100, 30);
       submit.addActionListener(this);
        add(submit);
        
           cencel = new JButton("Cencel");
        cencel.setFont(new Font("Raleway", Font.BOLD,12));
        cencel.setBackground(Color.BLACK);
        cencel.setForeground(Color. WHITE);
        cencel.setBounds(440, 660, 100, 30);
        cencel.addActionListener(this);
        add(cencel);
    }
    
    
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == submit){
        String acctype = null;
        if(saving.isSelected()){
            acctype = "Saving Account";
        }else if(fixed.isSelected()){
            acctype = "Fixed Deposit Account";
        }else if(current.isSelected()){
            acctype = "Crrent Account";
        }else if(recurring.isSelected()){
            acctype = "Reccuring Deposit Account";
        }
        Random random = new Random();
        String cardnumber = "" + Math.abs((random.nextLong() % 900000L))+98780000L;
        
        String pinnumber = "" + Math.abs((random.nextLong() %  9000L)+ 1000L);
        
        String  facility = "";
        if(atmcard.isSelected()){
            facility = facility + "ATM Card";
        }else if(internetbank.isSelected()){
            facility = facility +"Internet Banking";
            
        }else if(mobile.isSelected()){
            facility = facility + "Mobile Banking";
        }else if(cheque.isSelected()){
            facility = facility + "Cheque Book";
        }else if(estatement.isSelected()){
            facility = facility + "E-Statement";
            
        }else if(email$sms.isSelected()){
            facility = facility + "Email $ Sms Alerts";
        }
        try{
        if(acctype.equals("")){
           JOptionPane.showMessageDialog(null , "Account type is empty");
        }
           Conn c1 = new Conn();
           
           String query1 = "insert into signup3 values('"+formno+"','"+acctype+"','"+facility+"','"+cardnumber+"','"+pinnumber+"')";
           String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";

           c1.s.executeUpdate(query1);
           c1.s.executeUpdate(query2);
       JOptionPane.showMessageDialog(null, "Cardnumber" + cardnumber + "pinnumber" + pinnumber);
       
       setVisible(false);
       new Deposit(pinnumber).setVisible(true);
       
       }catch(Exception e){
            System.out.println(e);
        }
    
    }else if(ae.getSource() == cencel){
        setVisible(false);
        new Login().setVisible(true);
     }
    }
    
    public static void main(String agrs[]){
        new signup3("");
    }
}
