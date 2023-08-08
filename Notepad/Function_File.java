package Notepad;

import java.awt.FileDialog;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import javax.swing.*;

@SuppressWarnings("unused")
public class Function_File {
	
	Main1 main1;
	String filename;
	String fileaddress;
	
	public Function_File(Main1 main1)
	{
		this.main1=main1;
	}
	
	public void newFile()
	{
		main1.textarea.setText("");
		main1.window.setTitle("New");
		filename=null;
		fileaddress=null;
	}
	
	public void open()
	{
		FileDialog fd=new FileDialog(main1.window,"Open",FileDialog.LOAD);
		fd.setVisible(true);
		
		if(fd.getFile()!=null)
		{
			filename=fd.getFile();
			fileaddress=fd.getDirectory();
			main1.window.setTitle(filename);
		}
		
		System.out.println("File_Address and File_Name "+fileaddress +filename);
		
		try
		{
			BufferedReader br=new BufferedReader(new FileReader(fileaddress+filename));
			main1.textarea.setText("");
			String line=null;
			while((line=br.readLine())!=null)
			{
				main1.textarea.append(line+"\n");
			}
			br.close();
		}
		catch(Exception e)
		{
			System.out.println("Error...File Not Opened.");
		}
	}
	
	public void save()
	{
		if(filename==null)
		{
			saveas();
		}
		else
		{
			try
			{
				FileWriter fw=new FileWriter(fileaddress+filename);
				fw.write(main1.textarea.getText());
				fw.close();
			}
			catch(Exception e)
			{
				System.out.println("Something Went Wrong...Please Try Again.");
			}
		}
	}
	
	public void saveas()
	{
		FileDialog fd=new FileDialog(main1.window,"Save",FileDialog.SAVE);
		fd.setVisible(true);
		
		if(fd.getFile()!=null)
		{
			filename=fd.getFile();
			fileaddress=fd.getDirectory();
			main1.window.setTitle(filename);
		}
		
		try
		{
			FileWriter fw=new FileWriter(fileaddress+filename);
			fw.write(main1.textarea.getText());
			fw.close();
		}
		catch(Exception e)
		{
			System.out.println("Something Went Wrong...Please Try Again.");
		}
	}
	
	public void exit()
	{
		System.exit(0);
	}
}
