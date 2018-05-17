import edu.gwu.lintool.*;
import java.text.*;
import java.util.*;
import java.io.*;

public class TestA3 {

    public static void main (String[] argv)
    {
	LinTool lin = new MshendeLinTool ();
	// Test complex matrix operations.
  	LinTest.testComplexMatrices (lin);

	// REPLACE the line below with your tool.

 	LinTest.testAreColumnsLI (lin);
	LinTest.testGramSchmidt (lin);
	LinTest.testQR (lin);
    }

}
