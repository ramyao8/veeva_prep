package SeleniumTest1;
import java.util.*;

public class Capitals {

	public static void main(String[] args) {
		
		HashMap<String,HashMap<String,String>> hm=new HashMap<>();
		System.out.println("enter no of countries");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		for(int i=0;i<n;i++)
		{
			HashMap<String,String> hm1=new HashMap<>();
			System.out.println("enter country");
			String c=sc.next();
			System.out.println("enter no of capitals for the country");
			int n1=sc.nextInt();
			
			for(int j=0;j<n1;j++)
			{
				System.out.println("enter capital name");
				String cap=sc.next();
				System.out.println("enter winter/summer/rainy");
				String season=sc.next();
				hm1.put(cap, season);
			}
			hm.put(c, hm1);
		}
		
		for(String x:hm.keySet())
		{
			System.out.println(x+" "+hm.get(x).size()+"  "+hm.get(x));
		}
		
		System.out.println("enter name of the country");
		String country_name=sc.next();
		if(hm.containsKey(country_name))
		{
			System.out.println(hm.get(country_name)+" "+hm.get(country_name).size());
		}
		
		System.out.println("Print all the countries having 2 capitals.");
		for(String x:hm.keySet())
		{
			if(hm.get(x).size()==2)
			{
				System.out.println(x);
			}
		}
		
		System.out.println("Print all the countries having 3 capitals.");
		for(String x:hm.keySet())
		{
			if(hm.get(x).size()==3)
			{
				System.out.println(x);
			}
		}
		
		System.out.println("5. Find countries that doesn’t contain summer capital.");
		for(String x:hm.keySet())
		{
			boolean hasSummer=false;
			for(String season:hm.get(x).values())
			{
				if(season.equalsIgnoreCase("Summer"))
				{
					hasSummer=true;
					break;
				}
			}
			if(!hasSummer)
			{
				System.out.print(x+" ");
			}
		}
		
		System.out.println();
		System.out.println("6. Find capitals of countries starting with vowels.");
		String vowel="aeiou";
		for(String x:hm.keySet())
		{
			char ch=Character.toLowerCase(x.charAt(0));
			if(vowel.indexOf(ch)!=-1)
			{
				for(String y:hm.get(x).keySet())
				{
					System.out.println(x+" "+y);
				}
			}
		}
		
		System.out.println("7. Print summer capitals of countries starting with vowel.");
		for(String country:hm.keySet())
		{
			char ch=Character.toLowerCase(country.charAt(0));
			if(vowel.indexOf(ch)!=-1)
			{
				for(Map.Entry<String,String> entry:hm.get(country).entrySet())
				{
					if(entry.getValue().equalsIgnoreCase("Summer"))
					{
						System.out.println(country+" "+entry.getKey());
					}
				}
			}
		}
	}
}