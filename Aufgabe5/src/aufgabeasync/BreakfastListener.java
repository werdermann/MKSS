package aufgabeasync;

import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;

public class BreakfastListener<String> implements Consumer<String> {

    @Override
    public void accept(String o) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println(o);
            }
        };
        new Timer().schedule(task, 3000);
    }

}
