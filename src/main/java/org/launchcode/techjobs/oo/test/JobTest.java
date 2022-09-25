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
    Job job1, job2;
  @Before
  public void createJob(){
      job1 = new Job("Job1", new Employer("Ben's Fish Shack"), new Location("St. Louis"), new PositionType("Super Cook!"), new CoreCompetency("Cooking"));
      job2 = new Job();

  }

        @Test //debugged and realized they oth equaled nul to they were euqlling echother so i need to create the jobs becasue currently they were created as null
    public void testSettingJobId() {
        assertNotEquals(job1, job2);
    }

}

