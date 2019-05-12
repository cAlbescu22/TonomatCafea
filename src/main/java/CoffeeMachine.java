import java.io.*;

public class CoffeeMachine implements AutomaticCoffeeMachine, Serializable {
    private static final long serialVersionUID = -220782551719462861L;
    private int stocApa;
    private int stocBoabe;
    private int stocLapte;
    private final String persistentFileName = "stock.bin";

    public int getStocApa() {
        return stocApa;
    }

    public int getStocBoabe() {
        return stocBoabe;
    }

    public int getStocLapte() {
        return stocLapte;
    }

    CoffeeMachine() {
        stocApa = 1500;
        stocBoabe = 250;
        stocLapte = 800;
    }

    CoffeeMachine(int stocApa, int stocBoabe, int stocLapte) {
        this.stocApa = stocApa;
        this.stocBoabe = stocBoabe;
        this.stocLapte = stocLapte;
    }

    public Cafea brew(TipCafea tip) {
        Cafea result = null;
        if (stocApa >= tip.getCantitateApa() && stocBoabe >= tip.getCantitateBoabe() && stocLapte >= tip.getCantitateLapte()) {
            result = new Cafea(tip);
            stocApa -= tip.getCantitateApa();
            stocBoabe -= tip.getCantitateBoabe();
            stocLapte -= tip.getCantitateLapte();
        } else
            throw new IllegalArgumentException("Stoc insuficient");
        return result;
    }

    public CoffeeMachine powerOn() {
        CoffeeMachine obj = null;
        try {

            FileInputStream file = new FileInputStream(persistentFileName);

            ObjectInputStream in = new ObjectInputStream(file);
            obj = (CoffeeMachine) in.readObject();
            in.close();

            file.close();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        return obj;

    }

    public void powerOff() {
        try {

            FileOutputStream file = new FileOutputStream(persistentFileName);

            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(this);
            out.close();
            file.close();

        } catch (IOException ex) {

            System.out.println("IOException is caught");

        }

    }

}
