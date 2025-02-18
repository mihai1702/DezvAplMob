public class SMSNotification extends Notification implements Notifiable{

    public SMSNotification(String message) {
        super(message);
    }

    @Override
    public void sendNotification() {
        System.out.println("SMS Notification" + getMessage());
    }
}
