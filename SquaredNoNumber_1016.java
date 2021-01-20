import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SquaredNoNumber_1016{
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int[] pn;
	static long min, max;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		
		min = Long.parseLong(st.nextToken());
		max = Long.parseLong(st.nextToken());
		int[] field = new int[1000001];
		pn = new int[1000001];
		schpn(field);
		int[] noPr = new int[(int) (max-min+1)];
		int ans = cal(noPr);
		System.out.println(ans);
	}
	static int cal(int[] noPr) {
		int cnt = 0;
		for(int i=2; i<=Math.sqrt(max); i++) {
			if(pn[i] == 1) {
				long tmp = (long)i*i;
				long num = min/tmp;
				if(num*tmp<min) {
					num++;
				}

				while(num*tmp<=max) {
					noPr[(int) (num*tmp-min)] = 1;
					num++;
				}
			}
		}
		for(int i=0; i<noPr.length; i++) {
			if(noPr[i]==0)
				cnt++;
		}
		return cnt;
	}
	static void schpn(int[] field) {
		for(int i=2; i<=1000000; i++) {
			if(field[i]==0) {
				pn[i] = 1;
				int cnt = 1;
				while(i*cnt<=1000000) {
					field[i*cnt] = 1;
					cnt++;
				}
			}
		}
	}
}