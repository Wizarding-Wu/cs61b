public class NBody {
    public static double readRadius(String s) {
        In in = new In(s);
        in.readInt();
        return in.readDouble();
    }    

    public static Planet[] readPlanets(String s) {
        In in = new In(s);
        int N = in.readInt();
        in.readDouble();
        Planet[] planets = new Planet[5];
        for (int i = 0; i < N; i++) {
            planets[i] = new Planet(in.readDouble(), in.readDouble(), 
                                       in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planets = readPlanets(filename);
        double radius = readRadius(filename);

        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");

        for (Planet p : planets) {
            p.draw();
        }

        StdDraw.enableDoubleBuffering();
        
        int N = planets.length;
        for (double t = 0; t < T; t = t + dt) {
            double[] xForce = new double[N];
            double[] yForce = new double[N];
            for (int i = 0; i < N; i++) {
                xForce[i] = planets[i].calcNetForceExertedByX(planets);
                yForce[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for (int i = 0; i < N; i++) {
                planets[i].update(dt, xForce[i], yForce[i]);
            }

            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg"); 
            for (Planet p : planets) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                        planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
    }
}