import java.io.File;
import java.io.IOException;

// Test class

public class Test
{
	public static void main(String [] args)
	{
		
		// Button yes = new Button("YES");
		/*
		FXComponentTree test = new FXComponentTree();
		FXTreeNode root = new FXTreeNode("Root");
		
		test.addChild(1,root);
		test.cursorToRoot();
		test.addChild(1, new FXTreeNode("One"));
		test.addChild(2, new FXTreeNode("Two"));
		test.addChild(3, new FXTreeNode("Three"));
		test.addChild(4, new FXTreeNode("Four"));
		test.addChild(5, new FXTreeNode("Five"));
		test.addChild(6, new FXTreeNode("Six"));
		test.addChild(7, new FXTreeNode("Seven"));
		test.addChild(8, new FXTreeNode("Eight"));
		test.addChild(9, new FXTreeNode("Nine"));
		test.addChild(10, new FXTreeNode("Ten"));
		test.addChild(11, new FXTreeNode("Eleven"));
		test.addChild(10, new FXTreeNode("Ten"));

		
		System.out.print(test.getRoot());
		System.out.println();

		
		
		
		FXComponentTree test2 = new FXComponentTree();
		FXTreeNode root2 = new FXTreeNode();
		
		test2.addChild(1,root2);
		test2.cursorToRoot();
		test2.addChild(1, new FXTreeNode("One")); // 1
		test2.addChild(2, new FXTreeNode("Two")); // 12
		test2.addChild(3, new FXTreeNode("Five")); // 125
		test2.addChild(4, new FXTreeNode("Nine")); // 1259
		test2.addChild(3, new FXTreeNode("Three")); // 12359
		test2.addChild(4, new FXTreeNode("Four")); // 123459
		test2.addChild(6, new FXTreeNode("Six")); // 1234569
		test2.addChild(7, new FXTreeNode("Eight")); // 12345689
		test2.addChild(9, new FXTreeNode("Ten")); // 12345678910
		test2.addChild(7, new FXTreeNode("Seven")); // 12345678910

		System.out.print(test2.getRoot());
		
		System.out.println();
		
		test2.deleteChild(10);
		System.out.print(test2.getRoot()); // 123456789
		System.out.println();
		test2.deleteChild(3);
		System.out.print(test2.getRoot()); // 12456789
		System.out.println();
		test2.deleteChild(8);
		System.out.print(test2.getRoot()); // 1245678
		System.out.println();
		test2.deleteChild(2);
		System.out.print(test2.getRoot()); // 145678
		System.out.println();
		test2.deleteChild(8); // fails
		test2.deleteChild(17); // fails
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		test2.cursorToChild(1); // cursor at "One"
		test2.addChild(1, new FXTreeNode("One: 1")); // 11
		test2.addChild(2, new FXTreeNode("One: 2")); // 11 12
		test2.addChild(3, new FXTreeNode("One: 3")); // 11 12 13
		System.out.print(test2.getRoot());
		System.out.println();
		test2.deleteChild(2); // 11 13
		test2.deleteChild(17); // fails
		System.out.print(test2.getRoot());
		System.out.println();
		test2.setTextAtCursor("New One"); // One = New One
		System.out.print(test2.getRoot());
		System.out.println();
		System.out.println();
		
		test2.cursorToParent();
		test2.addChild(7, new FXTreeNode("New Seven")); // New One 11 13 45678 New Seven
		System.out.print(test2.getRoot());
		System.out.println();
		test2.cursorToChild(7);
		test2.addChild(1, new FXTreeNode("Seven: 1")); //New One 11 13 45678 New Seven 71
		test2.addChild(2, new FXTreeNode("Seven: 2")); // New One 11 13 45678 New Seven 71 72
		System.out.print(test2.getRoot());
		System.out.println();
		test2.cursorToRoot();
		test2.addChild(8, new FXTreeNode("New Eight")); // New One 11 13 45678 New Seven 71 72 New Eight
		System.out.print(test2.getRoot());
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println(test2.toString());
		*/
		
		FXComponentTree test2 = new FXComponentTree();
		FXTreeNode root2 = new FXTreeNode("Root", ComponentType.AnchorPane);
		
		test2.addChild(1,root2);
		test2.cursorToRoot();
		test2.addChild(1, new FXTreeNode("One", ComponentType.VBox)); // 1
		test2.addChild(2, new FXTreeNode("Two", ComponentType.VBox)); // 12
		test2.addChild(3, new FXTreeNode("Five", ComponentType.VBox)); // 125
		test2.addChild(4, new FXTreeNode("Nine", ComponentType.VBox)); // 1259
		test2.addChild(3, new FXTreeNode("Three", ComponentType.VBox)); // 12359
		test2.addChild(4, new FXTreeNode("Four", ComponentType.VBox)); // 123459
		test2.addChild(6, new FXTreeNode("Six", ComponentType.VBox)); // 1234569
		test2.addChild(7, new FXTreeNode("Eight", ComponentType.VBox)); // 12345689
		test2.addChild(9, new FXTreeNode("Ten", ComponentType.VBox)); // 12345678910
		test2.addChild(7, new FXTreeNode("Seven", ComponentType.VBox)); // 12345678910

		System.out.print(test2.toString());
		
		System.out.println();
		
		test2.cursorToChild(1); // cursor at "One"
		test2.addChild(1, new FXTreeNode("One: 1", ComponentType.HBox)); // 11
		test2.addChild(2, new FXTreeNode("One: 2", ComponentType.HBox)); // 11 12
		test2.addChild(3, new FXTreeNode("One: 3", ComponentType.HBox)); // 11 12 13
		System.out.print(test2.toString());
		System.out.println();
		test2.deleteChild(2); // 11 13
		test2.deleteChild(17); // fails
		System.out.print(test2.toString());
		System.out.println();
		test2.setTextAtCursor("New One"); // One = New One
		System.out.print(test2.toString());
		System.out.println();
		System.out.println();
		
		test2.cursorToParent();
		test2.addChild(7, new FXTreeNode("New Seven", ComponentType.VBox)); // New One 11 13 45678 New Seven
		System.out.print(test2.toString());
		System.out.println();
		test2.cursorToChild(7);
		test2.addChild(1, new FXTreeNode("Seven: 1", ComponentType.HBox)); //New One 11 13 45678 New Seven 71
		test2.addChild(2, new FXTreeNode("Seven: 2", ComponentType.HBox)); // New One 11 13 45678 New Seven 71 72
		test2.cursorToChild(1);
		test2.addChild(1, new FXTreeNode("Seven: 1: 1", ComponentType.Label)); // // New One 11 13 45678 New Seven 71 711 72
		System.out.print(test2.toString());
		test2.cursorToChild(1);
		test2.addChild(1, new FXTreeNode("Seven: 1: 1: 1", ComponentType.Button)); // // New One 11 13 45678 New Seven 71 711 7111 72
		System.out.print(test2.toString());
		System.out.println();
		test2.cursorToRoot();
		test2.addChild(8, new FXTreeNode("New Eight")); // New One 11 13 45678 New Seven 71 72 New Eight
		System.out.print(test2.toString());
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println(test2.toString());
		
		test2.cursorToChild(1);
		test2.cursorToChild(1);
		test2.addChild(1, new FXTreeNode("One: 1: 1", ComponentType.Button)); // New One 11 One11 13 45678 New Seven 71 72 New Eight
		System.out.println(test2.toString());
		test2.cursorToRoot();
		System.out.println(test2.toString());
		test2.cursorToChild(1);
		test2.cursorToChild(1);
		System.out.println(test2.toString());
		test2.cursorToChild(1);
		System.out.println(test2.toString());
		
		FXComponentTree test3;
		
		File testFile;
		
		File file = new File("C:\\Users\\Sean\\eclipse-workspace\\CSE214 HW5\\src\\hw5sample(2).txt");
		FXComponentTree test4 = new FXComponentTree();
		FXComponentTree.readFromFile(test4, file);
		System.out.println(test4.toString());
		
		try {
			FXComponentTree.writeToFile(test4, "testFile");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//FXComponentTree.writeToFile(test, filename); test out
		
	}
	
	
}
