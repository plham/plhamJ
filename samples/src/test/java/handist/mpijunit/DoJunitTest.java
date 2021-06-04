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

import org.junit.runners.BlockJUnit4ClassRunner;

public class DoJunitTest {

    public static void main(String[] args) throws Exception {
        // Obtain the class to test as an argument
        final Class<?> testClass = Class.forName(args[0]);
        final BlockJUnit4ClassRunner junitDefaultRunner = new BlockJUnit4ClassRunner(testClass);
        final String notificationFileName = testClass.getCanonicalName() + "_0";

        String directory = null;
        if (args.length > 1) {
            directory = args[1];
        }
        final File f = new File(directory, notificationFileName);

        final ToFileRunNotifier notifier = new ToFileRunNotifier(f);
        junitDefaultRunner.run(notifier);
        notifier.close();
    }
}
