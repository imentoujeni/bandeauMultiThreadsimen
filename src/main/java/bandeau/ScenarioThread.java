package bandeau;

public class ScenarioThread extends Thread {
    private Bandeau bandeau;
    private Scenario scenario;

    public ScenarioThread(Bandeau bandeau, Scenario scenario) {
        this.bandeau = bandeau;
        this.scenario = scenario;
    }

    @Override
    public void run() {
        scenario.playOn(bandeau);
        bandeau.close();
    }
}
