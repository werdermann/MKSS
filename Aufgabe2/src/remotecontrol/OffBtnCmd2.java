package remotecontrol;

public class OffBtnCmd2 implements Command {

    @Override
    public void execute(int no) {
        switch (no) {
            case 0 -> System.out.println("Stop heater");
            case 1 -> System.out.println("Stop floor light");
            case 2 -> System.out.println("Stop computer");
            case 3 -> System.out.println("Stop shower");
            case 4 -> System.out.println("Stop toaster");
            case 5 -> System.out.println("Stop tv");
            case 6 -> System.out.println("Stop fridge cooling");
        }
    }
}