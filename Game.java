import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Game extends JPanel implements ActionListener
	{
		ImageIcon img1,img2,img3,img4;
		ImageIcon img5,img6,img7;
		ImageIcon img8,img9;
		ImageIcon img10,img11,winimg;
		Image swt,board,s1,start;
		Image player1,player2;
		Image player11,player12;
		Image dice,dice1,win;
		JButton b1,b2,b3,b4;
		JLabel tx2,tx3;
		int px[]={0,40,120};//px0=0,px1=40,px2=120;//just for convenience
		int py[]={0,620,620};//px0=0,py1=620,py2=620;
		int A=0,r1=0,r2=0,count=1;
        String s[]={"","IMAGES/dice1.jpg","IMAGES/dice2.jpg","IMAGES/dice3.jpg","IMAGES/dice4.jpg","IMAGES/dice5.jpg","IMAGES/dice6.jpg"};
		boolean b=true,c=false,f=true,wining=false;
	Game(FDemo x)
	{
	setBackground(Color.black);
	img1=new ImageIcon("IMAGES/swt.jpg");
	img2=new ImageIcon("IMAGES/board.jpg");
	img3=new ImageIcon("IMAGES/s1.jpg");
	img4=new ImageIcon("IMAGES/start.jpg");
	img5=new ImageIcon("IMAGES/back1.jpg");//button image
	img6=new ImageIcon("IMAGES/reset.png");//button image
	img7=new ImageIcon("IMAGES/start.gif");//button image
	img8=new ImageIcon("IMAGES/player1.jpg");
	img9=new ImageIcon("IMAGES/player2.jpg");
	winimg=new ImageIcon("IMAGES/win.gif");
	img10=new ImageIcon("IMAGES/dice.gif");//image ki location pr betha hai yha	

	swt= img1.getImage();//image swt mai store ho gyi hai
	board=img2.getImage();
	s1= img3.getImage();
	start=img4.getImage();
	player1=img8.getImage();
	player2=img9.getImage();
	player11=img8.getImage();
	player12=img9.getImage();
	dice=img10.getImage();
	win=winimg.getImage();
	

setLayout(null);
Font f=new Font("Algerian",Font.BOLD,20);
b1=new JButton(img5);//back
	b1.setBounds(40,120,120,40);
	b1.setBackground(new Color(4,129,255));
	b1.setForeground(Color.red);
	b1.addActionListener(x);
	add(b1);
b2=new JButton(img6);//reset
    b2.setBounds(50,180,100,30);	
    b2.setBackground(new Color(4,129,255));
	b2.addActionListener(this);
	add(b2);
b3=new JButton("ROLL");//roll
     b3.setBounds(40,480,120,40);
     b3.setFont(f);
     b3.setForeground(Color.red);
     b3.addActionListener(this);
     add(b3);
b4=new JButton(img7);//start
     b4.setBounds(20,560,150,60);
     b4.setFont(f);
     b4.setForeground(Color.red);
     b4.addActionListener(this);
	 add(b4);
	 

tx2=new JLabel("PLAYER 1");
     tx2.setBounds(50,250,150,35);
     tx2.setBackground(Color.black);
	 tx2.setForeground(Color.black);
	 tx2.setFont(f);
     add(tx2);
tx3=new JLabel("PLAYER 2 ");
     tx3.setBounds(50,310,150,35);
     tx3.setBackground(Color.black);
     tx3.setForeground(Color.black); 
     tx3.setFont(f);
     add(tx3);

 }
public void paintComponent(Graphics g)
	{
		g.setColor(new Color(4,129,255));
		g.fillRect(0,0,200,735);
		
		g.drawImage(swt,0,0,this);
		g.drawImage(board,200,0,this);
		g.drawImage(s1,920,0,this);//softwaves
		g.drawImage(start,20,550,this);		
		
		g.drawImage(player11,10,240,this);
		g.drawImage(player12,10,300,this);
		
		//--------------------------------------------
		g.drawImage(dice,10,380,this);//isme img10 arhi hai jo ek gif hai
		g.drawImage(dice1,110,380,this);//isme img11 arhi hai jo string array mai store hai
		//---------------------------------------------
		
		g.drawImage(player1,px[1],py[1],this);
		g.drawImage(player2,px[2],py[2],this);
		if(wining)
		{
		g.drawImage(win,300,50,this);
		}
		
	}
public void actionPerformed(ActionEvent e)
 {	
 
    if(e.getSource()==b2)//reset button ko use
	{
		px[1]=40;
		py[1]=620;
		px[2]=120;
		py[2]=620;
		r1=0;
		r2=0;
		img11=new ImageIcon(s[0]); 	
        dice1=img11.getImage();
		repaint();
		f=true;//for start button again call when reset is pressed
		b=false;//so that dice also stop rolling
		tx2.setText("player 1");
		tx3.setText("player 2");
		wining=false;
	} 
 
    if(e.getSource()==b4)//start button ko active krna
	{
		if(f)//so that after one entry start button(dialogue box)shud not open again
		{
		 c=true;//so that game should not start before the filling of details
		 String player1=JOptionPane.showInputDialog(null,"Enter player 1 name");
		 
		 if(player1.equals(""))
		   {
			 JOptionPane.showMessageDialog(null,"Please Enter Name","Alert",JOptionPane.WARNING_MESSAGE);
			 player1=JOptionPane.showInputDialog(null,"Enter player 1 name");
		  }
		  
		 tx2.setText(player1);
		 String player2=JOptionPane.showInputDialog(null,"Enter player 2 name");
		 
		 if(player2.equals(""))
		 {	 
		     JOptionPane.showMessageDialog(null,"Please Enter Name","Alert",JOptionPane.WARNING_MESSAGE);
			 player2=JOptionPane.showInputDialog(null,"Enter player 2 name");
		 }
		 
		 tx3.setText(player2);
	     
		 
		 b=true;//so that dice can start again rolling
		 f=false;//so that after one entry start button(dialogue box)shud not open again
		 
		}
	}
	
    
	if(e.getSource()==b3)//dice wala button starts here****************************************************
	{
	  if(c)//details fill hone k baad hi chlega i.e start button ko click krke details fill
		{
      if(b)//winner k baad ye code nhi chlega i.e b false hojayega
	    {
		int r=(int)Math.round(Math.random()*5+1);
		
		img11=new ImageIcon(s[r]); 	
        dice1=img11.getImage();
        int k=0,j,l;
		
		if(count%2==1)//for first player-------------------------------------------------------- 
		{
	     r1=r1+r;
		 px[1]=140;
         py[1]=642;
		
		
		     if(r1==4){r1=25;}
		else if(r1==13){r1=46;}
		else if(r1==33){r1=49;}
		else if(r1==42){r1=63;}
		else if(r1==50){r1=69;}
		else if(r1==62){r1=81;}
		else if(r1==74){r1=92;}
		else if(r1==27){r1=5;}
		else if(r1==40){r1=3;}
		else if(r1==43){r1=18;}
		else if(r1==54){r1=31;}
		else if(r1==66){r1=45;}
		else if(r1==76){r1=58;}
		else if(r1==89){r1=53;}
		else if(r1==99){r1=41;}
        
		if(r1>100){r1=r1-r;}
		
		m:
		for(int i=1;i<=10;i++)
		{
         int t=9;//2nd chance se saari lines mai 9 baar hi chlna chahiye....
	     if(i==1)
	     {
	 	   t=10;//1st chance  mai 10 baar chlna chahiye....
	     } 
         
	       if(i%2==1)//odd lines chlega 1,3,5,7.....
		   {
			for(j=1;j<=t;j++)
			 {
				px[1]+=70;
				k++;	
				if(k==r1)break m;
			 }
	          if(j==11 || j==10){py[1]-=70;k++;if(k==r1)break m;}
		    }		   
		   else//even lines chlega 2,4,6,8......
		   {
			   for(l=1;l<=9;l++) 
			  {
				px[1]-=70;
				k++;
    			if(k==r1)break m;
			  }
			   if(l==10){py[1]-=70;k++;if(k==r1)break m;}
			
	   	    }
	    }
		count++;
		if(r1==100)//winning condition
		{
			wining=true;
			b=false;
           String s1= tx2.getText();
	       //repaint();
		   JOptionPane.showMessageDialog(this,s1+" is winner");
		   
		   
		}
	  }//first player ends here----------------------------------------------------------------
	  
	  
	 else//for second player-------------------------------------------------------------------
	  {
		r2=r2+r;
		px[2]=165;
        py[2]=642;
		
		     if(r2==4){r2=25;}
		else if(r2==13){r2=46;}
		else if(r2==33){r2=49;}
		else if(r2==42){r2=63;}
		else if(r2==50){r2=69;}
		else if(r2==62){r2=81;}
		else if(r2==74){r2=92;}
		else if(r2==27){r2=5;}
		else if(r2==40){r2=3;}
		else if(r2==43){r2=18;}
		else if(r2==54){r2=31;}
		else if(r2==66){r2=45;}
		else if(r2==76){r2=58;}
		else if(r2==89){r2=53;}
		else if(r2==99){r2=41;}
		
		if(r2>100){r2=r2-r;}	
		m:
		for(int i=1;i<=10;i++)
		{
        int t=9;
	     if(i==1)
	     {
	 	   t=10;
	     } 
         
	       if(i%2==1)//odd chlega 1,3,5,7.....
		   {
			for(j=1;j<=t;j++)
			 {
				px[2]+=70;
				k++;	
				if(k==r2)break m;
			 }
	          if(j==11 || j==10){py[2]-=70;k++;if(k==r2)break m;}
		    }		   
		   else//even chlega 2,4,6,8......
		   {
			   for(l=1;l<=9;l++) 
			  {
				px[2]-=70;
				k++;
    			if(k==r2)break m;
			  }
			   if(l==10){py[2]-=70;k++;if(k==r2)break m;}
			
	   	    }
	    }
		 count++;
		 if(r2==100)
		{
			wining=true;
			b=false;
			//repaint();
		    String s3= tx3.getText();
		   JOptionPane.showMessageDialog(this,s3+" is winner");
		}
		
	   }//second player ends here----------------------------------------------------------			
		
     }
	repaint();
   }
  }//dice wala button ends here****************************************************
 
 
 }//actionPerformed ends here
}
  

