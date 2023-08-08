package Notepad;

public class Function_Edit {

	Main1 main1;
	
	public Function_Edit(Main1 main1)
	{
		this.main1=main1;
	}
	
	public void undo()
	{
		main1.un.undo();
	}
	
	public void redo()
	{
		main1.un.redo();
	}
}
