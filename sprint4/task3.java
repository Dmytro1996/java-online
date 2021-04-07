public class Employee{
    private String fullName;
    private float salary;
    public Employee(String fullName,float salary){
        this.salary=salary;
        this.fullName=fullName;
    }
    public Employee(){}
    public String getFullName(){
        return fullName;
    }
    public float getSalary(){
        return salary;
    }
    public void setFullName(String fullName){
        this.fullName=fullName;
    }
    public void setSalary(float salary){
        this.salary=salary;
    }
}