// Sean MacDonald
// CSE 214 HW5
// tree manager class for the FXComponent tree
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FXComponentTree
{
	private FXTreeNode root;
	private FXTreeNode cursor;
	
	public void cursorToRoot() // cursor set to root
	{
		cursor = root;
	}
	
	public void deleteChild(int index) // deletes child at specified index, including all branching children of the deleted child
	{
		if(index > 0 && index <= cursor.getMaxChildren()) // within the boundaries of the node's array of children
		{
			if(cursor.getChildren()[index - 1] != null) // there is a child at specified index
			{
				cursor.getChildren()[index - 1] = null;
				
				for(int i = index - 1; i < cursor.getMaxChildren() - 1; i++) // shifts all children, if any, past the deleted child to the left to cover the hole made
				{
						cursor.getChildren()[i] = cursor.getChildren()[i + 1];
						
						if(cursor.getChildren()[cursor.getMaxChildren() - 1] != null) // if array was full, will empty the last spot
							cursor.getChildren()[cursor.getMaxChildren() - 1] = null;
				}
			}
			else // no child to delete at index
				System.out.println("There is no child at the inputted index");
		}
		else // outside array boundaries
			System.out.println("Index given is outside of children array boundaries");
	}
	
	public void addChild(int index, FXTreeNode node) // adds child in cursor's array of children at specified index
	{ 
		if(root == null)
			root = node;
		else
		{
			if(index > 0 && index <= cursor.getMaxChildren()) // within the boundaries of the node's array of children
			{
				if(cursor.getChildren()[cursor.getMaxChildren() - 1] == null) // children array is not full
				{
					if(cursor.getChildren()[index - 1] != null) // there's already a child at index, shifts them over if there's space
					{
						for(int i = cursor.getMaxChildren() - 1; i > index - 1; i--) // shifts children to the right
						{
							if(cursor.getChildren()[i - 1] != null)
							{
								cursor.getChildren()[i] = cursor.getChildren()[i - 1];
							}
						}
						cursor.getChildren()[index - 1] = node;
						
						node.setParent(cursor);
					}
					else // child at index is null
					{
						cursor.getChildren()[index - 1] = node;		
						
						node.setParent(cursor);
					}
				}
				else // array is full
					System.out.println("Children array is full and cannot be added to");			
			}
			else // outside array boundaries
				System.out.println("Index given is outside of children array boundaries");
		}	
	}
	
	public void setTextAtCursor(String text) // sets text of node that cursor is at
	{
		cursor.setText(text);
	}
	
	public void cursorToChild(int index) // sets cursor to child at given index
	{
		if(index > 0 && index <= cursor.getMaxChildren()) // within the boundaries of the node's array of children
		{
			if(cursor.getChildren()[index - 1] != null) // there is a child at specified index
			{
				cursor = cursor.getChildren()[index - 1];
			}
			else // no child at index
				System.out.println("There is no child at the inputted index");	
		}
		else // outside array boundaries
			System.out.println("Index given is outside of children array boundaries");		
	}
	
	public void cursorToParent() // sets cursor to parent
	{
		if(cursor != root)
			cursor = cursor.getParent();
		else
			System.out.println("Cursor is at root and therefore has no parent");
	}
	
	public static void readFromFile(FXComponentTree tree, File file)
	{
		// BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		try(BufferedReader br = new BufferedReader(new FileReader(file)))
		{
			String line;
			while((line = br.readLine()) != null)
			{				
				if(tree.getRoot() != null)
					tree.cursorToRoot();
				
				for(int i = 0; i < line.length() - 1; i++)
				{
					if(Character.isDigit(line.charAt(0)) && line.charAt(1) == ' ')
					{
						tree.addChild(1, new FXTreeNode(ComponentType.AnchorPane));
						tree.cursorToRoot();
						break; // ends for loop
					}
					if(line.charAt(i) == ' ')
					{
						switch(Character.toUpperCase(line.charAt(i + 1)))
						{
							case 'H':
								if(line.charAt(i + 4) != line.charAt(line.length() - 1))
									tree.addChild(Character.getNumericValue(line.charAt(i - 1)) + 1, new FXTreeNode(line.substring(i + 6, line.length()), ComponentType.HBox));  // Complete switch later
								else
									tree.addChild(Character.getNumericValue(line.charAt(i - 1)) + 1, new FXTreeNode("", ComponentType.HBox));
								break;
							case 'V':
								if(line.charAt(i + 4) != line.charAt(line.length() - 1))
									tree.addChild(Character.getNumericValue(line.charAt(i - 1)) + 1, new FXTreeNode(line.substring(i + 6, line.length()), ComponentType.VBox));  // Complete switch later
								else
									tree.addChild(Character.getNumericValue(line.charAt(i - 1)) + 1, new FXTreeNode("", ComponentType.VBox));
								break;
							case 'T':
								if(line.charAt(i + 8) != line.charAt(line.length() - 1))
									tree.addChild(Character.getNumericValue(line.charAt(i - 1)) + 1, new FXTreeNode(line.substring(i + 10, line.length()), ComponentType.TextArea));  // Complete switch later
								else
									tree.addChild(Character.getNumericValue(line.charAt(i - 1)) + 1, new FXTreeNode("", ComponentType.TextArea));
								break;
							case 'B':
								if(line.charAt(i + 6) != line.charAt(line.length() - 1))
									tree.addChild(Character.getNumericValue(line.charAt(i - 1)) + 1, new FXTreeNode(line.substring(i + 8, line.length()), ComponentType.Button));  // Complete switch later
								else
									tree.addChild(Character.getNumericValue(line.charAt(i - 1)) + 1, new FXTreeNode("", ComponentType.Button));
								break;
							case 'L':
								if(line.charAt(i + 5) != line.charAt(line.length() - 1))
									tree.addChild(Character.getNumericValue(line.charAt(i - 1)) + 1, new FXTreeNode(line.substring(i + 7, line.length()), ComponentType.Label));  // Complete switch later
								else
									tree.addChild(Character.getNumericValue(line.charAt(i - 1)) + 1, new FXTreeNode("", ComponentType.Label));
								break;
						}
						
						tree.cursorToRoot();
						break; // ends the for loop
					}
					else if(line.charAt(i) != '-')
					{
						if(Character.isDigit(line.charAt(i)) && i != 1 && i != 0 && line.charAt(i + 1) != ' ')
						{
							tree.cursorToChild(Character.getNumericValue(line.charAt(i)) + 1);
						}
					}
					if(line.charAt(i) == ' ')
						break;
				}
			}
			System.out.println(file + " loaded");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
		}
		catch(IOException e)
		{
			System.out.println("I/O exception has occured");
		}
	}
	
	public static void writeToFile(FXComponentTree tree, String filename) throws IOException
	{
		BufferedWriter writer = null;
        try {
            //create a temporary file
            File logFile = new File(filename);

            // This will output the full path where the file will be written to...
            System.out.println("Files saved to " + logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile));
            writer.write(tree.toString());
            
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                writer.close(); // Close the writer regardless of what happens
            } catch (Exception e)
            {
            }
        }
	}
	
	public static void exportToFile(FXComponentTree tree, String filename) // extra credit
	{
		
	}

	public FXTreeNode getRoot()
	{
		return root;
	}
	
	@Override
	public String toString()
	{	
		int spaces = 0;
		
		if(root != null) // tree is empty
		{
			String s = "";
			
			if(cursor == root)
				s += "==>" + root.getType() + "\n";
			else
				s += root.getType() + "\n";
			
			for(int i = 0; i < root.getMaxChildren(); i++)
			{
				if(root.getChildren()[i] != null) // there are children to print
				{	
					s += toString(root.getChildren()[i], spaces);
				}
					
			}
			return s;	
		}
		return "There is no tree to print";
	}
	
	private String toString(FXTreeNode root, int spaces)
	{
		String s = "";
		
		for(int i = 0; i < spaces; i++)
		{
			s += "   ";
		}
		
		if(cursor == root)
			s += "   ==>" + root.getType() + ": " + root.getText() + "\n";
		else
			s += root.toString();
		
		for(int i = 0; i < root.getMaxChildren(); i++)
		{
			if(root.getChildren()[i] != null) // there are children to print
			{
				s += "" + toString(root.getChildren()[i], spaces + 1);
			}
				
		}
		return s;	
	}

	public FXTreeNode getCursor()
	{
		return cursor;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
