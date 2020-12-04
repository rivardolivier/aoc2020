package day4;

import org.codehaus.plexus.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4 {

    public static void day4() {

        System.out.println("========== Running code for Day 4 ============");
        int passportValid = 0;
        int strictPassportValid = 0;
        List<HashMap<String, String>> documents = getData();

        for (HashMap<String, String> document : documents) {

            //Valid Passport
            if (document.containsKey("byr")
                && document.containsKey("iyr")
                && document.containsKey("eyr")
                && document.containsKey("hgt")
                && document.containsKey("hcl")
                && document.containsKey("ecl")
                && document.containsKey("pid")) {
                passportValid++;

                //Strict passport valid
                Integer byr = Integer.valueOf(document.get("byr"));


                Integer iyr = Integer.valueOf(document.get("iyr"));
                Integer eyr = Integer.valueOf(document.get("eyr"));

                if (validateNumber(Integer.valueOf(document.get("byr")), 1920, 2002) &&
                        validateNumber(Integer.valueOf(document.get("iyr")), 2010, 2020) &&
                        validateNumber(Integer.valueOf(document.get("eyr")), 2020, 2030) &&
                        validateHeight(document.get("hgt")) &&
                        validateHairColor(document.get("hcl")) &&
                        validateEyeColor(document.get("ecl")) &&
                        validateId(document.get("pid"))
                ) {
                    strictPassportValid+=1;
                }
            }





        }
        System.out.println("Number of passport valid:" + passportValid);
        System.out.println("Number of strict passport valid:" + strictPassportValid);
    }

    private static boolean validateId(String pid) {

        Pattern p = Pattern.compile("[0-9]{9}");
        Matcher m = p.matcher(pid);
        return m.matches();
    }

    private static boolean validateNumber(Integer number, Integer min, Integer max) {
        return number >= min && number <= max;
    }

    private static boolean validateHeight(String height) {
        StringBuilder unit = new StringBuilder();
        StringBuilder size = new StringBuilder();
        for (int i = 0; i < height.length(); i++) {
            if (Character.isDigit(height.charAt(i))) {
                size.append(height.charAt(i));
            } else {
                unit.append(height.charAt(i));
            }
        }
        Integer sizeInNumber = Integer.valueOf(size.toString());
        return (unit.toString().trim().equals("cm") && validateNumber(sizeInNumber, 150, 193)) ||
                (unit.toString().trim().equals("in") && validateNumber(sizeInNumber, 59, 76));
    }

    private static boolean validateHairColor(String hairColor) {

        if (!hairColor.startsWith("#")) {
            return false;
        }
        String hairColorFormatted = hairColor.replaceFirst("#", "");
        Pattern p = Pattern.compile("[a-f0-9]{6}");
        Matcher m = p.matcher(hairColorFormatted);
        return m.matches();
    }

    private static boolean validateEyeColor(String eyeColor) {
        return eyeColor.equals("amb") ||
                eyeColor.equals("blu") ||
                eyeColor.equals("brn") ||
                eyeColor.equals("gry") ||
                eyeColor.equals("grn") ||
                eyeColor.equals("hzl") ||
                eyeColor.equals("oth");
    }

    private static List<HashMap<String, String>> getData() {
        List<HashMap<String, String>> data = new ArrayList<>();
        HashMap<String, String> documentInfo = new HashMap<>();
        try {
            File file = new File("src/main/java/day4/input.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                if (StringUtils.isEmpty(line)) {
                    data.add(documentInfo);
                    documentInfo = new HashMap<>();
                } else {

                    String[] listOfValues = line.split(" ");
                    for (String valueWithKey : listOfValues) {
                        if (!StringUtils.isEmpty(valueWithKey)) {
                            String[] splitedValueWithKey = valueWithKey.split(":");
                            documentInfo.put(splitedValueWithKey[0], splitedValueWithKey[1]);
                        }
                    }

                }
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        data.add(documentInfo);
        return data;
    }
}
