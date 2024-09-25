import java.util.ArrayList;
import java.util.Random;

public class Lemur {

    Double fitness;
     double[] valueOfDimensions;


    Random rnd=new Random();
    public Lemur(LemurConfig config){
        valueOfDimensions=new double[config.getNumberOfDimensions()];
        for(int i =0;i<valueOfDimensions.length;i++){
            valueOfDimensions[i]= rnd.nextDouble() *
                    (config.getUpperBound() - config.getLowerBound())
                    + config.getLowerBound();
        }
    }
    public static void initializePopulation(LemurConfig config){
        ArrayList<Lemur> list = new ArrayList<>();
        for(int i =0;i<config.getNumberOfSolutions();i++){
           list.add(new Lemur(config));

        }
        for (Lemur x:list){
            for (int i=0;i<x.valueOfDimensions.length;i++){
                System.out.print(x.valueOfDimensions[i]+" ");

            }
            System.out.println(x.calculateFitessValue());

        }
    }
    public double calculateFitessValue(){
        double value=0;
        for(Double x: this.valueOfDimensions){
            value+=x;
        }
        return value;
    }


}
