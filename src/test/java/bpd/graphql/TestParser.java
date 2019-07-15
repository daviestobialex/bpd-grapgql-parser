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
package bpd.graphql;

import bpd.graphql.parser.GraphQueryParser;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author ailori
 */
@RunWith(SpringRunner.class)
public class TestParser {

    @Test
    public void convertTographQLTestString() {

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("email", "dav@mail.com");

        Map<String, Object> expectedResponses = new HashMap<>();
        expectedResponses.put("responseCode", null);
        expectedResponses.put("responseDescription", null);
        expectedResponses.put("id", null);

        GraphQLAnnotationRequest req = new GraphQLAnnotationRequest("getCommuterInfo", parameters, expectedResponses);

        GraphQueryParser p = new GraphQueryParser();

        try {
            System.out.println(p.toString(req));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(TestParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void convertTographQLTestPojo() {
        String response = "{\n"
                + "    \"data\": {\n"
                + "        \"getAllPagable\": {\n"
                + "            \"responseCode\": \"97\",\n"
                + "            \"groups\": null\n"
                + "        }\n"
                + "    }\n"
                + "}";

        GraphQueryParser p = new GraphQueryParser();

        try {
            System.out.println(" ======= GETTING QUERY DATA ====== ");
            BaseResponse parse = p.parse(response, "getAllPagable", BaseResponse.class);
            System.out.println(" ======= " + parse.getResponseCode() + " ====== ");
        } catch (JSONException ex) {
            Logger.getLogger(TestParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
