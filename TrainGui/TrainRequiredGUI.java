package TrainGui;


import java.time.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;;
class TrainRequiredGUI
{
	int row=0;
	int column=0;
	public int findTotaltrainNeed(ArrayList<ArrayList<Integer>> scheduleA,ArrayList<ArrayList<Integer>> scheduleB)
	{
		int trainAcount=scheduleA.size();
		int trainBcount=scheduleB.size();
		for(int i=0;i<scheduleA.size();i++)
		{	
			for(int j=0;j<scheduleB.size();j++)
			{
				if(scheduleA.get(i).get(0)>scheduleB.get(j).get(1)&&scheduleB.get(j).get(1)>0&&scheduleA.get(i).get(0)!=-1)
				{
				scheduleA.get(i).set(0,-1);
				scheduleB.get(j).set(1,-1);
				trainAcount--;
				}
					
			}

		}
		System.out.println(trainAcount);
		for(int i=0;i<scheduleB.size();i++)
		{
			for(int j=0;j<scheduleA.size();j++)
			{
				
				
				if(scheduleB.get(i).get(0)>scheduleA.get(j).get(1)&&scheduleA.get(j).get(1)!=-1&&scheduleB.get(i).get(0)!=-1)
				{
				scheduleB.get(i).set(i, -1);
				scheduleA.get(j).set(1, -1);
				trainBcount--;
				}
				
			}
		}
		System.out.println(trainBcount);
		return 	trainBcount;
	}
	// converting the string to HH:MM format
	public int convertMintues(String Time)
	{
		int time=0;
		String hourMin[]=Time.split(":");
		//System.out.println();
		try
		{
		time+=(Integer.parseInt(hourMin[0])*60)+Integer.parseInt(hourMin[1]);
		}
		catch(Exception e)
		{
			System.out.println("Invalid");
		}
		if(time<1440)
		return time;
		else
		return 0;
	}
	
	public void comboCreate()
	{
	final String data[]= {"aaa","bbb"};
    String[] items1 = {"12:00", "01:00", "02:00","03:00","04:00","05:00","06:00","07:00","09:00","10:00","11:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00"};
	String station[]= {"A","B"}; 
	
    JFrame  frame = new JFrame(); 
    frame.setSize(800, 500);
	
    final JComboBox<String> comboBox1 = new JComboBox<>(items1);
    comboBox1.setBounds(100, 100, 150, 100);
    
    final JComboBox<String> comboBox2 = new JComboBox<>(items1);
    comboBox2.setBounds(100, 100, 150, 100);
    
    final JComboBox<String> comboBox3 = new JComboBox<>(station);
    comboBox3.setBounds(100, 100, 150, 100);
    
    JButton b=new JButton("ADD");
    b.setBounds(200,100,75,20); 
    
    final DefaultTableModel model = new DefaultTableModel();
    JTable table=new JTable(model);
    table.setBounds(30, 40, 200, 300);
    
    final DefaultTableModel model2 = new DefaultTableModel();
    JTable table1=new JTable(model2);
    table1.setBounds(30, 40, 200, 300);
    
    comboBox1.setAlignmentY(22.0f);
    model.addColumn("A-Arrival");
    model.addColumn("A-Departure");
    model2.addColumn("B-Arrival");
    model2.addColumn("B-Departure");
    
    
    b.addActionListener(new ActionListener() 
    {  
        public void actionPerformed(ActionEvent e) 
        {  
        	 // adding data to the array to add it in the rows of tables
        	if(comboBox3.getItemAt(comboBox3.getSelectedIndex()).equals("A"))
        	{
        		data[0]=comboBox1.getItemAt(comboBox1.getSelectedIndex());
            	data[1]=comboBox2.getItemAt(comboBox2.getSelectedIndex()) ;
        		model.addRow(data);
        	}
        	else
        	{
        		data[0]=comboBox1.getItemAt(comboBox1.getSelectedIndex());
        		data[1]=comboBox2.getItemAt(comboBox2.getSelectedIndex()) ;
        		model2.addRow(data);
        	}
}  
}); 
    JPanel panel=new JPanel(new FlowLayout());
    panel.add(table);
    panel.add(table1);
    panel.add(comboBox1,"North");
    panel.add(comboBox2);
    panel.add(comboBox3);
    panel.add(b);
    frame.add(new  JScrollPane(table),BorderLayout.SOUTH);
    frame.add(new  JScrollPane(table1),BorderLayout.SOUTH);
    
    frame.setLayout(new GridLayout(1, 1));
    
    frame.add(panel);
    frame.setVisible(true);
    
    JButton button=new JButton("SUBMIT"); 
    button.setBounds(200,100,75,20); 
    panel.add(button);
    
    // adding button to peform the operation
    button.addActionListener(new ActionListener()
    {  
        public void actionPerformed(ActionEvent e) 
        { 
        	int value=getTableData(model,model2);
        	System.out.println(value);
        }
    }
    );
    
	}
	public int getTableData(DefaultTableModel model,DefaultTableModel model2)
	{
		ArrayList<ArrayList<Integer>>scheduleA=new ArrayList<>();
		ArrayList<ArrayList<Integer>> scheduleB=new ArrayList<>();
		ArrayList<Integer> col=new ArrayList<>();
		for(int i=0;i<model.getRowCount();i++)
		{
			col.add(convertMintues(model.getValueAt(i,0).toString()));
			col.add(convertMintues(model.getValueAt(i,1).toString()));
			scheduleA.add(col);
			col=new ArrayList<>();
		}
		for(int i=0;i<model2.getRowCount();i++)
		{
			col.add(convertMintues(model2.getValueAt(i,0).toString()));
			col.add(convertMintues(model2.getValueAt(i,1).toString()));
			scheduleB.add(col);
			col=new ArrayList<>();
		}
		return findTotaltrainNeed(scheduleA,scheduleB);
	}
	public static void main(String args[])
	{
		TrainRequiredGUI obj=new TrainRequiredGUI();
		obj.comboCreate();
	}
}
