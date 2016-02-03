import java.util.ArrayList;

public class SearchDictionary {
	public int ARRAY_SIZE=7;
	public SearchDictionary(){
		root=new Node(' ');
		result=true;
	}
	public void addWord(String word){
		countWords++;
		put(root,word);
	}
	public String delWord(String word) throws Exception{
		if(countWords==0)
			throw new Exception();
		del(root,word);
		--countWords;
		return word;
	}
	public boolean hasWord(String word){
		return search(root,word);
	}
	public Iterable<String> query(String query) throws Exception{
		ArrayList<String> result=new ArrayList<>();
		query(root,query,"",result);
		return result;
	}
	private void query(Node n,String query,String word,ArrayList<String> result) throws Exception{
		if (query.isEmpty())
			throw new Exception("Wrong querry syntax");
		char tempChar;
		tempChar=query.charAt(0);
		if(!query.equals("*")){
			boolean f=false;
			int t=0;
			while(n.arr[t]!=null){
				if(n.arr[t].value==tempChar){
					f=true;
					break;
				}
				t++;
			}
			if(f)
				query(n.arr[t],query.substring(1,query.length()),word+tempChar,result);
		}else{
			int t=0;
			while(t<n.arr.length&&n.arr[t]!=null){
				if(n.arr[t].value=='\n')
					result.add(word);
				else
					query(n.arr[t],query,word+n.arr[t].value,result);
				t++;
			}
		}
		return;
	}

	public int countWords(){
		return countWords;
	}
	private class Node{
		char value;
		Node[] arr=new Node[ARRAY_SIZE];
	public Node(char c){
			value=c;
		};
	}
	private Node root;
	private int countWords;
	private boolean result;
	private void put(Node s,String num){
		char tempChar;
		if(num.isEmpty())
			tempChar='\n';
		else
			tempChar=num.charAt(0);
		int t=0;
		while(s.arr[t]!=null){
			if(s.arr[t].value==tempChar)
				break;
			t++;
			if (t>=s.arr.length)
				resize(s);
		}
		if(s.arr[t]==null)
			s.arr[t]=new Node(tempChar);
		if(tempChar=='\n'){
			result=false;
			return;
		}
		put(s.arr[t],num.substring(1,num.length()));
		return;
	}
	private Node del(Node nod,String s){
		char tempChar;
		if(s.isEmpty())
			tempChar='\n';
		else
			tempChar=s.charAt(0);
		int t=0;
		while(nod.arr[t]!=null){
			if(nod.arr[t].value==tempChar)
				break;
			t++;
		}
		if(tempChar!='\n')
			nod.arr[t]=del(nod.arr[t],s.substring(1,s.length()));
		else
			nod.arr[t]=null;
		if(nod.arr[t]==null){
			if(nod.arr[t+1]!=null){
				while(nod.arr[t+1]!=null)
					nod.arr[t]=nod.arr[++t];
				nod.arr[t]=null;
				return nod;
			}
			if(t!=0&&nod.arr[t-1]!=null)
				return nod;
			return null;
		}
		return nod;
	}

	private boolean search(Node nod,String s){
		char tempChar;
		if(s.isEmpty())
			tempChar='\n';
		else
			tempChar=s.charAt(0);
		boolean result=false;
		boolean f=false;
		int t=0;
		while(nod.arr[t]!=null){
			if(nod.arr[t].value==tempChar){
				f=true;
				break;
			}
			t++;
		}
		if(f){
			if(tempChar=='\n')
				result=true;
			else
				result=search(nod.arr[t],s.substring(1,s.length()));
		}
		return result;
	}

	private void resize(Node n){
		//ARRAY_SIZE *= 2;
		//Node temp = new Node(n.value);
		Node[] temp=new Node[n.arr.length*2+1];
		for(int i=0;i<n.arr.length;i++)
			temp[i]=n.arr[i];
		n.arr=temp;
	}
}