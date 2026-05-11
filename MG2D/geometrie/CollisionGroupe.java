package MG2D.geometrie;

import java.util.ArrayList;
import java.awt.Graphics;

public class CollisionGroupe extends Dessin {

    private ArrayList<Dessin> managedDessins;

    public CollisionGroupe(){
        managedDessins = new ArrayList<>();
    }

    public boolean intersection(Dessin d){
        boolean isIntersecting = false;
        for(Dessin t : managedDessins){
            if(t.intersection(d)){
                isIntersecting = true;
                break;
            }
        }
        return isIntersecting;
    }

    public void insertion(Dessin t){
        if(!managedDessins.contains(t)){
            managedDessins.add(t);
        }
    }

    public void suppression(int indice){
        if(indice >= 0 && indice < managedDessins.size()){
            managedDessins.remove(indice);
        }
    }

    public void suppression(Dessin t){
        managedDessins.remove(t);
    }

    public ArrayList<Dessin> getManagedDessins(){
        return managedDessins;
    }

    public Dessin getManagedDessin(int indice){
        if(indice >= 0 && indice < managedDessins.size()){
            return managedDessins.get(indice);
        }
        return null;
    }

    public void afficher ( Graphics g ) {
        for(Dessin t : managedDessins){
            t.afficher(g);
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("CollisionGroupe : \n");
        for(Dessin t : managedDessins){
            sb.append(t.toString()).append("\n");
        }
        return sb.toString();
    }

    public BoiteEnglobante getBoiteEnglobante(){
        return null;
    }

    public void translater(double x, double y){
        for(Dessin t : managedDessins){
            t.translater(x, y);
        }
    }
}