import java.util.*;
import java.io.*;
class Army
{
  public static void main(String args[])
  {
     
      Scanner as=new Scanner(System.in);
	  int n=as.nextInt();
	  long start=as.nextLong();
	  long end =as.nextLong();
	  long s[]=new long[n];
	  long d[]=new long[n];
	  for(int i=0;i<n;i++)
	  {
	      long x=as.nextLong();
		  long p=as.nextLong();
		  s[i]=x-p;
		  d[i]=x+p;
		  }
		  MergeSort obj=new MergeSort();
		obj.sort(d,s,0,n-1);
		
	//finding conflicts
	long f1[]=new long[n];
	long f2[]=new long[n];
	f1[0]=s[0];
	f2[0]=d[0];
	int k=0;
	for(int i=1;i<n;i++)
	  {
	      if(s[i]>=f2[k])//insert
		  { 
		      k++;
			  f1[k]=s[i];
			  f2[k]=d[i];
		   }
		   else
		   {
		   //finding conflicts
		    int r=k;
			long min=s[i];
			long max=d[i];
			int v=r;
			 for( v=r;v>=0;v--)
			 {
			   if(s[i]<f2[v]){
			   min=minimum(min,f1[v]);
			   max=maximum(max,f2[v]);
			   f1[v]=min;
			   f2[v]=max;
			     }
				 else
				 {
				 break;
				 }
		    }
			 k=v+1;
			 }
	  }
	  long totaldist=0;
	  if(start<f1[0])
	  totaldist=totaldist+Math.abs(f1[0]-start);
	  //System.out.println("final array");
	 /* for(int i=0;i<=k;i++)
	  {
		  System.out.println(f1[i]+" "+f2[i]);
	  }
	  */
	  for(int i=1;i<=k;i++)
	  {
		  totaldist=totaldist+f1[i]-f2[i-1];
		  
	  }
	 if(f2[k]>=end)
	  System.out.println(totaldist);
     else
		 System.out.println(totaldist+Math.abs(end-f2[k]));
  }
	static long minimum(long a,long b)
	{
		if(a<b)
			return a;
		else
			return b;
	}
	static long maximum(long a,long b)
	{
		if(a>b)
			return a;
		else
			return b;
	}
}
class MergeSort 
{ 
	// Merges two subarrays of arr[]. 
	// First subarray is arr[l..m] 
	// Second subarray is arr[m+1..r] 
	void merge(long arr[],long brr[], int l, int m, int r) 
	{ 
		// Find sizes of two subarrays to be merged 
		int n1 = m - l + 1; 
		int n2 = r - m; 

		/* Create temp arrays */
		long L[] = new long [n1]; 
		long l2[]=new long[n1];
		
		
		long R[] = new long [n2]; 
		long r2[]=new long[n2];
		

		/*Copy data to temp arrays*/
		for (int i=0; i<n1; ++i) {
			L[i] = arr[l + i]; 
			l2[i]=brr[l+i];
			}
		for (int j=0; j<n2; ++j) {
			R[j] = arr[m + 1+ j]; 
			r2[j]=brr[m+1+j];
			}


		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays 
		int i = 0, j = 0; 

		// Initial index of merged subarry array 
		int k = l; 
		while (i < n1 && j < n2) 
		{ 
			if (L[i] <= R[j]) 
			{ 
				arr[k] = L[i]; 
				brr[k]=l2[i];
				i++; 
			} 
			else
			{ 
				arr[k] = R[j]; 
				brr[k]=r2[j];
				j++; 
			} 
			k++; 
		} 

		/* Copy remaining elements of L[] if any */
		while (i < n1) 
		{ 
			arr[k] = L[i]; 
			brr[k]=l2[i];
			i++; 
			k++; 
		} 

		/* Copy remaining elements of R[] if any */
		while (j < n2) 
		{ 
			arr[k] = R[j]; 
			brr[k]=r2[j];
			j++; 
			k++; 
		} 
	} 

	// Main function that sorts arr[l..r] using 
	// merge() 
	void sort(long arr[], long brr[],int l, int r) 
	{ 
		if (l < r) 
		{ 
			// Find the middle point 
			int m = (l+r)/2; 

			// Sort first and second halves 
			sort(arr,brr, l, m); 
			sort(arr ,brr, m+1, r); 

			// Merge the sorted halves 
			merge(arr, brr,l, m, r); 
		} 
	}
}	
	
	  
				
    