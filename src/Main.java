//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LemurConfig config = new LemurConfig.Builder().
                                numberOfIterations(5).
                                numberOfDimensions(3).
                                numberOfSolutions(4).
                                lowerBound(-10).
                                upperBound(10).
                                highRiskRate(0.6).
                                lowRiskRate(0.4).
                                build();

        Lemur.initializePopulation(config);

    }
}