package com.dawan.atelier_implementation.interfaces;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InverteurTest {
    private Inverteur inverteur = createInverteur();

    private Inverteur createInverteur() {
        // TODO: Importez votre class qui implémente Inverteur et returnez la ici
        throw new UnsupportedOperationException("Students must implement createInverteur() method");
    }

    // Tests for negate method

    @Test
    @DisplayName("Négation de true")
    void testNegateTrue() {
        // Given
        boolean input = true;
        
        // When
        boolean result = inverteur.negate(input);
        
        // Then
        assertFalse(result, "La négation de true devrait être false");
    }

    @Test
    @DisplayName("Négation de false")
    void testNegateFalse() {
        // Given
        boolean input = false;
        
        // When
        boolean result = inverteur.negate(input);
        
        // Then
        assertTrue(result, "La négation de false devrait être true");
    }

    @ParameterizedTest
    @CsvSource({
        "true, false",
        "false, true"
    })
    @DisplayName("Tests paramétrés pour la négation")
    void testNegateParameterized(boolean input, boolean expected) {
        // When
        boolean result = inverteur.negate(input);
        
        // Then
        assertEquals(expected, result, 
            String.format("La négation de %b devrait être %b", input, expected));
    }

    @Test
    @DisplayName("Double négation retourne la valeur originale")
    void testDoubleNegation() {
        // Given
        boolean originalValue = true;
        
        // When
        boolean negated = inverteur.negate(originalValue);
        boolean doubleNegated = inverteur.negate(negated);
        
        // Then
        assertEquals(originalValue, doubleNegated, 
            "La double négation devrait retourner la valeur originale");
    }

    @Test
    @DisplayName("Test de cohérence de la négation")
    void testNegationConsistency() {
        // Test avec true
        assertFalse(inverteur.negate(true), "negate(true) devrait toujours être false");
        
        // Test avec false
        assertTrue(inverteur.negate(false), "negate(false) devrait toujours être true");
    }

    // Tests for areBothTrue method

    @Test
    @DisplayName("areBothTrue avec deux valeurs true")
    void testAreBothTrueWithBothTrue() {
        // Given
        boolean a = true;
        boolean b = true;
        
        // When
        boolean result = inverteur.areBothTrue(a, b);
        
        // Then
        assertTrue(result, "areBothTrue(true, true) devrait être true");
    }

    @Test
    @DisplayName("areBothTrue avec a true et b false")
    void testAreBothTrueWithFirstTrueSecondFalse() {
        // Given
        boolean a = true;
        boolean b = false;
        
        // When
        boolean result = inverteur.areBothTrue(a, b);
        
        // Then
        assertFalse(result, "areBothTrue(true, false) devrait être false");
    }

    @Test
    @DisplayName("areBothTrue avec a false et b true")
    void testAreBothTrueWithFirstFalseSecondTrue() {
        // Given
        boolean a = false;
        boolean b = true;
        
        // When
        boolean result = inverteur.areBothTrue(a, b);
        
        // Then
        assertFalse(result, "areBothTrue(false, true) devrait être false");
    }

    @Test
    @DisplayName("areBothTrue avec deux valeurs false")
    void testAreBothTrueWithBothFalse() {
        // Given
        boolean a = false;
        boolean b = false;
        
        // When
        boolean result = inverteur.areBothTrue(a, b);
        
        // Then
        assertFalse(result, "areBothTrue(false, false) devrait être false");
    }

    @ParameterizedTest
    @CsvSource({
        "true, true, true",
        "true, false, false",
        "false, true, false",
        "false, false, false"
    })
    @DisplayName("Tests paramétrés pour areBothTrue")
    void testAreBothTrueParameterized(boolean a, boolean b, boolean expected) {
        // When
        boolean result = inverteur.areBothTrue(a, b);
        
        // Then
        assertEquals(expected, result, 
            String.format("areBothTrue(%b, %b) devrait être %b", a, b, expected));
    }

    @Test
    @DisplayName("areBothTrue est commutatif")
    void testAreBothTrueCommutativity() {
        // Given
        boolean a = true;
        boolean b = false;
        
        // When
        boolean result1 = inverteur.areBothTrue(a, b);
        boolean result2 = inverteur.areBothTrue(b, a);
        
        // Then
        assertEquals(result1, result2, "areBothTrue devrait être commutatif");
    }

    @Test
    @DisplayName("Test de cohérence de areBothTrue")
    void testAreBothTrueConsistency() {
        // Test tous les cas possibles
        assertTrue(inverteur.areBothTrue(true, true), 
            "areBothTrue(true, true) devrait être true");
        
        assertFalse(inverteur.areBothTrue(true, false), 
            "areBothTrue(true, false) devrait être false");
        
        assertFalse(inverteur.areBothTrue(false, true), 
            "areBothTrue(false, true) devrait être false");
        
        assertFalse(inverteur.areBothTrue(false, false), 
            "areBothTrue(false, false) devrait être false");
    }

    // Tests combinés

    @Test
    @DisplayName("Test de cohérence entre les deux méthodes")
    void testMethodConsistency() {
        // Test que les méthodes fonctionnent ensemble de manière cohérente
        boolean original = true;
        boolean negated = inverteur.negate(original);
        
        // areBothTrue avec la valeur originale et sa négation devrait être false
        assertFalse(inverteur.areBothTrue(original, negated), 
            "areBothTrue avec une valeur et sa négation devrait être false");
        
        // areBothTrue avec deux fois la même valeur devrait être cette valeur
        assertTrue(inverteur.areBothTrue(original, original), 
            "areBothTrue avec deux fois la même valeur devrait être cette valeur");
    }

    @Test
    @DisplayName("Test de propriétés logiques")
    void testLogicalProperties() {
        // Propriété: areBothTrue(a, b) == areBothTrue(b, a) (commutativité)
        boolean a = true;
        boolean b = false;
        
        assertEquals(inverteur.areBothTrue(a, b), inverteur.areBothTrue(b, a),
            "areBothTrue devrait être commutatif");
        
        // Propriété: negate(negate(x)) == x (double négation)
        boolean x = false;
        assertEquals(x, inverteur.negate(inverteur.negate(x)),
            "La double négation devrait retourner la valeur originale");
    }

    @Test
    @DisplayName("Test de robustesse - les méthodes ne devraient pas lever d'exception")
    void testRobustness() {
        // When & Then
        assertDoesNotThrow(() -> {
            inverteur.negate(true);
            inverteur.negate(false);
            inverteur.areBothTrue(true, true);
            inverteur.areBothTrue(true, false);
            inverteur.areBothTrue(false, true);
            inverteur.areBothTrue(false, false);
        }, "Les méthodes ne devraient pas lever d'exception");
    }

    @Test
    @DisplayName("Test de performance - les méthodes devraient être rapides")
    void testPerformance() {
        // Test negate performance
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            inverteur.negate(i % 2 == 0);
        }
        long endTime = System.currentTimeMillis();
        
        assertTrue(endTime - startTime < 1000, 
            "1000 appels à negate() devraient s'exécuter en moins d'une seconde");
        
        // Test areBothTrue performance
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            inverteur.areBothTrue(i % 2 == 0, (i + 1) % 2 == 0);
        }
        endTime = System.currentTimeMillis();
        
        assertTrue(endTime - startTime < 1000, 
            "1000 appels à areBothTrue() devraient s'exécuter en moins d'une seconde");
    }
}
