package Notepad;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("unused")
public class Main1 implements ActionListener {
	
	JFrame window;
	JTextArea textarea;
	JScrollPane scrollpanel;
	JMenuBar menubar;
	JMenu menuFile,menuedit,menuformat,menucolor;
	JMenuItem inew,isave,isaveas,iopen,iexit,iwordcount;
	JMenuItem icolor1,icolor2,icolor3,icolor4,icolor5,icolor6,icolor7,icolor8,icolor9;
	JMenuItem iundo,iredo;
	
	boolean wordwrapOn=false;
	
	Function_File file=new Function_File(this);
	Note nt=new Note(this);
	Function_Format format=new Function_Format(this);
	Function_Color color=new Function_Color(this);
	Function_Edit edit=new Function_Edit(this);
	Function_Shortcuts keys=new Function_Shortcuts(this);
	
	UndoManager un=new UndoManager();
	
	JMenuItem iwordwrap,ilcalligraphy,conpl,conit;
	JMenu ifont,ifontsize,consol;
	JMenuItem ifontArial,ifontCSMS,ifontTNR,ifontsize8,ifontsize10,ifontsize12,ifontsize14,ifontsize16,ifontsize18,ifontsize20,ifontsize22,ifontsize24,ifontsize26,ifontsize28;
	
	public Main1()
	{
		createwindow();
		createTextArea();
		createmenubar();
		createFileMenu();
		createFileFormat();
		createcolor();
		createedit();
		
		format.selectedFont="Arial";
		format.createfont(12);
		format.wordwrap();
		color.changecolor("White");
		window.setVisible(true);
	}
	
	public void createwindow()
	{
		window=new JFrame("NotePad");
		window.setSize(1000,600);
		window.setLocation(250,50);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createTextArea()
	{
		textarea=new JTextArea();
		textarea.getDocument().addUndoableEditListener(new UndoableEditListener() {
			public void undoableEditHappened(UndoableEditEvent e)
			{
				un.addEdit(e.getEdit());
			}
		});
		textarea.addKeyListener(keys);
		scrollpanel=new JScrollPane(textarea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpanel.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollpanel);
	}
	
	public void createmenubar()
	{
		menubar=new JMenuBar();
		window.setJMenuBar(menubar);
		menuFile=new JMenu("File");
		menubar.add(menuFile);
		menuedit=new JMenu("Edit");
		menubar.add(menuedit);
		menuformat=new JMenu("Format");
		menubar.add(menuformat);
		menucolor=new JMenu("Color");
		menubar.add(menucolor);
	}
	
	public void createFileMenu()
	{
		inew=new JMenuItem("New");
		inew.addActionListener(this);
		inew.setActionCommand("New");
		menuFile.add(inew);
		
		iopen=new JMenuItem("Open");
		iopen.addActionListener(this);
		iopen.setActionCommand("Open");
		menuFile.add(iopen);
		
		isave=new JMenuItem("Save");
		isave.addActionListener(this);
		isave.setActionCommand("Save");
		menuFile.add(isave);
		
		isaveas=new JMenuItem("Save As");
		isaveas.addActionListener(this);
		isaveas.setActionCommand("Save As");
		menuFile.add(isaveas);
		
		iwordcount=new JMenuItem("WordCount");
		iwordcount.addActionListener(this);
		iwordcount.setActionCommand("Word Count");
		menuFile.add(iwordcount);
		
		iexit=new JMenuItem("Exit");
		iexit.addActionListener(this);
		iexit.setActionCommand("Exit");
		menuFile.add(iexit);
	}
	
	public void createFileFormat()
	{
		iwordwrap=new JMenuItem("Word Wrap: Off");
		iwordwrap.addActionListener(this);
		iwordwrap.setActionCommand("Word Wrap");
		menuformat.add(iwordwrap);
		
		ifont=new JMenu("Font");
		menuformat.add(ifont);
		
		consol=new JMenu("Consolas");
		ifont.add(consol);
		
		conpl=new JMenuItem("Plain");
		conpl.addActionListener(this);
		conpl.setActionCommand("Consolas Plain");
		consol.add(conpl);
		
		conit=new JMenuItem("Italic");
		conit.addActionListener(this);
		conit.setActionCommand("Consolas Italic");
		consol.add(conit);
		
		ifontArial=new JMenuItem("Arial");
		ifontArial.addActionListener(this);
		ifontArial.setActionCommand("Arial");
		ifont.add(ifontArial);
		
		ifontTNR=new JMenuItem("Times New Roman");
		ifontTNR.addActionListener(this);
		ifontTNR.setActionCommand("Times New Roman");
		ifont.add(ifontTNR);
		
		ifontCSMS=new JMenuItem("Comic Sans MS");
		ifontCSMS.addActionListener(this);
		ifontCSMS.setActionCommand("Comic Sans MS");
		ifont.add(ifontCSMS);
		
		ilcalligraphy=new JMenuItem("Lucida Calligraphy");
		ilcalligraphy.addActionListener(this);
		ilcalligraphy.setActionCommand("Lucida Calligraphy");
		ifont.add(ilcalligraphy);
		
		ifontsize=new JMenu("Font Size");
		menuformat.add(ifontsize);
		
		ifontsize8=new JMenuItem("8");
		ifontsize8.addActionListener(this);
		ifontsize8.setActionCommand("8");
		ifontsize.add(ifontsize8);
		
		ifontsize10=new JMenuItem("10");
		ifontsize10.addActionListener(this);
		ifontsize10.setActionCommand("10");
		ifontsize.add(ifontsize10);
		
		ifontsize12=new JMenuItem("12");
		ifontsize12.addActionListener(this);
		ifontsize12.setActionCommand("12");
		ifontsize.add(ifontsize12);
		
		ifontsize14=new JMenuItem("14");
		ifontsize14.addActionListener(this);
		ifontsize14.setActionCommand("14");
		ifontsize.add(ifontsize14);
		
		ifontsize16=new JMenuItem("16");
		ifontsize16.addActionListener(this);
		ifontsize16.setActionCommand("16");
		ifontsize.add(ifontsize16);
		
		ifontsize18=new JMenuItem("18");
		ifontsize18.addActionListener(this);
		ifontsize18.setActionCommand("18");
		ifontsize.add(ifontsize18);
		
		ifontsize20=new JMenuItem("20");
		ifontsize20.addActionListener(this);
		ifontsize20.setActionCommand("20");
		ifontsize.add(ifontsize20);
		
		ifontsize22=new JMenuItem("22");
		ifontsize22.addActionListener(this);
		ifontsize22.setActionCommand("22");
		ifontsize.add(ifontsize22);
		
		ifontsize24=new JMenuItem("24");
		ifontsize24.addActionListener(this);
		ifontsize24.setActionCommand("24");
		ifontsize.add(ifontsize24);
		
		ifontsize26=new JMenuItem("26");
		ifontsize26.addActionListener(this);
		ifontsize26.setActionCommand("26");
		ifontsize.add(ifontsize26);
		
		ifontsize28=new JMenuItem("28");
		ifontsize28.addActionListener(this);
		ifontsize28.setActionCommand("28");
		ifontsize.add(ifontsize28);
	}
	
	public void createedit()
	{
		iundo=new JMenuItem("Undo");
		iundo.addActionListener(this);
		iundo.setActionCommand("Undo");
		menuedit.add(iundo);
		
		iredo=new JMenuItem("Redo");
		iredo.addActionListener(this);
		iredo.setActionCommand("Redo");
		menuedit.add(iredo);
	}
	
	public void createcolor()
	{
		icolor1=new JMenuItem("White");
		icolor1.addActionListener(this);
		icolor1.setActionCommand("White");
		menucolor.add(icolor1);
		
		icolor2=new JMenuItem("Black");
		icolor2.addActionListener(this);
		icolor2.setActionCommand("Black");
		menucolor.add(icolor2);
		
		icolor3=new JMenuItem("Blue");
		icolor3.addActionListener(this);
		icolor3.setActionCommand("Blue");
		menucolor.add(icolor3);
		
		icolor4=new JMenuItem("Green");
		icolor4.addActionListener(this);
		icolor4.setActionCommand("Green");
		menucolor.add(icolor4);
		
		icolor5=new JMenuItem("Gray");
		icolor5.addActionListener(this);
		icolor5.setActionCommand("Gray");
		menucolor.add(icolor5);
		
		icolor6=new JMenuItem("Red");
		icolor6.addActionListener(this);
		icolor6.setActionCommand("Red");
		menucolor.add(icolor6);
		
		icolor7=new JMenuItem("Cyan");
		icolor7.addActionListener(this);
		icolor7.setActionCommand("Cyan");
		menucolor.add(icolor7);
		
		icolor8=new JMenuItem("Orange");
		icolor8.addActionListener(this);
		icolor8.setActionCommand("Orange");
		menucolor.add(icolor8);
		
		icolor9=new JMenuItem("Magenta");
		icolor9.addActionListener(this);
		icolor9.setActionCommand("Magenta");
		menucolor.add(icolor9);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main1();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command=e.getActionCommand();
		switch(command) {
		case "New": file.newFile();
		break;
		case "Open": file.open();
		break;
		case "Save": file.save();
		break;
		case "Save As": file.saveas();
		break;
		case "Word Count": nt.createbox();
		break;
		case "Exit": file.exit();
		break;
		case "Word Wrap": format.wordwrap();
		break;
		case "Arial": format.setfont(command);
		break;
		case "Times New Roman": format.setfont(command);
		break;
		case "Comic Sans MS": format.setfont(command);
		break;
		case "Lucida Calligraphy": format.setfont(command);
		break;
		case "Consolas Plain": format.setfont(command);
		break;
		case "Consolas Italic": format.setfont(command);
		break;
		case "8": format.createfont(8);
		break;
		case "10": format.createfont(10);
		break;
		case "12": format.createfont(12);
		break;
		case "14": format.createfont(14);
		break;
		case "16": format.createfont(16);
		break;
		case "18": format.createfont(18);
		break;
		case "20": format.createfont(20);
		break;
		case "22": format.createfont(22);
		break;
		case "24": format.createfont(24);
		break;
		case "26": format.createfont(26);
		break;
		case "28": format.createfont(28);
		break;
		case "White": color.changecolor(command);
		break;
		case "Black": color.changecolor(command);
		break;
		case "Blue": color.changecolor(command);
		break;
		case "Green": color.changecolor(command);
		break;
		case "Red": color.changecolor(command);
		break;
		case "Cyan": color.changecolor(command);
		break;
		case "Orange": color.changecolor(command);
		break;
		case "Magenta": color.changecolor(command);
		break;
		case "Gray": color.changecolor(command);
		break;
		case "Undo": edit.undo();
		break;
		case "Redo": edit.redo();
		break;
		}
	}

}
