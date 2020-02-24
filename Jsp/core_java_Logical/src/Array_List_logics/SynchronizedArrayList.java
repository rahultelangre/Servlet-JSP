package Array_List_logics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SynchronizedArrayList {

	public static void main(String[] args) {
		ArrayList<String> al=new ArrayList<>();
		al.add("shiv");
		al.add("kashi");
		al.add("ganga");
		al.add("Bhole");
		System.out.println(al);
		
		//synchronized ArrayList
		List l=Collections.synchronizedList(al);
		
		System.out.println(l);
		System.out.println(" ");
		synchronized (l) {
			Iterator<String> itr=l.iterator();
			while(itr.hasNext()) {
				System.out.println(itr.next());
			}
		}
	}
}
