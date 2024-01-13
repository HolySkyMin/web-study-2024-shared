package hello.servlet.web.front_controller.v4;

import java.util.Map;

public class MemberFormController implements Controller {
    @Override
    public String control(Map<String, String> params, Map<String, Object> models) {
        params.put("type", "front-controller/v4");
        return "new-form";
    }
}
