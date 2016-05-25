package huffmanTree;

public class Huffman {
	private HuffmanNode mRoot;
	public Huffman(int[] a){
		HuffmanNode parent = null;
		MinHeap heap;
		heap=new MinHeap(a);
		for(int i=0; i<a.length-1; i++) {   
	        HuffmanNode left = heap.dumpFromMinimum();  // ��С�ڵ�������
	        HuffmanNode right = heap.dumpFromMinimum(); // ��β����Һ���

	        // �½�parent�ڵ㣬���Һ��ӷֱ���left/right��
	        // parent�Ĵ�С�����Һ���֮��
	        parent = new HuffmanNode(left.key+right.key, left, right, null);
	        left.parent = parent;
	        right.parent = parent;

	        // ��parent�ڵ����ݿ�����"��С��"��
	        heap.insert(parent);
	    }

	    mRoot = parent;

	    // ������С��
	    heap.destroy();
	}
}
