package org.matsim.parallel;

import mpi.MPI;
import mpi.MPIException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MPIHelloWorld {

    private static final Logger log = LogManager.getLogger(MPIHelloWorld.class);

    public static void main(String[] args) throws MPIException {

        log.info("Starting MPIHelloWorld!!!!");

        MPI.Init(args);

        int myrank = MPI.COMM_WORLD.getRank();
        int size = MPI.COMM_WORLD.getSize() ;
        System.out.println("Hello world from rank " + myrank + " of " + size);

        MPI.Finalize();


    }
}