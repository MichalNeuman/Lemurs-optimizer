import java.util.Random;

public class LemurConfig {

    private final int numberOfIterations;
    private final int numberOfDimensions;
    private final int numberOfSolutions;
    private  final double lowerBound;
    private  final double upperBound;
    private final double lowRiskRate;
    private final double highRiskRate;
    private Random rnd=new Random();

    public static class Builder{
        private int numberOfIterations=0;
        private int numberOfDimensions=0;
        private int numberOfSolutions=0;
        private double lowerBound=0;
        private double upperBound=0;
        private double lowRiskRate=0;
        private double highRiskRate=0;

        public Builder numberOfIterations(int numberOfIterations){
            this.numberOfIterations=numberOfIterations;
            return this;
        }
        public Builder numberOfDimensions(int numberOfDimensions){
            this.numberOfDimensions=numberOfDimensions;
            return this;
        }

        public Builder lowerBound(double lowerBound){
            this.lowerBound=lowerBound;
            return this;
        }
        public Builder upperBound(double upperBound){
            this.upperBound=upperBound;
            return this;
        }
        public Builder numberOfSolutions(int numberOfSolutions){
            this.numberOfSolutions=numberOfSolutions;
            return this;
        }
        public Builder lowRiskRate(double lowRiskRate){
            this.lowRiskRate=lowRiskRate;
            return this;
        }
        public Builder highRiskRate(double highRiskRate){
            this.highRiskRate=highRiskRate;
            return this;
        }
        public LemurConfig build(){
            return new LemurConfig(this);
        }

    }

    private LemurConfig(Builder builder){

        this.numberOfIterations=builder.numberOfIterations;
        this.numberOfDimensions=builder.numberOfDimensions;
        this.numberOfSolutions=builder.numberOfSolutions;
        this.lowerBound=builder.lowerBound;
        this.upperBound= builder.upperBound;
        this.lowRiskRate =builder.lowRiskRate;
        this.highRiskRate=builder.highRiskRate;

    }
    public  double getLowerBound(){
        return lowerBound;
    }
    public  double getUpperBound(){
        return upperBound;
    }
    public int getNumberOfDimensions(){return numberOfDimensions;}
    public int getNumberOfSolutions(){return numberOfSolutions;}

    public  Lemur[] initializePopulation(){
        Lemur[] tab = new Lemur[numberOfSolutions];
        for(int i =0;i<numberOfSolutions;i++){
            tab[i]=(new Lemur(numberOfDimensions,upperBound,lowerBound));
        }
        return tab;
    }

    public double calculateFRR(int currIter) {
        return highRiskRate - currIter * ((highRiskRate - lowRiskRate) / numberOfIterations);
    }
    public void findGlobalBestLemur(Lemur[] tab){
        Lemur best=tab[0];
        for(Lemur x : tab){
            if(x.fitness<best.fitness){
                best=x;
            }
        }
        Lemur.globalBestLemur=best;
    }

    public void optimize(){
        Lemur[] tab= this.initializePopulation();

        for(int i =0;i<numberOfIterations;i++){
            System.out.println();
            System.out.println("Iteracja nr: " + i);
            for(int j =0;j<numberOfSolutions;j++){
                tab[j].calculateFitnessValue();
            }
            double fRR = calculateFRR(i);
            findGlobalBestLemur(tab);
            for(int j=0;j<numberOfSolutions;j++){
                tab[j].findBestNearestLemur(tab,j);
                for (int k=0;k<numberOfDimensions;k++){
                    double random= rnd.nextDouble();
                    if(random<fRR){
                        tab[j].valueOfDimensions[k]=tab[j].valueOfDimensions[k]+Math.abs
                                                    (tab[j].valueOfDimensions[k]-tab[j].bestNearestLemur.valueOfDimensions[k])
                                                    *(random-0.5)*2;
                    }else{
                        tab[j].valueOfDimensions[k]=tab[j].valueOfDimensions[k]+Math.abs
                                                    (tab[j].valueOfDimensions[k]-Lemur.globalBestLemur.valueOfDimensions[k])
                                                    *(random-0.5)*2;
                    }
                    // Clamping: Upewniamy się, że lemur nie wyjdzie poza granice
                    if(tab[j].valueOfDimensions[k]>upperBound){
                        tab[j].valueOfDimensions[k]=upperBound;
                    }if(tab[j].valueOfDimensions[k]<lowerBound){
                        tab[j].valueOfDimensions[k]=lowerBound;
                    }
                }
            }
            for (Lemur x : tab) {
                // Wyświetlanie wartości wymiarów w jednej linii
                for (double y : x.valueOfDimensions) {
                    System.out.printf("%15.20f ", y);
                }

                // Wyświetlanie wartości fitness i fitness najbliższego lemura
                System.out.printf("%15.20f %15.20f%n", x.fitness, x.bestNearestLemur.fitness);
            }

            System.out.println();
            System.out.printf("Wartość najlepszego lemura: %.20f%n", Lemur.globalBestLemur.fitness);

        }

    }
}
