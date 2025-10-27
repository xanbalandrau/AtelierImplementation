package com.dawan.atelier_implementation.interfaces;

import com.dawan.atelier_implementation.interfaces.resource.ConverteurException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConverteurTest {
    private Converteur converteur = createConverteur();

    private Converteur createConverteur() {
        // TODO: Importez votre class qui implémente Converteur et returnez la ici
        throw new UnsupportedOperationException("Students must implement createConverteur() method");
    }

    // Tests for parseInt method

    @Test
    @DisplayName("Conversion d'un nombre positif valide")
    void testParseIntPositiveNumber() throws ConverteurException {
        // Given
        String input = "123";
        
        // When
        int result = converteur.parseInt(input);
        
        // Then
        assertEquals(123, result, "La chaîne '123' devrait être convertie en 123");
    }

    @Test
    @DisplayName("Conversion d'un nombre négatif valide")
    void testParseIntNegativeNumber() throws ConverteurException {
        // Given
        String input = "-456";
        
        // When
        int result = converteur.parseInt(input);
        
        // Then
        assertEquals(-456, result, "La chaîne '-456' devrait être convertie en -456");
    }

    @Test
    @DisplayName("Conversion de zéro")
    void testParseIntZero() throws ConverteurException {
        // Given
        String input = "0";
        
        // When
        int result = converteur.parseInt(input);
        
        // Then
        assertEquals(0, result, "La chaîne '0' devrait être convertie en 0");
    }

    @Test
    @DisplayName("Conversion avec espaces")
    void testParseIntWithSpaces() throws ConverteurException {
        // Given
        String input = "  789  ";
        
        // When
        int result = converteur.parseInt(input);
        
        // Then
        assertEquals(789, result, "La chaîne '  789  ' devrait être convertie en 789");
    }

    @ParameterizedTest
    @CsvSource({
        "'1', 1",
        "'-1', -1",
        "'100', 100",
        "'-100', -100",
        "'999', 999",
        "'-999', -999",
        "' 42 ', 42",
        "' -42 ', -42"
    })
    @DisplayName("Tests paramétrés pour parseInt")
    void testParseIntParameterized(String input, int expected) throws ConverteurException {
        // When
        int result = converteur.parseInt(input);
        
        // Then
        assertEquals(expected, result, 
            String.format("La chaîne '%s' devrait être convertie en %d", input, expected));
    }

    @Test
    @DisplayName("Exception pour chaîne contenant des lettres")
    void testParseIntWithLetters() {
        // Given
        String input = "123abc";
        
        // When & Then
        ConverteurException exception = assertThrows(ConverteurException.class, 
            () -> converteur.parseInt(input),
            "Une ConverteurException devrait être levée pour '123abc'");
        
        assertNotNull(exception.getMessage(), "Le message d'exception ne devrait pas être null");
    }

    @Test
    @DisplayName("Exception pour chaîne vide")
    void testParseIntEmptyString() {
        // Given
        String input = "";
        
        // When & Then
        ConverteurException exception = assertThrows(ConverteurException.class, 
            () -> converteur.parseInt(input),
            "Une ConverteurException devrait être levée pour une chaîne vide");
        
        assertNotNull(exception.getMessage(), "Le message d'exception ne devrait pas être null");
    }

    @Test
    @DisplayName("Exception pour chaîne null")
    void testParseIntNull() {
        // Given
        String input = null;
        
        // When & Then
        ConverteurException exception = assertThrows(ConverteurException.class, 
            () -> converteur.parseInt(input),
            "Une ConverteurException devrait être levée pour null");
        
        assertNotNull(exception.getMessage(), "Le message d'exception ne devrait pas être null");
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "12.34", "12,34", "12a", "a12", "++123", "--123", "12-3"})
    @DisplayName("Tests paramétrés pour les chaînes invalides")
    void testParseIntInvalidStrings(String input) {
        // When & Then
        assertThrows(ConverteurException.class, 
            () -> converteur.parseInt(input),
            String.format("Une ConverteurException devrait être levée pour '%s'", input));
    }

    // Tests for parseBool method

    @Test
    @DisplayName("Conversion de 'true' en boolean")
    void testParseBoolTrue() throws ConverteurException {
        // Given
        String input = "true";
        
        // When
        boolean result = converteur.parseBool(input);
        
        // Then
        assertTrue(result, "La chaîne 'true' devrait être convertie en true");
    }

    @Test
    @DisplayName("Conversion de 'false' en boolean")
    void testParseBoolFalse() throws ConverteurException {
        // Given
        String input = "false";
        
        // When
        boolean result = converteur.parseBool(input);
        
        // Then
        assertFalse(result, "La chaîne 'false' devrait être convertie en false");
    }

    @Test
    @DisplayName("Conversion de 'TRUE' en boolean")
    void testParseBoolTrueUpperCase() throws ConverteurException {
        // Given
        String input = "TRUE";
        
        // When
        boolean result = converteur.parseBool(input);
        
        // Then
        assertTrue(result, "La chaîne 'TRUE' devrait être convertie en true");
    }

    @Test
    @DisplayName("Conversion de 'FALSE' en boolean")
    void testParseBoolFalseUpperCase() throws ConverteurException {
        // Given
        String input = "FALSE";
        
        // When
        boolean result = converteur.parseBool(input);
        
        // Then
        assertFalse(result, "La chaîne 'FALSE' devrait être convertie en false");
    }

    @Test
    @DisplayName("Conversion de 'True' en boolean")
    void testParseBoolTrueMixedCase() throws ConverteurException {
        // Given
        String input = "True";
        
        // When
        boolean result = converteur.parseBool(input);
        
        // Then
        assertTrue(result, "La chaîne 'True' devrait être convertie en true");
    }

    @Test
    @DisplayName("Conversion avec espaces")
    void testParseBoolWithSpaces() throws ConverteurException {
        // Given
        String input = "  true  ";
        
        // When
        boolean result = converteur.parseBool(input);
        
        // Then
        assertTrue(result, "La chaîne '  true  ' devrait être convertie en true");
    }

    @ParameterizedTest
    @CsvSource({
        "'true', true",
        "'false', false",
        "'TRUE', true",
        "'FALSE', false",
        "'True', true",
        "'False', false",
        "'tRuE', true",
        "'fAlSe', false",
        "' true ', true",
        "' false ', false"
    })
    @DisplayName("Tests paramétrés pour parseBool")
    void testParseBoolParameterized(String input, boolean expected) throws ConverteurException {
        // When
        boolean result = converteur.parseBool(input);
        
        // Then
        assertEquals(expected, result, 
            String.format("La chaîne '%s' devrait être convertie en %b", input, expected));
    }

    @Test
    @DisplayName("Exception pour chaîne invalide")
    void testParseBoolInvalidString() {
        // Given
        String input = "yes";
        
        // When & Then
        ConverteurException exception = assertThrows(ConverteurException.class, 
            () -> converteur.parseBool(input),
            "Une ConverteurException devrait être levée pour 'yes'");
        
        assertNotNull(exception.getMessage(), "Le message d'exception ne devrait pas être null");
    }

    @Test
    @DisplayName("Exception pour chaîne vide")
    void testParseBoolEmptyString() {
        // Given
        String input = "";
        
        // When & Then
        ConverteurException exception = assertThrows(ConverteurException.class, 
            () -> converteur.parseBool(input),
            "Une ConverteurException devrait être levée pour une chaîne vide");
        
        assertNotNull(exception.getMessage(), "Le message d'exception ne devrait pas être null");
    }

    @Test
    @DisplayName("Exception pour chaîne null")
    void testParseBoolNull() {
        // Given
        String input = null;
        
        // When & Then
        ConverteurException exception = assertThrows(ConverteurException.class, 
            () -> converteur.parseBool(input),
            "Une ConverteurException devrait être levée pour null");
        
        assertNotNull(exception.getMessage(), "Le message d'exception ne devrait pas être null");
    }

    @ParameterizedTest
    @ValueSource(strings = {"yes", "no", "1", "0", "oui", "non", "vrai", "faux", "t", "f", "y", "n"})
    @DisplayName("Tests paramétrés pour les chaînes booléennes invalides")
    void testParseBoolInvalidStrings(String input) {
        // When & Then
        assertThrows(ConverteurException.class, 
            () -> converteur.parseBool(input),
            String.format("Une ConverteurException devrait être levée pour '%s'", input));
    }

    @Test
    @DisplayName("Test de cohérence des conversions")
    void testConversionConsistency() throws ConverteurException {
        // Test que les conversions sont cohérentes
        assertTrue(converteur.parseBool("true"), "true devrait être converti en true");
        assertFalse(converteur.parseBool("false"), "false devrait être converti en false");
        assertEquals(42, converteur.parseInt("42"), "42 devrait être converti en 42");
    }
}
