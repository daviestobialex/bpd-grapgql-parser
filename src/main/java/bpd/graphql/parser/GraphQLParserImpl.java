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
package bpd.graphql.parser;

import bpd.graphql.annotations.GraphQLRequestOperation;
import bpd.graphql.annotations.GraphQLRequestParameters;
import bpd.graphql.annotations.GraphQLRequestResponse;
import bpd.graphql.converter.GraphQLParser;
import bpd.graphql.exception.GraphQLParserException;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;

/**
 *
 * @author davies tobi alex
 */
public class GraphQLParserImpl implements GraphQLParser {

    private GraphQLWriter jsonWriter;

    private StringWriter writer;

    public GraphQLParserImpl(GraphQLWriter jsonWriter, StringWriter writer) {
        this.jsonWriter = jsonWriter;
        this.writer = writer;
    }

    public GraphQLParserImpl() {
        writer = new StringWriter();
        jsonWriter = new GraphQLWriter(writer);
    }

    /**
     * Converts a Class Object type to graphQL String
     *
     * @param <T>
     * @param object
     * @return
     * @throws Exception
     */
    @Override
    public <T> String toString(T object) throws GraphQLParserException, IOException, IllegalArgumentException, IllegalAccessException {

        for (Field f : object.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            for (Annotation a : f.getAnnotations()) {

                if (f.getAnnotation(GraphQLRequestOperation.class) != null) {
                    toGraphQLString(f, 0, object);
                } else if (f.getAnnotation(GraphQLRequestParameters.class) != null) {
                    toGraphQLString(f, 1, object);
                } else if (f.getAnnotation(GraphQLRequestResponse.class) != null) {
                    toGraphQLString(f, 2, object);
                } else {
                    throw new GraphQLParserException("Class not annotated properly,can not parse object.");
                }
            }

        }
        System.out.println("============ TESTING DONE ============");
        System.out.println(writer.toString());
        System.out.println("============ TESTING DONE ============");
        return writer.toString();
    }

    /**
     *
     * @param src
     * @param part
     * @param object
     * @throws IOException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    private void toGraphQLString(Field src, int part, Object object) throws IOException, IllegalArgumentException, IllegalAccessException {

        jsonWriter.beginObject();
        switch (part) {
            case 0:
                jsonWriter.writeOperationName((String) src.get(object));
                break;
            case 1:
                jsonWriter.writeParameters((Map<String, Object>) src.get(object));
                break;
            case 2:
                jsonWriter.responseExected((Map<String, Object>) src.get(object));
                jsonWriter.endObject();
                break;
            default:
                throw new GraphQLParserException("Class not annotated properly,can not parse object.");
        }

    }

    public <T> T parse(String query) {

        return null;
    }
}
