package com.dawan.atelier_implementation.solutions;

import com.dawan.atelier_implementation.interfaces.CalcInter;

public class CalcInterSolution implements CalcInter {
    @Override
    public int mult(int a, int b){
        return a*b;
    }

    @Override
    public int div(int a, int b){
        return a/b;
    }
}
