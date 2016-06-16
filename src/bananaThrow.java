
public class bananaThrow extends Moves{
	
	/**
	 * standard = 0
	 * 1 endurance point
	 */
	public bananaThrow() {
		super(0,"Banana Throw", 1);
	}//end constructor
	
	/**
	 * fighter throw a banana at his foe which
	 * ruins his concentration (accuracy)
	 */
	public void doMove(fighter user){
		int d = (int)(Math.random()*6) + (user.strength - 10);
		System.out.println(user.name + " threw a banana on " + user.target.name + " and inflicted " + d 
				+ " hitpoints of damage! " + user.name + " messed up " + user.target.name + 
				"'s concentration.");
		user.info += user.name + " threw a banana on " + user.target.name + " and inflicted " + d 
		+ " hitpoints of damage! " + user.name + " messed up " + user.target.name + 
		"'s concentration. -\n";
		user.i.setText(user.info);
		user.target.remHP -= d; 
		user.target.con -= .015;
		if(user.target.con < user.target.conMin){
			user.target.con = user.target.conMin;
			System.out.println("	but "+user.target.name + "'s con can't go any lower.");
		}
//		System.out.println("con:" + user.target.con);
	}//end method
}//end class
