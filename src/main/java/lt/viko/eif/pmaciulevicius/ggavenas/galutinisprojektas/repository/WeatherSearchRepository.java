package lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.repository;

import lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.model.WeatherSearch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository for weather search history.
 */
public interface WeatherSearchRepository extends JpaRepository<WeatherSearch, Long> {

    List<WeatherSearch> findTop10ByOrderBySearchedAtDesc();
}