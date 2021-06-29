package com.test.annotationcontext;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

/**
 * @create 2020-08-24
 */
@Controller
@Import(TestClass.class)
public class TestController {
}
