import twiddle.Algorithm;
import twiddle.Param;
import twiddle.TrainingData;
import twiddle.Twiddle;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        TrainingData data = new TrainingData();
        data.fromFile("trainingData.csv");
        Algorithm algo = new LinearModel(data.getTrainingX(), data.getTrainingY());
        Twiddle twiddle = new Twiddle(algo, 0.00001);
        System.out.println("optimized parameters: " + twiddle.optimizeParams().getParams().toString());

    }

}
