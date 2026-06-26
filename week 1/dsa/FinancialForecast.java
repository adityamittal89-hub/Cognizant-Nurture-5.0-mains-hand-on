public class FinancialForecast {

public static double predictValue(double presentValue, double rate, int years) {
if (years == 0) {
return presentValue;
}
return predictValue(presentValue * (1 + rate), rate, years - 1);
}

public static void main(String[] args) {
double presentValue = 1000;
double rate = 0.10;
int years = 3;

double futureValue = predictValue(presentValue, rate, years);
System.out.println("Future Value: " + futureValue);
}
}