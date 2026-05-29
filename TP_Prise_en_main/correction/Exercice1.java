import MG2D.*;
import MG2D.geometrie.*;



class Exercice1 extends ApplicationMG2D{

	private Fenetre fenetre ;
	private Clavier clavier = getClavier();

	public Texture texture1, texture2 ;

	int vitesse = 5; 

	public Exercice1(){
		super();
	}

	public void finDeBoucle(){

	}

	public void initialisation() {
		fenetre = getFenetre();

		texture1 = new Texture(
			"./img/duck1.jpg",
			new Point(250,250),
			100,
			100
		);

		texture2 = new Texture(
			"./img/duck2.jpg",
			new Point(64,64),
			100,
			100
		);

		Cercle nouvelleCollision = new Cercle(new Point(50,50), 16);

		texture2.changeFormeHitbox(nouvelleCollision);

		fenetre.ajouter(nouvelleCollision);

		fenetre.ajouter(texture1);
		fenetre.ajouter(texture2);
	}

    public void boucleDeJeu(){
		if (clavier.getZEnfoncee()){ texture1.translater(0, vitesse); }
		if (clavier.getSEnfoncee()){ texture1.translater(0, -vitesse); }
		if (clavier.getQEnfoncee()){ texture1.translater(-vitesse, 0); }
		if (clavier.getDEnfoncee()){ texture1.translater(vitesse, 0); }

		if (texture1.intersection(texture2)){
			System.out.println("Collision !");
		} 
    }

	public static void main(String[] args) {
		Exercice1 app = new Exercice1();
        app.lancerApplication();
	}
}
