public class Payroll
{
    private String name;
    private int idNumber;
    private double payRate;
    private double hoursWorked;

    public Payroll(String n, int i) throws InvalidNameException, InvialidIDException
    {
        setName(n);
        setIdNumber(i);
    }

    public void setName(String n) throws InvalidNameException
    {
        if (n == null || n.length() == 0)
        {
            throw new InvalidNameException();
        }
        else
        {
            name = n;
        }

    }

    public void setIdNumber(int i ) throws InvalidIDException
    {
        if (i <= 0)
        {
            throw new InvalidIDException(i);
        }
        else
        {
            idNumber = i;
        }
    }

    public void setPayRate(double p) throws InvalidHourlyRateException
    {
        if (p < 0 || p > 25)
        {
            throw new InvalidHourlyRateException();
        }
        else
        {
            payRate = p;
        }
    }

    public void setHoursWorked(double h) throws InvalidHoursException
    {
        if (h < 0 || h > 80)
        {
            throw new InvalidHourlyRateException();
        }
        else
        {
            hoursWorked = h;
        }
    }

    public String getname()
    {
        return name;
    }

        // insert other getter methods
        
     public double getGrossPay()
     {
         return hoursWorked * payRate;
     }

    }
