package greedyAlgorithms.Contact;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import greedyAlgorithms.Trie.TrieMap;
import greedyAlgorithms.Trie.TrieTree;

public class ContactTest {

    @Test
    public void testContact() {
        TrieTree c = new TrieTree();

        c.add("Felipe");

        assertNotNull(c.find("felipe"));
        assertNotNull(c.find("feli"));
        assertNull(c.find("fop"));
    }

    @Test
    public void testFindOccurs() {
        TrieTree c = new TrieTree();

        c.add("Felipe");
        c.add("Felipeta");

        assertEquals(2, c.findOccurs("felipe"));
    }

    @Test
    public void testSampleTestCase() {
        TrieTree c = new TrieTree();

        c.add("hack");
        c.add("hackerrank");

        assertEquals(2, c.findOccurs("hac"));
        assertEquals(0, c.findOccurs("hak"));
    }
   
    @Test
    public void testSampleTestCaseMap() {
        TrieMap c = new TrieMap();

        c.add("hack");
        c.add("hackerrank");

        assertEquals(2, c.findOccurs("hac"));
        assertEquals(0, c.findOccurs("hak"));
    }

    @Test
    public void testCaseInput() {
        System.out.println("testCaseInput");

        String[] args = { "input.txt" };
        try {
            ContactTest.main(args);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            System.out.println("\nexpected");
            System.out.println("2");
            System.out.println("0");
        }
    }   
    
    @Test
    public void testTestCase1() {
        System.out.println("testTestCase1");

        String[] args = { "input1.txt" };
        try {
            ContactTest.main(args);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Test
    public void testTestCase2() {
        System.out.println("testTestCase2");

        String[] args = { "input2.txt" };
        try {
            ContactTest.main(args);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public static void main(String[] args) throws IOException {
        System.setIn(ContactTest.class.getResourceAsStream("./" + args[0]));
        Scanner scanner = new Scanner(System.in);
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String first = scanner.nextLine().trim();
        int queriesRows = Integer.parseInt(first);

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = contacts(queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            // bufferedWriter.write(String.valueOf(result[resultItr]));
            System.out.print(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                // bufferedWriter.write("\n");
                System.out.println();
            }
        }

        // bufferedWriter.newLine();

        // bufferedWriter.close();
        scanner.close();
    }

    static int[] contacts(String[][] queries) {
        /*
         * Write your code here.
         */
        List<Integer> result = new ArrayList<Integer>(queries.length / 2);

        TrieMap c = new TrieMap();
        for (int l = 0; l < queries.length; l++) {
            String[] line = queries[l];
            switch (line[0].toLowerCase()) {
                case "find":
                    result.add(c.findOccurs(line[1]));
                    break;
                case "add":
                    c.add(line[1]);
                    break;
            }
        }

        return result.stream().mapToInt(t -> t).toArray();

    }
}