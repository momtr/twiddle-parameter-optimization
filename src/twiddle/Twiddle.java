package twiddle;

public class Twiddle {

    private Algorithm algo;
    private Param currentParams;
    private double threshold;
    private double bestError;

    public Twiddle(Algorithm algo, double threshold) {
        this.algo = algo;
        currentParams = new Param(algo.getDimensionOfParams());
        this.threshold = threshold;
        bestError = algo.process(currentParams);
    }

    public Param optimizeParams() {
        while(currentParams.sumDeltas() > this.threshold) {
            for(int i = 0; i < algo.getDimensionOfParams(); i++) {
                currentParams.addDeltas(i);
                double err = algo.process(currentParams);
                if(err < bestError) {
                    bestError = err;
                    currentParams.multiplyDeltas(i, 1.1);
                } else {
                    currentParams.subtractTowDeltas(i);
                    err = algo.process(currentParams);
                    if(err < bestError) {
                        bestError = err;
                        currentParams.multiplyDeltas(i, 1.05);
                    } else {
                        currentParams.addDeltas(i);
                        currentParams.multiplyDeltas(i, 0.95);
                    }
                }
            }
        }
        return currentParams;
    }

    public Algorithm getAlgo() {
        return algo;
    }

    public Param getCurrentParams() {
        return currentParams;
    }

    public double getThreshold() {
        return threshold;
    }

}
