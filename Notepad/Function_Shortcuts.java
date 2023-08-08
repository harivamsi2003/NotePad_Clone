package Notepad;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Function_Shortcuts implements KeyListener{
	
	Main1 main1;
	
	public Function_Shortcuts(Main1 main1)
	{
		this.main1=main1;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S)
		{
			main1.file.save();
		}
		if(e.isShiftDown() && e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S)
		{
			main1.file.saveas();
		}
		if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_F)
		{
			main1.menuFile.doClick();
		}
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_N)
		{
			main1.file.newFile();
		}
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Z)
		{
			main1.edit.undo();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
