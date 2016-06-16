/**
 * 
 * @author kishan
 * driver for the game. Later on,
 * I want to let the players choose the fighters 
 * (later on when there's more fighters.)
 * The fighters can be stored in an array list.
 */
public class driver1 {
	public static void main(String args[]){
		
		fighter p1 = new Umesh(); //player 1
		fighter p2 = new Rohan(); //player 2
		p1.setTarget(p2); //setting the targets 
		p2.setTarget(p1); // to each other
		
		while (p1.isAlive && p2.isAlive){
			p1.chooseMove(p1.listOfMoves);
			p2.chooseMove(p2.listOfMoves);
			if(p1.speed > p2.speed){
				p1.attack();
				p2.attack();	
			}else if(p1.speed < p2.speed){
				p2.attack();
				p1.attack();
			}else{//if the speed is equal
				int r = (int)(Math.random() * 2); //random integer (0 or 1)
				if(r == 0){
					p1.attack();
					p2.attack();
				}else{
					p2.attack();
					p1.attack();
				}//end if else
			}//end if else
		}//end while
	}//end main
}//end class
