package gridProject;

import java.util.HashMap;
import java.util.Set;

public class PrintDuplicateCharacter {

	public static void main(String[] args) {
		String str="aabbbcccdddd";
		HashMap <Character,Integer>hm = new HashMap();
		char [] ch=str.toCharArray();
		
		for(char c:ch){
			if(hm.containsKey(c)){
				hm.put(c,hm.get(c)+1);
			}
			else{
				hm.put(c,1);
			}
		}
System.out.println(hm);
   Set<Character> ks = hm.keySet();
   for(char c:ks){
	   if(hm.get(c)>1){
		   System.out.print(c);
	   }
   }
	}

}
