package Com.fag.infra.MercadoPago.repository;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import Com.fag.infra.MercadoPago.dto.CCPixDTO;
import Com.fag.infra.MercadoPago.dto.CCPixResponse;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
@RegisterRestClient (baseUri = "https://sandbox.openfinance.celcoin.dev")
public interface RestClientCC {

    @POST
    @Path("/v1/payments")
    @Consumes(MediaType.APPLICATION_JSON)
    CCPixResponse createPix(
            @HeaderParam("Authorization") String token,
            @HeaderParam("X-Idempotency-Key") String idempotency,
            CCPixDTO payload);

}