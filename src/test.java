import java.util.*;
//倒叙输出的参考
public class test {
    public static void main(String[] args) {
        Map<Integer,Integer> map=new LinkedHashMap<>();
        map.put(1,5);
        map.put(2,8);
        map.put(3,9);
        map.put(4,2);
        map.put(5,7);
        ListIterator<Map.Entry<Integer,Integer>> i=new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet()).listIterator(map.size());
        while (i.hasPrevious()){
            Map.Entry entry=(Map.Entry)i.previous();
            System.out.println(entry.getKey());
        }
    }
}
