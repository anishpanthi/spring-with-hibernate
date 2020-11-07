package net.app.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * Defines and creates beans or configuration for application context.
 *
 * @author Anish Panthi
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {

  /**
   * Enables MatrixVariable
   *
   * @param configurer path match configurer
   */
  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    UrlPathHelper urlPathHelper = new UrlPathHelper();
    urlPathHelper.setRemoveSemicolonContent(false);
    configurer.setUrlPathHelper(urlPathHelper);
  }
}
