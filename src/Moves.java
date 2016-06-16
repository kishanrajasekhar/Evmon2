
public abstract class Moves {
	
//	double acc; //accuracy
	double standard; //the value that acc needs to be over in order for the attack to hit the foe
	String moveName; //the name of the move
	int endCost; //how much endurance the move costs
	int count; //how many times that the move is used
	
	public Moves(double s, String name, int e) {
		standard = s;
		moveName = name;
		endCost = e;
		count = 0;
	}//end constructor
	
	public void act(fighter user){
		double acc = Math.random(); //a decimal value between 0 and 1
		user.setRemEnd(user.getRemEnd() - this.endCost);
		acc += user.getCon(); //boosted accuracy based on user's concentration
//		System.out.println(acc);
		if(acc < this.standard){
			System.out.print(user.getName() + " used " + this.moveName +".... but ");
			user.info += user.name + " used " + this.moveName +".... but ";
			user.miss();
		}else{
			this.doMove(user);
		}//end if else
		count ++;
	}//end method
	
	public void doMove(fighter user){} //user successfully does the move
	
}//end class
