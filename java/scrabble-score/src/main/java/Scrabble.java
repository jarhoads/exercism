import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Scrabble {
    
    private int score;
    
    private Pattern empty = Pattern.compile("");
                                                           // A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P 
    private final static List<Integer> scores = Arrays.asList(1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3,
                                                           // Q  R  S  T  U  V  W  X  Y  Z   
                                                             10, 1, 1, 1, 1, 4, 4, 8, 4, 10);

    private static int OFFSET = Character.getNumericValue('A');
    
    public Scrabble(final String input){ 
        score = (input == null) ? 0 : getScore(input.toUpperCase().split("\\W"));
    }
    
    private int getScore(String[] in){
        return (in.length == 0) ? 0 : scoreWord(in);
    }
    
    private int scoreWord(String[] letters){
        return Arrays.stream(letters)
                     .mapToInt(this::scrabble)
                     .sum();
    }
    
    private int scrabble(final String word){
        
        return empty.splitAsStream(word)
                    .mapToInt(c -> scores.get(Character.getNumericValue(c.charAt(0)) - OFFSET))
                    .sum();
    }
    
    public int getScore(){
        return score;
    }

}
