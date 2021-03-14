package com.s22034.goldys;

public class Task1_3_4 {

    public static void main(String[] args)
    {
        Figura fig[] = new Figura[2];
        fig[0] = new Kolo(10, 10, 5);
        fig[1] = new Prostokat(20, 20, 15, 10);

        for (Figura f : fig)
            System.out.println(f);

        fig[0].pozycja(12, 12);
        fig[1].pozycja(25, 30);

        for (Figura f : fig)
            System.out.println("Obwod: " + f.obwod());

        for (Figura f : fig)
            System.out.println("Pole: " + f.pole());

        Figura p2 = new Prostokat2(20, 20, 10, 5, '*');

        ((Prostokat2)p2).rysuj();
    }
}

abstract class Figura implements Obliczanie{

    private int x, y;

    public Figura(int x, int y){
        this.x = x;
        this.y = y;
    }

    public abstract String fig();
    public abstract void pozycja(int x, int y);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "x: " + x + "y: " + y;
    }
}


class Kolo extends Figura implements Obliczanie {

    private int promien;

    public Kolo(int x, int y, int r)
    {
        super(x ,y);
        this.promien = r;
    }

    @Override
    public String fig() {
        return "Koło";
    }

    @Override
    public void pozycja(int x, int y)
    {
        if(Math.pow(((getX() - x)+(getY() - y)),2) <= Math.pow(promien,2)){
            System.out.println(
                    "Punkt " + "(" + x + "," + y + ") znajduje się wewnątrz koła"
            );
        }
        else{
            System.out.println(
                    "Punkt " + "(" + x + "," + y + ") znajduje się zewnątrz koła"
            );
        }
    }

    public int getPromien() {
        return promien;
    }

    @Override
    public String toString(){
        return "Koło\n" +
                "Środek - " + "(" + getX() + "," + getY() + ")\n" +
                "Promień - " + getPromien();
    }

    @Override
    public int pole() {
        return (int) (Math.PI*Math.pow(getPromien(),2));
    }

    @Override
    public int obwod() {
        return (int) (2*Math.PI*getPromien());
    }
}

class Prostokat extends Figura implements Obliczanie{

    protected int szer, wys;

    public Prostokat(int x, int y, int s, int w) {
        super(x,y);
        this.szer = s;
        this.wys = w;
    }

    public int getSzer() {
        return szer;
    }

    public int getWys() {
        return wys;
    }

    @Override
    public String fig() {
        return "Prostokat";
    }

    @Override
    public void pozycja(int x, int y)
    {
        if(x <= (getX()-getSzer()) && x >= getX() && y >= (getY()-getWys()) && y <= getY()){
            System.out.println(
                    "Punkt " + "(" + x + "," + y + ") znajduje się wewnątrz prostokąta"
            );
        } else{
            System.out.println(
                    "Punkt " + "(" + x + "," + y + ") znajduje się zewnątrz prostokąta"
            );
        }
    }

    @Override
    public String toString()
    {
        return "Prostokąt\n" +
                "Lewy górny - " + "(" + getX() + "," + getY() + ")\n" +
                "Szerokość: " + getSzer() + ", Wysokość: " + getWys();
    }

    @Override
    public int pole() {
        return (getWys()*getSzer());
    }

    @Override
    public int obwod() {
        return ((2*getWys())+(2*getSzer()));
    }

}

class Prostokat2 extends Prostokat implements Rysowanie{

    char znak;

    public Prostokat2(int x, int y, int s, int w, char znak) {
        super(x, y, s, w);
        this.znak = znak;
    }

    public char getZnak() {
        return znak;
    }

    @Override
    public void rysuj() {

        for(int i = 0; i < getWys() ; i++){
            for(int j = 0; j < getSzer(); j++){
                System.out.print(
                        getZnak()
                );
            }
            System.out.println(

            );
        }

    }
}

class Kolo2 extends Kolo implements Transformacja{

    public Kolo2(int x, int y, int r) {
        super(x, y, r);
    }

    //Brak pomyslu jaka implementacje wykonac :(((
    @Override
    public void przesunDo(int x, int y) {

    }

    @Override
    public void powrot() {
    }

}

interface Obliczanie{
    int pole();
    int obwod();
}

interface Rysowanie{
    void rysuj();
}

interface Transformacja{
    void przesunDo(int x, int y);
    void powrot();
}