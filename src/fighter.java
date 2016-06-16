import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * 
 * @author kishan
 *	These are basic method for a fighter. A fighter
 *	also has attributes like strength and speed. More can 
 *	be added (like defence, weight, gender).
 *	
 *
 */
public abstract class fighter extends JFrame implements ActionListener{ //maybe I can use GUI
	String name; //name of the fighter
	int initHP; //initial hitpoints
	int remHP; //remaining hitpoints
	fighter target; //fighter's opponent
	boolean isAlive; //if fighter hp is above 0
	
	int strength; //the strength of the fighter
	int strMax; //the max that the strength stat can be raised to during a battle (*1.5)
	int strMin; //the min that the strength stat can be dropped to during a battle (*0.5)
	
	int speed; //the speed of the fighter
	int spMax; //the max that the speed stat can be raised to during a battle (*1.5)
	int spMin; //the min that the speed stat can be dropped to during a battle (*0.5)
	
	//Endurance is like the PP in pokemon, except each fighter has his own amount of endurance,
	//unlike in Pokemon, in which each move has its own PP.
	int initEnd; //initial endurance
	int remEnd; //remaining endurance
	
	double con; //concentration: helps boost accuracy of the fighter for moves with less than
	//100 percent accuracy. con is added to the acc (accuracy) variable. con should be initialized to
	//a small decimal value between 0 and 1. During a battle, this variable can decrease and become a 
	//negative.
	double conMax; //the max that the concentration stat can be raised to during a battle (0.2)
	double conMin; //the min that the concentration stat can be dropped to during a battle (-0.2)
	
	String choice; //the attack move that the player chooses
	String listOfMoves; //list of moves that the player can choose from. It is initialized in the 
						//child classes
	
	//The moves
	Moves m1; //move 1
	Moves m2; //move 2
	Moves m3; //move 3
	Moves m4; //move 4
	
	String missText; //the text if the fighter misses his opponent
	
	Scanner scan;
	
	//GUI variables
	JLabel fname; //fighter's name
	JLabel oname; //opponent's name
	JLabel imgl; //label where image will be placed
	ImageIcon img; //image of fighter
	JButton mv1;
	JButton mv2;
	JButton mv3;
	JButton mv4;
	boolean buttonClicked; //if the button is clicked
	JTextArea i; //where info will be displayed
	String info; //gives info on the battle
	
	 /**
	  * constructor which initializes the variables
	  * @param n - name
	  * @param hp - hitpoints
	  * @param str - strength
	  * @param sp - speed
	  */
	public fighter(String n, int hp, int str, int sp, int end, double c, String pathname) {
		super("EVXC Battle!"); //for the GUI
		
		name = n;
		initHP = hp;
		remHP = hp;
		isAlive = true;
		strength = str;
		strMax = (int)(str * 1.5);
		strMin = (int)(str * 0.5);
		speed = sp;
		spMax = (int)(sp * 1.5);
		spMin = (int)(sp * 0.5);
		initEnd = end;
		remEnd = end;
		con = c;
		conMax = 0.2;
		conMin = -0.2;
		//each fighter should have his own unique list of moves
		listOfMoves = "coder forgot to initialize listOfMoves variable in this child class"; 
		missText = n + " missed!";//default text
		target = this;
		
		//Now, all the GUI stuff..
		this.setSize(700, 300);
		JPanel top = new JPanel(new GridBagLayout());
		JPanel t2 = new JPanel();
		JPanel t3 = new JPanel();
		JPanel west = new JPanel();
		buttonClicked = false;
		info = "Battle Begin! -\n";
		i = new JTextArea(info);
		
		fname = new JLabel(n + " HP (" + hp + "/" + hp + ") Endurance (" + end + "/" + end + ")");
		oname = new JLabel(target.name + " HP (" + target.remHP + "/" + target.remHP+")");
		img = new ImageIcon(pathname);
		imgl = new JLabel(img);
		mv1 = new JButton("Move 1"); //move name must be initialized in the subclasses
		mv1.setActionCommand("1");
		mv1.addActionListener(this);
		mv2 = new JButton("Move 2");
		mv2.setActionCommand("2");
		mv2.addActionListener(this);
		mv3 = new JButton("Move 3");
		mv3.setActionCommand("3");
		mv3.addActionListener(this);
		mv4 = new JButton("Move 4");
		mv4.setActionCommand("4");
		mv4.addActionListener(this);
		
		mv1.setEnabled(false); //only enables when it's player's turn to choose a move
		mv2.setEnabled(false);
		mv3.setEnabled(false);
		mv4.setEnabled(false);
		
		GridBagConstraints gbc = new GridBagConstraints(); //for panel top
		gbc.insets = new Insets(15,15,15,15);
		
		top.add(fname);
		gbc.gridx=0;
		gbc.gridy=1;
		top.add(oname,gbc);
		t2.add(mv1);
		t2.add(mv2);
		t2.add(mv3);
		t2.add(mv4);
		t3.add(i);
		west.add(imgl);
		this.add(top, BorderLayout.NORTH);
		this.add(t2, BorderLayout.CENTER);
		this.add(t3, BorderLayout.SOUTH);
		this.add(west, BorderLayout.EAST);
	}//end constructor
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		choice = e.getActionCommand();
		buttonClicked = true;
		this.disableMoves();
		this.attackGUI();
		if(countString(info, "-") >= 4){ //keeps the text area from growing too big
			int ind = info.indexOf("-");
			info = info.substring(ind + 1);
		}//end if
	}//end method
	
	/**
	 * returns number of times s2 is n s1
	 * @param s
	 * @param s2
	 * @return
	 */
	public int countString(String s1, String s2){
		int c = 0; // count
		int l = s2.length();
		for(int i = 0; (i + (l - 1)) < s1.length(); i++){
			String ss = s1.substring(i, i+l);
			if(ss.equals(s2)){ 
				c++;
			}//end if
		}//end for
		return c;
	}//end method
	
	public void enableMoves(){
		mv1.setEnabled(true); 
		mv2.setEnabled(true);
		mv3.setEnabled(true);
		mv4.setEnabled(true);
	}
	
	public void disableMoves(){
		mv1.setEnabled(false); 
		mv2.setEnabled(false);
		mv3.setEnabled(false);
		mv4.setEnabled(false);
	}
	/**
	 * method that asks user to choose an attack move.
	 * @param list - list of moves
	 */
	public void chooseMove(String list){
		choice = "0"; //by default...
//		buttonClicked = false;
		if (!this.isAlive){
			System.out.println(this.name + " is down and cannot continue fighting.");
		}else if(this.remEnd <= 0){
			System.out.println(this.name + " is tired and needs to rest");
		}else{
			System.out.print(this.name + ": HP(" + this.remHP + "/" + this.initHP
					+ ") Endurance(" + this.remEnd + "/" + this.initEnd 
					+")			--->" + this.target.name + " (" + this.target.remHP + "/"
					+ this.target.initHP 
					+")\nChoose a move! (Input the number)  "); //prompts player to choose a move
			fname.setText(this.name + ": HP(" + this.remHP + "/" + this.initHP
					+ ") Endurance(" + this.remEnd + "/" + this.initEnd 
					+")");
			System.out.print(list + " "); //just put extra space to make user input out of the text box 
//			this.enableMoves();
			scan = new Scanner(System.in);					
			choice = scan.nextLine(); //the user input
			if (choice.equals("1") || choice.equals("2") || choice.equals("3") 
					|| choice.equals("4")){
				//do nothing
			}else{
				System.out.println("C'mon, just type in the number. Try again.");
				chooseMove(list);
			}
//			sc.close(); //causes an error
		}
	}//end method
	
	public void chooseMoveGUI(String list){
		choice = "0"; //by default...
		buttonClicked = false;
		if(!target.isAlive){
			//do nothing
		}else if (!this.isAlive){
			System.out.println(this.name + " is down and cannot continue fighting.");
		}else if(this.remEnd <= 0){
			System.out.println(this.name + " is tired and needs to rest");
		}else{
			System.out.print(this.name + ": HP(" + this.remHP + "/" + this.initHP
					+ ") Endurance(" + this.remEnd + "/" + this.initEnd 
					+")			--->" + this.target.name + " (" + this.target.remHP + "/"
					+ this.target.initHP 
					+")\nChoose a move! (Press Button)  "); //prompts player to choose a move
			fname.setText(this.name + ": HP(" + this.remHP + "/" + this.initHP
					+ ") Endurance(" + this.remEnd + "/" + this.initEnd 
					+")");
			oname.setText("vs. "+target.name + " HP (" + target.remHP + "/" + target.initHP+")");
			System.out.println(list + " "); //just put extra space to make user input out of the text box 
			this.enableMoves();
		}
	}//end method
	
	/**
	 * What fighter does when he misses.
	 * The default case is he just misses and does 
	 * nothing, but this method can be customized.
	 */
	public void miss(){
		System.out.println(this.missText);
		this.info += this.missText + " -\n";
		this.i.setText(this.info);
	}
	
	/**
	 * method that sets the opponent for the fighter
	 * @param f - opponent fighter
	 */
	public void setTarget(fighter f){
		this.target = f;
		oname.setText("vs. "+target.name + " HP (" + target.remHP + "/" + target.initHP+")");
	}
	
	/**
	 * used in child class, this method 
	 * allows the fighter to attack the opponent
	 * using the moves in the AttackMoves class.
	 */
	public void attack(){
		if(!this.isAlive){
			System.out.println(this.name + " is down and cannot continue fighting.");
		}else if(this.remEnd <= 0){
			this.recover();
		}else{
			if(choice.equals("1")){
				m1.act(this);
			}else if(choice.equals("2")){
				m2.act(this);
			}else if(choice.equals("3")){
				m3.act(this);
			}else if(choice.equals("4")){
				m4.act(this);
			}
			if(target.remHP <= 0){
				target.remHP = 0;
				System.out.println(target.name + " fainted!");
				this.info += target.name + " fainted! -\n";
				this.i.setText(this.info);
				target.isAlive= false;
				target.fname.setText(target.name + ": HP(" + target.remHP + "/" + target.initHP
						+ ") Endurance(" + target.remEnd + "/" + target.initEnd 
						+")");fname.setText(target.name + ": HP(" + target.remHP + "/" + target.initHP
								+ ") Endurance(" + target.remEnd + "/" + target.initEnd 
								+")");
				this.oname.setText("vs. "+target.name + " HP (" + target.remHP + "/" + target.initHP+")");
				if(!this.isAlive){
					System.out.println("It's a draw!");
					this.info += "It's a draw! -\n";
					this.i.setText(this.info);
				}else{
					System.out.println(this.name + " won the battle");
					this.info += this.name + " won the battle! -\n";
					this.i.setText(this.info);
				}//end if else
			}//end if
		}//end else
		fname.setText(this.name + ": HP(" + this.remHP + "/" + this.initHP
				+ ") Endurance(" + this.remEnd + "/" + this.initEnd 
				+")");
	}//end method
	
	/**
	 * for GUI
	 */
	public void attackGUI(){
		if(!target.buttonClicked){//faster fighter
			target.chooseMoveGUI(target.listOfMoves);
			//add has attacked boolean
		}else{//slower fighter
			target.attack();
			this.attack();
			this.buttonClicked = false;
			target.buttonClicked = false;
			if(this.speed < target.speed){
				target.chooseMoveGUI(target.listOfMoves);
			}else{
				this.chooseMoveGUI(this.listOfMoves);
			}
		}
			
	}//end method
	
	/**
	 * fighter recovers if he's out
	 * of endurance
	 */
	public void recover(){
		if(this.remEnd <= 0){
			if(this.remEnd < 0){ //just in case
				this.remEnd = 0;
			}//end if
			this.remEnd += 5;
		}//end if
	}//end method
	
	//GETTERS AND SETTERS
	
	public String getName() {
		return name;
	}//end method
	public int getRemEnd() {
		return remEnd;
	}//end method
	public void setRemEnd(int remEnd) {
		this.remEnd = remEnd;
	}//end method
	public double getCon() {
		return con;
	}//end method
	
}//end class
