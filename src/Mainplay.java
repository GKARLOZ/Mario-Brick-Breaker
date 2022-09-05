

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Mainplay extends JPanel implements KeyListener, ActionListener{
	
	
	private boolean play = false;
	private int score = 0;
	
	private int totalBricks = 8;// amount of bricks

        private int rowHeight = 50; // the rows height increment every time a player wins so it could add more bricks
        private int numOfRows = 1; // this number will increase if the player wins 
	private Timer timer;
	private int delay = 8;
	private int playerX = 310;// position of the yoshi in the frame
	
	private int ballposX = 300;
	private int ballposY = 250;
	private int ballXdir = -1;
	private int ballYdir = -2;
	
	Image pic;//background
	Image losePic;// losing pic
	Image yoshi;
	Image paddle;
	Image brick;
	private int imageX = 0;//Position on the screen
	private int imageY = 0;
	
	private BrickGenerator map;
	
	
	
	public Mainplay()
                    
	{
            
            
                 
		// brick generator recieves the rows, columns in that order
		map = new BrickGenerator(1,8,50);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();
		
		//ImageIcon i = new ImageIcon("MarioBrickBreaker/bg4.png");
                  ImageIcon i = new ImageIcon("img/bg4.png");

		pic = i.getImage();
		
		ImageIcon p = new ImageIcon("img/loser.gif");
		losePic = p.getImage();
		
		ImageIcon o = new ImageIcon("img/yoshio.gif");
		yoshi = o.getImage();
		
		ImageIcon h = new ImageIcon("img/paddle.png");
		paddle = h.getImage();
		
		ImageIcon t = new ImageIcon("img/smallBrick.png");
		brick = t.getImage();
		
	}
	
	
 
	
	
        @Override
	public void paint(Graphics g) {
		
		//image background
		g.setColor(Color.gray);
		g.drawImage(pic,imageX,imageY,this);
		
		//Draw a map of the bricks
		 map.draw((Graphics2D) g);
		
		//borders
		g.setColor(Color.blue);
		g.fillRect(0,0,3,592);
		g.fillRect(0,0,692,3);
		g.fillRect(691,0,3,592);
		
		//scores
		g.setColor(Color.black);
		g.setFont(new Font("serif", Font.BOLD, 35));
		g.drawString(""+ score, 650, 30);

			//THE PADDLE
		
		g.drawImage(paddle,playerX,530,this);

		//yoshi
		g.drawImage(yoshi,ballposX,ballposY,this);
		
		
		
		
                
		if(totalBricks <= 0) {
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			g.setColor(Color.RED);
			g.setFont(new Font("serif", Font.BOLD, 80));
			g.drawString("You win: ", 190, 300);
			
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press Enter to Restart ", 230, 350);
			
			
		}
		
		
		if(ballposY > 570) {
                          System.exit(0);
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 80));
			g.drawString("You Lose", 190, 300);
			g.drawImage(losePic,250,320,this);

			
			g.setFont(new Font("serif", Font.BOLD, 40));
			g.drawString("Press Enter to Restart ", 190,500);
			
		}
		
		g.dispose();
		

		

	}
	

        @Override
	public void actionPerformed(ActionEvent e) {
            
		timer.start();
		if(play) {
			if (new Rectangle(ballposX, ballposY,20,20).intersects(new Rectangle(playerX,510,100,8)))
			{
                          System.out.println("Mario intersected paddle");
			ballYdir = -ballYdir;	
				
			}
			
	     	A:for(int i = 0; i<map.numOfBricks.length;i++) {
				for(int j = 0; j< map.numOfBricks[0].length;j++) {
					if(map.numOfBricks[i][j]>0) {
						int brickX = j* map.brickWidth + 80;
						int brickY = i* map.brickHeight + 50;
						int brickWidth = map.brickWidth;
						int brickHeight = map.brickHeight;
						
						Rectangle rect = new Rectangle(brickX, brickY,brickWidth,brickHeight);
						Rectangle ballRect = new Rectangle(ballposX, ballposY,20,20);
						Rectangle brickRect = rect;
						
						if(ballRect.intersects(brickRect)) {
							map.setBrickValue(0,i,j);
							totalBricks--;// minus one
							score += 5;// score value increments of 5 
							if(ballposX + 19 <= brickRect.x || ballposX +1 >= brickRect.x + brickRect.width) 
                                                            {
                                                                    System.out.println("Mario intersected brick from the sides");
								ballXdir = -ballXdir;
							
							}
                                                            else 
                                                            { 
                                                                System.out.println("Mario intersected from the bottom or top");
                                                                ballYdir = -ballYdir;
							
						         }
						break A;
					}
				}
				
			}
	     	}
			
			ballposX += ballXdir;
			ballposY += ballYdir;
			
			if(ballposX < 0) {
				ballXdir = -ballXdir;
			}
			
			if(ballposY < 0) {
				ballYdir = -ballYdir;
			}
			if(ballposX > 670) {
				ballXdir = -ballXdir;
			}
		}
		
		repaint();
		
	}
	
	
	
	
	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) {
            System.out.println("keyPressed");
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(playerX >= 600){
				playerX = 600;
		                           }
                        else { 
			     moveRight();
			    }
		}// end of first if 
					if(e.getKeyCode() == KeyEvent.VK_LEFT) {
						if(playerX < 10) {
							playerX = 10;
						}else {
							moveLeft();
						}
					}//end of  first if 
                                        
			         //if the user presses enter 		
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                                    
					if(!play) {
                                           numOfRows += 1;
                                           rowHeight += 50; 
				         play = true;
					ballposX = 120;
					ballposY = 350;
					ballXdir = -1;
					ballYdir = -2;
					playerX = 310;
					//score = 0;
					totalBricks = 8 * numOfRows;
                                          System.out.println("TotalBricks " + totalBricks);
					map = new BrickGenerator(numOfRows,8,rowHeight);
					
					repaint();
						
					}
				}
			
	}//end of keyPressed

	public void moveRight() {
		play = true;
		playerX += 20;
		
	}
	public void moveLeft() {
		play = true;
		playerX -= 20;
		
	}
	

}