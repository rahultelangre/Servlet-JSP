package Array_List_logics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ArrayListTOUniqe {

	public static void main(String[] args) {
		ArrayList<Object> al=new ArrayList();
		al.add(1);
		al.add(1);
		al.add(2);
		al.add(2);
		al.add(3);
		al.add(3);
		al.add(4);
		al.add(5);
		al.add("hari");
		al.add("hari");
		al.add("hari");al.add("hari");
		System.out.println(al);
		
		Set<Object> st=new HashSet(al);
		
		al.clear();
		al.addAll(st);
		System.out.println(al);
		System.out.println(st);
	}

}
