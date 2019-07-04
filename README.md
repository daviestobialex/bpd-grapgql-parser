
# bpd-grapgql-parser

>`version 0.0.1`

***This Project is a java library designed to parse an object class to a graphQL string and parse a graphQL string to a GraphQLAnnotatedRequest class***

The library is still in developement

### How to use :

```
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("pageNumber", 1);
        parameters.put("numberOfRecords", 3);

        Map<String, Object> expectedResponses = new HashMap<>();
        expectedResponses.put("responseCode", null);
        expectedResponses.put("groups", null);

        GraphQLAnnotationRequest req = new GraphQLAnnotationRequest("getAllPageable", parameters, expectedResponses);

        GraphQLParser p = new GraphQLParser();

        try {
            p.toString(req);
        } catch (Exception ex) {
        }
```

String RESULT : `{getAllPageable(pageNumber:1,numberOfRecords:3){groups responseCode}}`
