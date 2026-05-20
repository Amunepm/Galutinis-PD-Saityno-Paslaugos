package lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.repository;

import lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.model.WeatherRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeatherRecordRepository extends JpaRepository<WeatherRecord, Long> {
    List<WeatherRecord> findByLocationId(Long locationId);
}
