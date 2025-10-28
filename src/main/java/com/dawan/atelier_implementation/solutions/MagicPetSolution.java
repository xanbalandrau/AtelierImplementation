package com.dawan.atelier_implementation.solutions;

import com.dawan.atelier_implementation.interfaces.MagicPet;
import com.dawan.atelier_implementation.interfaces.resource.Chat;
import com.dawan.atelier_implementation.interfaces.resource.Chien;

public class MagicPetSolution implements MagicPet {
    @Override
    public Chat becomeCat(Chien chien) {
        return new Chat(chien.getPattes(), chien.getNom(), chien.getAge());
    }

    @Override
    public Chien becomeDog(Chat chat) {
        return new Chien(chat.getPattes(), chat.getNom(), chat.getAge());
    }
}
