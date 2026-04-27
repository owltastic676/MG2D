import MG2D.*;
import MG2D.geometrie.*;



class Exercice1 extends ApplicationMG2D{

	private Fenetre fenetre ;

	public Exercice1(){
		super();

		fenetre = getFenetre();
	}

    public void boucleDeJeu(){
		Cercle roueG = new Cercle(Couleur.NOIR, new Point(100,200), 20, true);
		Cercle roueD = new Cercle(Couleur.NOIR, new Point(300,200), 20, true);
		Rectangle caisse = new Rectangle (Couleur.GRIS_FONCE, new Point(60,200), new Point(340,240), true);
		Rectangle vitreMilieu = new Rectangle (Couleur.GRIS, new Point(160,240), new Point(240,280), true);
		Triangle vitreArriere = new Triangle (Couleur.GRIS_CLAIR, new Point(160,280), new Point(60,240), new Point(160,240), true);
		Triangle vitreAvant = new Triangle (Couleur.GRIS_CLAIR, new Point(240,280), new Point(240,240), new Point(280,240), true);
		
		fenetre.ajouter(caisse);
		fenetre.ajouter(vitreMilieu);
		fenetre.ajouter(vitreArriere);
		fenetre.ajouter(vitreAvant);
		fenetre.ajouter(roueG);
		fenetre.ajouter(roueD);
    }

	public static void main(String[] args) {
		Exercice1 app = new Exercice1();
        app.lancerApplication();
	}
}
