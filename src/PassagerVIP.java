public class PassagerVIP extends Passager {
    private double reduction; // Ex : 0.20 pour 20 %

    public PassagerVIP(String nom, String prenom, String passeport, double reduction) {
        super(nom, prenom, passeport);
        if (reduction < 0 || reduction > 1) {
            System.out.println("La réduction doit être entre 0 et 1. Réduction mise à 0.");
            this.reduction = 0;
        } else {
            this.reduction = reduction;
        }
    }

    @Override
    public double calculerReduction(double prixBase) {
        return prixBase * (1 - reduction);
    }
}
