import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Robot {
    private static final Random generator = new Random();
    private static Set<String> names = new HashSet<>();
    
    private String name;
    
    public Robot(){
        name = setName();
    }
    
    public String getName(){
        return name;
    }
    
    public void reset(){
        name = setName();
    }
    
    private String setName(){
        String robot = robotName();
        
        while(names.contains(robot)){ robot = robotName(); }
        //if(names.contains(robot)){ robot = setName(); }
        
        names.add(robot);
        
        return robot;
    }
    
    private Stream<String> letters(int n){
        // I just read about Random ints() from 
        // https://www.mkyong.com/java/java-generate-random-integers-in-a-range/
        // the Java 8 information begins in section 3
        
        return generator.ints('A', ('Z' + 1))
                        .limit(n)
                        .mapToObj(i -> Character.toString((char)i));

    }
    
    private Stream<String> numbers(int n){
        return generator.ints(0, 10)
                .limit(n)
                .mapToObj(Integer::toString);
    }
    
    private String robotName(){
        return Stream.concat(letters(2),numbers(3))
                     .collect(Collectors.joining());
    }

}
