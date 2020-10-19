
package Life;
/*This Program is the implementation of Conways life Simulation
 * Author Sarah With the tutorials of the video
 * Date: October 18
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Life implements MouseListener, ActionListener {
	//Variables and objects
	int numCells = 10;
	//I want to be clever. (In your video you said if you want to be clever you can use a variable instead of 10x10
	boolean[][] cells = new boolean [numCells][numCells];
	JFrame frame = new JFrame ();
	LifePanel panel = new LifePanel(cells);
	Container south = new Container();
	JButton step = new JButton("Step");
	JButton start = new JButton("Start");
	JButton stop = new JButton ("Stop");
	
	//Constructor
	public Life() {
		frame.setSize(600,600);
		frame.setLayout(new BorderLayout());
		frame.add(panel, BorderLayout.CENTER);
		panel.addMouseListener(this);
		
		//south Container
		frame.add(south, BorderLayout.SOUTH);
		south.setLayout(new GridLayout(1,3));
		south.add(step);
		step.addActionListener(this);
		south.add(start);
		start.addActionListener(this);
		south.add(stop);
		stop.addActionListener(this);
		
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
		frame.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource().equals(step)) {
			System.out.println("Step");
			step();
		}
		if (event.getSource().equals(start)) {
			System.out.println("Start");
		}
		if (event.getSource().equals(stop)) {
			System.out.println("Stop");
		}
	}

	/*
	 * row - 1,column-1              row-1,column            row-1,column+1
	 * row, column-1                       me                row, column +1
	 * row +1, column - 1            row +1, column           row+1, column+1
	 */
	public void step() {
		boolean[][] nextCells = new boolean [cells.length][cells[0].length];
		for (int row = 0; row < cells.length; row++) {
			for (int column = 0; column < cells[0].length; column++) {
				int neighborCount = 0;
				if (row>0 && cells[row-1][column-1]) {//up left
					neighborCount++;
				}
				if (row > 0 && cells[row-1][column] == true) {
					neighborCount++;
				}
				if (row>0 && column<cells[0].length-1&& cells[row-1][column+1]) {
					neighborCount++;
				}
				if (column>0 && cells[row][column-1]) {
					neighborCount++;
				}
				if (column<cells[0].length-1 && cells[row][column+1]) {
					neighborCount++;
				}
				if (row<cells.length-1 && column>0 && cells[row+1][column-1]) {
					neighborCount++;
				}
				if (row<cells.length-1 && cells[row+1][column]) {
					neighborCount++;
				}
				if (row<cells.length-1 && column<cells[0].length-1 &&cells[row+1][column+1]) {
					neighborCount++;
				}
				
				
				//Rules of Life
				if(cells[row][column] == true) { // Im alive!!
					if (neighborCount == 2 || neighborCount == 3) {
						nextCells[row][column] = true; //alive next time
					}
					else {
						nextCells[row][column] = false; //ded
					}
				}
				else {
					if (neighborCount == 3) {
						nextCells[row][column] = true;
					}
					else {
						nextCells[row][column] = false;
					}
				}
			}
		}
		cells = nextCells;
		panel.setCells(nextCells);
		frame.repaint();
	}

}
