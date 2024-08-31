/*
 * Copyright (c) 2012-2024 Savoir Technologies, Inc.
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
package com.savoir.apache.karaf.ai.gateway.itests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.PerClass;

import org.apache.karaf.itests.KarafTestSupport;


@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
public class DemoTest extends KarafTestSupport {

    @Test
    public void demoAvailable() throws Exception {
        addFeaturesRepository("mvn:com.savoir/application-features-file/1.0.0-SNAPSHOT/xml/features");

        installAndAssertFeature("application-all-demo");

        assertFeatureInstalled("application-all-demo");

        //assertBundleInstalled("application-api");
        //assertBundleInstalled("application-spi");
        //assertBundleInstalled("application-impl");
        //assertBundleInstalled("application-plugins");
    }
}
