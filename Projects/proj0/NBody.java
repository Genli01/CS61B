public class NBody {

    public static double readRadius(String planetsTxtPath) {
        In in = new In(planetsTxtPath);
        in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String planetsTxtPath) {
        In in = new In(planetsTxtPath);
        int numberOfPlanets = in.readInt();
        Planet[] planets = new Planet[numberOfPlanets];
        double radius = in.readDouble();
        for(int i = 0; i < numberOfPlanets; i++) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            planets[i] = new Planet(xP, yP, xV, yV, m, img);
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        String backgroundImage = "./images/starfield.jpg";
        double universeRadius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        StdDraw.setScale(-universeRadius, universeRadius);
        //StdDraw.picture(0, 0, backgroundImage, 2 * universeRadius, 2 * universeRadius);
        double[] xForces = new double[planets.length];
        double[] yForces = new double[planets.length];

        for (int t = 0; t < (int)T/dt; t++) {
            StdDraw.picture(0, 0, backgroundImage, 2 * universeRadius, 2 * universeRadius);
            for (int i = 0; i < planets.length; i++) {
                planets[i].draw();
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.show(20);
            t++;

        }



    }



}
