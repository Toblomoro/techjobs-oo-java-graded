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
    Job job1, job2, job3, job4;


    @Before
    public void createJobObject() {
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

            assertNotEquals(job1.getId(), job2.getId());

    }
    @Test
    public void testJobsForEquality() {
        assertFalse(job3.equals(job4));
    }

    @Test
    public void testJobConstructorSetsAllFields() {

        assertEquals("Name:", job3.getName());
        assertEquals("ACME", job3.getEmployer().getValue());
        assertEquals("Desert", job3.getLocation().getValue());
        assertEquals("Quality control", job3.getPositionType().getValue());
        assertEquals("Persistence", job3.getCoreCompetency().getValue());
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
String testString = job3.toString();
int length = testString.length();
        assertTrue(testString.substring(1).contains("\n"));
        assertTrue(testString.substring(length-1).contains("\n"));
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        assertEquals("\nID: " + job3.getId() +
                "\nName: " + job3.getName() +
                "\nEmployer: " + job3.getEmployer() +
                "\nLocation: " + job3.getLocation() +
                "\nPosition Type: " + job3.getPositionType() +
                "\nCore Competency: " + job3.getCoreCompetency() +
                "\n", job3.toString());
    }
@Test
    public void testToStringHandlesEmptyField(){
    String testString = job4.toString();
    assertTrue(testString.contains("Data not available")); //Took forever to realize i didnt have a capital A in avalable........
}
}



