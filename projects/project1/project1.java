
public class InvalidHourlyRateException extends Exception
{
    public InvalidHourlyRateException()
    {
        super("Invalid hourly pay rate");
    }

    public InvliadHourlyRateException(double rate)
    {
        super("Invalid hourly pay rate: " + rate);
    }
}
