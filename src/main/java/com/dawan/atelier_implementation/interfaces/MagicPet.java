package com.dawan.atelier_implementation.interfaces;

import com.dawan.atelier_implementation.interfaces.resource.Chat;
import com.dawan.atelier_implementation.interfaces.resource.Chien;

public interface MagicPet {
    /**
     * Transforme un chien en chat
     * @param chien
     * @return
     */
    Chat becomeCat(Chien chien);

    /**
     * Transforme un chat en chien
     * @param chat
     * @return
     */
    Chien becomeDog(Chat chat);
}
