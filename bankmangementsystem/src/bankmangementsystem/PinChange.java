 
package bankmangementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class PinChange extends JFrame implements ActionListener{
    String pinnumber;
    JPasswordField pin,repin;
    JButton change, back;
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
          ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3   = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        
        
        JLabel text = new JLabel("Change your Pin:-");
        text.setFont(new Font("System", Font.BOLD ,16));
        text.setForeground(Color.WHITE);
        text.setBounds(250, 290, 500, 25);
        image.add(text);
        
        pin =new JPasswordField();
        pin.setBounds(270,320, 200, 20);
        pin.setFont(new Font("Arial",Font.BOLD,14));
        add(pin);
        
        JLabel pintext = new JLabel("NEW PIN:");
        pintext.setFont(new Font("System", Font.BOLD ,16));
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(165, 320,180, 25);
        image.add(pintext);
        
           
        JLabel repintext = new JLabel("RE-PIN:");
        repintext.setFont(new Font("System", Font.BOLD ,16));
        repintext.setForeground(Color.WHITE);
        repintext.setBounds(165, 360,180, 25);
        image.add(repintext);
        
         repin =new JPasswordField();
        repin.setBounds(270,360, 200, 20);
        repin.setFont(new Font("Arial",Font.BOLD,14));
        add(repin);
        
        change = new JButton("Change");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);
        
         back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            try{
                String npin =  pin.getText();
                String rpin = repin.getText();
                
                if(!rpin.equals(npin)){
                    JOptionPane.showMessageDialog(null, "pin not matched");
                return;
                }
                if(npin.equals("")){
                 JOptionPane.showMessageDialog(null, "enter your  pin");
                 return;
                }
                if(rpin.equals("")){
                 JOptionPane.showMessageDialog(null, "enter your  repin");
                 return;
                }
                
                Conn conn = new Conn();
                String query1 = "update bank set pinnumber ='"+rpin+"' where pinnumber = '"+pinnumber+"' ";
                String query2 = "update login set pinnumber ='"+rpin+"' where pinnumber = '"+pinnumber+"' ";
                String query3 = "update signup3 set pinnumber ='"+rpin+"' where pinnumber = '"+pinnumber+"' ";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
             JOptionPane.showMessageDialog(null,"pn change sucessfully");

                setVisible(false);
                new Transactions(rpin).setVisible(true);
            
            }catch(Exception e){
                System.out.print(e);
            }
            
     
        }else{
        setVisible(false);     
        new Transactions(pinnumber).setVisible(true);
    }
    }
    
    
    public static void main(String[] args){
        new PinChange("").setVisible(true);
    }
}
