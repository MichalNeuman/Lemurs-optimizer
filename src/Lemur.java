import java.util.Random;

public class Lemur {
     double fitness;
     double[] valueOfDimensions;
     Lemur bestNearestLemur;
    static Lemur globalBestLemur;
    private Random rnd=new Random();

    public Lemur(int numberOfDimensions, double upperBound, double lowerBound){
        valueOfDimensions=new double[numberOfDimensions];
        for(int i =0;i<valueOfDimensions.length;i++){
            valueOfDimensions[i]= rnd.nextDouble()*
                                 (upperBound-lowerBound)+lowerBound;
        }
    }
    //Funkcja Rastrigina
    public void calculateFitnessValue(){
        double A = 10;
        double result = A * valueOfDimensions.length; // A * 3 dla trzech wymiarów
        for (double value : valueOfDimensions) {
            result += (value * value - A * Math.cos(2 * Math.PI * value));
        }
        fitness=result;
    }
    public void findBestNearestLemur(Lemur[] lemurs,int index){
        Lemur bestNearestLemur=lemurs[index];
        boolean isFounded = false;
        int i = index+1;
        int j = index-1;
            if(bestNearestLemur.fitness==globalBestLemur.fitness){
                this.bestNearestLemur = bestNearestLemur;
                return;
            }
            while (i < lemurs.length || j >= 0) {
                if (i < lemurs.length && lemurs[i].fitness < bestNearestLemur.fitness) {
                    bestNearestLemur = lemurs[i];
                }
                if (j >= 0 && lemurs[j].fitness < bestNearestLemur.fitness) {
                    bestNearestLemur = lemurs[j];
                }
                if (bestNearestLemur != lemurs[index]) {
                    break;
                }
                i++;
                j--;
            }
        this.bestNearestLemur = bestNearestLemur;
    }
}