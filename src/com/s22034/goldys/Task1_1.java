package com.s22034.goldys;

public class Task1_1 {

    public static void main(String[] args) {
        Muzyk[] muzycy = {new Skrzypek("Aleks", 2),
                new Wiolonczelista("Bartek", 1),
                new Flecista("Czarek", 0.5)};
        for (Muzyk m : muzycy)
            System.out.println("Muzyk: " + m.imie() + '\n' +
                    "Instrument: " + m.instrument() + '\n' +
                    "Czas wystąpienia: " + m.czas() + " godz. " + '\n' +
                    "Stawka godzinowa: " + m.stawka() + '\n');

        System.out.println(Muzyk.maxHonorarium(muzycy));
    }
}

abstract class Muzyk {

    private String imie;
    private double czas;

    protected Muzyk(String imie, double czas) {
        this.imie = imie;
        this.czas = czas;
    }

    protected String imie() {
        return this.imie;
    }

    protected double czas() {
        return this.czas;
    }

    abstract protected String instrument();
    abstract protected int stawka();


    public String toString() {
        return imie + ", czas= " + czas + "godz., stawka= " + stawka();
    }


    public static Muzyk maxHonorarium(Muzyk[] muzycy)
    {
        int maxIndex = 0;
        double highestIncome = 0;
        for(int i = 0; i < muzycy.length; i++){
            if(muzycy[i].stawka()*muzycy[i].czas > highestIncome){
                maxIndex = i;
                highestIncome = muzycy[i].stawka()*muzycy[i].czas;
            }
        }
        return muzycy[maxIndex];
    }

}

class Flecista extends Muzyk {

    // konstruktor
    public Flecista(String imie, double czas) {
        super(imie, czas);
    }

    @Override
    public String instrument() {
        return "Flet";
    }

    @Override
    public int stawka() {
        return 300;
    }
}

class Skrzypek extends Muzyk{

    public Skrzypek(String imie, double czas){
        super(imie, czas);
    }

    @Override
    protected String instrument() {
        return "Skrzypce";
    }

    @Override
    protected int stawka() {
        return 200;
    }
}

class Wiolonczelista extends Muzyk{

    public Wiolonczelista(String imie, double czas) {
        super(imie, czas);
    }

    @Override
    protected String instrument() {
        return "Wiolonczela";
    }

    @Override
    protected int stawka() {
        return 250;
    }
}