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
package de.axelfaust.alfresco.hackathon.cmisserver.repo.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.alfresco.util.ParameterCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * This post processor is designed to allow us to remove a configurable list of beans that should not be instantiated in a reduced Alfresco
 * Repository. This is a bean definition registry post processor variant of the almost identical
 * {@link BeanDefinitionRemovingFactoryPostProcessor} - using this class instead of the other allows for removing beans that are themselves
 * Spring listeners (and thus initialized before the factory post processor can get to them), but at the cost of not having support for
 * property value placeholder substitution applied to the configuration of this post processor.
 *
 * @author Axel Faust
 */
public class BeanDefinitionRemovingRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor
{

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanDefinitionRemovingRegistryPostProcessor.class);

    protected List<String> beanNames = Collections.emptyList();

    public void setBeanNamesToRemove(final List<String> names)
    {
        ParameterCheck.mandatoryCollection("names", names);

        this.beanNames = new ArrayList<String>(names);
    }

    @Override
    public void postProcessBeanDefinitionRegistry(final BeanDefinitionRegistry registry) throws BeansException
    {
        for (final String beanName : this.beanNames)
        {
            if (registry.containsBeanDefinition(beanName))
            {
                LOGGER.info("Removing configured bean {}", beanName);
                registry.removeBeanDefinition(beanName);
            }
            else if (registry.isAlias(beanName))
            {
                registry.removeAlias(beanName);
            }
            else
            {
                LOGGER.debug("Bean registry {} does not contain bean definition for {}", registry, beanName);
            }
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void postProcessBeanFactory(final ConfigurableListableBeanFactory beanFactory) throws BeansException
    {
        if (beanFactory instanceof BeanDefinitionRegistry)
        {
            this.postProcessBeanDefinitionRegistry((BeanDefinitionRegistry) beanFactory);
        }
    }
}
