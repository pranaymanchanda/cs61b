public class Planet{
    // Instance variables belong to EACH instance of class
    // Static variables shared by ALL instances of the class 
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    // Creates a copy of the planet 
    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.yyPos;
        double r = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        return r;
    }

    public double calcForceExertedBy(Planet p){
        double r = this.calcDistance(p);
        // Newton's Gravitation Formula
        double F = (G*this.mass*p.mass)/Math.pow(r, 2);
        return F;
    }

    public double calcForceExertedByX(Planet p){
        double dx = p.xxPos - this.xxPos;
        double r = this.calcDistance(p);
        double F = this.calcForceExertedBy(p);
        double Fx = F*dx/r;
        return Fx;

    }
    public double calcForceExertedByY(Planet p){
        double dy = p.yyPos - this.yyPos;
        double r = this.calcDistance(p);
        double F = this.calcForceExertedBy(p);
        double Fy = F*dy/r;
        return Fy;
    }

    public double calcNetForceExertedByX(Planet[] planets){
        double netForceX = 0;
        for (Planet currentPlanet : planets){
            // Force exerted by planet on itself is 0
            if(currentPlanet.equals(this)){
                continue;
            } else {
                netForceX += this.calcForceExertedByX(currentPlanet);
            }
        }
        return netForceX;
    }

    public double calcNetForceExertedByY(Planet[] planets){
        double netForceY = 0;
        for (Planet currentPlanet: planets){
            // Force exerted by planet on itself is 0
            if(currentPlanet.equals(this)){
                continue;
            } else {
                netForceY += this.calcForceExertedByY(currentPlanet);
            }
        }
        return netForceY;
    }

    public void update(double time, double xForce, double yForce){
        double ax = xForce/this.mass;
        double ay = yForce/this.mass;
        this.xxVel = this.xxVel + ax*time;
        this.yyVel = this.yyVel + ay*time;
        this.xxPos = this.xxPos + time*this.xxVel;
        this.yyPos = this.yyPos + time*this.yyVel;
    }

}