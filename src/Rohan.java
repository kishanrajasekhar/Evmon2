import java.util.ArrayList;

/**
 * 
 * @author kishan
 *	Rohan lacks in raw speed, but he has
 *  very high endurance. (idk)
 *  Change stats (the numbers in the constructor) and description if you want.
 */
public class Rohan extends fighter{
	
	public Rohan() {
		// TODO Auto-generated constructor stub
		super("Rohan Varma", 110, 13, 14, 20, 0.025,
				"D:\\Kishan's Work\\Images\\pikachu.jpg");
		listOfMoves = "1)Punch 2)Warm-Up 3)Spike 4)Lift";
		m1 = new punch();
		m2 = new warmUp();
		m3 = new spike();
		m4 = new lift();
		mv1.setText(m1.moveName);
		mv2.setText(m2.moveName);
		mv3.setText(m3.moveName);
		mv4.setText(m4.moveName);
	}//end constructor
	
}//end class
