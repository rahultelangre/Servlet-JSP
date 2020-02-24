package Array_List_logics;

import java.util.HashSet;
import java.util.Set;

public class DuplicateWorldsCount {
	public static void main(String[] args) {
		
	String[] s= {"a","b","a","a","b","c","d","c","d","e","f","j"};
	Set<String> uniques=new HashSet();
	  Set<String> dups=new HashSet();
	    
		    for(String a:s)
	    	   if(!uniques.add(a)) 
	    		dups.add(a);
	    //descriptive set
	   System.out.println(dups);
	   System.out.println(uniques);
	   System.out.println(dups);
	   
	   System.out.println("All worlds "+s.toString());
	   System.out.println("uniques words "+uniques);
	   System.out.println("Duplicate Words "+dups);
	}

}
