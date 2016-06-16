
public class eatSnack extends Moves{
	
	/*
	 * this move can't fail
	 * uses 0 endurance points
	 */
	public eatSnack() {
		super(-100,"Eat Snack",0);
	}//end constructor
	
	/**
	 * figher eats a light snack and recovers 15 hp
	 */
	public void doMove(fighter user){
		if(count > 7){
			System.out.println(user.name + " is full!");
			user.info += user.name + " is full! -\n";
			user.i.setText(user.info);
		}else{
			System.out.println(user.name + " at a snack and replenished 15 hp.");
			user.info += user.name + " at a snack and replenished 15 hp. -\n";
			user.i.setText(user.info);
			user.remHP += 15;
			if(user.remHP > user.initHP){
				user.remHP = user.initHP;
			}//end if
			if ((count > 0) && (count % 2 == 0)){
				System.out.print(user.name + " is getting full... ");
				user.info += user.name + " is getting full... -\n";
				user.i.setText(user.info);
				if (user.speed < user.spMin){
					System.out.println(user.name + "'s speed can't decrease any further.");
					user.info += user.name + "'s speed can't decrease any further. -\n";
					user.i.setText(user.info);
					user.speed = user.spMin;
				}else{
					System.out.println(user.name + "'s speed decreased.");
					user.info += user.name + "'s speed decreased. -/n";
					user.i.setText(user.info);
					user.speed--;
				}//end if else
			}//end if
		}//end if else
	}//end method
}//end class
