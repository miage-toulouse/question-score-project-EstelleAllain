package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {

  private ScoreCalculateur ScoreCalculateur;
  private QuestionAChoixMultiple questionAChoixMultiple;

    @Before
    public void setUp() throws Exception {
        // given : une instance de question à choix multiple
        ScoreCalculateur = new ScoreCalculateur();
        questionAChoixMultiple = new QuestionAChoixMultiple("q1",new ArrayList<Integer>(Arrays.asList(2,3,5)));
    }

    @Test
    public void testGetScoreForIndiceBonneReponse() {
        // when : quand l'étudiant fournit l'indice de la bonne réponse
        List<Integer> reponse = new ArrayList<Integer>();
        reponse.add(2);
        reponse.add(3);
        reponse.add(5);
        // and : on demande le score de l'indice à la question
        float resScore = ScoreCalculateur.calculeScore(reponse,questionAChoixMultiple);

        // then : le score obtenu est 100
        assertEquals(100f, resScore, 0.01f);

    }

    @Test
    public void testGetScoreForIndiceMoitieBonneReponse() {
        // when : quand l'étudiant fournit l'indice de la bonne réponse
        List<Integer> reponse = new ArrayList<Integer>();
        reponse.add(2);
        reponse.add(3);
        // and : on demande le score de l'indice à la question
        float resScore = ScoreCalculateur.calculeScore(reponse,questionAChoixMultiple);

        // then : le score obtenu est 2*100/3 à 0,01 près
        float score = 2*100/3f;
        assertEquals(score, resScore, 0.01f);

    }

    @Test
    public void testGetScoreForIndiceMoitieBonneReponse2() {
        // when : quand l'étudiant fournit l'indice de la bonne réponse
        List<Integer> reponse = new ArrayList<Integer>();
        reponse.add(2);
        reponse.add(3);
        reponse.add(1);
        // and : on demande le score de l'indice à la question
        float resScore = ScoreCalculateur.calculeScore(reponse,questionAChoixMultiple);

        // then : le score obtenu est 2*100/3 à 0,01 près
        float score = 2*100/3f;
        assertEquals(16.66, resScore, 0.01f);

    }

    @Test
    public void testGetScoreForIndiceMauvaiseReponse() {
        // when : quand l'étudiant fournit l'indice d'une mauvaise réponse
        List<Integer> reponse = new ArrayList<Integer>();
        reponse.add(1);
        reponse.add(4);
        // and : on demande le score de l'indice à la question
        float resScore = ScoreCalculateur.calculeScore(reponse,questionAChoixMultiple);
        // then : le score obtenu est 0
        assertEquals(0f, resScore, 0.01f);
    }
    /*
    - quand on calcule le score pour une liste de réponses contenant les valeurs 1,2 et 3 on obtient 16.66 à 0,01 près comme résultat ;
- Après avoir constaté que ce test ne passait pas, modifiez le code de l'application et des tests (si nécessaire) afin que **tous les tests passent**. (Conseil : assurez-vous que vos modifications ne créent pas de nouvelles erreurs Checkstyle.)
*/
    @Test
    public void testGetScoreForIndiceMauvaiseReponse2() {
        // when : quand l'étudiant fournit l'indice d'une mauvaise réponse
        List<Integer> reponse = new ArrayList<Integer>();
        reponse.add(1);
        reponse.add(4);
        reponse.add(3);
        reponse.add(2);
        reponse.add(5);
        // and : on demande le score de l'indice à la question
        float resScore = ScoreCalculateur.calculeScore(reponse,questionAChoixMultiple);
        // then : le score obtenu est 0
        assertEquals(0f, resScore, 0.01f);
    }

}