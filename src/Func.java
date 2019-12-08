package ru.spbu.apmath.prog.methods;

public interface Func {
    double val(Vector v);

    Vector grad(Vector v);
}
