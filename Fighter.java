// Autora: Paola de León
// Curso: Programación Orientada a Objetos (POO)
// Fecha de creación: 15 de Octubre 2020
// Clase madre de los jugadores

import java.util.ArrayList;

abstract class Fighter {

    // Propiedades
    protected String Name;
    protected int LifePts;
    protected int LifePtsInitial;
    protected int AtackPwr;
    protected Pet Pet;
    protected ArrayList<Integer> Registro;
    protected boolean IsAPlayer, IsAPartner;
    protected int CantItems;
    protected boolean Recover, Grenade, Spell, Avoid = false;

    //Para jugadores 0=atack; 1=recover; 2=grenade;  3=spell
    //Para maleantes 0= atack; 1=heal; 2=avoid; 3=spell

    // Constructor
    public Fighter ( String name, int life, int pwr, boolean ply, boolean partner ) {
        this.Name = name;
        this.LifePts = life;
        this.LifePtsInitial = life;
        this.AtackPwr = pwr;
        Registro = new ArrayList<Integer>(); 
        this.IsAPlayer = ply;
        this.IsAPartner = partner;
    }

    // Getters
    public String getName() { return Name; }
    public int getLifePts() { return LifePts; }
    public int getAtackPwr() { return AtackPwr; }
    public ArrayList<Integer> getRegistro() { return Registro; }
    public int getLifePtsInitial() { return LifePtsInitial; }
    public boolean getIsAPlayer() { return IsAPlayer; }
    public boolean getIsAPartner() { return IsAPartner; }
    public int getCantItems() { return CantItems; }
    public boolean getRecover() { return Recover; }
    public boolean getGrenade() { return Grenade; }
    public boolean getSpell() { return Spell; }
    public boolean getAvoid() { return Avoid; }
    public Pet getPet() { return Pet; }


    // Setters
    public void setName( String a ) { Name = a; }
    public void setLifePts( int a ) { LifePts = a; }
    public void setAtackPwr( int a ) { AtackPwr = a; }
    public void setRegistro( ArrayList<Integer> a ) { Registro = a; }
    public void setLifePtsInitial( int a ) { LifePtsInitial = a; }
    public void setIsAPlayer( boolean a ) { IsAPlayer = a; }
    public void setIsAPartner( boolean a ) { IsAPartner = a; }
    public void setCantItems( int a ) { CantItems = a; }
    public void setRecover( boolean a ) { Recover = a; } 
    public void setGrenade( boolean a ) { Grenade = a; } 
    public void setSpell( boolean a ) { Spell = a; } 
    public void setAvoid( boolean a ) { Avoid = a; } 
    public void setPet( Pet a ) { Pet = a; }


    /**
     * Método para saber si el fighter ha muerto.
     * @return msj Mensaje indicando si el combatiente murió o no.
     */
    public String Dead (  ) {
        String msj = "";
        if ( LifePts<=0 ) {
            msj += "El combatiente " + Name + " ha muerto.";
        }
        else {
            msj += "El combatiente " + Name + " todavía tiene " + LifePts + " de vida! Tu puedes!";
        }

        return msj;
    }

    /**
     * Método para atacar a otro combatiente
     * @param fighter Combatiente por atacar
     */
    public void Atack( Fighter Fighter ) {
        int Life = Fighter.getLifePts();
        int NewLife = Life-AtackPwr;
        Fighter.setLifePts(NewLife);
        RegisterAttack(0);
    }

    /**
     * Método que registra los ataques realizados por combatientes
     * @param num Para maleantes 1=heal; 2=grenade; 3=spell
     */
    public void RegisterAttack( int num ) {
        Registro.add(num);
    }

    /**
     * Método que deben ser overrideados
     */
    public boolean Recover( Item a, Fighter ply ){ return false; }
    public boolean Recover(){ return false; }
    public boolean Grenade( Item a, Fighter e ){ return false; }
    public boolean Spell( Item a, boolean turn ){ return false; }
    public boolean Spell( boolean turn ) { return false; }
    public boolean Avoid( Fighter a ){ return false; }
    public void SelectItem( int a ) { };
    public void Absorbe( Fighter minionOenemigos ) {};

}
