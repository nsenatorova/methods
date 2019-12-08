package ru.spbu.apmath.prog.methods;

class QuasiNewtonian {
    Vector quasiNewtonian(Vector v, Func func) {
        Vector grad;
        Vector[] I = new Vector[] {new Vector(1,0),new Vector(0,1)};
        Vector[] H0 = I;
        Vector dir;
        Vector[] H;
        Vector[] A;
        Vector[] B;
        Vector[] C;
        Vector v0 = v;
        Vector sk;
        Vector yk;
        double x1, x2, alpha;
        double a = 0;
        double b = 10;
        double eps = 0.0001;
        while (func.grad(v0).getNorm()> eps){
            grad = func.grad(v0);
            dir = Vector.multiplyMV(H0,grad.multiplyV(-1));
            do {
                double middle = (a + b) / 2;
                x1 = middle - 0.0005;
                x2 = middle + 0.0005;
                double i1 = func.val(v.addV(dir.multiplyV(x1)));//i1 = f(v + dir*x1)
                double i2 = func.val(v.addV(dir.multiplyV(x2)));
                if (i1 < i2) {
                    b = x2;
                } else {
                    a = x1;
                }
            } while (Math.abs(b - a) > eps);
            alpha = (a+b)/2;
            sk = dir.multiplyV(alpha);
            v0 = v.addV(sk);
            yk = func.grad(v0).substractV(func.grad(v));
            H = H0;
            A = Vector.substractM(I,Vector.multiplyM(Vector.multiplyVV(sk,yk),(1/yk.skalmul(sk))));
            B = Vector.substractM(I,Vector.multiplyM(Vector.multiplyVV(yk,sk),(1/yk.skalmul(sk))));
            C = Vector.multiplyM(Vector.multiplyVV(sk,sk),(1/yk.skalmul(sk)));
            H0 = Vector.addM(Vector.multiplyMM(Vector.multiplyMM(A,H),B),C);
            v = v0;
        }
        return v;
    }
}
