class Student{
    String name="Korivi";
    int roll=269;
    String branch="EEE";
    float cgpa=8.4f;
}
class Employee{
    String name="Korivi";
    String role="Electrical Engineer";
    int id=75;
    float salary=70000f;
}
class Main{
    public static void main(String[] args){
        System.out.println("//STUDENT DETAILS//");
        Student s=new Student();
        System.out.println("Name: "+s.name);
        System.out.println("Roll: "+s.roll);
        System.out.println("Branch: "+s.branch);
        System.out.println("CGPA: "+s.cgpa);
        System.out.println("//EMPLOYEE DETAILS//");
        Employee e=new Employee();
        System.out.println("Name: "+e.name);
        System.out.println("Role: "+e.role);
        System.out.println("ID: "+e.id);
        System.out.println("SALARY: "+e.salary);
    }
}