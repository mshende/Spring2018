import edu.gwu.lintool.*;
import java.text.*;
import java.util.*;
import java.io.*;

public class TestA1Courtney {

    public static void main (String[] argv) {
        // Make an instance of your ComplexNumber class. REPLACE
        // AliceComplex below with your version.
        DuquetteComplex c = new DuquetteComplex (3, 5);

        // This tests your implementation of complex numbers.
        LinTest.testComplex (c);

        // REPLACE the line below with your tool, and un-comment.
        //DuquetteLinTool lin = new DuquetteLinTool ();

        // Un-comment tests one by one until all are passed.
        //LinTest.testVectorOperations (lin);
        //LinTest.testMatrixOperations (lin);
    }

}
