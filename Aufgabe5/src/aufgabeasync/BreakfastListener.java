package aufgabeasync;

import java.util.function.Consumer;

public class BreakfastListener implements Consumer {
    @Override
    public void accept(Object o) {
        synchronized (this) {
            try {
                this.wait(3000);
                System.out.println((String) o);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }

    @Override
    public Consumer andThen(Consumer after) {
        return Consumer.super.andThen(after);
    }

}
