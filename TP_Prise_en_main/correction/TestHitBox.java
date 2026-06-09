import MG2D.*;
import MG2D.geometrie.*;

class TestHitBox extends ApplicationMG2D{

    private Texture vaisseau;
    private GroupeCollision cg;
    private Clavier c;
    private int vitesse;
    private Cercle ennemi;
    private double dx, dy;
    private Dessin hitbox;
    private Carre temoin;

    public TestHitBox(String str, int largeur, int hauteur, int delay){
	super(str, largeur, hauteur, delay);
	vitesse = 2;
	vaisseau = new Texture("vaisseau.png", new Point(100,100), 200, 200);
	this.getFenetre().ajouter(vaisseau);
	c = this.getClavier();
	ennemi = new Cercle(Couleur.ROUGE, new Point(15,500), 10, true);
	this.getFenetre().ajouter(ennemi);
	dx = 1;
	dy = 1;
	//vaisseau.changeFormeHitbox(new Carre(new Point(50,50), 100));
	//this.getFenetre().ajouter(vaisseau.getHitbox());
	cg = new GroupeCollision();
	cg.insertion(new Rectangle(new Point(150,175),100,50));
	cg.insertion(new Rectangle(new Point(175,150),50,100));
	this.getFenetre().ajouter(cg);
	temoin = new Carre(Couleur.ROUGE, new Point(0,0), 10, true);
	this.getFenetre().ajouter(temoin);
    }

    public void initialisation(){
    }

    public void boucleDeJeu(){
	if(c.getQEnfoncee()) {vaisseau.translater(-vitesse, 0); cg.translater(-vitesse, 0);}
	if(c.getDEnfoncee()) {vaisseau.translater(vitesse, 0); cg.translater(vitesse, 0);}
	if(c.getZEnfoncee()) {vaisseau.translater(0, vitesse); cg.translater(0, vitesse);}
	if(c.getSEnfoncee()) {vaisseau.translater(0, -vitesse); cg.translater(0, -vitesse);}
	ennemi.translater(dx, dy);
	if(ennemi.getO().getX()-ennemi.getRayon() == 0) dx = 1;
	if(ennemi.getO().getX()+ennemi.getRayon() == 800) dx = -1;
	if(ennemi.getO().getY()-ennemi.getRayon() == 0) dy = 1;
	if(ennemi.getO().getY()+ennemi.getRayon() == 600) dy = -1;

	if(ennemi.intersection(cg)) temoin.setCouleur(Couleur.VERT);
	else temoin.setCouleur(Couleur.ROUGE);
    }

    public void finDeBoucle(){
    }
    
}
