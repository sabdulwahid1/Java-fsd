package Class_Objects_and_Pillars_of_OOPs;

//Employee class demonstrating encapsulation
class Employee {
 // Private fields (attributes)
 private String name;
 private int age;
 private double salary;

 // Public constructor
 public Employee(String name, int age, double salary) {
     this.name = name;
     this.age = age;
     this.salary = salary;
 }

 // Public getter method for name
 public String getName() {
     return name;
 }

 // Public setter method for name
 public void setName(String name) {
     this.name = name;
 }

 // Public getter method for age
 public int getAge() {
     return age;
 }

 // Public setter method for age
 public void setAge(int age) {
     if (age >= 18) {
         this.age = age;
     } else {
         System.out.println("Age must be 18 or older.");
     }
 }

 // Public getter method for salary
 public double getSalary() {
     return salary;
 }

 // Public setter method for salary
 public void setSalary(double salary) {
     if (salary > 0) {
         this.salary = salary;
     } else {
         System.out.println("Salary must be greater than 0.");
     }
 }

 // Public method to display employee information
 public void displayInfo() {
     System.out.println("Employee Information:");
     System.out.println("Name: " + name);
     System.out.println("Age: " + age);
     System.out.println("Salary: $" + salary);
 }
}

public class EncapsulationDemo {
 public static void main(String[] args) {
     // Create an instance of the Employee class
     Employee employee1 = new Employee("John Doe", 25, 50000.0);

     // Accessing and displaying employee information using getter methods
     System.out.println("Employee Name: " + employee1.getName());
     System.out.println("Employee Age: " + employee1.getAge());
     System.out.println("Employee Salary: $" + employee1.getSalary());

     // Updating employee information using setter methods
     employee1.setName("Jane Doe");
     employee1.setAge(30);
     employee1.setSalary(60000.0);

     // Displaying updated employee information
     employee1.displayInfo();
 }
}

