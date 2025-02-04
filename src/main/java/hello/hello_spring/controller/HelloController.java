package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","hello!!");
        //hello라는 애한테 가서 렌더링해라. 그러면 view resolver가 찾아서 처리해줌
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name",name);
        //hello라는 애한테 가서 렌더링해라. 그러면 view resolver가 찾아서 처리해줌
        return "hello-template";
    }
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam(value = "name") String name) {
        return "hello" + name; // 데이터를 그대로 보냄 html이 아님
    }
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloAPi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
