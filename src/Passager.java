public class Passager {
    protected String nom;
    protected String prenom;
    protected String passeport;

    public Passager(String nom, String prenom, String passeport) {
        this.nom = nom;
        this.prenom = prenom;
        this.passeport = passeport;
    }

    public void afficherPassager() {
        System.out.println("Passager : " + prenom + " " + nom + " (Passeport : " + passeport + ")");
    }
}
