package gridProject;

import java.util.HashMap;
import java.util.Set;

public class Demo {

	public static void main(String[] args) {
		String str="welcome to css";
	     char []ch=	str.toCharArray();
	  HashMap<Character,Integer>hs=   new HashMap();
	  
	  for(char c:ch){
	  if(hs.containsKey(c)){
		  hs.put(c,hs.get(c)+1);
	  }
	  else{
		  hs.put(c,1);
	  }

	}
	
	Set<Character> ks = hs.keySet();
	for(char c:ks){
		if(hs.get(c)>1){
			System.out.print(c);
		}
	}
	}

}
