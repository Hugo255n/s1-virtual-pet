import java.awt.Component;

import javax.swing.*;

public class Runner {
    public Runner() {
        VirtualPet p1 = new VirtualPet();

        JOptionPane.showMessageDialog(null, "Before we start, we need to know more about your pet.");

        Object[] personalities = { "Enthusiastic", "Pessimistic", "Mundane", "Ravenous" };
        int personalityInt = JOptionPane.showOptionDialog(null, "What is your pet's personality?", "Pet Personality",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                personalities,
                personalities[2]);
        p1.gateConfig(personalityInt);

        // String ans = getResponse("How was your day?");
        // System.out.println(ans);
        // JOptionPane.showMessageDialog(null, "Press OK");
        // p1.exercise();

        for (int i = 0; i < 2; i++) {
            wait(2500);
            int wakeUpCall = JOptionPane.showConfirmDialog(
                    null,
                    "Will you wake your pet up?",
                    "Question",
                    JOptionPane.YES_NO_OPTION);
            p1.wakeUp(wakeUpCall);
            if (wakeUpCall == 0) {
                break;
            } else if (i == 1) {
                wait(2500);
                JOptionPane.showMessageDialog(null, "Your pet is going to be late, wake it up!");
                p1.wakeUp(0);
            }
        }

        wait(2500);
        if (p1.getWakeUpCount() == 2) {
            p1.say("It's already 8:20");
        } else {
            p1.emotion("relieved");
            p1.say("Phew. It's still 7:30");
            wait(2000);
        }

        JOptionPane.showMessageDialog(null, "From now on, you will be in the perspective of your pet.");

        p1.say("We have to eatbreakfast");
        wait(2000);

        int eatBreakfastCheck = JOptionPane.showConfirmDialog(
                null,
                "Will you eat breakfast? You may be late to school.",
                "Question",
                JOptionPane.YES_NO_OPTION);
                wait(500);
        p1.eatBreakfast(eatBreakfastCheck);

        wait(5000);

        p1.emotion("happy");
        p1.say("Time to head for school!");

        
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
                JOptionPane.PLAIN_MESSAGE);
        return s;
    }
}
