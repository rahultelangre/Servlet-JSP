package com.nt.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Streams01 {
	public static void main(String[] args) {
		List<Integer> l=new ArrayList();
		List<String> ls=new ArrayList();
	    l=Arrays.asList(3,10,20,5,15,25);
	    ls=Arrays.asList("ramach","pawankalyan","ravitejaa","chiranjeevi");
	    System.out.println(l);
	    List<Integer> l1=l.stream().filter(i->i%2==0).collect(Collectors.toList());
	    List<Integer> l2=l.stream().map(i->i*2).collect(Collectors.toList());
	    List<String>   ls1=ls.stream().filter(s->s.length()>=7).collect(Collectors.toList());
	    List<String>   ls2=ls.stream().map(s->s.toUpperCase()).collect(Collectors.toList());
	    long   count=ls.stream().filter(s->s.length()>=7).count();
	    

	    //sorted the list
	    List<Integer> l3=l.stream().sorted().collect(Collectors.toList());
	    List<Integer> l4=l.stream().sorted((i1,i2)->i2.compareTo(i1)).collect(Collectors.toList());
	    Integer min=l.stream().min((i1,i2)->i1.compareTo(i2)).get();
	    Integer max=l.stream().max((i1,i2)->i1.compareTo(i2)).get();
	    System.out.println(l1);
	    System.out.println(l2);
	    System.out.println("------------------");
	    System.out.println(ls1);
	    System.out.println(count);
	    System.out.println(l3);
	    System.out.println("------------------");
	    System.out.println(l4);
	    System.out.println("-------------------");
	    System.out.println(ls2);
	    System.out.println(min);
	    System.out.println(max);
	    
	    //by forEach method
	    ls.stream().forEach(s->System.out.println(s));
	    System.out.println("=============refrenced method");
	    ls.stream().forEach(System.out::println);
	    
	    
	    System.out.println("---to Array mathod-----");
	    
	}
	

}
