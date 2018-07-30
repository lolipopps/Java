package UnionFound;

/**
 * 
 * 并查集,用来解决连通问题的，两个节点之间是否是连通的。 此处的节点是抽象的概念：比如用户和用户之间,港口和港口之间。
 * 用来看他们是否是连通的。典型的就是看你社交中任何人之间的关系是否认识. 并查集问题和路径问题的区别:并查集比路径能做的操作少，它只能回答两个节点是否连通
 * 路径还可以找到类似最短的连通点等等.但正因为并查集专注于连接问题,所以判断是否连接 修改连接状态时比较高效. Union-Find 如其名字我们主要提供
 * union(p,q); //合并p、q两点使他们两个连通. find(p); //找到节点q的连通性,(处在什么状态合谁联通)
 * 通过find的api,我们可以找到两个节点是否会连通的,即apiisConnected(p,q);
 *
 */
public class UnionFound {
	// 此处用一个id数组来表示每个节点的连通性。
	// 当节点连接到一起的时候那么它们有相同的id号
	private  int[] mIds;
	private int[] mParents;
	// 表示描述的节点的规模,总共有多少个
	private  int mCount;
	// 构造中实例化用来保存连通状态的数组,并初始化连通状态
	// 传入的并查集要表示多少个元素
	public UnionFound(int capacity) {
		mCount = capacity;
		mIds = new int[mCount];
		// 初始为每个点都不连通,此处i不同就表示不连通,想要连通是就把i设置为同一个即可
		// 同时也隐含着mCount各节点元素,每个节点元素的对应索引0...n，连通性,此处默认赋值都不连通
		for (int i = 0; i < mCount; i++) {
			mIds[i] = i;// 注意id代表的含义不要和索引混了
		}
	}
	
	public void QuickUnion(int capacity){
        mCount = capacity;
        mParents = new int[mCount];
        //初始化时每个索引对应的mParents都为自己的索引+5,表示谁也不连接
        for (int i = 0; i < mCount; i++) {
            mParents[i] = i;//初始状态为每个节点自己的索引
        }
    }

	// 寻找p索引对应的连通性的状态,可以看到查找某个元素的连通状态码
	// 是非常的快的，直接在数组中索引即可时间复杂度O(1)
	int quickFindFind(int p) {
		if (p < 0 || p >= mCount) {
			// ...做一些异常处理
			System.out.println("该点不存在");
		}
		// 直接返回当前索引所对应的元素的连通性,此处设计的是每个连通性默认是索引号.
		return mIds[p];
	}

	// 此处设计是用的数组存储元素,传入的是数组内元素的索引,注意这个数组不是指mIds.
	public boolean quickFindConnected(int p, int q) {
		// 返回p和q在ids数组中对应的连通状态码是否一致。
		return quickFindFind(p) == quickFindFind(q);
	}
	// 联合的整体思路:
	// 要么把p索引在mIds中的状态变成q的， 要么把q索引在mIds中的状态变成p的 mIds中的状态代表了连通性,id号相等就代表连通。
	// 此时就遍历mIds数组,然后把p/q索引对应的id进行相关赋值
	public void quickFindUnion(int p, int q) {
		// 先拿到p和q的id
		int pId = quickFindFind(p);
		int qId = quickFindFind(q);
		// 如果已经相等那么直接返回
		if (pId == qId) {
			return;
		}
		// 注意如下为什么不直接mIds[p] = qId,不要被初始状态迷惑 此处的设计思想quick-find查找快，但想要改变连通性的时候
		// 需要把所有的节点中的和pId相等的状态码，全部变成qId的状态码只有这样才能算是完全的连通了，你不能只改一个啊！！
		// 这种设计模式下的union的时间复杂度是O(n).
		for (int i = 0; i < mCount; i++) {
			if (mIds[i] == pId) {
				mIds[i] = qId;
			}
		}
	}
	
	
	
	
	// quick-union
	
	 //查找索引p在parent中对应的连通状态码,当它是在一个树的结构中时，
    //需要找到它一直往上直到根节点的对应码,因为我们联合的时候都是按照
    //根节点进行联合的
    public int quickUnionFind(int p){
        if( p<0 || p>=mCount){
            //...做一些异常处理
        }
        //最根部的肯定是等于当前索引的.
        while(p!= mParents[p]){
            //依次往上，把指向的父索引值赋值给当前的p循环查找.
            p = mParents[p];
        }
        return p;
    }
    //是否连通
    public boolean quickUnionisConnected(int p,int q){
        return quickUnionFind(p)== quickUnionFind(q);
    }
    //联合p所以和q索引对应的状态.此处的设计:
    //     1)、把p所在的树的根节点指向q所在的树的根节点
    //     2)、把q所在的树的根节点指向p所在的树的根节点
    //但从此角度考虑的话两种实现其实是一样的
    public void quickUnionUnion(int p,int q){
        //还是先找到pId和qId。
        int pRoot= quickUnionFind(p);
        int qRoot = quickUnionFind(q);
        //如果相等的时候,证明已经联合
        if(pRoot == qRoot){
            return;
        }
        //第一版我们什么也不考虑直接把p所在的树的根节点pRoot指向q所在的树的根。所以注意不是mParents[p] = qRoot,应该是p索引找到的根
        //这个根肯定这会也是指向自己的元素的索引,直接mParents[pRoot]
      //把mParents中pRoot索引对应的值变成qRoot，也就是指向qRoot.    
        mParents[pRoot] = qRoot;
    }
	
	
	
	
	
	
	
	
}
