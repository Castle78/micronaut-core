/*
 * Copyright 2017-2019 original authors
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
package io.micronaut.function.client;

import org.reactivestreams.Publisher;

/**
 * An interface for discovery functions, either remote or local.
 *
 * @author graemerocher
 * @since 1.0
 */
public interface FunctionDiscoveryClient {

    /**
     * Finds a function for the given function name.
     *
     * @param functionName The function name
     * @return A {@link Publisher} that emits the {@link java.net.URI} of the function or a {@link io.micronaut.function.client.exceptions.FunctionNotFoundException} if no function is found
     */
    Publisher<FunctionDefinition> getFunction(String functionName);
}
