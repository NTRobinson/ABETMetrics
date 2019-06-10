package ABET;

import java.util.ArrayList;

public class Material 
{ // a graded material/assignment that satisfies ABET criteria
	private String name; // name of material/assignment
	private Float point_value;
	private ArrayList<Problem> problems;
	private int num_lines;
	
	private float[] crit_points; // sum of criteria points
	private float[] crit_percentages; // 
	
	public Material(String n, float gp)
	{
		name = n;
		point_value = gp;
		num_lines = 0;
		problems = new ArrayList<Problem>(); // holds set of problems within material
	}
	public ArrayList<String> toStringArray()
	{ // writes all material info to a string array, for saving/loading
		ArrayList<String> lines = new ArrayList<String>();
		num_lines = problems.size();
		
		lines.add(Integer.toString(num_lines));
		lines.add(name);
		lines.add(Float.toString(point_value));
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
	public float[] getCriteriaSums()
	{ // returns criteria points possible to be earned for this assignment, with respect to the entire grade book
		float total_points = 0;
		for(Problem p : problems)
		{total_points = total_points + p.getPoints();}
		float[] crit_sums = new float[7];
		float[] crit_percentages = getCritPercentages(total_points);
		
		crit_sums[0] = crit_percentages[0] * point_value;
		crit_sums[1] = crit_percentages[1] * point_value;
		crit_sums[2] = crit_percentages[2] * point_value;
		crit_sums[3] = crit_percentages[3] * point_value;
		crit_sums[4] = crit_percentages[4] * point_value;
		crit_sums[5] = crit_percentages[5] * point_value;
		crit_sums[6] = crit_percentages[6] * point_value;
		
		return crit_sums;
	}
	private float[] getCritPercentages(float total_points)
	{ // gets the percentages of each type of criteria in this assignment
		crit_points = getCriteriaPoints(total_points);
		crit_percentages = new float[7];
		
		crit_percentages[0] = crit_points[0] / total_points;
		crit_percentages[1] = crit_points[1] / total_points;
		crit_percentages[2] = crit_points[2] / total_points;
		crit_percentages[3] = crit_points[3] / total_points;
		crit_percentages[4] = crit_points[4] / total_points;
		crit_percentages[5] = crit_points[5] / total_points;
		crit_percentages[6] = crit_points[6] / total_points;
		
		return crit_percentages;
	}
	private float[] getCriteriaPoints(float total_points)
	{ // returns sum of points for each criteria in this assignment/material
		crit_points = new float[7];
		
		for(Problem p : problems)
		{total_points = total_points + p.getPoints();}
		
		for(Problem p : problems)
		{ // find total points for each criteria with respect to the total points
			crit_points[0] = crit_points[0] + (float) (p.getPoints() * (p.get1() * 0.01));
			crit_points[1] = crit_points[1] + (float) (p.getPoints() * (p.get2() * 0.01));
			crit_points[2] = crit_points[2] + (float) (p.getPoints() * (p.get3() * 0.01));
			crit_points[3] = crit_points[3] + (float) (p.getPoints() * (p.get4() * 0.01));
			crit_points[4] = crit_points[4] + (float) (p.getPoints() * (p.get5() * 0.01));
			crit_points[5] = crit_points[5] + (float) (p.getPoints() * (p.get6() * 0.01));
			crit_points[6] = crit_points[6] + (float) (p.getPoints() * (p.get7() * 0.01));
		}
		
		return crit_points;
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
	public int getNumLines()
	{
		return num_lines;
	}
	public void setGradePointValue(Float gp)
	{
		point_value = gp;
	}
	public float getGradePointValue()
	{
		return point_value;
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
		for(float f : crit_points)
		{
			i++;
			System.out.println("Sum Criteria " + i + ": " + crit_points[i]);
		}
	}
}
