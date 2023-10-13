/* Virtual Pet, version 1
 * 
 * @author Cam
 * @author ?
 */
public class VirtualPet {

    VirtualPetFace face;
    private int hunger = 0; // how hungry the pet is.
    private int tiredness = 0;

    // constructor
    public VirtualPet() {
        face = new VirtualPetFace();
        face.setImage("normal");
        face.setMessage("Hello.");
    }

    public void feed() {
        if (hunger > 10) {
            hunger = hunger - 10;
        } else {
            hunger = 0;
        }
    }


        if (tiredness < 4) {
            face.setMessage("estoy ecstatic");
            face.setImage("ecstatic");
        }
    }

    public void sleep() {
        hunger = hunger + 1;
        face.setImage("asleep");
    }
} // end Virtual Pet
