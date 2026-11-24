public abstract class Passager {
    protected String nom;
    protected String prenom;
    protected String passeport;

    public Passager(String nom, String prenom, String passeport) {
        if (nom == null || nom.trim().isEmpty()) {
            throw new DonneeInvalideException("Le nom est vide !");
        }
        if (prenom == null || prenom.trim().isEmpty()) {
            throw new DonneeInvalideException("Le prénom est vide !");
        }
        if (passeport == null || passeport.trim().isEmpty()) {
            throw new DonneeInvalideException("Le passeport est vide !");
        }
        this.nom = nom;
        this.prenom = prenom;
        this.passeport = passeport;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPasseport() {
        return passeport;
    }

    public void afficherPassager() {
        System.out.println("Passager : " + prenom + " " + nom + " (Passeport : " + passeport + ")");
    }

    // Calcule le prix que le passager doit payer
    public abstract double calculerReduction(double prixBase);
}
