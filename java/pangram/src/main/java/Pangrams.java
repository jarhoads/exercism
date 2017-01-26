package pangram;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Pangrams {
    
    /**
     * isPangram returns true if the phrase is a pangram, false otherwise
     * returns false for an empty phrase
     * @param phrase the phrase to check for a pangram
     * @return true if the phrase is a pangram, false otherwise
     */
    public static boolean isPangram(String phrase){
        
        if(phrase == null){ throw new IllegalArgumentException("phrase can't be null"); }
        
        if(phrase.isEmpty()){ return false; }
        
        // I feel like this is probably defined as a constant somewhere,
        // but I couldn't find it so I'm using this
        final String letters = "abcdefghijklmnopqrstuvwxyz";
        
        Set<String> chars = Arrays.asList(phrase.toLowerCase().split(""))
                                  .stream()
                                  .filter(s -> letters.contains(s))
                                  .collect(Collectors.toSet());
        
        return letters.length() == chars.size();
    }

}
