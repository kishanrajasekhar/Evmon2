/**
 * 
 * @author kishan
 * users punches his opponent. The damage 
 * inflicted depends on the user's strength.
 */
public class punch extends Moves{
	
	/**
	 * standard = 0,
	 * takes up 1 endurance point
	 */
	public punch() {
		super(0, "Punch", 1);
	}
	
//	public void act(fighter user){
//		super.act(user);
//		user.remEnd -=1; //takes up 1 endurance point
//		if(acc < 0){
//			System.out.print(user.name + " used Punch.... but ");
//			user.miss();
//		}else{
//			int d = (int)(Math.random()*6) + (user.strength - 3);
//			System.out.println(user.name + " attacked " + user.target.name + " and inflicted " + d 
//					+ " hitpoints of damage!");
//			user.target.remHP -= d;
//		}//end if else
//	}//end method
	
	/**
	 * user punches his foe.
	 */
	public void doMove(fighter user){
		int d = (int)(Math.random()*6) + (user.strength - 3);
		System.out.println(user.name + " attacked " + user.target.name + " and inflicted " + d 
				+ " hitpoints of damage!");
		user.info += user.name + " attacked " + user.target.name + " and inflicted " + d 
		+ " hitpoints of damage! -\n";
		user.i.setText(user.info);
		user.target.remHP -= d;
	}
}//end class
