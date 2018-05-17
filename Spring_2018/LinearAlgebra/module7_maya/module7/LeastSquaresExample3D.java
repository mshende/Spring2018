// Instructions:
// (1) Insert code to compute the least squares solution. Compile and
//     execute to verify the same solution as you had before.
// (2) Change the matrix by adding the column (8,1,0) and see what happens.
//
// NOTE: you will need lintool.jar in your CLASSPATH. 

import edu.gwu.lintool.*;
import org.edisonwj.draw3d.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.stage.*;

import java.util.*;

public class LeastSquaresExample3D extends Application {

    String title = "least squares example";

    void drawingCommands() {
        DuquetteLinTool linTool = new DuquetteLinTool();

        // RHS b
        double[] b = {5, 6, 3};
        d3.setDrawColor(Color.BLUE);
        d3.drawVector(b);

        // Two columns of the matrix (just for drawing).
        double[] c1 = {6, 2, 0};
        double[] c2 = {4, 3, 0};
        double[] c3 = {8, 1, 0};
        d3.drawVector(c1);
        d3.drawVector(c2);
        d3.drawVector(c3);

        // The matrix
        double[][] A = {
                {6, 4, 8},
                {2, 3, 1},
                {0, 0, 0}
        };

        // INSERT YOUR CODE HERE:

        // Compute the transpose of A:
        double[][] AT = linTool.transpose(A);

        // Multiply A by AT (with AT on the left)
        double[][] ATA = linTool.mult(AT, A);

        // Get the inverse of ATA:
        LinResult L = linTool.inverse(ATA);
        if (L.Ainv == null) {
            System.out.println("No inverse exists for ATA");
            System.exit(0);
        }
        linTool.print(L.Ainv);

        // Compute approx solution x = ATA^-1 * A^T * b in two steps:
        // Step 1: first compute AT * b
        double[] ATb = linTool.matrixVectorMult(AT, b);
        // Step 2: multiply the result on the left by ATA^-1
        double[] x = linTool.matrixVectorMult(L.Ainv, ATb);

        System.out.println("x[0]=" + x[0] + " x[1]=" + x[1]);

        // Use x[0],x[1] in the linear combination of c1, c2:
        double[] y = linTool.add(
                linTool.scalarProduct(x[0], c1),
                linTool.scalarProduct(x[1], c2)
        );
        y = linTool.add(y, MatrixTool.scalarProduct(x[2], c3));

        // The difference vector z:
        double[] z = linTool.sub(b, y);

        // Draw y and z:
        d3.setDrawColor(Color.GREEN);
        d3.drawVector(y);
        d3.setDrawColor(Color.RED);
        d3.drawArrow(y[0], y[1], y[2], b[0], b[1], b[2]);
    }

    // No need to read further
    //////////////////////////////////////////////////////////

    Draw3D d3;

    void preambleCommands() {
        d3.setAmbientLight(false);
        d3.setPointLight(true);
        d3.setCumulate(false);
        d3.setSequencingOn();
        d3.setVectorRadius(1);
        d3.setArrowRadius(1);
    }

    public void start(Stage primaryStage) {
        d3 = new Draw3D();
        Scene scene = d3.buildScene();
        preambleCommands();
        drawingCommands();
        d3.setStart();
        primaryStage.setScene(scene);
        primaryStage.setTitle(title);
        primaryStage.show();
    }

    public static void main(String[] argv) {
        launch(argv);
    }

}
