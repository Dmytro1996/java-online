import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

interface DrinkReceipt {
    // Code
    String getName();
    DrinkReceipt addComponent(String componentName, int componentCount);
}
interface DrinkPreparation {
    // Code
    Map<String,Integer> makeDrink();
}
interface Rating {
    // Code
    int getRating();
}
class Caffee implements DrinkReceipt, DrinkPreparation, Rating {
    // Code
    private String name;
    private int rating;
    private Map<String,Integer> ingredients;
    
    public Caffee(String name, int rating){
        this.name=name;
        this.rating=rating;
        ingredients=new HashMap<>();
    }
    
    public DrinkReceipt addComponent(String componentName, int componentCount){
        ingredients.put(componentName,componentCount);
        return this;
    }
    
    public Map<String, Integer> makeDrink(){
        addComponent("Water",100);
        addComponent("Arabica",20);
        return ingredients;
    }
    
    public int getRating(){
        return rating;
    }
    
    public String getName(){
        return name;
    }
    
    public Map<String, Integer> getIngredients(){
        return ingredients;
    }
}
class Espresso extends Caffee {
    // Code
    public Espresso(String name, int ranking){
        super(name,ranking);
    }
    
    public Map<String, Integer> makeDrink(){
        addComponent("Water",50);
        addComponent("Arabica",20);
        return getIngredients();
    }
}
class Cappuccino extends Caffee {
    // Code
    public Cappuccino(String name, int ranking){
        super(name,ranking);
    }
    
    public Map<String, Integer> makeDrink(){
        addComponent("Water",100);
        addComponent("Arabica",20);
        addComponent("Milk",50);
        return getIngredients();
    }
}
public class MyUtils {
    public Map<String, Double> averageRating(List<Caffee> coffees) {
        // Code
        Map<String, Double> result=new HashMap<>();
        Set<String> coffeeTypes=coffees.stream().map(coffee->coffee.getName()).collect(Collectors.toSet());
        for(String coffeeType:coffeeTypes){
            result.put(coffeeType, coffees.stream()
              .filter(coffee->coffee.getName().equals(coffeeType))
              .mapToDouble(coffee->(double)coffee.getRating()).average().getAsDouble());
        }
        return result;
    }
}
