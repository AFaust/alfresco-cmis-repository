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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.alfresco.util.ParameterCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;

/**
 * This post processor is designed to allow us to remove a configurable list of beans that should not be instantiated in a reduced Alfresco
 * Repository.
 *
 * @author Axel Faust
 */
public class BeanDefinitionRemovingFactoryPostProcessor implements BeanFactoryPostProcessor
{

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanDefinitionRemovingFactoryPostProcessor.class);

    protected List<String> beanNames = Collections.emptyList();

    public void setBeanNamesToRemove(final String names)
    {
        ParameterCheck.mandatoryString("names", names);

        this.beanNames = Arrays.asList(names.split(","));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void postProcessBeanFactory(final ConfigurableListableBeanFactory beanFactory) throws BeansException
    {
        if (beanFactory instanceof BeanDefinitionRegistry)
        {
            for (final String beanName : this.beanNames)
            {
                if (((BeanDefinitionRegistry) beanFactory).containsBeanDefinition(beanName))
                {
                    LOGGER.info("Removing configured bean {}", beanName);
                    ((BeanDefinitionRegistry) beanFactory).removeBeanDefinition(beanName);
                }
                else if (((BeanDefinitionRegistry) beanFactory).isAlias(beanName))
                {
                    ((BeanDefinitionRegistry) beanFactory).removeAlias(beanName);
                }
                else
                {
                    LOGGER.debug("Bean factory {} does not contain bean definition for {}", beanFactory, beanName);
                }
            }
        }
    }
}
