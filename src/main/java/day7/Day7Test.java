package day7;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class Day7Test {

    @Test
    public void part1() {
        File inputFile = new File("src/main/java/day7/inputTest.txt");

        assertEquals( 4, Day7.part1(inputFile));
    }

    @Test
    public void part2() {
        File inputFile = new File("src/main/java/day7/inputTest2.txt");

        assertEquals( 126, Day7.part2(inputFile));
    }

}