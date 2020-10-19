// Autora: Paola de León
// Curso: Programación Orientada a Objetos (POO)
// Fecha de creación: 15 de Octubre 2020
// Clase que simulará al jugador (bueno)

public class Player extends Fighter {
    
    // Constructor de Guerrero
    public Player( String Name, int uno ) {
        super( Name, 100, 10, true, false );
        uno = 1;
        this.CantItems = uno;
    }

    // Constructor de Explorador
    public Player( String name ) {
        super( name, 60, 5, true, false );
        this.CantItems = 2;
    }

    /**
     * Método para seleccionar un item
     * @param num Número que indicará que item desea el usuario tener (Recover 1, Grenade 2, Spell 3)
     */
    public void SelectItem ( int num ) {
        switch ( num ) {
            case 1:
                this.Recover = true;
                break;
            case 2:
                this.Grenade = true;
                break;
            case 3:
                this.Spell = true;
                break;
            default:
                break;
        }
    }

    /**
     * Método para usar item Recover.
     * @param a Item.
     * @param  ply Jugador que se llama al método.
     * @return boolean Indica si se pudo o no.
     */
    public boolean Recover( Item a, Fighter ply ) {
        boolean recovered = false;
        if ( this.Recover == true && LifePts!=LifePtsInitial ) {
            a.Recover( ply );
            RegisterAttack(1);
            this.Recover = false;
            setCantItems(CantItems-1);
            recovered = true;
        }

        return recovered;
    }

    /**
     * Método para usar item Grenade
     * @param a Item
     * @param e AlQueAtacan
     */
    public boolean Grenade( Item a, Fighter e ) {
        boolean Done = false;
        if ( this.Grenade == true ) {
            a.Grenade( e, this.AtackPwr );
            RegisterAttack(2);
            this.Grenade = false;
            setCantItems(CantItems-1);
            Done = true;
        }

        return Done;
    }

    /**
     * Método para usar item de hechizar
     * @param a Items
     * @param turn boolean que maneja los turnos
     * @return
     */
    public boolean Spell( Item a, boolean turn ) {
        boolean spelled = false;
        if ( this.Spell == true ) {
            a. Spell(turn);
            RegisterAttack(2);
            this.Spell = false;
            setCantItems(CantItems-1);
            spelled = true;
        }

        return spelled;
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

        return msj;
    } 

}
