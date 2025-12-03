public class Rational {
	// Attribute
	private int zaehler;
	private int nenner;
	
    // Klassenkonstanten
    public static final Rational NULL = new Rational(0, 1);
    public static final Rational EINS = new Rational(1, 1);

	
	public Rational(int z, int n) {
		if(n==0) {
			throw new IllegalArgumentException("Nicht durch 0 teilen");
		}
		this.nenner = n;
		this.zaehler = z;
		kuerzen(); // cool
	}
	
	public Rational() {
		this(0,1);
	}
	
	// Objektmethoden
	// Getter
	public int getZaehler() {
		return this.zaehler;
	}
	
	public int getNenner() {
		return this.nenner;
	}
	
	// Allgemein
	public String toString() {
		return this.zaehler+"/"+this.nenner;
	}
	
	public boolean equals(Rational r) {
		/*
		 * 1. Versuch war zu vgl. ob nenner und zaehler gleich sind.
		 * Problem: 6/3 = 2 = 4/2
		 */
		return (this.zaehler * r.nenner == this.nenner * r.zaehler);
	}

	public double doubleValue() {
		return (this.zaehler/this.nenner);
	}
	
	// Rechnen

    // Addition
    public Rational plus(Rational r) {
        int gemeinsamerNenner = this.nenner * r.getNenner();
        int neuerZaehler = this.zaehler * r.getNenner() + r.getZaehler() * this.nenner;
        return new Rational(neuerZaehler, gemeinsamerNenner);
    }


    // Subtraktion
    public Rational minus(Rational r) {
        int gemeinsamerNenner = this.nenner * r.getNenner();
        int neuerZaehler = this.zaehler * r.getNenner() - r.getZaehler() * this.nenner;
        return new Rational(neuerZaehler, gemeinsamerNenner);
    }

    // Multiplikation
    public Rational mal(Rational r) {
        int neuerZaehler = this.zaehler * r.getZaehler();
        int neuerNenner = this.nenner * r.getNenner();
        return new Rational(neuerZaehler, neuerNenner);
    }

    // Division
    public Rational geteilt(Rational r) {
        if (r.getZaehler() == 0) {
            throw new ArithmeticException("Division durch 0 nicht erlaubt!");
        }
        int neuerZaehler = this.zaehler * r.getNenner();
        int neuerNenner = this.nenner * r.getZaehler();
        return new Rational(neuerZaehler, neuerNenner);
    }

    // Symmetrische Klassenmethoden
    public static Rational plus(Rational r1, Rational r2) {
        return r1.plus(r2);
    }

    public static Rational minus(Rational r1, Rational r2) {
        return r1.minus(r2);
    }

    public static Rational mal(Rational r1, Rational r2) {
        return r1.mal(r2);
    }

    public static Rational durch(Rational r1, Rational r2) {
        return r1.geteilt(r2);
    }

    
    // Zusatzaufgaben
    private void kuerzen() {
        int g = ggt(Math.abs(zaehler), Math.abs(nenner));
        zaehler /= g;
        nenner /= g;
        // Nenner immer positiv halten
        if (nenner < 0) {
            nenner *= -1;
            zaehler *= -1;
        }
    }

    // größter gemeinsamer Teiler
    private int ggt(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public Rational gekuerzterBruch() {
    	Rational temp = new Rational(this.zaehler, this.nenner); // Copy of Bruch
        int g = ggt(Math.abs(temp.zaehler), Math.abs(temp.nenner));
        temp.zaehler /= g;
        temp.nenner /= g;
        // Nenner immer positiv halten
        if (temp.nenner < 0) {
        	temp.nenner *= -1;
        	temp.zaehler *= -1;
        }
        
        return temp;
    }
    
    public boolean groesserAls(Rational r) {
    	return doubleValue() > r.doubleValue();
    }
    
    

}
