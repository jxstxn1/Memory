
import java.util.Random;

class SpielDaten {

    static Random r = new Random();
    public static int nextRnd(int min, int max){
        return r.nextInt((max-min)+1)+min;
    }

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

        char[] verwendeteChars = new char[36];

        for (int x = 0; x < xgroesse; x++) {
            for (int y = 0; y < ygroesse; y++) {

                boolean passendesZeichenGefunden = false;
                while (passendesZeichenGefunden == false) {
                    char zufaellig = (char) nextRnd(65, 82);
                    int wieOft = 0;
                    for (int i = 0; i < verwendeteChars.length; i++) {
                        if (zufaellig == verwendeteChars[i]) {
                            wieOft++;
                        }
                    }
                    if (wieOft == 2) {
                        passendesZeichenGefunden = false;
                    }
                    else{
                        passendesZeichenGefunden = true;
                        memoryfeld[x][y] = zufaellig;
                        verwendeteChars[x+6*y] = zufaellig;
                    }
                }

            }
        }
        //Zeichen jeweils zufällig verteilt,
        //so dass jedes Zeichen doppelt vorkommt.

        //int zahl = (int) ((Math.random()) * 9);
    }

    public char gibFeldWert(int px, int py) {
        //gibt den Wert des memoryfeld-arrays an der Stelle px/py zurück
        return memoryfeld[px][py];
    }

}
