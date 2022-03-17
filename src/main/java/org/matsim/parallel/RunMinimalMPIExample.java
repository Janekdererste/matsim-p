package org.matsim.parallel;

import mpi.MPI;
import mpi.MPIException;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.AbstractModule;
import org.matsim.core.controler.Controler;
import org.matsim.core.controler.OutputDirectoryHierarchy;
import org.matsim.core.controler.events.AfterMobsimEvent;
import org.matsim.core.controler.listener.AfterMobsimListener;
import org.matsim.core.controler.listener.ControlerListener;
import org.matsim.core.scenario.ScenarioUtils;
import org.matsim.core.utils.io.IOUtils;
import org.matsim.examples.ExamplesUtils;



public class RunMinimalMPIExample {


    public static void main(String[] args) throws MPIException {

        var version = System.getProperty("java.version");
        System.out.println("Java-Version: " + version);

        MPI.Init(args);
        var rank = MPI.COMM_WORLD.getRank();

        System.out.println("before getTestScenario");
        var equil = ExamplesUtils.getTestScenarioURL("equil");
        System.out.println("before load config");
        var config = ConfigUtils.loadConfig(IOUtils.extendUrl(equil, "config.xml"));
        config.qsim().setNumberOfThreads(1);
        config.controler().setOverwriteFileSetting(OutputDirectoryHierarchy.OverwriteFileSetting.deleteDirectoryIfExists);
        config.controler().setOutputDirectory("./output/equil-" + rank);
        config.controler().setLastIteration(100);
        var scenario = ScenarioUtils.loadScenario(config);
        var controler = new Controler(scenario);
        controler.run();

        MPI.Finalize();
    }
}
