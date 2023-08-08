package Notepad;

import java.awt.Color;

public class Function_Color {

	Main1 main1;
	public Function_Color(Main1 main1)
	{
		this.main1=main1;
	}
	
	public void changecolor(String color)
	{
		switch(color) {
		case "White": main1.window.getContentPane().setBackground(Color.white);
		main1.textarea.setBackground(Color.white);
		main1.textarea.setForeground(Color.black);
		break;
		case "Black": main1.window.getContentPane().setBackground(Color.black);
		main1.textarea.setBackground(Color.black);
		main1.textarea.setForeground(Color.white);
		break;
		case "Blue": main1.window.getContentPane().setBackground(Color.blue);
		main1.textarea.setBackground(Color.blue);
		main1.textarea.setForeground(Color.white);
		break;
		case "Green": main1.window.getContentPane().setBackground(Color.green);
		main1.textarea.setBackground(Color.green);
		main1.textarea.setForeground(Color.black);
		break;
		case "Gray": main1.window.getContentPane().setBackground(Color.darkGray);
		main1.textarea.setBackground(Color.darkGray);
		main1.textarea.setForeground(Color.yellow);
		break;
		case "Red": main1.window.getContentPane().setBackground(Color.red);
		main1.textarea.setBackground(Color.red);
		main1.textarea.setForeground(Color.black);
		break;
		case "Cyan": main1.window.getContentPane().setBackground(Color.cyan);
		main1.textarea.setBackground(Color.cyan);
		main1.textarea.setForeground(Color.black);
		break;
		case "Orange": main1.window.getContentPane().setBackground(Color.orange);
		main1.textarea.setBackground(Color.orange);
		main1.textarea.setForeground(Color.black);
		break;
		case "Magenta": main1.window.getContentPane().setBackground(Color.magenta);
		main1.textarea.setBackground(Color.magenta);
		main1.textarea.setForeground(Color.blue);
		break;
		}
	}
}
