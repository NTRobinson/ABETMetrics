package Driver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class FileReaderWriter
{
	public FileReaderWriter()
	{
		// nothing needed for construction
	}
	public ArrayList<String> readFile(String name) throws IOException 
	{
		FileInputStream fis = new FileInputStream(name);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
	 
		String line = null;
		ArrayList<String> text = new ArrayList<String>();
		// reads a line, then checks if null
		while ((line = br.readLine()) != null) 
		{ // adds if there is a line
			text.add(line);
		}
		// close the buffered reader
		br.close();
		
		return text;
	}
	public void writeFile(String name, ArrayList<String> lines) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(name);
		
		// BufferedWriter
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		
		for(String s : lines)
		{
			bw.write(s);
			bw.newLine();
		}
		
		bw.close();
	}
}