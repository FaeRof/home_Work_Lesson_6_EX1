package com.home_Work_Lesson_6_EX1;


import com.home_Work_Lesson_6_EX1.division.Division;

public class Launch {
    public static void main(String[] args){

        Division division = new Division();
        System.out.println("Integer division check:");
        System.out.println(division.divisionWithoutRemainder(1,10));     // 0
        System.out.println(division.divisionWithoutRemainder(5,5));    // 1
        System.out.println(division.divisionWithoutRemainder(8,3));      // 2
        System.out.println(division.divisionWithoutRemainder(40,8));     // 5
        System.out.println(division.divisionWithoutRemainder(777,7));  // 111
        System.out.println(division.divisionWithoutRemainder(-10000,5)); // -2000
        System.out.println(division.divisionWithoutRemainder(500,-52));  // -9
        System.out.println(division.divisionWithoutRemainder(-17,-7));   // 2
        System.out.println(division.divisionWithoutRemainder(0,-7));     // 0
        // for checking division by zero you should remove the comment mark before the next line
        //System.out.println(division.divisionWithoutRemainder(7,0));          // You cannot divide by zero
        System.out.println(" ");

        System.out.println("Checking the remainder of a division:");
        System.out.println(division.remainderOfDivision(4,9));           // 0
        System.out.println(division.remainderOfDivision(9,9));           // 0
        System.out.println(division.remainderOfDivision(0,9));           // 0
        System.out.println(division.remainderOfDivision(25,4));          // 1
        System.out.println(division.remainderOfDivision(7,4));           // 3
        System.out.println(division.remainderOfDivision(79,10));         // 9
        System.out.println(division.remainderOfDivision(-29,5));         // -4
        System.out.println(division.remainderOfDivision(39,-11));        // -6
        System.out.println(division.remainderOfDivision(-52,-50));       // 2
        // for checking division by zero you should remove the comment mark before the next line
        //System.out.println(division.remainderOfDivision(7,0));               // You cannot divide by zero

        System.out.println("Division test with fractional part:");
        System.out.println(division.divisionWithRemainder(20,3));        // 6.66666
        System.out.println(division.divisionWithRemainder(40,3));        // 13.33333
        System.out.println(division.divisionWithRemainder(-10,-3));      // 3.33333
        System.out.println(division.divisionWithRemainder(1,2));         // 0.5
        System.out.println(division.divisionWithRemainder(-7,4));        // -1.75
        System.out.println(division.divisionWithRemainder(23,-8));       // -2.875
        System.out.println(division.divisionWithRemainder(0,-8));        // -0.0
    }

}
