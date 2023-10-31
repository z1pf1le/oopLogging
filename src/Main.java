import java.util.logging.Logger;

public class Main{
    public static void main(String[] args) {
        MailSystem.MailService spy = new MailSystem.Spy(Logger.getLogger(Class.class.getName()));
        MailSystem.MailService thief = new MailSystem.Thief(10);
        MailSystem.MailService inspector = new MailSystem.Inspector();
        MailSystem.MailService[] msArray = {spy, thief, inspector};
        MailSystem.MailMessage mail1 = new MailSystem.MailMessage("Romeo", "Juliet", "I love you!");
        MailSystem.MailMessage mail2 = new MailSystem.MailMessage("Austin Powers", "James Bond", "Big secret!");
        MailSystem.Package p1 = new MailSystem.Package("Flowers", 15);
        MailSystem.MailPackage mail3 = new MailSystem.MailPackage("Romeo", "Juliet", p1);
        MailSystem.MailPackage mail4 = new MailSystem.MailPackage("Romeo", "Juliet", new MailSystem.Package ("Flowers", 25));
        MailSystem.MailPackage mail5 = new MailSystem.MailPackage("Austin Powers", "James Bond", new MailSystem.Package("weapons", 5));

        MailSystem.UntrustworthyMailWorker umw = new MailSystem.UntrustworthyMailWorker(msArray);
        try {
            umw.processMail(mail1);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
        try {
            umw.processMail(mail2);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
        try {
            umw.processMail(mail3);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
        try {
            umw.processMail(mail4);
        } catch (RuntimeException re) {
           System.out.println(re.getMessage());
        }
        try {
            umw.processMail(mail5);
       } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }

        System.out.println("Thief have stolen $" + ( (MailSystem.Thief) thief ).getStolenValue() + "!");
    }
}