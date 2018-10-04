package 演算法作業3;

public class main {
	static int total = 0;
	static int[][] array = { 
			{ 0, 4, 1, 2, 0, 0, 0 }, // S 7*7矩陣表示圖的路徑
			{ 0, 0, 0, 0, 8, 0, 0 }, // A
			{ 0, 4, 0, 5, 7, 5, 0 }, // B
			{ 0, 0, 0, 0, 0, 3, 0 }, // C
			{ 0, 0, 0, 0, 0, 0, 6 }, // D
			{ 0, 0, 0, 0, 0, 0, 1 }, // E
			{ 0, 0, 0, 0, 0, 0, 0 } }; // T
	//static char[] node = { 'S', 'A', 'B', 'C', 'D', 'E', 'T' }; // 點的名稱

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		di(0, 6);
		System.out.print("最短路徑:"+total);

	}

	public static void di(int i, int j) { // 0,6

		int tt,bb;

		int n = 0;

		for (int a = 0; a < 6; a++) {
			if (array[0][a] != 0) {
				n++;
			}
		}
		int[] b_tem = new int[4];
		int[] cc = new int[n]; // 暫存 A到T B到T C到T

		cc[0] += array[0][1];
		cc[0] += array[1][4];
		cc[0] += array[4][6];

		
		cc[1] += array[0][2];
		b_tem[0] += array[2][1];
		b_tem[0] += array[1][4];
		b_tem[0] += array[4][6];
		
		
		b_tem[0] += array[2][3];
		b_tem[1] += array[3][5];
		b_tem[1] += array[5][6];

		b_tem[0] += array[2][4];
		b_tem[2] += array[4][6];

		b_tem[0] += array[2][5];
		b_tem[3] += array[5][6];

		
		cc[2] += array[0][3];
		cc[2] += array[3][5];
		cc[2] += array[5][6];
		
		
		bb = b_tem[0];
		
		for (int a = 1; a < 4; a++) {
			if (b_tem[a] < cc[1]) {
				cc[1] = b_tem[a];
			}
		}
		cc[1]+=bb;
		tt = cc[0];
		
		for (int a = 1; a < 3; a++) {
			if (cc[a] < tt) {
				tt = cc[a];
				
			}
		}
		total = tt;
	}
}