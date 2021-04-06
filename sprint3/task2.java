import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyUtils {
    // Code
    public List<String> strSort(List<String> originList) {
        return originList.stream().sorted((s1,s2)->{
            if(s1.length()==s2.length()){
                return s1.compareTo(s2);
            }
            return s1.length()-s2.length();
        }).collect(Collectors.toList());
    }
}