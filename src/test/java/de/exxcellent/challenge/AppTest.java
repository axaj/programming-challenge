package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picocli.CommandLine;

/**
 * Example JUnit 5 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {
    private App myApp;
    private CommandLine cmd;
    private StringWriter sw;

    @BeforeEach
    void setUp() {
        myApp = new App();
        cmd = new CommandLine(myApp);
        sw = new StringWriter();
        cmd.setOut(new PrintWriter(sw));
    }

    @Test
    void runWeather() {
        int exitCode = cmd.execute("--weather", "weather.csv");
        assertEquals(CommandLine.ExitCode.OK, exitCode);
        assertEquals("14", sw.toString());
    }

    @Test
    void runFootball() {
        int exitCode = cmd.execute("--football", "football.csv");
        assertEquals(CommandLine.ExitCode.OK, exitCode);
        assertEquals("Aston_Villa", sw.toString());
    }

    @Test
    void runWeatherAndFootball() {
        int exitCode = cmd.execute("--weather", "--football", "weather.csv", "football.csv");
        assertEquals(CommandLine.ExitCode.USAGE, exitCode);
    }

    @Test
    void noArgumentsRun() {
        int exitCode = cmd.execute();
        assertEquals(CommandLine.ExitCode.USAGE, exitCode);
    }

    // TODO: Improve this behaviour, should probably use CommandLine.ExitCode.SOFTWARE to signal error here
    @Test
    void wrongFileName() {
        int exitCode = cmd.execute("--weather", "wwweather.csv");
        assertEquals(CommandLine.ExitCode.OK, exitCode);
    }

    @Test
    void analyzeWeatherTest() {
        assertEquals("14", App.analyze(new File("weather.csv"), ContentType.WEATHER));
    }
    
    @Test
    void analyzeFootballTest() {
        assertEquals("Aston_Villa", App.analyze(new File("football.csv"), ContentType.FOOTBALL));
    }

}