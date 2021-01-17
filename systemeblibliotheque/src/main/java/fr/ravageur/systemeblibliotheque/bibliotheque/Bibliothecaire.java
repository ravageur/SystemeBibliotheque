package fr.ravageur.systemeblibliotheque.bibliotheque;

import fr.ravageur.systemeblibliotheque.livre.Livre;

public class Bibliothecaire 
{
  private String nom;
  private int age;
  private Bibliotheque bibliotheque;
  private Livre livreFavori;

  /**
   * Permet d'instancier un ou une blibliothécaire.
   * @param nom
   * @param age
   * @param bibliotheque
   * @param livreFavori
   */
  public Bibliothecaire(String nom, int age, Bibliotheque bibliotheque, Livre livreFavori) 
  {
    this.nom = nom;
    this.age = age;
    this.bibliotheque = bibliotheque;
    this.livreFavori = livreFavori;
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
   * Permet d'obtenir l'age.
   * @return <code>Integer</code>
   */
  public int getAge() 
  {
    return age;
  }

  /**
   * Permet d'obtenir la blibliotheque.
   * @return <code>Bibliotheque</code>
   */
  public Bibliotheque getBibliotheque() 
  {
    return bibliotheque;
  }

  /**
   * Permet d'obtenir le livre favori.
   * @return <code>Livre</code>
   */
  public Livre getLivreFavori() 
  {
    return livreFavori;
  }

  /**
   * Permet de définir une nouvelle bibliothèque.
   * <p>Renvoie <code>true</code> si le changement s'est effectué avec succès.</p>
   * <p>Renvoie <code>false</code> si le changement à échoué.</p>
   * @param nouvelleBibliotheque
   * @return <code>boolean</code>
   */
  public boolean changerDeBibliotheque(Bibliotheque nouvelleBibliotheque) 
  {
    if(nouvelleBibliotheque != null)
    {
      bibliotheque = nouvelleBibliotheque;
      return true;
    }
    return false;
  }
}
