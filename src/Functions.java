import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Functions {
    private List<Company> comp = new ArrayList<>();

    public Functions() {

    }

    public void readFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filename)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Gson gson = new Gson();
                String[] parsed = line.split(",", 2);
                //System.out.println(parsed[1]);
                if (parsed.length > 1) {
                    Company com = gson.fromJson(parsed[1], Company.class);
                    comp.add(com);
                }

            }
            reader.close();
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException a) {
            a.printStackTrace();
        }
    }

    public void writeToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filename)))) {

            for (Company c : comp) {
                writer.write(c.getCompany() + " : " + c.getDescription() + "\n");
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkKeyPeople() {
        for (Company c : comp) {
            if (c.getNumPeople() > 0) {
                System.out.println("Company name : " + c.getCompany());
            }
        }
        System.out.println("\n\n");
    }

    public void printFax() {
        for (Company c : comp) {
            String[] str = c.getFax().split("-");
            StringBuilder fax = new StringBuilder();

            if (str.length > 0) {
                for (String num : str) {
                    fax.append(num);
                }
                long fax_long = Long.parseLong(fax.toString());
                System.out.println(c.getCompany() + " : " + fax_long);
            }
        }
    }

    public void replaceWWW() {
        String pattern = "[^(www+\\.)][A-Za-z0-9-]+\\.[com|net|org|biz|cc|ac|edu|ca\\.gov|info|us]+";
        int count = 0;
        for (Company c : comp) {

            if (c.getWebUrl() != null) {
                Pattern checkRegex = Pattern.compile(pattern);
                Matcher matchRegex = checkRegex.matcher(c.getWebUrl());
                count++;
                while (matchRegex.find()) {

                    if (matchRegex.group().length() != 0) {
                        System.out.println(matchRegex.group(0).trim());
                    } else {
                        System.out.println("no match");
                    }
                }
            }
        }
        System.out.println(count);

    }

    public void extractDomain() {
        for(Company c : comp) {
            if(c.getWebUrl() != null) {
                String s = c.getWebUrl().replaceAll("www.", "");
                if (s.contains("/")) {
                    String[] str = s.split("/");
                    s = str[0];
                }
                System.out.println(s);
            }

        }
    }
}
