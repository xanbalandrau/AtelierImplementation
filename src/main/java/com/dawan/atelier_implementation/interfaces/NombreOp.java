package com.dawan.atelier_implementation.interfaces;

public interface NombreOp {
    /**
     * Vérifie si le nombre est pair
     * @param a
     * @return
     */
    boolean estPair(int a);

    /**
     * Verifie si le nombre est premier
     * Ne peut etre divisible que par 1 et sois-même
     * @param a
     * @return
     */
    boolean estPremier(int a);
}
