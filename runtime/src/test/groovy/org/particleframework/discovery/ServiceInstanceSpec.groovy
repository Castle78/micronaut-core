/*
 * Copyright 2018 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.particleframework.discovery

import org.particleframework.http.HttpHeaders
import spock.lang.Specification

/**
 * @author graemerocher
 * @since 1.0
 */
class ServiceInstanceSpec extends Specification {

    void "test build service instance with authentication information"() {
        when:
        ServiceInstance instance = ServiceInstance.builder("test", URI.create("http://myuser:123@localhost:8888"))
                                                  .metadata(foo:'bar').build()

        then:
        instance.URI == URI.create("http://localhost:8888")
        instance.metadata.get(HttpHeaders.AUTHORIZATION_INFO, String).isPresent()
        instance.metadata.get(HttpHeaders.AUTHORIZATION_INFO, String).get() == 'myuser:123'
    }
}