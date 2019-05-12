public interface AutomaticCoffeeMachine {
    public Cafea brew(TipCafea tip);
    // vrem ca aparatul sa tina minte de la o zi la alta stocul lui real;
    //pentru asta metoda poweroff va stinge aparatul, salvand stocurile actuale;
    // metoda power on va crea o noua instanta de tipul coffeemachine cu stocurile citite din fisier;
    public CoffeeMachine powerOn();
    public void powerOff();

}
