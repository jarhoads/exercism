import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etl {
    
    /**
     * a transform method to convert an old scrabble scoring system to a new one
     * @param old A Map object representing the old scoring system
     * @return A Map object representing the new scoring system
     */
    public Map<String, Integer> transform(Map<Integer, List<String>> old) {
        
        Map<String, Integer> letterPoints = new HashMap<>();
        old.forEach((points, letters) -> 
            letters.forEach(letter -> letterPoints.put(letter.toLowerCase(), points))); 
        
        return letterPoints;
    }
    
}
