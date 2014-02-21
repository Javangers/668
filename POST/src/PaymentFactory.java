/*
 * SFSU CSC 668/868 Lab
 * Post 1
 */

/**
 * payment factory class
 * used for create the specific type of payment
 * we need a relative parameter to create the payment
 * @author Yanxing
 */
public class PaymentFactory {
    
    /**
     * payment type
     */
    public enum PaymentType{
        PAYMENT_CASH,
        PAYMENT_CHECK,
        PAYMENT_CREDIT_CARD,
        
        MAX_PAYMENT_TYPE
    }
    
    /**
     * @param type payment type
     * @param param parameter for creating the payment, money amount for instance
     * @return payment instance
     */
    static public IPayment createPayment(PaymentType type, String param){
        IPayment ret = null;
        switch(type){
            case PAYMENT_CASH:
                // the parameter is the amount
                ret = new CashPayment(Float.parseFloat(param));
                break;
            case PAYMENT_CHECK:
                // check does not need a parameter
                ret = new CheckPayment();
                break;
            case PAYMENT_CREDIT_CARD:
                // the parameter is the card number
                ret = new CreditPayment(param);
                break;
            default:
                break;
        }
        return ret;
    }
    
    /**
     * @param type payment type
     * @param param parameter for creating the payment, money amount for instance
     * @return payment instance
     */
    static public IPayment createPaymentByString(String type, String param){
        IPayment ret = null;
        switch(type){
            case "Cash":
                // the parameter is the amount
                ret = new CashPayment(Float.parseFloat(param));
                break;
            case "Check":
                // check does not need a parameter
                ret = new CheckPayment();
                break;
            case "Credit card":
                // the parameter is the card number
                ret = new CreditPayment(param);
                break;
            default:
                break;
        }
        return ret;
    }
    
    /**
     * @return Payment type names
     */
    static public String getPayments(){
        String ret = "";
        
        ret += createPayment(PaymentType.PAYMENT_CASH,"0").getPaymentType() + ",";
        ret += createPayment(PaymentType.PAYMENT_CHECK,"").getPaymentType() + ",";
        ret += createPayment(PaymentType.PAYMENT_CREDIT_CARD,"").getPaymentType();
        
        return ret;
    }
}