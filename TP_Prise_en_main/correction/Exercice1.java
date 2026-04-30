import MG2D.*;
import MG2D.geometrie.*;



class Exercice1 extends ApplicationMG2D{

	private Fenetre fenetre ;

	public Texture texture ; 

	public Exercice1(){
		super();

		fenetre = getFenetre();

		texture = new Texture(
			"anim/1.webp",
			new Point(100,100)
		);

		fenetre.ajouter(texture);
	}

    public void boucleDeJeu(){

    }

	public static void main(String[] args) {
		Exercice1 app = new Exercice1();
        app.lancerApplication();
	}
}
