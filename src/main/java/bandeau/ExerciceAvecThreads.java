package bandeau;


public class ExerciceAvecThreads {

    public static void main(String[] args) {
        ExerciceAvecThreads instance = new ExerciceAvecThreads();
        instance.exemple();
    }

    public void exemple() {
        // On crée les scénarios
        Scenario scenario1 = makeScenario1();
        Scenario scenario2 = makeScenario2();
        Scenario scenario3 = makeScenario3();

        // On crée les bandeaux
        Bandeau bandeau1 = new Bandeau();
        Bandeau bandeau2 = new Bandeau();
        Bandeau bandeau3 = new Bandeau();

        System.out.println("CTRL-C pour terminer le programme");

        // On crée les threads pour chaque scénario et bandeau
        Thread thread1 = new Thread(() -> scenario1.playOn(bandeau1));
        Thread thread2 = new Thread(() -> scenario2.playOn(bandeau2));
        Thread thread3 = new Thread(() -> scenario3.playOn(bandeau3));

        // On démarre les threads
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            // Attendez que les threads se terminent
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // On peut rejouer le scénario sur bandeau1 maintenant que le premier jeu est fini
        Thread thread4 = new Thread(() -> scenario1.playOn(bandeau1));
        thread4.start();
    }

    private Scenario makeScenario1() {
        // Créez le premier scénario ici en ajoutant les effets souhaités
        Scenario s = new Scenario();
        s.addEffect(new RandomEffect("Le jeu du pendu", 700), 1);
        s.addEffect(new Rotate("2 tours à droite", 180, 4000, true), 2);
        return s;
    }

    private Scenario makeScenario2() {
        Scenario s = new Scenario();
        s.addEffect(new RandomEffect("Le jeu du pendu", 700), 1);
        s.addEffect(new Rotate("2 tours à droite", 180, 4000, true), 2);
        return s;
    }

    private Scenario makeScenario3() {
        Scenario s = new Scenario();
        s.addEffect(new RandomEffect("Le jeu du pendu", 700), 1);
        s.addEffect(new Rotate("2 tours à droite", 180, 4000, true), 2);
        return s;
    }
}


