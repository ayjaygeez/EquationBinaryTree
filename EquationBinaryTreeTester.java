import java.util.Scanner;

public class EquationBinaryTreeTester {

	public static void main(String[] args) {
		//String infix = "1";
		//String infix = "((a+b)+(c+d))";
		
		EquationBinaryTree ebt = new EquationBinaryTree();
		
		System.out.println("Type 1 for infix, 2 for postfix or 3 for prefix: ");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if(choice == 1) {
            System.out.println("Type your infix expression: ");
            Scanner scan2 = new Scanner(System.in);
            String infix = scan2.nextLine();
            ebt.populateFromInfix(infix);
            System.out.println(ebt.printInfix());
    		System.out.println(ebt.printPostfix());
    		System.out.println(ebt.printPrefix());
            
        }
        else if(choice == 2) {
            System.out.println("Type your postfix expression: ");
            Scanner scan2 = new Scanner(System.in);
            String postfix = scan2.nextLine();
            String reverse = new StringBuffer(postfix).reverse().toString();
            EquationBinaryTree.equation = reverse;
            ebt.populateTreePostfix();
            System.out.println(ebt.printInfix());
    		System.out.println(ebt.printPostfix());
    		System.out.println(ebt.printPrefix());
            
        }
        else if(choice == 3){
        	System.out.println("Type your prefix expression: ");
            Scanner scan2 = new Scanner(System.in);
            EquationBinaryTree.equation = scan2.nextLine();
            ebt.populateTreePrefix();
            System.out.println(ebt.printInfix());
    		System.out.println(ebt.printPostfix());
    		System.out.println(ebt.printPrefix());
        }
        else {
            System.out.println("Invalid input.");
        }
        
		//EquationBinaryTree.equation = "++ab+cd";
		
		//ebt.populateFromInfix(infix);
		
	}

}
