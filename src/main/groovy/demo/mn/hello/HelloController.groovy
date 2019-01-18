package demo.mn.hello

import groovy.transform.CompileStatic
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

import javax.annotation.Nullable
import javax.inject.Inject

@CompileStatic
@Controller("/hello")
class HelloController {

    @Inject
    HelloService helloService

    @Get("{/name}")
    @Produces(MediaType.TEXT_PLAIN)
    String index(@Nullable String name) {
        String displayName = name ? helloService.capitalizeWords(name) : 'World'

        "Hello $displayName"
    }
}
