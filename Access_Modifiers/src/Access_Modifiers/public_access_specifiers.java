package Access_Modifiers;

public class public_access_specifiers {

	public void display() 
    { 
        System.out.println("This is Public Access Specifiers"); 
    } 

 public static void main(String[] args) {
	 public_access_specifiers obj = new public_access_specifiers(); 
     obj.display();  

 }
}