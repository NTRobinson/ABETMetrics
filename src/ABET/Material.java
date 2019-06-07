package ABET;

import java.util.ArrayList;

public class Material 
{ // a graded material/assignment that satisfies ABET criteria
	private String name; // name of material/assignment
	private Float grade_point_value;
	private ArrayList<Problem> problems;
	private int num_lines;
	
	private ArrayList<Float> criteria_sums; // to-remove, not used in final program
	
	public Material(String n, float gp)
	{
		name = n;
		grade_point_value = gp;
		num_lines = 0;
		criteria_sums = new ArrayList<Float>(); // holds criteria
		problems = new ArrayList<Problem>(); // holds set of problems within material
		
		for(int i = 0; i < 7; i++)
		{ // fill for 7 ABET criteria
			criteria_sums.add((float) 0);
		}

	}
	
	public ArrayList<String> toStringArray()
	{ // writes all material info to a string array
		ArrayList<String> lines = new ArrayList<String>();
		num_lines = problems.size();
		
		lines.add(Integer.toString(num_lines));
		lines.add(name);
		lines.add(Float.toString(grade_point_value));
		for(Problem p : problems)
		{
			ArrayList<String> lines_problem = p.toStringArray();
			for(String s : lines_problem)
			{ // nine lines for each problem
				lines.add(s);
			}
		}
		return lines;
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
	public int getNumLines()
	{
		return num_lines;
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
