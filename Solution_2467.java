import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_2467{
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int[] field;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		field = new int[n];
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		for(int i=0; i<n; i++) {
			field[i] = Integer.parseInt(st.nextToken());
		}
		int min = 2_000_000_000;
		int start = 0;
		int end = n-1;
		int ans1 = 0;
		int ans2 = n-1;
		while(start!=end) {
			int num = field[end] + field[start];
			if(min>Math.abs(num)) {
				min = Math.min(min, Math.abs(num));
				ans1 = start;
				ans2 = end;
			}
			if(num>0) {
				end--;
			}else {
				start++;
			}
		}
		System.out.println(field[ans1]+" "+field[ans2]);
		
	}
}