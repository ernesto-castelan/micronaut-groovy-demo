package demo.mn.hello

import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification
import spock.lang.Unroll

import javax.inject.Inject

@MicronautTest
class HelloServiceSpec extends Specification {

    @Inject
    HelloService helloService

    @Unroll("capitalizeWords works with string '#name'")
    void "Test capitalizeWords"() {
        expect:
            helloService.capitalizeWords(name) == expectedResult

        where:
            name                |expectedResult
            ''                  |''
            '   '               |''
            'demo'              |'Demo'
            'demo test example' |'Demo Test Example'
            'demo   test'       |'Demo Test'
    }
}
