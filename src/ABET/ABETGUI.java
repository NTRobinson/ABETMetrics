package ABET;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import GUI.*;

public class ABETGUI extends GUI implements Drawable, ActionListener
{
	private GUI materials_frame;
	private ArrayList<Material> materials;
	private ArrayList<Student> students;
	
	private JTextField m_name;
    private JTextField m_grade_points;
    private JList<Material> material_l;
    private JList<Material> material_l2;
    private JComboBox<Material> east_combo;
    private JScrollPane east_north_scroll;
    private JList<Problem> problems_l;
    private JTextPane east_south_text;
    private JTextPane abet_results;
    
    private JTextField prob_name;
    private JTextField prob_points;
    private JTextField prob_crit1;
    private JTextField prob_crit2;
    private JTextField prob_crit3;
    private JTextField prob_crit4;
    private JTextField prob_crit5;
    private JTextField prob_crit6;
    private JTextField prob_crit7;
	
	public ABETGUI(int width, int height, String title) 
	{
		super(width, height, title);
		materials_frame = new GUI(width, height, "Add Assignments"); // will pop up when "Add Materials" button clicked
		materials = new ArrayList<Material>();
		
		// second frame needed for materials
		setupMaterialsFrame(materials_frame);
		
		// WEST
		JPanel west_p = new JPanel();
		BorderLayout west_l = new BorderLayout();
		west_p.setLayout(west_l);
		
		// - materials
		JButton add_material = new JButton("Add Assignments");
	    west_p.add(add_material, BorderLayout.NORTH);
	    add_material.addActionListener(this);
	    add_material.setActionCommand("ADD");
		
		JScrollPane west_scroll = new JScrollPane();
		west_scroll.setPreferredSize(new Dimension(200,400));
		material_l = new JList<Material>();
	    west_scroll.getViewport().add(material_l);
	    Material[] materials_array = new Material[materials.size()];
	    material_l.setListData(materials.toArray(materials_array));

	    west_p.add(west_scroll, BorderLayout.WEST);
	    
	    // - save/load materials
	    JPanel west_east_p = new JPanel();
	    GridLayout west_east_l = new GridLayout(2, 1);
	    west_east_p.setLayout(west_east_l);
	    
	    JButton load_material = new JButton("Load Assignments");
	    load_material.addActionListener(this); // whenever the combo box picks up an action
	    load_material.setActionCommand("LOAD");
	    west_east_p.add(load_material);
	    
	    JButton save_material = new JButton("Save Assignments");
	    save_material.addActionListener(this); // whenever the combo box picks up an action
	    save_material.setActionCommand("SAVE");
	    west_east_p.add(save_material);
	    
	    west_p.add(west_east_p, BorderLayout.EAST);
	    
	    // EAST
	    JPanel east_p = new JPanel();
	    BorderLayout east_l = new BorderLayout();
	    east_p.setLayout(east_l);
	    
	    abet_results = new JTextPane(); //east_south_text.setPreferredSize(new Dimension(200,200));
	    abet_results.setEditable(false);
	    abet_results.setText("ABET Averages");
	    east_p.add(abet_results, BorderLayout.EAST);
	    
	    JPanel east_west_p = new JPanel();
	    BorderLayout east_west_l = new BorderLayout();
	    east_west_p.setLayout(east_west_l);
	    
	    JButton load_grades = new JButton("Load Grades");
	    load_grades.addActionListener(this);
	    load_grades.setActionCommand("LOAD GRADES");
	    east_west_p.add(load_grades, BorderLayout.NORTH);
	    
	    JButton calculate = new JButton("Calculate Averages");
	    calculate.addActionListener(this);
	    calculate.setActionCommand("CALCULATE");
	    east_west_p.add(calculate, BorderLayout.CENTER);
	    
	    east_p.add(east_west_p, BorderLayout.WEST);
	    
	    // finishing touches
	    javax.swing.ImageIcon img_icon = new javax.swing.ImageIcon("resources/abet.png");
		setIconImage(img_icon.getImage());
	    setResizable(false);
	    setVisible(true);
	    add(east_p, BorderLayout.EAST);
	    add(west_p, BorderLayout.WEST);
	}
	
	public void setupMaterialsFrame(GUI materials_frame)
	{ // frame for adding materials and their associated problem
		// NORTH
	    JPanel north_p = new JPanel();
	    BorderLayout north_l = new BorderLayout();
	    north_p.setLayout(north_l);
	    
	    JButton back_button = new JButton("Go Back");
	    north_p.add(back_button);
	    back_button.addActionListener(this);
	    back_button.setActionCommand("GO BACK");
	    
	    // WEST - for managing assignments/materials
	    JPanel west_p = new JPanel();
	    BorderLayout west_l = new BorderLayout();
	    west_p.setLayout(west_l);
	    
	    material_l2 = new JList<Material>();
	    JScrollPane west_scroll = new JScrollPane();
		west_scroll.setPreferredSize(new Dimension(200,400));
	    west_scroll.getViewport().add(material_l2);
	    west_p.add(west_scroll, BorderLayout.WEST);
	    Material[] materials_array = new Material[materials.size()];
	    material_l2.setListData(materials.toArray(materials_array));;
	    
	    // - for adding materials
	    JPanel west_east_p = new JPanel();
	    GridLayout west_east_l = new GridLayout(22, 1);
	    west_east_p.setLayout(west_east_l);
	    m_name = new JTextField();
	    m_grade_points = new JTextField();
	    JButton add_material_b = new JButton("Add");
	    add_material_b.addActionListener(this);
	    add_material_b.setActionCommand("ADD MATERIAL");
	    JButton remove_material_b = new JButton("Remove");
	    remove_material_b.addActionListener(this);
	    remove_material_b.setActionCommand("REMOVE MATERIAL");
	    JLabel name_l = new JLabel("Name : ");
	    name_l.setToolTipText("Name of assignment/material.");
	    JLabel assignments_label = new JLabel("ASSIGNMENTS");
	    JLabel grade_points_l = new JLabel("Grade Points: ");
	    grade_points_l.setToolTipText("Total grade point value within the class for this assignment.");
	    
	    west_east_p.add(assignments_label);
	    west_east_p.add(name_l);
	    west_east_p.add(m_name);
	    west_east_p.add(grade_points_l);
	    west_east_p.add(m_grade_points);
	    west_east_p.add(add_material_b);
	    west_east_p.add(remove_material_b);
	    west_east_p.add(new JLabel());
	    
	    // - for saving/loading
	    JButton load_material = new JButton("Load");
	    load_material.addActionListener(this); // whenever the combo box picks up an action
	    load_material.setActionCommand("LOAD");
	    west_east_p.add(load_material);
	    
	    JButton save_material = new JButton("Save");
	    save_material.addActionListener(this); // whenever the combo box picks up an action
	    save_material.setActionCommand("SAVE");
	    west_east_p.add(save_material);
	    west_p.add(west_east_p, BorderLayout.EAST);
	    
	    // EAST - for managing assignment/material DETAILS
	    JPanel east_p = new JPanel();
	    BorderLayout east_l = new BorderLayout();
	    east_p.setLayout(east_l);
	    
	    // - display problems for a given material
	    JPanel east_east_p = new JPanel();
	    BorderLayout east_east_l = new BorderLayout();
	    east_east_p.setLayout(east_east_l);
	    east_p.add(east_east_p, BorderLayout.EAST);
	    
	    JButton display_problem = new JButton("Display Selected");
	    display_problem.addActionListener(this); // whenever the combo box picks up an action
	    display_problem.setActionCommand("DISPLAY PROBLEM");
	    east_east_p.add(display_problem, BorderLayout.PAGE_START);
	    
	    east_north_scroll = new JScrollPane();
	    east_north_scroll.setPreferredSize(new Dimension(200,200));
	    east_east_p.add(east_north_scroll, BorderLayout.CENTER);
	    
	    problems_l = new JList<Problem>();
	    
	    // - display ABET criteria for selected problem
	    east_south_text = new JTextPane();
	    east_south_text.setPreferredSize(new Dimension(200,200));
	    east_south_text.setEditable(false);
	    east_east_p.add(east_south_text, BorderLayout.PAGE_END);
	    
	    // - select a material to add problems to
	    JPanel east_west_p = new JPanel();
	    GridLayout east_west_l = new GridLayout(22, 1);
	    east_west_p.setLayout(east_west_l);
	    east_combo = new JComboBox<Material>();
	    east_combo.addActionListener(this); // whenever the combo box picks up an action
	    east_combo.setActionCommand("MATERIAL SELECT");
	    
	    // - attribute boxes for a problem for a given material
	    JLabel prob_label = new JLabel("PROBLEMS");
	    JLabel prob_name_l = new JLabel("Name: ");
	    prob_name = new JTextField();
	    JLabel prob_pv_l = new JLabel("Point Value: ");
	    prob_points = new JTextField("0");
	    
	    JLabel prob_crit1_l = new JLabel("% Criteria 1:");
	    prob_crit1 = new JTextField("0");
	    prob_crit1.setToolTipText("Percentage of problem that satisfies ABET criteria 1.");
	    JLabel prob_crit2_l = new JLabel("% Criteria 2:");
	    prob_crit2 = new JTextField("0");
	    prob_crit2.setToolTipText("Percentage of problem that satisfies ABET criteria 2.");
	    JLabel prob_crit3_l = new JLabel("% Criteria 3:");
	    prob_crit3 = new JTextField("0");
	    prob_crit3.setToolTipText("Percentage of problem that satisfies ABET criteria 3.");
	    JLabel prob_crit4_l = new JLabel("% Criteria 4:");
	    prob_crit4 = new JTextField("0");
	    prob_crit4.setToolTipText("Percentage of problem that satisfies ABET criteria 4.");
	    JLabel prob_crit5_l = new JLabel("% Criteria 5:");
	    prob_crit5 = new JTextField("0");
	    prob_crit5.setToolTipText("Percentage of problem that satisfies ABET criteria 5.");
	    JLabel prob_crit6_l = new JLabel("% Criteria 6:");
	    prob_crit6 = new JTextField("0");
	    prob_crit6.setToolTipText("Percentage of problem that satisfies ABET criteria 6.");
	    JLabel prob_crit7_l = new JLabel("% Criteria 7:");
	    prob_crit7 = new JTextField("0");
	    prob_crit7.setToolTipText("Percentage of problem that satisfies ABET criteria 7.");
	    
	    east_west_p.add(prob_label);
	    east_west_p.add(east_combo);
	    east_west_p.add(prob_name_l);
	    east_west_p.add(prob_name);
	    east_west_p.add(prob_pv_l);
	    east_west_p.add(prob_points);
	    east_west_p.add(prob_crit1_l);
	    east_west_p.add(prob_crit1);
	    east_west_p.add(prob_crit2_l);
	    east_west_p.add(prob_crit2);
	    east_west_p.add(prob_crit3_l);
	    east_west_p.add(prob_crit3);
	    east_west_p.add(prob_crit4_l);
	    east_west_p.add(prob_crit4);
	    east_west_p.add(prob_crit5_l);
	    east_west_p.add(prob_crit5);
	    east_west_p.add(prob_crit6_l);
	    east_west_p.add(prob_crit6);
	    east_west_p.add(prob_crit7_l);
	    east_west_p.add(prob_crit7);
	    
	    JButton add_problem = new JButton("Add");
	    add_problem.addActionListener(this); // whenever the combo box picks up an action
	    add_problem.setActionCommand("ADD PROBLEM");
	    east_west_p.add(add_problem);
	    
	    JButton remove_problem = new JButton("Remove Selected");
	    remove_problem.addActionListener(this); // whenever the combo box picks up an action
	    remove_problem.setActionCommand("REMOVE PROBLEM");
	    east_west_p.add(remove_problem);
	    
	    east_p.add(east_west_p, BorderLayout.WEST);
	    
	    javax.swing.ImageIcon img_icon = new javax.swing.ImageIcon("resources/abet.png");
		materials_frame.setIconImage(img_icon.getImage());
	    
	    // add each panel to the frame
	    materials_frame.add(north_p, BorderLayout.NORTH);
	    materials_frame.add(west_p, BorderLayout.WEST);
	    materials_frame.add(east_p, BorderLayout.EAST);
	}

	public void actionPerformed(ActionEvent ae) 
	{
		if (ae.getActionCommand().equals("ADD"))
		{ // go to the "add materials" frame
			this.setVisible(false);
			materials_frame.setVisible(true);
		}
		else if (ae.getActionCommand().equals("GO BACK"))
		{ // go back to the main menu
			this.setVisible(true);
			materials_frame.setVisible(false);
		}
		else if (ae.getActionCommand().equals("ADD MATERIAL"))
		{ // adds a material with the given information
			Material m = new Material(m_name.getText(), Float.parseFloat(m_grade_points.getText()));
			materials.add(m);
			Material[] materials_array = new Material[materials.size()];
		    material_l.setListData(materials.toArray(materials_array));
		    material_l2.setListData(materials.toArray(materials_array));

		    east_combo.addItem(m);
		}
		else if (ae.getActionCommand().equals("REMOVE MATERIAL"))
		{ // removes a material that has been added to the list
			int index = material_l2.getSelectedIndex();
			materials.remove(index);
			
			Material[] materials_array = new Material[materials.size()];
		    material_l.setListData(materials.toArray(materials_array));
		    material_l2.setListData(materials.toArray(materials_array));
		    
		    east_combo.removeItemAt(index);
		}
		else if (ae.getActionCommand().equals("MATERIAL SELECT"))
		{ // when a material is selected, change to that material's problems
			Material selected = (Material) east_combo.getSelectedItem();
			Problem[] problem_l_array = new Problem[selected.getProblems().size()];
			problems_l.setListData(selected.getProblems().toArray(problem_l_array));
		    east_north_scroll.getViewport().add(problems_l);
		}
		else if (ae.getActionCommand().equals("ADD PROBLEM"))
		{ // adds a problem to the selected material with given input
			float sum_percentages = Float.parseFloat(prob_crit1.getText()) + Float.parseFloat(prob_crit2.getText()) + Float.parseFloat(prob_crit3.getText()) +
					Float.parseFloat(prob_crit4.getText()) + Float.parseFloat(prob_crit5.getText()) + Float.parseFloat(prob_crit6.getText()) + Float.parseFloat(prob_crit7.getText());
			
			if(sum_percentages <= 100)
			{ // percentages add up to 100
				if (sum_percentages == 0 || sum_percentages == 100)
				{
					Material selected = (Material) east_combo.getSelectedItem();
					
					Problem new_prob = new Problem(prob_name.getText(), Float.parseFloat(prob_points.getText()), Float.parseFloat(prob_crit1.getText()), Float.parseFloat(prob_crit2.getText()), Float.parseFloat(prob_crit3.getText()),
							Float.parseFloat(prob_crit4.getText()), Float.parseFloat(prob_crit5.getText()), Float.parseFloat(prob_crit6.getText()), Float.parseFloat(prob_crit7.getText()));
					selected.addProblem(new_prob);
					
					Problem[] problem_l_array = new Problem[selected.getProblems().size()];
					problems_l.setListData(selected.getProblems().toArray(problem_l_array));
				    east_north_scroll.getViewport().add(problems_l);
					
				    east_south_text.setText(new_prob.toStringABET());
				}
				else {JOptionPane.showMessageDialog(materials_frame, "Percentages don't add up to 100%");}
			}
			else {JOptionPane.showMessageDialog(materials_frame, "Percentages add up to more than 100%");}
		}
		else if (ae.getActionCommand().equals("REMOVE PROBLEM"))
		{ // adds a problem to the selected material with given input
			Material selected_m = (Material) east_combo.getSelectedItem();
			
			int index = problems_l.getSelectedIndex();
			selected_m.removeProblem(index);
			
			Problem[] problem_l_array = new Problem[selected_m.getProblems().size()];
			problems_l.setListData(selected_m.getProblems().toArray(problem_l_array));
		    east_north_scroll.getViewport().add(problems_l);
		}
		else if (ae.getActionCommand().equals("DISPLAY PROBLEM"))
		{ // display ABET criteria and point values for problem  
			Problem selected_p = problems_l.getSelectedValue();
			east_south_text.setText(selected_p.toStringABET());
		}
		else if (ae.getActionCommand().equals("LOAD"))
		{ // load up a saved set of material data
			ABETLoadSave ls = new ABETLoadSave();
			try 
			{
				ArrayList<Material> loaded_materials = ls.load("materials_data.txt");
				materials = loaded_materials;
				
				Material[] materials_array = new Material[materials.size()];
				material_l.setListData(materials.toArray(materials_array));
			    material_l2.setListData(materials.toArray(materials_array));
			    
			    try{east_combo.removeAllItems();}
			    catch (Exception e) {};
			    
			    for(Material m : materials)
			    {
			    	east_combo.addItem(m);
			    }
			    Material selected = (Material) east_combo.getSelectedItem();
				
				Problem[] problem_l_array = new Problem[selected.getProblems().size()];
				problems_l.setListData(selected.getProblems().toArray(problem_l_array));
			    east_north_scroll.getViewport().add(problems_l);
				
				JOptionPane.showMessageDialog(this, "Assignment/material data loaded.");
			}
			catch (IOException e) 
			{
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "Could not find saved file.");
			}
		}
		else if (ae.getActionCommand().equals("SAVE"))
		{ //  save all material data to a file
			if(materials.size() > 0)
			{
				ArrayList<String> lines = new ArrayList<String>();
				lines.add(Integer.toString(materials.size())); // need to know how many materials to read
				for(Material m : materials)
				{ // get each material
					ArrayList<String> material_lines = m.toStringArray();
					for(String s : material_lines)
					{ // add material lines to file
						lines.add(s);
					}
				}
				ABETLoadSave ls = new ABETLoadSave();
				try {ls.save("materials_data.txt", lines);} 
				catch (IOException e) {e.printStackTrace();}
				
				JOptionPane.showMessageDialog(this, "Assignment/material data saved.");
			}
			else {JOptionPane.showMessageDialog(this, "No assignments/materials added to save!");}
		}
		else if(ae.getActionCommand().equals("LOAD GRADES"))
		{
			try 
			{
				ABETLoadSave als = new ABETLoadSave();
				students = als.getGrades(materials, "sample_input.txt");
				JOptionPane.showMessageDialog(this, "Student grade data has been loaded.");
			}
			catch (IOException e) {e.printStackTrace();}
		}
		else if(ae.getActionCommand().equals("CALCULATE"))
		{
			for(Student student : students)
		    {
		    	student.calculateABETvalues();
		    }
			ArrayList<Float> abet_averages = getABETAverages(students);
			
			String lines = new String();
			for(int i = 0; i < 7; i++)
		    { // add to text pane
				lines = lines + "Avg Criteria " + (i + 1) + ": " + abet_averages.get(i) + "\n";
		    }
			abet_results.setText(lines);
		}
	}
	
	public ArrayList<Float> getABETAverages(ArrayList<Student> students)
	{
		ArrayList<Float> abet_averages = new ArrayList<Float>();
	    for(int i = 0; i <= 7; i++)
	    {abet_averages.add((float) 0);}
	    
	    for(int i = 0; i < students.size(); i++)
	    { // for each student, add the points they earned in each criteria
	    	ArrayList<Float> abet_values = students.get(i).getABETvalues();
	    	for(int j = 0; j < 7; j++)
	    	{
	    		abet_averages.set(j, abet_averages.get(j) + abet_values.get(j));
	    	}
	    }
	    for(int i = 0; i < 7; i++)
	    { // divide sum of all points collectively earned by the total number of students, an average number of points earned
	    	abet_averages.set(i, abet_averages.get(i) / students.size());
	    }
	    
	    float[] points_possible = new float[7];
	    for(int i = 0; i < 7; i++)
	    { // find total number of each criteria points possible
	    	for(Material m : materials)
	    	{
	    		float[] m_points = m.getCriteriaSums();
	    		points_possible[i] = points_possible[i] + m_points[i];
	    	}
	    }
	    
	    for(int i = 0; i < 7; i++)
	    { // find the class average
	    	abet_averages.set(i, abet_averages.get(i) / points_possible[i]);
	    }
	    
    	return abet_averages;
	}

	public void draw(Graphics g, int width, int height) 
	{
		
	}

	public void mouseClicked(int x, int y) 
	{
		
	}

	public void keyPressed(char key) 
	{
		
	}
	
}
