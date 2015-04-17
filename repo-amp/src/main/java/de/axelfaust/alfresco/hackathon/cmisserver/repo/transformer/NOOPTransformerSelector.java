/*
 * Copyright 2015 Axel Faust
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 *
 * https://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package de.axelfaust.alfresco.hackathon.cmisserver.repo.transformer;

import java.util.Collections;
import java.util.List;

import org.alfresco.repo.content.transform.ContentTransformer;
import org.alfresco.repo.content.transform.TransformerSelector;
import org.alfresco.service.cmr.repository.TransformationOptions;

/**
 * @author Axel Faust
 */
public class NOOPTransformerSelector implements TransformerSelector
{

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ContentTransformer> selectTransformers(final String sourceMimetype, final long sourceSize, final String targetMimetype,
            final TransformationOptions options)
    {
        // NO-OP
        return Collections.emptyList();
    }

}
