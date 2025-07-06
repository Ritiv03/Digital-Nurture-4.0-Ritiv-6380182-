package AdapterPattern;

// PaymentProcessor.java
interface PaymentProcessor {
    void processPayment(double amount);
}
// PayPal.java
class PayPal {
    public void sendMoney(double amount) {
        System.out.println("Processing payment of Rs." + amount + " through PayPal.");
    }
}

// Stripe.java
class Stripe {
    public void makePayment(double amount) {
        System.out.println("Processing payment of Rs." + amount + " through Stripe.");
    }
}

// Razorpay.java
class Razorpay {
    public void transfer(double amount) {
        System.out.println("Processing payment of Rs." + amount + " through Razorpay.");
    }
}
// PayPalAdapter.java
class PayPalAdapter implements PaymentProcessor {
    private PayPal paypal;

    public PayPalAdapter(PayPal paypal) {
        this.paypal = paypal;
    }

    public void processPayment(double amount) {
        paypal.sendMoney(amount);
    }
}

// StripeAdapter.java
class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    public void processPayment(double amount) {
        stripe.makePayment(amount);
    }
}

// RazorpayAdapter.java
class RazorpayAdapter implements PaymentProcessor {
    private Razorpay razorpay;

    public RazorpayAdapter(Razorpay razorpay) {
        this.razorpay = razorpay;
    }

    public void processPayment(double amount) {
        razorpay.transfer(amount);
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPalAdapter(new PayPal());
        PaymentProcessor stripe = new StripeAdapter(new Stripe());
        PaymentProcessor razorpay = new RazorpayAdapter(new Razorpay());

        paypal.processPayment(5000.00);
        stripe.processPayment(2500.50);
        razorpay.processPayment(1000.75);
    }
}
