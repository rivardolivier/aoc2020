package day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2 {

    public static void day2() {

        System.out.println("========== Running code for Day 2 ============");

        List<Password> passwords = getPasswords();

        int validPasswordsPolicy1 = 0;
        int validPasswordsPolicy2 = 0;

        for (Password password : passwords) {
            if (validatePolicy1(password)) {
                validPasswordsPolicy1++;
            }

            if (validatePolicy2(password)) {
                validPasswordsPolicy2++;
            }
        }

        System.out.println("Password policy 1:" + validPasswordsPolicy1);
        System.out.println("Password policy 2:" + validPasswordsPolicy2);
    }

    private static boolean validatePolicy2(Password password) {
        int cpt = 0;
        if(password.getPassword().charAt(password.getMin()-1) == password.getCharacter().charAt(0)) {
            cpt++;
        }
        if (password.getPassword().charAt(password.getMax()-1) == password.getCharacter().charAt(0)) {
            cpt++;
        }

        return cpt == 1;
    }

    private static boolean validatePolicy1(Password password) {
        int cpt = 0;
        for (int index = 0; index < password.getPassword().length(); index++) {
            if (password.getPassword().charAt(index) == password.getCharacter().charAt(0)) {
                cpt++;
            }
        }
        return cpt >= password.getMin() && cpt <= password.getMax();
    }


    private static List<Password> getPasswords() {
        List<Password> passwords = new ArrayList<>();
        try
        {
            File file=new File("src/main/java/day2/input.txt");
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            String line;
            while((line=br.readLine())!=null)
            {
                Password password = new Password();
                String[] passworAnddPolicy = line.split(":");
                password.setPassword(passworAnddPolicy[1].trim());

                String[] policy = passworAnddPolicy[0].split(" ");
                password.setCharacter(policy[1].trim());

                String[] characterNumber = policy[0].split("-");
                password.setMin(Integer.valueOf(characterNumber[0].trim()));
                password.setMax(Integer.valueOf(characterNumber[1].trim()));

                passwords.add(password);
            }
            fr.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return passwords;
    }
}
