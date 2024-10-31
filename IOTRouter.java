
import java.awt.Color;
import javax.swing.*;
import java.awt.Container;
import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;


public class IOTRouter extends JFrame implements ActionListener{
	JFrame jf;
	JPanel c;
	 String content;
	JLabel l1, l2, l, l3, l4, l5, l6, l7, l8, l9, l10, lsa, lsc, lse, lab, lac,
			lcd, lce, lef, lbd, lbdd, ldd, lfd, ldf, mrec1, mrec2;
	ImageIcon img1, img2, img3, img4, img5, img6, img7, img8, img9, img10,
			img11, img12;
	ImageIcon sa, sc, se, ab, ac, cd, ce, ef, db, bdd, dd, fd, df;
	public Font fa = new Font("Times new roman", Font.BOLD, 15);
	JLabel lgsa, lgsc, lgse, lgsab, lgac, lgcd, lgce, lgef, lgdb, lgbdd, lgdd,
			lgfd, lgdf;
	Timer timer;
	ImageIcon  gsc, gse, gac, gab, grd, gcd, gbd, gce, gef, gbdd, gddd,
			gfdd;
	
	String text1, text2, text3, text4, text5, text6;
	String Astatus="",Bstatus="",Cstatus="",Dstatus="",Estatus="",Fstatus="";//,node="";
	
	JButton att,key;

	IOTRouter() {
		setTitle("IOTRouter::Securing Data in Internet of Things Using Cryptography and Steganography Techniques");
		
		c=new JPanel();
		c.setLayout(null);
		c.setBackground(Color.white);

		mrec1 = new JLabel("");
		mrec1.setFont(fa);
		mrec1.setForeground(Color.WHITE);

		mrec2 = new JLabel("");
		mrec2.setFont(fa);
		mrec2.setForeground(Color.WHITE);
		
		ImageIcon banner = new ImageIcon(this.getClass().getResource("Router.png"));
		JLabel title = new JLabel();
		title.setIcon(banner);
		title.setBounds(0, -5, 1000,90);
		timer = new Timer();
		key = new JButton("View Secret Sharing Details");
		l2 = new JLabel();
		img2 = new ImageIcon(this.getClass().getResource("a.png"));
		l2.setIcon(img2);
		key.setBounds(220, 500, 260, 40);
		c.add(l2);
		//c.add(key);
		c.add(title);
		key.addActionListener(this);
	
		int[] ports = new int[] { 123, 456, 501 };
		for (int i = 0; i < 3; i++) {
			Thread t1 = new Thread(new PortListener(ports[i]));
			t1.start();
		}
		
		add(c);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
	
		
	}
	
	class PortListener implements Runnable {
		ServerSocket ss1, ss2;
		Socket cn1, cn2;
		int port;

		public PortListener(int port) {
			this.port = port;
		}

		public void run() {

			 if(this.port==456)
			{
				try {
					
					
					ss1 = new ServerSocket(456);
					while (true) {
						cn1 = ss1.accept();
						
						System.out.println("Listening Port 456");
						ObjectInputStream ois = new ObjectInputStream(cn1.getInputStream());
						String rn= (String) ois.readObject();
						String ip= (String) ois.readObject();
						String fname = (String) ois.readObject();	
						byte[] ct=(byte[])ois.readObject();
						
						SimpleDateFormat sdfDate = new SimpleDateFormat(
    					"dd/MM/yyyy");
    			        SimpleDateFormat sdfTime = new SimpleDateFormat(
    					"HH:mm:ss");

    			          Date now = new Date();
    			          String strDate = sdfDate.format(now);
    			          String strTime = sdfTime.format(now);
    			          String dt = strDate + "   " + strTime;
    			          
						/*Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qrcode","root","root");
						Statement st=con.createStatement();
						st.executeUpdate("insert into qrcode_details values('"+rn+"','"+ip+"','"+fname+"','"+dt+"')");*/
						
						
						l2.setVisible(false);
						Thread.sleep(1000);
						l2.setVisible(true);
						l2.setBounds(250, 130, 370, 330);

						Thread.sleep(1000);
						l2.setVisible(false);
						Thread.sleep(1000);
						l2.setVisible(true);
						l2.setBounds(250, 130, 370, 330);

						Thread.sleep(1000);
						l2.setVisible(false);
						Thread.sleep(1000);
						l2.setVisible(true);
						l2.setBounds(250, 130, 370, 330);

						Thread.sleep(1000);
						l2.setVisible(true);
						l2.setBounds(250, 130, 370, 330);

						if(rn.equals("A"))
						{
						Socket sc1 = new Socket(ip, 111);
						ObjectOutputStream out = new ObjectOutputStream(sc1.getOutputStream());
						out.writeObject(fname);
						out.writeObject(ct);
						}   
						if(rn.equals("B"))
						{
						Socket sc1 = new Socket(ip, 1111);
						ObjectOutputStream out = new ObjectOutputStream(sc1.getOutputStream());
						out.writeObject(fname);
						out.writeObject(ct);
						}   
						if(rn.equals("C"))
						{
						Socket sc1 = new Socket(ip, 11111);
						ObjectOutputStream out = new ObjectOutputStream(sc1.getOutputStream());
						out.writeObject(fname);
						out.writeObject(ct);
						}      							    
					}
					}
					catch(Exception ex){System.out.println(ex);}
			}
		}
	}

	public static void main(String[] args) {
		IOTRouter rn=new IOTRouter();
		rn.setSize(750, 600);
		rn.setVisible(true);
	}

}
