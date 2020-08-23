package algdat;

public class UkeOppgaver1 {

    // Forelesning 1
    static int max(int[] a) {
        int max_value = a[0];               // 1 + n + (n-1)
        for (int i=1; i<a.length; ++i) {    // 3
            if (a[i] > max_value) {         // 2 * (n-1)
                max_value = a[i];           // 2 * X
            }
        }
        return max_value;
    }

    // Oppgave 1.1.2 - 2
    static int min(int[] a){
        int min_value = a[0];
        for (int i=1; i<a.length; ++i){
            if (a[i] < min_value){
                min_value = a[i];
            }
        }
        return min_value;
    }

    /* Oppgave 1.1.3 - 5 Lag en metode public static int[] minmaks(int[] a). Den skal ved hjelp av en int-tabell med
    lengde 2 returnere posisjonene til minste og største verdi i tabellen a. Hvis du har funnet at m1 er posisjonen til
    den minste og m2 til den største, kan du returnere tabellen b definert ved:   int[] b = {m1, m2}; Hvor mange
    sammenligninger bruker metoden din?

    Bruker 2(n-1) sammenligninger
     */
    public static String minmaks(int[] a){
        int[] b = {0,0};

        for(int i = 1; i<a.length; ++i){
            if(a[b[0]] > a[i]){
                b[0] = i;
            }
            if(a[b[1]] < a[i]){
                b[1] = i;
            }
        }
        return b[0] + ", " + b[1];
    }

    // Oppgave 1.1.3 - 6
    static long fac(int n){
        long sum = 1;
        for (int i = 2; i<=n; i++){
            sum*=i;
        }
        return sum;
    }

    // Oppgave 1.1.14 - 1
    public static int maks(int[] a)   // versjon 2 av maks-metoden
    {
        int m = 0;               // indeks til største verdi   1
        int maksverdi = a[0];    // største verdi  2
        for (int i = 1; i < a.length; i++)
            if (a[i] > maksverdi) // 1 + n + (n-1)
        {
            maksverdi = a[i];     // største verdi oppdateres   // 2(x)
            m = i;                // indeks til største verdi oppdateres 1(x)
        }
        return m;   // returnerer indeks/posisjonen til største verdi
    }
    //i) 10, 5, 7, 2, 9, 1, 3, 8, 4, 6  | 3 + 3x +2n  | n = 10; -> 23 + 3x , x=1 => 26
    //
    //ii) 1, 2, 3, 4, 5, 6, 7, 8, 9, 10         23 + 3x, x = 9 +> 23 + 27 = 50

    // Oppgave 1.1.5 - 1
    public static int maks3(int[] a)  // versjon 3 av maks-metoden
    {
        int sist = a.length - 1;       // siste posisjon i tabellen
        int m = 0;                     // indeks til største verdi
        int maksverdi = a[0];          // største verdi
        int temp = a[sist];            // tar vare på siste verdi
        a[sist] = 0x7fffffff;          // legger tallet 2147483647 sist

        for (int i = 0; ; i++)         // i starter med 0
            if (a[i] >= maksverdi)       // denne blir sann til slutt
            {
                if (i == sist)             // sjekker om vi er ferdige
                {
                    a[sist] = temp;          // legger siste verdi tilbake
                    return temp >= maksverdi ? sist : m;   // er siste størst?
                }
                else
                {
                    maksverdi = a[i];        // maksverdi oppdateres
                    m = i;                   // m oppdateres
                }
            }
    } // maks



    public static void main(String[] args) {
        // Forelesning 1
        /*
        [1,2]  [2,1]
          1      0      ->      1/2 : avg = 0.5
        [1,2,3]  [1,3,2]  [2,1,3]  [2,3,1]  [3,1,2]  [3,2,1]
           2        1       1        1         0        0        ->     5/6 = 1/2 + 1/3 : avg = 0.8333

        [1,2,3,4]   [1,2,4,3]   [1,3,2,4]   [1,3,4,2]   [1,4,2,3]   [1,4,3,2]
            3           2           2           2           1           1
        [2,1,3,4]   [2,1,4,3]   [2,3,1,4]   [2,3,4,1]   [2,4,1,3]   [2,4,3,1]
            2           1           2           2           1           1
        [3,1,2,4]   [3,1,4,2]   [3,2,1,4]   [3,2,4,1]   [3,4,1,2]   [3,4,2,1]
            1           1           1           1           1           1
        [4,1,2,3]   [4,1,3,2]   [4,2,1,3]   [4,2,3,1]   [4,3,1,2]   [4,3,2,1]
            0           0           0           0           0           0       ->     26/24  = 1/2 + 1/3 + 1/4  :  avg = 1.08333

        Harmonisk tall: n tall : Sum(i=2 to n) = Hn ; et veldig lite tall
        n1 = 1 millioner ->
        n2 = 2 millioner ->

         */
        // Ukesoppgaver 1:

        // Oppgave 1.1.2 - 1
        // Den ville returnert '6'

        // Oppgave 1.1.2 - 3
        // Endrer if-statementen til '>=' fra '>'

        //System.out.println(fac(20));


    }
}
