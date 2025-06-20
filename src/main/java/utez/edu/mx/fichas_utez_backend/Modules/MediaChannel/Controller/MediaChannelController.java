package utez.edu.mx.fichas_utez_backend.Modules.MediaChannel.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.fichas_utez_backend.kernel.ResponseApi;
import utez.edu.mx.fichas_utez_backend.Modules.MediaChannel.Model.MediaChannel;
import utez.edu.mx.fichas_utez_backend.Modules.MediaChannel.Service.MediaChannelService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/media-channels")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "Medios de difusión", description = "Controlador para manejar los medios de difusión")
public class MediaChannelController {
    private final MediaChannelService service;

    @Operation(summary = "Obtener todos los medios de difusión", description = "Devuelve una lista de todos los medios de difusión registrados")
    @GetMapping
    public ResponseApi<List<MediaChannel>> getAll() {
        log.info("ini.MediaChannelController.getAll -> Fetching all media channels");
        List<MediaChannel> channels = service.getAllMediaChannels();
        log.info("end.MediaChannelController.getAll -> Fetched {} media channels", channels.size());
        return ResponseApi.success(channels);
    }
}

