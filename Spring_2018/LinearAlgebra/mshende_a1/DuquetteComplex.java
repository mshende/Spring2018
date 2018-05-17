import edu.gwu.lintool.*;
import java.lang.Math;

public class DuquetteComplex extends ComplexNumber {

    public DuquetteComplex () {
        re = 0;
        im = 0;
    }

    public DuquetteComplex (double real, double imag) {
        im = imag;
        re = real;
    }

    public double magnitude () {
        return Math.sqrt(Math.pow(re, 2) + Math.pow(im, 2));
    }

    public double angle () {
        double angle = Math.atan2(im, re);
        if (angle < 0) {
            angle = angle + 2*Math.PI;
        }
        return angle;
    }

    public ComplexNumber add (ComplexNumber c) {
        DuquetteComplex b = (DuquetteComplex) c;
        return new DuquetteComplex(re+b.re, im+b.im);
    }

    public ComplexNumber sub (ComplexNumber c) {
        DuquetteComplex complexNumber = (DuquetteComplex) c;
        return new DuquetteComplex(re - complexNumber.re, im - complexNumber.im);
    }

    public ComplexNumber mult (ComplexNumber c) {
        DuquetteComplex complexNumber = (DuquetteComplex) c;
        return new DuquetteComplex(re*complexNumber.re - im*complexNumber.im, re*complexNumber.im + im*complexNumber.re);
    }

    public ComplexNumber mult (double a) {
        return new DuquetteComplex(re*a, im*a);
    }

    public ComplexNumber pow (int n) {
        DuquetteComplex complexNumber = this;
        for (int i = 2; i <= n; i++) {
            complexNumber = (DuquetteComplex) complexNumber.mult(this);
        }
        return complexNumber;
    }

    public ComplexNumber conjugate () {
        return new DuquetteComplex(re, im*(-1));
    }
}
