package twiddle;

import java.io.Serial;
import java.util.ArrayList;

public interface Algorithm {

    /**
     * Algorithm processes data with specified params and returns the error
     * A( p ) -> error
     * @param p Patrameter
     * @return error : double
     */
    public double process(Param p);

    /**
     * Returns the dimension of the params
     * @return diemtnstion of params : int
     */
    public int getDimensionOfParams();

    /**
     * Returns the model's output for specified inputs
     * @param input ArrayList of inputs
     * @return the model's output
     */
    public ArrayList<Double> modelOutput(Param p, ArrayList<Double> input);

    /**
     * Sets the training examples (x,y) pairs
     * @param x array list containing array lists of x_i values
     * @param y array list containing array lists of y_i values
     */
    public void setTraningExamples(ArrayList<ArrayList<Double>> x, ArrayList<ArrayList<Double>> y);

}