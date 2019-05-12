import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CoffeeMachineShould {
    @Test
    public void brewEspressoWhenGivenProperStock(){
        //given
        CoffeeMachine m=new CoffeeMachine();
        //when
        Cafea c=m.brew(TipCafea.ESPRESSO);
        //then
        assertEquals(TipCafea.ESPRESSO,c.getTip());
    }
    @Test(expected =IllegalArgumentException.class)
    public void throwExceptionWhenMissingWater(){
        //given
        CoffeeMachine m=new CoffeeMachine(0,100,100);
        //when
        Cafea c=m.brew(TipCafea.ESPRESSO);
        //then

    }
    @Test
    public void updateStockAfterBrewCapuccino(){
        int apa=1000;
        int boabe=1000;
        int lapte=1000;
        CoffeeMachine m=new CoffeeMachine(apa,boabe,lapte);
        Cafea c=m.brew(TipCafea.CAPUCCINO);
        assertTrue(apa-c.getTip().getCantitateApa()==m.getStocApa());
        assertTrue(boabe-c.getTip().getCantitateBoabe()==m.getStocBoabe());
        assertTrue(lapte-c.getTip().getCantitateLapte()==m.getStocLapte());
    }
    @Test
    public void persistMachineIntoFileWhenPowering(){
        CoffeeMachine m=new CoffeeMachine(2019,2019,2019);
        Cafea latte=m.brew(TipCafea.LATTE_MACCHIATO);
        Cafea capuccino=m.brew(TipCafea.CAPUCCINO);
        Cafea espressoLung=m.brew(TipCafea.ESPRESSO_LUNG);
        m.powerOff();
        CoffeeMachine x=new CoffeeMachine();
        CoffeeMachine mFromFile=x.powerOn();
        assertEquals(m.getStocApa(),mFromFile.getStocApa());
        assertEquals(m.getStocBoabe(),mFromFile.getStocBoabe());
        assertEquals(m.getStocLapte(),mFromFile.getStocLapte());

    }
}
