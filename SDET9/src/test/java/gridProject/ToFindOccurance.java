package gridProject;

import java.util.HashMap;

public class ToFindOccurance {

	public static void main(String[] args) {
		 String str="Mahabharat";
		  str=str.toLowerCase();
		  
		  char [] ch=str.toCharArray();

		   HashMap<Character,Integer> hm=new HashMap();
		   
		   for(char c:ch){
		      if(hm.containsKey(c)){
		          hm.put(c,hm.get(c)+1);
		         }
		      else{
		          hm.put(c,1);
		        }
		      }
		   System.out.print(hm);

	}

}
