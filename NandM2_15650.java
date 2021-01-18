import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class NandM2_15650{
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int[] pnt;
	static int n, m, cnt;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		pnt = new int[n+1];
		sch(1);
		
	}
	static void sch(int number) {
		if(number>n)
			return;
		pnt[number] = 1;
		cnt++;
		if(cnt==m) {
			for(int i=1; i<=n; i++) {
				if(pnt[i]==1)
					System.out.print(i+" ");
			}
			System.out.println("");
		}
		sch(number+1);
		pnt[number] = 0;
		cnt--;
		sch(number+1);
	}
}