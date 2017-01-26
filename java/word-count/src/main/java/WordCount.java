import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
    
    /**
     * returns a count of the words in the phrase
     * @param words a string containing the words to count
     * @return a Map object with the words as keys and 
     *         the count of each one as the
     */
    public Map<String, Integer> phrase(String words){
        
        if(words == null){ throw new IllegalArgumentException("words must not be null"); }

        // if there are no words in the phrase, return an empty HashMap
        // could also throw IllegalArgumentException, but there was
        // nothing in the specification that said either way was preferred
        if(words.isEmpty()){ return new HashMap<>(); }
        
        Map<String, Integer> counts = new HashMap<>();
        
        Arrays.asList(words.toLowerCase()
                           .replaceAll("[^A-Za-z0-9]", " ")
                           .split(" "))
                           .stream()
                           .forEach(word -> { 
                                    if(word.trim().length() > 0){
                                       counts.put(word, (counts.containsKey(word)) ? (counts.get(word) + 1) : 1);
                                    }
                           });
        
        return counts;
    }
    
}
