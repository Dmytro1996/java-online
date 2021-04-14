import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

abstract class Shape {
    private String name;
    
    public Shape(String name){
        this.name=name;
    }
    
    public String getName(){
        return name;
    }
    
    public abstract double getArea();
    
    public boolean equals(Object object){
        if(object instanceof Shape){
            if(name==null){
                return ((Shape)object).getName()==null;
            }
            if(((Shape)object).getName()==null){
                return false;
            }
            return ((Shape)object).getName().equals(name);
        }
        return false;
    }
    
    public int hashCode(){
        return name.hashCode()+getClass().hashCode();
    }
}
class Circle extends Shape {
    private double radius;
    
    public Circle(String name, double radius){
        super(name);
        this.radius=radius;
    }
    
    public double getRadius(){
        return radius;
    }
    
    public double getArea(){
        return 4*radius*radius;
    }
}
class Rectangle extends Shape {
    private double height;
    private double width;
    
    public Rectangle(String name, double height, double width){
        super(name);
        this.height=height;
        this.width=width;
    }
    
    public double getWidth(){
        return width;
    }
    
    public double getHeight(){
        return height;
    }
    
    public double getArea(){
        return 2*(width+height);
    }
}
public class MyUtils {
    public List<Shape> maxAreas(List<Shape> shapes) {
        // Code 
        return shapes.stream().filter(shape->{
            if(shape instanceof Rectangle){
                return shape.getArea()==shapes.stream().filter(s->s!=null && s instanceof Rectangle)
                .map(s->s.getArea()).max(Double::compare).get();
            }
            if(shape instanceof Circle){
                return shape.getArea()==shapes.stream().filter(s->s!=null && s instanceof Circle)
                .map(s->s.getArea()).max(Double::compare).get();
            }
            return false;
        }).distinct().collect(Collectors.toList());
    }
}
