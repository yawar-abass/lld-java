package Basics.OOPs;

public class Client {
    public static void main(String[] args) {
        PaymentService ps = new PaymentService();
        ps.addPaymentMethod("YawarDebitCard",new DebitCard("1234","Yawar Abass"));
        ps.addPaymentMethod("YawarCreditCard",new CreditCard("5678","Yawar Abass"));
        ps.addPaymentMethod("YawarUPI",new UPI("Yawar27"));
        ps.addPaymentMethod("YawarWallet",new Wallet());
        ps.makePayment("YawarUPI");
        ps.makePayment("YawarDebitCard");
        ps.makePayment("YawarWallet");
    }
}