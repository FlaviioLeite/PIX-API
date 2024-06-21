package Com.fag.infra.CelCoin.repository;

import java.util.UUID;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import Com.fag.domain.dto.PixDTO;
import Com.fag.domain.repositories.IPixRepository;
import Com.fag.infra.CelCoin.dto.CelCoinPixDTO;
import Com.fag.infra.CelCoin.dto.CelCoinTokenDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Form;

@ApplicationScoped
public class CCPixRepository implements IPixRepository {

    @Inject
    @RestClient
    RestClientCC restClient;


    @Override
    public PixDTO create(PixDTO dto) {

        String token = getToken();
        

        CelCoinPixDTO celcoinDTO = new CelCoinPixDTO();

        celcoinDTO.setAmount(dto.getAmount());
        celcoinDTO.setMerchant(dto.getMerchant());
        celcoinDTO.setKey("testepix@celcoin.com.br");

        System.out.println(celcoinDTO.toString());
        
       CelCoinPixDTO response = restClient.createPix(token, celcoinDTO);

        dto.setEmv(response.getEmvqrcps());

        return dto;
    }

    private String getToken() {
        Form form = new Form();

        form.param("client_id", "41b44ab9a56440.teste.celcoinapi.v5");
        form.param("grant_type", "client_credentials");
        form.param("client_secret", "e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3");

        CelCoinTokenDTO tokenDTO = restClient.generateToken(form);
        String token = "Bearer " + tokenDTO.getAccessToken();
            
        return token;
    }
}