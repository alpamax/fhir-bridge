/*
 * Copyright 2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ehrbase.fhirbridge.ihe.xds;

import org.ehrbase.client.classgenerator.interfaces.CompositionEntity;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.*;
import org.openehealth.ipf.commons.ihe.xds.core.requests.ProvideAndRegisterDocumentSet;
import org.openehealth.ipf.commons.ihe.xds.core.requests.builder.ProvideAndRegisterDocumentSetBuilder;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;

import javax.activation.DataHandler;
import java.util.List;

/**
 * @author Renaud Subiger
 * @since 1.6
 */
// TODO: Check with @SevKohler, if the Exchange is required here. If yes, use TypeConverter from Camel
public class Iti41Converter implements Converter<CompositionEntity, ProvideAndRegisterDocumentSet> {

    @Override
    public ProvideAndRegisterDocumentSet convert(@NonNull CompositionEntity composition) {
        SubmissionSet submissionSet = getSumissionSet();
        List<Folder> folders = getFolders();
        List<Document > documents = getDocuments(composition);
        List< Association > associations = getAssociations();
        ProvideAndRegisterDocumentSetBuilder provideAndRegisterDocumentSetBuilder = new ProvideAndRegisterDocumentSetBuilder(true, new SubmissionSet());
        // TODO: Implement conversion logic
        return provideAndRegisterDocumentSetBuilder.doBuild(submissionSet, folders, documents, associations);

    }
    private SubmissionSet getSumissionSet() {
        SubmissionSet submissionSet = new SubmissionSet();
        return submissionSet;
    }

    private List<Association> getAssociations() {
        Association association = new Association();
        return List.of(association);
    }

    private List<Document> getDocuments(CompositionEntity source) {
        Document document = new Document();
        DataHandler dataHandler = new DataHandler(source, "application/json");
        DocumentEntry documentEntry = new DocumentEntry();
        document.setDataHandler(dataHandler);
      //  document.setDocumentEntry();
        return List.of(document);
    }

    private List<Folder> getFolders() {
        Folder folder = new Folder();
        return List.of(folder);
    }


}
