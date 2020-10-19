// Autora: Paola de León
// Curso: Programación Orientada a Objetos (POO)
// Fecha de creación: 15 de Octubre 2020
// Clase que simulará al enemigo líder.

public class LeaderEnemy extends Enemy {

    String Title;
    boolean Absorbed;
    
    public LeaderEnemy (boolean recover, boolean avoid, boolean spell) {
        super( recover, avoid, spell );
        setName("Maleante Master");
        Title = "El mas malo de todos";
        setAtackPwr(10);
        setLifePts(80);
        setLifePtsInitial(80);
    }

    /**
     * Método toString del Maleante Master
     */
    public String toString( ) {
        String msj = "";
        msj += "\nJUGADOR: " + Name + "..." + Title +"\n";
        msj += "Vida: " + LifePts + " pts\n";
        msj += "Poder de ataque: " + AtackPwr + " pts\n";
        msj += "Cantidad de items: " + CantItems;

        return msj;
    } 

    /**
     * Método para absorber a un enemigo o a un minion
     */
    public void Absorb( Fighter minionOenemigo ) {
        Fighter tragao = minionOenemigo;
        int LifeTragado = tragao.getLifePts();
        setLifePts(this.LifePts+LifeTragado);
    }

}
