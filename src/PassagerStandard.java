public class PassagerStandard extends Passager {

    public PassagerStandard(String nom, String prenom, String passeport) {
        super(nom, prenom, passeport);
    }

    @Override
    public double calculerReduction (double prixBase) {
        return prixBase; // Pas de réduction
    }
}
