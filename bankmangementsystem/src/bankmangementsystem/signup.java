
package bankmangementsystem;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;


public class signup extends JFrame implements ActionListener{
   
     long random;
     JTextField nameTextField ,fnameTextField , emailTextField, addrTextField, cityTextField,stateTextField,pinTextField;
     JRadioButton male , female, married , unmarried , other;
     JButton next;
     JDateChooser datechooser;
     
    signup(){
        setLayout(null);
               
        Random ran = new Random();
         random = Math.abs((ran.nextLong() % 9000L)+1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO : " + random );
        formno.setFont(new Font("Raleway" , Font.BOLD,38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
       
        
         JLabel personaldet = new JLabel("Page 1: Personal Details");
        personaldet.setFont(new Font("Raleway" , Font.BOLD,22));
        personaldet.setBounds(290, 80, 400, 30);
        add(personaldet);
        
           JLabel name = new JLabel("Name:");
       name.setFont(new Font("Raleway" , Font.BOLD,20));
       name.setBounds(100, 140, 100, 30);
       add(name);
        
          nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        
        
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway" , Font.BOLD , 20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
         fnameTextField= new JTextField();
        fnameTextField.setBounds(300,190,400,30);
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(fnameTextField);
        
           JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway" , Font.BOLD , 20));
        gender.setBounds(100,240,200,30);
        add(gender);
         male = new JRadioButton("Male");
        male.setBackground(Color.WHITE);
        male.setBounds(300, 240, 100, 30);
        add(male);
        
         female = new JRadioButton("Female");
        female.setBackground(Color.WHITE);
        female.setBounds(400, 240, 100, 30);
        add(female);
        
        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(male);
        groupgender.add(female);
        
        
        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway" , Font.BOLD , 20));
        dob.setBounds(100,290,200,30);
        add(dob);
        datechooser = new JDateChooser();
        datechooser.setBounds(300, 290, 400, 30);
        datechooser.setForeground(new Color(150,150,150));
        add(datechooser);
        
           JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway" , Font.BOLD , 20));
        email.setBounds(100,340,200,30);
        add(email);
        
           emailTextField= new JTextField();
        emailTextField.setBounds(300,340,400,30);
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(emailTextField);
        
         JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway" , Font.BOLD , 20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
          married = new JRadioButton("Married");
         married.setBackground(Color.WHITE);
        married.setBounds(300, 390, 100, 30);
        add(married);
        
          unmarried = new JRadioButton("Unmaried");
         unmarried.setBackground(Color.WHITE);
        unmarried.setBounds(400, 390, 100, 30);
        add(unmarried);
        
          other = new JRadioButton("Other");
         other.setBackground(Color.WHITE);
        other.setBounds(500, 390, 100, 30);
        add(other);
        
           JLabel Address = new JLabel("Address:");
        Address.setFont(new Font("Raleway" , Font.BOLD , 20));
        Address.setBounds(100,440,200,30);
        add(Address);
        
           addrTextField= new JTextField();
        addrTextField.setBounds(300,440,400,30);
        addrTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(addrTextField);
        
           JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway" , Font.BOLD , 20));
        city.setBounds(100,490,200,30);
        add(city);
        
           cityTextField= new JTextField();
       cityTextField.setBounds(300,490,400,30);
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(cityTextField);
        
        
           JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway" , Font.BOLD , 20));
        state.setBounds(100,540,200,30);
        add(state);
        
           stateTextField= new JTextField();
        stateTextField.setBounds(300,540,400,30);
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(stateTextField);
        
        
           JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway" , Font.BOLD , 20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
           pinTextField= new JTextField();
        pinTextField.setBounds(300,590,400,30);
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(pinTextField);
         
         next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD ,14));
        next.setBounds(600, 630, 100, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setVisible(true);
        setLocation(350,10);
    }
    public void actionPerformed(ActionEvent ae){
        
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "female";
        }
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        }else if(unmarried.isSelected()){
            marital = "unmarried";
            
        }else if(other.isSelected()){
            marital = "other";
        }
        String addres = addrTextField.getText();
        String email = emailTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        
        try{
        if(name.equals("")){
           JOptionPane.showMessageDialog(null , "Name Is Not Fill");
        }else{
            Conn c1 = new Conn();
            String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+addres+"','"+city+"','"+state+"','"+pin+"')";
           c1.s.executeUpdate(query);
           
              setVisible(false);
              new signup2(formno).setVisible(true);}
         
        
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    public static void main(String args[]){
       new signup().setVisible(true);
    }
}
