package ABET;

import java.util.ArrayList;

public class Material 
{ // a graded material that satisfies ABET criteria
	private String name; // name of material/assignment
	
	private ArrayList<Float> criteria_sums;
	
	public Material(String n)
	{
		name = n;
		criteria_sums = new ArrayList<Float>(); // holds criteria
		
		for(int i = 0; i < 7; i++)
		{ // fill for 7 ABET criteria
			criteria_sums.add((float) 0);
		}

	}
	
	public ArrayList<Float> getCriteriaSums()
	{
		return criteria_sums;
	}
	
	public void setCriteriaSums(ArrayList<Float> cs)
	{
		criteria_sums = cs;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void print()
	{
		int i = 0;
		for(float f : criteria_sums)
		{
			i++;
			System.out.println("Sum Criteria " + i + ": " + criteria_sums.get(i));
		}
	}
	
}
