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

package org.apache.any23.extractor;

import org.apache.any23.extractor.html.MicroformatExtractor;
import org.eclipse.rdf4j.model.BNode;
import org.eclipse.rdf4j.model.Resource;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * This interface models a specific {@link ExtractionResult} able to collect property roots generated by <i>HTML
 * Microformat</i> extractions.
 *
 * @author Michele Mostarda (mostarda@fbk.eu)
 */
public interface TagSoupExtractionResult extends ExtractionResult {

    /**
     * Adds a root property to the extraction result, specifying also the <i>path</i> corresponding to the root of data
     * which generated the property and the extractor responsible for such addition.
     *
     * @param path
     *            the <i>path</i> from the document root to the local root of the data generating the property.
     * @param root
     *            the property root node.
     * @param extractor
     *            the extractor responsible of such extraction.
     */
    void addResourceRoot(String[] path, Resource root, Class<? extends MicroformatExtractor> extractor);

    /**
     * Returns all the collected property roots.
     *
     * @return an <b>unmodifiable</b> list of {@link TagSoupExtractionResult.ResourceRoot}s.
     */
    List<ResourceRoot> getResourceRoots();

    /**
     * Adds a property path to the list of the extracted data.
     *
     * @param extractor
     *            the identifier of the extractor responsible for retrieving such property.
     * @param propertySubject
     *            the subject of the property.
     * @param property
     *            the property IRI.
     * @param object
     *            the property object if any, <code>null</code> otherwise.
     * @param path
     *            the path of the <i>HTML</i> node from which the property literal has been extracted.
     */
    void addPropertyPath(Class<? extends MicroformatExtractor> extractor, Resource propertySubject, Resource property,
            BNode object, String[] path);

    /**
     * Returns all the collected property paths.
     *
     * @return a valid list of property paths.
     */
    List<PropertyPath> getPropertyPaths();

    /**
     * Defines a property root object.
     */
    class ResourceRoot {
        private String[] path;
        private Resource root;
        private Class<? extends MicroformatExtractor> extractor;

        public ResourceRoot(String[] path, Resource root, Class<? extends MicroformatExtractor> extractor) {
            if (path == null || path.length == 0) {
                throw new IllegalArgumentException(
                        String.format(Locale.ROOT, "Invalid xpath: '%s'.", Arrays.toString(path)));
            }
            if (root == null) {
                throw new IllegalArgumentException("Invalid root, cannot be null.");
            }
            if (extractor == null) {
                throw new IllegalArgumentException("Invalid extractor, cannot ne null");
            }
            this.path = path;
            this.root = root;
            this.extractor = extractor;
        }

        public String[] getPath() {
            return path;
        }

        public Resource getRoot() {
            return root;
        }

        public Class<? extends MicroformatExtractor> getExtractor() {
            return extractor;
        }

        @Override
        public String toString() {
            return String.format(Locale.ROOT, "%s-%s-%s %s", this.getClass().getCanonicalName(), Arrays.toString(path),
                    root, extractor);
        }
    }

    /**
     * Defines a property path object.
     */
    class PropertyPath {

        private Class<? extends MicroformatExtractor> extractor;
        private String[] path;
        private Resource subject;
        private Resource property;
        private BNode object;

        public PropertyPath(String[] path, Resource subject, Resource property, BNode object,
                Class<? extends MicroformatExtractor> extractor) {
            if (path == null) {
                throw new NullPointerException("path cannot be null.");
            }
            if (subject == null) {
                throw new NullPointerException("subject cannot be null.");
            }
            if (property == null) {
                throw new NullPointerException("property cannot be null.");
            }
            if (extractor == null) {
                throw new NullPointerException("extractor cannot be null.");
            }
            this.path = path;
            this.subject = subject;
            this.property = property;
            this.object = object;
            this.extractor = extractor;
        }

        public String[] getPath() {
            return path;
        }

        public Resource getSubject() {
            return subject;
        }

        public Resource getProperty() {
            return property;
        }

        public BNode getObject() {
            return object;
        }

        public Class<? extends MicroformatExtractor> getExtractor() {
            return extractor;
        }

        @Override
        public String toString() {
            return String.format(Locale.ROOT, "%s %s - %s - %s -- %s -->", this.getClass().getCanonicalName(),
                    Arrays.toString(path), extractor, subject, property);
        }
    }

}
