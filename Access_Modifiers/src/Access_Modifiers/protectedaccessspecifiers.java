package Access_Modifiers;

public class protectedaccessspecifiers {

	protected void display() 
    { 
        System.out.println("This is protected access specifier"); 
    } 
	
	public static void main(String[] args) {
		protectedaccessspecifiers obj = new protectedaccessspecifiers ();   
	       obj.display();  
	}

}






