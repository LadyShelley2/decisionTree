import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbb on 2017/11/9.
 */
public class TreeNode {
    private Attribute attribute = new Attribute();
    private List<TreeNode> children = new ArrayList<TreeNode>();
    TreeNode(){

    }
    TreeNode(Attribute attribute){
        this.attribute = attribute;
    }
    TreeNode(Attribute attribute,List<TreeNode> children){
        this.attribute = attribute;
        this.children = children;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public void appendChild(TreeNode node){
        this.children.add(node);
    }
}
