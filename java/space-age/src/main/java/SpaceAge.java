import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SpaceAge {
    
    private long seconds;
    private Map<Planets, Double> years;
    
    private static final int EARTH_SECONDS_PER_YEAR = 31557600;

    private static final double EARTH_ORBIT = 1.0;
    private static final double MERCURY_ORBIT = 0.2408467;
    private static final double VENUS_ORBIT = 0.61519726;
    private static final double MARS_ORBIT = 1.8808158;
    private static final double JUPITER_ORBIT = 11.862615;
    private static final double SATURN_ORBIT = 29.447498;
    private static final double URANUS_ORBIT = 84.016846;
    private static final double NEPTUNE_ORBIT = 164.79132;

    private static final double EARTH_VAL = EARTH_ORBIT * EARTH_SECONDS_PER_YEAR;
    private static final double MERCURY_VAL = MERCURY_ORBIT * EARTH_SECONDS_PER_YEAR;
    private static final double VENUS_VAL = VENUS_ORBIT * EARTH_SECONDS_PER_YEAR;
    private static final double MARS_VAL = MARS_ORBIT * EARTH_SECONDS_PER_YEAR;
    private static final double JUPITER_VAL = JUPITER_ORBIT * EARTH_SECONDS_PER_YEAR;
    private static final double SATURN_VAL = SATURN_ORBIT * EARTH_SECONDS_PER_YEAR;
    private static final double URANUS_VAL = URANUS_ORBIT * EARTH_SECONDS_PER_YEAR;
    private static final double NEPTUNE_VAL = NEPTUNE_ORBIT * EARTH_SECONDS_PER_YEAR;
    
    private enum Planets { 
        EARTH(EARTH_VAL), 
        MERCURY(MERCURY_VAL), 
        VENUS(VENUS_VAL), 
        MARS(MARS_VAL), 
        JUPITER(JUPITER_VAL), 
        SATURN(SATURN_VAL), 
        URANUS(URANUS_VAL), 
        NEPTUNE(NEPTUNE_VAL);
        
        private final double orbit;
        Planets(double orbit){
            this.orbit = orbit;
        }
        
        double getOrbit(){ return orbit; }
        double on(Map<Planets, Double> year){ return year.get(this); }
        
    }
    
    public SpaceAge(long secs){
        this.seconds = secs;

        years = Arrays.asList(Planets.values())
                      .stream()
                      .collect(Collectors.toMap(planet -> planet, planet -> yearsOn(planet.getOrbit())));
    }
    
    public long getSeconds(){
        return seconds;
    }
    
    public double onEarth(){ return Planets.EARTH.on(years); }
    public double onMercury(){ return Planets.MERCURY.on(years); }
    public double onVenus(){ return Planets.VENUS.on(years); }
    public double onMars(){ return Planets.MARS.on(years); }
    public double onJupiter(){ return Planets.JUPITER.on(years); }
    public double onSaturn(){ return Planets.SATURN.on(years); }
    public double onUranus(){ return Planets.URANUS.on(years); }
    public double onNeptune(){ return Planets.NEPTUNE.on(years); }

    private double yearsOn(double orbit) {
        return seconds / orbit;
    }

}
