import java.util.*;
public class GrowthTable {
    static Scanner keyb = new Scanner(System.in);
    
    public static void main(String[] args){
        System.out.println("Welcome to the Growth Table program\n");
        System.out.print("Enter the inital number of acres of wetlands: ");
        double initialAcres = keyb.nextDouble();
        System.out.print("Project the growth rate for how many years? ");
        int years = keyb.nextInt();
        System.out.print("Enter the growth rate as a percent? ");
        double growthPercent = keyb.nextDouble();
        double growthRate = growthPercent / 100.0;
        System.out.print("How many years between rows? ");
        int yearsBetween = keyb.nextInt();
        double currentAcres = initialAcres;
        int yearCount = 0;
        Double totalGrowth = 0.0;
        double newGrowthSum = 0;
        
        System.out.println("\nProjecting wetlands regrowth for " + years + " years,");
        System.out.printf("\tfrom an initial area of %,.0f acres,", initialAcres);
        System.out.printf("\n\tassuming a growth rate of %.1f per year:\n", growthPercent);
        
        System.out.println("\nEnd of Year     New Growth                 Total");
        while (yearCount < years) {
            double newGrowth = currentAcres * growthRate;
            currentAcres = currentAcres + newGrowth;
            yearCount++;
            totalGrowth = totalGrowth + newGrowth;
            newGrowthSum = newGrowthSum + newGrowth;
            int yearsModulus = yearCount % yearsBetween;
            if (yearsModulus == 0) {
                System.out.printf("  %3d\t\t    %,4.2f\t         %,7.2f\n"
                             , yearCount, newGrowthSum, currentAcres);
                newGrowthSum = 0;
            }
            
        }
        System.out.printf("%,.2f acres of new land formation over %,d years.\n"
                         , totalGrowth, years);
        
        System.out.println("\nThanks for using the Growth Table program");
    }
}