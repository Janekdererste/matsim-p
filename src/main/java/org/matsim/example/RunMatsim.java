package org.matsim.example;

import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.Controler;
import org.matsim.core.scenario.ScenarioUtils;
import org.matsim.core.utils.io.IOUtils;
import org.matsim.examples.ExamplesUtils;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class RunMatsim {


    public static void main(String[] args) {

        var equil = ExamplesUtils.getTestScenarioURL("equil");
        var config = ConfigUtils.loadConfig(IOUtils.extendUrl(equil, "config.xml"));
        config.qsim().setNumberOfThreads(1);
        var scenario = ScenarioUtils.loadScenario(config);
        var controler = new Controler(scenario);

        controler.run();
    }
}
