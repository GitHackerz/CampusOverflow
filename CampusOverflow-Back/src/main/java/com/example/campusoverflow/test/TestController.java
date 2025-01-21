package com.example.campusoverflow.test;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping()
    public String getAllTests() {
        return "Hello, SARRA!";
    }

    @GetMapping("{sarraId}")
    public String getTestById(@PathVariable("sarraId") String id) {

        return "Hello, SARRA! Your id is: " + id;
    }

    @PostMapping()
    public String createTest(@RequestBody Test test) {
        return "Test created! " + test.getName();
    }

    @PutMapping("{sarraId}")
    public String updateTest(@PathVariable("sarraId") String id, @RequestBody Test test) {
        return "update sarra with id: " + id + " with new data: " + test.getName() + " " + test.getDescription();
    }

    @DeleteMapping("{sarraId}")
    public String deleteTest(@PathVariable("sarraId") String id) {
        return "delete sarra with id: " + id;
    }

}

