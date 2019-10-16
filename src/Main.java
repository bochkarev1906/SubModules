
public class Main {
    static int d = 0;
    static int g = 0;
    static int f = 0;
    static double  a = -2;
    static double  b = 20;
    static double e = 0.0001;
    static int n = findNFibonachi(a, b, e);


    public static double function(double x){
        return (x - 2) * (x - 2);
    }

    public static double dichotomy(double a, double b, double e){
        double x1 = (a + b) / 2 - 0.9 * e / 2;
        double x2 = (a + b) / 2 + 0.9 * e / 2;
        d++;
        if(Math.abs((a - b)) < e){
            return (x2 + x1) / 2;
        }
        else {
            if(function(x1) > function(x2)){
                return dichotomy(x1, b, e);
            }
            else {
                if(function(x1) < function(x2)){
                    return dichotomy(a, x2, e);
                }
                else {
                    return dichotomy(x1, x2, e);
                }
            }
        }
    }

    public static double gold(double a, double b, double e){
        double x1 = a + 0.381966011 * (b - a);
        double x2 = a + 0.618003399 * (b - a);
        g++;
        if(Math.abs((a - b)) < e){
            return (x2 + x1) / 2;
        }
        else {
            if(function(x1) > function(x2)){
                return gold(x1, b, e);
            }
            else {
                if(function(x1) < function(x2)){
                    return gold(a, x2, e);
                }
                else {
                    return gold(x1, x2, e);
                }
            }
        }
    }

        public static double fibonachi(int n){
        return (Math.pow(((1 + Math.pow(5, 0.5)) / 2), n) - Math.pow(((1 - Math.pow(5, 0.5)) / 2), n)) / Math.pow(5, 0.5);
    }

    public static int findNFibonachi(double a, double b, double e){
        int k = 0;
        while ((b - a) / e >= fibonachi(k)){
            k++;
        }
        return k - 2;
    }

    public static double methodFibonachi(double a, double b, double e){
        f++;
        double x1, x2;
        if(f == 1){
            x1 = a + fibonachi(n) / fibonachi(n + 2) * (b - a);
            x2 = a + fibonachi(n + 1) / fibonachi(n + 2) * (b - a);
        }
        else {
            x1 = a + fibonachi(n - f + 1) / fibonachi(n - f + 3) * (b - a);
            x2 = a + fibonachi(n - f + 2) / fibonachi(n - f + 3) * (b - a);
        }

        g++;
        if(f == n){
            return (x2 + x1) / 2;
        }
        else {
            if(function(x1) > function(x2)){
                return methodFibonachi(x1, b, e);
            }
            else {
                if(function(x1) < function(x2)){
                    return methodFibonachi(a, x2, e);
                }
                else {
                    return methodFibonachi(x1, x2, e);
                }
            }
        }
    }

    public static void main(String args[]){
        System.out.println(dichotomy(a, b, e) + " " + d);
        System.out.println(gold(a, b, e) + " " + g);
        System.out.println(methodFibonachi(a, b, e)  +" " + f);

    }
}
