package twiddle;

import java.util.ArrayList;

public class Param {

    private ArrayList<Double> params;
    private ArrayList<Double> deltas;
    private int dimension;

    public Param(ArrayList<Double> params, ArrayList<Double> deltas) {
        this.params = params;
        this.deltas = deltas;
        this.dimension = params.size();
    }

    public Param(int dimension) {
        this(new ArrayList<Double>(), new ArrayList<Double>());
        /** initialize randomly */
        for(int i = 0; i < dimension; i++) {
            this.params.add(Math.random());
            this.deltas.add(1.0);
        }
        this.dimension = dimension;
    }

    public ArrayList<Double> getDeltas() {
        return deltas;
    }

    public ArrayList<Double> getParams() {
        return params;
    }

    public int getDimension() {
        return dimension;
    }

    public double sumDeltas() {
        double sum = 0;
        for(double i : this.deltas)
            sum += i;
        return sum;
    }


    public void addDeltas(int index) {
        this.params.set(index, this.params.get(index) + this.deltas.get(index));
    }

    public void subtractTowDeltas(int index) {
        this.params.set(index, this.params.get(index) - (2 * this.deltas.get(index)));
    }

    public void multiplyDeltas(int index, double scalar) {
        this.deltas.set(index, this.deltas.get(index) * scalar);
    }

    @Override
    public String toString() {
        return new StringBuilder(params.toString()).append(";").append(deltas.toString()).toString();
    }

}
