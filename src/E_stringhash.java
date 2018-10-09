import java.util.HashMap;
import java.util.Scanner;

public class E_stringhash {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		while(input.hasNextLine()) {
			int output = 0;
			int M = input.nextInt();
			int P = input.nextInt();
			String str=input.nextLine();
			str = str.trim();
			//System.out.println(str.hashCode());
			String[] chararray = str.split("");
			int[] charascii = new int[chararray.length];
			for(int i=0;i<chararray.length;i++) {
				String s = chararray[i];
				int temp = (int)s.charAt(0);
				charascii[i] = temp;
			}
			int N = chararray.length;
			output = hash(N,M,P,charascii);
			System.out.println(M + " "+P+" "+str+" "+output);
		}
	}

	private static int hash(int n, int m, int p, int[] charascii) {
		int hash = 0;
		if(n == 0) {
			hash = 0;
			return hash;
		}
		else{
			hash = (p * hash(n-1,m,p,charascii) + charascii[n-1])% m;
		}
		return hash;
	}
}
