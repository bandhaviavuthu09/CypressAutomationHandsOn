import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test1 {

	//COunt the number of names starting with alphabet A in list
	@Test
	public void regular()
	{
	ArrayList<String> names=new ArrayList<String>();
	names.add("Abhijeet");
	names.add("Don");
	names.add("Alekhya");
	names.add("Adam");
	names.add("Ram");
	int count=0;
	
	for(int i=0;i<names.size();i++)
	{
		String actual=names.get(i);
		if(actual.startsWith("A"))
		{
			count++;
		}
	}

	System.out.println(count);	
		
		
	}
	
	
	@Test
	public void streamFilter() {
		
		ArrayList<String> names=new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Ram");
		int count=0;
		
		Long c=names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		long d = Stream.of("Abhijeet","Don","Alekya","Adam","Ram").filter(s->
		{
			s.startsWith("A");
			return true;
		}).count();
		System.out.println(d);
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		
	}

	@Test
	public void streamMap() {
		Stream.of("Abhijeet","Don","Alekya","Adam","Ram").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
	}
}

