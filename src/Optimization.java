package ru.spbu.apmath.prog.methods;

import java.util.Scanner;

public class Optimization {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Dichotomy d = new Dichotomy();
        GoldenSection g = new GoldenSection();

        NelderMead nd = new NelderMead();
        GradientDescent gd = new GradientDescent();
        ConjugateGradient cg = new ConjugateGradient();
        QuasiNewtonian qn = new QuasiNewtonian();

        System.out.println("Одномерная оптимизация:");
        System.out.println("a = ");
        double a = s.nextDouble();
        System.out.println("b = ");
        double b = s.nextDouble();
        System.out.println("f(x) =  " + a + "*x" + " + (" + b + ")/e^x");

        System.out.println("Метод дихотомии:");
        System.out.println(d.dichotomy(a, b));
        System.out.println("Метод золотого сечения:");
        System.out.println(g.goldensection(a, b));
        System.out.println();

        System.out.println("Многомерная оптимизация:");
        Vector v  = new Vector(10,10);
        System.out.println("Ф-ция Розенброка");
        System.out.println("a = "); //1
        double a1 = s.nextDouble();
        System.out.println("b = ");//5
        double b1 = s.nextDouble();
        RosenbrockFunc ros = new RosenbrockFunc(a1, b1);
        System.out.println("Метод Нелдера-Мида для ф-ции Розенброка:");
        System.out.println(nd.nelderMead(10,ros).repr());
        System.out.println("Метод градиентного спуска для ф-ции Розенброка:");
        System.out.println(gd.gradientDescent(v,ros).repr());
        System.out.println("Квазиньютоновский метод для ф-ции Розенброка:");
        System.out.println(qn.quasiNewtonian(v,ros).repr());


        System.out.println("Ф-ция Химмельблау");
        System.out.println("a = ");//11
        double a2 = s.nextDouble();
        System.out.println("b = ");//7
        double b2 = s.nextDouble();
        HimmelblauFunc him = new HimmelblauFunc(a2,b2);
        System.out.println("Метод Нелдера-Мида для ф-ции Химмельблау:");
        System.out.println(nd.nelderMead(100,him).repr());
        System.out.println("Метод градиентного спуска для ф-ции Химмельблау:");
        System.out.println(gd.gradientDescent(v,him).repr());
        System.out.println("Квазиньютоновский метод для ф-ции Химмельблау:");
        System.out.println(qn.quasiNewtonian(v,him).repr());
        System.out.println("Метод сопряженных градиентов для ф-ции Химмельблау:");
        System.out.println(cg.conjugateGrad(him).repr());

    }
}
