/*******************************************************************************
 * Copyright (c) 2021 Handy Tools for Distributed Computing (HanDist) project.
 *
 * This program and the accompanying materials are made available to you under
 * the terms of the Eclipse Public License 1.0 which accompanies this
 * distribution,
 * and is available at https://www.eclipse.org/legal/epl-v10.html
 *
 * SPDX-License-Identifier: EPL-1.0
 ******************************************************************************/
package handist.mpijunit;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

import org.junit.runner.Runner;
import org.junit.runners.Parameterized;
import org.junit.runners.Suite;

public class DoParameterizedJunitTest {

    public static void main(String[] args) throws Throwable {
        // Obtain the class to test as an argument
        // Obtain the class to test given as an argument
        final Class<?> testClass = Class.forName(args[0]);
        final int configurationIndex = Integer.parseInt(args[1]);

        // Create a Parameterized runner to extract the specific block runner we want to run
        Parameterized runner = new Parameterized(testClass);

        // Code below allows us to extract the successive "Runner" instances
        // prepared by Parameterized. They are in member "runners" of the parent
        // class Suite. 
        Field runnersField = Suite.class.getDeclaredField("runners");
        runnersField.setAccessible(true);
        @SuppressWarnings("unchecked")
        Runner runnerForSpecifiedConfig = ((List<Runner>) runnersField.get(runner)).get(configurationIndex);
        final String notificationFileName = testClass.getCanonicalName() + "_" + configurationIndex + "_0";

        String directory = null;
        if (args.length > 2) {
            directory = args[2];
        }
        final File f = new File(directory, notificationFileName);

        final ToFileRunNotifier notifier = new ToFileRunNotifier(f);
        runnerForSpecifiedConfig.run(notifier);
        notifier.close();
    }
}
