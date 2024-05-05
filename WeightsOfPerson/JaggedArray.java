package WeightsOfPerson;

import java.util.Scanner;

public class JaggedArray 
{
	public static void main(String[] args) 
	{
		Scanner scan= new Scanner(System.in);
		 int [][] res=null;
		while(true)
		{
			
			System.out.println("Select any option \n1) Add person's weights \n2) Find Weight \n3) Exit");
			int choice=scan.nextInt();
			
			switch(choice)
			{
			case 1:res=createArray();
			break;
			case 2:displayMin(res);
			break;
			case 3: break;
			default : System.out.println("Enter a valid option...!!!");
			}
			if(choice==3) break;
		} 
	}
		
		static int [][] createArray()
		{
			Scanner scan= new Scanner(System.in);
			System.out.println("Enter the number of Persons : ");
			int arr[][]=new int[scan.nextInt()][];
//			int res[][] = null;
			for(int x=0;x<arr.length;x++) 
			{
				System.out.println("Enter the Person's number to add weight");
				int person=scan.nextInt();
				if(person>=0 && person<=arr.length-1 && arr[person]==null)
					arr=addWeight(person,arr);
				else 
					System.out.println("Enter a valid Person number from 0 - "+(arr.length-1));
			}
			return arr;
		}
		public static void displayMin(int [][]arr)
		{
			if(arr==null)
			{
				System.out.println("First enter the weights...");
				return;
			}
			else {
			Scanner scan= new Scanner(System.in);
			System.out.println("Enter the Person's number to find the min weight");
			int findMin=scan.nextInt();
			int result=findMinWeight(findMin,arr);
			if(result!=0)
				System.out.println("Minimum weight of the "+(findMin+1)+" person is "+result);
		}
		}
		// to add the number of weight for nth person
		static int[][] addWeight(int p,int a[][])
		{
			
			Scanner scan= new Scanner(System.in);
			System.out.println("Enter the number of weights you want to add for PERSON:"+(p+1));
			int num=scan.nextInt();
			a[p]=new int[num];
			for(int i=0;i<num;i++)
			{
				a[p][i]=scan.nextInt();
			}
			return a;
		}
		
		
		// to find the minimum weight of the person
		static int findMinWeight(int person,int b[][])
		{
			
				
				if (b!=null && person<b.length)
				{
					int minimum=b[person][0];
					for(int i=0;i<b[person].length;i++)
					{
						minimum=Math.min(minimum,b[person][i]);
					}
					return minimum;
				}
				else
				{
					System.out.println("Enter valid person number...!!!");
					return 0;
				}
			}
}


