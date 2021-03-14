package com.s22034.goldys;

public class Task1_2 {

    public static void main(String[] args) {

		Flyable f[] = {new Bird(), new Virus(), new UFO(), new Plane()};
		Speakable s[] = {new Bird(), new Plane(), new UFO()};

		System.out.println(
                shortest(f)
        );

		System.out.println(
                loudest(s)
        );
    }

	private static Flyable shortest(Flyable[] f) {
		int minIndex = 0;
		double shortestDistance = Double.MAX_VALUE;

		for(int i = 0; i < f.length-1; i++){
		    if(f[i].distance() < shortestDistance){
                shortestDistance = f[i].distance();
		        minIndex = i;
            }
        }
		return f[minIndex];
	}

	private static Speakable loudest(Speakable[] s) {
		int maxIndex = 0;
		int charCounter = 0;
		int tmpCounter;

		for(int i = 0; i < s.length ; i++){
		    tmpCounter = 0;

		    tmpCounter = s[i].speak().length();
		    if(charCounter < tmpCounter){
		        maxIndex = i;
		        charCounter = tmpCounter;
            }
        }
		return s[maxIndex];
	}
}

interface Flyable {

    public double distance();
    public String drive();

}

interface Speakable {
    public String speak();
}

class Bird implements Flyable, Speakable{

    @Override
    public String speak() {
        return "Kra Kra Kra";
    }

    @Override
    public double distance() {
        return 800;
    }

    @Override
    public String drive() {
        return "Wings";
    }

    @Override
    public String toString() {
        return "Bird";
    }
}

class Plane implements Flyable, Speakable{

    @Override
    public double distance() {
        return 5000;
    }

    @Override
    public String drive() {
        return "Silniki!";
    }

    @Override
    public String speak() {
        return "Wsssshhhuuuum";
    }

    @Override
    public String toString() {
        return "Plane";
    }
}

class UFO implements Flyable, Speakable{

    @Override
    public double distance() {
        return 500000000;
    }

    @Override
    public String drive() {
        return "UFO Uber Engine";
    }

    @Override
    public String speak() {
        return "OooooOOOOoooOOOOOOO";
    }

    @Override
    public String toString() {
        return "UFO";
    }
}

class Virus implements Flyable {

    @Override
    public double distance() {
        return 00000000000000000000000000000000.1;
    }

    @Override
    public String drive() {
        return "Kropelkowo!";
    }

    @Override
    public String toString() {
        return "Virus";
    }
}