
public class PlotSin3 {

    public static void main (String[] argv)
    {
        Function F1 = new Function ("ph=0");
	Function F2 = new Function ("ph=p/4");
	Function F3 = new Function ("ph=p/2");
	Function F4 = new Function ("ph=p");

        for (double x=0; x<=1; x+=0.005) {
	    F1.add (x, Math.cos(2*Math.PI*x));
	    F2.add (x, Math.cos(2*Math.PI*x + Math.PI/4));
	    F3.add (x, Math.cos(2*Math.PI*x + Math.PI/2));
	    F4.add (x, Math.cos(2*Math.PI*x + Math.PI));
            // INSERT YOUR CODE HERE:
        }
        Function.show (F1, F2, F3, F4);
    }
    
}