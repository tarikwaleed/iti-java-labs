class Complex<T extends Number> {
    private T real;
    private T imaginary;

    public Complex(T real, T imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public T getReal() {
        return real;
    }

    public T getImaginary() {
        return imaginary;
    }

    public Complex<T> add(Complex<T> other) {
        T realPart = (T) Double.valueOf(this.real.doubleValue() + other.real.doubleValue());
        T imaginaryPart = (T) Double.valueOf(this.imaginary.doubleValue() + other.imaginary.doubleValue());
        return new Complex<T>(realPart, imaginaryPart);
    }

    public Complex<T> subtract(Complex<T> other) {
        T realPart = (T) Double.valueOf(this.real.doubleValue() - other.real.doubleValue());
        T imaginaryPart = (T) Double.valueOf(this.imaginary.doubleValue() - other.imaginary.doubleValue());
        return new Complex<T>(realPart, imaginaryPart);
    }


    public String toString() {
        return real + " + " + imaginary + "i";
    }
}

