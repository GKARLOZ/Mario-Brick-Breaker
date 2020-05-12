package MarioBrickBreaker;


import javax.swing.JFrame;
import java.applet.Applet;

public class Main extends Applet{
	public static void main(String []args) {
		JFrame obj = new JFrame();
		
		Mainplay gamePlay = new Mainplay();
		obj.setBounds(10,10,700,600);
		
		obj.setTitle("MarioYoshi ");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gamePlay);
		
	}


}
