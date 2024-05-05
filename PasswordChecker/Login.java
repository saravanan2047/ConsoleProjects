package PasswordChecker;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login  implements ActionListener
{
	JFrame frame= new JFrame();  
	JButton loginButton = new JButton("Check"); 
	JTextField password= new JTextField();
	JLabel Passswordlabel = new JLabel("Password: ");
	JLabel messageLabel = new JLabel(); // for message
	JLabel instruction = new JLabel();
	HashMap<String, String> logininfoOr= new HashMap<String,String>();
	
	//Constructor
	Login( HashMap <String,String> loginoriginal)
     {
    	 logininfoOr =loginoriginal;    
    	 Passswordlabel .setBounds(50,150,75,25);
    	 messageLabel.setBounds(110,250,250,35);    	 
    	 messageLabel.setFont(new Font(null,Font.ITALIC,25));
    	 instruction.setBounds(122,100,250,25);    	         
    	 instruction.setFont(new Font(null,Font.ITALIC,13));
    	 password.setBounds(125,150,200,25);    	 
    	 loginButton.setBounds(160,200,100,25); 
    	 loginButton.setFocusable(false);
    	 loginButton.addActionListener(this);  
    	 frame.add(password);
    	 frame.add(loginButton);
    	 frame.add(Passswordlabel);
    	 frame.add(messageLabel);
    	 frame.add(instruction);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 frame.setSize(420,420);
    	 frame.setLayout(null);
    	 frame.setVisible(true);
    	 instruction.setForeground(Color.black);
    	 instruction.setText("Use  A-Z ,a-z ,1-9, !@#$%^&*()_+  ");
    	 
     }
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==loginButton)
		{
			String userID =password.getText();
			//String PassWord =String.valueOf(((JPasswordField) password).getPassword());
			String res=passwordChecker.checker(userID);
			String s1="Strong";
			String s2="Medium";
			String s3="Weak";
			String s4="Invalid";
			if(res.equals(s1))
			{
				messageLabel.setForeground(Color.green);
				messageLabel.setText("Strong Password 💪");
			}
			else if(res.equals(s2))
			{
				messageLabel.setForeground(Color.orange);
				messageLabel.setText("Medium Password👍");
			}
			else if(res.equals(s3))
			{
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Weak Password ⚠");
			}
			else if(res.equals(s4))
			{
				messageLabel.setForeground(Color.blue);
				messageLabel.setText("Enter Valid Password");
			}
			else {}	
		}
		
	}
}
