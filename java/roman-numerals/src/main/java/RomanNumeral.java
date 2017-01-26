import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RomanNumeral {
    private final int numeral;
    private final String roman;
    
    private static final List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
                                                        10, 20, 30, 40, 50, 60, 70, 80, 90,
                                                        100, 200, 300, 400, 500, 600, 700, 800, 900,
                                                        1000, 2000, 3000);
    private static final List<String> romans = Arrays.asList("", "I", "II", "III", "IV", "V",
                                                      "VI", "VII", "VIII", "IX", "X", 
                                                      "XX", "XXX", "XL", "L", "LX", "LXX",
                                                      "LXXX", "XC", "C","CC","CCC", "CD", 
                                                      "D", "DC", "DCC", "DCCC", "CM",
                                                      "M", "MM", "MMM");
    
    private static final Map<Integer, String> romanNumbers = new HashMap<>();
    
    static{
        zip(numbers, romans).stream().forEach(e -> romanNumbers.put((Integer)e.get(0), (String)e.get(1)));
    }
    
    public RomanNumeral(int num){
        numeral = num;
        roman = convert(numeral);
    }
    
    public String getRomanNumeral(){
        return roman;
    }
    
    private String convert(int n){
        
        if(n >= 1000){ return romanNumbers.get((Integer)(1000 * (n / 1000))) + convert(n % 1000);}
        else if(n >= 100){ return romanNumbers.get((Integer)(100 * (n / 100))) + convert(n % 100);}
        else if(n >= 10){ return romanNumbers.get((Integer)(10 * (n / 10))) + convert(n % 10);}
        else if(n > 0){ return romanNumbers.get((Integer)(n)); }
        else{ return ""; }
    }
    
    /**
     * creates a zipped list containing lists of elements from
     * the same positions of the lists in the arguments
     * @param l1 first list
     * @param l2 second list
     * @return a List<List<Object>> containing elements from both lists
     */
    private static <T,U> List<List<Object>> zip(List<T> l1, List<U> l2){
        
        return IntStream.range(0, l1.size())
                        .mapToObj(i -> Arrays.asList(l1.get(i), l2.get(i)))
                        .collect(Collectors.toList());
        
    }

}
