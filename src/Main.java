//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LemurConfig config = new LemurConfig.Builder().
                                numberOfIterations(150).
                                numberOfDimensions(2).
                                numberOfSolutions(30).
                                lowerBound(-10000).
                                upperBound(10000).
                                highRiskRate(0.6).
                                lowRiskRate(0.4).
                                build();

        config.optimize();


    }
}