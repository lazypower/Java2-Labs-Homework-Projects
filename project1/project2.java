/* Demo for the payroll class */

public class PayrollDemo
{
    public static void main(String[] args)
    {
        Payroll worker;
        System.out.println("Invalid employee name if it is an empty string. ");
        System.out.println("Invalid employee ID if it is less than or equal to zero");
        System.out.println("Invalid worked hours if it is negative or greater than 84."); 
        System.out.println("Invalid hourly pay rate if it is negative or greater than 25.");

        System.out.println("-------------------------------------------------------------------");

        // create payroll object with empty string for name 
        try
        {
            System.out.println("\nTest 1 - worker = new Payroll(\" \", 123)");
            worker = new Payroll(" ", 123);

        }
        catch (Exception e)
        {
            system.out.println("Error - " + e.getMessage());
        }

        //Create a payroll object with an invliad id number
        try
        {
        System.out.println("\nTest 2 - worker = new Payroll(\"Superman \", 123)");
        System.out.println("             worker.setPayrate(150.0)");
        worker = new Payroll("Superman", 123);
        worker.setPayRate(150.0);
        }
        catch(InvalidHourlyRateException e)
        {
            System.out.println("Error = " + e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println("Error = " + e.getMessage());
        }

        //Try to set an invalid number of hours worked
        try
        {
            System.out.println("\nTest 3 - worker = new Payroll(\"DrDoom \", 123)");
            System.out.println("             worker.setHours(250)");
            worker = new Payroll("DrDoom", 123);
            worker.setHours(250); 
        }
        catch(InvalidHoursWorkedException e)
        {
            System.out.println("Error = " + e.getMessage());
        }



