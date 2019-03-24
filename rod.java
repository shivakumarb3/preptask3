import java.util.*;
//The number which has all ones as binary representation will require step2 always since
//when we right shift or divide by 2 will get odd only for eg:7--3--1
//odd number should have 1 in the last digit of binary representation
class rod
{
  public static void main(String args[])
  {
     Scanner as=new Scanner(System.in);
     int t=as.nextInt();
    for(int m=0;m<t;m++) {
	 int n=as.nextInt();
	 int i=0;
	 for(i=0; ;i++)
	 {
	     //finding number of binary numbers in n+1 
	     // if number of digist =3 
	     // we have 1,11,111 we do not need 1 and we do not want 2^n which is greater than n so 
	     // answer willl be number of binary bits -2
	    if(((int)Math.pow(2,i)-1)>=(n+1))
		break;
		
		}
			 System.out.println(i-2);
    }
	 
	 //System.out.println(i-2);
	 }
	 }
	
