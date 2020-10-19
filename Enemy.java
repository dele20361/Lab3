// Autora: Paola de León
// Curso: Programación Orientada a Objetos (POO)
// Fecha de creación: 15 de Octubre 2020
// Clase que simulará a los enemigos en el juego

import java.util.ArrayList;

public class Enemy extends Fighter {

    public Enemy ( boolean Recover, boolean avoid, boolean spell) {
        super( "Maleante", 50 , 5, false, false);
        this.Recover = Recover;
        this.Avoid = avoid;
        this.Spell = spell;
        this.CantItems = 1;
    }

    /**
     * Método para sanar
     * @return boolan true si se aumentó la vida; false si no aumentó.
     */
    public boolean Recover() {
        boolean Changed = false;
        if (LifePts != LifePtsInitial) {
            this.LifePts = LifePtsInitial;
            RegisterAttack(1);
        }

        return Changed;
    }

    /** 
     * Método para evitar un ataque
     * 
     */
    public boolean Avoid( Fighter a ) {
        ArrayList<Integer> list = a.getRegistro();
        int LastChange = list.get(list.size()-1 );
        int Life = 0;
        int Attacked = 0;
        int NewLife = 0;
        boolean recovered = false;
        switch (LastChange) {
            case 0:
                //Atack
                Life = this.LifePts;
                Attacked = a.getAtackPwr();
                NewLife = Life+Attacked;
                setLifePts(NewLife);
                recovered = true;
                break;
            case 1:
                //Recover
                break;
            case 2:
                //Grenade
                Life = this.LifePts;
                Attacked = (a.getAtackPwr()*3);
                NewLife = Life+Attacked;
                setLifePts(NewLife);
                recovered = true;
                break;
            case 3:
                //Spell
                //Aquí recupera toda la vida en vez de recuperar su turno.
                setLifePts(LifePtsInitial);
                recovered = true;
                break;

            default:
                break;

            }
            RegisterAttack(2);
        
            return recovered;
    }

    /**
     * Método para usar item Grenade
     * @param a Item
     * @param e AlQueAtacan
     */
    public boolean Grenade( Fighter e ) {
        boolean Done = false;
        if ( this.Grenade == true ) {
            int atack = this.AtackPwr*3;
            int Life = e.getLifePts();
            e.setLifePts(Life-atack);
            RegisterAttack(2);
            this.Grenade = false;
            setCantItems(CantItems-1);
            Done = true;
        }

        return Done;
    }

    /**
     * Método para hacer un hechizo. El judador pierde 1 turno
     * @param turn El turno del jugador.
     * @return boolean Nuevo booleano que va a hacer que el jugador pierda su turno. Recordate de asignarselo al boolean general.
     */
    public boolean Spell( boolean turn ) {
        turn =! turn;
        RegisterAttack(3);
        return turn;
    }

    /**
     * Método toString del jugador
     */
    public String toString( ) {
        String msj = "";
        msj += "\nJUGADOR: " + Name + "\n";
        msj += "Vida: " + LifePts + " pts\n";
        msj += "Poder de ataque: " + AtackPwr + " pts\n";
        msj += "Cantidad de items: " + CantItems;

        return msj;
    } 

}
