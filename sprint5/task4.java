// Write your code here
class Person{
    int age;
    String healthInfo;
    String name;
    
    public Person(int age, String healthInfo, String name){
        this.age=age;
        this.healthInfo=healthInfo;
        this.name=name;
    }
    
    public String getHealthStatus(){ 
        return name +" " + healthInfo;
    }
}

class Child extends Person{
    private String childIDNumber;
    
    public Child(int age, String childIDNumber, String healthInfo, String name){
        super(age,healthInfo,name);
        this.childIDNumber=childIDNumber;
    }
}

class Adult extends Person{
    private String passportNumber;
    
    public Adult(int age, String healthInfo, String passportNumber, String name){
        super(age,healthInfo,name);
        this.passportNumber=passportNumber;
    }
}