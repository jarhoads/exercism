import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class School {
    
    private final Map<Integer, List<String>> roster;
    
    public School(){
        this.roster = new HashMap<>();
    }
    
    public void add(String student, int grade){
        if(roster.containsKey(grade)){
            roster.get(grade).add(student);
        } else {
            roster.put(grade, new LinkedList<String>(Arrays.asList(student)));
        }
    }
    
    public Map<Integer, List<String>> db(){
        return new HashMap<Integer, List<String>>(roster);
    }
    
    public List<String> grade(int grade){
        return roster.containsKey(grade) ? new ArrayList<String>(roster.get(grade)) : new ArrayList<String>();
    }
    
    public Map<Integer, List<String>> sort(){
        return roster.keySet().stream()
                     .collect(Collectors.toMap(k -> k, k -> sortRoster(roster.get(k))));
    }
    
    private List<String> sortRoster(List<String> r){
        List<String> sorted = new ArrayList<>(r);
        sorted.sort(String::compareTo);
        return sorted;
    }

}
