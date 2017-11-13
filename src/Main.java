

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.HashMap;

public class Main {


    private float threhold = 0.1f;


    public static void main(String[] args) {
        List<Attribute> attrs = new ArrayList<Attribute>();

        Attribute weather = new Attribute("weather");
        weather.addValue("sunny");
        weather.addValue("rain");
        weather.addValue("overcast");
        attrs.add(weather);

        Attribute temperature = new Attribute("temperature");
        temperature.addValue("hot");
        temperature.addValue("mild");
        temperature.addValue("cool");
        attrs.add(temperature);

        Attribute humidity = new Attribute("humidity");
        humidity.addValue("high");
        humidity.addValue("normal");
        attrs.add(humidity);

        Attribute windy = new Attribute("windy");
        windy.addValue("true");
        windy.addValue("false");
        attrs.add(windy);

        Attribute result = new Attribute("class");
        result.addValue("yes");
        result.addValue("no");
        attrs.add(result);

        // read data from file.txt
        List<Item> traningData = new ArrayList<Item>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            String line = br.readLine();

            while (line != null) {
                String[] tmp = line.split(" ");
                Item item = new Item();
                item.values.put(weather.name, tmp[0]);
                item.values.put(temperature.name, tmp[1]);
                item.values.put(humidity.name, tmp[2]);
                item.values.put(windy.name, tmp[3]);
                item.values.put(result.name, tmp[4]);
                traningData.add(item);
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("IO error");
        }

        float threhold = 0.1f;
        //find the best attribute to classify
        Helper helper = new Helper(attrs);
        System.out.println(helper.findBestAttr(attrs,traningData).name);
        System.out.println("********************************");
    }

}

class Item {
    public Map<String, String> values = new HashMap<String, String>();

    Item() {

    }

    Item(Map<String, String> values) {
        this.values = values;
    }
}
