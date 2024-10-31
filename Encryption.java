import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.math.*;
import javax.imageio.ImageIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.event.*;
import javax.swing.filechooser.*;
import java.beans.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.lang.*;
import java.awt.event.ActionEvent;
import java.awt.font.*;
import java.lang.String;
import java.awt.Component;
import java.awt.geom.*;
import javax.swing.text.EditorKit;
import javax.swing.event.MouseInputAdapter;
import java.awt.image.BufferedImage;
import javax.swing.text.*;
import javax.crypto.Cipher;
import java.security.*;
import java.lang.Exception;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
//import javax.crypto.BadPaddingException;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.NoSuchPaddingException;
import java.io.FilterInputStream;
import javax.crypto.*;
//import java.security.AlgorithmParameters;
import java.math.BigInteger;
//import java.security.interfaces.*;
//import java.security.KeyException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import javax.crypto.spec.*;
import java.security.spec.*;
import java.applet.*;
import java.net.*;
import javax.swing.Timer;
import javax.swing.TransferHandler;

public class Encryption extends JFrame implements ActionListener,Serializable{
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JButton button1;
    JButton button2;
    JTextField textfield1;
    JTextArea textarea2;
    JScrollPane sp_textarea2;
    JPasswordField passwordfield3;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    
    JFileChooser filechooser;
    File f,tempfilename,Ofilename,Sfilename;
    int Copened,Cencrypt,Csave;
    InetAddress ipaddress;
    String name,Ekey,address;
    String chosenFile;
    InputStream ins;
    OutputStream outs;
    Thread t;
    
    
    public Encryption() 
    {
        EncryptionLayout customLayout = new EncryptionLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);
        getContentPane().setBackground(Color.YELLOW);

        label1 = new JLabel("SOURCE");
        getContentPane().add(label1);
        label1.setFont(new Font("Garamond", Font.BOLD, 16));

        label2 = new JLabel("MESSAGE");
        getContentPane().add(label2);
        label2.setFont(new Font("Garamond", Font.BOLD, 16));

        label3 = new JLabel("KEY");
        label3.setVisible(false);
        getContentPane().add(label3);
        label3.setFont(new Font("Garamond", Font.BOLD, 16));

        button1 = new JButton("BACK");
        getContentPane().add(button1);
        button1.addActionListener(this);
        button1.setFocusable(true);
        button1.setRolloverEnabled(true);
        button1.setContentAreaFilled(true);
		button1.setBorderPainted(true);
        button1.setVerifyInputWhenFocusTarget(true);
        button1.setFont(new Font("Garamond", Font.BOLD, 16));

        button2 = new JButton("NEXT");
        getContentPane().add(button2);
        button2.setFocusable(true);
        button2.setContentAreaFilled(true);
		button2.setBorderPainted(true);
        button2.setRolloverEnabled(true);
        button2.setVerifyInputWhenFocusTarget(true);
        button2.addActionListener(this);
        button2.setFont(new Font("Garamond", Font.BOLD, 16));

        textfield1 = new JTextField("");
        getContentPane().add(textfield1);
        textfield1.setEditable(false);
        textfield1.setBackground(Color.LIGHT_GRAY);
        textfield1.setToolTipText("Choose the image file to be encrypted");
        
        
        textarea2 = new JTextArea("");
        getContentPane().add(textarea2);
        textarea2.setFocusable(true);
        GraphicsEnvironment.getLocalGraphicsEnvironment();
        textarea2.setAutoscrolls(true);
        textarea2.setWrapStyleWord(true);
        textarea2.setBackground(Color.LIGHT_GRAY);
        textarea2.setToolTipText("Enter the message to be embedded with image");
        
       sp_textarea2 = new JScrollPane(textarea2);
       getContentPane().add(sp_textarea2);
        
        passwordfield3 = new JPasswordField("");
        getContentPane().add(passwordfield3);
        passwordfield3.setVisible(false);
        passwordfield3.setToolTipText("Enter a 6 digit KEY");

        button3 = new JButton("BROWSE");
        getContentPane().add(button3);
        button3.addActionListener(this);
        button3.setFocusable(true);
        button3.setContentAreaFilled(true);
		button3.setBorderPainted(true);
        button3.setRolloverEnabled(true);
        button3.setVerifyInputWhenFocusTarget(true);
        button3.setFont(new Font("Garamond", Font.BOLD, 16));

        button4 = new JButton("CLEAR");
        getContentPane().add(button4);
        button4.setFocusable(true);
        button4.setContentAreaFilled(true);
		button4.setBorderPainted(true);
        button4.setToolTipText("Clears the Textarea");
        button4.setRolloverEnabled(true);
        button4.setVerifyInputWhenFocusTarget(true);
        button4.addActionListener(this);
        button4.setFont(new Font("Garamond", Font.BOLD, 16));
        
        button5 = new JButton("SAVE");
        getContentPane().add(button5);
        button5.setFocusable(true);
        button5.setContentAreaFilled(true);
		button5.setBorderPainted(true);
        button5.setToolTipText("Saves the Encrypted image file");
        button5.setRolloverEnabled(true);
        button5.setVerifyInputWhenFocusTarget(true);
        button5.addActionListener(this);
        button5.setFont(new Font("Garamond", Font.BOLD, 16));
        
        button6 = new JButton("SEND");
        getContentPane().add(button6);
        button6.setFocusable(true);
        button6.setContentAreaFilled(true);
		button6.setBorderPainted(true);
        button6.setToolTipText("Sends the Encrypted image file to the remote machine");
        button6.setRolloverEnabled(true);
        button6.setVerifyInputWhenFocusTarget(true);
        button6.addActionListener(this);
        button6.setFont(new Font("Garamond", Font.BOLD, 16));
        button6.setVisible(false);
        
        Copened=0;
        Cencrypt=0;
        Csave=0;
        
    filechooser=new JFileChooser();
    filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    
        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
   
   public static void main(String args[])  {
        Encryption en = new Encryption();

        en.setTitle("Encryption");
        en.show();
        en.pack();
        JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try
		{
		
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		//javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		}
		catch (Exception ex)
		{
			System.out.println("Failed loading L&F: ");
			System.out.println(ex);
		}
	
	 }
    public void Imageencrypt(String message,File file,int key) throws java.io.IOException 
    {
    byte b[]=new byte[2];
    
    BigInteger Abi,Mbi;
    int k,k1;
    DataInputStream ins=new DataInputStream(new FileInputStream(file));
    DataOutputStream outs=new DataOutputStream(new FileOutputStream(new File("1.jpg")));
    for(int c=0;c<key;c++)
     {
      int ch=ins.read();
      outs.write(ch);
     }
    int len=message.length();
    byte mess[]=new byte[2];
    char chmess[]=new char[len+1];
    k=k1=0;
    for(int i=0;i<=len;i++)
     {
      message.getChars(0,len,chmess,0);
      if(i==0)
       {
        BigDecimal bd=new BigDecimal(len);
        BigInteger Blen=bd.toBigInteger();
        String Slen=Blen.toString(2);
        char Clen[]=new char[Blen.bitLength()];
        Slen.getChars(0,Blen.bitLength(),Clen,0);
        for(int j=0;j<=7;j++)
         {
          if(j==0)
           {
            for(k=0;k<8-Blen.bitLength();k++)
             {
              int n=ins.read(b);
              Abi=new BigInteger(b);
              String Aby=Abi.toString(2);
              int Alen=Abi.bitLength();
              if(b[0]<0)
                Alen++;
              char Ach[]=new char[Alen+1];
              Aby.getChars(0,Alen,Ach,0);

	      if(b[0]==0)
	       {
	       }
	      else
	       {
              if(Ach[Alen-1]=='1')
               {
                if(Alen==Abi.bitLength())
		 {
                  BigInteger bi=new BigInteger("1111111111111110",2);
                  BigInteger big=Abi.and(bi);
		  b=big.toByteArray();
		 }
 		else
		 {
  	                  BigInteger bi=new BigInteger("-1",2);
        	          BigInteger big=Abi.subtract(bi);
		  b=big.toByteArray();
		 }
               }
		outs.write(b);
  	       }
           }  //for loop k
         j=j+k-1;
         } // if of j
    		else
	         {
        	  int n=ins.read(b);
	          Abi=new BigInteger(b);
        	  String Aby=Abi.toString(2);
	          int Alen=Abi.bitLength();
                  if(b[0]<0)
                  Alen++;
	          char Ach[]=new char[Alen+1];
	          Aby.getChars(0,Alen,Ach,0);
	         if(b[0]==0)
        	  {
                   Alen=1;
	          }
	            if(Clen[j-k]=='0' && Ach[Alen-1]=='1')
        	     {
                       if(Alen==Abi.bitLength())
                        {
                 	 BigInteger bi=new BigInteger("1111111111111110",2);
	                 BigInteger big=Abi.and(bi);
			 b=big.toByteArray();
                        }
                       else
                        {
  	                  BigInteger bi=new BigInteger("-1",2);
        	          BigInteger big=Abi.subtract(bi);
			 b=big.toByteArray();
                        }
             	     }
	            else if(Clen[j-k]=='1' && Ach[Alen-1]=='0')
        	     {
                      if(Alen==Abi.bitLength())
			 {
                	BigInteger bi=new BigInteger("1",2);
			BigInteger big=Abi.add(bi);
			b=big.toByteArray();
			 }
                      else
			 {
                	BigInteger bi=new BigInteger("-1",2);
			BigInteger big=Abi.add(bi);
			b=big.toByteArray();
			 }

        	     }
       		   outs.write(b);
                 } // end else

    	    } // for loop j

        } // end of if

      else
       {
        String slen=String.valueOf(chmess[i-1]);
        byte blen[]=slen.getBytes();
        BigInteger Blen=new BigInteger(blen);
        String Slen=Blen.toString(2);
        char Clen[]=new char[Blen.bitLength()];
        Slen.getChars(0,Blen.bitLength(),Clen,0);
        for(int j=0;j<=7;j++)
         {
          if(j==0)
           {
            for(k1=0;k1<8-Blen.bitLength();k1++)
             {
              int n=ins.read(b);
              Abi=new BigInteger(b);
	      String Aby=Abi.toString(2);
              int Alen=Abi.bitLength();
                  if(b[0]<0)
                  Alen++;
              char Ach[]=new char[Alen+1];
              Aby.getChars(0,Alen,Ach,0);
 		if(b[0]==0)
		       {

		       }
	      else
	       {
	              if(Ach[Alen-1]=='1')
        	       {
                        if(Alen==Abi.bitLength())
                         {
                	  BigInteger bi=new BigInteger("1111111111111110",2);
	                  BigInteger big=Abi.and(bi);
			  b=big.toByteArray();
                         }
                        else
                         {
  	                  BigInteger bi=new BigInteger("-1",2);
        	          BigInteger big=Abi.subtract(bi);
			  b=big.toByteArray();
                         }
        	       }
	       }
		outs.write(b);

              }  //for loop k

		j=j+k1-1;

             } // if of j

        else
         {
          int n=ins.read(b);
           Abi=new BigInteger(b);
              String Aby=Abi.toString(2);
              int Alen=Abi.bitLength();
                  if(b[0]<0)
                  Alen++;
              char Ach[]=new char[Alen+1];
              Aby.getChars(0,Alen,Ach,0);
      		if(b[0]==0)
		       {
			Alen=1;
		       }

	            if(Clen[j-k1]=='0' && Ach[Alen-1]=='1')
	             {
			if(Alen==Abi.bitLength())
 			 {
  	                  BigInteger bi=new BigInteger("1111111111111110",2);
        	          BigInteger big=Abi.and(bi);
			  b=big.toByteArray();
                         }
                        else
 			 {
  	                  BigInteger bi=new BigInteger("-1",2);
        	          BigInteger big=Abi.subtract(bi);
			  b=big.toByteArray();
                         }
	             }
        	    else if(Clen[j-k1]=='1' && Ach[Alen-1]=='0')
	             {
			if(Alen==Abi.bitLength())
			 {
  		     	  BigInteger bi=new BigInteger("1",2);
                	  BigInteger big=Abi.add(bi);
			  b=big.toByteArray();
 			 }
			else
			 {
  		     	  BigInteger bi=new BigInteger("-1",2);
                	  BigInteger big=Abi.add(bi);
			  b=big.toByteArray();
 			 }
        	     }
		outs.write(b);
         } // end else

       } // for loop j
     } // end of else

   } // for loop i

  while(true)
   {
    int i=ins.read();
    if(i==-1) break;
    outs.write(i);
   }
    ins.close();
    outs.close();
   }
    
public void actionPerformed(ActionEvent e)
  {
 
    try
    {
    String cmd;
   
    cmd=e.getActionCommand();
    
    if(cmd.equals("BACK"))
    {  
      dispose();
      Stegno s = new Stegno();
      s.show();
      s.pack();
      s.setTitle("Main Menu - Implementation of Steganography");
    }
    if(cmd.equals("CLEAR"))
    {
    textarea2.setText("");	 
    }
    if(cmd.equals("SAVE"))
    {
    	
        if(Copened==1 && Cencrypt==1)
       {
        int r=filechooser.showSaveDialog(this);
        Sfilename=filechooser.getSelectedFile();
        FileInputStream in=new FileInputStream("1.jpg");
        FileOutputStream out=new FileOutputStream(Sfilename);
        
        Ofilename=Sfilename;
        textfield1.setEditable(true);
        textfield1.setText(Sfilename.getPath());
        textfield1.setEditable(false);
        
       while(true)
         {
          int i=in.read();
          if(i==-1) break;
          out.write(i);
         }
       
       in.close();
       out.close();
       JOptionPane.showMessageDialog(null,"\nYour image file has been encrypted and saved successfully\n","message",JOptionPane.INFORMATION_MESSAGE);
       
       }
      else
       {
        String m;
        if(Copened==0)
         m="File not Opened";
        else if(Cencrypt==0)
         m="Not Encrypted";
        else
         m="Not Decrypted";
         
        
JOptionPane.showMessageDialog(this,m,"Error",JOptionPane.ERROR_MESSAGE);
       }
     } 
   	
    if(cmd.equals("NEXT"))
     {
     	  
     if(Copened==1)
       {
        
        Ekey=JOptionPane.showInputDialog("Enter 4 digit Key For Encryption");
	 
//String type
        if(Ekey==null)
        {
        JOptionPane.showMessageDialog(this,"Enter only 4 Digit key","Error",JOptionPane.ERROR_MESSAGE);	
        } 	
         if(Ekey.trim().length()<4)
         {
         JOptionPane.showMessageDialog(this,"Enter only 4 Digit key","Error",JOptionPane.ERROR_MESSAGE);		
         }	
         if(Ekey.trim().length()>4)
         JOptionPane.showMessageDialog(this,"Enter only 4 Digit key","Error",JOptionPane.ERROR_MESSAGE);
         
         else
         {
          // encrypt the message
     
          int key=Integer.parseInt(Ekey);
         Imageencrypt(textarea2.getText(),Ofilename,key);
          Cencrypt=1;
         }
       }
      else
       {
        JOptionPane.showMessageDialog(this,"File NotOpened","Error",JOptionPane.ERROR_MESSAGE);
       }
     } 
     
    if(cmd.equals("BROWSE"))
    {
    	int r=filechooser.showOpenDialog(this);
     tempfilename=filechooser.getSelectedFile(); //File type
     
      if(r==JFileChooser.CANCEL_OPTION)
       JOptionPane.showMessageDialog(this,"FileNotSelected","Error",JOptionPane.ERROR_MESSAGE);
      else
       {
       String name=tempfilename.getName();

        if((!name.endsWith(".jpg")) && !name.endsWith(".gif") && !name.endsWith(".bmp")&& !name.endsWith(".jpeg"))  

          JOptionPane.showMessageDialog(this,"Select Only Image file","Error",JOptionPane.ERROR_MESSAGE);

        else
          {
            Copened=1;
            Ofilename=tempfilename;
            textfield1.setText(name);
            textfield1.setText(tempfilename.getPath());
            textfield1.setFont(new Font("Century",Font.PLAIN,15));
            textfield1.setBackground(Color.LIGHT_GRAY);
            textfield1.setEditable(false);
           }
          }
        }

    } // end try
    
     catch(Exception xe)
     {
     	//xe.printStackTrace();
JOptionPane.showMessageDialog(this,xe,"Error",JOptionPane.ERROR_MESSAGE);
     }

   } // end of actionperformed
} // End of class
    
class EncryptionLayout implements LayoutManager {

    public EncryptionLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 700 + insets.left + insets.right;
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
        if (c.isVisible()) {c.setBounds(insets.left+75,insets.top+74,112,32);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+75,insets.top+170,112,32);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+160,112,32);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+145,insets.top+294,124,38);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+300,insets.top+294,124,38);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+158,insets.top+74,390,32);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+158,insets.top+120,390,150);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+160,284,52);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+558,insets.top+74,114,35);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+558,insets.top+173,114,35);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+450,insets.top+294,124,38);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+559,insets.top+204,114,35);}
       
      
    }
}
