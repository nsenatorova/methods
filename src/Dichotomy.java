package ru.spbu.apmath.prog.methods;

import static java.lang.Math.abs;
import static java.lang.Math.exp;

class Dichotomy {
    double dichotomy(double a, double b) {
        int i = 0;
        double x;
        double l = -1000;
        double r = 1000;
        double del = 0.0000001;
        double epsilon = 2 * del + 0.0000001;
        while (abs((r - l)) >= epsilon) {
            i++;
            x = (r + l) / 2;
            double x1 = x - del;
            double x2 = x + del;
            double f1 = a * x1 + b / (exp(x1));
            double f2 = a * x2 + b / (exp(x2));
            if (f1 < f2) {
                r = x;
            } else {
                l = x;
            }
        }
        System.out.println(i + " итераций");
        x = (r + l) / 2;
        System.out.println("x = " + x);
        return a * x + b / (exp(x));
    }
}
