package Structs;

public class ADT {
	public int[] S;
	public int size;

	public void MakeSet(int size) {
		S = new int[size];
		for (int i = size - 1; i >= 0; i--) {
			S[i] = i;
		}
	}

	int Find(int x) {
		if (x == S[x])
			return x;
		return Find(S[x]);
	}

	public void Union(int x, int y) {
		if (Find(x) == Find(y)) {
			return;
		}
		S[x] = S[y];
	}

	public void QuickMakeSet(int size) {
		S = new int[size];
		for (int i = size - 1; i >= 0; i--) {
			S[i] = -1;
		}
	}

	public int QuickFind(int x) {
		if (S[x] < 0) {
			return x;
		} else {
			return QuickFind(S[x]);
		}
	}

	public void QuickUnion(int x, int y) {
		int tempx = QuickFind(x);
		int tempy = QuickFind(y);
		if (tempx == tempy) {
			return;
		}
		if (S[tempx] <= S[tempy]) { // S 存的是父节点 x 节点要多 因此
			S[tempx] += S[tempy];
			S[tempy] = y;
			S[y] = x;

		} else {
			S[tempy] += S[tempx];
			S[tempx] = x;
			S[x] = y;

		}
	}

	public void showS() {
		for (int i = 0; i < S.length; i++) {
			System.out.print(i + " 父节点是:" + S[i] + "  ");
		}
	}

}
