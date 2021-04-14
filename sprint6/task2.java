import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int experience;
    private BigDecimal basePayment;
    
    public Employee(String name, int experience, BigDecimal basePayment){
        this.name=name;
        this.experience=experience;
        this.basePayment=basePayment;
    }
    
    public String getName(){
        return name;
    }
    
    public int getExperience(){
        return experience;
    }
    
    public BigDecimal getPayment(){
        return basePayment;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + this.experience;
        hash = 67 * hash + Objects.hashCode(this.basePayment);
        hash = 67 * hash + Objects.hashCode(getClass());
        return hash;
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
        final Employee other = (Employee) obj;
        if (getExperience() != other.getExperience()) {
            return false;
        }
        if (!Objects.equals(getName(), other.getName())) {
            return false;
        }
        if (!Objects.equals(getPayment(), other.getPayment())) {
            return false;
        }
        return true;
    }
}
class Manager extends Employee {
    private double coefficient;
    
    public Manager(String name, int experience, BigDecimal basePayment,
            double coefficient){
        super(name, experience, basePayment);
        this.coefficient=coefficient;
    }
    
    public double getCoefficient(){
        return coefficient;
    }
    
    public BigDecimal getPayment(){
        return super.getPayment().multiply(BigDecimal.valueOf(coefficient));
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
        final Manager other = (Manager) obj;
        if (getExperience() != other.getExperience()) {
            return false;
        }
        if(getCoefficient() != other.getCoefficient()){
            return false;
        }
        if (!Objects.equals(getName(), other.getName())) {
            return false;
        }
        if (!Objects.equals(getPayment(), other.getPayment())) {
            return false;
        }
        return true;
    }
}
public class MyUtils {
    public List<Employee> largestEmployees(List<Employee> workers) {
        return workers.stream().filter(worker->worker!=null).filter(worker->{
            return worker.getExperience()==workers.stream()
                  .map(w->w.getExperience())
                  .max(Integer::compare).get() || 
                  worker.getPayment().subtract(workers.stream()
                  .map(w->w.getPayment())
                  .max((b1,b2)->b1.compareTo(b2)).get()).intValue()==0;
            }
            ).distinct().collect(Collectors.toList());
    }
}
