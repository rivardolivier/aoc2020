package day6;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class Day6Test {

    @Test
    public void part1() {

        File file = new File("src/main/java/day6/inputTest.txt");
        assertEquals( 11, Day6.part1(file));
    }

    @Test
    public void part2() {

        File file = new File("src/main/java/day6/inputTest.txt");
        assertEquals( 6, Day6.part2(file));
    }

}