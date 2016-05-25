package huffmanTree;

@SuppressWarnings("rawtypes")
public class HuffmanNode implements Comparable,Cloneable {

	@Override
	public int compareTo(Object o) {
		return this.key-((HuffmanNode)o).key;
	}
	
	protected int key;
	protected HuffmanNode left;
	protected HuffmanNode right;
	protected HuffmanNode parent;
	protected HuffmanNode(int key, HuffmanNode left, HuffmanNode right, HuffmanNode parent) {
		this.key = key;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
	
	@Override
    public Object clone() {
        Object obj=null;

        try {
            obj = (HuffmanNode)super.clone();//Object �е�clone()ʶ�����Ҫ���Ƶ�����һ������    
        } catch(CloneNotSupportedException e) {
            System.out.println(e.toString());
        }

        return obj;    
    }
}
