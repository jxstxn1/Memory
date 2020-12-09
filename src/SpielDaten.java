class SpielDaten {

    private char memoryfeld[][];

    public SpielDaten(int xgroesse, int ygroesse) {
        //Das ist der Konstruktor, hier werden Initialisierungen vorgenommen
        //diese Methode wird zum Erzeugen des Objekts aufgerufen,
        //danach nicht mehr, es sei denn, es werden mehr Objekte vom
        //selben Typ benötigt, was bei uns nicht der Fall ist.
        memoryfeld = new char[xgroesse][ygroesse];
        for (int idx = 0; idx < xgroesse; idx++) {
            for (int idy = 0; idy < ygroesse; idy++) {
                memoryfeld[idx][idy] = '#';
            }
        }
        initialisiereMemoryFeld(xgroesse, ygroesse);

    }

    private void initialisiereMemoryFeld(int xgroesse, int ygroesse) {
        //das memoryfeld wird initialisiert, d.h.
        //zwischen x = 0 und xgroesse, sowie
        //zwischen y = 0 und ygroesse werden
        //Zeichen jeweils zufällig verteilt,
        //so dass jedes Zeichen doppelt vorkommt.

        //int zahl = (int) ((Math.random()) * 9);

    }

    public char gibFeldWert(int px, int py) {
        //gibt den Wert des memoryfeld-arrays an der Stelle px/py zurück
        return memoryfeld[px][py];
    }


}
