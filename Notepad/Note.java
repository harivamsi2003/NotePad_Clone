package Notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class Note implements ActionListener{
	
	Main1 main1;
	
	JTextField i1;
	JTextField i2;
	JTextField i3;
	JFrame box;
	JButton b1,b2,b3;
	JLabel l1,l2;
	String filename,fileaddress;
	String s;
	String ch;
	int wordcount=0;
	
	public Note(Main1 main1)
	{	
		this.main1=main1;
	}
	
	public void createbox()
	{	
		box=new JFrame("Word Count");
		box.setSize(850,200);
		box.setLocation(250,50);
		box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		b1=new JButton();
		b1.setBounds(60,40 ,150, 50);
		b2=new JButton();
		b2.setBounds(300,40 ,150, 50);
		b1.setText("Total word count");
		b2.setText("Enter a word");
		b1.addActionListener(this);
		b2.addActionListener(this);
		box.add(b1);
		box.add(b2);
		box.add(b3);
		box.setLayout(null);
		box.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			
			//System.out.println("File_Address and File_Name "+fileaddress +filename);
			//main1.file.saveas();
			FileDialog fd=new FileDialog(main1.window,"Open",FileDialog.LOAD);
			fd.setVisible(true);
			if(fd.getFile()==null)
			{
				main1.file.saveas();
			}
			filename=fd.getFile();
			fileaddress=fd.getDirectory();
			main1.window.setTitle(filename);
			try
			{
				BufferedReader br=new BufferedReader(new FileReader(fileaddress+filename));
				String line;
				wordcount=0;
				while ((line = br.readLine()) != null)
				{
	                String[] words = line.split(" "); // Split the line into words using whitespace as delimiter
	                for (String word : words) {
	                    if (!word.isEmpty()) { // Check if the word is not empty before incrementing word count
	                        wordcount++;
	                    }
	                }
	            }
				br.close();
				System.out.println("Total word count: "+wordcount);
				JOptionPane.showMessageDialog(null,"Total word count is: "+wordcount);
			}
			catch(Exception e1)
			{
				System.out.println("Error...File Not Opened.");
			}
		}
		if(e.getSource()==b2)
		{
			FileDialog fd=new FileDialog(main1.window,"Open",FileDialog.LOAD);
			fd.setVisible(true);
			if(fd.getFile()==null)
			{
				main1.file.saveas();
			}
			filename=fd.getFile();
			fileaddress=fd.getDirectory();
			main1.window.setTitle(filename);
			s=JOptionPane.showInputDialog("Enter your word to search: ");
			try
			{
				BufferedReader br=new BufferedReader(new FileReader(fileaddress+filename));
				String line;
				wordcount=0;
				while ((line = br.readLine()) != null)
				{
	                String[] words = line.split("\\s+"); // Split the line into words using whitespace as delimiter
	                for (String word : words) {
	                    if (!word.isEmpty() && word.equals(s)) { // Check if the word is not empty before incrementing word count
	                        wordcount++;
	                    }
	                }
	            }
				br.close();
				System.out.println("Total word count: "+wordcount);
				JOptionPane.showMessageDialog(null,"Total word count is: "+wordcount);
			}
			catch(Exception e1)
			{
				System.out.println("Error...File Not Opened.");
			}
		}
	}

}
