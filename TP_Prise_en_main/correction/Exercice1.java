import MG2D.*;
import MG2D.geometrie.*;



class Exercice1 extends ApplicationMG2D{

	private Fenetre fenetre ;
	private Clavier clavier = getClavier();
	
	public Animation animation1, animation2 ;

	int vitesse = 5; 

	public Exercice1(){
		super();
	}

	public void initialisation() {
		fenetre = getFenetre();

		animation1 = new Animation(
			"./img/moving/duck",
			1,
			6,
			"png",
			100,
			new Point(350,350),
			100,
			100
		);

		animation2 = new Animation(
			"./img/idle/duck",
			1,
			3,
			"png",
			100,
			new Point(64,64),
			100,
			100
		);

		Cercle nouvelleCollision = new Cercle(new Point(50,50), 16);

		fenetre.ajouter(nouvelleCollision);

		fenetre.ajouter(animation2);

		fenetre.ajouter(animation2.getHitbox());
		fenetre.ajouter(animation1.getHitbox());

		animation1.changeFormeHitbox(nouvelleCollision);

		fenetre.ajouter(animation1);
		fenetre.ajouter(animation1.getHitbox());
	}

    public void boucleDeJeu(){
		if (clavier.getZEnfoncee()){ animation1.translater(0, vitesse); }
		if (clavier.getSEnfoncee()){ animation1.translater(0, -vitesse); }
		if (clavier.getQEnfoncee()){ animation1.translater(-vitesse, 0); }
		if (clavier.getDEnfoncee()){ animation1.translater(vitesse, 0); }

		if (animation1.intersection(animation2)){
			System.out.println("Collision !");
		} 
    }

	public static void main(String[] args) {
		Exercice1 app = new Exercice1();
        app.lancerApplication();
	}
}
