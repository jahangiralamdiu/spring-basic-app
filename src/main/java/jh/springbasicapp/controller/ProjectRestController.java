package jh.springbasicapp.controller;

import jh.springbasicapp.model.ProjectTask;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BS-113-Jahangir on 3/11/2015.
 */
@Controller
public class ProjectRestController extends BaseController {

    @ResponseBody
    @RequestMapping(value = "/project/{projectName}")
    public List<ProjectTask> getProjectTask(@PathVariable String projectName) {
        List<ProjectTask> projectTasks = new ArrayList<ProjectTask>();

        for (int i = 0; i <= 5; i++) {

            ProjectTask projectTask = new ProjectTask();
            projectTask.setId(1 + i);
            projectTask.setName("Test Task" + i);
            projectTask.setProjectId(1 + i);
            projectTask.setDetails("This is a test details" + i);

            projectTasks.add(projectTask);
        }

        return projectTasks;
    }

}
