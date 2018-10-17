import java.util.*;

public class ClockDegrees {
	
	public static void main(String[] args) {

		String time = "15:42";
		System.out.println(degreesBetweenHands(time));
	}

	public static double degreesBetweenHands(String time) {

		int colon = time.indexOf(":");
		int hour = Integer.parseInt(time.substring(0,colon))%12;
		int minutes = Integer.parseInt(time.substring(colon+1,time.length()));

		double hourAngle = (60.0*hour+minutes)/2.0;
		double minuteAngle = 6.0*minutes;

		return Math.abs(hourAngle-minuteAngle);
	}
}