package handist.mpijunit;

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

import apgas.mpi.MPILauncher;
import handist.collections.dist.TeamedPlaceGroup;

/**
 * This class is used to transparently call the regular {@link MPILauncher} with the main class as {@link DoJunitTest}
 * and the arguments received. It is also responsible for adding the library's plugin to the {@link MPILauncher} before
 * calling it.
 *
 * @author Patrick Finnerty
 *
 */
public class TestLauncher {

    public static void main(String[] args) throws Exception {
        // Insert the desired main in the arguments
        final String[] newArgs = new String[args.length + 1];
        int newIndex = 0;
        int oldIndex = 0;

        // If using MPJ, we put the first three arguments first
        if (args.length > 2) {
            while (newIndex < 3) {
                newArgs[newIndex++] = args[oldIndex++];
            }
        }

        // Place the class whose main we actually want to run
        newArgs[newIndex++] = DoJunitTest.class.getCanonicalName();

        // Put the rest of the arguments
        while (oldIndex < args.length) {
            newArgs[newIndex++] = args[oldIndex++];
        }

        // Call TeamedPlaceGroup setup method to add its plugin to MPILauncher
        TeamedPlaceGroup.setup();

        // Call the MPILauncher with the modified arguments
        MPILauncher.main(newArgs);
    }
}
