package com.dawan.atelier_implementation.interfaces;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalcInterTest {
    private CalcInter calculator = createCalculator();

    private CalcInter createCalculator() {
        // TODO: Importez votre class qui implémente CalcInter et returnez la ici
        throw new UnsupportedOperationException("Students must implement createCalculator() method");
    }

    @Test
    @DisplayName("Multiplication de deux nombres positifs")
    void testMultPositiveNumbers() {
        // Given
        int a = 4;
        int b = 5;
        
        // When
        int result = calculator.mult(a, b);
        
        // Then
        assertEquals(20, result, "4 * 5 devrait égaler 20");
    }

    @Test
    @DisplayName("Multiplication de deux nombres négatifs")
    void testMultNegativeNumbers() {
        // Given
        int a = -3;
        int b = -4;
        
        // When
        int result = calculator.mult(a, b);
        
        // Then
        assertEquals(12, result, "(-3) * (-4) devrait égaler 12");
    }

    @Test
    @DisplayName("Multiplication d'un nombre positif et négatif")
    void testMultPositiveAndNegative() {
        // Given
        int a = 5;
        int b = -3;
        
        // When
        int result = calculator.mult(a, b);
        
        // Then
        assertEquals(-15, result, "5 * (-3) devrait égaler -15");
    }

    @Test
    @DisplayName("Multiplication avec zéro")
    void testMultWithZero() {
        // Given
        int a = 5;
        int b = 0;
        
        // When
        int result = calculator.mult(a, b);
        
        // Then
        assertEquals(0, result, "5 * 0 devrait égaler 0");
    }

    @Test
    @DisplayName("Multiplication avec un")
    void testMultWithOne() {
        // Given
        int a = 7;
        int b = 1;
        
        // When
        int result = calculator.mult(a, b);
        
        // Then
        assertEquals(7, result, "7 * 1 devrait égaler 7");
    }

    @ParameterizedTest
    @CsvSource({
        "0, 0, 0",
        "1, 1, 1",
        "2, 3, 6",
        "-2, 3, -6",
        "2, -3, -6",
        "-2, -3, 6",
        "10, 10, 100",
        "-10, 10, -100"
    })
    @DisplayName("Tests paramétrés pour la multiplication")
    void testMultParameterized(int a, int b, int expected) {
        // When
        int result = calculator.mult(a, b);
        
        // Then
        assertEquals(expected, result, 
            String.format("%d * %d devrait égaler %d", a, b, expected));
    }

    @Test
    @DisplayName("Division de deux nombres positifs")
    void testDivPositiveNumbers() {
        // Given
        int a = 15;
        int b = 3;
        
        // When
        int result = calculator.div(a, b);
        
        // Then
        assertEquals(5, result, "15 / 3 devrait égaler 5");
    }

    @Test
    @DisplayName("Division de deux nombres négatifs")
    void testDivNegativeNumbers() {
        // Given
        int a = -12;
        int b = -3;
        
        // When
        int result = calculator.div(a, b);
        
        // Then
        assertEquals(4, result, "(-12) / (-3) devrait égaler 4");
    }

    @Test
    @DisplayName("Division d'un nombre positif et négatif")
    void testDivPositiveAndNegative() {
        // Given
        int a = 15;
        int b = -3;
        
        // When
        int result = calculator.div(a, b);
        
        // Then
        assertEquals(-5, result, "15 / (-3) devrait égaler -5");
    }

    @Test
    @DisplayName("Division avec reste")
    void testDivWithRemainder() {
        // Given
        int a = 17;
        int b = 3;
        
        // When
        int result = calculator.div(a, b);
        
        // Then
        assertEquals(5, result, "17 / 3 devrait égaler 5 (division entière)");
    }

    @Test
    @DisplayName("Division par un")
    void testDivByOne() {
        // Given
        int a = 7;
        int b = 1;
        
        // When
        int result = calculator.div(a, b);
        
        // Then
        assertEquals(7, result, "7 / 1 devrait égaler 7");
    }

    @Test
    @DisplayName("Division de zéro")
    void testDivZero() {
        // Given
        int a = 0;
        int b = 5;
        
        // When
        int result = calculator.div(a, b);
        
        // Then
        assertEquals(0, result, "0 / 5 devrait égaler 0");
    }

    @ParameterizedTest
    @CsvSource({
        "10, 2, 5",
        "20, 4, 5",
        "-10, 2, -5",
        "10, -2, -5",
        "-10, -2, 5",
        "100, 10, 10",
        "7, 2, 3"
    })
    @DisplayName("Tests paramétrés pour la division")
    void testDivParameterized(int a, int b, int expected) {
        // When
        int result = calculator.div(a, b);
        
        // Then
        assertEquals(expected, result, 
            String.format("%d / %d devrait égaler %d", a, b, expected));
    }

    @Test
    @DisplayName("Test de commutativité de la multiplication")
    void testMultCommutativity() {
        // Given
        int a = 7;
        int b = 13;
        
        // When
        int result1 = calculator.mult(a, b);
        int result2 = calculator.mult(b, a);
        
        // Then
        assertEquals(result1, result2, "La multiplication devrait être commutative");
    }

    @Test
    @DisplayName("Test avec valeurs limites")
    void testEdgeCases() {
        // Test avec Integer.MAX_VALUE et Integer.MIN_VALUE
        assertDoesNotThrow(() -> {
            calculator.mult(Integer.MAX_VALUE, 1);
            calculator.div(Integer.MIN_VALUE, 1);
        }, "Les opérations ne devraient pas lever d'exception avec les valeurs limites");
    }

    @Test
    @DisplayName("Test de propriété distributive")
    void testDistributiveProperty() {
        // Given
        int a = 3;
        int b = 4;
        int c = 5;
        
        // When - Test de la multiplication avec des valeurs calculées
        int result1 = calculator.mult(a, b + c); // a * (b + c)
        int result2 = calculator.mult(a, b) + calculator.mult(a, c); // (a * b) + (a * c)
        
        // Then
        assertEquals(result1, result2, "La propriété distributive devrait être respectée");
        assertEquals(27, calculator.mult(a, 9), "3 * 9 devrait égaler 27");
    }
}
