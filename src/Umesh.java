import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author kishan
 * Umesh is about average in everything... (idk)
 * Change stats (the numbers in the constructor) and description if you want.
 */
public class Umesh extends fighter{

	public Umesh(){
		super("Umesh Taniru", 85, 15, 16, 16, 0.01, 
				"D:\\Kishan's Work\\Images\\banana.jpg");
		listOfMoves = "1)Eat Snack 2)Knee Explosion 3)Spike 4)Banana Throw";
		m1 = new eatSnack();
		m2 = new kneeExplosion();
		m3 = new spike();
		m4 = new bananaThrow();
		missText = super.missText + " Umeshed up!";
		mv1.setText(m1.moveName);
		mv2.setText(m2.moveName);
		mv3.setText(m3.moveName);
		mv4.setText(m4.moveName);
		
	}//end constructor
	
}//end class
