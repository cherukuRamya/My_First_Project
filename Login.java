import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Vector;
import javax.swing.text.*;
import java.awt.*;
import java.lang.*;
import java.awt.image.*;
import javax.imageio.*;
import java.sql.*;
import java.lang.String;
import javax.swing.plaf.*;
import javax.swing.plaf.metal.*;
import java.io.Serializable;


public class Login extends JFrame implements ActionListener,Serializable {
    JLabel label1;
    JLabel label2;
    JTextField textfield1;
    JPasswordField passwordfield2;
    JButton button1;
    JLabel label3;
    
    
    public Login() {
        LoginLayout customLayout = new LoginLayout();

        getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);
        getContentPane().setBackground(Color.YELLOW);

        label1 = new JLabel("Login Name");
        getContentPane().add(label1);
        label1.setFont(new Font("Bookman Old Style",Font.BOLD,20));

        label2 = new JLabel("Password");
        getContentPane().add(label2);
        label2.setFont(new Font("Bookman Old Style",Font.BOLD,20));

        textfield1 = new JTextField();
        getContentPane().add(textfield1);
        textfield1.setFont(new Font("RockWell",Font.PLAIN,18));

        passwordfield2 = new JPasswordField();
        getContentPane().add(passwordfield2);
        passwordfield2.setEchoChar('^');
        passwordfield2.setFont(new Font("SansSerif",Font.BOLD,20));

        //ImageIcon icon1 = new ImageIcon("r1.jpg");
        button1 = new JButton("LOGIN");
        getContentPane().add(button1);
        button1.addActionListener(this);
        button1.setFont(new Font("Engravers MT",Font.BOLD,20));
        
         //ImageIcon icon = new ImageIcon("r1.jpg");
         //label3 = new JLabel("",icon,JLabel.LEFT);
         //getContentPane().add(label3);
       
        
        
        

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
        Login window = new Login();
       
        window.setTitle("Congestion Avoidance for Smart Devices by Caching Information in MANETS and IoT");
        window.pack();
        window.show();
        
        JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		
		try
		{
			   	UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	           // javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		
		}
		catch (Exception ex)
		{
			System.out.println("Failed loading L&F: ");
			System.out.println(ex);
		}
    }

public void actionPerformed(ActionEvent e)
  {

    String cmd;
    cmd=e.getActionCommand();
    if(cmd.equals("LOGIN"))
    {
    String user=textfield1.getText().trim().toLowerCase();
	String password=passwordfield2.getText().trim().toLowerCase();
	
		 String DBusername ="Admin";
     	String DBpassword = "Admin";
     	
     	

			if (DBusername.equalsIgnoreCase("Admin") && DBpassword.equalsIgnoreCase("Admin"))
			{
			  dispose();
			  Stegno s = new Stegno();
			  s.pack();
			  s.show();
			  s.setTitle("Steganography Implementation - Main Menu");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"!!! ***Username and password do not match*** !!!","Error",JOptionPane.INFORMATION_MESSAGE);
				textfield1.setText("");	
				passwordfield2.setText("");
			}
   }

}
class LoginLayout implements LayoutManager {

    public LoginLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 650 + insets.left + insets.right;
        dim.height = 400 + insets.top + insets.bottom;

        return dim;
    }

    public Dimension minimumLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);
        return dim;
    }

    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();

        Component c;
        c = parent.getComponent(0);
        if (c.isVisible()) {c.setBounds(insets.left+150,insets.top+100,136,32);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+150,insets.top+150,136,32);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+100,154,35);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+150,154,35);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+276,insets.top+216,160,48);}
        //c = parent.getComponent(5);
        //if (c.isVisible()) {c.setBounds(insets.left+0,insets.top+0,700,600);}
    }
}
}
