package SeleniumTest1;
import java.util.*;
public class StudentsPriority {

	    public static void main(String[] args) {
	        Scanner sc=new Scanner(System.in);
	        int totalEvents=sc.nextInt();
	        PriorityQueue<String[]>pq=new PriorityQueue<>(
	            (s1,s2)->{
	                double cgpa1=Double.parseDouble(s1[1]);
	                double cgpa2=Double.parseDouble(s2[1]);
	                if (Double.compare(cgpa2,cgpa1)!=0)
	                    return Double.compare(cgpa2, cgpa1);
	                else if (!s1[0].equals(s2[0]))
	                    return s1[0].compareTo(s2[0]);
	                else
	                    return Integer.parseInt(s1[2])-Integer.parseInt(s2[2]);
	            }
	        );
	        for(int i=0;i<totalEvents;i++) 
	        {
	            String event=sc.next();
	            if (event.equals("Enter")) {
	                String name=sc.next();
	                String cgpa=sc.next();
	                String id=sc.next();
	                pq.add(new String[]{name,cgpa,id});
	            } 
	            else if (event.equals("Served")) {
	                if (!pq.isEmpty()) {
	                    pq.poll();
	                }
	            }
	        }

	        if (pq.isEmpty()) {
	            System.out.println("EMPTY");
	        } 
	        else {
	            while (!pq.isEmpty()) {
	                System.out.println(pq.poll()[0]);
	            }
	        }
	    }
	}