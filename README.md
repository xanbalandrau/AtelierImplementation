# Atelier Implementation - Test-Driven Development

Ce projet contient des interfaces Java que les étudiants doivent implémenter en suivant une approche de développement piloté par les tests (TDD).

## Structure du Projet

```
src/
├── main/java/com/dawan/atelier_implementation/interfaces/
│   ├── CalcInter.java          # Opérations avancées (multiplication, division)
│   ├── CalcSimple.java         # Opérations simples (addition, soustraction)
│   ├── Converteur.java         # Conversion de chaînes (parseInt, parseBool)
│   ├── Horloge.java           # Gestion du temps (getTimeNow, quelJourDemain)
│   ├── inverteur.java         # Opérations booléennes (negate, areBothTrue)
│   ├── MagicPet.java          # Transformation d'animaux (becomeCat, becomeDog)
│   ├── NombreOp.java          # Opérations sur les nombres (estPair, estPremier)
│   ├── StringOp.java          # Opérations sur les chaînes (slice, combiner)
│   └── resource/             # Classes utilitaires
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

## Instructions pour les Étudiants

### 1. Approche Test-Driven Development (TDD)

1. **Lisez les tests** pour comprendre ce que chaque interface doit faire
2. **Exécutez les tests** - ils vont échouer car les interfaces ne sont pas encore implémentées
3. **Implémentez les classes** qui satisfont les tests
4. **Réexécutez les tests** jusqu'à ce qu'ils passent tous
5. **Refactorisez** votre code si nécessaire

### 2. Comment Commencer

Pour chaque interface, vous devez :

1. **Créer une classe** qui implémente l'interface
2. **Modifier la méthode `createXXX()`** dans le fichier de test correspondant
3. **Implémenter toutes les méthodes** de l'interface
4. **Exécuter les tests** pour vérifier votre implémentation

### 3. Exemple de Démarrage

Pour l'interface `CalcSimple` :

```java
// 1. Créer une classe qui implémente CalcSimple
public class MaCalculatrice implements CalcSimple {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
    
    @Override
    public int diff(int a, int b) {
        return a - b;
    }
}

// 2. Modifier CalcSimpleTest.java
private CalcSimple createCalculator() {
    return new MaCalculatrice(); // Remplacer la ligne qui lance l'exception
}
```

### 4. Exécution des Tests

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

## Conseils pour les Étudiants

1. **Commencez simple** : Implémentez d'abord les cas de base, puis les cas complexes
2. **Lisez attentivement les tests** : Ils vous donnent des indices sur le comportement attendu
3. **Gérez les cas limites** : Nombres négatifs, chaînes vides, valeurs nulles, etc.
4. **Testez régulièrement** : Exécutez les tests après chaque modification
5. **Respectez les conventions** : Nommage, documentation, gestion d'erreurs

## Cas d'Erreurs à Gérer

- **ConverteurException** : Pour les conversions invalides
- **Valeurs nulles** : Certaines méthodes peuvent recevoir des paramètres null
- **Valeurs limites** : Integer.MAX_VALUE, Integer.MIN_VALUE
- **Cas spéciaux** : Chaînes vides, nombres négatifs, etc.

## Objectifs Pédagogiques

- Comprendre le développement piloté par les tests (TDD)
- Implémenter des interfaces Java
- Gérer les exceptions
- Travailler avec les types de données Java (primitifs, objets, collections)
- Comprendre les concepts de programmation orientée objet
- Développer des compétences en débogage et test

Bon travail ! 🚀
