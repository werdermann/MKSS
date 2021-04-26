package observer;

public class main {

    /**
     * Task:
     * A news channel should notify every user whenever news are published
     * @param args
     */
    public static void main(String[] args) {
        NewsCompanyObservable observable = new NewsCompanyObservable();
        ChannelObserver observer = new ChannelObserver();

        observable.addObserver(observer);
        observable.setNews("*IMPORTANT NEWS*: !!! Ice Cream has been increasing in price !!!");
    }
}
