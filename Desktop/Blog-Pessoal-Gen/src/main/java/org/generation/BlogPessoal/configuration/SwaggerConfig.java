package org.generation.BlogPessoal.configuration;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI springBlogPessoalOpenAPI () {
		return new OpenAPI()
					.info(new Info()
						.title ("Blog Pessoal")
						.description ("Blog Pessoal - Otavio Tonello")
						.version ("v0.0.1")
						.license(new License()
								.name("Generation Brasil")
								.url("http://brazil.generation.org/"))
						.contact (new Contact()
								.name("Otavio Tonello")
								.url("https://github.com/otaviotonello")
								.email("otaviotonello0102@gmail.com")))
					.externalDocs (new ExternalDocumentation()
							.description("GitHub")
							.url("https://github.com/otaviotonello/Blog-Pessoal-Gen-"));
	}
	
	@Bean
	public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser () {
		return OpenApiCustomiser -> {
			OpenApiCustomiser.getPaths().values().forEach(PathItem -> PathItem.readOperations().forEach(operation -> {
				
				ApiResponses apiResponses = operation.getResponses();
				
				apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
				apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
				apiResponses.addApiResponse("204", createApiResponse("Objeto Excluído!"));
				apiResponses.addApiResponse("400", createApiResponse("Erro na Requisição!"));
				apiResponses.addApiResponse("401", createApiResponse("Acesso Não Autorizado!"));
				apiResponses.addApiResponse("404", createApiResponse("Objeto Não Encontrado!"));
				apiResponses.addApiResponse("500", createApiResponse("Erro na Aplicação!"));
			}));
		};
	}

	private ApiResponse createApiResponse (String message) {
		return new ApiResponse().description(message); 
	}
}
