package utez.edu.mx.fichas_utez_backend.Modules.MediaChannel.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaChannelRepository extends JpaRepository<MediaChannel, Long> {
}

