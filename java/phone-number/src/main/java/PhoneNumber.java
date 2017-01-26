

public class PhoneNumber {
    
    private final static int VALID_PHONE_NUMBER_LENGTH = 10;
    
    private final static int AREA_CODE_START = 0;
    private final static int AREA_CODE_END = 3;
    private final static int LOCAL_CODE_END = 6;
    
    private final String number;
    private final String areaCode;
    private final String localCode;
    private final String localNumber;
    
    public PhoneNumber(String n){
        number = parseNumber(n);
        
        areaCode = number.substring(AREA_CODE_START, AREA_CODE_END);
        localCode = number.substring(AREA_CODE_END, LOCAL_CODE_END);
        localNumber = number.substring(LOCAL_CODE_END);
    }
    
    public String getAreaCode(){
        return areaCode;
    }
    
    public String getNumber(){
        return number;
    }
    
    public String pretty(){
        return "(" + areaCode + ") " + localCode + "-" + localNumber;
    }
    
    private String parseNumber(String n){
        
        String phone = n.replaceAll("\\D", "");
        
        return (international(phone)) ? validate(phone.substring(1)) : validate(phone);
        
    }
    
    private boolean international(String n){
        return (n.length() > VALID_PHONE_NUMBER_LENGTH) && n.startsWith("1");
    }
    
    private String validate(String n){
        return (n.length() == VALID_PHONE_NUMBER_LENGTH) ? n : "0000000000";
    }

}
