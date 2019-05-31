package Driver;

import ABET.ABETGUI;
import ABET.Material;
import ABET.Student;
import GUI.GUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;

public class Driver {
	public static void main(String[] args) throws IOException
	{
		System.out.println("ABET Metrics");
		
		ABETGUI gui = new ABETGUI(800, 600, "ABET Metrics");
		
	    //nonGUI();
	}
	
	public static void nonGUI() throws IOException
	{
		ArrayList<Material> materials = getMaterials(); // be SURE that the materials are input in the same order that they appear on the spreadsheet
	    ArrayList<Student> students = getGrades(materials);
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
	    
	    ArrayList<Float> abet_averages = getABETAverages(students);
	    printABETAverages(abet_averages);
	}
	
	public static ArrayList<Material> getMaterials()
	{ // gets data on materials, needs to be in the same order as the spreadsheet
		System.out.print("Enter the total number of graded material(s): ");
		Scanner kb = new Scanner(System.in);
	    int num_materials = Integer.parseInt(kb.nextLine());
	    ArrayList<Material> materials = new ArrayList<Material>();
	    
	    if (num_materials == 0) 
	    {/* do nothing */}
	    
	    else
	    {
			boolean done = false;
			while(done == false)
			{
				System.out.println();
				System.out.print("Enter name of material/assignment: ");
				String name = kb.nextLine();
				
				Material graded_material = new Material(name, 0);
				ArrayList<Float> ABET_sums = graded_material.getCriteriaSums();
				
				for(int i = 0; i < 7; i++)
				{
					System.out.print("Enter sum of ABET criteria " + (i + 1) + " knowledge: ");
					ABET_sums.set(i, getFloat());
				}
				
				graded_material.setCriteriaSums(ABET_sums);
				materials.add(graded_material);
				//graded_material.print();
				
				num_materials--;
				if (num_materials == 0)
				{
					done = true;
				}
			}
	    }
		
		return materials;
	}
	
	public static ArrayList<Student> getGrades(ArrayList<Material> materials) throws IOException
	{ // this method will acquire the entire grade list
		Scanner kb = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter the name of input grade file: ");
		String input_file = kb.nextLine();
		
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
	
	public static ArrayList<Float> getABETAverages(ArrayList<Student> students)
	{
		ArrayList<Float> abet_averages = new ArrayList<Float>();
	    for(int i = 0; i <= 11; i++)
	    { // populate with 0s
	    	abet_averages.add((float) 0);
	    }
	    
	    // add them all together
	    for(int i = 0; i < students.size(); i++)
	    {
	    	ArrayList<Float> abet_values = students.get(i).getABETvalues();
	    	
	    	for(int j = 0; j < 7; j++)
	    	{
	    		abet_averages.set(j, abet_averages.get(j) + abet_values.get(j));
	    	}
	    }
	    
	    // divide by the total number of students
	    for(int i = 0; i < 7; i++)
	    {
	    	abet_averages.set(i, abet_averages.get(i) / students.size());
	    }

    	return abet_averages;
	}
	
	public static void printABETAverages(ArrayList<Float> abet_averages)
	{
		System.out.println();
	    System.out.println("ABET averages: ");
	    
	    for(int i = 0; i < 7; i++)
	    {
	    	System.out.println("Avg Criteria " + (i + 1) + ": " + abet_averages.get(i));
	    }
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