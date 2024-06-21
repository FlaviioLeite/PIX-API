package Com.fag.infra.CelCoin.dto;

import java.math.BigDecimal;

import Com.fag.domain.dto.PixMerchantDTO;

public class CelCoinPixDTO {

    private PixMerchantDTO merchant;
    private String key;
    private BigDecimal amount;
    private String emvqrcps;
    public PixMerchantDTO getMerchant() {
        return merchant;
    }
    public void setMerchant(PixMerchantDTO merchant) {
        this.merchant = merchant;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public String getEmvqrcps() {
        return emvqrcps;
    }
    public void setEmvqrcps(String emvqrcps) {
        this.emvqrcps = emvqrcps;
    }
    
    @Override
    public String toString() {
        return "CelCoinPixDTO [merchant=" + merchant + ", key=" + key + ", amount=" + amount + ", emvqrcps=" + emvqrcps
                + "]";
    }
    
}
