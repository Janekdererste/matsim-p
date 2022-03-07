package org.matsim.parallel;

import mpi.MPI;
import mpi.MPIException;

public class RunMinimalMPIExample {

    public static void main(String[] args) throws MPIException {

        MPI.Init(args);



        MPI.Finalize();
    }
}
