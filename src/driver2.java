import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * 
 * @author kishan allows players to choose their characters.
 */
public class driver2 extends JFrame {

	// ArrayList<fighter> ftr = new ArrayList<fighter>();
	public static int choice = 3; // player's choice: Note that ArrayList starts
									// at 0, but player's
	// choice starts at 1.

	JRadioButton b1, b2, b3, b4;
	ButtonGroup group;

	public driver2() {
		super("EVXC Battle!");
		this.setSize(300, 300);
		JPanel p1 = new JPanel();

		group = new ButtonGroup();
		b1 = new JRadioButton("Move 1");
		b2 = new JRadioButton("Move 2");
		b3 = new JRadioButton("Move 3");
		b4 = new JRadioButton("Move 4");
		group.add(b1);
		group.add(b2);
		group.add(b3);
		group.add(b4);

		this.add(p1, BorderLayout.NORTH);
	}// end constructor

	/**
	 * Adds fighters to the ArrayList. This method can be updated as new
	 * fighters are created. (Put them in alphabetical order by their first
	 * name).
	 */
	public static void addFighters(ArrayList<fighter> ftr) {
		ftr.add(new Austin());
		ftr.add(new Rohan());
		ftr.add(new Umesh());
	}// end method

	/**
	 * outputs the fighters for the player to see
	 * 
	 * @param ftr
	 *            - arrayList of fighters
	 */
	public static void displayFighters(ArrayList<fighter> ftr) {
		int count = 1;
		for (fighter f : ftr) {
			System.out.print(count + ") " + f.name + "	");
			count++;
		}
	}// end method

	/**
	 * sets the player variable to the chosen fighter
	 * 
	 * @param ftr
	 *            - arrayList of fighters
	 */
	public static void chooseFighter(ArrayList<fighter> ftr) {
		Scanner c = new Scanner(System.in);
		try {
			choice = c.nextInt();
		} catch (Exception e) {
			System.out.println("Type a number!");
			displayFighters(ftr);
			chooseFighter(ftr);
		}// end try catch
		if (choice >= 1 && choice <= ftr.size()) {
			// do nothing since conditions are met.
		} else {// error check
			System.out.println("C'mon, it's not that hard.");
			displayFighters(ftr);
			chooseFighter(ftr);
		}// end if else
	}// end method

	/**
	 * begins the fight between player 1 and player 2
	 * 
	 * @param p1
	 *            - player 1
	 * @param p2
	 *            - player 2
	 */
	public static void beginFight(fighter p1, fighter p2) {
//		p1.setVisible(true);
//		p2.setVisible(true);
		p2.setLocationRelativeTo(null);
		p1.setTarget(p2);
		p2.setTarget(p1);
		while (p1.isAlive && p2.isAlive) {
			p1.chooseMove(p1.listOfMoves);
			// check and see if one of the buttons are clicked...
			p2.chooseMove(p2.listOfMoves);
			// now both players made there choices
			if (p1.speed > p2.speed) {
				p1.attack();
				p2.attack();
			} else if (p1.speed < p2.speed) {
				p2.attack();
				p1.attack();
			} else {// if the speed is equal
				int r = (int) (Math.random() * 2); // random integer (0
													// or 1)
				if (r == 0) {
					p1.attack();
					p2.attack();
				} else {
					p2.attack();
					p1.attack();
				}// end if else
			}// end if else
		}// end while
	}// end method
	
	public static void beginFightGUI(fighter p1, fighter p2){
		p1.setVisible(true);
		p2.setVisible(true);
		p2.setLocationRelativeTo(null);
		p1.setTarget(p2);
		p2.setTarget(p1);
		p1.pack();
		p2.pack();
		//battle simulation
		guiBattleSimulation(p1,p2);
	}//end method
	
	private static void guiBattleSimulation(fighter p1, fighter p2){
		if (p1.speed > p2.speed) {
			p1.chooseMoveGUI(p1.listOfMoves);
		} else if (p1.speed < p2.speed) {
			p2.chooseMoveGUI(p2.listOfMoves);
		} else {// if the speed is equal
			int r = (int) (Math.random() * 2); // random integer (0
												// or 1)
			if (r == 0) {
				p1.chooseMoveGUI(p1.listOfMoves);
			} else {
				p2.chooseMoveGUI(p2.listOfMoves);
			}// end if else
		}// end if else
//		if(p1.isAlive || p2.isAlive){// if both players are still alive
//			guiBattleSimulation(p1,p2);//continue the battle
//		} //nope, stack overflow
	}//end helper method

	public static void main(String args[]) {

		fighter p1; // player 1
		fighter p2; // player 2

		ArrayList<fighter> ftr = new ArrayList<fighter>();
		addFighters(ftr);

		System.out.println("Player 1: Choose your character");
		displayFighters(ftr);
		chooseFighter(ftr);
		p1 = ftr.get(choice - 1); // -1 bc ArrayList starts count at 0
		ftr.remove(choice - 1); // uncomment code if you don't want the 2
								// players to have the
								// same character

		System.out.println("Player 2: Choose your character");
		displayFighters(ftr);
		chooseFighter(ftr);
		p2 = ftr.get(choice - 1); // -1 bc ArrayList starts count at 0

		System.out.println(p1.name + " VS " + p2.name
				+ "!!!! \n           BEGIN!!!");

//		beginFight(p1, p2);
		beginFightGUI(p1,p2);

	}// end main
}// end class

