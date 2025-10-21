package ss9_testing.bai_tap.triangle_classifier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleClassifierTest {

    @Test
    void classify() {
        assertEquals("Tam giac deu", TriangleClassifier.classify(1, 1, 1));
    }

    @Test
    void classify2() {
        assertEquals("tam giac can", TriangleClassifier.classify(2, 2, 3));
    }

    @Test
    void classify3() {
        assertEquals("Tam giac thuong", TriangleClassifier.classify(3, 4, 5));
    }

    @Test
    void classify4() {
        assertEquals("Khong phai tam giac", TriangleClassifier.classify(8, 2, 3));
    }

    @Test
    void classify5() {
        assertEquals("Khong phai tam giac", TriangleClassifier.classify(-1, 2, 1));
    }

    @Test
    void classify6() {
        assertEquals("Khong phai tam giac", TriangleClassifier.classify(0, 1, 1));
    }
}