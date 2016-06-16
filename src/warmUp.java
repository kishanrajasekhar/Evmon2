/**
 * 
 * @author kishan
 * this moves increases user's speed
 * by 2 speed points
 */
public class warmUp extends Moves{
	
	/**
	 * This move will not fail. 
	 * That's why the standard is so low.
	 * takes up 2 endurance points
	 */
	public warmUp() {
		super(-100, "Warm Up", 2);
	}
	
//	public void act(fighter user){
//		user.remEnd -=2; //takes up 2 endurance point
//		if(user.speed < user.spMax){
//			System.out.println(user.name + " warmed up. " + user.name + "'s speed increased!");
//			user.speed += 2; 
//		}else{
//			System.out.println(user.name + " 's speed is already maxed out!");
//		}
//	}
	
	/**
	 * user does a warm up like how athletes 
	 * warm up
	 */
	public void doMove(fighter user){
		if(user.speed < user.spMax){
			System.out.println(user.name + " warmed up. " + user.name + "'s speed increased!");
			user.info += user.name + " warmed up. " + user.name + "'s speed increased! -\n";
			user.i.setText(user.info);
			user.speed += 2; 
		}else{
			System.out.println(user.name + " 's speed is already maxed out!");
			user.info += user.name + " 's speed is already maxed out! -\n";
			user.i.setText(user.info);
			user.speed = user.spMax;
		}
	}//end method
}//end class
