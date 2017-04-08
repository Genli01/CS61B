public class Planet {
    double xxPos; //Its current x position
    double yyPos; //Its current y position
    double xxVel; //Its current velocity in the x direction
    double yyVel; //Its current velocity in the y direction
    double mass; //Its mass
    String imgFileName; //The name of an image in the images directory that depicts the planet
    public static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        return Math.sqrt((this.xxPos - p.xxPos) * (this.xxPos - p.xxPos) +
                (this.yyPos - p.yyPos) * (this.yyPos - p.yyPos));
    }

    public double calcForceExertedBy(Planet p) {
        double r = calcDistance(p);
        return G * this.mass * p.mass / r / r;
    }

    public double calcForceExertedByX(Planet p) {
        //Fx = F * dx / r
        return calcForceExertedBy(p) * (p.xxPos - this.xxPos) / calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        return calcForceExertedBy(p) * (p.yyPos - this.yyPos) / calcDistance(p);

    }
    public double calcNetForceExertedByX(Planet[] planets) {
        double netForceExertedByX = 0.0;
        for (Planet p : planets) {
            if (!p.equals(this)) {
                netForceExertedByX += calcForceExertedByX(p);
            }
        }
        return netForceExertedByX;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double netForceExertedByY = 0.0;
        for (Planet p : planets) {
            if (!p.equals(this)) {
                netForceExertedByY += calcForceExertedByY(p);
            }
        }
        return netForceExertedByY;
    }


}
