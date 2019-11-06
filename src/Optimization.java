package ru.spbu.apmath.prog.methods;

import java.util.Scanner;

public class Optimization {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Dichotomy d = new Dichotomy();
        GoldenSection g = new GoldenSection();
        System.out.println("a = ");
        double a = s.nextDouble();
        System.out.println("b = ");
        double b = s.nextDouble();
        System.out.println("f(x) =  " + a + "*x" + " + (" + b + ")/e^x");
        System.out.println("Dichotomy:");
        System.out.println(d.dichotomy(a, b));
        System.out.println("Golden Section:");
        System.out.println(g.goldensection(a, b));
    }
}
