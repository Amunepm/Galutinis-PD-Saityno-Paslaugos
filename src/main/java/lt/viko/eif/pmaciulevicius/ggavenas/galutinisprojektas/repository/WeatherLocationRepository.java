package lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.repository;

import lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.model.WeatherLocation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WeatherLocationRepository extends JpaRepository<WeatherLocation, Long> {
}
