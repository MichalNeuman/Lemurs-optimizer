public class LemurConfig {

    private final int numberOfIterations;
    private final int numberOfDimensions;
    private final int numberOfSolutions;
    private  final int lowerBound;
    private  final int upperBound;
    private final double lowRiskRate;
    private final double highRiskRate;




    public static class Builder{
        private int numberOfIterations=0;
        private int numberOfDimensions=0;
        private int numberOfSolutions=0;
        private int lowerBound=0;
        private int upperBound=0;
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

        public Builder lowerBound(int lowerBound){
            this.lowerBound=lowerBound;
            return this;
        }
        public Builder upperBound(int upperBound){
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


    public  int getLowerBound(){
        return lowerBound;
    }
    public  int getUpperBound(){
        return upperBound;
    }
    public int getNumberOfDimensions(){return numberOfDimensions;}
    public int getNumberOfSolutions(){return numberOfSolutions;}

}
