package basic;

class DeadLockTest {
    class Friend {
            private final String name;
            public Friend(String name) {
                this.name = name;
            }
            public String getName() {
                return this.name;
            }
            public synchronized void bow(Friend bower) {
                System.out.format("%s: %s"
                                + "  has bowed to me!%n",
                        this.name, bower.getName());
                bower.bowBack(this);
            }
            public synchronized void bowBack(Friend bower) {
                System.out.format("%s: %s"
                                + " has bowed back to me!%n",
                        this.name, bower.getName());
            }
        }
}

public class DeadLock {
    public static void main(String[] args) {
        final DeadLockTest deadLockTest = new DeadLockTest();
        final DeadLockTest.Friend alphonse =
                deadLockTest.new Friend("Alphonse");
        final DeadLockTest.Friend gaston =
                deadLockTest.new Friend("Gaston");

        new Thread(() -> alphonse.bow(gaston) ).start();
        new Thread(() -> gaston.bow(alphonse) ).start();
    }
}