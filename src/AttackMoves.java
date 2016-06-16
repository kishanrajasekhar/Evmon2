/**
 * 
 * @author kishan
 * moves that fighter can move
 * more moves need to be created (please put them in alphabetical order)
 */
public class AttackMoves {
	
	
	public static void kneeExplosion(fighter user){
		user.remEnd -=3; //3 endurance points
		user.remHP -= (int)(.25 * user.initHP); //user loses quarter of his total hp
		int d = (int)(Math.random()*5) + (user.strength + 20);
		System.out.println(user.name + " used Knee Explosion on " + user.target.name
				+ " and inflicted " + d + " hitpoints of damage, but lost " + (int)(.25 * user.initHP)
				+ " hp.");
		user.target.remHP -= d;
	}//end method
	
	/**
	 * a punch... damage inflicted depends on the fighter's strength.
	 * @param user - the fighter using the move
	 */
	public static void punch(fighter user){
		user.remEnd -=1; //takes up 1 endurance point
		int d = (int)(Math.random()*6) + (user.strength - 3);
		System.out.println(user.name + " attacked " + user.target.name + " and inflicted " + d 
				+ " hitpoints of damage!");
		user.target.remHP -= d;
	}//end method
	
	/**
	 * a warm up increases your speed
	 * @param user - the fighter using the move
	 */
	public static void warmUp(fighter user){
		user.remEnd -=2; //takes up 2 endurance point
		if(user.speed < user.spMax){
			System.out.println(user.name + " warmed up. " + user.name + "'s speed increased!");
			user.speed += 2; 
		}else{
			System.out.println(user.name + " 's speed is already maxed out!");
		}
	}//end method
	

}//end class
