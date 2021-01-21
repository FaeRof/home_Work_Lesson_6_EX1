package com.home_Work_Lesson_6_EX1.division;

import com.home_Work_Lesson_6_EX1.elimination_of_errors.EliminateDivisionByZeroErrors;

public class Division {


    private static boolean isResultNegativity(int x, int y) {
        boolean isALessThanZero = x < 0;
        boolean isBLessThanZero = y < 0;
        return ((isALessThanZero && !isBLessThanZero) || (!isALessThanZero && isBLessThanZero));
    }


    ///////////////////////////////////////////////////////////////

    private static int prepareNumberForDivision(int x) {      //converting the number to positive for correct counting
        boolean isXLessThanZero = x < 0;
        if (isXLessThanZero) {
            return -1 * x;
        } else return x;
    }


   /////////////////////////////////////////////////////////////////

    public int divisionWithoutRemainder(int a, int b) {   // divide the first number by the second (a/b);
        int result = 0;
        boolean isNegativity = isResultNegativity(a, b);
        a = prepareNumberForDivision(a);
        b = prepareNumberForDivision(b);
        if (b == 0) {
            throw new EliminateDivisionByZeroErrors("ForbiddenDivisionByZero");
        }
        if (a < b) {
            return 0;
        } else {
            while (a >= b) {
                result++;
                a = a - b;
            }

            if (isNegativity) {     // checking the result for negativity
                return -1 * result;
            } else {
                return result;
            }
        }
    }

    /////////////////////////////////////////////////////////////

    public int remainderOfDivision(int a, int b) {
        boolean isNegativity = isResultNegativity(a, b);
        a = prepareNumberForDivision(a);
        b = prepareNumberForDivision(b);
        if (b == 0) {
            throw new EliminateDivisionByZeroErrors("ForbiddenDivisionByZero");
        }
        if (a < b) {
            return 0;
        } else {
            int remainder = a - divisionWithoutRemainder(a, b) * b;

            if (isNegativity) {
                return -1 * remainder;
            } else {
                return remainder;
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////

    public double divisionWithRemainder(int a, int b){
        boolean isNegativity = isResultNegativity(a,b);
        int beforeDecimalPoint = divisionWithoutRemainder(a,b);   //part of division before decimal point

        if (beforeDecimalPoint < 0){                              //converting beforeDecimalPoint to positive for correct counting
            beforeDecimalPoint = -1 * beforeDecimalPoint;
        }

        a = prepareNumberForDivision(a);
        b = prepareNumberForDivision(b);

        if (b == 0){
            throw new EliminateDivisionByZeroErrors("ForbiddenDivisionByZero");
        }

        a = (a - beforeDecimalPoint * b) * 10;
        int divisionAccuracy = 0;
        double afterDecimalPoint = 0.0;
        double positionCounter = 0.1;

        while (true){
            for (int i = 9; i >= 0; i--) {
                if (b*i <= a){
                    a =  (a - b * i) * 10;
                    afterDecimalPoint = afterDecimalPoint + positionCounter * i;
                    divisionAccuracy++;
                    positionCounter = positionCounter * 0.1;
                    break;
                }
            }
            if (a == 0) {                                           // loop exit condition
                break;
            } else if (divisionAccuracy >= 5){                      // here you can set accuracy of division
                break;
            }
        }

        if (isNegativity) {                                         // checking the result for negativity
            return -1 * (beforeDecimalPoint + afterDecimalPoint);
        } else {
            return (beforeDecimalPoint + afterDecimalPoint);
        }
    }

}
