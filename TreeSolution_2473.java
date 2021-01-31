import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TreeSolution_2473{
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
		
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<n-1-i; j++) {
				if(field[j]>field[j+1]) {
					int tmp = field[j];
					field[j] = field[j+1];
					field[j+1] = tmp;
				}
			}
		}
		long min = (long)Math.pow(10, 10)*3;
		int ans1 = 0;
		int ans2 = 0;
		int ans3 = 0;
		for(int a=0; a<n-2; a++) {
			for(int b=a+1; b<n-1; b++) {
				int start = b+1;
				int end = n;
				while(start!=end) {
					int mid = (start+end)/2;
					long compare = (long)field[a]+field[b]+field[mid];
					if(min>Math.abs(compare)) {
						min = Math.abs(compare);
						ans1 = a;
						ans2 = b;
						ans3 = mid;
					}
					if(compare>0) {
						end = mid;
					}else {
						start = mid+1;
					}
				}
			}
		}
		System.out.println(field[ans1]+" "+field[ans2]+" "+field[ans3]);
		
	}
}