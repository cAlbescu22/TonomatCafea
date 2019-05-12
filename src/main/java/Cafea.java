public class Cafea {
    private TipCafea tip;

    public Cafea(TipCafea tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return  "Enjoy your: "+tip.toString();
    }

    public TipCafea getTip() {
        return tip;
    }
}
