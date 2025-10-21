package ss9_testing.bai_tap.triangle_classifier;

public class TriangleClassifier {
    public static String classify(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return "Khong phai tam giac";
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "Khong phai tam giac";
        }
        if (a == b && b == c) {
            return "Tam giac deu";
        } else if (a == b || b == c || a == c) {
            return "tam giac can";
        } else {
            return "Tam giac thuong";
        }
    }
}
