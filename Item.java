// Autora: Paola de León
// Curso: Programación Orientada a Objetos (POO)
// Fecha de creación: 15 de Octubre 2020
// Clase que simulará los items de cada jugador

public class Item {

    /**
     * Método para recuperar el 100% de vida.
     */
    public void Recover( Fighter a ) {
        int InitialLife = a.getLifePtsInitial();
        a.setLifePtsInitial(InitialLife);
    }

    /**
     * Método que simula una granada. Equivalente a 3 golpes.
     * @param a Enemigo que se atacará.
     * @param pwr Puntos de ataque de jugador.
     */
    public void Grenade( Fighter a, int pwr ) {
        int atack = pwr*3;
        int Life = a.getLifePts();
        a.setLifePts(Life-atack);
    }
    /**
     * Método para hacer un hechizo. El enemigo pierde 1 turno
     * @param turn El turno del jugador.
     * @return boolean Nuevo booleano que va a hacer que el enemigo pierda su turno. Recordate de asignarselo al boolean general.
     */
    public boolean Spell( boolean turn ) {
        turn =! turn;
        return turn;
    }
    


}
