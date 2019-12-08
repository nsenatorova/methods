package ru.spbu.apmath.prog.methods;

class ConjugateGradient {

    Vector conjugateGrad(Func func){
        double  a = 0;
        double  b = 10;
        int i = 1;
        double x1, x2, alpha, beta;

        Vector v = new Vector(2, 1);
        Vector grad = func.grad(v);
        Vector anti_grad = grad.multiply(-1);
        Vector direction_previous = anti_grad;
        Vector direction_current;

        double epsilon = 0.0001;
        while (func.grad(v).getNorm() > epsilon) {
            anti_grad = func.grad(v).multiply(-1);
            //ортогонализация Грама-Шмидта
            if (i == 1) {
                //первый вектор ортогон-ть не нужно
                direction_current = anti_grad;
            } else {
                //коэффициент для ортогонализации (x,y)/(y,y)
                beta = (anti_grad.skalm(anti_grad)) / (direction_previous.skalm(direction_previous));
                //найдем направление спуска g = x - beta*y
                direction_current = anti_grad.substract(direction_previous.multiply(beta));
                //System.out.println("Новое напрвление: " + direction_current.represent());
            }
            do {
                double middle = (a + b) / 2;
                x1 = middle - 0.0005;
                x2 = middle + 0.0005;
                double i1 = func.val(v.add(direction_current.multiply(x1)));
                double i2 = func.val(v.add(direction_current.multiply(x2)));
                if (i1 < i2) {
                    b = x2;
                } else {
                    a = x1;
                }
            } while (Math.abs(b - a) > epsilon);
            alpha = (a + b) / 2;
            v = v.add(direction_current.multiply(alpha));
            direction_previous = direction_current;
            //System.out.println("k = " + iter + " Точка: " + v.represent() + " Значение: " + ros.getValue(v));
            i++;

        }
        return v;
    }
}
