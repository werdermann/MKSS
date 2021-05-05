package remotecontrol;

public class OnBtnCmd2 implements Command {

    @Override
    public void execute(int no) {
        switch (no) {
            case 0 -> System.out.println("Start heater");
            case 1 -> System.out.println("Start floor light");
            case 2 -> System.out.println("Start computer");
            case 3 -> System.out.println("Start shower");
            case 4 -> System.out.println("Start toaster");
            case 5 -> System.out.println("Start tv");
            case 6 -> System.out.println("Start fridge cooling");
        }
    }
}
