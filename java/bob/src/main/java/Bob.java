
public class Bob {
     
    private final static String NOTHING = "Fine. Be that way!";
    private final static String QUESTION = "Sure.";
    private final static String YELLING = "Whoa, chill out!";
    private final static String OTHER = "Whatever.";
    
     public String hey(String s){
         String phrase = s.trim();

         if(sayNothing(phrase)){ return NOTHING; }
         if(isYelling(phrase)){ return YELLING; }
         if(askQuestion(phrase)){ return QUESTION; }
         
         return OTHER;
     }
     
     private boolean sayNothing(String s){
         return s.length() == 0;
     }
     
     private boolean isYelling(String s){
         boolean hasLetters = s.chars().anyMatch(Character::isLetter);
         return (s.toUpperCase().equals(s) && hasLetters);
     }
     
     private boolean askQuestion(String s){
         return s.endsWith("?");
     }
}
