package cristopher.marrasquin.planificacio.fils;

class Cronometre implements Runnable {
    private String nom;
    private int segons;

    public Cronometre(String nom, int segons) {
        this.nom = nom;
        this.segons = segons;
    }

    @Override
    public void run() {
        int segonActual = 0;
        while (segonActual <= segons) {
            try {
                Thread.sleep(1000); // Espera 1 segon
            } catch (InterruptedException e) {
                System.out.println("Error en " + nom + ": " + e.getMessage());
            }

            System.out.println("Cronòmetre " + nom + " - Segon: " + segonActual);
            segonActual++;
        }
        System.out.println(nom + " ha finalitzat.");
    }
}