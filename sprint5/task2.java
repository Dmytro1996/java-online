import java.util.Calendar;
import java.util.Date;
// Write your code here
class User {
    protected String name;
    protected String surname;
    
    public User(String name, String surname){
        this.name=name;
        this.surname=surname;
    }
    
    public String getFullName(){
        return name+" "+surname;
    }
}

class Student extends User{
    protected int year;
    
    public Student(int year, String name, String surname){
        super(name,surname);
        this.year=year;
    }
    
    public int getCourseNumber(){
        Date date=new Date();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        if((calendar.get(Calendar.YEAR)-year+1)>6 || (calendar.get(Calendar.YEAR)-year+1)<1){
            return -1;
        }
        return calendar.get(Calendar.YEAR)-year+1;
    }
}