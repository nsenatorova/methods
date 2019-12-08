package ru.spbu.apmath.prog.methods;

import java.util.ArrayList;
import java.util.List;

public class Vector {
    public double x, y;
    Vector(double x, double y){
        this.x=x;
        this.y=y;
    }

    String represent(){
        return "("+ x +", "+ y +")";
    }
    public List<Double> coord() {
        ArrayList<Double> coord = new ArrayList<>();
        coord.add(x);
        coord.add(y);
        return coord;
    }
    double getNorm() {
        return Math.sqrt((x * x) + (y * y));
    }
    Vector add(Vector other){
        return new Vector(x+other.x, y+other.y);
    }
    Vector substract(Vector other){
        return new Vector(x-other.x, y-other.y);
    }
    Vector multiply(double a){
        return new Vector(x*a,y*a);
    }
    double skalm(Vector another){
        return (x*another.x + y*another.y);
    }
    public double[] getValue(){
        return new double[] {x,y};
    }
}
