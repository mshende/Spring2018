// Instructions:
// 1. Write code to implement vector addition and scalar multiplication
// 2. Then compile and execute.

public class LinCombExample2 {

    public static void main (String[] argv) 
    {
	DrawTool.display ();
	DrawTool.setXYRange (-10,10, -10,10);
	DrawTool.drawMiddleAxes (true);

	double[] u = {1,4};
	double[] v = {3,2};
	double alpha = 1.5,  beta = 2;
	double[] z = add (scalarMult(alpha, u), scalarMult(beta,v));
	DrawTool.setArrowColor ("blue");
	DrawTool.drawVector (z);
    }

    static double[] add (double[] u, double[] v)
    {
	// INSERT YOUR CODE HERE
	double resultX = u[0] + v[0];
	double resultY = u[1] + v[1];
	double[] result = {resultX, resultY};
	return result;

    }

    static double[] scalarMult (double alpha, double[] v)
    {
    	// INSERT YOUR CODE HERE
	double resultX = alpha*v[0];
	double resultY = alpha*v[1];
	double[] result = {resultX, resultY};
	return result;
    }

}
