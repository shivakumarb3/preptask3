import java.io.*;
import java.util.*;
class Bulbs
{
  public static void main(String args[]) throws Exception
  {
	   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   int t=Integer.parseInt(br.readLine());
	  for(int v=0;v<t;v++){
	   String s=br.readLine();
	   long n=Long.parseLong(br.readLine());
	   ArrayList<Integer> al=new ArrayList<Integer>();
	   SortedSet<Long> h = new TreeSet<>();
	   for(int i=0;i<=39;i++){
		   if(s.charAt(i)=='1')
		   {
			   al.add(i+1);
		   }
	   }
	  
	  int k=1;
	  for(int i:al)
	  {
		  
		  for(long j=1;j<=n;j++)
			  h.add((long)(j)*(long)(i));
	}
	
	Iterator<Long> itr=h.iterator();
	while(itr.hasNext())
	{
		if(k==n)
	    {
			System.out.println(itr.next());
			break;
		}
		itr.next();
		k++;
	
     }
  }
  }
}
		  
  
  