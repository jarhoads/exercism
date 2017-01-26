
public class Triangle {
    
    private TriangleKind kind;
    
    public Triangle(double a, double b, double c) throws TriangleException{
        if(a == 0.0 || b == 0.0 || c == 0.0){ throw new TriangleException(); }
        if(a >= b + c || b >= a + c || c >= a + b){ throw new TriangleException(); }
        
        kind = setKind(Double.compare(a, b) == 0, Double.compare(b, c) == 0, Double.compare(a, c) == 0);
    }
    
    private TriangleKind setKind(boolean aEqb, boolean bEqc, boolean aEqc){
        if(aEqb && bEqc && aEqc){ return TriangleKind.EQUILATERAL; }
        else if(aEqb || bEqc || aEqc){ return TriangleKind.ISOSCELES; }
        else{ return TriangleKind.SCALENE; }
    }
    
    public TriangleKind getKind(){
        return kind;
    }

}
