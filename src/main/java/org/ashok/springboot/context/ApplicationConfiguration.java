package org.ashok.springboot.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

@PropertySource("classpath:/application.properties")
@PropertySource(value = "classpath:/application-${spring.profiles.active}.properties"
                    , ignoreResourceNotFound = true)
//@EnableWebMvc
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackageClasses = AppLauncher.class)
public class ApplicationConfiguration implements WebMvcConfigurer{

	/*
	 * @Bean public MethodValidationPostProcessor methodValidationPostProcessor() {
	 * return new MethodValidationPostProcessor(); }
	 * 
	 * @Bean public DataSource dataSource() {
	 * 
	 * JdbcDataSource ds = new JdbcDataSource();
	 * 
	 * ds.
	 * setURL("jdbc:h2:~/myFirstH2Database;INIT=RUNSCRIPT FROM 'classpath:schema.sql'"
	 * ); ds.setUser("sa"); ds.setPassword("sa"); return ds; }
	 * 
	 * @Bean public JdbcTemplate jdbcTemplate() { return new
	 * JdbcTemplate(dataSource()); }
	 * 
	 *//*    @Bean
	
	 * public EntityManagerFactory entityManagerFactory() {
	 * 
	 * HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	 * vendorAdapter.setShowSql(true); vendorAdapter.setGenerateDdl(true);
	 * 
	 * LocalContainerEntityManagerFactoryBean factory = new
	 * LocalContainerEntityManagerFactoryBean();
	 * factory.setJpaVendorAdapter(vendorAdapter);
	 * factory.setPackagesToScan("org.ashok"); factory.setDataSource(dataSource());
	 * factory.afterPropertiesSet();
	 * 
	 * return factory.getObject(); }
	 * 
	 * @Bean public PlatformTransactionManager transactionManager() {
	 * 
	 * JpaTransactionManager txManager = new JpaTransactionManager();
	 * txManager.setEntityManagerFactory(entityManagerFactory()); return txManager;
	 * }
	 */ 
	 
	/*
	 * @Bean public ObjectMapper objectMapper() { return new ObjectMapper(); }
	 */

	/*
	 * @Bean public ThymeleafViewResolver viewResolver() { ThymeleafViewResolver
	 * viewResolver = new ThymeleafViewResolver();
	 * viewResolver.setTemplateEngine(templateEngine()); viewResolver.setOrder(1);
	 * // optional viewResolver.setViewNames(new String[] {"*.html", "*.xhtml"}); //
	 * optional return viewResolver; }
	 * 
	 * @Bean public SpringTemplateEngine templateEngine() { SpringTemplateEngine
	 * templateEngine = new SpringTemplateEngine();
	 * templateEngine.setTemplateResolver(templateResolver());
	 * templateEngine.setTemplateEngineMessageSource(messageSource()); return
	 * templateEngine; }
	 */
    
	/*
	 * public MessageSource messageSource() { ResourceBundleMessageSource
	 * messageSource = new ResourceBundleMessageSource();
	 * messageSource.setBasename("messages"); return messageSource; }
	 */

	/*
	 * @Bean public SpringResourceTemplateResolver templateResolver() {
	 * SpringResourceTemplateResolver templateResolver = new
	 * SpringResourceTemplateResolver();
	 * templateResolver.setPrefix("classpath:/templates/");
	 * templateResolver.setCacheable(false); return templateResolver; }
	 */
	/*
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("classpath:/css/", "classpath:/images/");
    }
*/    
   
}
