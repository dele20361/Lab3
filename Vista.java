// Autora: Paola de León
// Curso: Programación Orientada a Objetos (POO)
// Fecha de creación: 15 de Octubre 2020
// Clase única con Scanner y Prints.

// System.out.println(x);

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Vista {

    Scanner scan = new Scanner( System.in );
    Random rand = new Random();
    boolean Heal, Grenade, Spell = false;

    public Vista(){}
    

    /**
     * Método que dará la bienvenida al juego.
     * @return name Nombre del jugador
     */
    public void WelcomeMsj ( ) {
    System.out.println( "\n\nBienvenido al juego PAO!\n" );
    }

    /**
     * Método que dará la bienvenida al juego.
     * @return name Nombre del jugador
     */
    public String Welcome ( ) {
        boolean ciclo = true;
        String name = "";
        while ( ciclo == true ) {
            System.out.println("\nPor favor ingrese su nombre: ");
            name = scan.nextLine();
            boolean IsTrue = ValideEntry( name );
            if ( IsTrue == true ) {
                ciclo = false;
                System.out.println( "Su nombre es: " + name );
            }
            else {}
        }

        return name;
    }

    /**
     * Método para seleccionar el tipo de jugador que desea ser
     * @return TypeOfPlayer 1=Guerrero; 2= Explorador; 3=Cazador.
     */
    public int FighterType ( ) {
        boolean ciclo = true;
        String tipo = "";
        String opcS;
        int opc = 0;
        int TypeOfPlayer = 0;
        boolean Valide = true;
        boolean Selected = false;
        while ( ciclo == true || opc != 4 && Selected == false || Valide == true ) {
            System.out.println("\nOPCIONES DE JUGADOR:"
            + "\n1) Guerrero (Bastante vida, bastante ataque, 1 item)"
            + "\n2) Explorador (Vida normal, ataque normal, 2 items)"
            + "\n3) Cazador (Menos vida, menos ataque, 1 item y una mascota ilimitada)"
            + "\nIngrese el número de opción: " );
            opcS = scan.nextLine();
            opc = ValideNum(opcS);
            if (opc == -1 ) {
            }
            else {
                Valide = false;
                if ( opc == 1 ) {
                    tipo += "Guerrero";
                    // TypeOfPlayer = 0;
                    boolean IsTrue = ValideEntry( tipo );
                    if ( IsTrue == true ) {
                        ciclo = false;
                        System.out.println( "TIPO DE JUGADOR: " + tipo );
                        Selected = true;
                    }
                    else { }
                }
                else if ( opc == 2 ) {
                    tipo += "Explorador";
                    boolean IsTrue = ValideEntry( tipo );
                    if ( IsTrue == true ) {
                        ciclo = false;
                        TypeOfPlayer = 1;
                        System.out.println( "TIPO DE JUGADOR: " + tipo );
                        Selected = true;
                    }
                    else { }
                }
                else if ( opc == 3 ) {
                    tipo += "Cazador";
                    boolean IsTrue = ValideEntry( tipo );
                    if ( IsTrue == true ) {
                        ciclo = false;
                        TypeOfPlayer = 2;
                        System.out.println( "TIPO DE JUGADOR: " + tipo );
                        Selected = true;
                    }
                    else { }
                }
                else {
                    System.out.println( "Error! Ingrese una opcion valida " );
                }
            }
        }

        return TypeOfPlayer;
    }

    /**
     * Método que indicará el item que desea usar.
     * @return int Número de opc elegida
     */
    public int ChooseItem ( ) {
        boolean ciclo = true;
        boolean Selected = false;
        boolean Valide = true;
        String opcS;
        int opc = 0;
        String dato = "";
        while ( ciclo == true || opc != 4 && Selected == false || Valide == true ) {
            System.out.println("\nOPCIONES ITEMS: "
            + "\n1) Sanar (Recuperar 100% de vida)"
            + "\n2) Granada (Ataque equivalente a 3 turnos)"
            + "\n3) Hechizo (Quitar 1 turno a oponente)"
            + "\nIngrese el numero de opcion: " );
            opcS = scan.nextLine();
            opc = ValideNum(opcS);
            if ( opc != -1 ) {
                Valide = false;
                if ( opc == 1 && Heal == false ) {
                    dato += "Sanar";
                    boolean IsTrue = ValideEntry( dato );
                    if ( IsTrue == true ) {
                        ciclo = false;
                        System.out.println( "ITEM ELEGIDO: " + dato );
                        Selected = true;
                        Heal = true;
                    }
                    else {}
                }
                else if ( opc == 2 && Grenade == false ) {
                    dato += "Granada";
                    boolean IsTrue = ValideEntry( dato );
                    if ( IsTrue == true ) {
                        ciclo = false;
                        System.out.println( "ITEM ELEGIDO: " + dato );
                        Selected = true;
                        Grenade = false;
                    }
                    else {}
                }
                else if ( opc == 3 ) {
                    dato += "Hechizo";
                    boolean IsTrue = ValideEntry( dato );
                    if ( IsTrue == true ) {
                        ciclo = false;
                        System.out.println( "ITEM ELEGIDO: " + dato );
                        Selected = true;
                        Spell = false;
                    }
                }
                else {
                    System.out.println("Error! Ingrese una opcion valida ");
                }
            }
        }

        return opc;
    }

    /**
     * Método que presentará el menú.
     * @return int Opción elegida.
     */
    public int Menu ( ) {
        int opc = 0;
        String opcS;
        boolean Valide = false;
        while ( Valide == false ) {
            System.out.println("\n\nMENU:" +
            "\n1) Continuar juego" +
            "\n2) Salir" +
            "\nIngrese el numero de opcion a elegir: ");
            opcS = scan.nextLine();
            opc = ValideNum(opcS);
            if ( opc != -1 ) {
                Valide = true;
            }
        }
        return opc;
    }

    /**
     * Método para comprobar info del usuario.
     * @return boolean Si el dato es correcto.
     */
    public boolean ValideEntry ( String dato ) {
        boolean IsTrue = false;
        System.out.println("\nDATO INGRESADO: " + dato );
        System.out.println( "¿Esta seguro del dato?"
        + "\nPresione enter si el dato ingresado es correcto; de lo contrario ingrese otro dato: " );
        String a = scan.nextLine();
        if ( a.equals("") ) {
            IsTrue = true;
        }
        else {}
        
        return IsTrue;
    }

    /**
     * Método toString de fighters
     * @param ply Jugador
     */
    public void toString( Fighter ply ) {
        System.out.println( ply.toString() );
    }

    /**
     * Método para mostrar mensaje.
     */
    public void InfoEnemies() {
        System.out.println("\n\nENEMIGOS:");
    }

    /**
     * Método para turnos de enemigos
     * @param list Lista de enemigos
     * @return int Número de jugador.
     */
    public int TurnEnemy(){
        boolean ciclo = true;
        String dato = "";
        String opcS;
        int opc = 0;
        boolean Valide = true;
        boolean Selected = false;
        while ( ciclo == true || opc != 4 && Selected == false || Valide == true ) {
            System.out.println("\nOPCIONES ITEMS PARA MALEANTE SUPERIOR: "
            + "\n1) Sanar (Recuperar 100% de vida solo 1 vez)"
            + "\n2) Evitar ataque anterior"
            + "\n3) Hechizo (Quitar 1 turno a oponente)"
            + "\nIngrese el numero de opcion: " );
            opcS = scan.nextLine();
            opc = ValideNum(opcS);
            if (opc == -1 ) {
            }
            else {
                Valide = false; 
                if ( opc == 1 ) {
                    dato += "Sanar";
                    boolean IsTrue = ValideEntry( dato );
                    if ( IsTrue == true ) {
                        ciclo = false;
                        System.out.println( "ITEM ELEGIDO: " + dato );
                        Selected = true;
                    }
                    else {}
                }
                else if ( opc == 2 ) {
                    dato += "Evitar ataque";
                    boolean IsTrue = ValideEntry( dato );
                    if ( IsTrue == true ) {
                        ciclo = false;
                        System.out.println( "ITEM ELEGIDO: " + dato );
                        Selected = true;
                    }
                    else {}
                }
                else if ( opc == 3 ) {
                    dato += "Hechizo";
                    boolean IsTrue = ValideEntry( dato );
                    if ( IsTrue == true ) {
                        ciclo = false;
                        System.out.println( "ITEM ELEGIDO: " + dato );
                        Selected = true;
                    }
                    else {}
                }
                else {
                    System.out.println("Error! Ingrese una opcion valida ");
                }
            }
        }

        return opc;
    }

    /**
     * Método para validar cualquier número ingresado.
     * @param Num String de un número.
     * @return Número convertido en int.
    */
    public int ValideNum ( String Num ) {

        int newNum = -1;
        try {
           newNum = Integer.parseInt( Num );
        }
        catch ( NumberFormatException e )
        {
           System.out.println("Error! Ingrese un numero por favor.");
        }
        
        return newNum;

    }

    /**
     * Método para saber de quien es el turno.
     * @param turnPlayer ¿turno del jugador 1?
     * @param ply Jugador
     * @param ListaEnemigos Lista de Enemigos
     * @param CantEnemies Cantidad de enemigos
     * @return ArrayList Al que le toca el turno está en posición 0; al que va a atacar va a esta en la posición 1.
     */
    public ArrayList<Fighter> TurnPlayer( boolean turnPlayer, Fighter ply, ArrayList<Fighter> ListaEnemigos, int CantEnemies ) {

        Fighter fighter = null;
        ArrayList<Fighter> turnos = new ArrayList<Fighter>();
        boolean EnemigosVivos = EnemiesAlive(ListaEnemigos);
        System.out.println("\n\nTURNO DE:");
        if ( ply.getLifePts()>0 && EnemigosVivos==true ) {
            if ( turnPlayer == true ) {
                System.out.println( ply.getName() + "\n");
                fighter = ply;
                turnos.add(fighter); //Posicion 0
                boolean listo = false;
                while ( listo == false ) {
                    int aleatorio = rand.nextInt(CantEnemies+1);
                    Fighter combatiente = ListaEnemigos.get(aleatorio);
                    if ( combatiente.getLifePts()>0 ) {
                        turnos.add(combatiente);
                        listo = true;
                    }
                }
                
            }
            else {
                boolean listo = false;
                while ( listo == false ) {
                    int aleatorio = rand.nextInt(CantEnemies+1);
                    Fighter combatiente = ListaEnemigos.get(aleatorio);
                    if ( combatiente.getLifePts()>0 ) {
                        System.out.println( combatiente.getName() + "\n");
                        fighter = combatiente;
                        turnos.add(fighter);
                        turnos.add(ply);
                        listo = true;
                    }
                }
            }
        }

        else if ( EnemigosVivos==false) {
            for (int i = 0; i < ListaEnemigos.size(); i++) {
                Fighter enemigo = ListaEnemigos.get(i);
                System.out.println( enemigo.Dead() + "\n");
            }
            System.out.println("\nVICTORIA!! Has ganado el juego PAO! Felicitaciones :) ");
        }
        else if ( ply.getLifePts()>=0 ) {
            System.out.println ( ply.Dead() );
            System.out.println ("\n\nHas perdido:( No te rindas, intentalo de nuevo...");
        }

        return turnos;
    }

    /**
     * Método para saber si los enemigos aún tienen vida
     * @param ListaEnemigos Lista de enemigos.
     * @return boolean Booleano que indica si los enemigos siguen vivos o no.
     */
    public boolean EnemiesAlive( ArrayList<Fighter> ListaEnemigos ) {
        boolean SiguenVivos = false;
        for (int i = 0; i < ListaEnemigos.size(); i++) {
            Fighter enemigo = ListaEnemigos.get(i);
            if ( enemigo.getLifePts()>0 ) {
                SiguenVivos = true;
            }
        }

        return SiguenVivos;
    }

    /**
     * Método para preguntar que ataque quiere hacer el usuario
     * @param a Combatiente.
     * @return int Opcion elegida.
     */
    public int Options( Fighter a ) {
        boolean selected = false;
        String opcS;
        int opc = 0;
        boolean Valide = false;
        toString(a);
        while ( selected == false && Valide == false) {
            System.out.println("\n\nOPCIONES:" +
            "\n1) Ataque normal" +
            "\n2) Item" +
            "\nIngrese la opcion a elegir: ");
            opcS = scan.nextLine();
            opc = ValideNum(opcS);
            if ( opc != -1 ) {
                Valide = true;
                if ( opc == 2 ) {
                    if ( a.getCantItems() != 0 ) {
                        selected = false;
                    }
                    else {
                        System.out.println("Ya no tienes items...");
                        Valide = false;
                    }
                }
            }
        }

        return opc;

    }

    /**
     * Método que muestra las opciones de items a usar
     */
    public int OptionsItems( Fighter a ){ 
        int opc = 0;
        String opcS;
        boolean Valide = false;
        while (Valide == false) {
            System.out.println("\n\nMENU"
            + "\n1) Sanarse"
            + "\n2) Granada"
            + "\n3) Hechizo"
            + "\n4) Evitar ataque anterior"
            + "\nIngrese la opcion a elegir: ");
            opcS = scan.nextLine();
            opc = ValideNum(opcS);
            if ( opc != -1 ) {
                if (opc == 1 && a.getRecover()==true){
                    Valide = true;
                }
                else if ( opc == 2 && a.getGrenade()==true){
                    Valide = true;
                }
                else if ( opc == 3 && a.getSpell()==true ) {
                    Valide = true;
                }
                else if ( opc == 4 && a.getAvoid()==true ) {
                    Valide = true;
                }
                else {
                    System.out.println ("No puedes utilizar este item. Intentalo de nuevo!");
                }
            }
        }

        return opc;
    }

    public void Atacked(Fighter AlQueAtacan){
        System.out.println("Has atackado a " + AlQueAtacan.getName() + ". Le quedan " + AlQueAtacan.getLifePts() + " puntos de vida.");
    }

    public void Ganador(){
        System.out.println("\n\n\nFELICITACIONES HAS GANADO!!!!");
    }

    public void Perdedor(){
        System.out.println("\n\n\nHas perdido:( Practica mas!");
    }

    public void Saliendo(){
        System.out.println("Saliendo del programa...");
    }

    public void Error(){
        System.out.println("Error! Ingresa la opcion nuevamente");
    }

    public void Jump(){
        System.out.println("\n\n\n");
    }
}