package huffmanTree;


/**
 * ��С��(Huffman.java�ĸ�����)
 *
 * @author skywang
 * @date 2014/03/27
 */

import java.util.ArrayList;
import java.util.List;

public class MinHeap {

	private List<HuffmanNode> mHeap;		// ��Ŷѵ�����

	/* 
	 * ������С��
	 *
	 * ����˵����
	 *     a -- �������ڵ�����
	 */
	protected MinHeap(int a[]) {
		mHeap = new ArrayList<HuffmanNode>();
		// ��ʼ������
		for(int i=0; i<a.length; i++) {
		    HuffmanNode node = new HuffmanNode(a[i], null, null, null);
			mHeap.add(node);
		}

		// ��(size/2-1) --> 0��α���������֮�󣬵õ�������ʵ������һ����С�ѡ�
		for (int i = a.length / 2 - 1; i >= 0; i--)
			filterdown(i, a.length-1);
	}

	/* 
	 * ��С�ѵ����µ����㷨
	 *
	 * ע������ʵ�ֵĶ��У���N���ڵ�����ӵ�����ֵ��(2N+1)���Һ��ӵ�������(2N+2)��
	 *
	 * ����˵����
	 *     start -- ���µ��ڵ����ʼλ��(һ��Ϊ0����ʾ�ӵ�1����ʼ)
	 *     end   -- ������Χ(һ��Ϊ���������һ��Ԫ�ص�����)
	 */
	protected void filterdown(int start, int end) {
		int c = start; 	 	// ��ǰ(current)�ڵ��λ��
		int l = 2*c + 1; 	// ��(left)���ӵ�λ��
		HuffmanNode tmp = mHeap.get(c);	// ��ǰ(current)�ڵ�

		while(l <= end) {
			// "l"�����ӣ�"l+1"���Һ���
			if(l < end && (mHeap.get(l).compareTo(mHeap.get(l+1))>0))
				l++;		// ������������ѡ���С�ߣ���mHeap[l+1]

			int cmp = tmp.compareTo(mHeap.get(l));
			if(cmp <= 0)
				break;		//��������
			else {
				mHeap.set(c, mHeap.get(l));
				c = l;
				l = 2*l + 1;   
			}       
		}   
		mHeap.set(c, tmp);
	}
	
	/*
	 * ��С�ѵ����ϵ����㷨(��start��ʼ����ֱ��0��������)
	 *
	 * ע������ʵ�ֵĶ��У���N���ڵ�����ӵ�����ֵ��(2N+1)���Һ��ӵ�������(2N+2)��
	 *
	 * ����˵����
	 *     start -- ���ϵ��ڵ����ʼλ��(һ��Ϊ���������һ��Ԫ�ص�����)
	 */
	protected void filterup(int start) {
		int c = start;			// ��ǰ�ڵ�(current)��λ��
		int p = (c-1)/2;		// ��(parent)����λ�� 
		HuffmanNode tmp = mHeap.get(c);	// ��ǰ(current)�ڵ�

		while(c > 0) {
			int cmp = mHeap.get(p).compareTo(tmp);
			if(cmp <= 0)
				break;
			else {
				mHeap.set(c, mHeap.get(p));
				c = p;
				p = (p-1)/2;   
			}       
		}
		mHeap.set(c, tmp);
	} 
 
	/* 
	 * ��node���뵽�������
	 */
	protected void insert(HuffmanNode node) {
		int size = mHeap.size();

		mHeap.add(node);	// ��"����"���ڱ�β
		filterup(size);		// ���ϵ�����
	}

	/*
	 * ��������HuffmanNode�ڵ��ȫ������
	 */
	private void swapNode(int i, int j) {
		HuffmanNode tmp = mHeap.get(i);
		mHeap.set(i, mHeap.get(j));
		mHeap.set(j, tmp);
	}

	/* 
	 * �½�һ���ڵ㣬������С������С�ڵ�����ݸ��Ƹ��ýڵ㡣
	 * Ȼ�����С�ڵ�֮����������¹������С�ѡ�
	 *
	 * ����ֵ��
	 *     ʧ�ܷ���null��
	 */
	protected HuffmanNode dumpFromMinimum() {
		int size = mHeap.size();

		// ���"��"�ѿգ��򷵻�
		if(size == 0)
			return null;

		// ��"��С�ڵ�"��¡һ�ݣ�����¡�õ��Ķ���ֵ��node
		HuffmanNode node = (HuffmanNode)mHeap.get(0).clone();

		// ����"��С�ڵ�"��"���һ���ڵ�"
		mHeap.set(0, mHeap.get(size-1));
		// ɾ������Ԫ��
		mHeap.remove(size-1);

		if (mHeap.size() > 1)
			filterdown(0, mHeap.size()-1);

		return node;
	}

	// ������С��
	protected void destroy() {
		mHeap.clear();
		mHeap = null;
	}
}
