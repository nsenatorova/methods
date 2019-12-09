package ru.spbu.apmath.prog.methods;

class NelderMead {

    Vector nelderMead(int maxIter, Func func) {
        Vector v1 = new Vector(1, 1);
        Vector v2 = new Vector(0, 0);
        Vector v3 = new Vector(1, -1);

        Vector w = null;
        Vector g = null;
        Vector b = null;

        double alpha = 1;
        double beta = 0.5;
        double gamma = 2;

        for (int i = 0; i < maxIter; i++) {

            double func_v1 = func.val(v1);
            double func_v2 = func.val(v2);
            double func_v3 = func.val(v3);


            if (func_v3 <= func_v2 && func_v3 <= func_v1) {
                b = v3;
                if (func_v2 <= func_v1) {
                    g = v2;
                    w = v1;
                } else {
                    g = v1;
                    w = v2;
                }
            }
            if (func_v1 <= func_v2 && func_v1 <= func_v3) {
                b = v1;
                if (func_v2 <= func_v3) {
                    g = v2;
                    w = v3;
                } else {
                    g = v3;
                    w = v2;
                }
            }
            if (func_v2 <= func_v1 && func_v2 <= func_v3) {
                b = v2;
                if (func_v1 <= func_v3) {
                    g = v1;
                    w = v3;
                } else {
                    g = v3;
                    w = v1;
                }
            }

            Vector mid = new Vector((g.x + b.x) / 2, (g.x + b.x) / 2);
            Vector xr = new Vector((mid.x + alpha * (mid.x - w.x)), (mid.y + alpha * (mid.y - w.y)));

            if (func.val(xr) < func.val(g)) {
                w = xr;
            } else {
                if (func.val(xr) < func.val(w)) {
                    w = xr;
                }
                Vector c = w.addV(mid).multiplyV(0.5);
                if (func.val(c) < func.val(w)) {
                    w = c;
                }
            }

            if (func.val(xr) < func.val(b)) {
                Vector xe = new Vector((mid.x + gamma * (xr.x - mid.x)), (mid.y + gamma * (xr.y - mid.y)));
                if (func.val(xe) < func.val(xr)) {
                    w = xe;
                } else {
                    w = xr;
                }
            }
            if (func.val(xr) < func.val(g)) {
                Vector xc = new Vector((mid.x + beta * (w.x - mid.x)), (mid.y + beta * (w.y - mid.y)));
                if (func.val(xc) < func.val(w)) {
                    w = xc;
                }
            }
            v1 = w;
            v2 = g;
            v3 = b;

        }
        return b;
    }

}
