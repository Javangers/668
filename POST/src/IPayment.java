/*
 * SFSU CSC 668/868 Lab
 * Post 1
 */

/**
 * Payment interface
 * we need payment type getter and result printing interfaces
 * @author Yanxing
 */
public interface IPayment{
    
    /**
     * @return the string description of the payment
     */
    public String getPaymentType();
    
    /**
     * print the invoice
     * @param actualAmount the total price of this transaction
     */
    public void printResult(float actualAmount);
}

/**
 * Cash payment class, derived from payment interface
 * @author Yanxing
 */
class CashPayment implements IPayment{
    private final float money;
    
    /**
     * Constructor with cash amounts
     */
    public CashPayment(float money){
        this.money = money;
    }
    
    @Override
    public String getPaymentType(){
        return "Cash";
    }
    
    @Override
    public void printResult(float actualAmount){
        System.out.println("------");
        System.out.println("Total $" + Float.toString(actualAmount));
        System.out.println("Amount Tendered: $" + Float.toString(money));
        System.out.println("Amount Returned: $" + Float.toString(money - actualAmount));
    }
}

/**
 * Check payment class, derived from payment interface
 * @author Yanxing
 */
class CheckPayment implements IPayment{
    public CheckPayment(){
    }
    
    @Override
    public String getPaymentType(){
        return "Check";
    }
    
    @Override
    public void printResult(float actualAmount){
        System.out.println("------");
        System.out.println("Total $" + Float.toString(actualAmount));
        System.out.println("Paid by check");
    }
}

/**
 * Credit card payment class, derived from payment interface
 * @author Yanxing
 */
class CreditPayment implements IPayment{
    private final String number;
    
    public CreditPayment(String number){
        this.number = number;
    }
    
    @Override
    public String getPaymentType(){
        return "Credit card";
    }
    
    @Override
    public void printResult(float actualAmount){
        System.out.println("------");
        System.out.println("Total $" + Float.toString(actualAmount));
        System.out.println("Credit Card " + number);
    }
}
