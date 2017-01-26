import java.util.Arrays;
import java.util.stream.Collectors;

public class Acronym {
    
    public static String generate(String phrase){

        String[] words = phrase.split("[\\s-:]+");
        
        return Arrays.asList(words)
                     .stream().map(Acronym::acronymLetters)
                              .collect(Collectors.joining())
                     .toUpperCase(); 
        
    }
    
    private static String acronymLetters(String word){
        
        String acronym = word.charAt(0) + 
                         word.substring(1)
                             .chars().mapToObj(c -> (char)c)
                                     .filter(c -> Character.isUpperCase(c))
                                     .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                             .toString();
        
        // I'm not proud of this, but it's what I came up with 
        // to pass the weird 'PHP' test
        return (acronym.length() == word.length()) ? Character.toString(word.charAt(0)) : acronym; 
    }

}
