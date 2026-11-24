public class PassagerStandard extends Passager {

    public PassagerStandard(String nom, String prenom, String passeport) {
        super(nom, prenom, passeport);
    }

    // Le passager standard ne bénéficie d'aucune réduction (0 %)
    @Override
    public double calculerReduction(double prixBase) {
        return prixBase;
    }
}

