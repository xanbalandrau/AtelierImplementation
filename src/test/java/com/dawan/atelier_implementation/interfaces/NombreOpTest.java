package com.dawan.atelier_implementation.interfaces;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NombreOpTest {
    private NombreOp nombreOp = createNombreOp();

    private NombreOp createNombreOp() {
        // TODO: Importez votre class qui implémente NombreOp et returnez la ici
        throw new UnsupportedOperationException("Students must implement createNombreOp() method");
    }

    // Tests for estPair method

    @Test
    @DisplayName("Vérification qu'un nombre pair est détecté comme pair")
    void testEstPairWithEvenNumber() {
        // Given
        int number = 4;
        
        // When
        boolean result = nombreOp.estPair(number);
        
        // Then
        assertTrue(result, "4 devrait être détecté comme pair");
    }

    @Test
    @DisplayName("Vérification qu'un nombre impair est détecté comme impair")
    void testEstPairWithOddNumber() {
        // Given
        int number = 5;
        
        // When
        boolean result = nombreOp.estPair(number);
        
        // Then
        assertFalse(result, "5 devrait être détecté comme impair");
    }

    @Test
    @DisplayName("Zéro est pair")
    void testEstPairWithZero() {
        // Given
        int number = 0;
        
        // When
        boolean result = nombreOp.estPair(number);
        
        // Then
        assertTrue(result, "0 devrait être considéré comme pair");
    }

    @Test
    @DisplayName("Nombres négatifs pairs")
    void testEstPairWithNegativeEven() {
        // Given
        int number = -4;
        
        // When
        boolean result = nombreOp.estPair(number);
        
        // Then
        assertTrue(result, "-4 devrait être considéré comme pair");
    }

    @Test
    @DisplayName("Nombres négatifs impairs")
    void testEstPairWithNegativeOdd() {
        // Given
        int number = -5;
        
        // When
        boolean result = nombreOp.estPair(number);
        
        // Then
        assertFalse(result, "-5 devrait être considéré comme impair");
    }

    @ParameterizedTest
    @CsvSource({
        "0, true",
        "1, false",
        "2, true",
        "3, false",
        "4, true",
        "5, false",
        "6, true",
        "7, false",
        "8, true",
        "9, false",
        "10, true",
        "-1, false",
        "-2, true",
        "-3, false",
        "-4, true",
        "-5, false",
        "100, true",
        "101, false",
        "1000, true",
        "1001, false"
    })
    @DisplayName("Tests paramétrés pour estPair")
    void testEstPairParameterized(int number, boolean expected) {
        // When
        boolean result = nombreOp.estPair(number);
        
        // Then
        assertEquals(expected, result, 
            String.format("%d devrait être %s", number, expected ? "pair" : "impair"));
    }

    // Tests for estPremier method

    @Test
    @DisplayName("Vérification qu'un nombre premier est détecté comme premier")
    void testEstPremierWithPrimeNumber() {
        // Given
        int number = 7;
        
        // When
        boolean result = nombreOp.estPremier(number);
        
        // Then
        assertTrue(result, "7 devrait être détecté comme premier");
    }

    @Test
    @DisplayName("Vérification qu'un nombre non-premier est détecté comme non-premier")
    void testEstPremierWithNonPrimeNumber() {
        // Given
        int number = 8;
        
        // When
        boolean result = nombreOp.estPremier(number);
        
        // Then
        assertFalse(result, "8 devrait être détecté comme non-premier");
    }

    @Test
    @DisplayName("2 est premier")
    void testEstPremierWithTwo() {
        // Given
        int number = 2;
        
        // When
        boolean result = nombreOp.estPremier(number);
        
        // Then
        assertTrue(result, "2 devrait être considéré comme premier");
    }

    @Test
    @DisplayName("3 est premier")
    void testEstPremierWithThree() {
        // Given
        int number = 3;
        
        // When
        boolean result = nombreOp.estPremier(number);
        
        // Then
        assertTrue(result, "3 devrait être considéré comme premier");
    }

    @Test
    @DisplayName("1 n'est pas premier")
    void testEstPremierWithOne() {
        // Given
        int number = 1;
        
        // When
        boolean result = nombreOp.estPremier(number);
        
        // Then
        assertFalse(result, "1 ne devrait pas être considéré comme premier");
    }

    @Test
    @DisplayName("0 n'est pas premier")
    void testEstPremierWithZero() {
        // Given
        int number = 0;
        
        // When
        boolean result = nombreOp.estPremier(number);
        
        // Then
        assertFalse(result, "0 ne devrait pas être considéré comme premier");
    }

    @Test
    @DisplayName("Nombres négatifs ne sont pas premiers")
    void testEstPremierWithNegativeNumbers() {
        // Given
        int number = -7;
        
        // When
        boolean result = nombreOp.estPremier(number);
        
        // Then
        assertFalse(result, "Les nombres négatifs ne devraient pas être considérés comme premiers");
    }

    @Test
    @DisplayName("Nombres premiers connus")
    void testEstPremierWithKnownPrimes() {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
        
        for (int prime : primes) {
            assertTrue(nombreOp.estPremier(prime), 
                String.format("%d devrait être détecté comme premier", prime));
        }
    }

    @Test
    @DisplayName("Nombres composés connus")
    void testEstPremierWithKnownComposites() {
        int[] composites = {4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25};
        
        for (int composite : composites) {
            assertFalse(nombreOp.estPremier(composite), 
                String.format("%d devrait être détecté comme non-premier", composite));
        }
    }

    @ParameterizedTest
    @CsvSource({
        "0, false",
        "1, false",
        "2, true",
        "3, true",
        "4, false",
        "5, true",
        "6, false",
        "7, true",
        "8, false",
        "9, false",
        "10, false",
        "11, true",
        "12, false",
        "13, true",
        "14, false",
        "15, false",
        "16, false",
        "17, true",
        "18, false",
        "19, true",
        "20, false",
        "23, true",
        "25, false",
        "29, true",
        "31, true",
        "37, true",
        "41, true",
        "43, true",
        "47, true",
        "49, false",
        "53, true",
        "59, true",
        "61, true",
        "67, true",
        "71, true",
        "73, true",
        "79, true",
        "83, true",
        "89, true",
        "97, true"
    })
    @DisplayName("Tests paramétrés pour estPremier")
    void testEstPremierParameterized(int number, boolean expected) {
        // When
        boolean result = nombreOp.estPremier(number);
        
        // Then
        assertEquals(expected, result, 
            String.format("%d devrait être %s", number, expected ? "premier" : "non-premier"));
    }

    // Tests combinés

    @Test
    @DisplayName("Test de cohérence entre estPair et estPremier")
    void testConsistencyBetweenMethods() {
        // Tous les nombres premiers > 2 sont impairs
        for (int i = 3; i <= 100; i++) {
            if (nombreOp.estPremier(i)) {
                assertFalse(nombreOp.estPair(i), 
                    String.format("Le nombre premier %d devrait être impair", i));
            }
        }
        
        // 2 est le seul nombre premier pair
        assertTrue(nombreOp.estPremier(2), "2 devrait être premier");
        assertTrue(nombreOp.estPair(2), "2 devrait être pair");
    }

    @Test
    @DisplayName("Test avec des valeurs limites")
    void testEdgeCases() {
        // Test avec Integer.MAX_VALUE et Integer.MIN_VALUE
        assertDoesNotThrow(() -> {
            nombreOp.estPair(Integer.MAX_VALUE);
            nombreOp.estPremier(Integer.MAX_VALUE);
            nombreOp.estPair(Integer.MIN_VALUE);
            nombreOp.estPremier(Integer.MIN_VALUE);
        }, "Les méthodes ne devraient pas lever d'exception avec les valeurs limites");
    }

    @Test
    @DisplayName("Test de performance")
    void testPerformance() {
        // Test estPair performance
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            nombreOp.estPair(i);
        }
        long endTime = System.currentTimeMillis();
        
        assertTrue(endTime - startTime < 1000, 
            "1000 appels à estPair() devraient s'exécuter en moins d'une seconde");
        
        // Test estPremier performance
        startTime = System.currentTimeMillis();
        for (int i = 2; i < 100; i++) {
            nombreOp.estPremier(i);
        }
        endTime = System.currentTimeMillis();
        
        assertTrue(endTime - startTime < 1000, 
            "100 appels à estPremier() devraient s'exécuter en moins d'une seconde");
    }

    @Test
    @DisplayName("Test de robustesse - les méthodes ne devraient pas lever d'exception")
    void testRobustness() {
        // When & Then
        assertDoesNotThrow(() -> {
            nombreOp.estPair(0);
            nombreOp.estPair(1);
            nombreOp.estPair(-1);
            nombreOp.estPremier(0);
            nombreOp.estPremier(1);
            nombreOp.estPremier(-1);
        }, "Les méthodes ne devraient pas lever d'exception");
    }

    @Test
    @DisplayName("Test de propriétés mathématiques")
    void testMathematicalProperties() {
        // Propriété: Si n est pair, alors n+1 est impair
        for (int i = 0; i < 100; i += 2) {
            assertTrue(nombreOp.estPair(i), String.format("%d devrait être pair", i));
            assertFalse(nombreOp.estPair(i + 1), String.format("%d devrait être impair", i + 1));
        }
        
        // Propriété: 2 est le seul nombre premier pair
        assertTrue(nombreOp.estPremier(2) && nombreOp.estPair(2), 
            "2 devrait être à la fois premier et pair");
        
        // Propriété: Tous les autres nombres premiers sont impairs
        for (int i = 3; i <= 100; i++) {
            if (nombreOp.estPremier(i)) {
                assertFalse(nombreOp.estPair(i), 
                    String.format("Le nombre premier %d devrait être impair", i));
            }
        }
    }
}
