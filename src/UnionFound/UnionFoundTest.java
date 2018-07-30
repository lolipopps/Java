package UnionFound;

public class UnionFoundTest {
	public static void main(String[] args) {
		UnionFound unionFound = new UnionFound(6);
		unionFound.quickFindUnion(1, 2);
		unionFound.quickFindUnion(1, 3);
		unionFound.quickFindUnion(2, 5);
		System.out.println(unionFound.quickFindConnected(1, 5));
		System.out.println(unionFound.quickFindFind(1));
		unionFound.QuickUnion(10);
		unionFound.quickUnionUnion(2, 5);
		unionFound.quickUnionUnion(1, 5);
		unionFound.quickUnionUnion(3, 2);
		unionFound.quickUnionUnion(7, 4);
		unionFound.quickUnionUnion(9, 4);
		System.out.println(unionFound.quickUnionFind(1));
		System.out.println(unionFound.quickUnionFind(8));
		System.out.println(unionFound.quickUnionisConnected(2, 8));
	}
}
