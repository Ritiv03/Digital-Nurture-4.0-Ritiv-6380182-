package DecoratorPattern;

interface Notifier {
    void send(String message);
}
class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}
abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    public void send(String message) {
        wrappedNotifier.send(message);
    }
}
class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        sendSlack(message);
    }

    private void sendSlack(String message) {
        System.out.println("Slack: " + message);
    }
}
public class Main {
    public static void main(String[] args) {
        // Basic notifier
        Notifier baseNotifier = new EmailNotifier();

        // Add SMS notification
        Notifier smsNotifier = new SMSNotifierDecorator(baseNotifier);

        // Add Slack on top of SMS and Email
        Notifier fullNotifier = new SlackNotifierDecorator(smsNotifier);

        // Send notification
        fullNotifier.send("Notification sent successfully!");
    }
}
