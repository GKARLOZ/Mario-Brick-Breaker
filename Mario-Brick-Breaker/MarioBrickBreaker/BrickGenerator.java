
package MarioBrickBreaker;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class BrickGenerator {

	public int numOfBricks[][];
	public int brickWidth;
	public int brickHeight;
	Image brick;

	// this constructor makes the blocks in the game
	public BrickGenerator(int row, int col ) {
		
	ImageIcon t = new ImageIcon("MarioBrickBreaker/smallBrick.png");
		brick = t.getImage();
		
		numOfBricks = new int[row][col];
		for(int i =0; i < numOfBricks.length; i++) {
			for(int j=0; j< numOfBricks[0].length;j++) {
				numOfBricks[i][j] = 1;
				}
			}
		
		brickWidth = 540/col;
		brickHeight = 150/row;
		
	}
	
	// this method draws the blocks depending on this one gets hit
	public void draw(Graphics2D g) {
		
		for(int i =0; i < numOfBricks.length; i++) {
			for(int j=0; j< numOfBricks[0].length;j++) {
				if(numOfBricks[i][j] > 0 ) {
					
					
					// this is what makes the blocks form in a certain order. 
					g.drawImage(brick,j* brickWidth + 80,i * brickHeight + 50,brickWidth,brickHeight,null);

				}
				
			}
		}
		
		
	}
	
	public void setBrickValue(int value, int row, int col) {
		
		numOfBricks[row][col]= value;
		
		}
	
	
}//end of class
