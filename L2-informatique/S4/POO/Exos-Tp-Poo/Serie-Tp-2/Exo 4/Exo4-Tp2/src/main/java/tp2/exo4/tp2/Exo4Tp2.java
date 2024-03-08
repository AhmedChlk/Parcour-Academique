package tp2.exo4.tp2;

public class Exo4Tp2 {

    public static void main(String[] args) {
        Compte Cp1 = new Compte(11156765, 45000);
        Compte Cp2 = new Compte(11167523, 20000);
        Cp1.retrait(5000);
        Cp2.retrait(7000);
        Cp1.depot(8000);
        Cp2.depot(12000);
        Cp1.afficheSolde();
        Cp2.afficheSolde();
    }
}

class Compte {
    private int numero;
    private double solde;

    public Compte(int numero, double solde) {
        if (solde < 0) {
            throw new IllegalArgumentException("Le solde du compte ne peut pas être négatif lors de la création");
        }
        this.numero = numero;
        this.solde = solde;
    }

    public int getNum() {
        return numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setNum(int numero) {
        this.numero = numero;
    }

    public void setSolde(double solde) {
        if (solde < 0) {
            throw new IllegalArgumentException("Le solde du compte ne peut pas être négatif");
        }
        this.solde = solde;
    }

    public void depot(double montant) {
        if (montant < 0) {
            throw new IllegalArgumentException("Le montant du dépôt ne peut pas être négatif");
        }
        solde += montant;
    }

    public void retrait(double montant) {
        if (montant < 0) {
            throw new IllegalArgumentException("Le montant du retrait ne peut pas être négatif");
        }
        if (montant > solde) {
            throw new IllegalArgumentException("Le retrait est plus important que le solde du compte");
        }
        solde -= montant;
    }

    public void afficheSolde() {
        System.out.println("Le solde du compte est de : " + solde + " euros");
    }
}
