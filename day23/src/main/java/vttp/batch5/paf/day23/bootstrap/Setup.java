package vttp.batch5.paf.day23.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Setup implements CommandLineRunner {

    //@Autowired - @Service, @Repository

    @Override
    public void run(String... args) {
        System.out.printf("Number of elements: %d\n", args.length);

        for (int i = 0; i < args.length; i++)
            System.out.printf("i = %d, value = %s\n", i, args[i]);

    }

}
