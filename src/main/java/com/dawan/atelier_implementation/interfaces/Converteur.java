package com.dawan.atelier_implementation.interfaces;

import com.dawan.atelier_implementation.interfaces.resource.ConverteurException;

public interface Converteur {
    /**
     * Transforme un texte de chiffre en nombre entier
     * @param s
     * @return
     * @throws ConverteurException si le texte contien autre chose qu'un chiffre
     */
    int parseInt(String s) throws ConverteurException;

    /**
     * Transforme du texte en booleen
     * @param s
     * @return
     * @throws ConverteurException si le texte n'est pas conforme a la conversion
     */
    boolean parseBool(String s) throws ConverteurException;
}
