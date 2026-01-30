import java.util.*;
class Employee
{
    String name;
    String job;
    int salary;
    String DOJ;
    Employee(String n,String j,int sal,String d)
    {
        name=n;
        job=j;
        salary=sal;
        DOJ=d;
    }

}
class SortEmployee
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter n");
         int n=sc.nextInt();
        Employee e[]=new Employee[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("enter name");
            String name=sc.next();
            System.out.println("enter job");
            String job=sc.next();
            System.out.println("enter salary");
            int salary=sc.nextInt();
            System.out.println("enter Doj");
            String DOJ=sc.next();
            e[i]=new Employee(name,job,salary,DOJ);
        }
        while(true)
        {                
            System.out.println("1.salary in ascending order");
            System.out.println("2. salary in decending order");
            System.out.println("3.DOJ in ascending order");
            System.out.println("4.DOJ in decending order");
            System.out.println("enter query number");
            int n1=sc.nextInt();
            if(n1==1)
            {
               Arrays.sort(e,(a,b)->a.salary-b.salary);
               printList(e,n);
            }
            else if(n1==2)
            {
                Arrays.sort(e,(a,b)->b.salary-a.salary);
                printList(e,n);
            }
            else if(n1==3)
            {
                Arrays.sort(e,(a,b)->a.DOJ.compareTo(b.DOJ));
                printList(e,n);
                
            }
            else if(n1==4)
            {
                Arrays.sort(e,(a,b)->b.DOJ.compareTo(a.DOJ));
                printList(e,n);
            }
            else{
                break;
            }
        }
    }
    static void printList(Employee e[],int n)
    {
        for(int i=0;i<n;i++)
        {
            System.out.print(e[i].name+" ");
            System.out.print(e[i].job+" ");
            System.out.print(e[i].salary+" ");
            System.out.print(e[i].DOJ+" ");
        }
    }
}