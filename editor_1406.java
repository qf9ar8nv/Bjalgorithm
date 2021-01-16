import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class editor_1406{
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static StringBuilder sd;
	static int pnt;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		String st_input = br.readLine();
		for(int i=0; i<st_input.length(); i++) {
			left.add(st_input.charAt(i));
		}
		int cnt = Integer.parseInt(br.readLine());
		
		for(int i=0; i<cnt; i++) {
			String str = br.readLine();
			st = new StringTokenizer(str);
			char cmd = str.charAt(0);
			if(cmd=='L') {
				if(!left.isEmpty()) {
					char tmp = left.pop();
					right.add(tmp);
				}
			}else if(cmd=='D') {
				if(!right.isEmpty()) {
					char tmp = right.pop();
					left.add(tmp);
				}
			}else if(cmd=='B') {
				if(!left.isEmpty()) {
					left.pop();
				}
			}else {
				char put = str.charAt(2);
				left.add(put);
			}
		}
		while(!left.isEmpty()) {
			char tmp = left.pop();
			right.add(tmp);
		}
		while(!right.isEmpty()){
			char tmp = right.pop();
			bw.write(tmp);
		}
		bw.flush();
		
		
	}
}
