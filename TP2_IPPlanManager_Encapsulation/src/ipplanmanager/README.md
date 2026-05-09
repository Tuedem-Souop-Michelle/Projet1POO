# TP2 - Encapsulation

## Notions étudiées

- private
- getters
- setters
- validations
- this

## Tests réalisés

- Test d’une adresse IP vide : remplacement automatique par `0.0.0.0`
- Test d’une adresse IP valide : affichage normal de l’adresse
- Test d’un masque CIDR invalide (`45`) : remplacement automatique par `24`
- Test d’un équipement sans nom : attribution de la valeur `"equipement inconnu"`
- Test d’un équipement sans type : attribution de la valeur `"Type inconnu"`
- Test d’une interface sans adresse IP : gestion correcte de la valeur `null`

---

## Difficultés rencontrées

- Compréhension du principe d’encapsulation
- Passage des attributs publics aux attributs privés
- Création des getters et setters
- Mise en place des validations dans les setters
- Gestion des objets contenant d’autres objets
- Correction des problèmes d’affichage des caractères accentués

## Réponses aux questions

### 1. Pourquoi utilise-t-on `private` dans les classes ?

On utilise `private` pour protéger les attributs d’une classe et empêcher leur modification directe depuis l’extérieur.

---

### 2. Quelle différence existe entre un attribut `public` et un attribut `privé` ?

Un attribut public est accessible directement depuis n’importe quelle classe.  
Un attribut privé est protégé et accessible uniquement via des méthodes comme les getters et setters.

### 3. Pourquoi utilise-t-on des getters et setters ?

Les getters permettent de lire les valeurs des attributs privés et les setters permettent de les modifier avec contrôle et validation.

---

### 4. Pourquoi les validations sont-elles importantes dans un logiciel réseau ?

Les validations permettent d’éviter les données incorrectes comme une adresse IP vide ou un masque CIDR invalide afin de garantir la fiabilité du réseau.

### 5. Quel est le rôle du mot-clé `this` ?

Le mot-clé `this` permet de faire référence à l’attribut de la classe courante et de le différencier des paramètres des méthodes ou du constructeur.

### 6. Pourquoi le constructeur appelle-t-il les setters ?

Le constructeur appelle les setters pour appliquer les validations dès la création de l’objet.

### 7. Pourquoi la validation du masque CIDR est-elle importante ?

Parce qu’un masque CIDR doit être compris entre `0` et `32`. Une valeur invalide peut provoquer des erreurs dans la configuration réseau.

### 8. Pourquoi l’encapsulation améliore-t-elle la sécurité logicielle ?

L’encapsulation protège les données sensibles, contrôle leur accès et évite les modifications non autorisées.


