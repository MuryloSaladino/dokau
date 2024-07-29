package org.saladino.dokau.config;

import org.saladino.dokau.filters.ValidateTokenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class FiltersConfiguration {

    private final ValidateTokenFilter validateTokenFilter;

    public FiltersConfiguration(ValidateTokenFilter validateTokenFilter) {
        this.validateTokenFilter = validateTokenFilter;
    }


    @Bean @Scope()
    protected FilterRegistrationBean<ValidateTokenFilter> validateToken() {

        FilterRegistrationBean<ValidateTokenFilter> filter = new FilterRegistrationBean<ValidateTokenFilter>();
        filter.setFilter(validateTokenFilter);
        filter.addUrlPatterns("/*");

        return filter;
    }
}
