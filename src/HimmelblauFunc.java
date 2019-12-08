package ru.spbu.apmath.prog.methods;

public class HimmelblauFunc implements Func {
    public double b;
    public double a;
    HimmelblauFunc(double a, double b){
        this.a = a;
        this.b = b;
    }
    public double val(Vector v){
        double x = v.x;
        double y = v.y;
        return Math.pow((Math.pow(x,2) + y - a),2) + Math.pow((x + Math.pow(y,2) - b),2);
    }
    public Vector grad(Vector v){
        double x = v.x;
        double y = v.y;
        double dx = 2*(Math.pow(x,2) + y -a)*2*x + 2*(x + Math.pow(y,2) - b);
        double dy = 2*(Math.pow(x,2) + y -a) + 2*(x + Math.pow(y,2) - b)*2*y;
        return new Vector(dx, dy);
    }
}
