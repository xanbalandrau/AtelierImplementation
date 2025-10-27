package com.dawan.atelier_implementation.interfaces;

public interface Inverteur {
    /**
     * Renvoi l'opposé de b
     * @param b
     * @return
     */
    boolean negate(boolean b);

    /**
     * A et B doivent etres vrais sinon faux
     * @param a
     * @param b
     * @return
     */
    boolean areBothTrue(boolean a, boolean b);
}
