package greedyAlgorithms.Assessment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class AmazonGoStores2 {

    class Coord {
        int l;
        int c;

        Coord(int l, int c) {
            this.l = l;
            this.c = c;
        }

        public String toString() {
            return "(".concat(String.valueOf(l)).concat(",").concat(String.valueOf(c)).concat(")");
        }
    }

    class Line {
        Coord start;
        Coord end;
        Set<Line> adjacentLines;

        Line add(Line l) {
            this.adjacentLines.add(l);
            return this;
        }

        Line(Coord s, Coord e) {
            this.start = s;
            this.end = e;
            this.adjacentLines = new HashSet<>();
        }

        boolean isAdjacent(Line prev) {
            return ((prev.end.c >= this.start.c) && (prev.end.c <= this.end.c)
                    || (prev.start.c >= this.end.c) && (prev.start.c <= this.start.c));
        }

        public String toString() {
            return this.start.toString().concat(" - ").concat(this.end.toString());
        }

        boolean isAfter(Line prev) {
            return prev.end.c < this.start.c;
        }
    }

    Map<Integer, List<Line>> getLines(int l, List<List<Integer>> grid, Map<Integer, List<Line>> lines) {

        int columns = grid.get(l).size();
        Coord start = null;
        for (int c = 0; c < columns; c++) {
            Integer val = grid.get(l).get(c);

            // Integer next = grid.get(l).get(c + 1);
            if (start == null && Integer.valueOf(1).equals(val)) {
                start = new Coord(l, c);
            }
            if (start != null && (Integer.valueOf(0).equals(val) || c == columns - 1)) {
                int col = Integer.valueOf(0).equals(val) ? c - 1 : c;
                lines.get(Integer.valueOf(l)).add(new Line(start, new Coord(l, col)));
                start = null;
            }
        }

        return lines;
    }

    int blocks = 0;

    int numberAmazonGoStores(int rows, int column, List<List<Integer>> grid) {

        Map<Integer, List<Line>> mapLines = new TreeMap<>();
        for (int l = 0; l < rows; l++) {
            List<Line> lines = new ArrayList<>();
            mapLines.put(Integer.valueOf(l), lines);

            getLines(l, grid, mapLines);

            blocks += lines.size();
        }

        if (mapLines.size() < 2) {
            return mapLines.size();
        }

        Entry<Integer, List<Line>> prev = null;
        Iterator<Entry<Integer, List<Line>>> it = mapLines.entrySet().iterator();
        while (it.hasNext()) {
            Entry<Integer, List<Line>> next = it.next();
            if (prev != null) {
                verifyAdjacent(next.getKey(), next.getValue(), prev.getValue());
                prev = null;
            } else {
                prev = next;
            }
        }

        return blocks;

    }

    void verifyAdjacent(int row, List<Line> lines, List<Line> prev) {
        for (Line currLine : lines) {
            Iterator<Line> it = prev.listIterator();
            while (it.hasNext()) {
                Line prevLine = it.next();
                if (currLine.isAfter(prevLine)) {
                    it.remove();
                } else if (currLine.isAdjacent(prevLine)) {
                    prevLine.add(currLine);
                    blocks--;
                }
            }

        }
    }

}