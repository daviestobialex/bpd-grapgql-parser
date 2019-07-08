/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpd.graphql.converter;

import bpd.graphql.exception.GraphQLParserException;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 *
 * @author ailori
 */
public interface GraphQLParser {

    /**
     * Converts a Class Object type to graphQL String
     *
     * @param <T>
     * @param object
     * @return
     * @throws GraphQLParserException
     */
    public <T> String toString(T object) throws GraphQLParserException, IOException, IllegalArgumentException, IllegalAccessException;
}
