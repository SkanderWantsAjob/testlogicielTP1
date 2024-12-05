package junit.monprojet;
import java.util.HashMap;

public class PorteMonnaie {
    private HashMap<String, Integer> contenu;

    
    public PorteMonnaie() {
        contenu = new HashMap<String, Integer>();
    }

    
    public HashMap<String, Integer> getContenu() {
        return contenu;
    }
public void ajouteSomme(SommeArgent sa) {
    String unite = sa.getUnite();  
    int quantite = sa.getQuantite();   

    
    if (contenu.containsKey(unite)) {
        contenu.put(unite, contenu.get(unite) + quantite);
    } else {
        
        contenu.put(unite, quantite);
    }
}
@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Porte-Monnaie: ");
    if (contenu.isEmpty()) {
        sb.append("Vide");
    } else {
        for (String devise : contenu.keySet()) {
            sb.append(devise).append(" : ").append(contenu.get(devise)).append(" ");
        }
    }
    return sb.toString().trim();
}

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PorteMonnaie other = (PorteMonnaie) obj;
        return contenu.equals(other.contenu);
    }
    
}