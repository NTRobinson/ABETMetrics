package ABET;

import java.io.IOException;
import java.util.ArrayList;

import Driver.FileReaderWriter;

public class ABETLoadSave 
{
	ArrayList<String> grade_key; //  NAME ASSIGNMENT1 ASSIGNMENT2 ASSIGNMENT3 ETC
	ArrayList<Student> students; // will eacj
	
	public ABETLoadSave()
	{
		grade_key = new ArrayList<String>();
		students = new ArrayList<Student>();
	}
	
	public void save(String file_name, ArrayList<String> lines) throws IOException
	{ // this method will write all of material data (including problem data) to a text file for loading from
		FileReaderWriter frw = new FileReaderWriter();
		frw.writeFile(file_name, lines);
	}
	
	public ArrayList<Material> load(String file_name) throws IOException
	{ // this method will read the data that we wrote previously from a save
		// read num_materials
		// for each material, read - name, points, each problem
		// add save to list of materials
		ArrayList<Material> materials = new ArrayList<Material>();
		FileReaderWriter frw = new FileReaderWriter();
		ArrayList<String> lines = frw.readFile(file_name);
		
		int curr_line = 0;
		
		int num_materials = Integer.parseInt(lines.get(0));
		curr_line++;
		
		for(int i = 0; i < num_materials; i++)
		{ // read each material, base on num_materials
			int num_problems = Integer.parseInt(lines.get(curr_line));
			curr_line++;
			
			String material_name = lines.get(curr_line);			
			curr_line++;
			float material_points = Float.parseFloat(lines.get(curr_line));
			curr_line++;
			Material new_material = new Material(material_name, material_points);
			
			for(int j = 0; j < num_problems; j++)
			{ // read all the problems for the newly created material
				String prob_name = lines.get(curr_line);
				curr_line++;
				
				Float prob_points = Float.parseFloat(lines.get(curr_line));
				curr_line++;
				Float crit1 = Float.parseFloat(lines.get(curr_line));
				curr_line++;
				Float crit2 = Float.parseFloat(lines.get(curr_line));
				curr_line++;
				Float crit3 = Float.parseFloat(lines.get(curr_line));
				curr_line++;
				Float crit4 = Float.parseFloat(lines.get(curr_line));
				curr_line++;
				Float crit5 = Float.parseFloat(lines.get(curr_line));
				curr_line++;
				Float crit6 = Float.parseFloat(lines.get(curr_line));
				curr_line++;
				Float crit7 = Float.parseFloat(lines.get(curr_line));
				curr_line++;
				
				Problem new_prob = new Problem(prob_name, prob_points, crit1, crit2, crit3, crit4, crit5, crit6, crit7);
				new_material.addProblem(new_prob);
			}
			
			materials.add(new_material);
		}
		
		return materials;
	}
	
	public ArrayList<Student> getGrades(ArrayList<Material> materials, String input_file) throws IOException
	{ // adds grades, spreadsheet doesn't need to correspond with the order in-application
		FileReaderWriter fr = new FileReaderWriter();
		ArrayList<String> lines = fr.readFile(input_file);
		
		String[] first_line = lines.get(0).split("\t"); // NAME ASSIGNMENT1 ASSIGNMENT2 ASSIGNMENT3 ETC
		for(String s : first_line)
		{grade_key.add(s);} // manually convert String[] to ArrayList
		
		for(int i = 1; i < lines.size(); i++)
		{ // loop over ALL students' grade data, skipping the first line
			String[] line_values = lines.get(i).split("\t"); // splits string based on a given delimiter
			ArrayList<String> line_values_al = new ArrayList<String>();
			 
			for(String s : line_values)
			{line_values_al.add(s);}
			
			Student student = new Student(materials); // materials list is added
			
			for(int j = 0; j < line_values_al.size(); j++)
			{ // looping over the line containing a particular student's grades
				if (j == 0)
				{ // name comes first
					student.setName(line_values_al.get(j));
				}
				else
				{ // add whatever the grade value is
					boolean added = student.addGrade(Float.parseFloat(line_values_al.get(j)), grade_key.get(j));
					if(added = false)
					{
						System.out.println(grade_key.get(j) + " not found!");
					}
				}
			}
			
			students.add(student);
		}
		return students;
	}
}
