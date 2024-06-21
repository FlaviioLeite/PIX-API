package Com.fag.infra.MercadoPago.dto;
import jakarta.json.bind.annotation.JsonbProperty;

public class CCPixResponse {
    @JsonbProperty("point_of_interaction")
    private CCPixPoiDTO poi;

    public CCPixPoiDTO getPoi() {
        return poi;
    }

    public void setPoi(CCPixPoiDTO poi) {
        this.poi = poi;
    }

}
