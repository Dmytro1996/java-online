import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class MyUtils {
    // Code
    public int[][] arrSort(int[][] arr) {
            return Arrays.asList(arr).stream().sorted((arr1,arr2)->{
            if(arr1.length>0 && arr2.length==0){
                return -1;
            }
            if(arr1.length==0 && arr2.length>0){
                return 1;
            }
            for(int i=0;i<2;i++){
                    int a=0,b=0;
                    if(i<arr1.length){
                        a=arr1[i];
                    }
                    if(i<arr2.length){
                        b=arr2[i];
                    }
                    if(i>0){
                        return a-b;
                    }
                    if(a==b){
                        continue;
                    }
                    return b-a;
                
            }            
            return 0;
            }).collect(Collectors.toList()).toArray(new int[arr.length][]);
    }
}