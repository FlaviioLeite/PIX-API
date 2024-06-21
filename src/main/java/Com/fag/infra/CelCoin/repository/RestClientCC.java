package Com.fag.infra.CelCoin.repository;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import Com.fag.infra.CelCoin.dto.CelCoinPixDTO;
import Com.fag.infra.CelCoin.dto.CelCoinTokenDTO;
import Com.fag.infra.MercadoPago.dto.CCPixDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
@RegisterRestClient(baseUri = "https://sandbox.openfinance.celcoin.dev")
public interface RestClientCC {

    @POST
    @Path("/pix/v1/brcode/static")
    @Consumes(MediaType.APPLICATION_JSON)
    CelCoinPixDTO createPix(
            @HeaderParam("Authorization") String token,
            CelCoinPixDTO payload);

    @POST
    @Path("/v5/token")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    CelCoinTokenDTO generateToken(Form form);
}