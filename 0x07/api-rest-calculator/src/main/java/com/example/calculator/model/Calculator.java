package com.example.calculator.model;

import java.time.LocalDate;

public class Calculator {

    public Calculator(){}

    public Double sum(Double number1, Double number2) {
        Double sum;
        if (number1 != null && number2 != null) {
            sum = number1 + number2;
        } else {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
        return sum;
    }

    public Double sub(Double number1, Double number2) {
        Double sub;
        if (number1 != null && number2 != null) {
            sub = number1 - number2;
        } else {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
        return sub;
    }

    public Double divide(Double number1, Double number2) {
        Double div;
        if (number1 != null && number2 != null) {
            if (number2 == 0) {
                throw new ArithmeticException("Divisão por zero não é permitido.");
            } else {
                div = number1 / number2;
            }
        } else {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
        return div;
    }

    public Integer factorial(Integer factorial) {
        Integer result = 1;
        if (factorial != null && factorial != 0) {
            for (int i=1; i <= factorial; i++){
                result = result * i;
            }
        } else {
            throw new NullPointerException("Número é obrigatório.");
        }
        return result;
    }

    public Integer integerToBinary(Integer integer) {
        String resultString = Integer.toBinaryString(integer);
        Integer result = Integer.parseInt(resultString);
        return result;
    }

    public String integerToHexadecimal(Integer integer) {
        String result = Integer.toHexString(integer);
        return result;
    }

    public int calculeDayBetweenDate(LocalDate date1, LocalDate date2) {
        int dias = date1.compareTo(date2);
        return dias;
    }

}
