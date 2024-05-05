package TrainGui;
	import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

	public class TrainRequiredSwing extends JFrame 
	{
		
		public static int [] noOfTrains(ArrayList<String> A_departure,ArrayList<String> A_arrival,ArrayList<String>B_departure,ArrayList<String>  B_arrival)
	    {
	        List<Integer> depatureA = new ArrayList<Integer>();
	        List<Integer> arrivalA = new ArrayList<Integer>();
	        List<Integer> depatureB = new ArrayList<Integer>();
	        List<Integer> arrivalB = new ArrayList<Integer>();
	        int aCount=0,bCount=0;
	        for (int i = 0; i < A_arrival.size(); i++) 
	        {
	            int min1=toMinutes(A_departure.get(i));
	            int min2=toMinutes(A_arrival.get(i));
	            if(min1 ==-1 || min2==-1)
	                System.out.println("Invalid input");
	            depatureA.add(min1);
	            arrivalA.add(min2);
	        }
	        for (int i = 0; i < B_departure.size(); i++) 
	        {
	            int min1=toMinutes(B_departure.get(i));
	            int min2=toMinutes(B_arrival.get(i));
	            if(min1 ==-1 || min2==-1)
	               System.out.println("Invalid input");
	            depatureB.add(min1);
	            arrivalB.add(min2);
	        } 
	        // if arrival is greater than departure then train is required
	        for (int i = 0; i < depatureA.size(); i++)
	        {
	            if(arrivalB.isEmpty()) {
	                aCount=depatureA.size();
	                break;
	            }
	            if(Collections.min(arrivalB)<depatureA.get(i))
	            {
	                arrivalB.remove(Collections.min(arrivalB));
	                continue;
	            }
	            if(!depatureA.isEmpty() &&!(Collections.min(arrivalB)<depatureA.get(i)))
	                aCount++;
	        }
	     // if arrival is greater than departure then train is required
	        for (int i = 0; i < depatureB.size(); i++) 
	        {
	            if(arrivalA.isEmpty()) {
	                bCount=depatureB.size();
	                break;
	            }
	            if(Collections.min(arrivalA)<depatureB.get(i))
	            {
	                arrivalA.remove(Collections.min(arrivalA));
	                continue;
	            }
	            if(!depatureB.isEmpty() &&  !(Collections.min(arrivalA)<depatureB.get(i)))
	                bCount++;
	        }
	        int [] res= new int[2];
	        res[0]=aCount;
	        res[1]=bCount;
	        return res;
	        
	    }
	// method to validate the time  format and convert it into minutes
	    public static int toMinutes(String s) 
	    {
	        String[] s1 = s.split(":");
	        if (s1.length != 2)
	            return -1;
	        int hours = Integer.parseInt(s1[0]);
	        int min = Integer.parseInt(s1[1]);
	        if (hours < 0 || hours > 23 || min < 0 || min > 59)
	            return -1;
	        return hours * 60 + min;
	    }
	    

	    public TrainRequiredSwing() 
	    {
	    	 JTextField inputField1, inputField2, inputField3, inputField4,inputField5, inputField6, inputField7,inputField8;
		     JTable table1, table2;
		     JLabel outputLabel;
	        setTitle("Train Required");
	        setSize(1000, 500);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // Create input fields
	        inputField1 = new JTextField(10);
	        inputField2 = new JTextField(10);
	        inputField3 = new JTextField(10);
	        inputField4 = new JTextField(10);
	        inputField5 = new JTextField(10);
	        inputField6 = new JTextField(10);
	        inputField7 = new JTextField(10);
	        inputField8 = new JTextField(10);

	        // Create tables
	        table1 = new JTable();
	        table2 = new JTable();

	        // Create output label
	        outputLabel = new JLabel("Train Required is : ");

	        

	        // Create layout
	        setLayout(new GridLayout(5, 2));
	        add(new JLabel("A station departure: "));
	        add(inputField1);
	        add(new JLabel("A station Arrival:"));
	        add(inputField2);
	        add(new JLabel("A station departure:"));
	        add(inputField3);
	        add(new JLabel("A station Arrival:"));
	        add(inputField4);
	        add(new JLabel("B station departure:"));
	        add(inputField5);
	        add(new JLabel("B station Arrival"));
	        add(inputField6);
	        add(new JLabel("B station departure:"));
	        add(inputField7);
	        add(new JLabel("B station Arrival"));
	        add(inputField8);

	     // Create button
	        JButton processButton = new JButton("SUBMIT");
	        
	        
	        ArrayList<String> A_depart=new ArrayList<String>();
	        ArrayList<String> A_arrival=new ArrayList<String>();
	        ArrayList<String> B_depart=new ArrayList<String>();
	        ArrayList<String> B_arrival=new ArrayList<String>();
	 
	        
	        processButton.addActionListener(new ActionListener() 
	        {
	            @Override
	            public void actionPerformed(ActionEvent e) 
	            {
	            	 // Get input values
	    	        String value1 = inputField1.getText();
	    	        String value2 = inputField2.getText();
	    	        String value3 = inputField3.getText();
	    	        String value4 = inputField4.getText();
	    	        String value5 = inputField1.getText();
	    	        String value6 = inputField2.getText();
	    	        String value7 = inputField3.getText();
	    	        String value8 = inputField4.getText();

	    	       A_depart.add(value1);
	    	       A_depart.add(value3);
	    	       
	    	       A_arrival.add(value2);
	    	       A_arrival.add(value4);
	    	       
	    	       B_depart.add(value5);
	    	       B_depart.add(value7);
	    	       
	    	       B_arrival.add(value6);
	    	       B_arrival.add(value8);
	    	        // Set data in tables
	    	        
	    	        int [] s=noOfTrains(A_depart,A_arrival,B_depart,B_arrival);
	    	        // Display output in label
	    	        outputLabel.setText("Train at A is : "+(s[0])+" &  B is :"+(s[1]) );

	            }
	        });
	       
	        add(processButton);
	        add(outputLabel);
	        setVisible(true);
	    }

	    public void processInput() 
	    {
	       
	    }
	    public static void main(String[] args) 
	    {
	        SwingUtilities.invokeLater(new Runnable() 
	        {
	            @Override
	            public void run() 
	            {
	                new TrainRequiredSwing();
	            }
	        });
	    }
	}



