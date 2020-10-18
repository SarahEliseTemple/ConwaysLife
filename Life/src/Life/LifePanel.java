package Life;

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
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		width = (double)this.getWidth() / cells[0].length;
		height = (double)this.getHeight() / cells.length;
		g.setColor(Color.BLACK);
		for (int x=0; x < cells[0].length+1; x++) {
			g.drawLine((int)(Math.round(x*width)), 0, (int)(Math.round(x*width)), this.getHeight());
		}
		for (int y=0; y < cells.length+1; y++) {
			g.drawLine( 0, (int)(Math.round(y*height)), this.getWidth(), (int)(Math.round(y*height)));
		}
	}
}
