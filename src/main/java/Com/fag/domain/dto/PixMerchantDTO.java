package Com.fag.domain.dto;

public class PixMerchantDTO {
    
    private String postalCode;
    private String city;
    private String merchantCategoryCode;
    private String name;
    private String emvqrcps;
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getMerchantCategoryCode() {
        return merchantCategoryCode;
    }
    public void setMerchantCategoryCode(String merchantCategoryCode) {
        this.merchantCategoryCode = merchantCategoryCode;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmvqrcps() {
        return emvqrcps;
    }
    public void setEmvqrcps(String emvqrcps) {
        this.emvqrcps = emvqrcps;
    }
   

}

