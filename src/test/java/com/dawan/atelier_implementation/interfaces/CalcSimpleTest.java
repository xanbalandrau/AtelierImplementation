package com.dawan.atelier_implementation.interfaces;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalcSimpleTest {
    private CalcSimple calculator = createCalculator();

    private CalcSimple createCalculator() {
        // TODO: Importez votre class qui implémente CalcSimple et returnez la ici
        throw new UnsupportedOperationException("Students must implement createCalculator() method");
    }

    @Test
    @DisplayName("Addition de deux nombres positifs")
    void testAddPositiveNumbers() {
        // Given
        int a = 5;
        int b = 3;
        
        // When
        int result = calculator.add(a, b);
        
        // Then
        assertEquals(8, result, "5 + 3 devrait égaler 8");
    }

    @Test
    @DisplayName("Addition de deux nombres négatifs")
    void testAddNegativeNumbers() {
        // Given
        int a = -5;
        int b = -3;
        
        // When
        int result = calculator.add(a, b);
        
        // Then
        assertEquals(-8, result, "-5 + (-3) devrait égaler -8");
    }

    @Test
    @DisplayName("Addition d'un nombre positif et négatif")
    void testAddPositiveAndNegative() {
        // Given
        int a = 5;
        int b = -3;
        
        // When
        int result = calculator.add(a, b);
        
        // Then
        assertEquals(2, result, "5 + (-3) devrait égaler 2");
    }

    @Test
    @DisplayName("Addition avec zéro")
    void testAddWithZero() {
        // Given
        int a = 5;
        int b = 0;
        
        // When
        int result = calculator.add(a, b);
        
        // Then
        assertEquals(5, result, "5 + 0 devrait égaler 5");
    }

    @ParameterizedTest
    @CsvSource({
        "0, 0, 0",
        "1, 1, 2",
        "10, 20, 30",
        "-10, -20, -30",
        "100, -50, 50",
        "-100, 50, -50"
    })
    @DisplayName("Tests paramétrés pour l'addition")
    void testAddParameterized(int a, int b, int expected) {
        // When
        int result = calculator.add(a, b);
        
        // Then
        assertEquals(expected, result, 
            String.format("%d + %d devrait égaler %d", a, b, expected));
    }

    @Test
    @DisplayName("Différence entre deux nombres positifs")
    void testDiffPositiveNumbers() {
        // Given
        int a = 10;
        int b = 3;
        
        // When
        int result = calculator.diff(a, b);
        
        // Then
        assertEquals(7, result, "10 - 3 devrait égaler 7");
    }

    @Test
    @DisplayName("Différence avec résultat négatif")
    void testDiffNegativeResult() {
        // Given
        int a = 3;
        int b = 10;
        
        // When
        int result = calculator.diff(a, b);
        
        // Then
        assertEquals(-7, result, "3 - 10 devrait égaler -7");
    }

    @Test
    @DisplayName("Différence de nombres négatifs")
    void testDiffNegativeNumbers() {
        // Given
        int a = -5;
        int b = -3;
        
        // When
        int result = calculator.diff(a, b);
        
        // Then
        assertEquals(-2, result, "-5 - (-3) devrait égaler -2");
    }

    @Test
    @DisplayName("Différence avec zéro")
    void testDiffWithZero() {
        // Given
        int a = 5;
        int b = 0;
        
        // When
        int result = calculator.diff(a, b);
        
        // Then
        assertEquals(5, result, "5 - 0 devrait égaler 5");
    }

    @Test
    @DisplayName("Différence de zéro")
    void testDiffFromZero() {
        // Given
        int a = 0;
        int b = 5;
        
        // When
        int result = calculator.diff(a, b);
        
        // Then
        assertEquals(-5, result, "0 - 5 devrait égaler -5");
    }

    @ParameterizedTest
    @CsvSource({
        "0, 0, 0",
        "10, 5, 5",
        "5, 10, -5",
        "-10, -5, -5",
        "-5, -10, 5",
        "100, 50, 50",
        "50, 100, -50"
    })
    @DisplayName("Tests paramétrés pour la différence")
    void testDiffParameterized(int a, int b, int expected) {
        // When
        int result = calculator.diff(a, b);
        
        // Then
        assertEquals(expected, result, 
            String.format("%d - %d devrait égaler %d", a, b, expected));
    }

    @Test
    @DisplayName("Test avec valeurs limites")
    void testEdgeCases() {
        // Test avec Integer.MAX_VALUE et Integer.MIN_VALUE
        assertDoesNotThrow(() -> {
            calculator.add(Integer.MAX_VALUE, 0);
            calculator.diff(Integer.MIN_VALUE, 0);
        }, "Les opérations ne devraient pas lever d'exception avec les valeurs limites");
    }

    @Test
    @DisplayName("Test de commutativité de l'addition")
    void testAddCommutativity() {
        // Given
        int a = 7;
        int b = 13;
        
        // When
        int result1 = calculator.add(a, b);
        int result2 = calculator.add(b, a);
        
        // Then
        assertEquals(result1, result2, "L'addition devrait être commutative");
    }
}
