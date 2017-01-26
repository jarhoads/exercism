import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Meetup {
    
    private int month;
    private int year;
    
    // I couldn't come up with a better way to check for teenths
    private static final List<Integer> teenths = Arrays.asList(13, 14, 15, 16, 17, 18, 19);
    
    public Meetup(int m, int y){
        month = m;
        year = y;
        
    }
    
    public LocalDate day(DayOfWeek day, MeetupSchedule schedule){
        
        //build a list of days matching the day of the week
        final List<LocalDate> days = IntStream.rangeClosed(1, YearMonth.of(year, month).lengthOfMonth())
                                              .mapToObj(i -> LocalDate.of(year, month, i))
                                              .filter(d -> d.getDayOfWeek().equals(day))
                                              .collect(Collectors.toList());
        
        // this could probably be turned into a Map.
        // for now I think the problem lends itself well to
        // using a switch
        switch (schedule) {
            case FIRST:
                return single(1, days);
            case SECOND:
                return single(2, days);
            case THIRD: 
                return single(3, days);
            case FOURTH: 
                return single(4, days);
            case TEENTH:
                return teenth(days);
            case LAST:
                return last(days);
            default:
                throw new IllegalArgumentException("Incorrect Schedule Option");
        }
        
    }
    
    private LocalDate single(int i, List<LocalDate> ds){
        return ds.get(i-1);
    }
    
    private LocalDate teenth(List<LocalDate> ds){
        return ds.stream().filter(d -> teenths.contains(d.getDayOfMonth()))
                          .findFirst().get();
    }
    
    private LocalDate last(List<LocalDate> ds){
        return ds.get(ds.size() - 1);
    }


}
