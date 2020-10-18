
package Life;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Life implements MouseListener {
	//This line I am using from the Q+A to let me import JFrame...
	int numCells = 10;
	//I want to be clever. (In your video you said if you want to be clever you can use a variable instead of 10x10
	boolean[][] cells = new boolean [numCells][numCells];
		JFrame frame = new JFrame ();
		LifePanel panel = new LifePanel(cells);
	public Life() {
		frame.setSize(800,800);
		frame.setLayout(new BorderLayout());
		frame.add(panel, BorderLayout.CENTER);
		panel.addMouseListener(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Life();
 
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {//A mouse hovers over
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {//moves away from  
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent event) {//this is the one we are using
		System.out.println(event.getX() + "," + event.getY());
		double Pwidth = (double)panel.getWidth() / cells[0].length;
		double Pheight = (double)panel.getHeight() / cells.length;
		int column = Math.min(cells[0].length-1,(int)(event.getX()/Pwidth));
		int row =  Math.min(cells.length-1,(int) (event.getY()/Pheight));
		System.out.println(column +"," + row);
		cells[row][column] = !cells[row][column];
	}

}
