import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbb on 2017/11/9.
 */
public class Attribute {
    public String name = new String();
    public List<String> values = new ArrayList<String >();

    Attribute(){

    }

    Attribute(String name){
        this.name = name;
    }

    Attribute(String name, List<String> values){
        this.name = name;
        this.values = values;
    }

    public void addValue (String value){
        values.add(value);
    }
}
