import MG2D.*;
import MG2D.geometrie.*;



class Exercice1 extends ApplicationMG2D{

	private Fenetre fenetre ;

	public Animation anim1 , anim2 ; 

	public Texture texture1, texture2 ;

	public Exercice1(){
		super();
	}

	public void finDeBoucle(){

	}

	public void initialisation() {
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

		texture1 = new Texture(
			"./img/duck1.jpg",
			new Point(0,0)
		);

		texture2 = new Texture(
			"./img/duck2.jpg",
			new Point(64,64)
		);

		Cercle nouvelleCollision = new Cercle(new Point(100,100), 25);

		Cercle nouvelleCollision2 = new Cercle(new Point(8,8), 50);

		CollisionGroupe collisionGroupe = new CollisionGroupe();
		collisionGroupe.insertion(nouvelleCollision);
		collisionGroupe.insertion(nouvelleCollision2);

		texture1.changeFormeHitbox(nouvelleCollision);
		texture2.changeFormeHitbox(collisionGroupe);

		fenetre.ajouter(nouvelleCollision);

		fenetre.ajouter(collisionGroupe);

		fenetre.ajouter(texture1);
		fenetre.ajouter(texture2);

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
