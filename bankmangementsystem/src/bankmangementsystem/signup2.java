

package bankmangementsystem;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class signup2 extends JFrame implements ActionListener{
   
     
     JTextField aadharTextField,panTextField;
     JRadioButton yes , No;
     JButton next;
     JComboBox education1, ocupation1,religion , income1, category1;
     String formno;
     
     
    signup2(String formno){
        this.formno = formno;
        setLayout(null);
               
        setTitle("NEW APPLICATION FORM 2");
        
 
        
         JLabel personaldet = new JLabel("Page 2: Additional Details");
        personaldet.setFont(new Font("Raleway" , Font.BOLD,22));
        personaldet.setBounds(290, 80, 400, 30);
        add(personaldet);
        
           JLabel religio = new JLabel("Religion:");
       religio.setFont(new Font("Raleway" , Font.BOLD,20));
       religio.setBounds(100, 140, 100, 30);
       add(religio);
       String valreligion[] = {"Hindu" , "Muslim","Sikh","Chirstian","Other" };
       
       religion = new JComboBox(valreligion);
       religion.setBounds(300, 140, 400, 30);
       religion.setBackground(Color.WHITE);
       add(religion);
        
        
        
        
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway" , Font.BOLD , 20));
        category.setBounds(100,190,200,30);
        add(category);
        String valcategory[] ={"General","OBC","SC","ST"};
        
         category1 = new JComboBox(valcategory);
        category1.setBounds(300, 190, 400, 30);
        add(category1);
        
        
        
           JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway" , Font.BOLD , 20));
        income.setBounds(100,240,200,30);
        add(income);
        String valincome[] = {"Less Than 1Lakh" , "1Lakh - 2Lakh" , "2Lakh - 4Lakh","More Than 5Lakh"}; 
          income1 = new JComboBox(valincome);
         income1.setBounds(300, 240, 400, 30);
         income1.setBackground(Color.WHITE);
         add(income1);
        
        JLabel education = new JLabel("Education " + 
                "Qualification");
        education.setFont(new Font("Raleway" , Font.BOLD , 20));
        education.setBounds(100,290,200,30);
        add(education);
        String valeducation[] = {"Non-Graduate" , "Graduate" , "Post-graduate","Other"}; 
          education1 = new JComboBox(valeducation);
         education1.setBounds(300, 290, 400, 30);
         education1.setBackground(Color.WHITE);
         add(education1);
        
           JLabel ocupation = new JLabel("Occupation:");
        ocupation.setFont(new Font("Raleway" , Font.BOLD , 20));
        ocupation.setBounds(100,340,200,30);
        add(ocupation);
        String valocupation[] = {"Salaried" , "Self-Employed" , "Business","Student","Retired"}; 
          ocupation1 = new JComboBox(valocupation);
         ocupation1.setBounds(300, 340, 400, 30);
         ocupation1.setBackground(Color.WHITE);
         add(ocupation1);
        
        
        
           JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway" , Font.BOLD , 20));
       pan.setBounds(100,390,200,30);
        add(pan);
        
           panTextField= new JTextField();
        panTextField.setBounds(300,390,400,30);
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(panTextField);
        
           JLabel aadhar = new JLabel("Aadhaar Number");
        aadhar.setFont(new Font("Raleway" , Font.BOLD , 20));
        aadhar.setBounds(100,440,200,30);
        add(aadhar);
        
           aadharTextField= new JTextField();
        aadharTextField.setBounds(300,440,400,30);
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(aadharTextField);
        
           JLabel seniorc = new JLabel("Senior Citizen:");
        seniorc.setFont(new Font("Raleway" , Font.BOLD , 20));
        seniorc.setBounds(100,490,200,30);
        add(seniorc);
        yes = new JRadioButton("yes");
        yes.setBackground(Color.WHITE);
        yes.setBounds(300, 490, 100, 30);
        add(yes);
        
         No = new JRadioButton("No");
        No.setBackground(Color.WHITE);
        No.setBounds(400, 490, 100, 30);
        add(No);
        
        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(yes);
        groupgender.add(No);
       
        JLabel existing = new JLabel("Existing Account:");
        existing.setFont(new Font("Raleway" , Font.BOLD , 20));
        existing.setBounds(100,540,200,30);
        add(existing);
        
      
        yes = new JRadioButton("yes");
        yes.setBackground(Color.WHITE);
        yes.setBounds(300, 540, 100, 30);
        add(yes);
        No = new JRadioButton("No");
        No.setBackground(Color.WHITE);
        No.setBounds(400, 540, 100, 30);
        add(No);
        
          ButtonGroup groupexisting = new ButtonGroup();
        groupexisting.add(yes);
        groupexisting.add(No);
        
        
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
          
        String aadhar = aadharTextField.getText();
        String pan = panTextField.getText();
        String religion1 = (String)religion.getSelectedItem();
        String category = (String) category1.getSelectedItem();
        String income = (String) income1.getSelectedItem();
        String occupation =(String) ocupation1.getSelectedItem();
        String education = (String) education1.getSelectedItem();
         String existing = null;
        if(yes.isSelected()){
            existing = "Yes";
        }else if(No.isSelected()){
            existing = "No";
        }
        String seniorc = null;
        if(yes.isSelected()){
            seniorc = "Yes";
        }else if(No.isSelected()){
            seniorc = "No";
            
        }
      
        try{
        if(category.equals("")){
           JOptionPane.showMessageDialog(null , "Name is Not Fill");
        }else{
            Conn c1 = new Conn();
            String query = "insert into signup2 values('"+formno+"','"+religion1+"','"+category+"','"+income+"','"+occupation+"','"+seniorc+"','"+pan+"','"+aadhar+"','"+existing+"','"+education+"')";
           c1.s.executeUpdate(query);
           
          //signup3 object
          setVisible(false);
          new signup3(formno).setVisible(true);
        } 
        
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    public static void main(String args[]){
       new signup2("");
    }
}


  

