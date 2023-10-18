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

    public void eatLunch(int answer) {
        if (answer == 0) {
            face.setImage("eating");
            face.setMessage("Nom Nom, What a good lunch!");
            this.hunger -= 20;
        } else {
            this.hunger += 30;
            face.setImage("sad");
            face.setMessage("I'm feeling really hungry now, but I don't feel like eating right now.");
        }
    }

    public void takeTest() {
        int score = 0;

        Object[] options1 = { "5",
                "6" };
        int n1 = JOptionPane.showOptionDialog(null,
                "What is 2 + 3?",
                "Problem 1",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options1,
                options1[0]);
        if (n1 == 0) {
            face.setMessage("Correct!");
            score++;
        } else {
            face.setMessage("Incorrect");
        }

        Object[] options2 = { "1",
                "-1" };
        int n2 = JOptionPane.showOptionDialog(null,
                "What is 7 - 8?",
                "Problem 1",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options2,
                options2[0]);
        if (n2 == 1) {
            face.setMessage("Correct!");
            score++;
        } else {
            face.setMessage("Incorrect");
        }
        // score calculate
        if (score == 0) {
            happiness -= 20;
            face.setImage("sad");
            face.setMessage("Noooo. My parents are going to be so mad.");
        } else if (score == 1) {
            happiness += 10;
            face.setImage("happy");
            face.setMessage("I don't think I did that bad.");
        } else {
            happiness += 40;
            face.setImage("ecstatic");
            face.setMessage("Yaaaaay! Full Score!");
        }
    }

    public void lookForFriend(int answer) {
        if (answer == 0) {
            face.setImage("ecstatic");
            face.setMessage("Yaaay found my friend! 'Hey friend, we should walk together!'");
            happiness += 30;
        } else {
            face.setImage("sad");
            face.setMessage("I don't feel like talking to my friend anyway.");
            happiness -= 35;
        }
    }

    // ending check method
    public void checkEnding() {
        if (hunger > hungerGate) {
            face.setImage("skeleton");
            face.setMessage("You died from hunger, don't forget to eat your meals.");
        } else if (this.happiness < angryGate) {
            face.setImage("angry");
            face.setMessage("Don't be so angry, there's always tomorrow.");
        } else if (this.happiness < sadGate) {
            face.setImage("sad");
            face.setMessage("You're a bit sad, but you can get over it.");
        } else if (this.happiness < happyGate) {
            face.setImage("That was such a boring day.");
        } else {
            face.setImage("ecstatic");
            face.setImage("Today was the happiest day of you life.");
        }
    }

    public int getWakeUpCount() {
        return this.wakeUpCount;
    }
} // end Virtual Pet
