package twiddle;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.SplittableRandom;

public class TrainingData {

    private ArrayList<ArrayList<Double>> trainingX;
    private ArrayList<ArrayList<Double>> trainingY;

    public TrainingData() {
        trainingX = new ArrayList<ArrayList<Double>>();
        trainingY = new ArrayList<ArrayList<Double>>();
    }

    public void fromFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String line = br.readLine();
        while(line != null && line.length() > 0) {
            if(line.indexOf("//") == -1) {
                String[] row = line.split(" A ");
                String[] row_x = row[0].split(";");
                String[] row_y = row[1].split(";");
                ArrayList<Double> x = new ArrayList<Double>();
                ArrayList<Double> y = new ArrayList<Double>();
                for(int i = 0; i < row_x.length; i++) {
                    try {
                        x.add(Double.parseDouble(row_x[i]));
                    } catch (Exception e) { break; }
                }
                for(int i = 0; i < row_y.length; i++) {
                    try {
                        y.add(Double.parseDouble(row_y[i]));
                    } catch (Exception e) { break; }
                }
                this.trainingX.add(x);
                this.trainingY.add(y);
            }
            line = br.readLine();
        }
    }

    public ArrayList<ArrayList<Double>> getTrainingX() {
        return trainingX;
    }

    public ArrayList<ArrayList<Double>> getTrainingY() {
        return trainingY;
    }

}
