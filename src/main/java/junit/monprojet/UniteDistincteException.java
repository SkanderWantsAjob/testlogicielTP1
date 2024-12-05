package junit.monprojet;

public class UniteDistincteException extends Exception {
    private final SommeArgent somme1;
    private final SommeArgent somme2;

    public UniteDistincteException(SommeArgent sa1, SommeArgent sa2) {
        this.somme1 = sa1;
        this.somme2 = sa2;
    }

    @Override
    public String toString() {
        return "Unité distincte : " + somme1.getUnite() + " != " + somme2.getUnite();
    }
}
