package Driver;

import ABET.Material;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) throws IOException
	{
		System.out.println("ABET Criteria Calculator");
		
	    ArrayList<Material> materials = getMaterials(); // be SURE that the materials are input in the same order that they appear on the spreadsheet
	    ArrayList<Student> students = getGrades(args[0], materials);
	    for(Student student : students)
	    {
	    	student.calculateABETvalues();
	    }
	    
	    for(Student student : students)
	    { // works, but make sure you have materials data
	    	student.printGrades();
	    }
	    
	    for(Student student : students)
	    {
	    	student.printABET();
	    }
	    
	    ArrayList<Float> abet_averages = new ArrayList<Float>();
	    for(int i = 0; i <= 11; i++)
	    { // populate with 0s
	    	abet_averages.add((float) 0);
	    }
	    
	    // add them all together
	    for(int i = 0; i < students.size(); i++)
	    {
	    	ArrayList<Float> abet_values = students.get(i).getABETvalues();
	    	
	    	abet_averages.set(0, abet_averages.get(0) + abet_values.get(0));
	    	abet_averages.set(1, abet_averages.get(1) + abet_values.get(1));
	    	abet_averages.set(2, abet_averages.get(2) + abet_values.get(2));
	    	abet_averages.set(3, abet_averages.get(3) + abet_values.get(3));
	    	abet_averages.set(4, abet_averages.get(4) + abet_values.get(4));
	    	abet_averages.set(5, abet_averages.get(5) + abet_values.get(5));
	    	abet_averages.set(6, abet_averages.get(6) + abet_values.get(6));
	    	abet_averages.set(7, abet_averages.get(7) + abet_values.get(7));
	    	abet_averages.set(8, abet_averages.get(8) + abet_values.get(8));
	    	abet_averages.set(9, abet_averages.get(9) + abet_values.get(9));
	    	abet_averages.set(10, abet_averages.get(10) + abet_values.get(10));
	    }
	    
	    // divide by the total number of students
    	abet_averages.set(0, abet_averages.get(0) / students.size());
    	abet_averages.set(1, abet_averages.get(1) / students.size());
    	abet_averages.set(2, abet_averages.get(2) / students.size());
    	abet_averages.set(3, abet_averages.get(3) / students.size());
    	abet_averages.set(4, abet_averages.get(4) / students.size());
    	abet_averages.set(5, abet_averages.get(5) / students.size());
    	abet_averages.set(6, abet_averages.get(6) / students.size());
    	abet_averages.set(7, abet_averages.get(7) / students.size());
    	abet_averages.set(8, abet_averages.get(8) / students.size());
    	abet_averages.set(9, abet_averages.get(9) / students.size());
    	abet_averages.set(10, abet_averages.get(10) / students.size());
	    
	    System.out.println();
	    System.out.println("ABET averages: ");
	    
	    System.out.println("Avg A: " + abet_averages.get(0));
	    System.out.println("Avg B: " + abet_averages.get(1));
	    System.out.println("Avg C: " + abet_averages.get(2));
	    System.out.println("Avg D: " + abet_averages.get(3));
	    System.out.println("Avg E: " + abet_averages.get(4));
	    System.out.println("Avg F: " + abet_averages.get(5));
	    System.out.println("Avg G: " + abet_averages.get(6));
	    System.out.println("Avg H: " + abet_averages.get(7));
	    System.out.println("Avg I: " + abet_averages.get(8));
	    System.out.println("Avg J: " + abet_averages.get(9));
	    System.out.println("Avg K: " + abet_averages.get(10));
	}
	
	public static ArrayList<Student> getGrades(String input_file, ArrayList<Material> materials) throws IOException
	{ // this method will acquire the entire grade list
		ArrayList<Student> students = new ArrayList<Student>();
		FileReader fr = new FileReader();
		
		ArrayList<String> lines = fr.readFile(input_file);
		for(int i = 1; i < lines.size(); i++)
		{ // looping over ALL students' grade data, skipping the first line
			String[] line_values = lines.get(i).split("\t"); // splits string based on a given delimiter
			ArrayList<String> line_values_al = new ArrayList<String>();
			{ // convert to ArrayList
				for(String s : line_values)
				{
					line_values_al.add(s);
				}
			}
			Student student = new Student(materials);
			
			for(int j = 0; j < line_values_al.size(); j++)
			{ // looping over the line containing a particular student's grades
				if (j == 0)
				{ // name comes first
					student.setName(line_values_al.get(j));
				}
				else
				{ // add whatever the grade value is
					student.addGrade(Float.parseFloat(line_values_al.get(j)));
				}
			}
			
			students.add(student);
		}
		
		return students;
	}
	
	public static ArrayList<Material> getMaterials()
	{ // gets data on materials, needs to be in the same order as the spreadsheet
		System.out.print("Enter the total number of graded material(s): ");
		Scanner kb = new Scanner(System.in);
	    int num_materials = Integer.parseInt(kb.nextLine());
	    ArrayList<Material> materials = new ArrayList<Material>();
	    
	    if (num_materials == 0) 
	    {
	    	// do nothing
	    }
	    
	    else
	    {
			boolean done = false;
			while(done == false)
			{
				System.out.println();
				System.out.print("Enter name of material/assignment: ");
				String name = kb.nextLine();
				
				Material graded_material = new Material(name);
				
				System.out.print("Enter sum of ABET criteria A knowledge: ");
				graded_material.setSum_a_knowledge(getFloat());
				
				System.out.print("Enter sum of ABET criteria B knowledge: ");
				graded_material.setSum_b_knowledge(getFloat());
				
				System.out.print("Enter sum of ABET criteria C knowledge: ");
				graded_material.setSum_c_knowledge(getFloat());
				
				System.out.print("Enter sum of ABET criteria D knowledge: ");
				graded_material.setSum_d_knowledge(getFloat());
				
				System.out.print("Enter sum of ABET criteria E knowledge: ");
				graded_material.setSum_e_knowledge(getFloat());
				
				System.out.print("Enter sum of ABET criteria F knowledge: ");
				graded_material.setSum_f_knowledge(getFloat());
				
				System.out.print("Enter sum of ABET criteria G knowledge: ");
				graded_material.setSum_g_knowledge(getFloat());
				
				System.out.print("Enter sum of ABET criteria H knowledge: ");
				graded_material.setSum_h_knowledge(getFloat());
				
				System.out.print("Enter sum of ABET criteria I knowledge: ");
				graded_material.setSum_i_knowledge(getFloat());
				
				System.out.print("Enter sum of ABET criteria J knowledge: ");
				graded_material.setSum_j_knowledge(getFloat());
				
				System.out.print("Enter sum of ABET criteria K knowledge: ");
				graded_material.setSum_k_knowledge(getFloat());
				
				materials.add(graded_material);
				graded_material.print();
				
				num_materials--;
				if (num_materials == 0)
				{
					done = true;
				}
			}
	    }
		
		return materials;
	}
	
	public static float getFloat()
	{
		Scanner kb = new Scanner(System.in);
		boolean valid = false;
		float ft = 0;
		
		do
		{
			try 
			{
				ft = Float.parseFloat(kb.nextLine());
				valid = true;
			}
			catch (NumberFormatException e)
			{
				System.out.println("Oops! Please enter a valid number: ");
			}
		} while(!valid);
		
		return ft;
	}
}