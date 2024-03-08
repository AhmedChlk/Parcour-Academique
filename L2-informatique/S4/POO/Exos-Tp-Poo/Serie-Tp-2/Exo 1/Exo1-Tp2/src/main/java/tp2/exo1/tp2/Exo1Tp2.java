package tp2.exo1.tp2;
import java.util.Scanner;

public class Exo1Tp2 {

    public static void main(String[] args) {
        //declaration du scanner pour lire les attributs de l'etudiant 
        Scanner scanner = new Scanner(System.in);
        // on declare etd1 a l'exterieur du bloc try pour pouvoir le manipuler ailleurs
        Etudiant etd1 = null;

        System.out.println("Entrez le nom de l'etudiant");
        String nom = scanner.next();
        System.out.println("Entrez l'age de l'etudiant");
        int age = scanner.nextInt();
        System.out.println("Entrez La moyenne de L'etudiant");
        double moyenne = scanner.nextDouble();

        try {
             etd1 = new Etudiant(nom, age, moyenne);
            System.out.println("Etudiant crée avec succées avec les informations suivantes : ");
            System.out.println("Nom : " + etd1.getNom());
            System.out.println("Age : " + etd1.getAge());
            System.out.println("Moyenne : " + etd1.getNoteMoyenne());
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur :" + e);
            
        }

        System.out.println("Entrez la nouvelle moyenne de l'etudiant : ");
        double nouvmoyenne;
        do{
             nouvmoyenne = scanner.nextDouble();
            try {
                etd1.setNoteMoyenne(nouvmoyenne);
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur : " + e);
                System.out.println("Saisissez a nouveau une nouvelle moyenne valide ");
            }
        }while(nouvmoyenne< 0 || nouvmoyenne>20);
        
        System.out.println("ma moyenne a été changé a  : " + etd1.getNoteMoyenne());
        // Fermer le scanner
        scanner.close();
    }
    
}
 class Etudiant {
    // Attributs de la classe Etudiant
    private String nom;
    private int age;
    private double moyenne;

    // Constructeur de la classe Etudiant
    public Etudiant(String nom, int age, double moyenne) {
        // Vérification de l'âge et de la note moyenne
        if (age < 0) {
            throw new IllegalArgumentException("L'âge ne peut pas être négatif");
        }
        if (moyenne < 0 || moyenne > 20) {
            throw new IllegalArgumentException("La note moyenne doit être comprise entre 0 et 20");
        }

        this.nom = nom;
        this.age = age;
        this.moyenne = moyenne;
    }

    // Méthodes pour obtenir les attributs de l'étudiant
    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public double getNoteMoyenne() {
        return moyenne;
    }

    // Méthode pour mettre à jour la note moyenne de l'étudiant
    public void setNoteMoyenne(double moyenne) {
        if (moyenne < 0 || moyenne > 20) {
            throw new IllegalArgumentException("La note moyenne doit être comprise entre 0 et 20");
        }
        this.moyenne = moyenne;
    }
}
