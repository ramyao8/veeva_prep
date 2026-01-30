import java.util.*;
class DataManagement
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        HashMap<String,HashMap<String,Integer>>hm=new HashMap<>();
        while(true)
        {                
            System.out.println("1.enter store id to retrive the products and prices");
            System.out.println("2. enter store id to find product with highest price");
            System.out.println("3.enter product name to find and  display all stores with that product");
            System.out.println("enter query number");
            int n=sc.nextInt();
            if(n==1)
            {
                String id=sc.next();
                retrivePrices(id,hm);
            }
            else if(n==2)
            {
                String id=sc.next();
                retriveHighestPrice(id,hm);
            }
            else if(n==3)
            {
                String name=sc.next();
                retriveAllProducts(name,hm);
            }
            else{
                break;
            }
        }
    }
    static void retrivePrices(String s,HashMap<String,HashMap<String,Integer>>hm)
    {
         Scanner sc=new Scanner(System.in);
        if(hm.isEmpty() || !hm.containsKey(s))
        {
            System.out.print("enter no of products to insert ");
            int n=sc.nextInt();
             HashMap<String,Integer>hm1=new HashMap<>();
            for(int i=0;i<n;i++)
            {
               System.out.print("enter products name ");
                String name=sc.next();
                System.out.print("enter products price ");
                int price=sc.nextInt();
                hm1.put(name,price);    
                            
            }
            hm.put(s,hm1);
        }
        else
        {
            System.out.println("the products are "+hm.get(s));
        }
    }
    static void retriveHighestPrice(String id,HashMap<String,HashMap<String,Integer>>hm)
    {
         Scanner sc=new Scanner(System.in);
         if(hm.isEmpty() || !hm.containsKey(id))
        {
            System.out.println("Invalid id ");
        }
        else
        {
            HashMap<String,Integer>hm1=new HashMap<>();
            hm1=hm.get(id);
            int max=Integer.MIN_VALUE;
            String res="";
            for(String x:hm1.keySet())
            {
                if(hm1.get(x)>=max){
                    max=hm1.get(x);
                     res=x;
                }
                   
            }
            System.out.println(res);
        }
        

    }
    static void retriveAllProducts(String name,HashMap<String,HashMap<String,Integer>>hm)
    {
         Scanner sc=new Scanner(System.in);
            for (String storeId:hm.keySet()) 
            {
                HashMap<String, Integer> products = hm.get(storeId);
                if(products.containsKey(name))
                    System.out.println(storeId);
            }
    }

}