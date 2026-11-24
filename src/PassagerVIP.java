public class PassagerVIP extends Passager {
    private double reduction; // Ex : 0.20 pour 20 %

    public PassagerVIP(String nom, String prenom, String passeport, double reduction) {
        super(nom, prenom, passeport);
        if (reduction < 0 || reduction > 1) {
            throw new DonneeInvalideException("La réduction doit être entre 0 et 1 (ex : 0.20).");
        }
        this.reduction = reduction;
    }

    @Override
    public double calculerReduction(double prixBase) {
        return prixBase * (1 - reduction);
    }
}
