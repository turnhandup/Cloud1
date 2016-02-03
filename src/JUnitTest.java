import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class JUnitTest {
	@Test 
	public void JunitTestsAssertDefault(){
		JUnitTest tester=new JUnitTest();
		assertNotNull(tester);
	}
	@Test
	public void AddWordDefault(){
		SearchDictionary sd = new SearchDictionary();
		sd.addWord("abc");
	}
	@Test
	public void delWordDefault() throws Exception{
		SearchDictionary sd = new SearchDictionary();
		sd.addWord("Hello");
		sd.delWord("Hello");
	}
	@Test
	public void sizeWord(){
		ArrayList<String> a =new ArrayList<String>();
		a.size();
	}
	@Test
	public void queryDefault() throws Exception{
		SearchDictionary sd = new SearchDictionary();
		Iterable<String> search = sd.query("ab*");
		
	}
	@Test
	public void Searh(){
		SearchDictionary sd=new SearchDictionary();
		sd.countWords();
	}
	@Test
	public  void Search(){
		ArrayList<String> a =new ArrayList<String>();
		a.add("hey");
		a.isEmpty();
	}
	@Test
	public void TesterTest() throws Exception{
		Tester test=new Tester();
		test.main(null);
	}
}
