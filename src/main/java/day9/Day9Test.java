package day9;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class Day9Test {

    @Test
    public void part1() {
        File inputFile = new File("src/main/java/day9/inputTest.txt");

        assertEquals( 127, Day9.part1(inputFile, 5));
    }

    @Test
    public void part2() {
        File inputFile = new File("src/main/java/day9/inputTest.txt");

        assertEquals( 62, Day9.part2(inputFile, 5));
    }

}