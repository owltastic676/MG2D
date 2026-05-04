import MG2D.*;
import MG2D.geometrie.*;



class Exercice1 extends ApplicationMG2D{

	private Fenetre fenetre ;

	public Animation anim1 , anim2 ; 

	public Exercice1(){
		super();

		fenetre = getFenetre();

		anim1 = new Animation(
            "./img/duck",  
            1,          
            4,          
            "jpg",      
			100,  
            new Point(400, 300),
			64,
			64
        );

		anim2 = new Animation(
            "./img/duck",  
            1,          
            4,          
            "jpg",      
			300,  
            new Point(500, 300),
			64,
			64
        );



		fenetre.ajouter(anim1);
		fenetre.ajouter(anim2);
	}

    public void boucleDeJeu(){

    }

	public static void main(String[] args) {
		Exercice1 app = new Exercice1();
        app.lancerApplication();
	}
}
