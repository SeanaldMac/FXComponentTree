import java.util.Arrays;

// Sean MacDonald
// CSE 214 HW5
// Tree class that holds type component, an array of children, and a string for text
public class FXTreeNode
{
	private String text;
	private ComponentType type;
	private FXTreeNode parent;
	private FXTreeNode [] children;
	final int maxChildren = 10;
	
	public FXTreeNode(String text)
	{
		this.text = text;
		children = new FXTreeNode[maxChildren];
	}
	
	public FXTreeNode(ComponentType type)
	{
		this.type = type;
		children = new FXTreeNode[maxChildren];
	}
	
	public FXTreeNode(String text, ComponentType type)
	{
		this.text = text;
		this.type = type;
		children = new FXTreeNode[maxChildren];
	}
	
	public FXTreeNode()
	{
		children = new FXTreeNode[maxChildren];
	}
	
	public void setText(String text)
	{
		this.text = text;
	}
	
	public ComponentType getType()
	{
		return type;
	}
	
	public void setParent(FXTreeNode parent)
	{
		this.parent = parent;
	}
	
	public FXTreeNode getParent()
	{
		return parent;
	}
	
	public FXTreeNode[] getChildren()
	{
		return children;
	}
	
	public int getMaxChildren()
	{
		return maxChildren;
	}
	
	public String getText()
	{
		return text;
	}
	
	@Override
	public String toString()
	{
		if(text != null)
			return "   +--" + type + ": " + text + "\n";
		
		return "" + type + "\n";
	}
	
	public String toStringg()
	{
		return "" + type + ": " + text;
	}


	
	
	
	
	
	
	
}
