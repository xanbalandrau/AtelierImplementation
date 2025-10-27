package com.dawan.atelier_implementation.interfaces;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HorlogeTest {
    private Horloge horloge = createHorloge();

    private Horloge createHorloge() {
        // TODO: Importez votre class qui implémente Horloge et returnez la ici
        throw new UnsupportedOperationException("Students must implement createHorloge() method");
    }

    @Test
    @DisplayName("getTimeNow retourne une date/heure valide")
    void testGetTimeNowReturnsValidDateTime() {
        // When
        LocalDateTime now = horloge.getTimeNow();
        
        // Then
        assertNotNull(now, "getTimeNow() ne devrait pas retourner null");
        
        // Vérifier que la date/heure est raisonnable (pas dans le futur lointain ou le passé lointain)
        LocalDateTime currentTime = LocalDateTime.now();
        long secondsDifference = Math.abs(ChronoUnit.SECONDS.between(now, currentTime));
        
        assertTrue(secondsDifference <= 1, 
            "La différence entre le temps retourné et maintenant devrait être inférieure à 1 seconde");
    }

    @Test
    @DisplayName("getTimeNow retourne des valeurs différentes à des moments différents")
    void testGetTimeNowReturnsDifferentValues() throws InterruptedException {
        // Given
        LocalDateTime firstCall = horloge.getTimeNow();
        
        // When - Attendre un petit moment
        Thread.sleep(10); // 10 millisecondes
        LocalDateTime secondCall = horloge.getTimeNow();
        
        // Then
        assertNotEquals(firstCall, secondCall, 
            "Les deux appels à getTimeNow() devraient retourner des valeurs différentes");
        
        // Vérifier que le deuxième appel est postérieur au premier
        assertTrue(secondCall.isAfter(firstCall), 
            "Le deuxième appel devrait être postérieur au premier");
    }

    @RepeatedTest(5)
    @DisplayName("getTimeNow retourne des valeurs cohérentes sur plusieurs appels")
    void testGetTimeNowConsistency() {
        // When
        LocalDateTime now1 = horloge.getTimeNow();
        LocalDateTime now2 = horloge.getTimeNow();
        
        // Then
        assertNotNull(now1, "Premier appel ne devrait pas retourner null");
        assertNotNull(now2, "Deuxième appel ne devrait pas retourner null");
        
        // Les deux appels devraient être très proches dans le temps
        long secondsDifference = Math.abs(ChronoUnit.SECONDS.between(now1, now2));
        assertTrue(secondsDifference <= 1, 
            "Les deux appels devraient être séparés de moins d'une seconde");
    }

    @Test
    @DisplayName("quelJourDemain retourne une date valide")
    void testQuelJourDemainReturnsValidDate() {
        // When
        LocalDate tomorrow = horloge.quelJourDemain();
        
        // Then
        assertNotNull(tomorrow, "quelJourDemain() ne devrait pas retourner null");
        
        // Vérifier que c'est bien demain
        LocalDate expectedTomorrow = LocalDate.now().plusDays(1);
        assertEquals(expectedTomorrow, tomorrow, 
            "quelJourDemain() devrait retourner la date de demain");
    }

    @Test
    @DisplayName("quelJourDemain retourne toujours la même valeur pour le même jour")
    void testQuelJourDemainConsistency() {
        // When
        LocalDate tomorrow1 = horloge.quelJourDemain();
        LocalDate tomorrow2 = horloge.quelJourDemain();
        
        // Then
        assertEquals(tomorrow1, tomorrow2, 
            "Deux appels à quelJourDemain() le même jour devraient retourner la même date");
    }

    @Test
    @DisplayName("quelJourDemain retourne une date dans le futur")
    void testQuelJourDemainIsInFuture() {
        // When
        LocalDate tomorrow = horloge.quelJourDemain();
        LocalDate today = LocalDate.now();
        
        // Then
        assertTrue(tomorrow.isAfter(today), 
            "La date retournée par quelJourDemain() devrait être dans le futur");
        
        // Vérifier que c'est exactement demain
        assertEquals(1, ChronoUnit.DAYS.between(today, tomorrow), 
            "La différence entre aujourd'hui et demain devrait être exactement 1 jour");
    }

    @Test
    @DisplayName("Test de cohérence entre getTimeNow et quelJourDemain")
    void testConsistencyBetweenMethods() {
        // When
        LocalDateTime now = horloge.getTimeNow();
        LocalDate tomorrow = horloge.quelJourDemain();
        
        // Then
        assertNotNull(now, "getTimeNow() ne devrait pas retourner null");
        assertNotNull(tomorrow, "quelJourDemain() ne devrait pas retourner null");
        
        // Vérifier que demain est bien le jour suivant la date/heure actuelle
        LocalDate nowDate = now.toLocalDate();
        LocalDate expectedTomorrow = nowDate.plusDays(1);
        
        assertEquals(expectedTomorrow, tomorrow, 
            "quelJourDemain() devrait retourner le jour suivant la date de getTimeNow()");
    }

    @Test
    @DisplayName("Test avec différents moments de la journée")
    void testDifferentTimesOfDay() {
        // When
        LocalDateTime morningTime = horloge.getTimeNow();
        LocalDate tomorrow = horloge.quelJourDemain();
        
        // Then
        assertNotNull(morningTime, "getTimeNow() ne devrait pas retourner null");
        assertNotNull(tomorrow, "quelJourDemain() ne devrait pas retourner null");
        
        // Vérifier que la date de demain est cohérente
        LocalDate expectedTomorrow = LocalDate.now().plusDays(1);
        assertEquals(expectedTomorrow, tomorrow, 
            "La date de demain devrait être cohérente");
    }

    @Test
    @DisplayName("Test de performance - les méthodes ne devraient pas être trop lentes")
    void testPerformance() {
        // Test getTimeNow performance
        long startTime = System.currentTimeMillis();
        LocalDateTime now = horloge.getTimeNow();
        long endTime = System.currentTimeMillis();
        
        assertNotNull(now, "getTimeNow() ne devrait pas retourner null");
        assertTrue(endTime - startTime < 1000, 
            "getTimeNow() devrait s'exécuter en moins d'une seconde");
        
        // Test quelJourDemain performance
        startTime = System.currentTimeMillis();
        LocalDate tomorrow = horloge.quelJourDemain();
        endTime = System.currentTimeMillis();
        
        assertNotNull(tomorrow, "quelJourDemain() ne devrait pas retourner null");
        assertTrue(endTime - startTime < 1000, 
            "quelJourDemain() devrait s'exécuter en moins d'une seconde");
    }

    @Test
    @DisplayName("Test de robustesse - les méthodes ne devraient pas lever d'exception")
    void testRobustness() {
        // When & Then
        assertDoesNotThrow(() -> {
            LocalDateTime now = horloge.getTimeNow();
            LocalDate tomorrow = horloge.quelJourDemain();
            
            assertNotNull(now, "getTimeNow() ne devrait pas retourner null");
            assertNotNull(tomorrow, "quelJourDemain() ne devrait pas retourner null");
        }, "Les méthodes ne devraient pas lever d'exception");
    }

    @Test
    @DisplayName("Test de format de date - vérifier que les dates sont valides")
    void testDateValidity() {
        // When
        LocalDateTime now = horloge.getTimeNow();
        LocalDate tomorrow = horloge.quelJourDemain();
        
        // Then
        // Vérifier que les dates sont dans des plages raisonnables
        LocalDate minDate = LocalDate.of(2020, 1, 1);
        LocalDate maxDate = LocalDate.of(2030, 12, 31);
        
        assertTrue(now.toLocalDate().isAfter(minDate) && now.toLocalDate().isBefore(maxDate),
            "La date actuelle devrait être dans une plage raisonnable");
        
        assertTrue(tomorrow.isAfter(minDate) && tomorrow.isBefore(maxDate),
            "La date de demain devrait être dans une plage raisonnable");
    }
}
