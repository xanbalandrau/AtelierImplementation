package com.dawan.atelier_implementation.interfaces;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Horloge {
    /**
     * Renvoi maintenant
     * @return
     */
    LocalDateTime getTimeNow();

    /**
     * Renvoi la date de demain
     * @return
     */
    LocalDate quelJourDemain();
}
