package com.example.model;
import static org.junit.jupiter.api.Assertions.*;

import java.util.BitSet;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlgorithmTest {
    @Test
    public void czebyszewFunctionTest() {
        NewtonCotes newtonCotes = new NewtonCotes();
        double result = newtonCotes.czebyszewFunctionT(2, 5);
        assertEquals(result, 362);
        //32*16-20*8+5*2= 512-160+10=362
    }

    @Test
    public void chooseFunctionPackageTest() {
        NewtonCotes newtonCotes = new NewtonCotes();
        double result = newtonCotes.chooseFunctionPackage("functionI", 1, 5);
    }

}
