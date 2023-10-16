/* Virtual Pet, version 1
 * 
 * @author Cam
 * @author ?
 */

import javax.swing.JOptionPane;

public class VirtualPet {

    VirtualPetFace face;
    private int personality;

    private int wakeUpCount = 0;

    private int happiness = 50;
    private int hunger = 50;

    private int happyGate = 75;
    private int sadGate = 50;
    private int angryGate = 25;
    private int hungerGate = 75;

    // constructor
    public VirtualPet() {
        face = new VirtualPetFace();
        face.setImage("asleep");
        face.setMessage("ZZZzzzzz...");
    }

    public void gateConfig(int n) {
        personality = n;

        if (n == 0) {
            happyGate = 60;
        } else if (n == 1) {
            sadGate = 30;
        } else if (n == 2) {
            happyGate = 90;
            sadGate = 40;
        } else if (n == 3) {
            hungerGate = 50;
        }
        System.out.println(happyGate);
        System.out.println(sadGate);
        System.out.println(angryGate);
        System.out.println(hungerGate);
    }

    public void say(String message) {
        face.setMessage(message);
    }

    public void emotion(String emotion) {
        face.setImage(emotion);
    }

    public void wakeUp(int answer) {
        if (answer == 0) {
            face.setMessage("*Gasp* What time is it?");
            face.setImage("astonished");
        } else {
            System.out.println("ZZZzzzzz...");
            wakeUpCount++;
        }
    }

    public void eatBreakfast(int answer) {
        if (answer == 0) {
            face.setImage("eating");
            face.setMessage("Nom Nom, I feel ready and energized now!");
            this.hunger -= 20;
        } else {
            this.hunger += 30;
            face.setImage("sad");
            face.setMessage("I'm feeling a little hungry, but I can't be late to school.");
        }
    }

    public void takeTest() {
        int score = 0;

        Object[] options = { "5",
                "6" };
        int n = JOptionPane.showOptionDialog(null,
                "What is 2 + 3?",
                "Problem 1",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

    }

    // ending check method
    public void checkEnding() {
        if (hunger > hungerGate) {
            face.setImage("skeleton");
        } else if (happiness < angryGate) {
            face.setImage("angry");
        } else if (happiness < sadGate) {
            face.setImage("sad");
        } else if (happiness < happyGate) {
            face.setImage("happy");
        } else {
            face.setImage("ecstatic");
        }
    }

    public int getWakeUpCount() {
        return this.wakeUpCount;
    }
} // end Virtual Pet
