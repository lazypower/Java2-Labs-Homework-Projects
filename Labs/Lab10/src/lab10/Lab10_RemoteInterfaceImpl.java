
package lab10;

import java.rmi.*;
import java.rmi.server.*;


public class Lab10_RemoteInterfaceImpl extends UnicastRemoteObject implements Lab10Interface throws RemoteException
{
    // default constructor
    public void Lab10_RemoteInterfaceImpl()
    {

    }

    public double monthlyPayment(double loanAmount, double annualInterestRate, int numberOfYears) throws RemoteException
    {
        double monthlyInterestRate = (annualInterestRate / 12) * 100;
        return loanAmount * monthlyInterestRate / (1 - (1 / monthlyInterestRate));

    }



}
