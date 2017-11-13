import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by lbb on 2017/11/13.
 */
public class Helper {


    private float threhold = 0.1f;
    private List<Attribute> attributes;

    Helper() {

    }

    Helper(List<Attribute> attrs) {
        this.attributes = attrs;
    }

    public TreeNode ID3(List<Attribute> attrs, List<Item> items) {
        TreeNode tn = new TreeNode();
        // format the tree
        //// TODO: 2017/11/13  

        threhold = 0.2f;
        return tn;
    }

    private void id3Helper(List<Attribute> attrs, List<Item> items) {
        Attribute bestAttr = findBestAttr(attrs, items);

        if (!attributes.contains(bestAttr))
            return;

        List<List<Item>> subClasses = bestAttr.values.stream().map(
                v -> items.stream().filter(i -> i.values.get(bestAttr).equals(v)
                ).collect(Collectors.toList())
        ).collect(Collectors.toList());

        attrs.remove(bestAttr);

        Helper that = this;
        subClasses.forEach(s -> {
            id3Helper(attrs, s);
        });
        
        // record the tree;
        // // TODO: 2017/11/13  
    }

    public Attribute findBestAttr(List<Attribute> attrs, List<Item> items) {
        //if there is no attribute, return;
        if (attrs.size() == 0)
            return new Attribute();

        //
        int size = items.size();
        double positiveP = items.stream().filter(i -> i.values.get("class").equals("yes")).count() * 1.0 / size;
        double negtiveP = items.stream().filter(i -> i.values.get("class").equals("no")).count() * 1.0 / size;

        // if samples are all in one class, return;
        if (positiveP == 0 || negtiveP == 0)
            return new Attribute();

        double entropyOld = -(Math.log(positiveP) * positiveP + Math.log(negtiveP) + negtiveP);

        //else, compute the entropy decrease for each attribute
        double entropyNew = 0.0;

        //non-test
        Optional<Attribute> res = attrs.stream().collect(Collectors.maxBy(Comparator.comparingDouble((attr) -> {
            //for each attribute, compute entropy decrease.
            return attr.values.stream().mapToDouble((value) -> {

                //for each value, compute rate :subitems.size/totalsize
                double rate = items.stream().filter(i -> i.values.get(attr.name) == value).count() * 1.0 / size;

                // for each value, compute log(p)*p
                double p = items.stream().filter(i -> i.values.get(attr.name) == value).filter(i -> i.values.get("class").equals("yes")).count() * 1.0 / size;

                // return entropy
                return rate * (p * Math.log(p) + (1 - p) * Math.log(1 - p));
            }).sum();
        })));
        // jduge if the max entropy is larger than threshold
        //// TODO: 2017/11/13  

        return res.get();
    }
}
