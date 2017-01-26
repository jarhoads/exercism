package gigasecond;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {
    
    private final LocalDateTime gigasecond;
    
    private final static long GIGASECOND = 1000000000L;
    
    public Gigasecond(LocalDate date){
        this(date.atStartOfDay());
    }
    
    public Gigasecond(LocalDateTime date){
        gigasecond = date.plusSeconds(GIGASECOND);
    }
    
    public LocalDateTime getDate(){
        return gigasecond;
    }

}
