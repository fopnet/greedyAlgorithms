package greedyAlgorithms.Assessment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortWordsById {
    public List<String> reorderLines(int logFileSize, List<String> logLines) {
        Comparator<String> cmp = new Comparator<String>() {
            public int compare(String o1, String o2) {
                String id1 = o1.split("\\s")[0];
                String id2 = o2.split("\\s")[0];
                o1 = o1.substring(id1.length()).replaceAll("\\s+", "").trim();
                o2 = o2.substring(id2.length()).replaceAll("\\s+", "").trim();

                boolean o1IsNumber  = o1.matches("\\d+");
                boolean o2IsNumber  = o2.matches("\\d+");

                if (!o1IsNumber && !o2IsNumber) {
                    int comp = o1.compareTo(o2);
                    if (comp == 0) {
                        return id1.compareTo(id2);
                    } else {
                        return comp;
                    }
                } else if (o1IsNumber && o2IsNumber) {
                    return Integer.parseInt(o2) - Integer.parseInt(o1);
                } else if(o1IsNumber) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        Map<String, String> map = new TreeMap<>(cmp);

        for (String line : logLines) {
            map.put(line,line);
        }

        return new ArrayList<String>(map.values());
    }

}