public class Planet {
    public double xxPos, yyPos, xxVel, yyVel;
    public double mass;
    public String imgFileName;

    private static double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, 
                 double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        return Math.sqrt((xxPos - p.xxPos) * (xxPos - p.xxPos) + (yyPos - p.yyPos) * (yyPos - p.yyPos));
    }

    public double calcForceExertedBy(Planet p) {
        double r = calcDistance(p);
        return (G * mass * p.mass) / (r * r); 
    }

    public double calcForceExertedByX (Planet p) {
        double r = calcDistance(p);
        double F = calcForceExertedBy(p);
        double dx = p.xxPos - xxPos;
        return (F * dx) / r;        
    }

    public double calcForceExertedByY (Planet p) {
        double r = calcDistance(p);
        double F = calcForceExertedBy(p);
        double dy = p.yyPos - yyPos;
        return (F * dy) / r;        
    }
    
    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double result = 0;
        for (Planet p : allPlanets) {
            if (!this.equals(p)) {
                result = result + calcForceExertedByX(p);
            }
        }
        return result;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double result = 0;
        for (Planet p : allPlanets) {
            if (!this.equals(p)) {
                result = result + calcForceExertedByY(p);
            }
        }
        return result;
    }

    public void update(double dt, double fX, double fY) {
        double ax = fX / mass;
        double ay = fY / mass;

        xxVel = xxVel + dt * ax;
        yyVel = yyVel + dt * ay;

        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
