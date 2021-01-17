package fr.ravageur.systemeblibliotheque.bibliotheque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import fr.ravageur.systemeblibliotheque.livre.*;

public class BibliothequeTests 
{

  private Livre livreRef;
  private Livre livreRom;
  private Livre livreBiblio;
  private Livre livreMan;
  private Livre livreCui;
  private Bibliotheque testBibliotheque;
  private Bibliothecaire testBibliothecaire;

  @BeforeEach
  public void setUp() 
  {
    testBibliotheque = new Bibliotheque("Bibliothèque privée Dampierre", testBibliothecaire);
    testBibliothecaire = new Bibliothecaire("Kevin Roy", 10, testBibliotheque, livreRom);

    livreRef = new Livre("Dormir n'importe où", "E. Clément, B. Briendo", GenreLivre.REFERENCE, 2021, 1);
    livreRef.setBibliothequeMere(testBibliotheque);
    testBibliotheque.enregistrerLivre(livreRef);
    livreRom = new Livre("Pizza mon amour", "T. Geneste", GenreLivre.ROMAN, 2020, 2);
    livreRom.setBibliothequeMere(testBibliotheque);
    testBibliotheque.enregistrerLivre(livreRom);
    livreBiblio = new Livre("Ma vie avec lui", "A. Krzykawsky", GenreLivre.BIBLIOGRAPHIE, 2023, 1);
    livreBiblio.setBibliothequeMere(testBibliotheque);
    testBibliotheque.enregistrerLivre(livreBiblio);
    livreMan = new Livre("Introduction à la programmation C#", "M. Giera", GenreLivre.MANUEL, 2035, 2);
    livreMan.setBibliothequeMere(testBibliotheque);
    testBibliotheque.enregistrerLivre(livreMan);
    livreCui = new Livre("Maîtriser l'Art de l'Américain-cervelas", "Q. Delaporte", GenreLivre.CUISINE, 2020, 2);
    livreCui.setBibliothequeMere(testBibliotheque);
    testBibliotheque.enregistrerLivre(livreCui);
  }

  @Test
  public void test1() 
  {
    assertEquals("Bibliothèque privée Dampierre", testBibliotheque.getNom());
  }

  @Test
  public void test2() 
  {
    assertEquals(true, testBibliotheque.estDansCatalogue(livreRef));
    assertEquals(true, testBibliotheque.estDansCatalogue(livreCui));
    assertEquals(true, testBibliotheque.estDansCatalogue(livreRom));
    assertEquals(true, testBibliotheque.estDansCatalogue(livreMan));
  }

  @Test
  public void test3() 
  {
    assertEquals(true, testBibliotheque.peutEtreEmprunte(livreRef));
    testBibliotheque.enregistrerSortie(livreRef);
    assertEquals(false, testBibliotheque.peutEtreEmprunte(livreRef));

    assertEquals(true, testBibliotheque.peutEtreEmprunte(livreCui));
    testBibliotheque.enregistrerSortie(livreCui);
    assertEquals(false, testBibliotheque.peutEtreEmprunte(livreCui));
  }

  @Test
  public void test4() 
  {
    assertEquals(true, testBibliotheque.peutEtreEmprunte(livreMan));
    assertEquals(true, testBibliotheque.enregistrerSortie(livreMan));
    assertEquals(false, testBibliotheque.peutEtreEmprunte(livreMan));
    assertEquals(true, testBibliotheque.enregistrerRetour(livreMan));
    assertEquals(true, testBibliotheque.peutEtreEmprunte(livreMan));
  }
}
