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
package bpd.graphql.config;

/**
 *
 * @author ailori
 */
public class GraphQLScope {

    /**
     * An array with no elements requires no separators or newlines before it is
     * closed.
     */
    protected static final int EMPTY_ARRAY = 1;

    /**
     * A array with at least one value requires a comma and newline before the
     * next element.
     */
    protected static final int NONEMPTY_ARRAY = 2;

    /**
     * An object with no name/value pairs requires no separators or newlines
     * before it is closed.
     */
    protected static final int EMPTY_OBJECT = 3;

    /**
     * An object whose most recent element is a key. The next element must be a
     * value.
     */
    protected static final int DANGLING_NAME = 4;

    /**
     * An object with at least one name/value pair requires a comma and newline
     * before the next element.
     */
    protected static final int NONEMPTY_OBJECT = 5;

    /**
     * No object or array has been started.
     */
    protected static final int EMPTY_DOCUMENT = 6;

    /**
     * A document with at an array or object.
     */
    protected static final int NONEMPTY_DOCUMENT = 7;

    /**
     * A document that's been closed and cannot be accessed.
     */
    protected static final int CLOSED = 8;

    /**
     * A document with operational parameters
     */
    protected static final int PARAMETERS = 9;

    /**
     * A document with operational parameters
     */
    protected static final int NONPARAMETERS = 10;
}
