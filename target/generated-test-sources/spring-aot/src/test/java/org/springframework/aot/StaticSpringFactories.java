package org.springframework.aot;

import java.lang.Class;
import java.lang.Object;
import java.lang.String;
import java.util.function.Supplier;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.SpringBootExceptionReporter;
import org.springframework.boot.autoconfigure.AutoConfigurationImportFilter;
import org.springframework.boot.autoconfigure.AutoConfigurationImportListener;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.config.ConfigDataLocationResolver;
import org.springframework.boot.diagnostics.FailureAnalyzer;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.sql.init.dependency.DatabaseInitializerDetector;
import org.springframework.boot.sql.init.dependency.DependsOnDatabaseInitializationDetector;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.data.jdbc.AutoConfigureDataJdbc;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.neo4j.AutoConfigureDataNeo4j;
import org.springframework.boot.test.autoconfigure.data.r2dbc.AutoConfigureDataR2dbc;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jooq.AutoConfigureJooq;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebFlux;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.DefaultTestExecutionListenersPostProcessor;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.data.jpa.util._FactoryProvider;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.data.util.ProxyUtils;
import org.springframework.test.context.ContextCustomizerFactory;
import org.springframework.test.context.TestExecutionListener;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Class generated - do not edit this file
 */
public abstract class StaticSpringFactories {
  public static MultiValueMap<Class, Supplier<Object>> factories = new LinkedMultiValueMap();

  public static MultiValueMap<Class, String> names = new LinkedMultiValueMap();

  static {
    System.setProperty("spring.xml.ignore", "true");
    names.add(RepositoryFactorySupport.class, "org.springframework.data.jpa.repository.support.JpaRepositoryFactory");
    factories.add(ProxyUtils.ProxyDetector.class, () -> _FactoryProvider.hibernateProxyDetector());
    factories.add(org.springframework.data.web.config.SpringDataJacksonModules.class, () -> new org.springframework.data.web.config.SpringDataJacksonConfiguration());
    factories.add(org.springframework.beans.BeanInfoFactory.class, () -> new org.springframework.beans.ExtendedBeanInfoFactory());
    factories.add(org.springframework.boot.diagnostics.FailureAnalysisReporter.class, () -> new org.springframework.boot.diagnostics.LoggingFailureAnalysisReporter());
    names.add(SpringApplicationRunListener.class, "org.springframework.boot.context.event.EventPublishingRunListener");
    factories.add(ApplicationListener.class, () -> org.springframework.boot._FactoryProvider.clearCachesApplicationListener());
    factories.add(org.springframework.context.ApplicationListener.class, () -> new org.springframework.boot.builder.ParentContextCloserApplicationListener());
    factories.add(org.springframework.context.ApplicationListener.class, () -> new org.springframework.boot.context.FileEncodingApplicationListener());
    factories.add(org.springframework.context.ApplicationListener.class, () -> new org.springframework.boot.context.config.AnsiOutputApplicationListener());
    factories.add(org.springframework.context.ApplicationListener.class, () -> new org.springframework.boot.context.config.DelegatingApplicationListener());
    factories.add(org.springframework.context.ApplicationListener.class, () -> new org.springframework.boot.context.logging.LoggingApplicationListener());
    factories.add(org.springframework.context.ApplicationListener.class, () -> new org.springframework.boot.env.EnvironmentPostProcessorApplicationListener());
    factories.add(org.springframework.boot.logging.LoggingSystemFactory.class, () -> new org.springframework.boot.logging.logback.LogbackLoggingSystem.Factory());
    factories.add(org.springframework.boot.logging.LoggingSystemFactory.class, () -> new org.springframework.boot.logging.log4j2.Log4J2LoggingSystem.Factory());
    factories.add(org.springframework.boot.logging.LoggingSystemFactory.class, () -> new org.springframework.boot.logging.java.JavaLoggingSystem.Factory());
    factories.add(DatabaseInitializerDetector.class, () -> org.springframework.boot.flyway._FactoryProvider.flywayDatabaseInitializerDetector());
    factories.add(DatabaseInitializerDetector.class, () -> org.springframework.boot.jdbc._FactoryProvider.abstractDataSourceInitializerDatabaseInitializerDetector());
    factories.add(DatabaseInitializerDetector.class, () -> org.springframework.boot.jdbc.init._FactoryProvider.dataSourceScriptDatabaseInitializerDetector());
    factories.add(DatabaseInitializerDetector.class, () -> org.springframework.boot.liquibase._FactoryProvider.liquibaseDatabaseInitializerDetector());
    names.add(DatabaseInitializerDetector.class, "org.springframework.boot.orm.jpa.JpaDatabaseInitializerDetector");
    factories.add(DatabaseInitializerDetector.class, () -> org.springframework.boot.r2dbc.init._FactoryProvider.r2dbcScriptDatabaseInitializerDetector());
    factories.add(org.springframework.boot.env.PropertySourceLoader.class, () -> new org.springframework.boot.env.PropertiesPropertySourceLoader());
    factories.add(org.springframework.boot.env.PropertySourceLoader.class, () -> new org.springframework.boot.env.YamlPropertySourceLoader());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.context.config._FactoryProvider.configDataNotFoundFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.context.properties._FactoryProvider.incompatibleConfigurationFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.context.properties._FactoryProvider.notConstructorBoundInjectionFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.diagnostics.analyzer._FactoryProvider.beanCurrentlyInCreationFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.diagnostics.analyzer._FactoryProvider.beanDefinitionOverrideFailureAnalyzer());
    factories.add(org.springframework.boot.diagnostics.FailureAnalyzer.class, () -> new org.springframework.boot.diagnostics.analyzer.BeanNotOfRequiredTypeFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.diagnostics.analyzer._FactoryProvider.bindFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.diagnostics.analyzer._FactoryProvider.bindValidationFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.diagnostics.analyzer._FactoryProvider.unboundConfigurationPropertyFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.diagnostics.analyzer._FactoryProvider.connectorStartFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.diagnostics.analyzer._FactoryProvider.noSuchMethodFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.diagnostics.analyzer._FactoryProvider.noUniqueBeanDefinitionFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.diagnostics.analyzer._FactoryProvider.portInUseFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.diagnostics.analyzer._FactoryProvider.invalidConfigurationPropertyNameFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.diagnostics.analyzer._FactoryProvider.invalidConfigurationPropertyValueFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.diagnostics.analyzer._FactoryProvider.patternParseFailureAnalyzer());
    names.add(SpringBootExceptionReporter.class, "org.springframework.boot.diagnostics.FailureAnalyzers");
    factories.add(DependsOnDatabaseInitializationDetector.class, () -> org.springframework.boot.sql.init.dependency._FactoryProvider.annotationDependsOnDatabaseInitializationDetector());
    factories.add(DependsOnDatabaseInitializationDetector.class, () -> org.springframework.boot.jdbc._FactoryProvider.springJdbcDependsOnDatabaseInitializationDetector());
    factories.add(DependsOnDatabaseInitializationDetector.class, () -> org.springframework.boot.jooq._FactoryProvider.jooqDependsOnDatabaseInitializationDetector());
    names.add(DependsOnDatabaseInitializationDetector.class, "org.springframework.boot.orm.jpa.JpaDependsOnDatabaseInitializationDetector");
    names.add(ConfigDataLocationResolver.class, "org.springframework.boot.context.config.ConfigTreeConfigDataLocationResolver");
    names.add(ConfigDataLocationResolver.class, "org.springframework.boot.context.config.StandardConfigDataLocationResolver");
    factories.add(org.springframework.boot.context.config.ConfigDataLoader.class, () -> new org.springframework.boot.context.config.ConfigTreeConfigDataLoader());
    factories.add(org.springframework.boot.context.config.ConfigDataLoader.class, () -> new org.springframework.boot.context.config.StandardConfigDataLoader());
    factories.add(org.springframework.context.ApplicationContextInitializer.class, () -> new org.springframework.boot.context.ConfigurationWarningsApplicationContextInitializer());
    factories.add(org.springframework.context.ApplicationContextInitializer.class, () -> new org.springframework.boot.context.ContextIdApplicationContextInitializer());
    factories.add(org.springframework.context.ApplicationContextInitializer.class, () -> new org.springframework.boot.context.config.DelegatingApplicationContextInitializer());
    factories.add(org.springframework.context.ApplicationContextInitializer.class, () -> new org.springframework.boot.rsocket.context.RSocketPortInfoApplicationContextInitializer());
    factories.add(org.springframework.context.ApplicationContextInitializer.class, () -> new org.springframework.boot.web.context.ServerPortInfoApplicationContextInitializer());
    factories.add(org.springframework.boot.env.EnvironmentPostProcessor.class, () -> new org.springframework.boot.cloud.CloudFoundryVcapEnvironmentPostProcessor());
    names.add(EnvironmentPostProcessor.class, "org.springframework.boot.context.config.ConfigDataEnvironmentPostProcessor");
    names.add(EnvironmentPostProcessor.class, "org.springframework.boot.env.RandomValuePropertySourceEnvironmentPostProcessor");
    factories.add(org.springframework.boot.env.EnvironmentPostProcessor.class, () -> new org.springframework.boot.env.SpringApplicationJsonEnvironmentPostProcessor());
    factories.add(org.springframework.boot.env.EnvironmentPostProcessor.class, () -> new org.springframework.boot.env.SystemEnvironmentPropertySourceEnvironmentPostProcessor());
    factories.add(org.springframework.boot.env.EnvironmentPostProcessor.class, () -> new org.springframework.boot.reactor.DebugAgentEnvironmentPostProcessor());
    factories.add(AutoConfigurationImportListener.class, () -> org.springframework.boot.autoconfigure.condition._FactoryProvider.conditionEvaluationReportAutoConfigurationImportListener());
    factories.add(AutoConfigurationImportFilter.class, () -> org.springframework.boot.autoconfigure.condition._FactoryProvider.onBeanCondition());
    factories.add(AutoConfigurationImportFilter.class, () -> org.springframework.boot.autoconfigure.condition._FactoryProvider.onClassCondition());
    factories.add(AutoConfigurationImportFilter.class, () -> org.springframework.boot.autoconfigure.condition._FactoryProvider.onWebApplicationCondition());
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.aop.AopAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.jdbc.JndiDataSourceAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.availability.ApplicationAvailabilityAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration");
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.autoconfigure.data.redis._FactoryProvider.redisUrlSyntaxFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.autoconfigure.diagnostics.analyzer._FactoryProvider.noSuchBeanDefinitionFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.autoconfigure.flyway._FactoryProvider.flywayMigrationScriptMissingFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.autoconfigure.jdbc._FactoryProvider.dataSourceBeanCreationFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.autoconfigure.jdbc._FactoryProvider.hikariDriverConfigurationFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.autoconfigure.r2dbc._FactoryProvider.connectionFactoryBeanCreationFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.autoconfigure.session._FactoryProvider.nonUniqueSessionRepositoryFailureAnalyzer());
    factories.add(DependsOnDatabaseInitializationDetector.class, () -> org.springframework.boot.autoconfigure.batch._FactoryProvider.jobRepositoryDependsOnDatabaseInitializationDetector());
    factories.add(DependsOnDatabaseInitializationDetector.class, () -> org.springframework.boot.autoconfigure.quartz._FactoryProvider.schedulerDependsOnDatabaseInitializationDetector());
    factories.add(DependsOnDatabaseInitializationDetector.class, () -> org.springframework.boot.autoconfigure.session._FactoryProvider.jdbcIndexedSessionRepositoryDependsOnDatabaseInitializationDetector());
    factories.add(DatabaseInitializerDetector.class, () -> org.springframework.boot.autoconfigure.flyway._FactoryProvider.flywayMigrationInitializerDatabaseInitializerDetector());
    factories.add(ApplicationContextInitializer.class, () -> org.springframework.boot.autoconfigure._FactoryProvider.sharedMetadataReaderFactoryContextInitializer());
    factories.add(org.springframework.context.ApplicationContextInitializer.class, () -> new org.springframework.boot.autoconfigure.logging.ConditionEvaluationReportLoggingListener());
    factories.add(EnvironmentPostProcessor.class, () -> org.springframework.boot.autoconfigure.integration._FactoryProvider.integrationPropertiesEnvironmentPostProcessor());
    factories.add(org.springframework.test.context.TestExecutionListener.class, () -> new org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener());
    factories.add(org.springframework.test.context.TestExecutionListener.class, () -> new org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener());
    factories.add(ContextCustomizerFactory.class, () -> org.springframework.boot.test.context._FactoryProvider.importsContextCustomizerFactory());
    factories.add(ContextCustomizerFactory.class, () -> org.springframework.boot.test.context.filter._FactoryProvider.excludeFilterContextCustomizerFactory());
    factories.add(ContextCustomizerFactory.class, () -> org.springframework.boot.test.json._FactoryProvider.duplicateJsonObjectContextCustomizerFactory());
    factories.add(ContextCustomizerFactory.class, () -> org.springframework.boot.test.mock.mockito._FactoryProvider.mockitoContextCustomizerFactory());
    factories.add(ContextCustomizerFactory.class, () -> org.springframework.boot.test.web.client._FactoryProvider.testRestTemplateContextCustomizerFactory());
    factories.add(ContextCustomizerFactory.class, () -> org.springframework.boot.test.web.reactive.server._FactoryProvider.webTestClientContextCustomizerFactory());
    factories.add(EnvironmentPostProcessor.class, () -> org.springframework.boot.test.web._FactoryProvider.springBootTestRandomPortEnvironmentPostProcessor());
    names.add(AutoConfigureDataR2dbc.class, "org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration");
    names.add(AutoConfigureDataR2dbc.class, "org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration");
    names.add(AutoConfigureWebMvc.class, "org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration");
    names.add(AutoConfigureWebMvc.class, "org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration");
    names.add(AutoConfigureWebMvc.class, "org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration");
    names.add(AutoConfigureWebMvc.class, "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration");
    names.add(AutoConfigureWebMvc.class, "org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration");
    names.add(AutoConfigureWebMvc.class, "org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration");
    names.add(AutoConfigureWebMvc.class, "org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration");
    names.add(AutoConfigureWebMvc.class, "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration");
    names.add(AutoConfigureDataJpa.class, "org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration");
    names.add(AutoConfigureDataJpa.class, "org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration");
    names.add(AutoConfigureDataJpa.class, "org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration");
    names.add(AutoConfigureDataJpa.class, "org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration");
    names.add(AutoConfigureDataJpa.class, "org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration");
    names.add(AutoConfigureDataJpa.class, "org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration");
    names.add(AutoConfigureDataJpa.class, "org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration");
    names.add(AutoConfigureJooq.class, "org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration");
    names.add(AutoConfigureJooq.class, "org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration");
    names.add(AutoConfigureJooq.class, "org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration");
    names.add(AutoConfigureJooq.class, "org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration");
    factories.add(org.springframework.test.context.TestExecutionListener.class, () -> new org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener());
    factories.add(TestExecutionListener.class, () -> org.springframework.boot.test.autoconfigure.web.client._FactoryProvider.mockRestServiceServerResetTestExecutionListener());
    factories.add(TestExecutionListener.class, () -> org.springframework.boot.test.autoconfigure.web.servlet._FactoryProvider.mockMvcPrintOnlyOnFailureTestExecutionListener());
    factories.add(TestExecutionListener.class, () -> org.springframework.boot.test.autoconfigure.web.servlet._FactoryProvider.webDriverTestExecutionListener());
    factories.add(org.springframework.test.context.TestExecutionListener.class, () -> new org.springframework.boot.test.autoconfigure.webservices.client.MockWebServiceServerTestExecutionListener());
    names.add(AutoConfigureJson.class, "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration");
    names.add(AutoConfigureTestEntityManager.class, "org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManagerAutoConfiguration");
    names.add(AutoConfigureCache.class, "org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration");
    names.add(AutoConfigureDataMongo.class, "org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration");
    names.add(AutoConfigureMockRestServiceServer.class, "org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerAutoConfiguration");
    names.add(AutoConfigureDataJdbc.class, "org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration");
    names.add(AutoConfigureDataJdbc.class, "org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration");
    names.add(AutoConfigureDataJdbc.class, "org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration");
    names.add(AutoConfigureDataJdbc.class, "org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration");
    names.add(AutoConfigureDataJdbc.class, "org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration");
    names.add(AutoConfigureRestDocs.class, "org.springframework.boot.test.autoconfigure.restdocs.RestDocsAutoConfiguration");
    names.add(AutoConfigureWebClient.class, "org.springframework.boot.test.autoconfigure.web.client.WebClientRestTemplateAutoConfiguration");
    names.add(AutoConfigureWebClient.class, "org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration");
    names.add(AutoConfigureWebClient.class, "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration");
    names.add(AutoConfigureWebClient.class, "org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration");
    factories.add(ContextCustomizerFactory.class, () -> org.springframework.boot.test.autoconfigure._FactoryProvider.overrideAutoConfigurationContextCustomizerFactory());
    factories.add(ContextCustomizerFactory.class, () -> org.springframework.boot.test.autoconfigure.actuate.metrics._FactoryProvider.metricsExportContextCustomizerFactory());
    factories.add(ContextCustomizerFactory.class, () -> org.springframework.boot.test.autoconfigure.filter._FactoryProvider.typeExcludeFiltersContextCustomizerFactory());
    factories.add(ContextCustomizerFactory.class, () -> org.springframework.boot.test.autoconfigure.properties._FactoryProvider.propertyMappingContextCustomizerFactory());
    factories.add(ContextCustomizerFactory.class, () -> org.springframework.boot.test.autoconfigure.web.servlet._FactoryProvider.webDriverContextCustomizerFactory());
    names.add(AutoConfigureJsonTesters.class, "org.springframework.boot.test.autoconfigure.json.JsonTestersAutoConfiguration");
    names.add(AutoConfigureJsonTesters.class, "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration");
    names.add(AutoConfigureMockMvc.class, "org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration");
    names.add(AutoConfigureTestDatabase.class, "org.springframework.boot.test.autoconfigure.jdbc.TestDatabaseAutoConfiguration");
    names.add(AutoConfigureTestDatabase.class, "org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration");
    names.add(AutoConfigureDataNeo4j.class, "org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration");
    names.add(AutoConfigureJdbc.class, "org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration");
    names.add(AutoConfigureJdbc.class, "org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration");
    names.add(AutoConfigureJdbc.class, "org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration");
    names.add(AutoConfigureJdbc.class, "org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration");
    names.add(AutoConfigureJdbc.class, "org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration");
    names.add(AutoConfigureWebFlux.class, "org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration");
    factories.add(DefaultTestExecutionListenersPostProcessor.class, () -> org.springframework.boot.test.autoconfigure._FactoryProvider.springBootDependencyInjectionTestExecutionListenerPostProcessor());
    factories.add(org.springframework.test.context.TestExecutionListener.class, () -> new org.springframework.test.context.web.ServletTestExecutionListener());
    factories.add(org.springframework.test.context.TestExecutionListener.class, () -> new org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener());
    factories.add(org.springframework.test.context.TestExecutionListener.class, () -> new org.springframework.test.context.event.ApplicationEventsTestExecutionListener());
    factories.add(org.springframework.test.context.TestExecutionListener.class, () -> new org.springframework.test.context.support.DependencyInjectionTestExecutionListener());
    factories.add(org.springframework.test.context.TestExecutionListener.class, () -> new org.springframework.test.context.support.DirtiesContextTestExecutionListener());
    factories.add(org.springframework.test.context.TestExecutionListener.class, () -> new org.springframework.test.context.transaction.TransactionalTestExecutionListener());
    factories.add(org.springframework.test.context.TestExecutionListener.class, () -> new org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener());
    factories.add(org.springframework.test.context.TestExecutionListener.class, () -> new org.springframework.test.context.event.EventPublishingTestExecutionListener());
    factories.add(ContextCustomizerFactory.class, () -> org.springframework.test.context.web.socket._FactoryProvider.mockServerContainerContextCustomizerFactory());
    factories.add(ContextCustomizerFactory.class, () -> org.springframework.test.context.support._FactoryProvider.dynamicPropertiesContextCustomizerFactory());
    factories.add(org.springframework.boot.diagnostics.FailureAnalyzer.class, () -> new org.springframework.nativex.GeneratedClassNotFoundExceptionFailureAnalyzer());
    factories.add(org.springframework.boot.diagnostics.FailureAnalyzer.class, () -> new org.springframework.nativex.ClassNotFoundExceptionNativeFailureAnalyzer());
    factories.add(org.springframework.boot.diagnostics.FailureAnalyzer.class, () -> new org.springframework.nativex.NoSuchMethodExceptionNativeFailureAnalyzer());
    factories.add(org.springframework.context.ApplicationListener.class, () -> new org.springframework.nativex.NativeListener());
  }
}
