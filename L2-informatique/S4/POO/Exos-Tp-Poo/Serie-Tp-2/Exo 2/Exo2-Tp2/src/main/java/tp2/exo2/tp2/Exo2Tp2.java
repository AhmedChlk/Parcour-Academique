package tp2.exo2.tp2;

import java.util.Scanner;
import java.lang.Math;

public class Exo2Tp2 {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int init_x=0;
        int inti_y=0;
        boolean valid_Input = false;
        while (!valid_Input) {
            try {
                System.out.print("X : ");
                init_x = Integer.parseInt(sc.nextLine());
                System.out.print("Y : ");
                inti_y = Integer.parseInt(sc.nextLine());
                valid_Input = true;
            }catch(NumberFormatException e ){
                System.out.println("Entrez des entiers valides");
            }
        }
        Point point = new Point(init_x, inti_y);
        System.out.println("Point crée avec les coordonées suivantes : ");
        System.out.println("X : " + point.getX());
        System.out.println("Y : " + point.getY());

        char reponse;
        int new_pos_x=0;
        int new_pos_y=0;
        boolean valide_changement = false;
        valid_Input = false;
        System.out.println("Voulez Vous Modifier la Position du Point ? (Y/N) ");
        while (!valid_Input) {
            try{
                reponse = sc.next().charAt(0);
                sc.nextLine(); // c juste pour clear le buffer 
                if (reponse != 'Y' && reponse != 'N') 
                {
                    throw new IllegalArgumentException("Entrez un Caractere Valide");
                }
                valid_Input = true;
                if(reponse == 'Y')
                {
                    System.out.println("entrez la nouvelle position du Point : ");
                    while (!valide_changement) 
                    {
                        try{
                            System.out.println("X :");
                            new_pos_x = Integer.parseInt(sc.nextLine());
                            System.out.println("Y :");
                            new_pos_y = Integer.parseInt(sc.nextLine());
                            valide_changement = true;
                        }catch(NumberFormatException e ){
                            System.out.println("Entrez des entiers valides");
                        }
                    }
                   point.MoveTo(new_pos_x, new_pos_y);
                   System.out.println("Position du Point changé vers  : ");
                   System.out.println("X :" + point.getX());
                   System.out.println("Y : " + point.getY());
                }
            }catch(IllegalArgumentException e){
                System.out.println("Erreur " + e.getMessage());
            }
        }
        // On va tester l'exo 3 ici 

        Cercle cercle = new Cercle(-1, point);

        System.out.println("La position du cercle est : " + "X : " + cercle.getCentre().getX() + " Y : " + cercle.getCentre().getY());
        System.out.println("La surface du cercle est :" + cercle.calculerSurface());
        System.out.println("La circumference du cercle est :" + cercle.calculerCircumference());
        cercle.deplacerCercle(11, 11);
        System.out.println("La position du cercle est : " + "X : " + cercle.getCentre().getX() + " Y : " + cercle.getCentre().getY());

        sc.close();


    
    }
}

class Point {
    private int X;
    private int Y;

    public Point(int X, int Y) {

        this.X = X;
        this.Y = Y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void MoveTo(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }
}

// Ceci est la declaration de la classe de L'exo 3 
 class Cercle {
    private double rayon;
    private Point centre;
    public Cercle (double rayon, Point centre){
        if (rayon <= 0) {
            throw new IllegalArgumentException("Le rayon doit être une valeur positive.");
        }
        if (centre == null){
            throw new IllegalArgumentException("Le centre ne peut pas être null.");
        }
        this.rayon = rayon;
        this.centre= new Point(centre.getX(),centre.getY()); // crée une copie pour qu ele centre du cercle ne soit modifié en modifier le centre d'origine 
    }
    public double getRayon(){
        return rayon;
    }
    public Point getCentre(){
       // Retourne une copie du centre du cercle pour éviter la modification du centre d'origine

        return new Point(centre.getX(),centre.getY());
    }
    public double calculerCircumference(){
        return 2 * Math.PI * rayon ;
    }
    public double calculerSurface(){
        return Math.PI * (rayon*rayon);
    }
    public void deplacerCercle(int new_pos_x , int new_pos_y){
        this.centre.MoveTo(new_pos_x, new_pos_y);
    }
    
}