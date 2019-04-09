import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestTransac {

    public static void testTransac(String inStr, Session ses, Transaction tr){
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(inStr);
        System.out.println("session isJoinedToTransaction : " + ses.isJoinedToTransaction());
        System.out.println("session isOpen                : " + ses.isOpen());
        System.out.println("session isConnected           : " + ses.isConnected());
        System.out.println("transaction isActive          : " + tr.isActive());
        System.out.println("------------------------------------------");
    }
}
