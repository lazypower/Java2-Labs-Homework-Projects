package lab10;

import java.rmi.*;

public interface Lab10Interface {

    public interface Lab10_RemoteInterface extends Remote
    {
        public double monthlyPayment(double loanAmount, double annualInterestRate, int numberOfYears) throws RemoteException;
        public double totalPayment (double loanAmount, double annualInterestRate, int numberOfYears) throws RemoteException;
    }



}
