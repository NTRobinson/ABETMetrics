package ABET;

import java.util.ArrayList;

public class Material 
{ // a graded material that satisfies ABET criteria
	private String name; // name of material/assignment
	private Float grade_point_value;
	private ArrayList<Problem> problems;
	
	private ArrayList<Float> criteria_sums;
	
	public Material(String n, float gp)
	{
		name = n;
		grade_point_value = gp;
		criteria_sums = new ArrayList<Float>(); // holds criteria
		problems = new ArrayList<Problem>(); // holds set of problems within material
		
		for(int i = 0; i < 7; i++)
		{ // fill for 7 ABET criteria
			criteria_sums.add((float) 0);
		}

	}
	
	public void addProblem(Problem p)
	{
		problems.add(p);
	}
	public void removeProblem(int index)
	{
		problems.remove(index);
	}
	
	public ArrayList<Problem> getProblems()
	{
		return problems;
	}
	
	public ArrayList<Float> getCriteriaSums()
	{
		return criteria_sums;
	}
	
	public void setGradePointValue(Float gp)
	{
		grade_point_value = gp;
	}
	
	public float getGradePointValue()
	{
		return grade_point_value;
	}
	
	public void setCriteriaSums(ArrayList<Float> cs)
	{
		criteria_sums = cs;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public String toString()
	{
		return name + " - " + grade_point_value;
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
