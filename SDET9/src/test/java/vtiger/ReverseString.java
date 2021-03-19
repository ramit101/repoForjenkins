package vtiger;

import org.testng.annotations.Test;
import java.util.*;
public class ReverseString {
@Test
public void tc_001() {
	String str="i am a qa ";
	char[] ch = str.toCharArray();
	HashMap<Character,Integer> hm = new HashMap();
	for(char c:ch) {
		if(hm.containsKey(c)) {
			hm.put(c,hm.get(c)+1);
		}
		else {
			hm.put(c,1);
		}
		
	}
	
}
}
