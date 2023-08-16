package Map;

public class Value {
    
    private JSON<Value> json;
    private String string;
    private double number;
    private Value[] array;

    private boolean isJSON = false;
    private boolean isString = false;
    private boolean isNumber = false;
    private boolean isArray = false;

    public Value(JSON<Value> json) {
        this.json = json;
        this.isJSON = true;
    }

    public Value(String string) {
        this.string = string;
        this.isString = true;
    }

    public Value(double number) {
        this.number = number;
        this.isNumber = true;
    }

    public Value(Value[] array) {
        this.array = array;
        this.isArray = true;
    }

    public String whatIsMyType(){
        if (this.isJSON) {
            return "JSON";
        } else if (this.isString) {
            return "String";
        } else if (this.isNumber) {
            return "Number";
        } else if (this.isArray) {
            return "Array";
        } else {
            return "Unknown";
        }
    }
    
    public JSON<Value> getJSON() {
        return this.json;
    }
}
