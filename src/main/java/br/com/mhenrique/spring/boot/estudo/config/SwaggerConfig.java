//package br.com.mhenrique.spring.boot.estudo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//	
//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("br.com.mhenrique.spring.boot.estudo.controller"))
//				.paths(PathSelectors.any())
//				.build()
////				.directModelSubstitute(LocalDateTime.class, String.class)
////				.securityContexts(Collections.singletonList(securityContext()))
////				.securitySchemes(apiKey())
//				.apiInfo(apiInfo())
//				;
//		
//		
//}
//	
//	private Appinfo apiInfo() {
//        return new ApiInfoBuilder().title("Manutenção de Usuários")
//                .description("MS para manutenção de Usuários")
////                .version(this.version)
//                .license("Apache License Version 2.0")
//                .licenseUrl("https://www.apache.com/licenses/LICENSE-2.0")
//                .build();
//    }
//}