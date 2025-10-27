package com.dawan.atelier_implementation.interfaces;

import com.dawan.atelier_implementation.interfaces.resource.Sliced;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringOpTest {
    private StringOp stringOp = createStringOp();

    private StringOp createStringOp() {
        // TODO: Importez votre class qui implémente StringOp et returnez la ici
        throw new UnsupportedOperationException("Students must implement createStringOp() method");
    }

    // Tests for slice method

    @Test
    @DisplayName("Découpage d'une chaîne au milieu")
    void testSliceMiddle() {
        // Given
        String text = "Hello World";
        int index = 5;
        
        // When
        Sliced result = stringOp.slice(text, index);
        
        // Then
        assertNotNull(result, "slice() ne devrait pas retourner null");
        assertEquals("Hello", result.moitie1(), "La première moitié devrait être 'Hello'");
        assertEquals(" World", result.moitie2(), "La deuxième moitié devrait être ' World'");
    }

    @Test
    @DisplayName("Découpage au début de la chaîne")
    void testSliceAtBeginning() {
        // Given
        String text = "Hello";
        int index = 0;
        
        // When
        Sliced result = stringOp.slice(text, index);
        
        // Then
        assertNotNull(result, "slice() ne devrait pas retourner null");
        assertEquals("", result.moitie1(), "La première moitié devrait être vide");
        assertEquals("Hello", result.moitie2(), "La deuxième moitié devrait être 'Hello'");
    }

    @Test
    @DisplayName("Découpage à la fin de la chaîne")
    void testSliceAtEnd() {
        // Given
        String text = "Hello";
        int index = 5;
        
        // When
        Sliced result = stringOp.slice(text, index);
        
        // Then
        assertNotNull(result, "slice() ne devrait pas retourner null");
        assertEquals("Hello", result.moitie1(), "La première moitié devrait être 'Hello'");
        assertEquals("", result.moitie2(), "La deuxième moitié devrait être vide");
    }

    @Test
    @DisplayName("Découpage d'une chaîne vide")
    void testSliceEmptyString() {
        // Given
        String text = "";
        int index = 0;
        
        // When
        Sliced result = stringOp.slice(text, index);
        
        // Then
        assertNotNull(result, "slice() ne devrait pas retourner null");
        assertEquals("", result.moitie1(), "La première moitié devrait être vide");
        assertEquals("", result.moitie2(), "La deuxième moitié devrait être vide");
    }

    @Test
    @DisplayName("Découpage d'une chaîne d'un seul caractère")
    void testSliceSingleCharacter() {
        // Given
        String text = "A";
        int index = 0;
        
        // When
        Sliced result = stringOp.slice(text, index);
        
        // Then
        assertNotNull(result, "slice() ne devrait pas retourner null");
        assertEquals("", result.moitie1(), "La première moitié devrait être vide");
        assertEquals("A", result.moitie2(), "La deuxième moitié devrait être 'A'");
    }

    @Test
    @DisplayName("Découpage d'une chaîne d'un seul caractère à la fin")
    void testSliceSingleCharacterAtEnd() {
        // Given
        String text = "A";
        int index = 1;
        
        // When
        Sliced result = stringOp.slice(text, index);
        
        // Then
        assertNotNull(result, "slice() ne devrait pas retourner null");
        assertEquals("A", result.moitie1(), "La première moitié devrait être 'A'");
        assertEquals("", result.moitie2(), "La deuxième moitié devrait être vide");
    }

    @ParameterizedTest
    @CsvSource({
        "'Hello', 0, '', 'Hello'",
        "'Hello', 1, 'H', 'ello'",
        "'Hello', 2, 'He', 'llo'",
        "'Hello', 3, 'Hel', 'lo'",
        "'Hello', 4, 'Hell', 'o'",
        "'Hello', 5, 'Hello', ''",
        "'Test', 2, 'Te', 'st'",
        "'Java', 2, 'Ja', 'va'",
        "'Programming', 4, 'Prog', 'ramming'"
    })
    @DisplayName("Tests paramétrés pour slice")
    void testSliceParameterized(String text, int index, String expectedFirst, String expectedSecond) {
        // When
        Sliced result = stringOp.slice(text, index);
        
        // Then
        assertNotNull(result, "slice() ne devrait pas retourner null");
        assertEquals(expectedFirst, result.moitie1(), 
            String.format("La première moitié de '%s' à l'index %d devrait être '%s'", text, index, expectedFirst));
        assertEquals(expectedSecond, result.moitie2(), 
            String.format("La deuxième moitié de '%s' à l'index %d devrait être '%s'", text, index, expectedSecond));
    }

    // Tests for combiner method

    @Test
    @DisplayName("Combinaison de deux chaînes")
    void testCombinerTwoStrings() {
        // Given
        Sliced sliced = new Sliced("Hello", " World");
        
        // When
        String result = stringOp.combiner(sliced);
        
        // Then
        assertNotNull(result, "combiner() ne devrait pas retourner null");
        assertEquals("Hello World", result, "La combinaison devrait être 'Hello World'");
    }

    @Test
    @DisplayName("Combinaison avec première moitié vide")
    void testCombinerWithEmptyFirst() {
        // Given
        Sliced sliced = new Sliced("", "Hello");
        
        // When
        String result = stringOp.combiner(sliced);
        
        // Then
        assertNotNull(result, "combiner() ne devrait pas retourner null");
        assertEquals("Hello", result, "La combinaison devrait être 'Hello'");
    }

    @Test
    @DisplayName("Combinaison avec deuxième moitié vide")
    void testCombinerWithEmptySecond() {
        // Given
        Sliced sliced = new Sliced("Hello", "");
        
        // When
        String result = stringOp.combiner(sliced);
        
        // Then
        assertNotNull(result, "combiner() ne devrait pas retourner null");
        assertEquals("Hello", result, "La combinaison devrait être 'Hello'");
    }

    @Test
    @DisplayName("Combinaison de deux chaînes vides")
    void testCombinerWithBothEmpty() {
        // Given
        Sliced sliced = new Sliced("", "");
        
        // When
        String result = stringOp.combiner(sliced);
        
        // Then
        assertNotNull(result, "combiner() ne devrait pas retourner null");
        assertEquals("", result, "La combinaison devrait être vide");
    }

    @Test
    @DisplayName("Combinaison avec des caractères spéciaux")
    void testCombinerWithSpecialCharacters() {
        // Given
        Sliced sliced = new Sliced("Hello@", "#World!");
        
        // When
        String result = stringOp.combiner(sliced);
        
        // Then
        assertNotNull(result, "combiner() ne devrait pas retourner null");
        assertEquals("Hello@#World!", result, "La combinaison devrait être 'Hello@#World!'");
    }

    @Test
    @DisplayName("Combinaison avec des espaces")
    void testCombinerWithSpaces() {
        // Given
        Sliced sliced = new Sliced("  Hello  ", "  World  ");
        
        // When
        String result = stringOp.combiner(sliced);
        
        // Then
        assertNotNull(result, "combiner() ne devrait pas retourner null");
        assertEquals("  Hello    World  ", result, "La combinaison devrait préserver les espaces");
    }

    @ParameterizedTest
    @CsvSource({
        "'Hello', 'World', 'HelloWorld'",
        "'', 'World', 'World'",
        "'Hello', '', 'Hello'",
        "'', '', ''",
        "'A', 'B', 'AB'",
        "'Test', '123', 'Test123'",
        "'Java', 'Programming', 'JavaProgramming'"
    })
    @DisplayName("Tests paramétrés pour combiner")
    void testCombinerParameterized(String first, String second, String expected) {
        // Given
        Sliced sliced = new Sliced(first, second);
        
        // When
        String result = stringOp.combiner(sliced);
        
        // Then
        assertNotNull(result, "combiner() ne devrait pas retourner null");
        assertEquals(expected, result, 
            String.format("La combinaison de '%s' et '%s' devrait être '%s'", first, second, expected));
    }

    // Tests combinés (slice + combiner)

    @Test
    @DisplayName("Test de cohérence: slice puis combiner")
    void testSliceThenCombiner() {
        // Given
        String originalText = "Hello World";
        int index = 5;
        
        // When
        Sliced sliced = stringOp.slice(originalText, index);
        String combined = stringOp.combiner(sliced);
        
        // Then
        assertEquals(originalText, combined, 
            "La combinaison du résultat de slice devrait redonner le texte original");
    }

    @Test
    @DisplayName("Test de cohérence avec différents index")
    void testSliceCombinerConsistency() {
        String[] testStrings = {"Hello", "World", "Java", "Programming", "Test", ""};
        
        for (String text : testStrings) {
            for (int i = 0; i <= text.length(); i++) {
                Sliced sliced = stringOp.slice(text, i);
                String combined = stringOp.combiner(sliced);
                assertEquals(text, combined, 
                    String.format("Slice puis combiner devrait redonner '%s' pour l'index %d", text, i));
            }
        }
    }

    @Test
    @DisplayName("Test de cohérence bidirectionnelle")
    void testBidirectionalConsistency() {
        // Given
        String originalText = "Hello World";
        
        // When - slice puis combiner
        Sliced sliced = stringOp.slice(originalText, 5);
        String combined = stringOp.combiner(sliced);
        
        // Then
        assertEquals(originalText, combined, 
            "Slice puis combiner devrait redonner le texte original");
        
        // When - combiner puis slice (si on peut reconstruire le Sliced)
        Sliced reconstructed = new Sliced(sliced.moitie1(), sliced.moitie2());
        String recombined = stringOp.combiner(reconstructed);
        
        // Then
        assertEquals(originalText, recombined, 
            "La reconstruction devrait donner le même résultat");
    }

    // Tests de robustesse

    @Test
    @DisplayName("Test avec des chaînes longues")
    void testWithLongStrings() {
        // Given
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append("A");
        }
        String longString = sb.toString();
        int index = 500;
        
        // When
        Sliced sliced = stringOp.slice(longString, index);
        String combined = stringOp.combiner(sliced);
        
        // Then
        assertNotNull(sliced, "slice() ne devrait pas retourner null");
        assertNotNull(combined, "combiner() ne devrait pas retourner null");
        assertEquals(longString, combined, 
            "La combinaison devrait redonner la chaîne longue originale");
    }

    @Test
    @DisplayName("Test avec des caractères Unicode")
    void testWithUnicodeCharacters() {
        // Given
        String unicodeText = "Hello 世界 🌍";
        int index = 6;
        
        // When
        Sliced sliced = stringOp.slice(unicodeText, index);
        String combined = stringOp.combiner(sliced);
        
        // Then
        assertNotNull(sliced, "slice() ne devrait pas retourner null");
        assertNotNull(combined, "combiner() ne devrait pas retourner null");
        assertEquals(unicodeText, combined, 
            "La combinaison devrait redonner le texte Unicode original");
    }

    @Test
    @DisplayName("Test de performance")
    void testPerformance() {
        // Given
        String text = "Hello World";
        Sliced sliced = new Sliced("Hello", " World");
        
        // When
        long startTime = System.currentTimeMillis();
        
        for (int i = 0; i < 1000; i++) {
            stringOp.slice(text, 5);
            stringOp.combiner(sliced);
        }
        
        long endTime = System.currentTimeMillis();
        
        // Then
        assertTrue(endTime - startTime < 1000, 
            "1000 opérations devraient s'exécuter en moins d'une seconde");
    }

    @Test
    @DisplayName("Test de robustesse - les méthodes ne devraient pas lever d'exception")
    void testRobustness() {
        // Given
        String text = "Hello World";
        Sliced sliced = new Sliced("Hello", " World");
        
        // When & Then
        assertDoesNotThrow(() -> {
            stringOp.slice(text, 0);
            stringOp.slice(text, text.length());
            stringOp.combiner(sliced);
        }, "Les méthodes ne devraient pas lever d'exception");
    }

    @Test
    @DisplayName("Test avec des chaînes contenant des retours à la ligne")
    void testWithNewlines() {
        // Given
        String textWithNewlines = "Hello\nWorld\nTest";
        int index = 6; // Après "Hello\n"
        
        // When
        Sliced sliced = stringOp.slice(textWithNewlines, index);
        String combined = stringOp.combiner(sliced);
        
        // Then
        assertNotNull(sliced, "slice() ne devrait pas retourner null");
        assertNotNull(combined, "combiner() ne devrait pas retourner null");
        assertEquals(textWithNewlines, combined, 
            "La combinaison devrait redonner le texte avec retours à la ligne original");
    }
}
