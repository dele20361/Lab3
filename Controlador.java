// Autora: Paola de León
// Curso: Programación Orientada a Objetos (POO)
// Fecha de creación: 15 de Octubre 2020
// Main del programa

import java.util.Random;
import java.util.ArrayList;

public class Controlador {
    public static void main(String[] args) {

        // Propiedades
        Random rand = new Random();
        int CantEnemies;
        int Type;
        String Name;
        Fighter ply;
        Pet Pet;
        int Item;
        ArrayList<Fighter> Enemigos = new ArrayList<Fighter>();
        boolean TurnPly = true;

        // Instancias de clases
        Vista v = new Vista ();
        Item items = new Item();

        // Bienvenida y solicitar nombre del jugador
        v.WelcomeMsj();
        Name = v.Welcome();
        Type = v.FighterType();

        if ( Type == 0 ) {
            ply = new Player ( Name, 1 );
            Item = v.ChooseItem();
            ply.SelectItem(Item);
            v.toString( ply );
        }
        else if ( Type == 1) {
            ply = new Player ( Name );
            Item = v.ChooseItem();
            ply.SelectItem(Item);
            Item = v.ChooseItem();
            ply.SelectItem(Item);
            v.toString( ply );
        }
        else {
            ply = new Hunter(Name);
            Pet = new Pet(ply);
            ply.setPet(Pet);
            
        }

        // Crear enemigos
        v.InfoEnemies();
        CantEnemies = rand.nextInt(3);
        for (int i = 0; i < CantEnemies; i++) {
            int alea = rand.nextInt(2);
            Enemy Enemigo = null;
            switch (alea) {
                case 0:
                    Enemigo = new Enemy(true, false, false );
                    break;
                case 1:
                    Enemigo = new Enemy(false, true, false );
                case 2:
                    Enemigo = new Enemy(false, false, true );
                default:
                    break;
            }
            Enemigos.add(Enemigo);
            v.toString(Enemigo);
        }
        
        //Crear enemigo líder
        int item = v.TurnEnemy();
        Enemy EnemigoSupremo = null;
        switch (item) {
            case 1:
                EnemigoSupremo = new LeaderEnemy(true, false, false);
                break;

            case 2:
                EnemigoSupremo = new LeaderEnemy(false, true, false);
                break;

            case 3:
                EnemigoSupremo = new LeaderEnemy(false, false, true);
                break;
        
            default:
                break;
        }
        Enemigos.add(EnemigoSupremo);
        v.toString(EnemigoSupremo);

        boolean wantToContinue = true;
        while ( wantToContinue == true ) {
            int opcP = v.Menu();
            if ( opcP == 1 ) {
                boolean EnemiesAreAlive = v.EnemiesAlive(Enemigos);
                if (ply.getLifePts()>0 && EnemiesAreAlive == false ) {
                    v.Ganador();
                    wantToContinue = false;
                } else if (EnemiesAreAlive==true && ply.getLifePts()<=0){
                    v.Perdedor();
                    wantToContinue = false;
                } else {
                    ArrayList<Fighter> fighters = v.TurnPlayer(TurnPly, ply, Enemigos, CantEnemies);
                    Fighter QuienAtaca = fighters.get(0);
                    Fighter AlQueAtacan = fighters.get(1);
                    int opc = v.Options(QuienAtaca);
                    switch (opc) {
                        case 1:
                            QuienAtaca.Atack(AlQueAtacan);
                            v.Atacked(AlQueAtacan);
                            break;
                        case 2:
                            int opcItem = v.OptionsItems(QuienAtaca);
                            switch (opcItem) {
                                case 1:
                                    QuienAtaca.Atack(AlQueAtacan);
                                    v.toString(QuienAtaca);
                                    v.toString(AlQueAtacan);
                                    break;
        
                                case 2:    
                                    QuienAtaca.Grenade(items, AlQueAtacan);
                                    v.toString(QuienAtaca);
                                    v.toString(AlQueAtacan);
                                    break;
        
                                case 3:
                                    if ( QuienAtaca.getIsAPlayer()==true ) {
                                        TurnPly = QuienAtaca.Spell(items, TurnPly);
                                    } else { TurnPly = QuienAtaca.Spell(TurnPly); }
                                    v.toString(QuienAtaca);
                                    v.toString(AlQueAtacan);
                                    break;
        
                                case 4:
                                    QuienAtaca.Avoid(AlQueAtacan);
                                    v.toString(QuienAtaca);
                                    v.toString(AlQueAtacan);
                                    break;
                                
                                
                                default:
                                    break;
                            }
                            break;
                        default:
                        break;
                    }
                    v.Jump();
                    //Cambiar de turno
                    TurnPly =! TurnPly;
                }
            } else if ( opcP == 2 ) {
                //Despedida
                v.Saliendo();
                wantToContinue = false;
            } else { 
                v.Error();
            }
        }
    }
} 
