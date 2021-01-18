import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class LengthOfRGB_1149{
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[][] field = new int[n][3];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			st = new StringTokenizer(str);
			field[i][0] = Integer.parseInt(st.nextToken());
			field[i][1] = Integer.parseInt(st.nextToken());
			field[i][2] = Integer.parseInt(st.nextToken());
		}
		int[][] min = new int[n][3];
		min[0][0] = field[0][0];
		min[0][1] = field[0][1];
		min[0][2] = field[0][2];
		for(int i=1; i<n; i++) {
			min[i][0] = Math.min(min[i-1][1], min[i-1][2])+field[i][0];
			min[i][1] = Math.min(min[i-1][0], min[i-1][2])+field[i][1];
			min[i][2] = Math.min(min[i-1][0], min[i-1][1])+field[i][2];
		}
		int ans = Math.min(min[n-1][0], min[n-1][1]);
		ans = Math.min(ans, min[n-1][2]);
		System.out.println(ans);
		
	}
}