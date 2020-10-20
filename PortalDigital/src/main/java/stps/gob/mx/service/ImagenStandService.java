package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.ImagenStandDTO;

public interface ImagenStandService {
	ImagenStandDTO alta(ImagenStandDTO dto);
	ImagenStandDTO baja(ImagenStandDTO dto);
	List<ImagenStandDTO> consulta(ImagenStandDTO dto);
	List<ImagenStandDTO> consultaId(ImagenStandDTO dto);
	ImagenStandDTO modificacion(ImagenStandDTO dto);
}
