
import org.edisonwj.draw3d.*;
import edu.gwu.lintool.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.stage.*;
import java.util.*;

public class SVDExample3D extends Application {

    String title = "SVD Example in 3D";

    void drawingCommands () 
    {
	// Word-document matrix (based on frequency counts of occurrence).
	double[][] D = {
	    {0.9, 0.8, 0.1, 0.2, 0.9},
	    {0.1, 0.2, 0.9, 0.8, 0.9},
	    {0.9, 0.8, 0.9, 0.8, 0.9},
	};


	// Even though this data is NOT a candidate for PCA, we'll
	// apply PCA just to contrast.

	// PCA #1: normalize.
	double[][] X = SVDStats.normalizeData (D);
	LinUtil.print ("X", X);
	// PCA #2: X*X^T
	double[][] XT = SVDStats.transpose (X);
	double[][] C = SVDStats.matrixMult (X, XT);
	// PCA #3: Eigenvectors of C.
	LinResult L = LinToolLibrary.computeEigenvaluesAndVectors (C);
	double[][] S = SVDStats.reverseColumns (L.S);
	double[][] ST = SVDStats.transpose (S);
	// PCA #4: Change coords.
	double[][] Y = SVDStats.matrixMult (ST, X);

	// Print PCA results: Covariance of transformed data:
	double[][] YT = SVDStats.transpose (Y);
	double[][] C2 = SVDStats.matrixMult (Y, YT);
	LinUtil.print ("C", C);
	LinUtil.print ("C2", C2);
	// Does it provide insight?

	// Now, on to SVD.

	// SVD #1: normalize (already done above).

	// SVD #2: Compute SVD.
	// The library method works directly with the centered data.
	LinResult L2 = LinToolLibrary.computeSVDShortForm (X);

	// Print the rank to see if new zero-rows need to be added.
	System.out.println ("SVD rank: " + L2.rank);

	// SVD #3: Transform coordinates: UT*X
	double[][] U = L2.U;
	double[][] UT = SVDStats.transpose (U);
	double[][] Yp = SVDStats.matrixMult (UT, X);
	LinUtil.print ("Yp", Yp);

	// Draw original data.
	d3.setXYZRange (1,1,1);
	d3.setDrawColor (Color.BLUE);
	for (int i=0; i<X[0].length; i++) {
	    // i-th column is what we want to draw.
	    double[] x = new double [3];
	    for (int k=0; k<3; k++) {
		x[k] = X[k][i];
	    }
	    d3.drawSphere (x[0], x[1], x[2], 0.03);
	}

	// Draw new PCA coordinates.
	d3.setDrawColor (Color.RED);
	for (int i=0; i<Y[0].length; i++) {
	    // i-th column is what we want to draw.
	    double[] y = new double [3];
	    for (int k=0; k<3; k++) {
		y[k] = Y[k][i];
	    }
	    d3.drawSphere (y[0], y[1], y[2], 0.03);
	}

	// Draw new document vectors after SVD.
	d3.setDrawColor (Color.GREEN);
	for (int i=0; i<Yp[0].length; i++) {
	    // i-th column is what we want to draw.
	    double[] y = new double [3];
	    for (int k=0; k<3; k++) {
		y[k] = Yp[k][i];
	    }
	    d3.drawVector (y);
	}

    }


    // No need to read further
    //////////////////////////////////////////////////////////

    Draw3D d3;

    void preambleCommands ()
    {
	d3.setAmbientLight(false);
	d3.setPointLight(true);
	d3.setCumulate(false);
	d3.setSequencingOn();
	d3.setVectorRadius(1);
        d3.setArrowRadius(1);
    }

    public void start (Stage primaryStage) 
    {
	d3 = new Draw3D ();
	Scene scene = d3.buildScene ();
	preambleCommands ();
	drawingCommands ();
	d3.setStart ();
	primaryStage.setScene (scene);
	primaryStage.setTitle (title);
	primaryStage.show ();
    }

    public static void main (String[] argv)
    {
	launch (argv);
    }

}

