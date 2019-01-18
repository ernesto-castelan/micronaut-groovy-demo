package demo.mn.hello

import javax.inject.Singleton

@Singleton
class HelloService {

    String capitalizeWords(String name) {
        name.split()*.capitalize().join(' ')
    }
}
