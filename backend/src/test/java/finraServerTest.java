import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class finraServerTest {

    @org.junit.jupiter.api.Test
    void getComb() {
        ArrayList<String> test1 = new ArrayList<>();
        test1.add("2");
        test1.add("A");
        test1.add("B");
        test1.add("C");
        assertEquals(test1,finraServer.getComb("2"));
        test1.clear();
        test1.add("23");
        test1.add("A3");
        test1.add("B3");
        test1.add("C3");
        test1.add("2D");
        test1.add("AD");
        test1.add("BD");
        test1.add("CD");
        test1.add("2E");
        test1.add("AE");
        test1.add("BE");
        test1.add("CE");
        test1.add("2F");
        test1.add("AF");
        test1.add("BF");
        test1.add("CF");
        assertEquals(test1,finraServer.getComb("23"));
        assertEquals(16,finraServer.getComb("23").size());
    }
}