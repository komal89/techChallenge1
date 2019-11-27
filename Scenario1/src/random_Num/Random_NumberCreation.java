
package random_Num;

import java.io.IOException;
import java.util.Random;

import javax.management.RuntimeErrorException;

import org.apache.logging.log4j.*;

public class Random_NumberCreation {

	public static Logger log = LogManager.getLogger(Random_NumberCreation.class.getName());

	public static void main(String args[]) throws IOException {
		// TODO Auto-generated method stub	
		
		Random r = new Random();
		int numLines =Integer.parseInt(args[0]);
	if (numLines>=100 && numLines<=500) {
		log.info("TestCase Passed");
		log.debug("Value input by the user is within the minimum and the maximum limit defined");
		
		
		for(int i=1;i<= 50;) {
			int randomNumber = (r.nextInt(41)+10)*10;
			System.out.println(i +" " +randomNumber);
			i++;
		}
	} else
	{
	log.info("TestCase Failed");	
	log.error(Error.class);
	log.error("Value input by the user is outside the minimum and the maximum limit defined");

	}
		

		
	}
	
	
}