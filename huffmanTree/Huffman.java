package huffmanTree;

public class Huffman {
	private HuffmanNode mRoot;
	public Huffman(int[] a){
		HuffmanNode parent = null;
		MinHeap heap;
		heap=new MinHeap(a);
		for(int i=0; i<a.length-1; i++) {   
	        HuffmanNode left = heap.dumpFromMinimum();  // 最小节点是左孩子
	        HuffmanNode right = heap.dumpFromMinimum(); // 其次才是右孩子

	        // 新建parent节点，左右孩子分别是left/right；
	        // parent的大小是左右孩子之和
	        parent = new HuffmanNode(left.key+right.key, left, right, null);
	        left.parent = parent;
	        right.parent = parent;

	        // 将parent节点数据拷贝到"最小堆"中
	        heap.insert(parent);
	    }

	    mRoot = parent;

	    // 销毁最小堆
	    heap.destroy();
	}
}
