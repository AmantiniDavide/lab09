package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;


/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String HOME = System.getProperty("user.home");
    private static final String DEFAULT_FILE = "output.txt";

    private File dest = new File(HOME + File.separator + DEFAULT_FILE);

    public File getCurrentFile(){
        return dest;
    }

    public String getCurrentFilePath(){
        return dest.getPath();
    }

    public void save(final String text) throws IOException {
        try (PrintStream out = new PrintStream(dest, StandardCharsets.UTF_8)) {
            out.println(text);
        }
    }

    public void setDestination(final File file){
        final File parent = file.getParentFile();
        if(parent.exists()){
            dest = file;
        } else{
            throw new IllegalArgumentException("Cannot save in a non-existing folder");
        }
    }

    public void setDestination(final String file){
        setDestination(new File(file));
    }

}
