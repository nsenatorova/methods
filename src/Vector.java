package ru.spbu.apmath.prog.methods;

class Vector {
    double x, y;

    Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    Vector addV(Vector another) {
        return new Vector(x + another.x, y + another.y);
    }

    Vector substractV(Vector another) {
        return new Vector(x - another.x, y - another.y);
    }

    Vector multiplyV(double a) {
        return new Vector(x * a, y * a);
    }

    static Vector[] multiplyVV(Vector v1, Vector v2) {
        Vector x = new Vector(v1.x * v2.x, v1.x * v2.y);
        Vector y = new Vector(v1.y * v2.x, v1.y * v2.y);
        return new Vector[]{x, y};
    }


    static Vector[] addM(Vector[] m1, Vector[] m2) {
        Vector x1 = new Vector(m1[0].x + m2[0].x, m1[0].y + m2[0].y);
        Vector x2 = new Vector(m1[1].x + m2[1].x, m1[1].y + m2[1].y);
        return new Vector[]{x1, x2};
    }

    static Vector[] substractM(Vector[] m1, Vector[] m2) {
        return Vector.addM(m1, Vector.multiplyM(m2, (-1)));
    }

    static Vector[] multiplyM(Vector[] m, double a) {
        m[0].x = m[0].x * a;
        m[0].y = m[0].y * a;
        m[1].x = m[1].x * a;
        m[1].y = m[1].y * a;
        return m;
    }

    static Vector[] multiplyMM(Vector[] m1, Vector[] m2) {
        Vector x1 = new Vector(m1[0].x * m2[0].x + m1[0].y * m2[1].x, m1[0].x * m2[0].y + m1[0].y * m2[1].y);
        Vector x2 = new Vector(m1[1].x * m2[0].x + m1[1].y * m2[1].x, m1[1].x * m2[0].y + m1[1].y * m2[1].y);
        return new Vector[]{x1, x2};
    }

    static Vector multiplyMV(Vector[] m, Vector v) {
        double x = m[0].x * v.x + m[0].y * v.y;
        double y = m[1].x * v.x + m[1].y * v.y;
        return new Vector(x, y);
    }

    double skalmul(Vector another) {
        return (x * another.x + y * another.y);
    }

    double getNorm() {
        return Math.sqrt(x * x + y * y);
    }

    String repr() {
        return "(" + x + ", " + y + ")";
    }
}
