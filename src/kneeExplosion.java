/**
 * 
 * @author kishan
 * User sacrifices a quarter of his hp to damage
 * his opponent. An Umesh move.
 */
public class kneeExplosion extends Moves{
	
	/**
	 * standard = 0
	 * takes up 3 endurance points
	 */
	public kneeExplosion() {
		super(0, "Knee Explosion", 3);
	}
	
//	public void act(fighter user){
//		user.remEnd -=3; //3 endurance points
//		user.remHP -= (int)(.25 * user.initHP); //user loses quarter of his total hp
//		int d = (int)(Math.random()*5) + (user.strength + 20);
//		System.out.println(user.name + " used Knee Explosion on " + user.target.name
//				+ " and inflicted " + d + " hitpoints of damage, but lost " + (int)(.25 * user.initHP)
//				+ " hp.");
//		user.target.remHP -= d;
//	}//end method
	
	public void act(fighter user){
		double acc = Math.random(); //a decimal value between 0 and 1
		user.remEnd -= this.endCost;
		user.remHP -= (int)(.25 * user.initHP); //user loses quarter of his total hp
		acc += user.con; //boosted accuracy based on user's concentration
//		System.out.println(acc);
		if(acc < this.standard){
			System.out.print(user.name + " used " + this.moveName +".... but ");
			user.info += user.name + " used " + this.moveName +".... but ";
			user.miss();
		}else{
			this.doMove(user);
		}//end if else
		if(user.remHP <= 0){
			user.isAlive = false;
		}//end if
	}//end method
	
	public void doMove(fighter user){
		int d = (int)(Math.random()*5) + (user.strength + 20);
		System.out.println(user.name + " used Knee Explosion on " + user.target.name
				+ " and inflicted " + d + " hitpoints of damage, but lost " + (int)(.25 * user.initHP)
				+ " hp.");
		user.info += user.name + " used Knee Explosion on " + user.target.name
		+ " and inflicted " + d + " hitpoints of damage, but lost " + (int)(.25 * user.initHP)
		+ " hp. -\n";
		user.i.setText(user.info);
		user.target.remHP -= d;
	}
}//end class
