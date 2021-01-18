import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class NumberOfLand{
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			String str = br.readLine();
			st = new StringTokenizer(str);
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if(w==0 && h==0)
				break;
			int ans = init(w, h);
			System.out.println(ans);
		}
		
	}
	static int init(int w, int h) throws IOException {
		int[][] field = new int[h][w];
		for(int i=0; i<h; i++) {
			String str = br.readLine();
			st = new StringTokenizer(str);
			for(int j=0; j<w; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		return cal(field, w, h);
	}
	static int cal(int[][] field, int w, int h) {
		int[] ch_x = {0, 1, 1, 1, 0, -1, -1, -1};
		int[] ch_y = {-1, -1, 0, 1, 1, 1, 0, -1};
		int answer = 0;
		int[][] check = new int[h][w];
		LinkedList<Info> que = new LinkedList<>();
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(field[i][j] == 1 && check[i][j] == 0) {
					que.add(new Info(j, i));
					check[i][j] = 1;
					answer++;
					while(!que.isEmpty()) {
						Info info = que.poll();
						int x = info.x;
						int y = info.y;
						for(int a=0; a<8; a++) {
							if(x+ch_x[a]>=0 && x+ch_x[a]<w && y+ch_y[a]>=0 && y+ch_y[a]<h && 
									check[y+ch_y[a]][x+ch_x[a]]==0 && field[y+ch_y[a]][x+ch_x[a]]==1) {
								que.add(new Info(x+ch_x[a], y+ch_y[a]));
								check[y+ch_y[a]][x+ch_x[a]] = 1;
							}
						}
					}
				}
			}
		}
		return answer;
	}
}
class Info{
	int x, y;
	Info(int x, int y){
		this.x = x;
		this.y = y;
	}
}