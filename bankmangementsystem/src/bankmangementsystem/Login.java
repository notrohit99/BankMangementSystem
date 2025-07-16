package bankmangementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
     JButton login, signup, clear;
     JLabel Cardno,text,label;
     JTextField cardTextField;
     JPasswordField pinTextField;
    Login(){
        setTitle("Automatic Teller Machine");
        setLayout(null);
        //put image add awt for icon image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));//adding image
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);//for give location
        ImageIcon i3 = new ImageIcon(i2);//
        label = new JLabel(i3);//for show the image 
        label.setBounds(120,10, 100, 100);//to set left right up down
        add(label);
        
        //add text in frame
         text = new JLabel("Welcom to ATM");
        text.setFont(new Font("OSWARD",Font.BOLD,38));
        text.setBounds(250,40,400,40);
        add(text);
        
         Cardno = new JLabel("Card no:");
        Cardno.setFont(new Font("raleway",Font.BOLD,28));
        Cardno.setBounds(120,150,250,30);
        add(Cardno);
        //add rectangle space for entering
        cardTextField =new JTextField();
        cardTextField.setBounds(300,150, 250, 30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
                
                
         JLabel pinno = new JLabel("Pin no:");
        pinno.setFont(new Font("raleway",Font.BOLD,28));
        pinno.setBounds(120,220,250,30);
        add(pinno);
        
         pinTextField =new JPasswordField();
        pinTextField.setBounds(300,220, 250, 30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
        //button makeing start wth JButton
         login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        
         clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
        
        //frame background color
        getContentPane().setBackground(Color.WHITE);
        
        //frame make
       setSize(800,480);
       setVisible(true);//for see the frame
       setLocation(350,200);//for set the location default centre
    }
 
 
    public  void actionPerformed(ActionEvent ae){
   try{
      if(ae.getSource() == login){
   Conn conn = new Conn();
   String cardnumber = cardTextField.getText();
   String pinnumber = pinTextField.getText();
   String query = "select * from login where cardnumber = '"+cardnumber+"' and pinnumber = '"+pinnumber+"'";
  
           ResultSet rs = conn.s.executeQuery(query);
           if(rs.next()){
               setVisible(false);
               new Transactions(pinnumber).setVisible(true);
           }else{
              JOptionPane.showMessageDialog(null , "incorrect pin or card number"); 
      }
      }else if(ae.getSource() == clear){
              cardTextField.setText("");
              pinTextField.setText("");}
          else if(ae.getSource() == signup){
              setVisible(false);
              new signup().setVisible(true); 
          }
   } catch(Exception e){
           System.out.print(e);
      }
    }
    
        
    
    public static void main(String[] agrs){
        new Login();
    }
}
