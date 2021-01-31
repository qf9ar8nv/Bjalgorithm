import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Work_2056{
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int[] pnt;
	static ArrayList<Integer>[] rela;
	static int[] time;
	static int n;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		pnt = new int[n+1];
		rela = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			rela[i] = new ArrayList<>();
		}
		time = new int[n+1];
		init();
		System.out.println(cal());
	}
	static int cal() {
		int ans = 0;
		ArrayList<Info> list = new ArrayList<>();
		for(int i=1; i<=n; i++) {
			if(pnt[i] == 0) {
				list.add(new Info(i, time[i]));
			}
		}
		while(!list.isEmpty()) {
			int min = 0;
			int mintime = 10000;
			int size = list.size();
			for(int i=0; i<size; i++) {
				int comN = list.get(i).getNum();
				int comT = list.get(i).getTime();
				if(mintime>comT) {
					min = comN;
					mintime = comT;
				}
			}
			for(int i=0; i<size; i++) {
				Info info = list.get(0);
				list.remove(0);
				if(info.c_num == min) {
					ans += info.c_time;
					for(int j=0; j<rela[info.c_num].size(); j++) {
						int check = rela[info.c_num].get(j);
						pnt[check]--;
						if(pnt[check]==0) {
							list.add(new Info(check, time[check]));
						}
					}
				}else {
					info.c_time -= mintime;
					list.add(info);
				}
			}	
		}
		return ans;
	}
	static void init() throws IOException {
		for(int i=1; i<=n; i++) {
			String str = br.readLine();
			st = new StringTokenizer(str);
			time[i] = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			for(int j=0; j<num; j++) {
				int pre = Integer.parseInt(st.nextToken());
				rela[pre].add(i);
				pnt[i]++;
			}
		}
	}
}
class Info{
	int c_num, c_time;
	Info(int c_num, int c_time){
		this.c_num = c_num;
		this.c_time = c_time;
	}
	int getTime() {
		return c_time;
	}
	int getNum() {
		return c_num;
	}
}