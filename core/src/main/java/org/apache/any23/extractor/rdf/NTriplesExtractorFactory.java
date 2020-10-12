/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.any23.extractor.rdf;

import java.util.Arrays;

import org.apache.any23.extractor.ExtractorDescription;
import org.apache.any23.extractor.ExtractorFactory;
import org.apache.any23.extractor.SimpleExtractorFactory;
import org.apache.any23.rdf.Prefixes;

/**
 * @author Peter Ansell p_ansell@yahoo.com
 *
 */
public class NTriplesExtractorFactory extends SimpleExtractorFactory<NTriplesExtractor>
        implements ExtractorFactory<NTriplesExtractor> {

    public static final String NAME = "rdf-nt";

    public static final Prefixes PREFIXES = null;

    private static final ExtractorDescription descriptionInstance = new NTriplesExtractorFactory();

    public NTriplesExtractorFactory() {
        super(NTriplesExtractorFactory.NAME, NTriplesExtractorFactory.PREFIXES, Arrays
                .asList("application/n-triples;q=0.1", "text/nt;q=0.1", "text/ntriples;q=0.1", "text/plain;q=0.1"),
                "example-ntriples.nt");
    }

    @Override
    public NTriplesExtractor createExtractor() {
        return new NTriplesExtractor();
    }

    public static ExtractorDescription getDescriptionInstance() {
        return descriptionInstance;
    }
}
