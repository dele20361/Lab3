public class Minion extends Partner {
    
    //Propiedades
    boolean Fire, Ice, Elec = false;

    public Minion ( Fighter owner ) {
        super("Minion", owner);
    }

    public void ChooseElement ( int opc ) {
        switch (opc) {
            case 0:
                Fire = true;
                break;
            case 1:
                Ice = true;
                break;
            case 2:
                Elec = true;
                break;
            default:
                break;
        }
    }

    public boolean Fire ( Fighter AQuienAtacan ) {
        boolean changed = false;
        if ( Fire == true ) {
            Atack(AQuienAtacan);
            Atack(AQuienAtacan);
            Atack(AQuienAtacan);
            changed = true; 
        }

        return changed;
    }

    public boolean Ice ( Fighter QuienAtaca ) {
        boolean changed = false;
        if ( Ice == true ) {
            int atack = QuienAtaca.getAtackPwr(); //
            int newAtack = atack/2;
            int life = Owner.getLifePts();
            Owner.setLifePts(life-newAtack);
            changed = true;
        }
        
        return changed;
    }

    public void SpecialAbility( Fighter chico ) {
        //Dueno recupera toda la vida
        Owner.setLifePts(Owner.getLifePtsInitial());
    }

    public void Ability() {
        //Dueno recupera 20 puntos de vida
        int life = Owner.getLifePts();
        Owner.setLifePts(life+20);
    }

}
