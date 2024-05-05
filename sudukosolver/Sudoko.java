package sudukosolver;

import java.util.Scanner;

public class Sudoko 
{
	public static void main(String[] args) 
	{
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter the Grid Size : ");
		int size=scan.nextInt();
		int [][] sudoko= new int[size][size];
		System.out.println("Enter the element in the sudoko :");
		for(int i=0;i<sudoko.length;i++)
		{
			for(int j=0;j<sudoko.length;j++)
			{
				sudoko[i][j]=scan.nextInt();
			}
		}

		System.out.println("Before Solving");
		printSudoko(sudoko);
		if(solve(sudoko))
		{
			System.out.println("After Solving");
			printSudoko(sudoko);
		}
			
		else
			System.out.println("Sudoko has no solution");
	}
	public static void printSudoko(int [][] sudoko)
	{
		
		
		for(int i=0;i<sudoko.length;i++)
		{
			for(int j=0;j<sudoko.length;j++)
			{
				System.out.print(sudoko[i][j]+" ");
			}
			System.out.println("\n------------------");
		}		
	}
	public static boolean solve(int [][] sudoko)
	{
		for(int row=0;row<sudoko.length;row++)
		{
			for(int col=0;col<sudoko.length;col++)
			{
				if(sudoko[row][col]==0)
				{
					for(int num=1;num<=sudoko.length;num++)
					{
						if(isValid(sudoko,num,row,col)) 
						{
							sudoko[row][col]=num;
							if(solve(sudoko))
								return true;
							else 
								sudoko[row][col]=0;
						}
					}
					return false;	
				}
			}
		}
		return true;
		
	}
	public static boolean isValid(int [][] sudoko,int k, int row, int col)
	{
		return !inRow(sudoko,k,row,col) && !inCol(sudoko,k,row,col) && !inBox(sudoko,k,row,col);
	}
	public static boolean inRow(int[][] sudoko, int k, int row, int col)
	{
		for(int i=0;i<sudoko.length;i++)
		{
			if(sudoko[row][i]==k)
				return true;
		}
		return false;
	}

	public static boolean inCol(int[][] sudoko, int k, int row, int col)
	{
		for(int i=0;i<sudoko.length;i++)
		{
			if(sudoko[i][col]==k)
				return true;
		}
		return false;
	}
	public static boolean inBox(int[][] sudoko, int k, int row, int col)
	{
		int r=row-row%3;
		int c=col-col%3;
		
		for(int i=r;i<r+3;i++)
		{
			for(int j=c;j<c+3;j++)
			{
				if(sudoko[i][j]==k)
					return true;
			}		
		}
		return false;
	}
	
	
}
