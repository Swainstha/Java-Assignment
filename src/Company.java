import java.util.List;

public class Company {

    private String company;
    private String industry;
    private String subIndustry;
    private String sector;
    private String description;
    private String phone;
    private String fax;
    private String weburl;
    private List<KeyPeople> keyPeople;

    public Company() {

    }

    public String getCompany() {
        return company;
    }

    public String getDescription() {
        return description;
    }

    public int getNumPeople() {
        return keyPeople.size();
    }

    public String getFax() {
        return fax;
    }

    public String getWebUrl() {
        return weburl;
    }

    @Override
    public String toString() {
        return "\nCOMPANY: " + company + " INDUSTRY: " + industry  + "\n"
                + "SUBINDUSTRY: " + subIndustry + " SECTOR: " + sector + "\n"
                + "DESCRIPTION: " + description + "\nPHONE: " + phone
                + " FAX: " + fax + "\nKEYPEOPLE: " + keyPeople;
    }
}

