import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackSequence_1874{
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Stack<Integer> stack = new Stack<>();
		ArrayList<String> answer = new ArrayList<>();   
		
		int n = Integer.parseInt(br.readLine());
		int cnt = 1; 
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num >= cnt) {
				while(num > cnt) {
					stack.push(cnt);
					answer.add("+");
					cnt ++;
				}
				if(num == cnt) {
					answer.add("+");
					answer.add("-");
					cnt ++;
				}	
			}else {
				int compare = stack.pop();
				if(compare == num) {
					answer.add("-");
				}else {
					answer.clear();
					answer.add("NO");
					break;
				}
			}
		}
		for(int i=0; i<answer.size(); i++) {
			System.out.println(answer.get(i));
		}
		
		
	}
}