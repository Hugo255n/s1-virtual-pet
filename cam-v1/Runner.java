import java.awt.Component;

import javax.swing.*;

public class Runner {
    public Runner() {
        VirtualPet p1 = new VirtualPet();

        Object[] personalities = {"Enthusiastic", "Pessimistic", "Mundane", "Ravenous", "Daring"};

        p1.exercise();
        wait(1000);
        String ans = getResponse("How was your day?");
        System.out.println(ans);

        JOptionPane.showMessageDialog(null, "Press OK");
    }

    public static void main(String[] args) {
        new Runner();
    }

    public void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {

        }
    }

    public String getResponse(String q) {
        String s = (String) JOptionPane.showInputDialog(
                new JFrame(),
                q,
                "Your Title",
                JOptionPane.PLAIN_MESSAGE
        );
        return s;
    }
}
