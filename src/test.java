import java.util.*;
//倒叙输出的参考
public class test {
    public static <K, V extends Comparable<? super V>> Map<K, V> sortDescend(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                int compare = (o1.getValue()).compareTo(o2.getValue());
                return -compare;
            }
        });

        Map<K, V> returnMap = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            returnMap.put(entry.getKey(), entry.getValue());
        }
        return returnMap;
    }
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
