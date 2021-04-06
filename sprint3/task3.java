import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyUtils {
    // Code
    public boolean listMapCompare(List<String> list, Map<String, String> map) {
        return map.values().stream().filter(c->!list.contains(c))
            .collect(Collectors.toList()).isEmpty();
    }
}