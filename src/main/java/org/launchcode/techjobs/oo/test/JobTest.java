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




    @Before
    public void createJob() {
       Job job1 = new Job();
        Job job2 = new Job();
        Job job3 = new Job("Product tester",new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        Job job4 = new Job("Product tester",new Employer("ACME"),
                new Location(""), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

    }


//    public void testSettingJobId() {
//        Job job1 = new Job();
//        Job job2 = new Job();
//        assertEquals(false, job1.equals(job2));
//    }


        //@Test //debugged and realized they oth equaled nul to they were euqlling echother so i need to create the jobs becasue currently they were created as null
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertEquals(false, job1.equals(job2));


    }
    @Test
    public void testJobsForEquality() {
        Job job3 = new Job("Product tester",new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        Job job4 = new Job("Product tester",new Employer("ACME"),
                new Location(""), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertFalse(job3 == job4);
    }
//    assertNotEquals(job1.getId(), job2.getId());

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job5 = new Job("Product tester",new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals("Product tester", job5.getName());
        assertEquals("ACME", job5.getEmployer().getValue());
        assertEquals("Desert", job5.getLocation().getValue());
        assertEquals("Quality control", job5.getPositionType().getValue());
        assertEquals("Persistence", job5.getCoreCompetency().getValue());

        assertTrue(job5.getName() instanceof String);
        assertTrue(job5.getEmployer() instanceof Employer);
        assertTrue(job5.getLocation() instanceof Location);
        assertTrue(job5.getPositionType() instanceof PositionType);
        assertTrue(job5.getCoreCompetency() instanceof CoreCompetency);

        //Add assertTrue for 5 more to test data type 'instance of'
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job5 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals("\n" + "\n",
                job5.toString().substring(0, 1) +
                        job5.toString().substring(job5.toString().length() - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
       Job job5 = new Job("Product tester",new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals('\n' + "ID: " + job5.getId() +
                '\n' + "Name: " + job5.getName() +
                '\n' + "Employer: " + job5.getEmployer() +
                '\n' + "Location: " + job5.getLocation() +
                '\n' + "Position Type: " + job5.getPositionType() +
                '\n' + "Core Competency: " + job5.getCoreCompetency() +
                '\n', job5.toString() );
    }
@Test
    public void testToStringHandlesEmptyField(){
    Job job5 = new Job("Product tester",new Employer("ACME"),
            new Location(""), new PositionType("Quality control"),
            new CoreCompetency("Persistence"));

    String testString = job5.toString();
    assertTrue(testString.contains("Data not available")); //Took forever to realize i didnt have a capital A in avalable........
}
}



