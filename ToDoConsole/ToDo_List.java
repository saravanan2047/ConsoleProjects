package ToDoConsole;

		import java.util.ArrayList;
		import java.util.Scanner;
		public class ToDo_List 
		{
		public static void main(String[] args) 
		{
		Scanner scan=new Scanner(System.in);
		System.out.println(" Select the task options from below : \n");
		ArrayList<String> todo =new ArrayList<String>();
		// Showing the options 
		System.out.println("1) Display ToDo Lists\n\n2) ADD tasks \n\n3) Delete task\n\n4) Enter 0 to exit");
		// taking option from user
		int opt=scan.nextInt();
		// iterating until user choose to exit
		while(opt!=0)
		{
		switch (opt)
			{
			// calling the functions
				case 1: displayTask(todo);
				break;
				case 2: addTask(todo);
				break;
				case 3: deleteTask(todo);
				break;
				default : System.out.println(" \n Select a valid option");
				}
			// if user enters wrong option showing the options again
			System.out.println(" \n Select the task options from below : \n");
			System.out.println("1) Display ToDo Lists\n2) ADD tasks \n3) Delete task\n4) Enter 0 to exit \n");
				 opt=scan.nextInt();
				}
			System.out.println("\n EXIT SUCCESSFULLY.....");
			}
				// Displaying the tasks inside the arraylist
				public static void displayTask(ArrayList todo)
				{
					// if list is empty ask user to add task first
					if(todo.size()==0) 
					{
					System.out.println(" \n First Add tasks to display it.\n");
					}
					else
					{
					// Displaying the tasks
					System.out.println("\n ****** Displaying the tasks ****** \n");
					for(int i=0;i<todo.size();i++)
					{
						String g=(String) todo.get(i);
						System.out.println("\t\t"+(i+1)+") "+ g);
					}
		System.out.println("\n*******END OF TASK********\n ");
				}
			}
				// Adding the tasks in the arraylist
				public static void addTask(ArrayList todo)
				{
					// getting user input for adding the tasks
					System.out.println(" \n Enter the tasks to add \n ");
					Scanner scan=new Scanner(System.in);
					String s=scan.nextLine();
					 while(s.length()>0)
						{
		todo.add(s);
							s= scan.nextLine();
						}
				}
				
				// deleting the task form the array list
		public static void deleteTask(ArrayList todo)
		{
			Scanner scan=new Scanner(System.in);
			System.out.println (" \n Select the task number to be deleted:");
			// getting the user input to delete the task number
			int x=scan.nextInt();
			String s=(String) todo.get(x);
			todo.remove(s);
			}
}
