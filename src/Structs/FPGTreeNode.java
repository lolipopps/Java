package Structs;


import java.util.ArrayList;
import java.util.List;



public class FPGTreeNode implements Comparable<FPGTreeNode>{

    private String name; // 节点名称
    private Integer count; // 计数
    private FPGTreeNode parent; // 父节点
    private List<FPGTreeNode> children; // 子节点
    private FPGTreeNode nextHomonym; // 下一个同名节点
  
    public FPGTreeNode() {
  
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	public void Sum(Integer count) {
		this.count =this.count+count;
	}
	public FPGTreeNode getParent() {
		return parent;
	}

	public void setParent(FPGTreeNode parent) {
		this.parent = parent;
	}

	public List<FPGTreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<FPGTreeNode> children) {
		this.children = children;
	}

	public FPGTreeNode getNextHomonym() {
		return nextHomonym;
	}

	public void setNextHomonym(FPGTreeNode nextHomonym) {
		this.nextHomonym = nextHomonym;
	}
    /**
     * 加入一个节点
     * @param child
     */
    public void addChild(FPGTreeNode child) {
        if (this.getChildren() == null) {
            List<FPGTreeNode> list = new ArrayList<FPGTreeNode>();
            list.add(child);
            this.setChildren(list);
        } else {
            this.getChildren().add(child);
        }
    }
    /**
    *  是否存在着该节点,存在返回该节点，不存在返回空
    * @param name
    * @return
    */
    public FPGTreeNode findChild(String name) {
        List<FPGTreeNode> children = this.getChildren();
        if (children != null) {
            for (FPGTreeNode child : children) {
                if (child.getName().equals(name)) {
                    return child;
                }
            }
        }
        return null;
    }


    @Override
    public int compareTo(FPGTreeNode arg0) {
        // TODO Auto-generated method stub
        int count0 = arg0.getCount();
        // 跟默认的比較大小相反。导致调用Arrays.sort()时是按降序排列
        return count0 - this.count;
    }
}
