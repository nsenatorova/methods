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
        NewFunc func = new NewFunc(a, b);

        System.out.println("Метод дихотомии:");
        System.out.println("Значение ф-ции: " + func.val(d.dichotomy(a, b)));
        System.out.println();

        System.out.println("Метод золотого сечения:");
        System.out.println("Значение ф-ции: " + func.val(g.goldensection(a, b)));
        System.out.println();

        System.out.println("Многомерная оптимизация:");
        Vector v = new Vector(10, 10);
        System.out.println("Ф-ция Розенброка");
        System.out.println("a = "); //1
        double a1 = s.nextDouble();
        System.out.println("b = ");//5
        double b1 = s.nextDouble();
        RosenbrockFunc ros = new RosenbrockFunc(a1, b1);

        System.out.println("Метод Нелдера-Мида для ф-ции Розенброка:");
        System.out.println("Минимум в: " + nd.nelderMead(100, ros).repr());
        System.out.println("Значение ф-ции: " + ros.val(nd.nelderMead(100, ros)));
        System.out.println();

        System.out.println("Метод градиентного спуска для ф-ции Розенброка:");
        System.out.println("Минимум в: " + gd.gradientDescent(v, ros).repr());
        System.out.println("Значение ф-ции: " + ros.val(gd.gradientDescent(v, ros)));
        System.out.println();

        System.out.println("Квазиньютоновский метод для ф-ции Розенброка:");
        System.out.println("Минимум в: " + qn.quasiNewtonian(v, ros).repr());
        System.out.println("Значение ф-ции: " + ros.val(qn.quasiNewtonian(v, ros)));
        System.out.println();

        System.out.println("Метод сопряженных градиентов для ф-ции Розенброка:");
        System.out.println("Минимум в: " + cg.conjugateGrad(ros).repr());
        System.out.println("Значение ф-ции: " + ros.val(cg.conjugateGrad(ros)));
        System.out.println();


        System.out.println("Ф-ция Химмельблау");
        System.out.println("a = ");//11
        double a2 = s.nextDouble();
        System.out.println("b = ");//7
        double b2 = s.nextDouble();
        HimmelblauFunc him = new HimmelblauFunc(a2, b2);

        System.out.println("Метод Нелдера-Мида для ф-ции Химмельблау:");
        System.out.println("Минимум в: " + nd.nelderMead(100, him).repr());
        System.out.println("Значение ф-ции: " + him.val(nd.nelderMead(100, him)));
        System.out.println();

        System.out.println("Метод градиентного спуска для ф-ции Химмельблау:");
        System.out.println("Минимум в: " + gd.gradientDescent(v, him).repr());
        System.out.println("Значение ф-ции: " + him.val(gd.gradientDescent(v, him)));
        System.out.println();

        System.out.println("Квазиньютоновский метод для ф-ции Химмельблау:");
        System.out.println("Минимум в: " + qn.quasiNewtonian(v, him).repr());
        System.out.println("Значение ф-ции: " + him.val(qn.quasiNewtonian(v, him)));
        System.out.println();

        System.out.println("Метод сопряженных градиентов для ф-ции Химмельблау:");
        System.out.println("Минимум в: " + cg.conjugateGrad(him).repr());
        System.out.println("Значение ф-ции: " + him.val(cg.conjugateGrad(him)));

    }
}
