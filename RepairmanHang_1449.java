import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.StringTokenizer;

public class RepairmanHang_1449{
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int[] part = new int[n];
		boolean[] part2 = new boolean[n];
		int count = 0;
		
		str = br.readLine();
		st = new StringTokenizer(str);
		for(int i=0; i<n; i++) {
			part[i] = Integer.parseInt(st.nextToken());
			part2[i] = false;
		}
		Arrays.sort(part);
		
		
		for(int i=0; i<n; i++) {
			if(part2[i] == false) {
				int last = part[i] + l;
				for(int j=0; j<n; j++) {
					if(part[j] < last) {
						part2[j] = true;
					}else {
						break;
					}
				}
				count ++;
			}
		}
		System.out.println(count);
		
	}
	
}