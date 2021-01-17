package fr.ravageur.systemeblibliotheque.bibliotheque;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import fr.ravageur.systemeblibliotheque.livre.*;

public class Bibliotheque 
{

  private Bibliothecaire gerant;
  private String nom;
  private List<Bibliotheque> branches;
  private HashMap<GenreLivre, ArrayList<Livre>> livres = new HashMap<>();

  /**
   * Permet d'instancier une bibliothèque.
   * @param nom
   * @param gerant
   */
  public Bibliotheque(String nom, Bibliothecaire gerant) 
  {
    this.nom = nom;
    this.gerant = gerant;

    livres.put(GenreLivre.REFERENCE, new ArrayList<>());
    livres.put(GenreLivre.ROMAN, new ArrayList<>());
    livres.put(GenreLivre.BIBLIOGRAPHIE, new ArrayList<>());
    livres.put(GenreLivre.MANUEL, new ArrayList<>());
    livres.put(GenreLivre.CUISINE, new ArrayList<>());
  }

  /**
   * Permet d'obtenir le nom.
   * @return <code>String</code>
   */
  public String getNom() 
  {
    return nom;
  }

  /**
   * Permet d'obtenir le gerant.
   * @return <code>Bibliothecaire</code>
   */
  public Bibliothecaire getGerant() 
  {
    return gerant;
  }

  /**
   * Permet d'enregistrer un livre dans la bonne collection du genre de l'objet.
   * @param livre
   */
  public void enregistrerLivre(Livre livre) 
  {
    if(livre != null)
    {
      switch(livre.getGenre())
      {
        case BIBLIOGRAPHIE:
          livres.get(GenreLivre.BIBLIOGRAPHIE).add(livre);
        break;
        case CUISINE:
        livres.get(GenreLivre.CUISINE).add(livre);
        break;
        case MANUEL:
        livres.get(GenreLivre.MANUEL).add(livre);
        break;
        case REFERENCE:
        livres.get(GenreLivre.REFERENCE).add(livre);
        break;
        case ROMAN:
        livres.get(GenreLivre.ROMAN).add(livre);
        break;
      }
    }
  }

  /**
   * Permet de savoir si le livre en paramètre se situe dans cette bibliothèque.
   * <p>Renvoie <code>true</code> si le livre en paramètre se situe dans cette bibliothèque.</p>
   * <p>Renvoie <code>false</code> si le livre en pramètre n'est pas dans la blibliothèque.</p>
   * @param livre
   * @return <code>boolean</code>
   */
  public boolean estDansCatalogue(Livre livre) 
  {
    if(livre != null)
    {
      for(Entry<GenreLivre, ArrayList<Livre>> entry : livres.entrySet())
      {
        for(int i = 0; i < entry.getValue().size(); i++)
        {
          if(entry.getValue().get(i).equals(livre))
          {
            return true;
          }
        }
      }
    }
    return false;
  }

  /**
   * Permet de savoir si le livre est disponible à l'emprunt.
   * <p>Renvoie <code>true</code> si le livre est disponible à l'emprunt.</p>
   * <p>Renvoie <code>false</code> si le livre n'est pas disponible.</p>
   * @param livre
   * @return <code>boolean</code>
   */
  public boolean peutEtreEmprunte(Livre livre) 
  {
    if(livre != null && livre.estSorti() == false)
    {
      return true;
    }
    return false;
  }

  /**
   * Permet de savoir si livre est dans le catalogue de cette bliblothèque ou des 
   * autres branches de cette blibliothèque.
   * <p>Renvoie <code>true</code> si le livre est trouvé.</p>
   * <p>Renvoie <code>false</code> si le livre n'est pas trouvé.</p>
   * @param livre
   * @return <code>boolean</code>
   */
  public boolean estDansCatalogueEtendu(Livre livre) 
  {
    if(livre != null)
    {
      for(Bibliotheque bibliotheque : branches)
      {
        if(bibliotheque.estDansCatalogue(livre))
        {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Permet d'enregistrer le livre en paramètre à l'état "Sorti" si c'est possible.
   * <p>Renvoie <code>true</code> si le livre vient d'être défini à "Sorti".</p>
   * <p>Renvoie <code>false</code> si le livre ne peut pas être défini à "Sorti".</p>
   * @param livre
   * @return <code>boolean</code>
   */
  public boolean enregistrerSortie(Livre livre) 
  {
    if(livre != null)
    {
      if(livre.estSorti() == false)
      {
        livre.enregistrerSortie();
        return true;
      }
    }
    return false;
  }

  /**
   * Permet d'enregistrer le livre en paramètre à l'état "Revenu" si c'est possible.
   * <p>Renvoie <code>true</code> si le livre vient d'être défini à "Revenu".</p>
   * <p>Renvoie <code>false</code> si le livre ne peut pas être défini à "Revenu".</p>
   * @param livre
   * @return <code>boolean</code>
   */
  public boolean enregistrerRetour(Livre livre) 
  {
    if(livre != null)
    {
      if(livre.estSorti())
      {
        livre.enregistrerRetour();
        return true;
      }
    }
    return false;
  }

  /**
   * Permet de définir un gérant.
   * Renvoie <code>true</code> si le gérant a bien été défini.
   * Renvoie <code>false</code> si le gérant n'a pas pu être défini.
   * @param bibliothecaire
   * @return <code>boolean</code>
   */
  public boolean engagerGerant(Bibliothecaire bibliothecaire) 
  {
    if(gerant != null)
    {
      gerant = bibliothecaire;
      return true;
    }
    return false;
  }

  // EFFETS : affiche le catalogue de cette bibliothèque
  // (toutes les informations de chaque livre)
  /**
   * Permet de faire afficher chaque livre de la blibliothèque son titre, auteur, genre, 
   * année et édition.
   */
  public void afficherCatalogue() 
  {
    for(Entry<GenreLivre, ArrayList<Livre>> entry : livres.entrySet())
    {
      for(Livre livre : entry.getValue())
      {
        System.out.println(
        "Titre du livre: " + livre.getTitre() + 
        "\nAuteur du livre: " + livre.getAuteur() + 
        "\nGenre du livre: " + livre.getGenre() +
        "\nAnnée du livre: " + livre.getAnnee() + 
        "\nEdition du livre: " + livre.getEdition());
      }
    }
  }
}
