package demo.mn.hello

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class HelloControllerSpec extends Specification {

    @Shared
    @AutoCleanup
    EmbeddedServer server = ApplicationContext.run(EmbeddedServer)

    @Shared
    @AutoCleanup
    HttpClient client = HttpClient.create(server.URL)

    @Unroll("Endpoint #endpoint returns correct response")
    void "Test endpoint /hello"() {
        when: "Calling the endpoint"
            String response = client.toBlocking().retrieve(endpoint)

        then: "Response is correct"
            response == expectedResponse

        where:
            endpoint            |expectedResponse
            '/hello'            |'Hello World'
            '/hello/John'       |'Hello John'
            '/hello/john%20doe' |'Hello John Doe'
    }
}
