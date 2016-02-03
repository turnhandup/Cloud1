import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Tester {
	public static void main(String[] args) throws Exception {
		SearchDictionary sd = new SearchDictionary();
		Scanner s = new Scanner(new File("1.txt"));
		HashSet<String> hs = new HashSet<>();
		while (s.hasNext()) {
			String ss = s.next();
			hs.add(ss);
			sd.addWord(ss);
		}
		Iterable<String> search = sd.query("a*");
		ArrayList<String> a =(ArrayList<String>) search;
	    for(int i=0;i<a.size();i++)
		System.out.println(a.get(i));
	    System.out.println("An amount of words which starts with your input : "+a.size());
	    System.out.println("An amount of words in our dictionary : "+hs.size());
	}

}