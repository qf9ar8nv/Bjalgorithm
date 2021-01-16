import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class FindingDecimal_1929{
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		int start = Integer.parseInt(st.nextToken());
		if(start == 1)
			start = 2;
		int end = Integer.parseInt(st.nextToken());
		
		int[] field = new int[end+1];
		
		for(int i=2; i<=end; i++) {
			if(field[i]==0) {
				if(i>=start) {
					System.out.println(i);					
				}
				int tmp = i;
				int cnt = 1;
				while((tmp*cnt)<=end) {
					field[tmp*cnt] = 1;
					cnt++;
				}
			}
		}
	}
}
