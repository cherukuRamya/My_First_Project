import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
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
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.imageio.ImageIO;
import java.util.Vector;
import javax.swing.text.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.String;
import java.lang.Byte;
import java.math.*;
import java.security.*;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import javax.crypto.*;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.interfaces.*;
import java.security.KeyException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;


class Decryption extends JFrame implements ActionListener,Serializable {
    JLabel label1;
   JLabel label2;
    JLabel label3;
    JButton button1;
    JButton button2;
    JTextField textfield1;
    JTextField textfield2;
    JTextArea textarea3;
    JScrollPane sp_textarea3;
    JButton button3;
    JButton button4;
    JFileChooser filechooser;
    File f,tempfilename,Ofilename,Sfilename;
    int Copened,Cdecrypt;
    String name,Dkey;
    String chosenFile;
    
    

    public Decryption() 
    {
        decryptionLayout customLayout = new decryptionLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);
        getContentPane().setBackground(Color.YELLOW);

        label1 = new JLabel("SOURCE");
        getContentPane().add(label1);
        label1.setFont(new Font("Garamond", Font.BOLD, 16));

        label2 = new JLabel("IMAGE");
        getContentPane().add(label2);
        label2.setVisible(false);
        label2.setFont(new Font("Garamond", Font.BOLD, 16));

        label3 = new JLabel("MESSAGE");
        getContentPane().add(label3);
        label3.setToolTipText("Encrypted message is:");
        label3.setFont(new Font("Garamond", Font.BOLD, 16));

        button1 = new JButton("BACK");
        getContentPane().add(button1);
        button1.setFocusable(true);
        button1.setRolloverEnabled(true);
        button1.setVerifyInputWhenFocusTarget(true);
        button1.addActionListener(this);
        button1.setFont(new Font("Garamond", Font.BOLD, 18));

        button2 = new JButton("NEXT");
        getContentPane().add(button2);
        button2.setFocusable(true);
        button2.setRolloverEnabled(true);
        button2.setVerifyInputWhenFocusTarget(true);
        button2.addActionListener(this);
        button2.setFont(new Font("Garamond", Font.BOLD, 18));

        textfield1 = new JTextField("");
        getContentPane().add(textfield1);
        textfield1.setEditable(false);
        textfield1.setBackground(Color.LIGHT_GRAY);
        textfield1.setToolTipText("Choose the file to decrypt for message");

        textfield2 = new JTextField("");
        getContentPane().add(textfield2);
        textfield2.setVisible(false);
        textfield2.setToolTipText("Choose the image file to be encrypted");

        textarea3 = new JTextArea("");
        getContentPane().add(textarea3);
        textarea3.setBackground(Color.LIGHT_GRAY);
        textarea3.setToolTipText("The Encrypted Message is ::");
        textarea3.setEditable(false);
        sp_textarea3 = new JScrollPane(textarea3);
        sp_textarea3.setWheelScrollingEnabled(true);
        textarea3.setFocusable(true);
       
        
        getContentPane().add(sp_textarea3);

        button3 = new JButton("BROWSE");
        getContentPane().add(button3);
        button3.setFocusable(true);
        button3.setRolloverEnabled(true);
        button3.setVerifyInputWhenFocusTarget(true);
        button3.addActionListener(this);
        button3.setToolTipText("Select the Encrypted image file");
        button3.setFont(new Font("Garamond", Font.BOLD, 16));

        button4 = new JButton("BROWSE");
        getContentPane().add(button4);
        button4.addActionListener(this);
        button4.setVisible(false);
        button4.setFont(new Font("Garamond", Font.BOLD, 16));
        
        Copened=0;
        Cdecrypt=0;
        FileInputStream ins;
        FileOutputStream outs;
        byte b[];
        int len;
        
    filechooser=new JFileChooser();
    filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    
    public void Imagedecrypt(File filename,int key)throws java.io.IOException
 {
 FileInputStream ins=new FileInputStream(filename);
  byte b[]=new byte[2];
  BigInteger bb1;
  char mess[]=new char[8];
  int c=0;
  for(int i=0;i<key;i++)
  {
   int n=ins.read();
  }
  for(int i=0;i<8;i++)
   {
    ins.read(b);
    bb1=new BigInteger(b);
    String str=bb1.toString(2);
    int len=bb1.bitLength();
    if(b[0]<0)
     len++;
    char ch[]=new char[len+1];
    str.getChars(0,len,ch,0);
    if(b[0]==0)
     mess[i]='0';
    else
     mess[i]=ch[len-1];
   }
  String dd=new String(mess);
  BigInteger bb=new BigInteger(dd,2);
  String s=bb.toString(2);
 int l=bb.intValue();

char me[]=new char[l];
int count=0;

for(int m=0;m<l;m++)
 {
for(int i=0;i<8;i++)
   {
    ins.read(b);
    bb1=new BigInteger(b);
    String str=bb1.toString(2);
    int len=bb1.bitLength();
    if(b[0]<0)
     len++;
    char ch[]=new char[len+1];
    str.getChars(0,len,ch,0);
    if(b[0]==0)
     mess[i]='0';
    else
     mess[i]=ch[len-1];
   }
  String dd1=new String(mess);
  BigInteger bb2=new BigInteger(dd1,2);
  String s1=bb2.toString(2);
 int l1=bb2.intValue();
 me[count]=(char)l1;
 count++;
 }
String message=new String(me);
textarea3.setText(message);
ins.close();

 }

    public static void main(String args[]) throws Exception
    {
        Decryption dn = new Decryption();

        dn.setTitle("Decryption");
        dn.show();
        dn.pack();
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
      s.setTitle("Main Menu");
      
    }
    if(cmd.equals("NEXT"))
     {
      if(Copened==1)
       {
        Dkey=JOptionPane.showInputDialog("Enter 4 digit Key For Decryption");
//String type
        if(Dkey.trim().equals(""))
         JOptionPane.showMessageDialog(this,"Invalid Input","Error",JOptionPane.ERROR_MESSAGE);
        else
         {
          // decrypt the message
          int key=Integer.parseInt(Dkey);
          Imagedecrypt(Ofilename,key);
          Cdecrypt=1;
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

          JOptionPane.showMessageDialog(this,"Select Only Encrypted Image file","Error",JOptionPane.ERROR_MESSAGE);

        else
          {
            Copened=1;
            Ofilename=tempfilename;
            textfield1.setEditable(true);
            textfield1.setText(tempfilename.getPath());
            textfield1.setFont(new Font("Century",Font.PLAIN,15));
            textfield1.setBackground(Color.LIGHT_GRAY);
            //textfield1.setText(name);
            textfield1.setEditable(false);
           }

         }
            }
            } // end try
    catch(Exception ae)
     {
     //
JOptionPane.showMessageDialog(this,e,"Error",JOptionPane.ERROR_MESSAGE);
     }      
}

class decryptionLayout implements LayoutManager {

    public decryptionLayout() {
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
        if (c.isVisible()) {c.setBounds(insets.left+75,insets.top+64,112,32);}
       c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+112,112,32);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+75,insets.top+165,112,32);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+204,insets.top+294,134,42);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+380,insets.top+294,134,42);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+165,insets.top+64,390,32);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+112,264,70);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+165,insets.top+110,390,150);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+570,insets.top+64,104,32);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+480,insets.top+112,104,32);}
    }
}
}
