package ru.spbu.apmath.prog.methods;

class ConjugateGradient {

    Vector conjugateGrad(Func func) {
        double a = 0, b = 10;
        double x1, x2, alpha, beta;
        int i = 1;
        Vector v = new Vector(2, 1);
        Vector anti_grad = func.grad(v).multiplyV(-1);
        Vector direct_previous = anti_grad;
        Vector direct_current;

        double epsilon = 0.0011;
        while (func.grad(v).getNorm() > epsilon) {
            anti_grad = func.grad(v).multiplyV(-1);
            if (i == 1) {
                direct_current = anti_grad;
            } else {
                beta = (anti_grad.skalmul(direct_previous)) / (direct_previous.skalmul(direct_previous));
                direct_current = anti_grad.substractV(direct_previous.multiplyV(beta));
            }
            do {
                double middle = (a + b) / 2;
                x1 = middle - 0.0005;
                x2 = middle + 0.0005;
                double i1 = func.val(v.addV(direct_current.multiplyV(x1)));
                double i2 = func.val(v.addV(direct_current.multiplyV(x2)));
                if (i1 < i2) {
                    b = x2;
                } else {
                    a = x1;
                }
            } while (Math.abs(b - a) > epsilon);
            alpha = (a + b) / 2;
            v = v.addV(direct_current.multiplyV(alpha));
            direct_previous = direct_current;
            i++;

        }
        System.out.println(i + " итераций");
        return v;
    }
}
