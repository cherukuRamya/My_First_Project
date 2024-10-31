
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;




public class ReceiverC implements ActionListener {
	JFrame jf;
	Container c;
	JLabel l1, l2, l3,image;
	JTextField t1, t2;
	JTextArea ta1, ta2;
	JButton b1, b2;
	JScrollPane sp1;
	JLabel p11, p22, p33, p44, p55, p66, p77, p88, p99, p100,img11,img22,img33,img44,img55,img66;
	String ConRout1, rc1, fname;
	 String path;
	Random rd;
	int seq;
	
	ReceiverC() {
		
		jf = new JFrame("ReceiverC::Securing Data in Internet of Things Using Cryptography and Steganography Techniques");
		c = jf.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		l1 = new JLabel("File Receiver");

		b1 = new JButton("Un Stegano Data");
		
		
		img11 = new JLabel();
		img22 = new JLabel();
		img33 = new JLabel();
		img44 = new JLabel();
		img55 = new JLabel();
		img66 = new JLabel();
			
		ImageIcon img1 = new ImageIcon(this.getClass().getResource("servermonitor.png"));
		l2 = new JLabel();
		l2.setIcon(img1);
		//l2.setBounds(25, 0, 525, 350);

		ta1 = new JTextArea();
		ta1.setRows(100);
		ta1.setColumns(100);
		
		sp1 = new JScrollPane();
		sp1.setViewportView(ta1);
		sp1.setBounds(80, 340, 380, 265);
		
		b1.setBounds(120, 540, 170, 35);
		b1.addActionListener(this);
		
		c.add(l1);c.add(img11);
		//c.add(sp1);
		c.add(b1);
		
		c.add(l2);
		jf.show();
		jf.setSize(550, 650);
		
		int[] ports = new int[]{11111};
		  for(int i=0;i<1;i++)
		  {
			  Thread t1 = new Thread(new PortListener(ports[i]));
			  t1.start();
		  }	 
	}
	class PortListener implements Runnable
	  {
		  ServerSocket ss1,ss2;
		  Socket cn1,cn2;
		  int port;
		  
		  public PortListener(int port)
		  {
			  this.port = port;
		  }
		  public void run()
		  {
			  if(this.port == 11111)
			  {
				  try
				  {
					  ss1 = new ServerSocket(11111);
					  while(true)
					  {
						  cn1 = ss1.accept();
						  ObjectInputStream ois = new ObjectInputStream(cn1.getInputStream());
							
							String fname = (String) ois.readObject();	
							byte[] ct=(byte[])ois.readObject();
							

							FileOutputStream fos = new FileOutputStream("SteganoImageC/"
									+ fname);
							fos.write(ct);
							fos.close();
							
							l2.setVisible(false);
							Thread.sleep(1000);
							l2.setVisible(true);
							l2.setBounds(25, 0, 500, 400);
							Thread.sleep(1000);
							l2.setVisible(false);
							Thread.sleep(1000);
							l2.setVisible(true);
							l2.setBounds(25, 0, 500, 400);
							Thread.sleep(1000);
							l2.setVisible(false);
							Thread.sleep(1000);
							l2.setVisible(true);
							l2.setBounds(25, 0, 500, 400);
							Thread.sleep(1000);
							l2.setVisible(true);
							l2.setBounds(25, 0, 500, 400);
								
							
							
						
					  }
				  }catch(Exception ee)
				  {
					  ee.printStackTrace();
				  }
			  }
		  }
	   }
	public void actionPerformed(ActionEvent e1)
	{
if (e1.getSource() == b1) {
			
			try
			{
			
				 Receiver_Decryption dn = new Receiver_Decryption();
		         	dn.setTitle("Un Stegano Data");
		         	dn.pack();
		         	dn.show();
	          	
			
			
	    
			}
			catch(Exception ec)
			{System.out.println(ec);}
		}
		
		
	}
	
	public static void main(String[] args) {
		new ReceiverC();
	}
}