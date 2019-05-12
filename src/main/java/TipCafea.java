public enum TipCafea {
    ESPRESSO(100, 10, 0){
        @Override
        public String toString(){
            return "espresso";
        }
    },
    ESPRESSO_LUNG(200, 10, 0){
        @Override
        public String toString(){
            return "espresso lung";
        }
    },
    LATTE_MACCHIATO(100, 10, 200){
        @Override
        public String toString(){
            return "latte macchiato";
        }
    },
    CAPUCCINO(100, 10, 100){
        @Override
        public String toString(){
            return "capuccino";
        }
    };
    private final int cantitateApa;
    private final int cantitateBoabe;
    private final int cantitateLapte;

    public int getCantitateApa() {
        return cantitateApa;
    }

    public int getCantitateBoabe() {
        return cantitateBoabe;
    }

    public int getCantitateLapte() {
        return cantitateLapte;
  }

    private TipCafea(int apa, int boabe, int lapte) {
        cantitateApa = apa;
        cantitateBoabe = boabe;
        cantitateLapte = lapte;
    }
}
