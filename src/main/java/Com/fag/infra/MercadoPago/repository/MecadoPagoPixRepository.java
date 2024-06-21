package Com.fag.infra.MercadoPago.repository;

import java.util.UUID;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import Com.fag.domain.dto.PixDTO;
import Com.fag.domain.repositories.IPixRepository;
import Com.fag.infra.MercadoPago.dto.CCPixDTO;
import Com.fag.infra.MercadoPago.dto.CCPixPayerDTO;
import Com.fag.infra.MercadoPago.dto.CCPixResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MecadoPagoPixRepository implements IPixRepository {

    @Inject
    @RestClient
    RestClientCC restClient;

    @ConfigProperty(name = "CC.token")
    String CCToken;

    private final String CC_PAYMENT_ID = "pix";

    @Override
    public PixDTO create(PixDTO dto) {
        
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy91c2VyZGF0YSI6ImY2MWU4YTdlYjEyMzRlMGQ4MDViIiwiZXhwIjoxNjIzNzY0MTg2LCJpc3MiOiJDZWxjb2luQVBJIiwiYXVkIjoiQ2VsY29pbkFQSSJ9.CeIFVYPko6ItDdvw2GMc_WEbac-Hr_7dHjT4HsjKfmk";
        String idempotencyKey = UUID.randomUUID().toString();

        CCPixPayerDTO payerDTO = new CCPixPayerDTO();
        CCPixDTO pixDTO = new CCPixDTO();
        payerDTO.setEmail(dto.getEmail());

        pixDTO.setAmount(dto.getAmount());
        pixDTO.setDescription(dto.getDescription());
        pixDTO.setPaymentMethodId(CC_PAYMENT_ID);
        pixDTO.setPayer(payerDTO);

        CCPixResponse response = restClient.createPix(token, idempotencyKey, pixDTO);

        dto.setEmv(response.getPoi().getTrxData().getEmv());
        dto.setBase64(response.getPoi().getTrxData().getBase64());

        return dto;
    }

}