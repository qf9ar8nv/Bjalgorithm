import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SymmetricDifferenceSet_1269{
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		
		int a, b;
		int count = 0;
		int k;
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		ArrayList<Integer> a_circle = new ArrayList<>();
		ArrayList<Integer> b_circle = new ArrayList<>();
		
		String str1 = br.readLine();
		st = new StringTokenizer(str1);
		for(int i=0; st.hasMoreTokens(); i++) {
			a_circle.add(Integer.parseInt(st.nextToken()));
		}
		
		String str2 = br.readLine();
		st = new StringTokenizer(str2);
		for(int i=0; i<b; i++) {
			b_circle.add(Integer.parseInt(st.nextToken()));
		}
		
		int[] middle = new int[100000000];
		for(int i=0; i<a_circle.size(); i++) {
			k = a_circle.get(i);
			middle[k-1] = k;
		}
		for(int i=0; i<b_circle.size(); i++) {
			k = b_circle.get(i);
			if(middle[k-1]!=0)
				count += 1;
		}
		System.out.println(a+b-(2*count));
	}
	
}