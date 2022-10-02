package TRJavaHWs.lesson2.mathfunc;

public class MathFunctions implements IMathFunction{
    @Override
    public double Power(int n, int pow){
        return Math.pow(n, pow);
    }

    @Override
    public double AbsComplex(double x, double y){
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public double circumference(double r){
        return 2 * r * IMathFunction.PI;
    }
}
