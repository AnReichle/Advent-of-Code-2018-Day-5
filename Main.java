import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws Exception {
		String str;
		String path = "src\\input.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			str = br.readLine();
		}
		String aux;
		System.out.println("answer for (a): " + collapse(aux = str).length());
		ArrayList<Integer> lengths = new ArrayList<Integer>();
		for(char c = 'a'; c<= 'z'; c++) {
			(aux = str).replaceAll("(?i)" + c, "");
			lengths.add(collapse(aux).length());
		}
		Stream<Integer> stream = lengths.stream();
		Optional<Integer> result = stream.min(Integer::compare);
		System.out.println("answer of (b): " + result.get());
	}
	static String collapse(String s) {
		StringBuilder str = new StringBuilder(s);
		for(int i = 0; i<(str.length()-1); i++) {
			if(Math.abs(str.charAt(i)-str.charAt(i+1)) == 32) {
				str.delete(i,i+2);
				if(i == 0) i++;
				i -= 2;
			}
		}
		return str.toString();
	}
}
