package com.dawan.atelier_implementation.interfaces;

import com.dawan.atelier_implementation.interfaces.resource.Chat;
import com.dawan.atelier_implementation.interfaces.resource.Chien;
import com.dawan.atelier_implementation.solutions.MagicPetSolution;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MagicPetTest {
    private MagicPet magicPet = createMagicPet();

    private MagicPet createMagicPet() {
        return new MagicPetSolution();
    }

    // Tests for becomeCat method

    @Test
    @DisplayName("Transformation d'un chien en chat")
    void testBecomeCat() {
        // Given
        Chien chien = new Chien(4, "Rex", 5);
        
        // When
        Chat chat = magicPet.becomeCat(chien);
        
        // Then
        assertNotNull(chat, "becomeCat() ne devrait pas retourner null");
        assertInstanceOf(Chat.class, chat, "Le résultat devrait être une instance de Chat");
        
        // Vérifier que les propriétés sont conservées
        assertEquals(chien.getPattes(), chat.getPattes(), 
            "Le nombre de pattes devrait être conservé");
        assertEquals(chien.getNom(), chat.getNom(), 
            "Le nom devrait être conservé");
        assertEquals(chien.getAge(), chat.getAge(), 
            "L'âge devrait être conservé");
    }

    @Test
    @DisplayName("Transformation d'un chien avec des valeurs spécifiques")
    void testBecomeCatWithSpecificValues() {
        // Given
        Chien chien = new Chien(3, "Patte", 7);
        
        // When
        Chat chat = magicPet.becomeCat(chien);
        
        // Then
        assertNotNull(chat, "becomeCat() ne devrait pas retourner null");
        assertEquals(3, chat.getPattes(), "Le nombre de pattes devrait être 3");
        assertEquals("Patte", chat.getNom(), "Le nom devrait être 'Patte'");
        assertEquals(7, chat.getAge(), "L'âge devrait être 7");
    }

    @Test
    @DisplayName("Transformation d'un chien avec des valeurs limites")
    void testBecomeCatWithEdgeValues() {
        // Given - chien avec 0 pattes
        Chien chienSansPattes = new Chien(0, "SansPattes", 1);
        
        // When
        Chat chat = magicPet.becomeCat(chienSansPattes);
        
        // Then
        assertNotNull(chat, "becomeCat() ne devrait pas retourner null");
        assertEquals(0, chat.getPattes(), "Le nombre de pattes devrait être 0");
        assertEquals("SansPattes", chat.getNom(), "Le nom devrait être conservé");
        assertEquals(1, chat.getAge(), "L'âge devrait être conservé");
    }

    @Test
    @DisplayName("Transformation d'un chien avec un nom vide")
    void testBecomeCatWithEmptyName() {
        // Given
        Chien chien = new Chien(4, "", 2);
        
        // When
        Chat chat = magicPet.becomeCat(chien);
        
        // Then
        assertNotNull(chat, "becomeCat() ne devrait pas retourner null");
        assertEquals("", chat.getNom(), "Le nom vide devrait être conservé");
    }

    @Test
    @DisplayName("Transformation d'un chien avec un âge de 0")
    void testBecomeCatWithZeroAge() {
        // Given
        Chien chien = new Chien(4, "Bébé", 0);
        
        // When
        Chat chat = magicPet.becomeCat(chien);
        
        // Then
        assertNotNull(chat, "becomeCat() ne devrait pas retourner null");
        assertEquals(0, chat.getAge(), "L'âge de 0 devrait être conservé");
    }

    // Tests for becomeDog method

    @Test
    @DisplayName("Transformation d'un chat en chien")
    void testBecomeDog() {
        // Given
        Chat chat = new Chat(4, "Mimi", 3);
        
        // When
        Chien chien = magicPet.becomeDog(chat);
        
        // Then
        assertNotNull(chien, "becomeDog() ne devrait pas retourner null");
        assertInstanceOf(Chien.class, chien, "Le résultat devrait être une instance de Chien");
        
        // Vérifier que les propriétés sont conservées
        assertEquals(chat.getPattes(), chien.getPattes(), 
            "Le nombre de pattes devrait être conservé");
        assertEquals(chat.getNom(), chien.getNom(), 
            "Le nom devrait être conservé");
        assertEquals(chat.getAge(), chien.getAge(), 
            "L'âge devrait être conservé");
    }

    @Test
    @DisplayName("Transformation d'un chat avec des valeurs spécifiques")
    void testBecomeDogWithSpecificValues() {
        // Given
        Chat chat = new Chat(3, "Tripode", 8);
        
        // When
        Chien chien = magicPet.becomeDog(chat);
        
        // Then
        assertNotNull(chien, "becomeDog() ne devrait pas retourner null");
        assertEquals(3, chien.getPattes(), "Le nombre de pattes devrait être 3");
        assertEquals("Tripode", chien.getNom(), "Le nom devrait être 'Tripode'");
        assertEquals(8, chien.getAge(), "L'âge devrait être 8");
    }

    @Test
    @DisplayName("Transformation d'un chat avec des valeurs limites")
    void testBecomeDogWithEdgeValues() {
        // Given - chat avec beaucoup de pattes
        Chat chat = new Chat(8, "Araignée", 1);
        
        // When
        Chien chien = magicPet.becomeDog(chat);
        
        // Then
        assertNotNull(chien, "becomeDog() ne devrait pas retourner null");
        assertEquals(8, chien.getPattes(), "Le nombre de pattes devrait être 8");
        assertEquals("Araignée", chien.getNom(), "Le nom devrait être conservé");
        assertEquals(1, chien.getAge(), "L'âge devrait être conservé");
    }

    @Test
    @DisplayName("Transformation d'un chat avec un nom null")
    void testBecomeDogWithNullName() {
        // Given
        Chat chat = new Chat(4, null, 2);
        
        // When
        Chien chien = magicPet.becomeDog(chat);
        
        // Then
        assertNotNull(chien, "becomeDog() ne devrait pas retourner null");
        assertNull(chien.getNom(), "Le nom null devrait être conservé");
    }

    // Tests de transformation bidirectionnelle

    @Test
    @DisplayName("Transformation bidirectionnelle chien -> chat -> chien")
    void testBidirectionalTransformationChienToChatToChien() {
        // Given
        Chien originalChien = new Chien(4, "Rex", 5);
        
        // When
        Chat chat = magicPet.becomeCat(originalChien);
        Chien transformedChien = magicPet.becomeDog(chat);
        
        // Then
        assertNotNull(transformedChien, "Le chien transformé ne devrait pas être null");
        assertEquals(originalChien.getPattes(), transformedChien.getPattes(), 
            "Le nombre de pattes devrait être conservé après transformation bidirectionnelle");
        assertEquals(originalChien.getNom(), transformedChien.getNom(), 
            "Le nom devrait être conservé après transformation bidirectionnelle");
        assertEquals(originalChien.getAge(), transformedChien.getAge(), 
            "L'âge devrait être conservé après transformation bidirectionnelle");
    }

    @Test
    @DisplayName("Transformation bidirectionnelle chat -> chien -> chat")
    void testBidirectionalTransformationChatToChienToChat() {
        // Given
        Chat originalChat = new Chat(4, "Mimi", 3);
        
        // When
        Chien chien = magicPet.becomeDog(originalChat);
        Chat transformedChat = magicPet.becomeCat(chien);
        
        // Then
        assertNotNull(transformedChat, "Le chat transformé ne devrait pas être null");
        assertEquals(originalChat.getPattes(), transformedChat.getPattes(), 
            "Le nombre de pattes devrait être conservé après transformation bidirectionnelle");
        assertEquals(originalChat.getNom(), transformedChat.getNom(), 
            "Le nom devrait être conservé après transformation bidirectionnelle");
        assertEquals(originalChat.getAge(), transformedChat.getAge(), 
            "L'âge devrait être conservé après transformation bidirectionnelle");
    }

    // Tests de robustesse

    @Test
    @DisplayName("Test avec des animaux identiques")
    void testWithIdenticalAnimals() {
        // Given
        Chien chien1 = new Chien(4, "Rex", 5);
        Chien chien2 = new Chien(4, "Rex", 5);
        
        // When
        Chat chat1 = magicPet.becomeCat(chien1);
        Chat chat2 = magicPet.becomeCat(chien2);
        
        // Then
        assertNotNull(chat1, "Premier chat ne devrait pas être null");
        assertNotNull(chat2, "Deuxième chat ne devrait pas être null");
        
        // Les propriétés devraient être identiques
        assertEquals(chat1.getPattes(), chat2.getPattes(), 
            "Les chats devraient avoir le même nombre de pattes");
        assertEquals(chat1.getNom(), chat2.getNom(), 
            "Les chats devraient avoir le même nom");
        assertEquals(chat1.getAge(), chat2.getAge(), 
            "Les chats devraient avoir le même âge");
    }

    @Test
    @DisplayName("Test de performance - les transformations devraient être rapides")
    void testPerformance() {
        // Given
        Chien chien = new Chien(4, "Rex", 5);
        Chat chat = new Chat(4, "Mimi", 3);
        
        // When
        long startTime = System.currentTimeMillis();
        
        for (int i = 0; i < 100; i++) {
            magicPet.becomeCat(chien);
            magicPet.becomeDog(chat);
        }
        
        long endTime = System.currentTimeMillis();
        
        // Then
        assertTrue(endTime - startTime < 1000, 
            "100 transformations devraient s'exécuter en moins d'une seconde");
    }

    @Test
    @DisplayName("Test de robustesse - les méthodes ne devraient pas lever d'exception")
    void testRobustness() {
        // Given
        Chien chien = new Chien(4, "Rex", 5);
        Chat chat = new Chat(4, "Mimi", 3);
        
        // When & Then
        assertDoesNotThrow(() -> {
            magicPet.becomeCat(chien);
            magicPet.becomeDog(chat);
        }, "Les méthodes ne devraient pas lever d'exception");
    }

    @Test
    @DisplayName("Test avec des valeurs extrêmes")
    void testWithExtremeValues() {
        // Given - animal avec beaucoup de pattes et un âge élevé
        Chien chien = new Chien(100, "CentPattes", 100);
        
        // When
        Chat chat = magicPet.becomeCat(chien);
        
        // Then
        assertNotNull(chat, "becomeCat() ne devrait pas retourner null");
        assertEquals(100, chat.getPattes(), "Le nombre de pattes devrait être 100");
        assertEquals("CentPattes", chat.getNom(), "Le nom devrait être conservé");
        assertEquals(100, chat.getAge(), "L'âge devrait être 100");
    }
}
