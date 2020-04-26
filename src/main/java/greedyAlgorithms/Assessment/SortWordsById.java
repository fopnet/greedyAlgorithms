package greedyAlgorithms.Assessment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SortWordsById {
    public List<String> reorderLines(final int logFileSize, final List<String> logLines) {
        final Comparator<String> cmp = new Comparator<String>() {
            public int compare(String o1, String o2) {
                final String id1 = o1.split("\\s")[0];
                final String id2 = o2.split("\\s")[0];
                o1 = o1.substring(id1.length()).replaceAll("\\s+", "").trim();
                o2 = o2.substring(id2.length()).replaceAll("\\s+", "").trim();

                final boolean o1IsNumber = o1.matches("\\d+");
                final boolean o2IsNumber = o2.matches("\\d+");

                if (!o1IsNumber && !o2IsNumber) {
                    final int comp = o1.compareTo(o2);
                    if (comp == 0) {
                        return id1.compareTo(id2);
                    } else {
                        return comp;
                    }
                } else if (o1IsNumber && o2IsNumber) {
                    return Integer.parseInt(o2) - Integer.parseInt(o1);
                } else if (o1IsNumber) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };

        final Supplier<TreeMap<String, String>> supplier = new Supplier<TreeMap<String, String>>() {
            public TreeMap<String, String> get() {
                return new TreeMap<>(cmp);
            }
        };

        final Map<String, String> map = logLines.stream().collect(
                Collectors.toMap(String::toString, String::toString, (oldValue, newValue) -> oldValue, supplier));

        return new ArrayList<String>(map.values());
    }

}