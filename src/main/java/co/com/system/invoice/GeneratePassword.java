package co.com.system.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeneratePassword {

    /*implements CommandLineRunner {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public static void main(String[] args) {
        SpringApplication.run(GeneratePassword.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String password = "12345";

        for(int i=0; i<3;i++) {
            String passwordBc =bCryptPasswordEncoder.encode(password);
            System.out.println(passwordBc);
        }
    }*/
}
