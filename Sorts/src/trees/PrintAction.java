package trees;

/*
    Implementation of PrintAction class.
    @author Alyce Brady
    Creation Date: Spring 2001
    
    The PrintAction class implements the NodeVisitor interface.
	It prints the contents of the node to System.out.
*/


public class PrintAction implements NodeVisitor
{
    public void visit(Object data)
	{
        if ( data != null )
            System.out.print (data.toString()+ ". ");
	}

	@Override
	public String completeAction() {
		return "\n";
	}

}
