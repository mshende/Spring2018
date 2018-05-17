import edu.gwu.lintool.*;

public class MshendeComplex extends ComplexNumber {

    public MshendeComplex (double real, double imag) {
	re = real;
	im = imag;
    }

    public MshendeComplex () {
	re = 0;
	im = 0;
    }

    public double magnitude () {
	double mag = Math.sqrt(re*re + im*im);
	return mag;
    }

    public double angle () {
	double result = Math.atan2(im,re);
	if (result < 0) {
	    result = result + 2*Math.PI;
	}
	return result;
    }

    public ComplexNumber add (ComplexNumber c) {
	MshendeComplex b = (MshendeComplex) c;
	return new MshendeComplex (re+b.re, im+b.im);
    }

    public ComplexNumber sub (ComplexNumber c) {
	 MshendeComplex b = (MshendeComplex) c;
	 return new MshendeComplex (re-b.re, im-b.im);
    }

    public ComplexNumber mult (ComplexNumber c) {
	MshendeComplex b = (MshendeComplex) c;
	double newReal = (re*b.re) - (im*b.im);
	double newImag = (re*b.im) + (im*b.re);
	return new MshendeComplex (newReal, newImag);
    }

    public ComplexNumber mult (double a) {
	return new MshendeComplex (a*re, a*im);
    }

    public ComplexNumber pow (int n) {
	MshendeComplex result = new MshendeComplex();
	if (n==0) {
	    result = new MshendeComplex(re,im);
	}
	else{
	    MshendeComplex temp = new MshendeComplex(re,im);
	    result = (MshendeComplex) mult(temp);
	    for (int i=2;i<n;i++) {
		result = (MshendeComplex) mult(result);
	    }
	}
	return result;
    }
    
    public ComplexNumber conjugate () {
	return new MshendeComplex (re, -im);
    }
    
}