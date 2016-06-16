/**
 * 
 * @author kishan
 * user spikes his opponent.
 * This move is only 80 percent accurate
 * and uses 2 endurance points
 */
public class spike extends Moves{
	
	/**
	 * standard = 0.2
	 * takes up 2 endurance points
	 */
	public spike() {
		super(0.2, "Spike" , 2);
	}//end constructor
	
//	public void act(fighter user){
//		super.act(user);
//		user.remEnd -= 2;
//		if(acc < 0.2){ //it's a miss
//			System.out.print(user.name + " used Spike.... but ");
//			user.miss();
//		}else{
//			int d = (int)(Math.random()*4) + (user.strength + 3);
//			System.out.println(user.name + " spiked " + user.target.name + " and inflicted " + d 
//					+ " hitpoints of damage!");
//			user.target.remHP -= d;
//		}//end if else
//	}//end method

	/**
	 * user spikes his foe with his running spikes
	 */
	public void doMove(fighter user){
		int d = (int)(Math.random()*4) + (user.strength + 3);
		System.out.println(user.name + " spiked " + user.target.name + " and inflicted " + d 
				+ " hitpoints of damage!");
		user.info += user.name + " spiked " + user.target.name + " and inflicted " + d 
		+ " hitpoints of damage! -\n";
		user.i.setText(user.info);
		user.target.remHP -= d;
	}
	
}//end class
