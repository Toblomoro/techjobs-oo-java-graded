package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    Job job1, job2, job3, job4, jobTest
            ;


    @Before
    public void createJob() {
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester",new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        job4 = new Job("Product tester",new Employer("ACME"),
                new Location(""), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

    }


//    public void testSettingJobId() {
//        assertEquals(false, job1.equals(job2));
//    }


        //@Test //debugged and realized they oth equaled nul to they were euqlling echother so i need to create the jobs becasue currently they were created as null
    @Test
    public void testSettingJobId() {
        job1 = new Job();
        job2 = new Job();
        assertEquals(false, job1.equals(job2));


    }
    @Test
    public void testJobsForEquality() {
        assertFalse(job3 == job4);
    }
//    assertNotEquals(job1.getId(), job2.getId());

    @Test
    public void testJobConstructorSetsAllFields() {
        jobTest = new Job("Product tester",new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals("Product tester", jobTest.getName());
        assertEquals("ACME", jobTest.getEmployer().getValue());
        assertEquals("Desert", jobTest.getLocation().getValue());
        assertEquals("Quality control", jobTest.getPositionType().getValue());
        assertEquals("Persistence", jobTest.getCoreCompetency().getValue());

        assertTrue(jobTest.getName() instanceof String);
        assertTrue(jobTest.getEmployer() instanceof Employer);
        assertTrue(jobTest.getLocation() instanceof Location);
        assertTrue(jobTest.getPositionType() instanceof PositionType);
        assertTrue(jobTest.getCoreCompetency() instanceof CoreCompetency);

        //Add assertTrue for 5 more to test data type 'instance of'
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        jobTest = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals("\n" + "\n",
                jobTest.toString().substring(0, 1) +
                        jobTest.toString().substring(jobTest.toString().length() - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        jobTest = new Job("Product tester",new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals('\n' + "ID: " + jobTest.getId() +
                '\n' + "Name: " + jobTest.getName() +
                '\n' + "Employer: " + jobTest.getEmployer() +
                '\n' + "Location: " + jobTest.getLocation() +
                '\n' + "Position Type: " + jobTest.getPositionType() +
                '\n' + "Core Competency: " + jobTest.getCoreCompetency() +
                '\n', jobTest.toString() );
    }
@Test
    public void testToStringHandlesEmptyField(){
    jobTest = new Job("Product tester",new Employer("ACME"),
            new Location(""), new PositionType("Quality control"),
            new CoreCompetency("Persistence"));

    String testString = jobTest.toString();
    assertTrue(testString.contains("Data not available")); //Took forever to realize i didnt have a capital A in avalable........
}
}



