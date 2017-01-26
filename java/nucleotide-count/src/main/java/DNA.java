import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DNA {
    
    // nucleotideCounts contains the counts for the nucleotides
    //                  initialized with the dna string in the constructor
    private Map<Character, Integer> nucleotideCounts;
    // nucleotides is an immutable map with initial values of 0 for each nucleotide
    //             initialized in the constructor
    //             I know this probably isn't necessary, 
    //             it's more of a way for me to play around with java 8 stuff
    private final Map<Character, Integer> nucleotides;
    
    /**
     * DNA class constructor
     * @param dna the string of DNA to use for nucleotide counts
     */
    public DNA(String dna){
        this.nucleotides = Collections.unmodifiableMap(initializeCounterMap('A', 'T', 'C', 'G'));
        this.nucleotideCounts = countNucleotidesMap(dna);
    }
    
    /**
     * initializeCounterMap utility method that initializes the counts of nucleotides to zero
     * @param strings character values that will be added as keys to the map
     * @return Map<Character, Integer> with keys that represent each nucleotide and values for counts all set to zero
     */
    private Map<Character, Integer> initializeCounterMap(Character... strings){
        return Arrays.asList(strings).stream().collect(Collectors.toMap(s -> s, s -> 0));
    }
    
    /**
     * countNucleotidesMap utility method to count the number of each nucleotide in the DNA string
     * @param dnaString string of DNA nucleotides
     * @return Map<Character, Integer> that represents the count of each nucleotide
     */
    private Map<Character, Integer> countNucleotidesMap(String dnaString){
        return (dnaString.length() > 0) ? 
                nucleotides.keySet().stream()
                           .collect(Collectors.toMap(n -> n, 
                                                     n -> numChars(dnaString,n)))
                : new HashMap<Character, Integer>(nucleotides);
    }
    
    /**
     * numChars utility method used to count the number of a specific character in a string
     * @param s string containing the character
     * @param c the character to search for
     * @return the number of characters in a string if the string is not empty, otherwise 0
     */
    private static int numChars(String s, char c){
        return (s.length() > 0) ? s.length() - s.replaceAll(Character.toString(c), "").length() : 0;
    }
    
    /**
     * int count method - throws IllegalArgumentException if nucleotide is not in the map
     * @param nucleotide nucleotide to search for a count
     * @return the count of the nucleotide in the DNA string
     */
    public int count(char nucleotide){
        
        if(!nucleotideCounts.containsKey(nucleotide)){ throw new IllegalArgumentException("Nucleotide must be 'A', 'C', 'G', or 'T'"); }
        
        return nucleotideCounts.get(nucleotide); 
        
    }
     
    /**
     * nucleotideCounts method uses defensive copying 
     * to make sure the internal map isn't exposed to the client
     * @return a HashMap containing the counts for each nucleotide
     */
    public Map<Character, Integer> nucleotideCounts(){
        return new HashMap<Character, Integer>(nucleotideCounts);
    }
}
