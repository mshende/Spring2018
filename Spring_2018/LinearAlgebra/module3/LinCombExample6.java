
public class LinCombExample6 {

    public static void main (String[] argv) 
    {
	DrawTool.display ();
	DrawTool.setXYRange (-10,10, -10,10);
	DrawTool.drawMiddleAxes (true);

	double[] u = {1, 4};
	double[] v = {3, 2};
	double[] w = {-1, 1};
	double[] z = {7.5, 10};
	// INSERT YOUR CODE HERE.
	DrawTool.setArrowColor ("blue");
	DrawTool.drawVector (u);
	DrawTool.drawVector (v);
	DrawTool.drawVector (w);
	DrawTool.setArrowColor ("green");
	DrawTool.drawVector (z);
    }

}
