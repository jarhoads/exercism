import java.util.List;
import java.util.stream.Collectors;

public class Anagram {
    
    private final String word;
    
    public Anagram(String word){
        this.word = word.toLowerCase();
    }
    
    public List<String> match(List<String> words){
        
        return words.stream().filter(this::isAnagram)
                             .collect(Collectors.toList());
        
    }
    
    private boolean isAnagram(String str){
        
        String s = str.toLowerCase();
        
        if(s.length() != word.length()){ return false; }
        if(s.equals(word)){ return false; }
        
        // I'm trying to find a better way to do this part
        // so far the lack of a CharStream makes everything
        // more complicated than it needs to be and I just keep
        // giving up on working with it
        for(char letter : s.toCharArray()){
            
            long wordCount = word.chars().filter(ch -> ch == letter)
                                         .count();
            
            long sCount = s.chars().filter(ch -> ch == letter)
                                   .count();
            
            if(word.indexOf(letter) < 0 || wordCount != sCount){ return false; }
        }
        
        return true;
        

    }
}
