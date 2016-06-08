import java.util.Random;

/**
 * Created by Pidhurska Tetiana
 */
public class StrategyApp {
    public static void main(String[] args) {
        StrategyClient c = new StrategyClient();
        Activity[] act = {new Fisher(), new Mushroomer(), new Hunter()};
        generateRandomStrategy(c, act);
    }

    public static void generateRandomStrategy(StrategyClient s, Activity[] array) {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int val = random.nextInt(3);
            s.setStrategy(array[val]);
            s.executeStrategy();
        }
    }


}

class StrategyClient {
    Activity strategy;

    public void setStrategy(Activity strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        strategy.doSomething();
    }
}

interface Activity {
    void doSomething();
}

class Fisher implements Activity {

    @Override
    public void doSomething() {
        System.out.println("I'll fish!");
    }
}

class Hunter implements Activity {

    @Override
    public void doSomething() {
        System.out.println("I'll hunt!");
    }
}

class Mushroomer implements Activity {

    @Override
    public void doSomething() {
        System.out.println("I'll pick mushrooms!");
    }
}
