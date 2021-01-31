import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TravelingSalesman_2098{
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int[][] field;;
	static int n;
	static int maxvalue;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		maxvalue = 1000000000;
		init();
		System.out.println(search());
	}
	static int search() {
		int ans = maxvalue;
		int a = 1;
		int max = a<<n;
		int[][] dp = new int[n+1][max];
		for(int i=2; i<=n; i++) {
			if(field[i][1]<0) {
				continue;
			}
			ans = Math.min(ans, Dp(i, max-1, dp)+field[i][1]);
		}
		return ans;
	}
	static int Dp(int num, int visit, int[][] dp) {
		int end = visit;
		int cnt = 0;
		for(int i=0; i<n; i++) {
			if((end & 1)!=0)
				cnt++;
			end = end>>1;
		}
		if(cnt==2) {
			visit -= 1;
			int a = 1;
			for(int i=1; i<n; i++) {
				a = a<<1;
				if((visit & a)!=0) {
					if(field[1][i+1]>0) {
						dp[num][visit+1] = field[1][i+1];						
					}else {
						dp[num][visit+1] = maxvalue;
					}
					return dp[num][visit+1];
				}
			}
		}
		if(dp[num][visit]!=0) {
			return dp[num][visit];
		}
		int min = maxvalue;
		for(int i=1; i<n; i++) {
			int a = 1;
			int check = a<<i;
			int change = ~(a<<(num-1));
			if((check & visit)!=0 && field[i+1][num]>0 && (i+1)!=num) {
				int tmp = Dp(i+1, (change&visit), dp)+field[i+1][num];
				min = Math.min(tmp, min);
			}
		}
		dp[num][visit] = min;
		return min;
	}
	static void init() throws IOException {
		field = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			String str = br.readLine();
			st = new StringTokenizer(str);
			for(int j=1; j<=n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num==0 && (i!=j)) {
					field[i][j] = -1;
				}else {
					field[i][j] = num;
				}
			}
		}
	}
}