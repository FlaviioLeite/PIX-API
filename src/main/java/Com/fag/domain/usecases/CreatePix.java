package Com.fag.domain.usecases;
import Com.fag.domain.dto.PixDTO;
import Com.fag.domain.entities.PixBO;
import Com.fag.domain.mappers.PixMapper;
import Com.fag.domain.repositories.IPixRepository;

public class CreatePix {

    private IPixRepository pixRepo;

    public CreatePix(IPixRepository pixRepo) {
        this.pixRepo = pixRepo;
    }

    public PixDTO execute(PixDTO pixDTO) {

        PixBO bo = PixMapper.toBO(pixDTO);

        PixDTO createdPix = pixRepo.create(pixDTO);

        bo.updateEmvData(createdPix.getEmv(), createdPix.getBase64(), createdPix.getExpiration());

        return createdPix;
    
    }

}