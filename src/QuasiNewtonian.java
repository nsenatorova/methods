package ru.spbu.apmath.prog.methods;

public class QuasiNewtonian {
    private double eps = 0.0011;
    public Vector quasiNewtonian(Vector v, Func func) {
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
        double iter = 1,
                a = 0,
                b = 10,
                x1,
                x2,
                alpha;
        while (func.grad(v0).getNorm()>eps){
            grad = func.grad(v0);
            dir = Vector.mulMatVect(H0,grad.mul(-1));
            do {
                double middle = (a + b) / 2;
                x1 = middle - 0.0005;
                x2 = middle + 0.0005;
                double i1 = fun.getValue(v.add(dir.mul(x1)));
                double i2 = fun.getValue(v.add(dir.mul(x2)));
                if (i1 < i2) {
                    b = x2;
                } else {
                    a = x1;
                }
            } while (Math.abs(b - a) > eps);
            alpha = (a+b)/2;
            sk = dir.multiply(alpha);
            v0 = v.add(sk);
            yk = func.getDer(v0).sub(func.grad(v));
            H = H0;
            A = Vector.sub(I,Vector.mul(Vector.mulVect(sk,yk),(1/yk.skalm(sk))));
            B = Vector.substract(I,Vector.mul(Vector.mulVect(yk,sk),(1/yk.skalm(sk))));
            C = Vector.multiply(Vector.mulVect(sk,sk),(1/yk.skalm(sk)));
            H0 = Vector.add(Vector.prodmm(Vector.prodmm(A,H),B),C);
            v = v0;
            iter++;
        }
        return v;
    }
}
