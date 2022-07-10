package org.example;

import java.util.ArrayList;

public class MyCalculator {

    public ArrayList<String> solutionHistory = new ArrayList<>();

    public int add(int a, int b) {
        int res = a+b;
        solutionHistory.add(a+"+"+b+"="+res);
        return res;
    }

    public int multiply(int a, int b) {
        int res = a*b;
        solutionHistory.add(a+"*"+b+"="+res);
        return res;
    }

    public int subtract(int a, int b) {
        int res = a-b;
        solutionHistory.add(a+"-"+b+"="+res);
        return res;
    }

    public double divide(int a, int b) {
        double res = a*1.0/b;
        solutionHistory.add(a+"/"+b+"="+res);
        return res;
    }

    public double root(int a) {
        double res = Math.sqrt(a);
        solutionHistory.add("sqrt("+a+")="+res);
        return res;
    }

    public int sqr(int a) {
        int res = a*a;
        solutionHistory.add("sqr("+a+")="+res);
        return res;
    }

    public void clearHistory() {
        solutionHistory.clear();
    }
}
