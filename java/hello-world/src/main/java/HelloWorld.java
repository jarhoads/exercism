public class HelloWorld {
    public static String hello(String name) {
        if(name == null){ return "Hello, World!"; }
        
        return (name.isEmpty()) ? "Hello, World!" : "Hello, " + name + "!";
    }
}
