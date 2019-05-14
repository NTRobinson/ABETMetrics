package Driver;

import java.util.ArrayList;

import ABET.Material;

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
		abet_values = new ArrayList<Float>();
	}
	
	public void addGrade(float g)
	{
		grades.add(g);
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public ArrayList<Float> calculateABETvalues()
	{
		// so we have a "material" with different ABET values associated with it
		// need to pull that information out (for each material), multiply it by whatever percentage the student made on the assignment, and sum it with every other material
		
		for (int i = 0; i <= 11; i++)
		{ // initialize ABET values to 0
			abet_values.add((float) 0);
		}
		
		for (int i = 0; i < materials.size(); i++)
		{
			float grade_on_material = grades.get(i);
			
			// there are 11 ABET criteria, where index 0 in abet_values corresponds to criteria 'a'
			abet_values.set(0, (float) ((abet_values.get(0) + materials.get(i).getSum_a_knowledge() * 0.01 * grade_on_material)));
			abet_values.set(1, (float) ((abet_values.get(1) + materials.get(i).getSum_b_knowledge() * 0.01 * grade_on_material)));
			abet_values.set(2, (float) ((abet_values.get(2) + materials.get(i).getSum_c_knowledge() * 0.01 * grade_on_material)));
			abet_values.set(3, (float) ((abet_values.get(3) + materials.get(i).getSum_d_knowledge() * 0.01 * grade_on_material)));
			abet_values.set(4, (float) ((abet_values.get(4) + materials.get(i).getSum_e_knowledge() * 0.01 * grade_on_material)));
			abet_values.set(5, (float) ((abet_values.get(5) + materials.get(i).getSum_f_knowledge() * 0.01 * grade_on_material)));
			abet_values.set(6, (float) ((abet_values.get(6) + materials.get(i).getSum_g_knowledge() * 0.01 * grade_on_material)));
			abet_values.set(7, (float) ((abet_values.get(7) + materials.get(i).getSum_h_knowledge() * 0.01 * grade_on_material)));
			abet_values.set(8, (float) ((abet_values.get(8) + materials.get(i).getSum_i_knowledge() * 0.01 * grade_on_material)));
			abet_values.set(9, (float) ((abet_values.get(9) + materials.get(i).getSum_j_knowledge() * 0.01 * grade_on_material)));
			abet_values.set(10, (float) ((abet_values.get(10) + materials.get(i).getSum_k_knowledge() * 0.01 * grade_on_material)));
		}
		
		return abet_values;
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
		System.out.println("A: " + abet_values.get(0));
		System.out.println("B: " + abet_values.get(1));
		System.out.println("C: " + abet_values.get(2));
		System.out.println("D: " + abet_values.get(3));
		System.out.println("E: " + abet_values.get(4));
		System.out.println("F: " + abet_values.get(5));
		System.out.println("G: " + abet_values.get(6));
		System.out.println("H: " + abet_values.get(7));
		System.out.println("I: " + abet_values.get(8));
		System.out.println("J: " + abet_values.get(9));
		System.out.println("K: " + abet_values.get(10));
	}
}
