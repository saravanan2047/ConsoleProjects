package BMI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BMI 
{
	public static void main(String[] args) 
	{
			Scanner scan= new Scanner(System.in);
			boolean s=true;
			ArrayList<BmiInfo>result=new ArrayList<BmiInfo>(); // creating a class type array List
			do
			{
				System.out.println("\n Enter the choice : \n1) Enter the Data \n2) Check Result \n3) EXIT!"); // getting user input
				int choice=scan.nextInt();
				switch(choice)
				{
				
				case 1: // adding the data
				{				
						String stat="";
						float bmiValue=0;
						System.out.println("Enter the Name of the person :");
						String name=scan.next();
				
						System.out.println("Enter the weight in KG :");
						float weight=scan.nextFloat();
						if(weight<=0) 
							{
								System.out.println("Enter Valid weight...!");
								break;
							}
				
						System.out.println("Enter the Height in Cms :");
						float height=scan.nextFloat();
						if(height<=0) 
						{
							System.out.println("Enter Valid weight...!");
							break;
						}
						height=(height*height)/10000;
						
						bmiValue=weight/height;
				
						if(bmiValue<18.5)      stat="Under-Weight";
				
						else if(bmiValue>=18.5 && bmiValue<25.0) stat="Normal";
				
						else if(bmiValue>=25.0 && bmiValue<30.0) stat= "Over-Weight";
				
						else if(bmiValue>=30.2 && bmiValue<40.0) stat="Obese";
				
						else if(bmiValue>=40.0 )                 stat="Highly-Obese"; 
				
						result.add(new BmiInfo(name,weight,height,bmiValue,stat));	
					
					break;
				}
				case 2: // displaying the result 
				{
					if(result.isEmpty()) // checkin whether the array is empty
					{
						System.out.println("Empty List ..!! \n First Enter the data to see result...");
						break;
					}
					else 
					{
						Collections.sort(result, Comparator.comparing(BmiInfo::getBMI).reversed()); // using comparator to sort based on bmi in descending order
						System.out.println(" _________________________________________________");
						System.out.println("|Name      |       BMI       |     Remark         |");
						System.out.println(" -------------------------------------------------");
						for(int i=0;i<result.size();i++)
							{
								System.out.print(result.get(i).getName()+"\t"+"  |"+"\t");
								System.out.printf("%.3f",result.get(i).getBMI());
								System.out.print("\t"+"    |"+"\t"+result.get(i).getResult()+"     |        ");
								System.out.println();
								System.out.println("-------------------------------------------------");
							}
					}
						break;
				}
				case 3:
					System.out.println("✨..........Thank you........✨");
						s=false;
						break;
				default : 
						System.out.println("Enter a valid input.....!"); 
						break;
				}
			}while(s);

	}
	}
	class BmiInfo   // class BMI with parameters
	{
		String name;
		float height;
		float weight;
		float BMI;
		String remark;
		
		public BmiInfo() 
		{
			super();
		}
		public BmiInfo(String name, float weight , float height,Float BMI,String remark) 
		{
			this.name= name;
			this.weight=weight;
			this.height=height;
			this.BMI=BMI;
			this.remark=remark;
			
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public float getHeight() {
			return height;
		}
		public void setHeight(float height) {
			this.height = height;
		}
		public float getWeight() {
			return weight;
		}
		public void setWeight(float weight) {
			this.weight = weight;
		}
		public float getBMI() {
			return BMI;
		}
		public void setBMI(float bMI) {
			BMI = bMI;
		}
		public String getResult() {
			return remark;
		}
		public void setResult(String result) {
			this.remark = result;
		}
}
