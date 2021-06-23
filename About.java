import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class About extends JPanel 
 {
     JButton b1;
	 JTextArea ta;
	 ImageIcon img1,img2,img3;
	 Image bg1,bg2;
     About(FDemo f)
    {
      setLayout(null);
      Color c=new Color(128,128,255);
      setBackground(c);
      Font f1=new Font("Algerian", Font.ITALIC,25);
	  
	  img2=new ImageIcon("bg2.jpg");
	  bg1= img2.getImage();
	  img3=new ImageIcon("abt2.png");
	  bg2= img3.getImage();
      
	  img1=new ImageIcon("back1.jpg");
	  b1=new JButton(img1);
	  b1.setBackground(new Color(128,128,255));
      b1.setBounds(730,600,125,40);
      add(b1);
	  ta=new JTextArea();
	  ta.setBounds(300,200,500,150);
	  ta.setForeground(Color.white);
	  ta.setBackground(new Color(64,128,128));
	  ta.setFont(f1);
	  ta.setText("We are from Softwaves Technologies"+"\n"+"Our Main Moto is To Make The Student's"+"\n"+" Future Bright And Successfull");
	  add(ta);
 
    
    b1.addActionListener(f);
    
  }  
  public void paintComponent(Graphics g)
	{
		g.drawImage(bg1,0,0,this);
		g.drawImage(bg2,20,20,this);
		

	}
}

