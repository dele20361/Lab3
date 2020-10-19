// Autora: Paola de León
// Curso: Programación Orientada a Objetos (POO)
// Fecha de creación: 15 de Octubre 2020
// Main del programa


public class Hunter extends Fighter {
    
    //Propiedades
    boolean PetOut = false;

    public Hunter ( String name ) {
        super( name, 50, 5, true, false );
    }

    /**
     * Método para sacar al pet
     */
    public boolean PetOut ( ) {
        boolean IsOut = false;
        if ( PetOut == false ){
            PetOut = true;
            IsOut = true;
        }
        return IsOut;
    }

    /**
     * Método toString del jugador
     */
    public String toString( ) {
        String msj = "";
        msj += "\nJUGADOR: " + Name + "\n";
        msj += "Vida: " + LifePts + " pts\n";
        msj += "Poder de ataque: " + AtackPwr + " pts\n";
        msj += "Cantidad de items: " + CantItems + "\n";
        msj += "Tiene una mascota llamada: " + Pet.getName() + "\n";

        return msj;
    } 
}
