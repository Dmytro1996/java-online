import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class MyUtils {
    // Code
    public Map<String, List<String>> createNotebook(Map<String, String> phones) {
        // Code
        Map<String,List<String>> resultMap=new HashMap<>();
        for(String phone:phones.keySet()){
            if(resultMap.keySet().contains(phones.get(phone))){
                resultMap.get(phones.get(phone)).add(phone);
            } else{
                List<String> phoneNums=new ArrayList<>();
                phoneNums.add(phone);
                resultMap.put(phones.get(phone),phoneNums);
            }
        }
        return resultMap;
    }
}