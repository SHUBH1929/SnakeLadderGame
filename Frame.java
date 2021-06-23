import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class FDemo extends JFrame implements ActionListener
{
	CardLayout cd;
	Container c=getContentPane();
	Setting st;
    Game gm;
	Home hm;
	About ab;
    FDemo()
     {
		 cd=new CardLayout();
		 setLayout(cd);
		 setTitle("snake and ladder");
		 
	     hm=new Home(this);//1 card as home page
		 add("home",hm);
		
		 gm=new Game(this);//the main card ie game 
		 add("game",gm);
		 
		 ab=new About(this);
		 add("about",ab);
		 
		 st=new Setting(this);
		 add("setting",st);
	 }
	 

	 public void actionPerformed(ActionEvent e)
	 {
		 if(e.getSource()==hm.b1)
		 {
			 cd.show(c,"game");	 
			 //music ---------------------------------

			 
			 
		 }
		 if(e.getSource()==hm.b2)
		 {
			 cd.show(c,"setting");
		 }
		 if(e.getSource()==hm.b3)
		 {
			 cd.show(c,"about");
		 }
		 if(e.getSource()==st.b1)
		 {
			 cd.show(c,"home");
		 }
		  if(e.getSource()==ab.b1)
		 {
			 cd.show(c,"home");
		 }
		  if(e.getSource()==gm.b1)
		 {
			 cd.show(c,"home");
		 }
		 
	 }
	 
}
class Frame
 {
  public static void main(String args[])
  {
   FDemo f=new FDemo();
   f.setVisible(true);
   f.setBounds(100,0,995,735);
   f.setDefaultCloseOperation(f.EXIT_ON_CLOSE); 
  }
}
