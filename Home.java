import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Home extends JPanel// implements ActionListener
	{
		ImageIcon img1,img2,img3,img4,img5;
	    Image bg,logo;
		JButton b1,b2,b3;
    Home(FDemo f)
	{
		
    setLayout(null);
	
	img1=new ImageIcon("IMAGES/bg3.jpg");
	bg= img1.getImage();
	img5=new ImageIcon("IMAGES/logo.png");
	logo= img5.getImage();
	Font f1=new Font("Algerian",Font.BOLD,30);
	Color a1=new Color(76,55,19);
	b1=new JButton("PLAY");//play
	b1.setBackground(new Color(255,104,57));
	b1.setForeground(a1);
	b1.setBounds(540,280,155,40);
	b1.setFont(f1);
	add(b1);
	b2=new JButton("SETTING");//setting
	b2.setBounds(730,280,155,40);
	b2.setForeground(a1);
	b2.setBackground(new Color(93,193,112));
	Font f2=new Font("Algerian",Font.BOLD,22);
	b2.setFont(f2);
	add(b2);
	Font f3=new Font("Algerian",Font.BOLD,25);
	b3=new JButton("ABOUT US");//about 
	b3.setBounds(615,380,165,40);
	b3.setForeground(a1);
	b3.setBackground(new Color(118,132,239));
	b3.setFont(f3);
	add(b3);
	
	b1.addActionListener(f);
	b2.addActionListener(f);
	b3.addActionListener(f);
	
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(bg,0,0,this);
		g.drawImage(logo,600,20,this);
		

	}
	
}
