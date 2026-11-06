public class PassagerVIP extends Passager {
    private double reduction; // Ex: 0.20 pour 20%

    public PassagerVIP(String nom, String prenom, String passeport, double reduction) {
        super(nom, prenom, passeport);
        this.reduction = reduction;
    }

    @Override
    public double calculerReduction(double prixBase) {
        return prixBase * (1 - reduction); // Réduction appliquée
    }
}

