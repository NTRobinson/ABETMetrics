package ABET;

import java.util.ArrayList;

public class Problem 
{ // holds data on a particular problem for any given material
	private String name;
	private float[] ABET_criteria_p;
	private float points_within_assignment;
	
	public Problem(String n, float p,  float c1, float c2, float c3, float c4, float c5, float c6, float c7)
	{
		name = n;
		points_within_assignment = p;
		ABET_criteria_p = new float[7];
		ABET_criteria_p[0] = c1;
		ABET_criteria_p[1] = c2;
		ABET_criteria_p[2] = c3;
		ABET_criteria_p[3] = c4;
		ABET_criteria_p[4] = c5;
		ABET_criteria_p[5] = c6;
		ABET_criteria_p[6] = c7;
	}
	public String toString()
	{
		return name + ": " + points_within_assignment + " points";
	}
	public String toStringABET()
	{
		String abet = name + ": " + points_within_assignment + " points\n";
		
		for(int i = 0; i < 7; i++)
		{
			abet = abet + "% " + (i + 1) + ": " + ABET_criteria_p[i] + "\n";
		}
		
		return abet;
	}
	public ArrayList<String> toStringArray()
	{ // writes all info to an array of strings
		ArrayList<String> lines = new ArrayList<String>();
		
		lines.add(name);
		lines.add(Float.toString(points_within_assignment));
		lines.add(Float.toString(ABET_criteria_p[0]));
		lines.add(Float.toString(ABET_criteria_p[1]));
		lines.add(Float.toString(ABET_criteria_p[2]));
		lines.add(Float.toString(ABET_criteria_p[3]));
		lines.add(Float.toString(ABET_criteria_p[4]));
		lines.add(Float.toString(ABET_criteria_p[5]));
		lines.add(Float.toString(ABET_criteria_p[6]));
		
		return lines;
	}
	
	public float[] getABET()
	{
		return ABET_criteria_p;
	}
	
	public void setPoints(float p)
	{
		points_within_assignment = p;
	}
	public float getPoints()
	{
		return points_within_assignment;
	}
	
	public void set1(float f)
	{
		ABET_criteria_p[0] = f;
	}
	public float get1()
	{
		return ABET_criteria_p[0];
	}
	
	public void set2(float f)
	{
		ABET_criteria_p[1] = f;
	}
	public float get2()
	{
		return ABET_criteria_p[1];
	}
	
	public void set3(float f)
	{
		ABET_criteria_p[2] = f;
	}
	public float get3()
	{
		return ABET_criteria_p[2];
	}
	
	public void set4(float f)
	{
		ABET_criteria_p[3] = f;
	}
	public float get4()
	{
		return ABET_criteria_p[3];
	}
	
	public void set5(float f)
	{
		ABET_criteria_p[4] = f;
	}
	public float get5()
	{
		return ABET_criteria_p[4];
	}
	
	public void set6(float f)
	{
		ABET_criteria_p[5] = f;
	}
	public float get6()
	{
		return ABET_criteria_p[5];
	}
	
	public void set7(float f)
	{
		ABET_criteria_p[6] = f;
	}
	public float get7()
	{
		return ABET_criteria_p[6];
	}
}

