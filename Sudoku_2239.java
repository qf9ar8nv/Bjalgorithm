import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sudoku_2239{
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int[][] row, col, rec, field;
	static int check;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		row = new int[10][10];
		col = new int[10][10];
		rec = new int[10][10];
		field = new int[10][10];
		check = 0;
		
		init();
		search(1, 1);
		
		return;
	}
	static void search(int x, int y) {
		if(x==10) {
			x=1;
			y++;
		}
		if(y>9) {
			for(int i=1; i<10; i++) {
				for(int j=1; j<10; j++) {
					System.out.print(field[i][j]);
				}
				System.out.println("");
			}
			check = 1;
			return;
		}
		if(field[y][x]!=0) {
			search(x+1, y);
			return;
		}
		for(int i=1; i<10; i++) {
			if(row[y][i]==0 && col[x][i]==0 && rec[(((x-1)/3)+3*((y-1)/3))+1][i]==0) {
				field[y][x] = i;
				row[y][i] = 1;
				col[x][i] = 1;
				rec[(((x-1)/3)+3*((y-1)/3))+1][i] = 1;
				search(x+1, y);
				field[y][x] = 0;
				row[y][i] = 0;
				col[x][i] = 0;
				rec[(((x-1)/3)+3*((y-1)/3))+1][i] = 0;
			}
			if(check == 1) {
				break;
			}
		}
	}
	static void init() throws IOException {
		for(int i=1; i<10; i++) {
			String str = br.readLine();
			for(int j=1; j<10; j++) {
				field[i][j] = str.charAt(j-1)-'0';
				if(field[i][j]!=0) {
					row[i][field[i][j]] = 1;
					col[j][field[i][j]] = 1;
					rec[(((j-1)/3)+3*((i-1)/3))+1][field[i][j]] = 1;
				}
			}
		}
	}
}