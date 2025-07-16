
package bankmangementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener{
    String pinnumber ;
       JButton deposite , withdrawl ,exit, fastcash , ministatement,pincharge,balenceenquiry;

    FastCash(String pinnumber){
        this.pinnumber = pinnumber ;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Select Your Transactions:");
        text.setBounds(250, 300, 700, 35);
        text.setFont(new Font("System" , Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        image.add(text);
        
         deposite = new JButton("100");
        deposite.setBounds(170, 400, 150, 30);
        deposite.addActionListener(this);
       image.add(deposite);
       
        withdrawl = new JButton("500");
        withdrawl.setBounds(350, 400, 150, 30);
        withdrawl.addActionListener(this);
       image.add(withdrawl);
        
        fastcash   = new JButton("1000");
        fastcash.setBounds(170, 435, 150, 30);
                fastcash.addActionListener(this);
       image.add(fastcash); 
       
        pincharge = new JButton("5000");
        pincharge.setBounds(170, 475, 150, 30);
                pincharge.addActionListener(this);
       image.add(pincharge); 

        ministatement  = new JButton("2000");
        ministatement.setBounds(350, 435, 150, 30);
                ministatement.addActionListener(this);
       image.add(ministatement);

        balenceenquiry = new JButton("10000");
        balenceenquiry.setBounds(350, 475, 150, 30);
                balenceenquiry.addActionListener(this);
       image.add(balenceenquiry);
       
       exit = new JButton("Exit");
        exit.setBounds(275, 520, 150, 30);
                exit.addActionListener(this);
       image.add(exit);

        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText();
                Conn conn = new Conn();
           
                try{
                    ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
                    int balence = 0;
                    while(rs.next()){
                        if(rs.getString("type").equals("deposit")){
                            balence += Integer.parseInt(rs.getString("amount"));
                        }else{
                            balence -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if( balence < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "insufficent balence");
                    return;
                    }
                    Date date = new Date();
                    String query = "insert into bank values('"+pinnumber+"','withdraw','"+date+"','"+amount+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited sucesfully");
                  setVisible(false);
                  new Transactions(pinnumber).setVisible(true);
                }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String[] agrs){
        new FastCash("");
    }
}
