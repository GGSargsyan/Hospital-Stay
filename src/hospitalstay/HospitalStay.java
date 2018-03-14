
package hospitalstay;
import java.util.Scanner;

/**
 *
 * @author Grigor Sargsyan
 */
public class HospitalStay 
{/**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        boolean isPatient;
        boolean isOvernight;
        int patientNumber = 0;
        
        isPatient = getPatient();
        
        while (isPatient)
        {    
            double patientTotal = 0.0;
            patientTotal = getMedicationCharges() + getLabServiceCharges();
            
            isOvernight = getOvernight();
            if (isOvernight)
                patientTotal += getOvernightCharges();
            
            patientNumber++;
            //System.out.println("Patient " +patientNumber + " will be charged $" +patientTotal);
            System.out.printf("Patient %d will be charged $%.2f.\n", patientNumber, patientTotal);
            isPatient = getNewPatient();
            if ( !isPatient )
                System.out.println("No more patients. Hospital will now close.");
        }
    }
    
    private static boolean getPatient()
    {      
        System.out.println("Is there a patient? (Y/N)");
        
        Scanner patient = new Scanner(System.in);
        char c = patient.next().charAt(0);
        patient.nextLine();
        if (c == 'Y' || c == 'y')
            return true;
        return false;
    }
    
    private static boolean getNewPatient()
    {      
        System.out.println("Is there another patient? (Y/N)");
        
        Scanner patient = new Scanner(System.in);
        char c = patient.next().charAt(0);
        patient.nextLine();
        if (c == 'Y' || c == 'y')
            return true;
        return false;
    }
    
    private static boolean getOvernight()
    {
        System.out.println("Did the patient stay overnight? (Y/N)");
        
        Scanner overnightCharge = new Scanner(System.in);
        char c = overnightCharge.next().charAt(0);
        overnightCharge.nextLine();
        if (c == 'Y' || c == 'y')
            return true;
        return false;
    }
    
    private static double getMedicationCharges()
    {
        double medicalCharges = 40.50;
        return medicalCharges;
    }
    
    private static double getLabServiceCharges()
    {
        double labServiceCharges = 100.22;
        return labServiceCharges;
    }
    
    private static double getOvernightCharges()
    {
        double overnightCharges = 90.55;
        return overnightCharges;
    }
}
