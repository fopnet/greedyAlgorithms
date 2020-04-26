package greedyAlgorithms.Assessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortWordsById {
    public List<String> reorderLines(int logFileSize, List<String> logLines) {
        Map<String, String> map = new TreeMap<>();

        for (int i = 0; i < logLines.size(); i++) {
            String id = logLines.get(i).split(" ")[0];

            map.put(id, logLines.get(i));
        }

        return new ArrayList<String>(map.values());
    }

    public static void main(String[] args) {
        SortWordsById s = new SortWordsById();

        List<String> r = s.reorderLines(4,
                Arrays.asList("wz3 34 54 398", "mi2 jog mid pet", "a1 alps cow bar", "x4 45 21 7"));

        r.stream().forEach(System.out::println);

        System.out.println();
        System.out.println("Expected answer");
        Arrays.asList("a1 alps cow bar", "mi2 jog mid pet", "wz3 34 54 398", "x4 45 21 7").stream().forEach(System.out::println);

    }
}