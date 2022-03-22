package debug;

import mpi.MPI;
import mpi.MPIException;
import org.apache.logging.log4j.LogManager;

import java.util.UUID;

public class LoggerExample {

    public static void main(String[] args) throws MPIException {

        MPI.Init(args);

        var logger = LogManager.getLogger(LoggerExample.class);

        for (int i = 0; i < 10000; i++) {
            var uuid = UUID.randomUUID().toString();
            logger.info(uuid);
        }

        MPI.Finalize();

    }
}
