package bpd.graphql;

import bpd.graphql.annotations.GraphQLRequestOperation;
import bpd.graphql.annotations.GraphQLRequestParameters;
import bpd.graphql.annotations.GraphQLRequestResponse;
import java.util.Collections;
import java.util.Map;

/*
 * Copyright 2019 ailori.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * This is a sample annotation graphQL request which would help build the
 * graphQLRequestpayload to be processed, the intention is to design something
 * similar to the XML annotations used to generate XML string data
 *
 * @author ailori
 */
public class GraphQLAnnotationRequest {

    @GraphQLRequestOperation
    private final String operationName;

    @GraphQLRequestParameters
    private final Map<String, Object> parameters;

    @GraphQLRequestResponse
    private final Map<String, Object> expectedResponses;

    public GraphQLAnnotationRequest(String operationName, Map<String, Object> parameters, Map<String, Object> expectedResponses) {
        this.operationName = operationName;
        this.parameters = parameters != null ? parameters : Collections.emptyMap();;
        this.expectedResponses = expectedResponses != null ? expectedResponses : Collections.emptyMap();;
    }

    public String getOperationName() {
        return operationName;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public Map<String, Object> getExpectedResponses() {
        return expectedResponses;
    }

}
