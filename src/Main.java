//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LemurConfig config = new LemurConfig.Builder().
                                numberOfIterations(200).
                                numberOfDimensions(3).
                                numberOfSolutions(30).
                                lowerBound(-5.12).
                                upperBound(5.12).
                                highRiskRate(0.9).
                                lowRiskRate(0.1).
                                build();

        config.optimize();


    }
}