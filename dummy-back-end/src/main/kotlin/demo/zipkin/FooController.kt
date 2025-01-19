package demo.zipkin

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import org.springframework.web.reactive.function.client.toEntity


@RestController
class FooController(
    // The auto-configured builder is configured to propagates trace ID to outbound requests
    webClientBuilder: WebClient.Builder,
    @Value("\${backend.endpoint:http://httpbin.org/}") backendEndpoint: String) {

    val webClient: WebClient = webClientBuilder.baseUrl(backendEndpoint).build()


    @GetMapping("/foo")
    suspend fun foo(): String {
        return webClient.get().uri("").retrieve().awaitBody()
    }
}