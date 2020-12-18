package org.guylabs.angular.spring.data.rest.sample.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.RepositoryDetectionStrategy;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class RestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

        /*
         ALL        — exposes all Spring Data repositories regardless of their Java visibility or
                      annotation configuration.
         DEFAULT    — exposes public Spring Data repositories or ones explicitly annotated
                      with @RepositoryRestResource and its exported attribute not set to false.
         VISIBILITY — exposes only public Spring Data repositories regardless of
                      annotation configuration.
         ANNOTATED  — only exposes Spring Data repositories explicitly annotated
                      with @RepositoryRestResource and its exported attribute not set to false.
         @see https://docs.spring.io/spring-data/rest/docs/current/reference/html/#customizing-sdr.repository-exposure
         */
        config.setRepositoryDetectionStrategy(
                RepositoryDetectionStrategy.RepositoryDetectionStrategies.ANNOTATED);
        config.setReturnBodyForPutAndPost(true);
        config.setBasePath("/rest");
    }
}
