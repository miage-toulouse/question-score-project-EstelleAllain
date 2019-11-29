package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {

    private QuestionAChoixMultiple questionChoixMultiple;

    @Before
    public void setUp() throws Exception {
        // given : une instance de question à choix multiple
        List<Integer> reponse = new ArrayList<Integer>();
        reponse.add(1);
        reponse.add(3);
        questionChoixMultiple = new QuestionAChoixMultiple("un énoncé à choix multiple", reponse);
    }

    @Test
    public void testGetEnonce() {
        // when : on demande son énoncé à la question
        String resEnonce = questionChoixMultiple.getEnonce();
        // then: l'énoncé retourné est l'énnoncé fourni à la construction de la question
        assertEquals("un énoncé à choix multiple", resEnonce);
    }

    @Test
    public void testGetScoreForIndiceBonneReponse() {
        // when : quand l'étudiant fournit l'indice de la bonne réponse
        List<Integer> reponse = new ArrayList<Integer>();
        reponse.add(1);
        reponse.add(3);
        // and : on demande le score de l'indice à la question
        float resScore = questionChoixMultiple.getScoreForIndice(reponse.get(0));
        resScore = resScore+ questionChoixMultiple.getScoreForIndice(reponse.get(1));

        // then : le score obtenu est 100
        assertEquals(100f, resScore, 0.01f);

    }

    @Test
    public void testGetScoreForIndiceMauvaiseReponse() {
        // when : quand l'étudiant fournit l'indice d'une mauvaise réponse
        int indiceEtudiant = 2 ;
        // and : on demande le score de l'indice à la question
        float resScore = questionChoixMultiple.getScoreForIndice(indiceEtudiant);
        // then : le score obtenu est 0
        assertEquals(0f, resScore, 0.01f);
    }
}