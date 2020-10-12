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
package org.apache.any23.vocab;

import org.eclipse.rdf4j.model.IRI;

/**
 * <p>
 * An implementation of the <a href="https://github.com/RinkeHoekstra/lkif-core">lkif-core</a> vocabulary which is a
 * library of ontologies relevant for the legal domain. The library consists of 15 modules, each of which describes a
 * set of closely related concepts from both legal and commonsense domains.
 * </p>
 * 
 * <p>
 * The time module provides an OWL DL implementation of the theory of time by Allen (1984).
 * </p>
 *
 * @author lewismc
 *
 */
public class LKIFCoreTime extends Vocabulary {

    /**
     * The namespace of the vocabulary as a string.
     */
    public static final String NS = "http://www.estrellaproject.org/lkif-core/time.owl#";

    private static LKIFCoreTime instance;

    public static LKIFCoreTime getInstance() {
        if (instance == null) {
            instance = new LKIFCoreTime();
        }
        return instance;
    }

    ///////////////////////////////////////////////////////
    /* http://www.estrellaproject.org/lkif-core/time.owl */
    ///////////////////////////////////////////////////////
    // CLASSES
    public final IRI Interval = createClass(NS, "Interval");
    public final IRI Moment = createClass(NS, "Moment");
    public final IRI Pair_Of_Periods = createClass(NS, "Pair_Of_Periods");
    public final IRI Temporal_Occurrence = createClass(NS, "Temporal_Occurrence");

    // RESOURCES

    // PROPERTIES
    public final IRI after = createProperty(NS, "after");
    public final IRI before = createProperty(NS, "before");
    public final IRI between = createProperty(NS, "between");
    public final IRI during = createProperty(NS, "during");
    public final IRI finishes = createProperty(NS, "finishes");
    public final IRI immediately_after = createProperty(NS, "immediately_after");
    public final IRI immediately_before = createProperty(NS, "immediately_before");
    public final IRI overlap = createProperty(NS, "overlap");
    public final IRI preceeds = createProperty(NS, "preceeds");
    public final IRI starts = createProperty(NS, "starts");
    public final IRI temporal_relation = createProperty(NS, "temporal_relation");

    private LKIFCoreTime() {
        super(NS);
    }

}
