import java.text.SimpleDateFormat; 
import java.util.Date;

public class DateToday {
 
      static void dateinfo() {
 
        Date now = new Date();
 
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); 
        simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
        System.out.println(simpleDateformat.format(now));
 
    }
}