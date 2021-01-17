package fr.ravageur.systemeblibliotheque.livre;

import fr.ravageur.systemeblibliotheque.bibliotheque.Bibliotheque;

public class Livre 
{
  private String titre;
  private String auteur;
  private GenreLivre genre;
  private int annee;
  private int edition;
  private Bibliotheque bibliothequeMere;
  private boolean estSorti;

  /**
   * Permet d'instancier un objet <code>Livre</code>.
   * @param titre
   * @param auteur
   * @param genre
   * @param annee
   * @param edition
   */
  public Livre(String titre, String auteur, GenreLivre genre, int annee, int edition) 
  {
    this.titre = titre;
    this.auteur = auteur;
    this.genre = genre;
    this.annee = annee;
    this.edition = edition;
  }

  /**
   * Permet d'obtenir le titre.
   * @return <code>String</code>
   */
  public String getTitre() 
  {
    return titre;
  }

  /**
   * Permet d'obtenir l'auteur.
   * @return <code>String</code>
   */
  public String getAuteur() 
  {
    return auteur;
  }

  /**
   * Permet d'obtenir le genre.
   * @return <code>GenreLivre</code>
   */
  public GenreLivre getGenre() 
  {
    return genre;
  }

  /**
   * Permet d'obtenir l'année.
   * @return <code>Integer</code>
   */
  public int getAnnee() 
  {
    return annee;
  }

  /**
   * Permet d'obtenir l'édition.
   * @return <code>Integer</code>
   */
  public int getEdition() 
  {
    return edition;
  }

  /**
   * Permet d'obtenir la blibliothèque.
   * @return <code>Bibliotheque</code>
   */
  public Bibliotheque getBibliothequeMere() 
  {
    return bibliothequeMere;
  }

  /**
   * Permet de définir la blibliotheque.
   * @param bibliotheque
   */
  public void setBibliothequeMere(Bibliotheque bibliotheque) 
  {
    this.bibliothequeMere = bibliotheque;
  }

  /**
   * Permet de définir l'état du livre à "Revenu".
   */
  public void enregistrerRetour() 
  {
    estSorti = false;
  }

  /**
   * Permet d'obtenir l'état du livre:
   * <p><code>true</code> si il est sorti.</p>
   * <p><code>false</code> si il est revenu.</p>
   * @return <code>boolean</code>
   */
  public boolean estSorti() 
  {
    return estSorti;
  }

  /**
   * Permet de définir l'état du livre à "Sorti".
   */
  public void enregistrerSortie() 
  {
    estSorti = true;
  }
}
