// Autora: Paola de León
// Curso: Programación Orientada a Objetos (POO)
// Fecha de creación: 15 de Octubre 2020
// Clase abstracta de acompanantes.

abstract class Partner extends Fighter {
    
    Fighter Owner;

    public Partner ( String name, Fighter owner ) {
        super(name, 40, 10, false, true);
        this.Owner = owner;
    }

    // Métodos que serán overrideados
    abstract void Ability(  );
    abstract void SpecialAbility( Fighter AlQueAtacan );

}
