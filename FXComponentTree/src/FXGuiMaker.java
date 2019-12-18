// Sean MacDonald
// CSE 214 HW5
// takes a text file, generates a tree and provides an interface for the user to manipulate the tree
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class FXGuiMaker
{
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		String choice = "", text = "", type = "", fileName = "";
		int index = 0;
		FXComponentTree tree = new FXComponentTree();
		createTree(tree);
		
		
		System.out.println("Welcome to counterfeit SceneBuilder");
		System.out.println();
		System.out.println("Menu: ");
		System.out.println("	L) Load from file");
		System.out.println("	P) Print tree");
		System.out.println("	C) Move cursor to a child node");
		System.out.println("	A) Add a child");
		System.out.println("	U) Move cursor to parent");
		System.out.println("	E) Edit text");
		System.out.println("	D) Delete child");
		System.out.println("	R) Move cursor to root");
		System.out.println("	S) Save to file");
		System.out.println("	Q) Quit");
		System.out.println();
		
		
		
		do
		{
			choice = choice.toUpperCase();
			
			switch(choice)
			{
			case "L":
				tree = new FXComponentTree();
				System.out.println("Please enter filename or specific file location: ");
				fileName = input.next();
				
				readFromFile(tree, fileName);
				break;
			case "P":
				System.out.println();
				print(tree);
				break;
			case "C":
				System.out.println("Please enter number of child (starting with 1): ");
				index = input.nextInt();
				
				cursorToChild(tree, index);
				break;
			case "A":
				System.out.println("Please select component type (H - HBox, V - VBox, T - TextArea, B - Button, L - Label): ");
				type = input.next();
				System.out.println("Please enter text: ");
				text = input.next();
				System.out.println("Please enter an index: ");
				index = input.nextInt();
				
				addChild(tree, index, text, type);
				break;
			case "U":
				cursorToParent(tree);
				break;
			case "E":
				System.out.println("Please enter new text: ");
				text = input.next();
				setTextAtCursor(tree, text);
				break;
			case "D":
				System.out.println("Please enter number of child (starting with 1): ");
				index = input.nextInt();
				deleteChild(tree, index);
				break;
			case "R":
				cursorToRoot(tree);
				break;
			case "S":
				System.out.println("Please enter a filename");
				fileName = input.next();
				writeToFile(tree, fileName);
				break;
			}
			
			
			if(!choice.equalsIgnoreCase("Q"))
			{
				System.out.println("Please select an option");
				
				choice = input.next();
			}
			
		}
		while(!choice.equalsIgnoreCase("Q"));
		
		
		System.out.println("Make like a tree and leave!!!!!!!!!!");
		
		
		
		
		
		
		
		
		
		// Method testing
		/*
		FXComponentTree tree1 = new FXComponentTree();
		createTree(tree1); // create tree and make AnchorPane with cursor on it
		print(tree1);
		addChild(tree1, 1, "Child 1", "V"); // add a child to AnchorPane
		print(tree1);
		cursorToChild(tree1, 1); // move cursor to Child 1
		print(tree1);
		addChild(tree1, 1, "Child's Child 1", "H"); // add child to child 1
		print(tree1);
		cursorToChild(tree1, 1); // move cursor to child's child 1
		print(tree1);
		cursorToParent(tree1); // move cursor to Child 1
		print(tree1);
		setTextAtCursor(tree1, "New Child 1"); // change Child 1 text to New Child 1
		print(tree1);
		deleteChild(tree1, 1); // remove Child's child 1
		print(tree1);
		cursorToRoot(tree1); // set cursor to root
		print(tree1);
		FXComponentTree tree2 = new FXComponentTree();
		readFromFile(tree2, "hw5sample(2).txt");
		print(tree2);
		FXComponentTree tree3 = new FXComponentTree();
		readFromFile(tree3, "C:\\Users\\Sean\\eclipse-workspace\\CSE214 HW5\\src\\hw5sample(2).txt");
		print(tree3);
		*/
		
		

		
	}
	

	
	// METHODS
	
	public static void print(FXComponentTree tree) // prints inputed tree
	{
		System.out.println(tree.toString());
	}
	
	public static void cursorToChild(FXComponentTree tree, int index) // moves cursor to child of inputed tree at specified index if possible
	{
		tree.cursorToChild(index);
		
		if(index > 0 && index <= tree.getCursor().getMaxChildren())
		{
			if(tree.getCursor().getChildren()[index - 1] != null)
				{
				System.out.print("Cursor moved to ");
			
				if(tree.getCursor().getText() != null)
					System.out.println(tree.getCursor().toStringg());
				else
					System.out.println(tree.getCursor().toString());
			}
		}
	}
	
	public static void addChild(FXComponentTree tree, int index, String text, String type) // adds child to specified tree if possible
	{
		type = type.toUpperCase();
		FXTreeNode node;
		
		switch(type)
		{
			case "H":
				node = new FXTreeNode(text, ComponentType.HBox);
				tree.addChild(index, node);
				break;
			case "V":
				node = new FXTreeNode(text, ComponentType.VBox);
				tree.addChild(index, node);
				break;
			case "T":
				node = new FXTreeNode(text, ComponentType.TextArea);
				tree.addChild(index, node);
				break;
			case "B":
				node = new FXTreeNode(text, ComponentType.Button);
				tree.addChild(index, node);
				break;
			case "L":
				node = new FXTreeNode(text, ComponentType.Label);
				tree.addChild(index, node);
				break;
			default:
				System.out.println("Invalid component type entered");
				break;	
		}		
	}
	
	public static void createTree(FXComponentTree tree) // makes a basic tree with an AnchorPane root and the cursor starts at the root
	{
		tree.addChild(1, new FXTreeNode(ComponentType.AnchorPane));
		tree.cursorToRoot();
	}
	
	public static void cursorToParent(FXComponentTree tree) // moves cursor to it's parent for specified tree
	{
		tree.cursorToParent();
		
		System.out.print("Cursor moved to ");
		
		if(tree.getCursor().getText() != null)
			System.out.println(tree.getCursor().toStringg());
		else
			System.out.println(tree.getCursor().toString());
	}
	
	public static void setTextAtCursor(FXComponentTree tree, String text) // changes text for cursor's node to the inputed text for specified tree
	{
		tree.setTextAtCursor(text);
		System.out.println("Text edited");
	}
	
	public static void deleteChild(FXComponentTree tree, int index) // deletes child of cursor at given index for specified tree
	{	
		if(tree.getCursor().getChildren()[index - 1] != null)
		{
			if(tree.getCursor().getChildren()[index - 1].getText() != null)
				System.out.print(tree.getCursor().getChildren()[index - 1].toStringg());
			else
				System.out.print(tree.getCursor().getChildren()[index - 1].toString());
			System.out.println(" removed");
		}
		tree.deleteChild(index);
	}
	
	public static void cursorToRoot(FXComponentTree tree) // sets cursor to the root of specified tree
	{
		tree.cursorToRoot();
		
		System.out.println("Cursor is at root");
	}
	
	public static void readFromFile(FXComponentTree tree, String fileName)
	{
		File file = new File("");
		
		if(fileName.length() >= 2)
			if(!fileName.substring(0, 2).equals("C:"))
				file = new File("C:\\Users\\Sean\\eclipse-workspace\\CSE214 HW5\\src\\" + fileName);
		else
			file = new File(fileName);
		
		FXComponentTree.readFromFile(tree, file);	
	}
	
	public static void writeToFile(FXComponentTree tree, String filename)
	{
		try {
			FXComponentTree.writeToFile(tree, filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	


	
}
