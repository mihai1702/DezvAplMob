public class EmailNotification extends Notification implements Notifiable{

    public EmailNotification(String message) {
        super(message);
    }

    @Override
    public void sendNotification() {
        System.out.println("Email Notification " +getMessage());
    }
}
