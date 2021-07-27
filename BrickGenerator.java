
package MarioBrickBreaker;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class BrickGenerator {

	public int numOfBricks[][];
	public int brickWidth;
	public int brickHeight;
	Image brick;

	// this constructor makes the blocks in the game
	public BrickGenerator(int row, int col, int RowsHeight ) {
		
	ImageIcon t = new ImageIcon("src/MarioBrickBreaker/smallBrick.png");
		brick = t.getImage();
		
		numOfBricks = new int[row][col];
		for(int i =0; i < numOfBricks.length; i++) {
			for(int j=0; j< numOfBricks[0].length;j++) {
                                 System.out.println(i+" - "+j+ " bricks");
				numOfBricks[i][j] = 1;
				}
			}
		
		brickWidth = 540/col;
		brickHeight = RowsHeight/row;
		
	}
	
	// this method draws the blocks depending on this one gets hit
	public void draw(Graphics2D g) {
		
		for(int i =0; i < numOfBricks.length; i++) {
			for(int j=0; j< numOfBricks[0].length;j++) {
				if(numOfBricks[i][j] > 0 ) {
					
					
					// this is what makes the blocks form in a certain order. 
                                         // The adding numbers is the position of the blocks as a whole. From right left and top to bottom.
					g.drawImage(brick,j* brickWidth + 80,i * brickHeight + 50,brickWidth,brickHeight,null);

				}
				
			}
		}
		
		
	}
	
        int a = 0;
        int b = 0;
	public void setBrickValue(int value, int row, int col) {
		
                
		numOfBricks[row][col]= value;
                 
		
		}
        
        
        public void drawTwo(int row, int col, Graphics2D g){
            
             ImageIcon yOSHIO = new ImageIcon("src/MarioBrickBreaker/yoshio.gif");
                Image yooo = yOSHIO.getImage();
                 
                 
                 g.drawImage(yooo,col* brickWidth + 80,row * brickHeight + 50,brickWidth,brickHeight,null);
                
        
        System.out.print("a"+ a + " b "+b +"\n");
        
        }
        
        
        
}//end of class