package Com.fag.infra.MercadoPago.dto;

import java.math.BigDecimal;

import jakarta.json.bind.annotation.JsonbProperty;

public class CCPixDTO {

    private String description;

    @JsonbProperty("payment_method_id")
    private String paymentMethodId;

    @JsonbProperty("transaction_amount")
    private BigDecimal amount;

    private CCPixPayerDTO payer;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public CCPixPayerDTO getPayer() {
        return payer;
    }

    public void setPayer(CCPixPayerDTO payer) {
        this.payer = payer;
    }

}
