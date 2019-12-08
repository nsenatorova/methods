package ru.spbu.apmath.prog.methods;

public class RosenbrockFunc implements Func{
    public double b;
    public double a;
    RosenbrockFunc(double a, double b){
        this.a = a;
        this.b = b;
    }
    public double val(Vector v){
        double x = v.x;
        double y = v.y;
        return Math.pow((a-x),2) + b*Math.pow((y - Math.pow(x,2)),2);
    }
    public Vector grad(Vector v){
        double x = v.x;
        double y = v.y;
        double dx = (-2)*(a-x) - 4*b*(y - Math.pow(x,2))*x;
        double dy = 2*b*(y-Math.pow(x,2));
        return new Vector(dx, dy);
    }
}
