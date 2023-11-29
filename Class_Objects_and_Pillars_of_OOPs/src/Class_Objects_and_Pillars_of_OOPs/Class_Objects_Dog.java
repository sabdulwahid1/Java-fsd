package Class_Objects_and_Pillars_of_OOPs;

public class Class_Objects_Dog 
{  
    String name; 
    String breed; 
    int age; 
    String color; 
    public Class_Objects_Dog(String name, String breed, int age, String color) 
    { 
        this.name = name; 
        this.breed = breed; 
        this.age = age; 
        this.color = color; 
    } 
    public String getName() 
    { 
        return name; 
    } 
    public String getBreed() 
    { 
        return breed; 
    } 
    public int getAge() 
    { 
        return age; 
    } 
    public String getColor() 
    { 
        return color; 
    } 
    @Override
    public String toString() 
    { 
        return("Hi my name is "+ this.getName()+ ".\nMy breed,age and color are " + this.getBreed()+", " + this.getAge()+ ", and"+ this.getColor() + "."); 
    } 
    public static void main(String[] args) 
    { 
        Class_Objects_Dog scott = new Class_Objects_Dog("Scott","papillon", 5, "black"); 
        System.out.println(scott.toString()); 
    } 
}

