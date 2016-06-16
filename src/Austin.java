/**
 * @author kishan
 *
 * black anaconda
 */
public class Austin extends fighter{
	public Austin() {
		super("Austin Lee", 95, 16, 17, 18, 0.02,
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
