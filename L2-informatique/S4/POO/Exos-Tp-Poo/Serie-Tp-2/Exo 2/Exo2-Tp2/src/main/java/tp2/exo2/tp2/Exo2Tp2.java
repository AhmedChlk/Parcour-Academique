package tp2.exo2.tp2;

import java.util.Scanner;

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
                if (init_x < 0 || inti_y < 0) {
                    throw new IllegalArgumentException("Les coordonnées ne peuvent pas être négatives.");
                }
                valid_Input = true;

            }catch(NumberFormatException e ){
                System.out.println("Entrez des entiers valides");
            }catch (IllegalArgumentException e) {
                System.out.println("les positions doivent etre positives");
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
                if (reponse != 'Y' && reponse != 'N') {
                    throw new IllegalArgumentException("Entrez un Caractere Valide");
                }
                valid_Input = true;
                if(reponse == 'Y'){
                    System.out.println("entrez la nouvelle position du Point : ");
                    while (!valide_changement) {
                        try{
                            System.out.println("X :");
                            new_pos_x = Integer.parseInt(sc.nextLine());
                            System.out.println("Y :");
                            new_pos_y = Integer.parseInt(sc.nextLine());
                            valide_changement = true;
                        }catch(NumberFormatException e ){
                            System.out.println("Entrez des entiers valides");
                        }catch (IllegalArgumentException e) {
                            System.out.println("les positions doivent etre positives");
                        } 
                    }
                   point.MoveTo(new_pos_x, new_pos_y);
                   System.out.println("Porsition du Point changé vers  : ");
                   System.out.println("X :" + point.getX());
                   System.out.println("Y : " + point.getY());
                    
                }
            }catch(IllegalArgumentException e){
                System.out.println("Erreur " + e.getMessage());
            }
        }
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
