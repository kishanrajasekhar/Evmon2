
public class lift extends Moves{
	
	/**
	 * this move doesn't fail
	 * takes up 2 endurance points
	 */
	public lift() {
		super(-100, "Lift", 2);
	}//end constructor
	
	/**
	 * user lifts and gains strength
	 */
	public void doMove(fighter user){
		System.out.println(user.name + " lifted and gained strength!");
		user.info += user.name + " lifted and gained strength! -\n";
		user.i.setText(user.info);
		if(user.strength >= user.strMax){
			user.strength= user.strMax;
			System.out.println("	but " + user.name + "'s str is maxed out.");
			user.info += "	but " + user.name + "'s str is maxed out. \n";
			user.i.setText(user.info);
		}else{
			user.strength ++;	
		}
	}
	
}//end constructor
