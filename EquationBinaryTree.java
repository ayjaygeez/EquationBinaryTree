

public class EquationBinaryTree {
	private EquationTreeNode root;
	static String equation;
	public EquationBinaryTree()
	{
		root = null;
	}
	//populating tree from infix
	//((a+(b*c))+(((d*e)+f)*g))
	public void populateFromInfix(String inf)
	{
		root = populateInfixHelper(inf);
	}
	//recursive helper to break down infix formula
	private EquationTreeNode populateInfixHelper(String inf)
	{
		EquationTreeNode node;
		if(inf.length() == 1)
		{
			node = new EquationTreeNode(inf);
		}
		else
		{
			//break down infix into 3 parts, begin, end, middle
			String[] parts = infixBreakdownHelper(inf);
			node = new EquationTreeNode(parts[2]);
			if(!parts[0].equals(""))
				node.left = populateInfixHelper(parts[0]);
			if(!parts[1].equals(""))
				node.right = populateInfixHelper(parts[1]);
		}
		return node;
	}
	//breakdown infix into 3 parts
	private String[] infixBreakdownHelper(String inf)
	{
		String[] parts = new String[3];
		//remove leading/trailing parens
		inf = inf.substring(1, inf.length()-1);//(a+(b*c))+(((d*e)+f)*g)
		int parenCount = 0;
		int i = 0;
		for(i = 0; i < inf.length(); i++)
		{
			if(inf.charAt(i) == '(')
				parenCount++;
			else if(inf.charAt(i) == ')')
				parenCount--;
			if(parenCount == 0)
				break;
		}
		
		parts[0] = inf.substring(0, i+1);//(a+(b*c))
		parts[1] = inf.substring(i+2);//(((d*e)+f)*g)
		parts[2] = ""+inf.charAt(i+1);//+

		return parts;
	}

	//print tree as infix
	public String printInfix()
	{
		String output = "";
		output += printInfixHelper(root);
		return output;
	}
	private String printInfixHelper(EquationTreeNode node)
	{
		String output = "";
		if(node.left != null)
		{
			output += "(";
			output += printInfixHelper(node.left);
		}
		output += node;
		if(node.right != null)
		{
			output += printInfixHelper(node.right);
			output += ")";
		}
		return output;
	}

	//print tree as postfix
	public String printPostfix()
	{
		String output = "";
		output += printPostfixHelper(root);
		return output;
	}
	private String printPostfixHelper(EquationTreeNode node)
	{
		String output = "";
		if(node.left != null)
		{
			output += printPostfixHelper(node.left);
		}
		if(node.right != null)
		{
			output += printPostfixHelper(node.right);
		}
		output += node;
		return output;
	}
	//print tree as prefix
	public String printPrefix()
	{
		String output = "";
		output += printPrefixHelper(root);
		return output;
	}
	private String printPrefixHelper(EquationTreeNode node)
	{
		String output = "";
		output += node;
		if(node.left != null)
		{
			output += printPrefixHelper(node.left);
		}
		if(node.right != null)
		{
			output += printPrefixHelper(node.right);
		}
		return output;
	}
	
	private boolean isOperator(char c)
    {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }


	private class EquationTreeNode{
		String value;
		EquationTreeNode left;
		EquationTreeNode right;
		public EquationTreeNode(String v)
		{
			value = v;
			left = null;
			right = null;
			
		}
		public String toString()
		{
			return value.toString();
		}
		
	}
	
	public void populateTreePrefix(){
		root = new EquationTreeNode("" + equation.charAt(0));
		
		//System.out.println("Print equation before isOperator: "+equation);
		
		equation = equation.substring(1);
		
		if(isOperator(root.value.charAt(0)) == true){
			root.left = getPrefixNodes();
			root.right = getPrefixNodes();
			//System.out.println("if triggered");
		}
		
	}
	public EquationTreeNode getPrefixNodes(){
		//System.out.println("Print equation 1: "+equation);
		EquationTreeNode node = new EquationTreeNode("" + equation.charAt(0));
		
		if(equation.length() > 1){
			equation = equation.substring(1);
		}
		else{
			return node;
		}

			
		if(isOperator(node.value.charAt(0)) == true){
			node.left = getPrefixNodes();
			node.right = getPrefixNodes();
		}
			
		//System.out.println("Print equation: "+equation);
		return node;
	}
	
	public void populateTreePostfix(){
		root = new EquationTreeNode("" + equation.charAt(0));

		equation = equation.substring(1);
		
		if(isOperator(root.value.charAt(0)) == true){
			root.right = getPostfixNodes();
			root.left = getPostfixNodes();
		}
		
	}
	public EquationTreeNode getPostfixNodes(){
		EquationTreeNode node = new EquationTreeNode("" + equation.charAt(0));
		
		if(equation.length() > 1){
			equation = equation.substring(1);
		}
		else{
			return node;
		}

			
		if(isOperator(node.value.charAt(0)) == true){
			node.right = getPostfixNodes();
			node.left = getPostfixNodes();
		}
		return node;
	}
	
}
