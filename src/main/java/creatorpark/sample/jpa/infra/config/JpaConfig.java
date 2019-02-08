package creatorpark.sample.jpa.infra.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import creatorpark.sample.jpa.Application;
import creatorpark.sample.jpa.infra.audit.AuditorAwareBean;

@Configuration
@EnableJpaAuditing
@EntityScan(
	basePackageClasses = {Application.class, Jsr310JpaConverters.class}
)
public class JpaConfig {
  @Bean
  AuditorAware<String> auditorAware() {
    return new AuditorAwareBean();
  }
}
