import java.util.ArrayList;
import java.util.Random;

public class Lemur {
     Double fitness;
     double[] valueOfDimensions;
     Lemur bestNearestLemur;
    static Lemur globalBestLemur;
    Random rnd=new Random();

    public Lemur(int numberOfDimensions, double upperBound, double lowerBound){
        valueOfDimensions=new double[numberOfDimensions];
        for(int i =0;i<valueOfDimensions.length;i++){
            valueOfDimensions[i]= rnd.nextDouble()*
                                 (upperBound-lowerBound)+lowerBound;
        }
    }

    public void calculateFitessValue(){
        double value=0;
        for(Double x: this.valueOfDimensions){
            value+=x;
        }
        fitness=value;
    }
    public void findBestNearestLemur(Lemur[] lemurs,int index){
        Lemur bestNearestLemur=lemurs[index];
        boolean isFounded = false;
        int i = index+1;
        int j = index-1;
        while (i < lemurs.length || j >= 0) {
            if (i < lemurs.length && lemurs[i].fitness > bestNearestLemur.fitness) {
                bestNearestLemur = lemurs[i];
                isFounded = true;
            }
            if (j >= 0 && lemurs[j].fitness > bestNearestLemur.fitness) {
                bestNearestLemur = lemurs[j];
                isFounded = true;
            }
            if (isFounded) {
                break;
            }
            i++;
            j--;
        }

        this.bestNearestLemur = bestNearestLemur;
    }
}