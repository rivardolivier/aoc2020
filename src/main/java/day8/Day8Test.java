package day8;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class Day8Test {

    @Test
    public void part1() {
        File inputFile = new File("src/main/java/day8/inputTest.txt");

        assertEquals( 5, Day8.part1(inputFile));
    }

    @Test
    public void part2() {
        File inputFile = new File("src/main/java/day8/inputTest.txt");

        assertEquals( 8, Day8.part2(inputFile));
    }
}