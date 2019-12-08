package ru.spbu.apmath.prog.methods;

import static java.lang.Math.*;
import static java.lang.Math.exp;

class GoldenSection {
    double goldensection(double a, double b) {
        int i = 0;
        double x;
        double l = -1000;
        double r = 1000;
        double epsilon = 0.0000001;
        double gs = (1 + sqrt(5)) / 2;
        while (abs(r - l) >= epsilon) {
            i++;
            double x1 = r - (r - l) / gs;
            double x2 = l + (r - l) / gs;
            double f1 = a * x1 + b / (exp(x1));
            double f2 = a * x2 + b / (exp(x2));
            if (f1 >= f2) {
                l = x1;
            } else {
                r = x2;
            }
        }
        System.out.println(i + " итераций");
        x = (r + l) / 2;
        System.out.println("x = " + x);
        return a * x + b / (exp(x));
    }
}
