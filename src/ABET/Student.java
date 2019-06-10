package ABET;

import java.util.ArrayList;

public class Student 
{
	private String name; // name of student
	
	private ArrayList<Float> grades; // each grade should correspond to the same index as the material it is for
	private ArrayList<Float> abet_values; // list containing a percentage value that this student has satisfied
	private ArrayList<Material> materials; // list of each ABET criteria satisfying materials
	
	public Student(ArrayList<Material> ms)
	{
		materials = ms;
		grades = new ArrayList<Float>();
		for(int i = 0; i < 7; i++)
		{
			grades.add((float) 0);
		}
		
		abet_values = new ArrayList<Float>();
	}
	public boolean addGrade(float g, String material)
	{	
		boolean added = false;
		for(int i = 0; i < materials.size(); i++)
		{
			if(material.equalsIgnoreCase(materials.get(i).getName()))
			{ // if the name of material supplied matches one in the list, that's the grade value we have
				grades.set(i, g);
				added = true;
			}
		}
		return added;
	}
	public ArrayList<Float> calculateABETvalues()
	{ // need to pull assignment points, multiply it by whatever percentage the student made on the assignment, and sum it with every other material
		abet_values = new ArrayList<Float>();
		for (int i = 0; i < 7; i++)
		{ // initialize ABET values to 0
			abet_values.add((float) 0);
		}
		
		for (int i = 0; i < materials.size(); i++)
		{
			float grade_on_material = grades.get(i);
			// there are 7 ABET criteria
			for(int j = 0; j < 7; j++)
			{
				float[] crit_sums = materials.get(i).getCriteriaSums();
				abet_values.set(j, (float) ((abet_values.get(j) + crit_sums[j] * 0.01 * grade_on_material)));
			}
		}
		return abet_values;
	}
	public void setName(String n)
	{
		name = n;
	}
	public ArrayList<Float> getABETvalues()
	{
		return abet_values;
	}
	public ArrayList<Float> getGrades()
	{
		return grades;
	}
	public void printGrades()
	{
		System.out.println();
		System.out.println(name + " grades for each material: ");
		for (int i = 0; i < grades.size(); i++)
		{
			System.out.println(materials.get(i).getName() + " " + grades.get(i));
		}
	}
	public void printABET()
	{
		System.out.println();
		System.out.println(name + " ABET scores: ");
		System.out.println("1: " + abet_values.get(0));
		System.out.println("2: " + abet_values.get(1));
		System.out.println("3: " + abet_values.get(2));
		System.out.println("4: " + abet_values.get(3));
		System.out.println("5: " + abet_values.get(4));
		System.out.println("6: " + abet_values.get(5));
		System.out.println("7: " + abet_values.get(6));
	}
}
