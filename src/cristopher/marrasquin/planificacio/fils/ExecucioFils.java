package cristopher.marrasquin.planificacio.fils;

public class ExecucioFils {
    private Cronometre[] cronometres;

    public ExecucioFils() {
        // Creem les 7 instàncies de Cronometre
        cronometres = new Cronometre[] {
                new Cronometre("CronoAlfa", 21),
                new Cronometre("CronoBravo", 15),
                new Cronometre("CronoCharlie", 12),
                new Cronometre("CronoDelta", 6),
                new Cronometre("CronoEcho", 11),
                new Cronometre("CronoFoxtrot", 4),
                new Cronometre("CronoGolf", 7)
        };
    }

    public void iniciarExecucio() {
        try {
            System.out.println("Iniciant CronoBravo en exclusiva durant 4 segons");
            Thread threadBravo = new Thread(cronometres[1]);
            threadBravo.start();
            Thread.sleep(4000);
            System.out.println("Iniciant CronoDelta en exclusiva fins que finalitzi");
            Thread threadDelta = new Thread(cronometres[3]);
            threadDelta.start();
            threadDelta.join();

            System.out.println("Iniciant CronoEcho en exclusiva durant 8 segons");
            Thread threadEcho = new Thread(cronometres[4]);
            threadEcho.start();
            Thread.sleep(8000);

            System.out.println("Iniciant la resta de cronòmetres simultàniament...");
            Thread threadAlfa = new Thread(cronometres[0]);
            Thread threadCharlie = new Thread(cronometres[2]);
            Thread threadFoxtrot = new Thread(cronometres[5]);
            Thread threadGolf = new Thread(cronometres[6]);

            threadAlfa.start();
            threadCharlie.start();
            threadFoxtrot.start();
            threadGolf.start();

            threadAlfa.join();
            threadCharlie.join();
            threadFoxtrot.join();
            threadGolf.join();

            System.out.println("Tots els cronòmetres han finalitzat.");
        } catch (InterruptedException e) {
            System.err.println("Error en la gestió de fils.");
        }
    }
}
