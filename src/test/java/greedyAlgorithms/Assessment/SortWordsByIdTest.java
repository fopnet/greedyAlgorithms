package greedyAlgorithms.Assessment;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SortWordsByIdTest {

    class TestResult {
        public List<String> logLines = null;
        public List<String> expected = null;
    
        public TestResult(List<String> logLines, List<String> expected) {
            this.logLines = logLines;
            this.expected = expected;
        }
    }

    
    public TestResult getTestCase1() {
        return new TestResult(Arrays.asList("wz3 34 54 398", "mi2 jog mid pet", "a1 alps cow bar", "x4 45 21 7"),
                Arrays.asList("a1 alps cow bar", "mi2 jog mid pet", "wz3 34 54 398", "x4 45 21 7")) {
        };
    }

    private TestResult getTestCase2() {
        return new TestResult(Arrays.asList("f3 52 54 31", "br8 eat nim did","t2 13 121 98", "b4 xi me nu", "w1 has uni gry", "r1 box ape bit" ),
        Arrays.asList("r1 box ape bit", "br8 eat nim did", "w1 has uni gry", "b4 xi me nu", "t2 13 121 98", "f3 52 54 31")) {
};
    }

    public void testTemplate(TestResult testResult) {
        SortWordsById s = new SortWordsById();

        List<String> result = s.reorderLines(testResult.logLines.size(), testResult.logLines);

        result.stream().forEach(System.out::println);

        assertArrayEquals(testResult.expected.toArray(), result.toArray());        
        
        System.out.println();
        System.out.println("Expected answer");
        testResult.expected.stream().forEach(System.out::println);
    } 

    @Test
    public void testCase1() {
        testTemplate(getTestCase1());
    }    
    
    @Test
    public void testCase2() {
        testTemplate(getTestCase2());
    }

  
}