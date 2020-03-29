package me.logan.senpagamemory;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;


public class OptionsTest {
    @Test
    public void getOption() throws Exception {
        Options options = new Options();
        options.option = 1;
        assertEquals(1, options.getOption());
    }

    @Test
    public void print() throws Exception {
        Options options = new Options();
        options.print();
    }


}