package items;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.Calendar;


public class Helper {
	
	public static boolean ifMeetsCriteria(Item item){
		//@SuppressWarnings("deprecation")
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		Calendar now = Calendar.getInstance();
	    TimeZone timeZone = now.getTimeZone();
	    sdf.setTimeZone(TimeZone.getTimeZone(timeZone.getID().toString()));
		Date currentDate = null;
		Date itemDate = null;
		try {
			 String d = sdf.format(new Date());
			 currentDate = sdf.parse(d);
			 itemDate = sdf.parse(item.getTimeStamp());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		long diff = 0;
		diff = Math.abs(currentDate.getTime() - itemDate.getTime());
		long seconds = TimeUnit.MILLISECONDS.toSeconds(diff) % 60;
        long minutes = TimeUnit.MILLISECONDS.toMinutes(diff) % 60;
        long hours = TimeUnit.MILLISECONDS.toHours(diff) % 24;
        long days = TimeUnit.MILLISECONDS.toDays(diff) % 365;
        long years = TimeUnit.MILLISECONDS.toDays(diff) / 365;
        long totalSeconds = years * 365 * 24 * 60* 60 + days*24*60*60 + hours*60*60 + minutes*60 + seconds;
		System.out.println("diffSeconds ------ " + totalSeconds);
		if(totalSeconds < 2)
			return true;
		
		return false;
	}

}
