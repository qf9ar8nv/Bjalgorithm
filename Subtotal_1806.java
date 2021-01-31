import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Subtotal_1806{
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int[] field = new int[n];
		
		str = br.readLine();
		st = new StringTokenizer(str);
		for(int i=0; i<n; i++) {
			field[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = 0;
		int sum = 0;
		int ans = 100001;
		while(end!=n) {
			sum += field[end];
			if(sum>=s) {
				while(sum>=s) {
					sum -= field[start];
					start +=1;
				}
				ans = Math.min(ans, end-start+2);
			}
			end++;
		}
		if(ans==100001) {
			ans = 0;
		}
		System.out.println(ans);
	}
}