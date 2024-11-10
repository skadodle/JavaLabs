public class Complex {

    private double re;
    private double im;

    Complex() {}
    Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }
    Complex(Complex otherComplex) {
        this.re = otherComplex.re;
        this.im = otherComplex.im;
    }

    public double getMod() { return Math.sqrt(re * re + im * im); }

    public double getArg() throws Exception {
        if (re > 0)
            return Math.atan(im/re);
        if (re < 0 && im >= 0)
            return Math.atan(im/re) + Math.PI;
        if (re < 0 && im < 0)
            return Math.atan(im/re) - Math.PI;
        if (re == 0 && im > 0)
            return Math.PI / 2;
        if (re == 0 && im < 0)
            return 0 - Math.PI / 2;
        throw new Exception("Illegal re and im");
    }

    public void add(Complex num) {
        this.re += num.re;
        this.im += num.im;
    }

    public void sub(Complex num) {
        this.re -= num.re;
        this.im -= num.im;
    }

    public double getRe() { return this.re; }
    public double getIm() { return this.im; }

    public void setRe(double re) { this.re = re; }
    public void setIm(double im) { this.im = im; }
}
