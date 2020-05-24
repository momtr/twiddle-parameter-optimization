import twiddle.Algorithm;
import twiddle.Param;

import java.util.ArrayList;

public class LinearModel implements Algorithm {

    private ArrayList<ArrayList<Double>> trainingX;
    private ArrayList<ArrayList<Double>> trainingY;

    public LinearModel(ArrayList<ArrayList<Double>> trainingX, ArrayList<ArrayList<Double>> trainingY) {
        this.trainingX = trainingX;
        this.trainingY = trainingY;
    }

    @Override
    public double process(Param p) {
        double error = 0;
        for(int i = 0; i < trainingX.size(); i++) {
            error += Math.pow(modelOutput(p, trainingX.get(i)).get(0) - trainingY.get(i).get(0), 2);
        }
        return error;
    }

    @Override
    public int getDimensionOfParams() {
        /** two dimensions: y = ax + b where {a;b} are params */
        return 2;
    }

    @Override
    public ArrayList<Double> modelOutput(Param p, ArrayList<Double> input) {
        /** y = ax + b */
        ArrayList<Double> ret = new ArrayList<Double>();
        ret.add(p.getParams().get(0) * input.get(0) + p.getParams().get(1));
        return ret;
    }

    @Override
    public void setTraningExamples(ArrayList<ArrayList<Double>> x, ArrayList<ArrayList<Double>> y) {
        this.trainingX = x;
        this.trainingY = y;
    }
}
