package com.feedback.feedbackapp.controller;

import com.feedback.feedbackapp.model.CourseFeedBack;
import com.feedback.feedbackapp.model.response.CourseFeedbackResponse;
import com.feedback.feedbackapp.service.CourseFeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/api")
public class CourseFeedBackController {

    private CourseFeedBackService courseFeedBackService;
    private static final Logger LOGGER = Logger.getLogger(CourseFeedBackController.class.getName());

    @Autowired
    public void setCourseFeedBackService(CourseFeedBackService courseFeedBackService) {
        this.courseFeedBackService = courseFeedBackService;
    }


    //to get a single course feedback for a course
    // http://localhost:9092/api/coursefeedback/course/1
    @GetMapping(path = "/coursefeedback/course/{courseId}")
    public Optional<CourseFeedBack> getCourseFeedBack(@PathVariable(value = "courseId") Long courseId) {
        LOGGER.info("calling getCourseFeedBack method from controller");
        return courseFeedBackService.getCourseFeedBack(courseId);
    }

    //to create a course feedback for a course
    // http://localhost:9092/api/coursefeedback/course/2/
    @PostMapping(path = "/coursefeedback/course/{courseId}")
    public CourseFeedBack createCourseFeedBack(@PathVariable(value = "courseId") Long courseId,
                                               @RequestBody CourseFeedBack courseFeedBackObject) {
        LOGGER.info("calling createCourseFeedBack method from controller");
        return courseFeedBackService.createCourseFeedBack(courseId, courseFeedBackObject);
    }

    //to update a course feedback for a course
    // http://localhost:9092/api/coursefeedback/course/1
    @PutMapping(path = "/coursefeedback/course/{courseId}")
    public CourseFeedBack updateCourseFeedBack(@PathVariable(value = "courseId") Long courseId,
                                               @RequestBody CourseFeedBack courseFeedBackObject) {
        LOGGER.info("calling updateCourseFeedBack method from controller");
        return courseFeedBackService.updateCourseFeedBack(courseId, courseFeedBackObject);
    }

    //to delete a course feedback for a course
    // http://localhost:9092/api/coursefeedback/1/course/1
    @DeleteMapping(path = "/coursefeedback/course/{courseId}")
    public Optional<CourseFeedBack> deleteCourseFeedBack(@PathVariable(value = "courseId") Long courseId) {
        LOGGER.info("calling deleteCourseFeedBack method from controller");
        return courseFeedBackService.deleteCourseFeedBack(courseId);
    }

    //to get all the course feedbacks
    // http://localhost:9092/api/coursefeedbacks/
    @GetMapping(path = "/coursefeedbacks")
    public List<CourseFeedbackResponse> getCourseFeedBacks() {
        LOGGER.info("calling getCourseFeedBacks method from controller");
        return courseFeedBackService.getCourseFeedBacks();
    }

    // to get all course feedbacks for a course by an instructor
    // http://localhost:9092/api/coursefeedbacks/course/5
    @GetMapping(path = "/coursefeedbacks/course/{courseId}")
    public List<CourseFeedbackResponse> getCourseFeedBacksByCourse(@PathVariable(value = "courseId") Long courseId) {
        LOGGER.info("calling getCourseFeedBacksByCourse method from service");
        return courseFeedBackService.getCourseFeedBacksByCourse(courseId);
    }
}
