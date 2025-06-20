package utez.edu.mx.fichas_utez_backend.Modules.MediaChannel.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utez.edu.mx.fichas_utez_backend.Modules.MediaChannel.Model.MediaChannelRepository;
import utez.edu.mx.fichas_utez_backend.Modules.MediaChannel.Model.MediaChannel;

import java.util.List;

@Service
public class MediaChannelService {
    private final MediaChannelRepository mediaChannelRepository;

    @Autowired
    public MediaChannelService(MediaChannelRepository mediaChannelRepository) {
        this.mediaChannelRepository = mediaChannelRepository;
    }

    public List<MediaChannel> getAllMediaChannels() {
        return mediaChannelRepository.findAll();
    }
}

