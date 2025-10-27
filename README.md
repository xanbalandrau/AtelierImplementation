# Atelier Implementation - Test-Driven Development

Ce projet contient des interfaces Java que les vous devez implémenter en suivant une approche de développement piloté par les tests (TDD).

## Structure du Projet

```
src/
├── main/java/com/dawan/atelier_implementation/interfaces/
│   ├── CalcInter.java          # Opérations avancées (multiplication, division)
│   ├── CalcSimple.java         # Opérations simples (addition, soustraction)
│   ├── Converteur.java         # Conversion de chaînes (parseInt, parseBool)
│   ├── Horloge.java            # Gestion du temps (getTimeNow, quelJourDemain)
│   ├── inverteur.java          # Opérations booléennes (negate, areBothTrue)
│   ├── MagicPet.java           # Transformation d'animaux (becomeCat, becomeDog)
│   ├── NombreOp.java           # Opérations sur les nombres (estPair, estPremier)
│   ├── StringOp.java           # Opérations sur les chaînes (slice, combiner)
│   └── resource/               # Classes utilitaires
│       ├── Animal.java
│       ├── Chat.java
│       ├── Chien.java
│       ├── ConverteurException.java
│       └── Sliced.java
└── test/java/com/dawan/atelier_implementation/interfaces/
    ├── CalcInterTest.java
    ├── CalcSimpleTest.java
    ├── ConverteurTest.java
    ├── HorlogeTest.java
    ├── InverteurTest.java
    ├── MagicPetTest.java
    ├── NombreOpTest.java
    └── StringOpTest.java
```

## Instructions

### 1. Approche Test-Driven Development (TDD)

1. **Lisez les tests** pour comprendre ce que son interface doit faire
2. **Exécutez les tests** - ils vont échouer car l'interface n'est pas encore implémentée
3. **Implémentez la classe** qui satisfera les tests
4. **Réexécutez les tests** jusqu'à ce qu'ils passent tous
5. **Refactorisez** votre code si nécessaire

### 2. Exécution des Tests

```bash
# Exécuter tous les tests
mvn test

# Exécuter un test spécifique
mvn test -Dtest=CalcSimpleTest

# Exécuter avec plus de détails
mvn test -X
```

## Description des Interfaces

### CalcSimple
- `add(int a, int b)` : Addition de deux nombres
- `diff(int a, int b)` : Différence entre deux nombres

### CalcInter
- `mult(int a, int b)` : Multiplication de deux nombres
- `div(int a, int b)` : Division de deux nombres (division entière)

### Converteur
- `parseInt(String s)` : Conversion d'une chaîne en entier (lève `ConverteurException` si invalide)
- `parseBool(String s)` : Conversion d'une chaîne en booléen (lève `ConverteurException` si invalide)

### Horloge
- `getTimeNow()` : Retourne la date/heure actuelle
- `quelJourDemain()` : Retourne la date de demain

### inverteur
- `negate(boolean b)` : Retourne l'opposé d'un booléen
- `areBothTrue(boolean a, boolean b)` : Retourne true si les deux booléens sont true

### MagicPet
- `becomeCat(Chien chien)` : Transforme un chien en chat
- `becomeDog(Chat chat)` : Transforme un chat en chien

### NombreOp
- `estPair(int a)` : Vérifie si un nombre est pair
- `estPremier(int a)` : Vérifie si un nombre est premier

### StringOp
- `slice(String s, int index)` : Coupe une chaîne en deux au caractère à l'index donné
- `combiner(Sliced sliced)` : Combine les deux moitiés d'un objet Sliced

Bon courage ! 🚀
