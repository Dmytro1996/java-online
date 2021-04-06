import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MyUtils {
    public static class Student {
        private int id;
        private String name;
            
        public Student(int id, String name){
            this.id=id;
            this.name=name;
        }
        
        public int getId(){
            return id;
        }
        
        public String getName(){
            return name;
        }
        
        public void setId(int id){
            this.id=id;
        }
        
        public void setName(String name){
            this.name=name;
        }
        
        public boolean equals(Object object){
            if(object==null){
                return false;
            }
            if(!(object instanceof Student)){
                return false;
            }
            Student objectAsStudent=(Student)object;
            if(objectAsStudent.getName()==null){
                if(name==null){
                    return id==objectAsStudent.getId();
                }
                return false;
            }
            return objectAsStudent.getId()==id && objectAsStudent.getName().equals(name);
        }
        
        public int hashCode(){
            return id;
        }
        
    }
    public Set<Student> commonStudents(List<Student> list1, List<Student> list2) {
        return list1.stream().filter(s->list2.contains(s)).collect(Collectors.toSet());
    }
}