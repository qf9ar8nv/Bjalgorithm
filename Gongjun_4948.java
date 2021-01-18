import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gongjun_4948{
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] pn = new int[246913];
		int[] check = new int[246913];
		for(int i=2; i<=246912; i++) {
			if(check[i]==0) {
				pn[i] = 1;
				int tmp = 1;
				while((i*tmp)<=246912) {
					check[i*tmp] = 1;
					tmp++;
				}
			}
		}
		while(true) {
			int num = Integer.parseInt(br.readLine());
			if(num==0)
				break;
			int ans = 0;
			for(int i=(num+1); i<=(2*num); i++) {
				if(pn[i] == 1)
					ans++;
			}
			System.out.println(ans);
		}
		
	}
}