package com.dawan.atelier_implementation.interfaces;

import com.dawan.atelier_implementation.interfaces.resource.Sliced;

public interface StringOp {
    /**
     * Coupe un texte en deux au caractère à l'index demandé
     * @param s
     * @param index
     * @return
     */
    Sliced slice(String s, int index);

    /**
     * Combine deux textes ensemble
     * @param sliced
     * @return
     */
    String combiner(Sliced sliced);
}
