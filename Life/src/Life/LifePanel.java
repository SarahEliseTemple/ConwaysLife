package Life;
/*Panel for Conway's Life Simulation This draws the grids and cells
 * Author Sarah With the videos from class
 */
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class LifePanel extends JPanel {
	boolean[][] cells;
	double width;
	double height;
	public LifePanel(boolean[][] in) {
		cells = in;
	}
	
	public void setCells(boolean[][] newCells) {// This resets the cells in here. with step on the other side
		cells = newCells;
	}
	
	public void paintComponent(Graphics g) {//This draws the grid and the boxes/ 
		super.paintComponent(g);
		width = (double)this.getWidth() / cells[0].length;
		height = (double)this.getHeight() / cells.length;
		
		
		//draw the cells
		g.setColor(Color.BLUE);//"That seems pretty unoffensive" - Mr. Galbraith
		for(int rows = 0; rows < cells.length; rows++ ) {
			for(int columns = 0; columns < cells[0].length; columns++ ) {
				if(cells[rows][columns] == true) {
					g.fillRect((int)Math.round(columns*width), (int)Math.round(rows*height),
							(int)width+1, (int)height+1);
				}
			}
		}
		
		//draw the lines
		g.setColor(Color.BLACK);
		for (int x=0; x < cells[0].length+1; x++) {
			g.drawLine((int)(Math.round(x*width)), 0, (int)(Math.round(x*width)), this.getHeight());
		}
		for (int y=0; y < cells.length+1; y++) {
			g.drawLine( 0, (int)(Math.round(y*height)), this.getWidth(), (int)(Math.round(y*height)));
		}
	}
}
