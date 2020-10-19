// Autora: Paola de León
// Curso: Programación Orientada a Objetos (POO)
// Fecha de creación: 15 de Octubre 2020
// Clase que simulará una mascota

public class Pet extends Partner{
    
    public Pet ( Fighter owner ){
        super("Compa" , owner);
    }

    // Método en el que se otorgarán 20 puntos al dueno
    public void Ability() {
        int life = Owner.getLifePts();
        Owner.setLifePts(life+20);
    }

    /**
     * Método en el que se otorgarán 20 puntos al dueno 
     * */ 
    public void SpecialAbility( Fighter AlQueAtacan ) {
        int life = Owner.getLifePts();
        Owner.setLifePts(life-30);
    }

}
