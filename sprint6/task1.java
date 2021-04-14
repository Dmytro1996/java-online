import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Objects;

class Person {
    private String name;
    
    public Person(String name){
        this.name=name;
    }
    
    public String getName(){
        return name;
    }
    
    public int hashCode(){
        return name.hashCode();
    }
}
class Student extends Person {
    private String studyPlace;
    private int studyYears;
    
    public Student(String name, String studyPlace, int studyYears){
        super(name);
        this.studyPlace=studyPlace;
        this.studyYears=studyYears;
    }
    
    public String getStudyPlace(){
        return studyPlace;
    }
    
    public int getStudyYears(){
        return studyYears;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.studyYears != other.studyYears) {
            return false;
        }
        if (!Objects.equals(getName(), other.getName())) {
            return false;
        }
        if (!Objects.equals(this.studyPlace, other.studyPlace)) {
            return false;
        }
        return true;
    }
    
    public int hashCode(){
        return super.hashCode()+studyPlace.hashCode()+studyYears;
    }
}
class Worker extends Person {
    private String workPosition;
    private int experienceYears;
    
    public Worker(String name, String workPosition, int experienceYears){
        super(name);
        this.workPosition=workPosition;
        this.experienceYears=experienceYears;
    }
    
    public String getWorkPosition(){
        return workPosition;
    }
    
    public int getExperienceYears(){
        return experienceYears;
    } 
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Worker other = (Worker) obj;
        if (this.experienceYears != other.experienceYears) {
            return false;
        }
        if (!Objects.equals(getName(), other.getName())) {
            return false;
        }
        if (!Objects.equals(this.workPosition, other.workPosition)) {
            return false;
        }
        return true;
    }
    
    public int hashCode(){
        return super.hashCode()+workPosition.hashCode()+experienceYears;
    }
}
public class MyUtils {
    public List<Person> maxDuration(List<Person> persons) {
        return persons.stream().filter(pers->{
            if(pers instanceof Worker){
                return ((Worker)pers).getExperienceYears()==persons.stream()
                .filter(p->p instanceof Worker).map(p->((Worker)p).getExperienceYears())
                .max(Integer::compare).get();
            }
            if(pers instanceof Student){
                return ((Student)pers).getStudyYears()==persons.stream()
                .filter(p->p instanceof Student).map(p->((Student)p).getStudyYears())
                .max(Integer::compare).get();
            } else{
                return false;
            }
        }
        ).collect(Collectors.toList());
    }
}
