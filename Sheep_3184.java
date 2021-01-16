import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Sheep_3184{
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int s_cnt, w_cnt;
	static char[][] field;
	static int[][] visit;
	static int a, b;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		field = new char[a][b];
		for(int i=0; i<a; i++) {
			String info = br.readLine();
			for(int j=0; j<b; j++) {
				field[i][j] = info.charAt(j);
			}
		}
		visit = new int[a][b];
		s_cnt = 0;
		w_cnt = 0;
		for(int i=0; i<a; i++) {
			for(int j=0; j<b; j++) {
				if(field[i][j]!='#' && visit[i][j]==0) {
					sch(i, j);
				}
			}
		}
		System.out.println(s_cnt+" "+w_cnt);
		
	}
	static void sch(int y, int x) {
		int[] ch_x = {1, -1, 0, 0};
		int[] ch_y = {0, 0, 1, -1};
		int cnt_o = 0;
		int cnt_v = 0;
		LinkedList<Info> que = new LinkedList<>();
		que.add(new Info(x, y));
		while(!que.isEmpty()) {
			Info info = que.poll();
			x = info.x;
			y = info.y;
			visit[info.y][info.x] = 1; 
			if(field[info.y][info.x] == 'o') {
				cnt_o++;
			}else if(field[info.y][info.x] == 'v') {
				cnt_v++;
			}
			for(int i=0; i<4; i++) {
				if(x+ch_x[i]>=0 && y+ch_y[i]>=0 && x+ch_x[i]<b && y+ch_y[i]<a && 
						field[y+ch_y[i]][x+ch_x[i]]!='#' && visit[y+ch_y[i]][x+ch_x[i]]==0) {
					que.add(new Info(x+ch_x[i], y+ch_y[i]));
					visit[y+ch_y[i]][x+ch_x[i]] = 1;
				}
			}
		}
		if(cnt_o > cnt_v) {
			s_cnt += cnt_o;
		}else {
			w_cnt += cnt_v;
		}
	}
}
class Info{
	int x, y;
	Info(int x, int y){
		this.x = x;
		this.y = y;
	}
}
