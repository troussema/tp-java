package dessin;

public class EnsembleForme
{
  
  /*------------------------------------------------
   *                   data                        *
   *                                               *
   *-----------------------------------------------*/
  
  protected final int TAILLE_MAX;
  protected int placeRestante; // place restante dans l'ensemble
  protected Forme formes[];;

  
  /*------------------------------------------------
   *               constructors                    *
   *                                               *
   *-----------------------------------------------*/
  
  public EnsembleForme (int tailleMax)
  {
    if (tailleMax < 0)
    {
      System.out.println("taille de l'ensemble invalide donc a creer un ensemble de taille 1");
      tailleMax = 1;
    }
    TAILLE_MAX = tailleMax;
    formes = new Forme[tailleMax];
    placeRestante = tailleMax;
  }
  

  /*------------------------------------------------
   *                   methods                     *
   *                                               *
   *-----------------------------------------------*/
  
  /**
   * Pour ajoute un nouveau objet Forme à condition que sa capacité n'est pas dépassé.
   *
   * @param Forme nouveau objet Forme
   */
  public void ajouterForme (Forme f)
  {
    if (placeRestante > 0)
    {
      this.formes[TAILLE_MAX - placeRestante] = f;
      placeRestante --;
    }
    else
    {
      System.out.println("L'Ensemble n'a plus de place donc le dernier ajout a été annulé !!!");
    }
  }

  /**
   * Retourne la somme de tous les perimetres de ses formes
   *
   * @return double Somme total des perimtres des formes
   */
  public double  sommePerimetres ()
  {
    double somme = 0.0d;
    for (int i = 0; i < TAILLE_MAX; i++)
    {
      somme += formes[i].perimetre();
    }

    return somme;
  }

  /**
   * Methode qui calcul la somme des surfaces des formes convexes de l'ensemble
   *
   * @return double : la somme des surfaces
   */
  public double sommeSurface ()
  {
    double somme = 0.0d;
    for (int i = 0; i < TAILLE_MAX; i++)
      somme += (formes[i].surface() > 0) ? formes[i].surface() : 0.0d;
    return somme;
  }
  
  /**
   * Pour afficher les polygones qu'il contient
   */
  public void affiche ()
  {
    System.out.println(this.toString());
  }
  public String toString ()
  {
    int i;
    String str = new String();
    str = "\n Ensemble de Forme ("+ TAILLE_MAX +") : \n";
    for (i = 0; i < TAILLE_MAX; i++)
    {
      str += formes[i] + "; ";
    }

    return str;
  }
}
