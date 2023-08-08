package Notepad;

import java.awt.Font;

public class Function_Format {
	
	Main1 main1;
	Font arial,comicSansMS,timesNewRoman,lucidacalligraphy,conpl,conit;
	String selectedFont;
	
	public Function_Format(Main1 main1)
	{
		this.main1=main1;
	}
	
	public void wordwrap()
	{
		if(main1.wordwrapOn==false)
		{
			main1.wordwrapOn=true;
			main1.textarea.setLineWrap(true);
			main1.textarea.setWrapStyleWord(true);
			main1.iwordwrap.setText("Word Wrap: On");
		}
		else if(main1.wordwrapOn==true)
		{
			main1.wordwrapOn=false;
			main1.textarea.setLineWrap(false);
			main1.textarea.setWrapStyleWord(false);
			main1.iwordwrap.setText("Word Wrap: Off");
		}
	}
	
	public void createfont(int fontsize)
	{
		arial=new Font("Arial",Font.PLAIN,fontsize);
		comicSansMS=new Font("Comic Sans MS",Font.PLAIN,fontsize);
		timesNewRoman=new Font("Times New Roman",Font.PLAIN,fontsize);
		lucidacalligraphy=new Font("Lucida Calligraphy",Font.PLAIN,fontsize);
		conpl=new Font("Consolas Plain",Font.PLAIN,fontsize);
		conit=new Font("Consolas Italic",Font.ITALIC,fontsize);
		
		setfont(selectedFont);
	}
	
	public void setfont(String font)
	{
		selectedFont=font;
		switch(selectedFont)
		{
		case "Arial": main1.textarea.setFont(arial);
		break;
		case "Times New Roman": main1.textarea.setFont(timesNewRoman);
		break;
		case "Comic Sans MS": main1.textarea.setFont(comicSansMS);
		break;
		case "Lucida Calligraphy": main1.textarea.setFont(lucidacalligraphy);
		break;
		case "Consolas Plain": main1.textarea.setFont(conpl);
		break;
		case "Consolas Italic": main1.textarea.setFont(conit);
		break;
		}
	}
}
